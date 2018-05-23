package project.dajver.com.viewmodelexample;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textA)
    TextView textA;
    @BindView(R.id.textB)
    TextView textB;

    private ScoreViewModel mViewModel;
    private int counterA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
        displayForTeamA(counterA);
        displayForTeamB(mViewModel.scoreTeamB);
    }

    @OnClick(R.id.buttonA)
    public void onButtonAClick() {
        displayForTeamA(counterA++);
    }

    @OnClick(R.id.buttonB)
    public void onButtonBClick() {
        mViewModel.scoreTeamB = mViewModel.scoreTeamB + 1;
        displayForTeamB(mViewModel.scoreTeamB);
    }

    public void displayForTeamA(int v) {
        textA.setText(String.valueOf(v));
    }

    public void displayForTeamB(int v) {
        textB.setText(String.valueOf(v));
    }
}
