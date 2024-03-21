import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String operand1 = "";
    private String operator = "";
    private String operand2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onNumberClick(View view) {
        String number = ((TextView) view).getText().toString();
        resultTextView.append(number);
        if (operator.isEmpty()) {
            operand1 += number;
        } else {
            operand2 += number;
        }
    }

    public void onOperationClick(View view) {
        operator = ((TextView) view).getText().toString();
        resultTextView.append(operator);
    }

    public void onClearClick(View view) {
        operand1 = "";
        operator = "";
        operand2 = "";
        resultTextView.setText("");
    }

    public void onEqualClick(View view) {
        double result = 0;
        if (!operand1.isEmpty() && !operand2.isEmpty()) {
            double num1 = Double.parseDouble(operand1);
            double num2 = Double.parseDouble(operand2);
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultTextView.setText("Error: Division by zero");
                        return;
                    }
                    break;
            }
            resultTextView.setText(String.valueOf(result));
            operand1 = String.valueOf(result);
            operator = "";
            operand2 = "";
        }
    }
}
