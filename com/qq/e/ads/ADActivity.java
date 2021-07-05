package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes7.dex */
public class ADActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ACTD f40655a;

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
            ACTD actd = this.f40655a;
            if (actd != null) {
                actd.onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (actd = this.f40655a) == null) {
            return;
        }
        actd.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            ACTD actd = this.f40655a;
            if (actd != null) {
                actd.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            String str2 = null;
            try {
                POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                if (pOFactory != null) {
                    Intent intent = getIntent();
                    intent.setExtrasClassLoader(pOFactory.getClass().getClassLoader());
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        str2 = extras.getString(ACTD.DELEGATE_NAME_KEY);
                        String string = extras.getString("appid");
                        if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(string)) {
                            if (GDTADManager.getInstance().initWith(getApplicationContext(), string)) {
                                ACTD activityDelegate = pOFactory.getActivityDelegate(str2, this);
                                this.f40655a = activityDelegate;
                                if (activityDelegate == null) {
                                    str = "Init ADActivity Delegate return null,delegateName" + str2;
                                }
                            } else {
                                str = "Init GDTADManager fail in AdActivity";
                            }
                            GDTLogger.e(str);
                        }
                    }
                }
            } catch (Throwable th) {
                GDTLogger.e("Init ADActivity Delegate Faile,DelegateName:" + str2, th);
            }
            ACTD actd = this.f40655a;
            if (actd != null) {
                actd.onBeforeCreate(bundle);
            } else {
                try {
                    finish();
                } catch (Exception e2) {
                    GDTLogger.report("finish ADActivity err", e2);
                }
            }
            try {
                super.onCreate(bundle);
            } catch (Exception e3) {
                GDTLogger.report("onCreate ADActivity err", e3);
            }
            ACTD actd2 = this.f40655a;
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
            ACTD actd = this.f40655a;
            if (actd != null) {
                actd.onDestroy();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ACTD actd = this.f40655a;
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
            ACTD actd = this.f40655a;
            if (actd != null) {
                actd.onResume();
            }
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ACTD actd = this.f40655a;
            if (actd != null) {
                actd.onStop();
            }
            super.onStop();
        }
    }
}
