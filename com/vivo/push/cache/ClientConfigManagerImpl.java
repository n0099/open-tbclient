package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.u;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class ClientConfigManagerImpl implements d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ClientConfigManager";
    public static volatile ClientConfigManagerImpl sClientConfigManagerImpl;
    public transient /* synthetic */ FieldHolder $fh;
    public a mAppConfigSettings;
    public Context mContext;
    public e mPushConfigSettings;

    public Set<String> getBlackEventList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (Set) invokeV.objValue;
    }

    public ClientConfigManagerImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = ContextDelegate.getContext(context);
        this.mAppConfigSettings = new a(this.mContext);
        this.mPushConfigSettings = new e(this.mContext);
    }

    @Override // com.vivo.push.cache.d
    public boolean isInBlackList(long j) {
        InterceptResult invokeJ;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            String c = preparePushConfigSettings().c("BL");
            if (!TextUtils.isEmpty(c)) {
                for (String str : c.split(",")) {
                    try {
                        if (!TextUtils.isEmpty(str) && Long.parseLong(str) == j) {
                            return true;
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public static synchronized ClientConfigManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        ClientConfigManagerImpl clientConfigManagerImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (ClientConfigManagerImpl.class) {
                if (sClientConfigManagerImpl == null) {
                    sClientConfigManagerImpl = new ClientConfigManagerImpl(context);
                }
                clientConfigManagerImpl = sClientConfigManagerImpl;
            }
            return clientConfigManagerImpl;
        }
        return (ClientConfigManagerImpl) invokeL.objValue;
    }

    public String getValueByKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.mPushConfigSettings.c();
            return this.mPushConfigSettings.c(str);
        }
        return (String) invokeL.objValue;
    }

    public boolean isDebug(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return a.a(i);
        }
        return invokeI.booleanValue;
    }

    private void prepareAppConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            a aVar = this.mAppConfigSettings;
            if (aVar == null) {
                this.mAppConfigSettings = new a(this.mContext);
            } else {
                aVar.c();
            }
        }
    }

    private e preparePushConfigSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            e eVar = this.mPushConfigSettings;
            if (eVar == null) {
                this.mPushConfigSettings = new e(this.mContext);
            } else {
                eVar.c();
            }
            return this.mPushConfigSettings;
        }
        return (e) invokeV.objValue;
    }

    public void clearPush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mAppConfigSettings.d();
        }
    }

    public String getSuitTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return preparePushConfigSettings().c("CSPT");
        }
        return (String) invokeV.objValue;
    }

    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.mAppConfigSettings.c();
            return a.a(this.mAppConfigSettings.b());
        }
        return invokeV.booleanValue;
    }

    public boolean isEnablePush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            prepareAppConfig();
            com.vivo.push.model.a c = this.mAppConfigSettings.c(this.mContext.getPackageName());
            if (c != null) {
                return "1".equals(c.b());
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public Set<Long> getWhiteLogList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
            u.d(TAG, " initWhiteLogList ".concat(String.valueOf(hashSet)));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String c = preparePushConfigSettings().c("PSM");
            if (!TextUtils.isEmpty(c)) {
                try {
                    parseInt = Integer.parseInt(c);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if ((parseInt & 4) != 0) {
                    return false;
                }
                return true;
            }
            parseInt = 0;
            if ((parseInt & 4) != 0) {
            }
        } else {
            return invokeV.booleanValue;
        }
    }
}
