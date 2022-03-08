package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes8.dex */
public class ADActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ACTD a;

    public ADActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            ACTD actd = this.a;
            if (actd != null) {
                actd.onActivityResult(i2, i3, intent);
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
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            String str = null;
            try {
                POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                if (pOFactory != null) {
                    Intent intent = getIntent();
                    intent.setExtrasClassLoader(pOFactory.getClass().getClassLoader());
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        str = extras.getString(ACTD.DELEGATE_NAME_KEY);
                        String string = extras.getString("appid");
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string) && GDTADManager.getInstance().isInitialized()) {
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
                } catch (Exception e2) {
                    GDTLogger.e("ADActivity onCreate 发生异常", e2);
                }
            }
            try {
                super.onCreate(bundle);
            } catch (Exception e3) {
                GDTLogger.e("ADActivity onCreate 发生异常", e3);
            }
            ACTD actd2 = this.a;
            if (actd2 != null) {
                actd2.onAfterCreate(bundle);
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
}
