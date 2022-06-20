package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class hl {
    public static /* synthetic */ Interceptable $ic;
    public static final hl a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ hl[] f464a;
    public static final hl b;
    public static final hl c;
    public static final hl d;
    public static final hl e;
    public static final hl f;
    public static final hl g;
    public static final hl h;
    public static final hl i;
    public static final hl j;
    public static final hl k;
    public static final hl l;
    public static final hl m;
    public static final hl n;
    public static final hl o;
    public static final hl p;
    public static final hl q;
    public static final hl r;
    public static final hl s;
    public static final hl t;
    public static final hl u;
    public static final hl v;
    public static final hl w;
    public static final hl x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final int f465a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372804, "Lcom/xiaomi/push/hl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372804, "Lcom/xiaomi/push/hl;");
                return;
            }
        }
        a = new hl("DeviceInfo", 0, 1);
        b = new hl("AppInstallList", 1, 2);
        c = new hl("AppActiveList", 2, 3);
        d = new hl("Bluetooth", 3, 4);
        e = new hl(Headers.LOCATION, 4, 5);
        f = new hl("Account", 5, 6);
        g = new hl("WIFI", 6, 7);
        h = new hl("Cellular", 7, 8);
        i = new hl("TopApp", 8, 9);
        j = new hl("BroadcastAction", 9, 10);
        k = new hl("BroadcastActionAdded", 10, 11);
        l = new hl("BroadcastActionRemoved", 11, 12);
        m = new hl("BroadcastActionReplaced", 12, 13);
        n = new hl("BroadcastActionDataCleared", 13, 14);
        o = new hl("BroadcastActionRestarted", 14, 15);
        p = new hl("BroadcastActionChanged", 15, 16);
        q = new hl("AppPermission", 16, 17);
        r = new hl("WifiDevicesMac", 17, 18);
        s = new hl("ActivityActiveTimeStamp", 18, 19);
        t = new hl("DeviceBaseInfo", 19, 20);
        u = new hl("DeviceInfoV2", 20, 21);
        v = new hl("Battery", 21, 22);
        w = new hl("Storage", 22, 23);
        hl hlVar = new hl("AppIsInstalled", 23, 24);
        x = hlVar;
        f464a = new hl[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, hlVar};
    }

    public hl(String str, int i2, int i3) {
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
        this.f465a = i3;
    }

    public static hl a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return a;
                case 2:
                    return b;
                case 3:
                    return c;
                case 4:
                    return d;
                case 5:
                    return e;
                case 6:
                    return f;
                case 7:
                    return g;
                case 8:
                    return h;
                case 9:
                    return i;
                case 10:
                    return j;
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
        return (hl) invokeI.objValue;
    }

    public static hl valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (hl) Enum.valueOf(hl.class, str) : (hl) invokeL.objValue;
    }

    public static hl[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (hl[]) f464a.clone() : (hl[]) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f465a : invokeV.intValue;
    }
}
