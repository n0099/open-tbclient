package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.p;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class ClientConfigManagerImpl implements e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object SLOCK;
    public static final String TAG = "ClientConfigManager";
    public static volatile ClientConfigManagerImpl sClientConfigManagerImpl;
    public transient /* synthetic */ FieldHolder $fh;
    public a mAppConfigSettings;
    public Context mContext;
    public f mPushConfigSettings;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(542586068, "Lcom/vivo/push/cache/ClientConfigManagerImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(542586068, "Lcom/vivo/push/cache/ClientConfigManagerImpl;");
                return;
            }
        }
        SLOCK = new Object();
    }

    public ClientConfigManagerImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
        this.mAppConfigSettings = new a(this.mContext);
        this.mPushConfigSettings = new f(this.mContext);
    }

    public static ClientConfigManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (sClientConfigManagerImpl == null) {
                synchronized (SLOCK) {
                    if (sClientConfigManagerImpl == null) {
                        sClientConfigManagerImpl = new ClientConfigManagerImpl(context);
                    }
                }
            }
            return sClientConfigManagerImpl;
        }
        return (ClientConfigManagerImpl) invokeL.objValue;
    }

    private void prepareAppConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            a aVar = this.mAppConfigSettings;
            if (aVar == null) {
                this.mAppConfigSettings = new a(this.mContext);
            } else {
                aVar.c();
            }
        }
    }

    private f preparePushConfigSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            f fVar = this.mPushConfigSettings;
            if (fVar == null) {
                this.mPushConfigSettings = new f(this.mContext);
            } else {
                fVar.c();
            }
            return this.mPushConfigSettings;
        }
        return (f) invokeV.objValue;
    }

    public void clearPush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mAppConfigSettings.d();
        }
    }

    public Set<String> getBlackEventList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (Set) invokeV.objValue;
    }

    public int getNotifyStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                String c2 = preparePushConfigSettings().c("DPL");
                if (!TextUtils.isEmpty(c2)) {
                    try {
                        return Integer.parseInt(c2);
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (NumberFormatException e3) {
                e3.printStackTrace();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String getSuitTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? preparePushConfigSettings().c("CSPT") : (String) invokeV.objValue;
    }

    public String getValueByKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.mPushConfigSettings.c();
            return this.mPushConfigSettings.c(str);
        }
        return (String) invokeL.objValue;
    }

    public Set<Long> getWhiteLogList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HashSet hashSet = new HashSet();
            String valueByKey = getValueByKey("WLL");
            if (!TextUtils.isEmpty(valueByKey)) {
                for (String str : valueByKey.split(",")) {
                    try {
                        hashSet.add(Long.valueOf(Long.parseLong(str)));
                    } catch (Exception unused) {
                    }
                }
            }
            p.d(TAG, " initWhiteLogList " + hashSet);
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0025 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isCancleBroadcastReceiver() {
        InterceptResult invokeV;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return invokeV.booleanValue;
        }
        String c2 = preparePushConfigSettings().c("PSM");
        if (!TextUtils.isEmpty(c2)) {
            try {
                parseInt = Integer.parseInt(c2);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return (parseInt & 4) == 0;
        }
        parseInt = 0;
        if ((parseInt & 4) == 0) {
        }
    }

    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.mAppConfigSettings.c();
            return a.a(this.mAppConfigSettings.b());
        }
        return invokeV.booleanValue;
    }

    public boolean isEnablePush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            prepareAppConfig();
            com.vivo.push.model.a c2 = this.mAppConfigSettings.c(this.mContext.getPackageName());
            if (c2 != null) {
                return "1".equals(c2.b());
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.vivo.push.cache.e
    public boolean isInBlackList(long j2) {
        InterceptResult invokeJ;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
            String c2 = preparePushConfigSettings().c("BL");
            if (!TextUtils.isEmpty(c2)) {
                for (String str : c2.split(",")) {
                    try {
                        if (!TextUtils.isEmpty(str) && Long.parseLong(str) == j2) {
                            return true;
                        }
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public boolean isDebug(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? a.a(i2) : invokeI.booleanValue;
    }
}
