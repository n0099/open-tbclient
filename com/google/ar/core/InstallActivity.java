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
import com.google.protobuf.CodedInputStream;
import d.g.b.a.h;
import d.g.b.a.i;
import d.g.b.a.k;
import d.g.b.a.m;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(24)
/* loaded from: classes6.dex */
public class InstallActivity extends Activity {
    public static final int BOX_SIZE_DP = 280;
    public static final int INSTALLING_TEXT_BOTTOM_MARGIN_DP = 30;
    public static final String INSTALL_BEHAVIOR_KEY = "behavior";
    public static final String MESSAGE_TYPE_KEY = "message";
    public static final String TAG = "ARCore-InstallActivity";
    public boolean finished;
    public ArCoreApk.InstallBehavior installBehavior;
    public boolean installStarted;
    public ArCoreApk.UserMessageType messageType;
    public boolean waitingForCompletion;
    public final ContextThemeWrapper themeWrapper = new ContextThemeWrapper(this, 16974394);
    public p lastEvent = p.CANCELLED;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [d.g.b.a.m.a(com.google.ar.core.p):void, d.g.b.a.m.b(java.lang.Exception):void] */
    public static /* synthetic */ void access$000(InstallActivity installActivity, Exception exc) {
        installActivity.finishWithFailure(exc);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [d.g.b.a.m.a(com.google.ar.core.p):void, d.g.b.a.m.b(java.lang.Exception):void] */
    public static /* synthetic */ p access$402(InstallActivity installActivity, p pVar) {
        installActivity.lastEvent = pVar;
        return pVar;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [d.g.b.a.m.a(com.google.ar.core.p):void] */
    public static /* synthetic */ boolean access$500(InstallActivity installActivity) {
        return installActivity.waitingForCompletion;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [d.g.b.a.m.a(com.google.ar.core.p):void] */
    public static /* synthetic */ void access$600(InstallActivity installActivity) {
        installActivity.closeInstaller();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateToSpinner() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = (int) (displayMetrics.density * 280.0f);
        int width = getWindow().getDecorView().getWidth();
        int height = getWindow().getDecorView().getHeight();
        setContentView(new RelativeLayout(this));
        getWindow().getDecorView().setMinimumWidth(i2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new d.g.b.a.j(this, width, i2, height));
        ofFloat.addListener(new k(this));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeInstaller() {
        startActivity(new Intent(this, InstallActivity.class).setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithFailure(Exception exc) {
        d.g.b.a.f.d().f66144a = exc;
        d.g.b.a.f.d().g();
        this.finished = true;
        super.finish();
    }

    private boolean isOptional() {
        return this.installBehavior == ArCoreApk.InstallBehavior.OPTIONAL;
    }

    private void showEducationDialog() {
        setContentView(R.layout.__arcore_education);
        findViewById(R.id.__arcore_cancelButton).setOnClickListener(new h(this));
        if (!isOptional()) {
            findViewById(R.id.__arcore_cancelButton).setVisibility(8);
        }
        findViewById(R.id.__arcore_continueButton).setOnClickListener(new i(this));
        TextView textView = (TextView) findViewById(R.id.__arcore_messageText);
        if (this.messageType.ordinal() != 1) {
            textView.setText(R.string.__arcore_install_app);
        } else {
            textView.setText(R.string.__arcore_install_feature);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSpinner() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = (int) (displayMetrics.density * 280.0f);
        getWindow().setLayout(i2, i2);
        RelativeLayout relativeLayout = new RelativeLayout(this.themeWrapper);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        ProgressBar progressBar = new ProgressBar(this.themeWrapper);
        progressBar.setIndeterminate(true);
        progressBar.setLayoutParams(layoutParams);
        relativeLayout.addView(progressBar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        layoutParams2.bottomMargin = (int) (displayMetrics.density * 30.0f);
        TextView textView = new TextView(this.themeWrapper);
        textView.setText(R.string.__arcore_installing);
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        setContentView(relativeLayout);
        getWindow().setLayout(i2, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInstaller() {
        this.installStarted = true;
        this.lastEvent = p.CANCELLED;
        d.g.b.a.f.d().e(this).c(this, new m(this));
    }

    @Override // android.app.Activity
    public void finish() {
        finishWithFailure(new UnavailableUserDeclinedInstallationException());
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        StringBuilder sb = new StringBuilder(27);
        sb.append("activityResult: ");
        sb.append(i3);
        Log.i(TAG, sb.toString());
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (bundle != null) {
                finishWithFailure(new FatalException("Install activity was suspended and recreated."));
                return;
            }
            this.messageType = (ArCoreApk.UserMessageType) getIntent().getSerializableExtra("message");
            ArCoreApk.InstallBehavior installBehavior = (ArCoreApk.InstallBehavior) getIntent().getSerializableExtra(INSTALL_BEHAVIOR_KEY);
            this.installBehavior = installBehavior;
            if (this.messageType != null && installBehavior != null) {
                setTheme(16974394);
                getWindow().requestFeature(1);
                setFinishOnTouchOutside(isOptional());
                if (this.messageType == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                    showSpinner();
                    return;
                }
                AtomicReference atomicReference = new AtomicReference(ArCoreApk.Availability.UNKNOWN_CHECKING);
                d.g.b.a.f.d().e(this).e(this, new d.g.b.a.d(atomicReference));
                int ordinal = ((ArCoreApk.Availability) atomicReference.get()).ordinal();
                if (ordinal == 0) {
                    Log.w(TAG, "Preliminary compatibility check failed.");
                } else if (ordinal == 3) {
                    finishWithFailure(new UnavailableDeviceNotCompatibleException());
                    return;
                }
                showEducationDialog();
                return;
            }
            Log.e(TAG, "missing intent data.");
            finishWithFailure(new FatalException("Install activity launched without config data."));
        } catch (RuntimeException e2) {
            finishWithFailure(new FatalException("Exception starting install flow", e2));
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (!this.finished) {
            d.g.b.a.f.d().g();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.installStarted) {
            if (this.messageType == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                startInstaller();
            }
        } else if (this.finished) {
        } else {
            synchronized (this) {
                if (this.lastEvent == p.CANCELLED) {
                    finish();
                } else if (this.lastEvent == p.ACCEPTED) {
                    this.waitingForCompletion = true;
                } else {
                    finishWithFailure(d.g.b.a.f.d().f66144a);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("didResume", true);
    }
}
