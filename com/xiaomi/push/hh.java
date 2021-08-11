package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class hh {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final hh f77393a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ hh[] f479a;

    /* renamed from: b  reason: collision with root package name */
    public static final hh f77394b;

    /* renamed from: c  reason: collision with root package name */
    public static final hh f77395c;

    /* renamed from: d  reason: collision with root package name */
    public static final hh f77396d;

    /* renamed from: e  reason: collision with root package name */
    public static final hh f77397e;

    /* renamed from: f  reason: collision with root package name */
    public static final hh f77398f;

    /* renamed from: g  reason: collision with root package name */
    public static final hh f77399g;

    /* renamed from: h  reason: collision with root package name */
    public static final hh f77400h;

    /* renamed from: i  reason: collision with root package name */
    public static final hh f77401i;

    /* renamed from: j  reason: collision with root package name */
    public static final hh f77402j;
    public static final hh k;
    public static final hh l;
    public static final hh m;
    public static final hh n;
    public static final hh o;
    public static final hh p;
    public static final hh q;
    public static final hh r;
    public static final hh s;
    public static final hh t;
    public static final hh u;
    public static final hh v;
    public static final hh w;
    public static final hh x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final int f480a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372928, "Lcom/xiaomi/push/hh;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372928, "Lcom/xiaomi/push/hh;");
                return;
            }
        }
        f77393a = new hh("DeviceInfo", 0, 1);
        f77394b = new hh("AppInstallList", 1, 2);
        f77395c = new hh("AppActiveList", 2, 3);
        f77396d = new hh("Bluetooth", 3, 4);
        f77397e = new hh("Location", 4, 5);
        f77398f = new hh("Account", 5, 6);
        f77399g = new hh(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 6, 7);
        f77400h = new hh("Cellular", 7, 8);
        f77401i = new hh("TopApp", 8, 9);
        f77402j = new hh("BroadcastAction", 9, 10);
        k = new hh("BroadcastActionAdded", 10, 11);
        l = new hh("BroadcastActionRemoved", 11, 12);
        m = new hh("BroadcastActionReplaced", 12, 13);
        n = new hh("BroadcastActionDataCleared", 13, 14);
        o = new hh("BroadcastActionRestarted", 14, 15);
        p = new hh("BroadcastActionChanged", 15, 16);
        q = new hh("AppPermission", 16, 17);
        r = new hh("WifiDevicesMac", 17, 18);
        s = new hh("ActivityActiveTimeStamp", 18, 19);
        t = new hh("DeviceBaseInfo", 19, 20);
        u = new hh("DeviceInfoV2", 20, 21);
        v = new hh("Battery", 21, 22);
        w = new hh("Storage", 22, 23);
        hh hhVar = new hh("AppIsInstalled", 23, 24);
        x = hhVar;
        f479a = new hh[]{f77393a, f77394b, f77395c, f77396d, f77397e, f77398f, f77399g, f77400h, f77401i, f77402j, k, l, m, n, o, p, q, r, s, t, u, v, w, hhVar};
    }

    public hh(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f480a = i3;
    }

    public static hh a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return f77393a;
                case 2:
                    return f77394b;
                case 3:
                    return f77395c;
                case 4:
                    return f77396d;
                case 5:
                    return f77397e;
                case 6:
                    return f77398f;
                case 7:
                    return f77399g;
                case 8:
                    return f77400h;
                case 9:
                    return f77401i;
                case 10:
                    return f77402j;
                case 11:
                    return k;
                case 12:
                    return l;
                case 13:
                    return m;
                case 14:
                    return n;
                case 15:
                    return o;
                case 16:
                    return p;
                case 17:
                    return q;
                case 18:
                    return r;
                case 19:
                    return s;
                case 20:
                    return t;
                case 21:
                    return u;
                case 22:
                    return v;
                case 23:
                    return w;
                case 24:
                    return x;
                default:
                    return null;
            }
        }
        return (hh) invokeI.objValue;
    }

    public static hh valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (hh) Enum.valueOf(hh.class, str) : (hh) invokeL.objValue;
    }

    public static hh[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (hh[]) f479a.clone() : (hh[]) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f480a : invokeV.intValue;
    }
}
