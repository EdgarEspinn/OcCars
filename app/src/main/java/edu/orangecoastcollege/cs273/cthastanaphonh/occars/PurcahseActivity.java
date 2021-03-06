package edu.orangecoastcollege.cs273.cthastanaphonh.occars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class PurcahseActivity extends AppCompatActivity {

    // Connections to the view
    private EditText mPriceEditText;
    private EditText mDownPaymentEditText;
    private RadioButton mThreeYearRadioButton;
    private RadioButton mFourYearRadioButton;
    private RadioButton mFiveYearRadioButton;

    // Connections to the Model
    private CarLoan mCarLoan = new CarLoan();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purcahse);

        // Use findViewById to connect controller to each view
        mPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        mDownPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        mThreeYearRadioButton = (RadioButton) findViewById(R.id.threeYearRadioButton);
        mFourYearRadioButton = (RadioButton) findViewById(R.id.fourYearRadioButton);
        mFiveYearRadioButton = (RadioButton) findViewById(R.id.fiveYearRadioButton);
    }

    private void collectCarLoanData()
    {
        mCarLoan.setPrice(Double.parseDouble(mPriceEditText.getText().toString()));
        mCarLoan.setDownPayment(Double.parseDouble(mDownPaymentEditText.getText().toString()));

        if (mThreeYearRadioButton.isChecked())
            mCarLoan.setTerm(3);
        else if(mFourYearRadioButton.isChecked())
            mCarLoan.setTerm(4);
        else
            mCarLoan.setTerm(5);

    }

    protected void reportSummary(View v)
    {
        collectCarLoanData();
        String report = "Monthly Payment: $" + mCarLoan.monthlyPayment();
        // Keep going, more report


        // Intents start new activities and can share data with them
        Intent launchLoanSummary = new Intent(this, LoanSummaryActivity.class);
        // Put data into the Intent for Loan Summary receive
        launchLoanSummary.putExtra("loanReport", report);
        // Start the second activity
        startActivity(launchLoanSummary);

    }

}
