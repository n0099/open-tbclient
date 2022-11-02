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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.tieba.pt9;
import com.baidu.tieba.rt9;
import com.baidu.tieba.tt9;
import com.baidu.tieba.ut9;
import com.baidu.tieba.vt9;
import com.baidu.tieba.wt9;
import com.baidu.tieba.yt9;
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
/* loaded from: classes7.dex */
public class InstallActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ContextThemeWrapper a;
    public ArCoreApk.UserMessageType b;
    public ArCoreApk.InstallBehavior c;
    public p d;
    public boolean e;
    public boolean f;
    public boolean g;

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
        }
    }

    public InstallActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ContextThemeWrapper(this, 16974394);
        this.d = p.b;
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j(new UnavailableUserDeclinedInstallationException());
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            startActivity(new Intent(this, InstallActivity.class).setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT));
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c == ArCoreApk.InstallBehavior.OPTIONAL) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f = true;
            this.d = p.b;
            rt9.d().e(this).c(this, new yt9(this));
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!this.e) {
                rt9.d().g();
            }
            super.onDestroy();
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.yt9.a(com.google.ar.core.p):void, com.baidu.tieba.yt9.b(java.lang.Exception):void] */
    public static /* synthetic */ void a(InstallActivity installActivity, Exception exc) {
        installActivity.j(exc);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.yt9.a(com.google.ar.core.p):void, com.baidu.tieba.yt9.b(java.lang.Exception):void] */
    public static /* synthetic */ p e(InstallActivity installActivity, p pVar) {
        installActivity.d = pVar;
        return pVar;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.yt9.a(com.google.ar.core.p):void] */
    public static /* synthetic */ boolean f(InstallActivity installActivity) {
        return installActivity.g;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.yt9.a(com.google.ar.core.p):void] */
    public static /* synthetic */ void g(InstallActivity installActivity) {
        installActivity.i();
    }

    public final void j(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
            rt9.d().a = exc;
            rt9.d().g();
            this.e = true;
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean("didResume", true);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = (int) (displayMetrics.density * 280.0f);
            int width = getWindow().getDecorView().getWidth();
            int height = getWindow().getDecorView().getHeight();
            setContentView(new RelativeLayout(this));
            getWindow().getDecorView().setMinimumWidth(i);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new vt9(this, width, i, height));
            ofFloat.addListener(new wt9(this));
            ofFloat.start();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setContentView(R.layout.__arcore_education);
            findViewById(R.id.__arcore_cancelButton).setOnClickListener(new tt9(this));
            if (!k()) {
                findViewById(R.id.__arcore_cancelButton).setVisibility(8);
            }
            findViewById(R.id.__arcore_continueButton).setOnClickListener(new ut9(this));
            TextView textView = (TextView) findViewById(R.id.__arcore_messageText);
            if (this.b.ordinal() != 1) {
                textView.setText(R.string.__arcore_install_app);
            } else {
                textView.setText(R.string.__arcore_install_feature);
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            if (!this.f) {
                if (this.b == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                    n();
                }
            } else if (!this.e) {
                synchronized (this) {
                    if (this.d == p.b) {
                        finish();
                    } else if (this.d == p.a) {
                        this.g = true;
                    } else {
                        j(rt9.d().a);
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            StringBuilder sb = new StringBuilder(27);
            sb.append("activityResult: ");
            sb.append(i2);
            Log.i("ARCore-InstallActivity", sb.toString());
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
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
                    rt9.d().e(this).e(this, new pt9(atomicReference));
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
    }
}
