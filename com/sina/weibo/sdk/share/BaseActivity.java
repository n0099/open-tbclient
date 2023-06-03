package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.LogUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public class BaseActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BaseActivity";
    public transient /* synthetic */ FieldHolder $fh;

    public BaseActivity() {
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

    private boolean fixOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
                declaredField.setAccessible(false);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean isTranslucentOrFloating() {
        InterceptResult invokeV;
        Exception e;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
                Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
                method.setAccessible(true);
                z = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
                try {
                    method.setAccessible(false);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return z;
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating()) {
                boolean fixOrientation = fixOrientation();
                LogUtil.i("BaseActivity", "onCreate fixOrientation when Oreo, result = " + fixOrientation);
            }
            super.onCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating()) {
                LogUtil.i("BaseActivity", "avoid calling setRequestedOrientation when Oreo.");
            } else {
                super.setRequestedOrientation(i);
            }
        }
    }
}
