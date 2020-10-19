package com.google.ar.core;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(24)
/* loaded from: classes11.dex */
public class InstallActivity extends Activity {
    private boolean finished;
    private ArCoreApk.UserMessageType obG;
    private ArCoreApk.InstallBehavior obH;
    private boolean obJ;
    private boolean obK;
    private final ContextThemeWrapper obF = new ContextThemeWrapper(this, 16974394);
    private p obI = p.CANCELLED;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (bundle != null) {
                E(new FatalException("Install activity was suspended and recreated."));
                return;
            }
            this.obG = (ArCoreApk.UserMessageType) getIntent().getSerializableExtra("message");
            this.obH = (ArCoreApk.InstallBehavior) getIntent().getSerializableExtra("behavior");
            if (this.obG == null || this.obH == null) {
                Log.e("ARCore-InstallActivity", "missing intent data.");
                E(new FatalException("Install activity launched without config data."));
                return;
            }
            setTheme(16974394);
            getWindow().requestFeature(1);
            setFinishOnTouchOutside(eeI());
            if (this.obG == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                eeG();
                return;
            }
            AtomicReference atomicReference = new AtomicReference(ArCoreApk.Availability.UNKNOWN_CHECKING);
            o.eeL().gN(this).a(this, new m(atomicReference));
            switch (((ArCoreApk.Availability) atomicReference.get()).ordinal()) {
                case 0:
                    Log.w("ARCore-InstallActivity", "Preliminary compatibility check failed.");
                    break;
                case 3:
                    E(new UnavailableDeviceNotCompatibleException());
                    return;
            }
            eeF();
        } catch (RuntimeException e) {
            E(new FatalException("Exception starting install flow", e));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("didResume", true);
    }

    private void eeF() {
        setContentView(R.layout.__arcore_education);
        findViewById(R.id.__arcore_cancelButton).setOnClickListener(new r(this));
        if (!eeI()) {
            findViewById(R.id.__arcore_cancelButton).setVisibility(8);
        }
        findViewById(R.id.__arcore_continueButton).setOnClickListener(new s(this));
        TextView textView = (TextView) findViewById(R.id.__arcore_messageText);
        switch (this.obG.ordinal()) {
            case 1:
                textView.setText(R.string.__arcore_install_feature);
                return;
            default:
                textView.setText(R.string.__arcore_install_app);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeG() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = (int) (280.0f * displayMetrics.density);
        getWindow().setLayout(i, i);
        RelativeLayout relativeLayout = new RelativeLayout(this.obF);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        ProgressBar progressBar = new ProgressBar(this.obF);
        progressBar.setIndeterminate(true);
        progressBar.setLayoutParams(layoutParams);
        relativeLayout.addView(progressBar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        layoutParams2.bottomMargin = (int) (displayMetrics.density * 30.0f);
        TextView textView = new TextView(this.obF);
        textView.setText(R.string.__arcore_installing);
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        setContentView(relativeLayout);
        getWindow().setLayout(i, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeH() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = (int) (displayMetrics.density * 280.0f);
        int width = getWindow().getDecorView().getWidth();
        int height = getWindow().getDecorView().getHeight();
        setContentView(new RelativeLayout(this));
        getWindow().getDecorView().setMinimumWidth(i);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new t(this, width, i, height));
        ofFloat.addListener(new v(this));
        ofFloat.start();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.obJ) {
            if (this.obG == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                eeJ();
            }
        } else if (!this.finished) {
            synchronized (this) {
                if (this.obI == p.CANCELLED) {
                    finish();
                } else if (this.obI == p.ACCEPTED) {
                    this.obK = true;
                } else {
                    E(o.eeL().f4043a);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        E(new UnavailableUserDeclinedInstallationException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Exception exc) {
        o.eeL().f4043a = exc;
        o.eeL().b();
        this.finished = true;
        super.finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (!this.finished) {
            o.eeL().b();
        }
        super.onDestroy();
    }

    private boolean eeI() {
        return this.obH == ArCoreApk.InstallBehavior.OPTIONAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeJ() {
        this.obJ = true;
        this.obI = p.CANCELLED;
        o.eeL().gN(this).a(this, new y(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeK() {
        startActivity(new Intent(this, InstallActivity.class).setFlags(67108864));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Log.i("ARCore-InstallActivity", new StringBuilder(27).append("activityResult: ").append(i2).toString());
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.google.ar.core.y.a(com.google.ar.core.p):void, com.google.ar.core.y.a(java.lang.Exception):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(InstallActivity installActivity, Exception exc) {
        installActivity.E(exc);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.google.ar.core.y.a(com.google.ar.core.p):void, com.google.ar.core.y.a(java.lang.Exception):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ p a(InstallActivity installActivity, p pVar) {
        installActivity.obI = pVar;
        return pVar;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.google.ar.core.y.a(com.google.ar.core.p):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean d(InstallActivity installActivity) {
        return installActivity.obK;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.google.ar.core.y.a(com.google.ar.core.p):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(InstallActivity installActivity) {
        installActivity.eeK();
    }
}
