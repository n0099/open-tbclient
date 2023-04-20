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
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.tieba.ata;
import com.baidu.tieba.rsa;
import com.baidu.tieba.tsa;
import com.baidu.tieba.vsa;
import com.baidu.tieba.wsa;
import com.baidu.tieba.xsa;
import com.baidu.tieba.ysa;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import com.google.protobuf.CodedInputStream;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(24)
/* loaded from: classes8.dex */
public class InstallActivity extends Activity {
    public ArCoreApk.UserMessageType b;
    public ArCoreApk.InstallBehavior c;
    public boolean e;
    public boolean f;
    public boolean g;
    public final ContextThemeWrapper a = new ContextThemeWrapper(this, 16974394);
    public p d = p.CANCELLED;

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
    }

    @Override // android.app.Activity
    public void finish() {
        j(new UnavailableUserDeclinedInstallationException());
    }

    public final void i() {
        startActivity(new Intent(this, InstallActivity.class).setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT));
    }

    public final boolean k() {
        if (this.c == ArCoreApk.InstallBehavior.OPTIONAL) {
            return true;
        }
        return false;
    }

    public final void n() {
        this.f = true;
        this.d = p.CANCELLED;
        tsa.d().e(this).c(this, new ata(this));
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (!this.e) {
            tsa.d().g();
        }
        super.onDestroy();
    }

    public final void j(Exception exc) {
        tsa.d().a = exc;
        tsa.d().g();
        this.e = true;
        super.finish();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("didResume", true);
    }

    public final void h() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = (int) (displayMetrics.density * 280.0f);
        int width = getWindow().getDecorView().getWidth();
        int height = getWindow().getDecorView().getHeight();
        setContentView(new RelativeLayout(this));
        getWindow().getDecorView().setMinimumWidth(i);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new xsa(this, width, i, height));
        ofFloat.addListener(new ysa(this));
        ofFloat.start();
    }

    public final void m() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = (int) (displayMetrics.density * 280.0f);
        getWindow().setLayout(i, i);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        ProgressBar progressBar = new ProgressBar(this.a);
        progressBar.setIndeterminate(true);
        progressBar.setLayoutParams(layoutParams);
        relativeLayout.addView(progressBar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        layoutParams2.bottomMargin = (int) (displayMetrics.density * 30.0f);
        TextView textView = new TextView(this.a);
        textView.setText(R.string.__arcore_installing);
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        setContentView(relativeLayout);
        getWindow().setLayout(i, i);
    }

    public final void l() {
        setContentView(R.layout.__arcore_education);
        findViewById(R.id.__arcore_cancelButton).setOnClickListener(new vsa(this));
        if (!k()) {
            findViewById(R.id.__arcore_cancelButton).setVisibility(8);
        }
        findViewById(R.id.__arcore_continueButton).setOnClickListener(new wsa(this));
        TextView textView = (TextView) findViewById(R.id.__arcore_messageText);
        if (this.b.ordinal() != 1) {
            textView.setText(R.string.__arcore_install_app);
        } else {
            textView.setText(R.string.__arcore_install_feature);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder(27);
        sb.append("activityResult: ");
        sb.append(i2);
        Log.i("ARCore-InstallActivity", sb.toString());
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (bundle != null) {
                j(new FatalException("Install activity was suspended and recreated."));
                return;
            }
            this.b = (ArCoreApk.UserMessageType) getIntent().getSerializableExtra("message");
            ArCoreApk.InstallBehavior installBehavior = (ArCoreApk.InstallBehavior) getIntent().getSerializableExtra(TaskInfo.keyBehavior);
            this.c = installBehavior;
            if (this.b != null && installBehavior != null) {
                setTheme(16974394);
                getWindow().requestFeature(1);
                setFinishOnTouchOutside(k());
                if (this.b == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                    m();
                    return;
                }
                AtomicReference atomicReference = new AtomicReference(ArCoreApk.Availability.UNKNOWN_CHECKING);
                tsa.d().e(this).e(this, new rsa(atomicReference));
                int ordinal = ((ArCoreApk.Availability) atomicReference.get()).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 3) {
                        j(new UnavailableDeviceNotCompatibleException());
                        return;
                    }
                } else {
                    Log.w("ARCore-InstallActivity", "Preliminary compatibility check failed.");
                }
                l();
                return;
            }
            Log.e("ARCore-InstallActivity", "missing intent data.");
            j(new FatalException("Install activity launched without config data."));
        } catch (RuntimeException e) {
            j(new FatalException("Exception starting install flow", e));
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.f) {
            if (this.b == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                n();
            }
        } else if (!this.e) {
            synchronized (this) {
                if (this.d == p.CANCELLED) {
                    finish();
                } else if (this.d == p.ACCEPTED) {
                    this.g = true;
                } else {
                    j(tsa.d().a);
                }
            }
        }
    }
}
