package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.b;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes10.dex */
public class ADActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NOTCH_CONTAINER_TAG = "NOTCH_CONTAINER";
    public transient /* synthetic */ FieldHolder $fh;
    public ACTD a;
    public FrameLayout b;

    public ADActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            super.setContentView(linearLayout);
            FrameLayout frameLayout = new FrameLayout(this);
            frameLayout.setTag(NOTCH_CONTAINER_TAG);
            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(frameLayout);
            this.b = new FrameLayout(this);
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.addView(this.b);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            ACTD actd = this.a;
            if (actd != null) {
                actd.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (actd = this.a) == null) {
            return;
        }
        actd.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            ACTD actd = this.a;
            if (actd != null) {
                actd.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            ACTD actd = this.a;
            if (actd != null) {
                actd.onDestroy();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ACTD actd = this.a;
            if (actd != null) {
                actd.onPause();
            }
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            ACTD actd = this.a;
            if (actd != null) {
                actd.onResume();
            }
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ACTD actd = this.a;
            if (actd != null) {
                actd.onStop();
            }
            super.onStop();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            a();
            LayoutInflater.from(this).inflate(i, (ViewGroup) this.b, true);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            a();
            this.b.addView(view2);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view2, layoutParams) == null) {
            a();
            this.b.addView(view2, layoutParams);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            String str = null;
            try {
                POFactory pOFactory = b.b().c().getPOFactory();
                if (pOFactory != null) {
                    Intent intent = getIntent();
                    intent.setExtrasClassLoader(pOFactory.getClass().getClassLoader());
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        str = extras.getString(ACTD.DELEGATE_NAME_KEY);
                        String string = extras.getString("appid");
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string) && b.b().d()) {
                            ACTD activityDelegate = pOFactory.getActivityDelegate(str, this);
                            this.a = activityDelegate;
                            if (activityDelegate == null) {
                                GDTLogger.e("创建 ADActivity Delegate " + str + " 失败");
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                GDTLogger.e("创建ADActivity Delegate" + str + "发生异常", th);
            }
            ACTD actd = this.a;
            if (actd != null) {
                actd.onBeforeCreate(bundle);
            } else {
                try {
                    finish();
                } catch (Throwable th2) {
                    GDTLogger.e("ADActivity onCreate 发生异常", th2);
                }
            }
            try {
                super.onCreate(bundle);
            } catch (Throwable th3) {
                a.a(th3, "ADActivity onCreate 发生异常");
                GDTLogger.e("ADActivity onCreate 发生异常", th3);
            }
            ACTD actd2 = this.a;
            if (actd2 != null) {
                actd2.onAfterCreate(bundle);
            }
        }
    }
}
