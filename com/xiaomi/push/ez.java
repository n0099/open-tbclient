package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class ez {
    public static /* synthetic */ Interceptable $ic;
    public static final ez A;
    public static final ez B;
    public static final ez C;
    public static final ez D;
    public static final ez E;
    public static final ez F;
    public static final ez G;
    public static final ez H;
    public static final ez I;
    public static final ez J;
    public static final ez K;
    public static final ez L;
    public static final ez M;
    public static final ez N;
    public static final ez O;
    public static final ez P;
    public static final ez Q;
    public static final ez R;
    public static final ez S;
    public static final ez T;
    public static final ez U;
    public static final ez V;
    public static final ez W;
    public static final ez X;
    public static final ez Y;
    public static final ez Z;
    public static final ez a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ ez[] f1054a;
    public static final ez aa;
    public static final ez ab;
    public static final ez ac;
    public static final ez ad;
    public static final ez ae;
    public static final ez b;
    public static final ez c;
    public static final ez d;
    public static final ez e;
    public static final ez f;
    public static final ez g;
    public static final ez h;
    public static final ez i;
    public static final ez j;
    public static final ez k;
    public static final ez l;
    public static final ez m;
    public static final ez n;
    public static final ez o;
    public static final ez p;
    public static final ez q;
    public static final ez r;
    public static final ez s;
    public static final ez t;
    public static final ez u;
    public static final ez v;
    public static final ez w;
    public static final ez x;
    public static final ez y;
    public static final ez z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final int f1055a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375253, "Lcom/xiaomi/push/ez;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375253, "Lcom/xiaomi/push/ez;");
                return;
            }
        }
        a = new ez("TCP_CONN_FAIL", 0, 1);
        b = new ez("TCP_CONN_TIME", 1, 2);
        c = new ez("PING_RTT", 2, 3);
        d = new ez("CHANNEL_CON_FAIL", 3, 4);
        e = new ez("CHANNEL_CON_OK", 4, 5);
        f = new ez("ICMP_PING_FAIL", 5, 6);
        g = new ez("ICMP_PING_OK", 6, 7);
        h = new ez("CHANNEL_ONLINE_RATE", 7, 8);
        i = new ez("BATCH_TCP_CONN_SUCCESS", 8, 1000);
        j = new ez("BATCH_TCP_CONN_FAIL", 9, 1001);
        k = new ez("CHANNEL_STATS_COUNTER", 10, 8000);
        l = new ez("GSLB_REQUEST_SUCCESS", 11, 10000);
        m = new ez("GSLB_TCP_NOACCESS", 12, 10101);
        n = new ez("GSLB_TCP_NETUNREACH", 13, 10102);
        o = new ez("GSLB_TCP_CONNREFUSED", 14, 10103);
        p = new ez("GSLB_TCP_NOROUTETOHOST", 15, Constants.REQUEST_QZONE_SHARE);
        q = new ez("GSLB_TCP_TIMEOUT", 16, Constants.REQUEST_QQ_FAVORITES);
        r = new ez("GSLB_TCP_INVALARG", 17, Constants.REQUEST_SEND_TO_MY_COMPUTER);
        s = new ez("GSLB_TCP_UKNOWNHOST", 18, Constants.REQUEST_SHARE_TO_TROOP_BAR);
        t = new ez("GSLB_TCP_ERR_OTHER", 19, 10199);
        u = new ez("GSLB_ERR", 20, 10999);
        v = new ez("CONN_SUCCESS", 21, 20000);
        w = new ez("CONN_TCP_NOACCESS", 22, 20101);
        x = new ez("CONN_TCP_NETUNREACH", 23, 20102);
        y = new ez("CONN_TCP_CONNREFUSED", 24, 20103);
        z = new ez("CONN_TCP_NOROUTETOHOST", 25, 20104);
        A = new ez("CONN_TCP_TIMEOUT", 26, 20105);
        B = new ez("CONN_TCP_INVALARG", 27, 20106);
        C = new ez("CONN_TCP_UKNOWNHOST", 28, 20107);
        D = new ez("CONN_TCP_ERR_OTHER", 29, 20199);
        E = new ez("CONN_XMPP_ERR", 30, 20399);
        F = new ez("CONN_BOSH_UNKNOWNHOST", 31, 20407);
        G = new ez("CONN_BOSH_ERR", 32, 20499);
        H = new ez("BIND_SUCCESS", 33, 30000);
        I = new ez("BIND_TCP_READ_TIMEOUT_DEPRECTED", 34, 30101);
        J = new ez("BIND_TCP_CONNRESET_DEPRECTED", 35, 30102);
        K = new ez("BIND_TCP_BROKEN_PIPE_DEPRECTED", 36, 30103);
        L = new ez("BIND_TCP_READ_TIMEOUT", 37, 30108);
        M = new ez("BIND_TCP_CONNRESET", 38, 30109);
        N = new ez("BIND_TCP_BROKEN_PIPE", 39, 30110);
        O = new ez("BIND_TCP_ERR", 40, 30199);
        P = new ez("BIND_XMPP_ERR", 41, 30399);
        Q = new ez("BIND_BOSH_ITEM_NOT_FOUND", 42, 30401);
        R = new ez("BIND_BOSH_ERR", 43, 30499);
        S = new ez("BIND_TIMEOUT", 44, 30501);
        T = new ez("BIND_INVALID_SIG", 45, 30502);
        U = new ez("CHANNEL_TCP_READTIMEOUT_DEPRECTED", 46, 40101);
        V = new ez("CHANNEL_TCP_CONNRESET_DEPRECTED", 47, 40102);
        W = new ez("CHANNEL_TCP_BROKEN_PIPE_DEPRECTED", 48, 40103);
        X = new ez("CHANNEL_TCP_READTIMEOUT", 49, 40108);
        Y = new ez("CHANNEL_TCP_CONNRESET", 50, 40109);
        Z = new ez("CHANNEL_TCP_BROKEN_PIPE", 51, 40110);
        aa = new ez("CHANNEL_TCP_ERR", 52, 40199);
        ab = new ez("CHANNEL_XMPPEXCEPTION", 53, 40399);
        ac = new ez("CHANNEL_BOSH_ITEMNOTFIND", 54, 40401);
        ad = new ez("CHANNEL_BOSH_EXCEPTION", 55, 40499);
        ez ezVar = new ez("CHANNEL_TIMER_DELAYED", 56, SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE);
        ae = ezVar;
        f1054a = new ez[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ezVar};
    }

    public ez(String str, int i2, int i3) {
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
        this.f1055a = i3;
    }

    public static ez a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 30501) {
                if (i2 != 30502) {
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
                                case SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE /* 50001 */:
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
        return (ez) invokeI.objValue;
    }

    public static ez valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ez) Enum.valueOf(ez.class, str) : (ez) invokeL.objValue;
    }

    public static ez[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ez[]) f1054a.clone() : (ez[]) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1055a : invokeV.intValue;
    }
}
