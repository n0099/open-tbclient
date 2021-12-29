package com.vivo.push.util;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class ContextDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ContextDelegate";
    public static Context mContext;
    public static Method mCreateCredentialProtectedStorageContext;
    public static Method mCreateDeviceProtectedStorageContext;
    public static boolean mDelegateEnable;
    public static Boolean mIsFbeProject;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static ContextDelegate a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(136215115, "Lcom/vivo/push/util/ContextDelegate$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(136215115, "Lcom/vivo/push/util/ContextDelegate$a;");
                    return;
                }
            }
            a = new ContextDelegate();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1591201448, "Lcom/vivo/push/util/ContextDelegate;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1591201448, "Lcom/vivo/push/util/ContextDelegate;");
        }
    }

    public ContextDelegate() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Context createCredentialProtectedStorageContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (mCreateCredentialProtectedStorageContext == null) {
                    mCreateCredentialProtectedStorageContext = Context.class.getMethod("createCredentialProtectedStorageContext", new Class[0]);
                }
                return (Context) mCreateCredentialProtectedStorageContext.invoke(context, new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
                return context;
            }
        }
        return (Context) invokeL.objValue;
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (mCreateDeviceProtectedStorageContext == null) {
                    mCreateDeviceProtectedStorageContext = Context.class.getMethod("createDeviceProtectedStorageContext", new Class[0]);
                }
                return (Context) mCreateDeviceProtectedStorageContext.invoke(context, new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
                return context;
            }
        }
        return (Context) invokeL.objValue;
    }

    public static Context getContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (!isFBEProject() || context == null) {
                return context;
            }
            Context context2 = mContext;
            if (context2 != null) {
                return context2;
            }
            setContext(context);
            return mContext;
        }
        return (Context) invokeL.objValue;
    }

    public static ContextDelegate getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a.a : (ContextDelegate) invokeV.objValue;
    }

    public static boolean isFBEProject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (mIsFbeProject == null) {
                try {
                    mIsFbeProject = Boolean.valueOf("file".equals(j.a("ro.crypto.type", "unknow")));
                    p.b(TAG, "mIsFbeProject = " + mIsFbeProject.toString());
                } catch (Exception e2) {
                    p.a(TAG, "mIsFbeProject = " + e2.getMessage());
                }
            }
            Boolean bool = mIsFbeProject;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static void setAppContext() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || (context = mContext) == null) {
            return;
        }
        setContext(context);
    }

    public static void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            if (!mDelegateEnable) {
                mContext = createCredentialProtectedStorageContext(context);
            } else {
                mContext = createDeviceProtectedStorageContext(context);
            }
        }
    }

    public static void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            mDelegateEnable = z;
            setAppContext();
        }
    }
}
