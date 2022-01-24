package com.sina.weibo.sdk.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.LogUtil;
/* loaded from: classes4.dex */
public class NetStateManager {
    public static /* synthetic */ Interceptable $ic;
    public static NetState CUR_NETSTATE;
    public static Context mContext;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class NetState {
        public static final /* synthetic */ NetState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetState Mobile;
        public static final NetState NOWAY;
        public static final NetState WIFI;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-540219678, "Lcom/sina/weibo/sdk/net/NetStateManager$NetState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-540219678, "Lcom/sina/weibo/sdk/net/NetStateManager$NetState;");
                    return;
                }
            }
            Mobile = new NetState("Mobile", 0);
            WIFI = new NetState(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
            NetState netState = new NetState("NOWAY", 2);
            NOWAY = netState;
            $VALUES = new NetState[]{Mobile, WIFI, netState};
        }

        public NetState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static NetState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetState) Enum.valueOf(NetState.class, str) : (NetState) invokeL.objValue;
        }

        public static NetState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetState[]) $VALUES.clone() : (NetState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class NetStateReceive extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetStateManager this$0;

        public NetStateReceive(NetStateManager netStateManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netStateManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = netStateManager;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                Context unused = NetStateManager.mContext = context;
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (!wifiManager.isWifiEnabled() || -1 == connectionInfo.getNetworkId()) {
                        NetStateManager.CUR_NETSTATE = NetState.Mobile;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-190753668, "Lcom/sina/weibo/sdk/net/NetStateManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-190753668, "Lcom/sina/weibo/sdk/net/NetStateManager;");
                return;
            }
        }
        CUR_NETSTATE = NetState.Mobile;
    }

    public NetStateManager() {
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

    public static Pair<String, Integer> getAPN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Uri parse = Uri.parse("content://telephony/carriers/preferapn");
            Context context = mContext;
            Pair<String, Integer> pair = null;
            Cursor query = context != null ? context.getContentResolver().query(parse, null, null, null, null) : null;
            if (query != null && query.moveToFirst()) {
                String string = query.getString(query.getColumnIndex("proxy"));
                if (string != null && string.trim().length() > 0) {
                    pair = new Pair<>(string, 80);
                }
                query.close();
            }
            return pair;
        }
        return (Pair) invokeV.objValue;
    }

    public static boolean isNetworkConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null) {
                LogUtil.e("Weibosdk", "unexpected null context in isNetworkConnected");
                return false;
            } else if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return false;
            } else {
                NetworkInfo networkInfo = null;
                try {
                    networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (NullPointerException unused) {
                }
                return networkInfo != null && networkInfo.isAvailable();
            }
        }
        return invokeL.booleanValue;
    }
}
