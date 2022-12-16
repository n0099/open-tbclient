package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class hj {
    public static /* synthetic */ Interceptable $ic;
    public static final hj A;
    public static final hj B;
    public static final hj C;
    public static final hj D;
    public static final hj E;
    public static final hj F;
    public static final hj G;
    public static final hj H;
    public static final hj I;
    public static final hj J;
    public static final hj K;
    public static final hj a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ hj[] f491a;
    public static final hj b;
    public static final hj c;
    public static final hj d;
    public static final hj e;
    public static final hj f;
    public static final hj g;
    public static final hj h;
    public static final hj i;
    public static final hj j;
    public static final hj k;
    public static final hj l;
    public static final hj m;
    public static final hj n;
    public static final hj o;
    public static final hj p;
    public static final hj q;
    public static final hj r;
    public static final hj s;
    public static final hj t;
    public static final hj u;
    public static final hj v;
    public static final hj w;
    public static final hj x;
    public static final hj y;
    public static final hj z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final int f492a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372866, "Lcom/xiaomi/push/hj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372866, "Lcom/xiaomi/push/hj;");
                return;
            }
        }
        a = new hj("Registration", 0, 1);
        b = new hj("UnRegistration", 1, 2);
        c = new hj("Subscription", 2, 3);
        d = new hj("UnSubscription", 3, 4);
        e = new hj("SendMessage", 4, 5);
        f = new hj("AckMessage", 5, 6);
        g = new hj("SetConfig", 6, 7);
        h = new hj("ReportFeedback", 7, 8);
        i = new hj("Notification", 8, 9);
        j = new hj("Command", 9, 10);
        k = new hj("MultiConnectionBroadcast", 10, 11);
        l = new hj("MultiConnectionResult", 11, 12);
        m = new hj("ConnectionKick", 12, 13);
        n = new hj("ApnsMessage", 13, 14);
        o = new hj("IOSDeviceTokenWrite", 14, 15);
        p = new hj("SaveInvalidRegId", 15, 16);
        q = new hj("ApnsCertChanged", 16, 17);
        r = new hj("RegisterDevice", 17, 18);
        s = new hj("ExpandTopicInXmq", 18, 19);
        t = new hj("SendMessageNew", 19, 22);
        u = new hj("ExpandTopicInXmqNew", 20, 23);
        v = new hj("DeleteInvalidMessage", 21, 24);
        w = new hj("BadAction", 22, 99);
        x = new hj("Presence", 23, 100);
        y = new hj("FetchOfflineMessage", 24, 101);
        z = new hj("SaveJob", 25, 102);
        A = new hj("Broadcast", 26, 103);
        B = new hj("BatchPresence", 27, 104);
        C = new hj("BatchMessage", 28, 105);
        D = new hj("StatCounter", 29, 107);
        E = new hj("FetchTopicMessage", 30, 108);
        F = new hj("DeleteAliasCache", 31, 109);
        G = new hj("UpdateRegistration", 32, 110);
        H = new hj("BatchMessageNew", 33, 112);
        I = new hj("PublicWelfareMessage", 34, 113);
        J = new hj("RevokeMessage", 35, 114);
        hj hjVar = new hj("SimulatorJob", 36, 200);
        K = hjVar;
        f491a = new hj[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, hjVar};
    }

    public hj(String str, int i2, int i3) {
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
        this.f492a = i3;
    }

    public static hj a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 200) {
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
                    default:
                        switch (i2) {
                            case 22:
                                return t;
                            case 23:
                                return u;
                            case 24:
                                return v;
                            default:
                                switch (i2) {
                                    case 99:
                                        return w;
                                    case 100:
                                        return x;
                                    case 101:
                                        return y;
                                    case 102:
                                        return z;
                                    case 103:
                                        return A;
                                    case 104:
                                        return B;
                                    case 105:
                                        return C;
                                    default:
                                        switch (i2) {
                                            case 107:
                                                return D;
                                            case 108:
                                                return E;
                                            case 109:
                                                return F;
                                            case 110:
                                                return G;
                                            default:
                                                switch (i2) {
                                                    case 112:
                                                        return H;
                                                    case 113:
                                                        return I;
                                                    case 114:
                                                        return J;
                                                    default:
                                                        return null;
                                                }
                                        }
                                }
                        }
                }
            }
            return K;
        }
        return (hj) invokeI.objValue;
    }

    public static hj valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (hj) Enum.valueOf(hj.class, str) : (hj) invokeL.objValue;
    }

    public static hj[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (hj[]) f491a.clone() : (hj[]) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f492a : invokeV.intValue;
    }
}
