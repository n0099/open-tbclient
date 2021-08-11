package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class ew {
    public static /* synthetic */ Interceptable $ic;
    public static final ew A;
    public static final ew B;
    public static final ew C;
    public static final ew D;
    public static final ew E;
    public static final ew F;
    public static final ew G;
    public static final ew H;
    public static final ew I;
    public static final ew J;
    public static final ew K;
    public static final ew L;
    public static final ew M;
    public static final ew N;
    public static final ew O;
    public static final ew P;
    public static final ew Q;
    public static final ew R;
    public static final ew S;
    public static final ew T;
    public static final ew U;
    public static final ew V;
    public static final ew W;
    public static final ew X;
    public static final ew Y;
    public static final ew Z;

    /* renamed from: a  reason: collision with root package name */
    public static final ew f77212a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ ew[] f345a;
    public static final ew aa;
    public static final ew ab;
    public static final ew ac;
    public static final ew ad;
    public static final ew ae;

    /* renamed from: b  reason: collision with root package name */
    public static final ew f77213b;

    /* renamed from: c  reason: collision with root package name */
    public static final ew f77214c;

    /* renamed from: d  reason: collision with root package name */
    public static final ew f77215d;

    /* renamed from: e  reason: collision with root package name */
    public static final ew f77216e;

    /* renamed from: f  reason: collision with root package name */
    public static final ew f77217f;

    /* renamed from: g  reason: collision with root package name */
    public static final ew f77218g;

    /* renamed from: h  reason: collision with root package name */
    public static final ew f77219h;

    /* renamed from: i  reason: collision with root package name */
    public static final ew f77220i;

    /* renamed from: j  reason: collision with root package name */
    public static final ew f77221j;
    public static final ew k;
    public static final ew l;
    public static final ew m;
    public static final ew n;
    public static final ew o;
    public static final ew p;
    public static final ew q;
    public static final ew r;
    public static final ew s;
    public static final ew t;
    public static final ew u;
    public static final ew v;
    public static final ew w;
    public static final ew x;
    public static final ew y;
    public static final ew z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final int f346a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375346, "Lcom/xiaomi/push/ew;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375346, "Lcom/xiaomi/push/ew;");
                return;
            }
        }
        f77212a = new ew("TCP_CONN_FAIL", 0, 1);
        f77213b = new ew("TCP_CONN_TIME", 1, 2);
        f77214c = new ew("PING_RTT", 2, 3);
        f77215d = new ew("CHANNEL_CON_FAIL", 3, 4);
        f77216e = new ew("CHANNEL_CON_OK", 4, 5);
        f77217f = new ew("ICMP_PING_FAIL", 5, 6);
        f77218g = new ew("ICMP_PING_OK", 6, 7);
        f77219h = new ew("CHANNEL_ONLINE_RATE", 7, 8);
        f77220i = new ew("BATCH_TCP_CONN_SUCCESS", 8, 1000);
        f77221j = new ew("BATCH_TCP_CONN_FAIL", 9, 1001);
        k = new ew("CHANNEL_STATS_COUNTER", 10, 8000);
        l = new ew("GSLB_REQUEST_SUCCESS", 11, 10000);
        m = new ew("GSLB_TCP_NOACCESS", 12, 10101);
        n = new ew("GSLB_TCP_NETUNREACH", 13, 10102);
        o = new ew("GSLB_TCP_CONNREFUSED", 14, 10103);
        p = new ew("GSLB_TCP_NOROUTETOHOST", 15, Constants.REQUEST_QZONE_SHARE);
        q = new ew("GSLB_TCP_TIMEOUT", 16, Constants.REQUEST_QQ_FAVORITES);
        r = new ew("GSLB_TCP_INVALARG", 17, Constants.REQUEST_SEND_TO_MY_COMPUTER);
        s = new ew("GSLB_TCP_UKNOWNHOST", 18, Constants.REQUEST_SHARE_TO_TROOP_BAR);
        t = new ew("GSLB_TCP_ERR_OTHER", 19, 10199);
        u = new ew("GSLB_ERR", 20, 10999);
        v = new ew("CONN_SUCCESS", 21, 20000);
        w = new ew("CONN_TCP_NOACCESS", 22, 20101);
        x = new ew("CONN_TCP_NETUNREACH", 23, 20102);
        y = new ew("CONN_TCP_CONNREFUSED", 24, 20103);
        z = new ew("CONN_TCP_NOROUTETOHOST", 25, 20104);
        A = new ew("CONN_TCP_TIMEOUT", 26, 20105);
        B = new ew("CONN_TCP_INVALARG", 27, 20106);
        C = new ew("CONN_TCP_UKNOWNHOST", 28, 20107);
        D = new ew("CONN_TCP_ERR_OTHER", 29, 20199);
        E = new ew("CONN_XMPP_ERR", 30, 20399);
        F = new ew("CONN_BOSH_UNKNOWNHOST", 31, 20407);
        G = new ew("CONN_BOSH_ERR", 32, 20499);
        H = new ew("BIND_SUCCESS", 33, 30000);
        I = new ew("BIND_TCP_READ_TIMEOUT_DEPRECTED", 34, 30101);
        J = new ew("BIND_TCP_CONNRESET_DEPRECTED", 35, 30102);
        K = new ew("BIND_TCP_BROKEN_PIPE_DEPRECTED", 36, 30103);
        L = new ew("BIND_TCP_READ_TIMEOUT", 37, 30108);
        M = new ew("BIND_TCP_CONNRESET", 38, 30109);
        N = new ew("BIND_TCP_BROKEN_PIPE", 39, 30110);
        O = new ew("BIND_TCP_ERR", 40, 30199);
        P = new ew("BIND_XMPP_ERR", 41, 30399);
        Q = new ew("BIND_BOSH_ITEM_NOT_FOUND", 42, 30401);
        R = new ew("BIND_BOSH_ERR", 43, 30499);
        S = new ew("BIND_TIMEOUT", 44, 30501);
        T = new ew("BIND_INVALID_SIG", 45, 30502);
        U = new ew("CHANNEL_TCP_READTIMEOUT_DEPRECTED", 46, 40101);
        V = new ew("CHANNEL_TCP_CONNRESET_DEPRECTED", 47, 40102);
        W = new ew("CHANNEL_TCP_BROKEN_PIPE_DEPRECTED", 48, 40103);
        X = new ew("CHANNEL_TCP_READTIMEOUT", 49, 40108);
        Y = new ew("CHANNEL_TCP_CONNRESET", 50, 40109);
        Z = new ew("CHANNEL_TCP_BROKEN_PIPE", 51, 40110);
        aa = new ew("CHANNEL_TCP_ERR", 52, 40199);
        ab = new ew("CHANNEL_XMPPEXCEPTION", 53, 40399);
        ac = new ew("CHANNEL_BOSH_ITEMNOTFIND", 54, 40401);
        ad = new ew("CHANNEL_BOSH_EXCEPTION", 55, 40499);
        ew ewVar = new ew("CHANNEL_TIMER_DELAYED", 56, 50001);
        ae = ewVar;
        f345a = new ew[]{f77212a, f77213b, f77214c, f77215d, f77216e, f77217f, f77218g, f77219h, f77220i, f77221j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ewVar};
    }

    public ew(String str, int i2, int i3) {
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
        this.f346a = i3;
    }

    public static ew a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 30501) {
                if (i2 != 30502) {
                    switch (i2) {
                        case 1:
                            return f77212a;
                        case 2:
                            return f77213b;
                        case 3:
                            return f77214c;
                        case 4:
                            return f77215d;
                        case 5:
                            return f77216e;
                        case 6:
                            return f77217f;
                        case 7:
                            return f77218g;
                        case 8:
                            return f77219h;
                        default:
                            switch (i2) {
                                case 8000:
                                    return k;
                                case 10000:
                                    return l;
                                case 10199:
                                    return t;
                                case 10999:
                                    return u;
                                case 20000:
                                    return v;
                                case 20199:
                                    return D;
                                case 20399:
                                    return E;
                                case 20407:
                                    return F;
                                case 20499:
                                    return G;
                                case 30000:
                                    return H;
                                case 30199:
                                    return O;
                                case 30399:
                                    return P;
                                case 30401:
                                    return Q;
                                case 30499:
                                    return R;
                                case 40199:
                                    return aa;
                                case 40399:
                                    return ab;
                                case 40401:
                                    return ac;
                                case 40499:
                                    return ad;
                                case 50001:
                                    return ae;
                                default:
                                    switch (i2) {
                                        case 10101:
                                            return m;
                                        case 10102:
                                            return n;
                                        case 10103:
                                            return o;
                                        case Constants.REQUEST_QZONE_SHARE /* 10104 */:
                                            return p;
                                        case Constants.REQUEST_QQ_FAVORITES /* 10105 */:
                                            return q;
                                        case Constants.REQUEST_SEND_TO_MY_COMPUTER /* 10106 */:
                                            return r;
                                        case Constants.REQUEST_SHARE_TO_TROOP_BAR /* 10107 */:
                                            return s;
                                        default:
                                            switch (i2) {
                                                case 20101:
                                                    return w;
                                                case 20102:
                                                    return x;
                                                case 20103:
                                                    return y;
                                                case 20104:
                                                    return z;
                                                case 20105:
                                                    return A;
                                                case 20106:
                                                    return B;
                                                case 20107:
                                                    return C;
                                                default:
                                                    switch (i2) {
                                                        case 30101:
                                                            return I;
                                                        case 30102:
                                                            return J;
                                                        case 30103:
                                                            return K;
                                                        default:
                                                            switch (i2) {
                                                                case 30108:
                                                                    return L;
                                                                case 30109:
                                                                    return M;
                                                                case 30110:
                                                                    return N;
                                                                default:
                                                                    switch (i2) {
                                                                        case 40101:
                                                                            return U;
                                                                        case 40102:
                                                                            return V;
                                                                        case 40103:
                                                                            return W;
                                                                        default:
                                                                            switch (i2) {
                                                                                case 40108:
                                                                                    return X;
                                                                                case 40109:
                                                                                    return Y;
                                                                                case 40110:
                                                                                    return Z;
                                                                                default:
                                                                                    return null;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                }
                return T;
            }
            return S;
        }
        return (ew) invokeI.objValue;
    }

    public static ew valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ew) Enum.valueOf(ew.class, str) : (ew) invokeL.objValue;
    }

    public static ew[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ew[]) f345a.clone() : (ew[]) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f346a : invokeV.intValue;
    }
}
