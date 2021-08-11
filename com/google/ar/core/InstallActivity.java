package com.google.ar.core;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.i.c.a.h;
import c.i.c.a.i;
import c.i.c.a.k;
import c.i.c.a.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import com.google.protobuf.CodedInputStream;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(24)
/* loaded from: classes9.dex */
public class InstallActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOX_SIZE_DP = 280;
    public static final int INSTALLING_TEXT_BOTTOM_MARGIN_DP = 30;
    public static final String INSTALL_BEHAVIOR_KEY = "behavior";
    public static final String MESSAGE_TYPE_KEY = "message";
    public static final String TAG = "ARCore-InstallActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean finished;
    public ArCoreApk.InstallBehavior installBehavior;
    public boolean installStarted;
    public p lastEvent;
    public ArCoreApk.UserMessageType messageType;
    public final ContextThemeWrapper themeWrapper;
    public boolean waitingForCompletion;

    public InstallActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.themeWrapper = new ContextThemeWrapper(this, 16974394);
        this.lastEvent = p.f69884b;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [c.i.c.a.m.a(com.google.ar.core.p):void, c.i.c.a.m.b(java.lang.Exception):void] */
    public static /* synthetic */ void access$000(InstallActivity installActivity, Exception exc) {
        installActivity.finishWithFailure(exc);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [c.i.c.a.m.a(com.google.ar.core.p):void, c.i.c.a.m.b(java.lang.Exception):void] */
    public static /* synthetic */ p access$402(InstallActivity installActivity, p pVar) {
        installActivity.lastEvent = pVar;
        return pVar;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [c.i.c.a.m.a(com.google.ar.core.p):void] */
    public static /* synthetic */ boolean access$500(InstallActivity installActivity) {
        return installActivity.waitingForCompletion;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [c.i.c.a.m.a(com.google.ar.core.p):void] */
    public static /* synthetic */ void access$600(InstallActivity installActivity) {
        installActivity.closeInstaller();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateToSpinner() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = (int) (displayMetrics.density * 280.0f);
            int width = getWindow().getDecorView().getWidth();
            int height = getWindow().getDecorView().getHeight();
            setContentView(new RelativeLayout(this));
            getWindow().getDecorView().setMinimumWidth(i2);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new c.i.c.a.j(this, width, i2, height));
            ofFloat.addListener(new k(this));
            ofFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeInstaller() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            startActivity(new Intent(this, InstallActivity.class).setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithFailure(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, exc) == null) {
            c.i.c.a.f.d().f33898a = exc;
            c.i.c.a.f.d().g();
            this.finished = true;
            super.finish();
        }
    }

    private boolean isOptional() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? this.installBehavior == ArCoreApk.InstallBehavior.OPTIONAL : invokeV.booleanValue;
    }

    private void showEducationDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSpinner() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInstaller() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.installStarted = true;
            this.lastEvent = p.f69884b;
            c.i.c.a.f.d().e(this).c(this, new m(this));
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            finishWithFailure(new UnavailableUserDeclinedInstallationException());
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            StringBuilder sb = new StringBuilder(27);
            sb.append("activityResult: ");
            sb.append(i3);
            sb.toString();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
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
                    c.i.c.a.f.d().e(this).e(this, new c.i.c.a.d(atomicReference));
                    int ordinal = ((ArCoreApk.Availability) atomicReference.get()).ordinal();
                    if (ordinal != 0 && ordinal == 3) {
                        finishWithFailure(new UnavailableDeviceNotCompatibleException());
                        return;
                    }
                    showEducationDialog();
                    return;
                }
                finishWithFailure(new FatalException("Install activity launched without config data."));
            } catch (RuntimeException e2) {
                finishWithFailure(new FatalException("Exception starting install flow", e2));
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!this.finished) {
                c.i.c.a.f.d().g();
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            if (!this.installStarted) {
                if (this.messageType == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                    startInstaller();
                }
            } else if (this.finished) {
            } else {
                synchronized (this) {
                    if (this.lastEvent == p.f69884b) {
                        finish();
                    } else if (this.lastEvent == p.f69883a) {
                        this.waitingForCompletion = true;
                    } else {
                        finishWithFailure(c.i.c.a.f.d().f33898a);
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean("didResume", true);
        }
    }
}
