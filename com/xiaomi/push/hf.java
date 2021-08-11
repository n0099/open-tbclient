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
/* loaded from: classes10.dex */
public final class hf {
    public static /* synthetic */ Interceptable $ic;
    public static final hf A;
    public static final hf B;
    public static final hf C;
    public static final hf D;
    public static final hf E;
    public static final hf F;
    public static final hf G;
    public static final hf H;
    public static final hf I;
    public static final hf J;
    public static final hf K;

    /* renamed from: a  reason: collision with root package name */
    public static final hf f77381a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ hf[] f475a;

    /* renamed from: b  reason: collision with root package name */
    public static final hf f77382b;

    /* renamed from: c  reason: collision with root package name */
    public static final hf f77383c;

    /* renamed from: d  reason: collision with root package name */
    public static final hf f77384d;

    /* renamed from: e  reason: collision with root package name */
    public static final hf f77385e;

    /* renamed from: f  reason: collision with root package name */
    public static final hf f77386f;

    /* renamed from: g  reason: collision with root package name */
    public static final hf f77387g;

    /* renamed from: h  reason: collision with root package name */
    public static final hf f77388h;

    /* renamed from: i  reason: collision with root package name */
    public static final hf f77389i;

    /* renamed from: j  reason: collision with root package name */
    public static final hf f77390j;
    public static final hf k;
    public static final hf l;
    public static final hf m;
    public static final hf n;
    public static final hf o;
    public static final hf p;
    public static final hf q;
    public static final hf r;
    public static final hf s;
    public static final hf t;
    public static final hf u;
    public static final hf v;
    public static final hf w;
    public static final hf x;
    public static final hf y;
    public static final hf z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final int f476a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372990, "Lcom/xiaomi/push/hf;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372990, "Lcom/xiaomi/push/hf;");
                return;
            }
        }
        f77381a = new hf("Registration", 0, 1);
        f77382b = new hf("UnRegistration", 1, 2);
        f77383c = new hf("Subscription", 2, 3);
        f77384d = new hf("UnSubscription", 3, 4);
        f77385e = new hf("SendMessage", 4, 5);
        f77386f = new hf("AckMessage", 5, 6);
        f77387g = new hf("SetConfig", 6, 7);
        f77388h = new hf("ReportFeedback", 7, 8);
        f77389i = new hf("Notification", 8, 9);
        f77390j = new hf("Command", 9, 10);
        k = new hf("MultiConnectionBroadcast", 10, 11);
        l = new hf("MultiConnectionResult", 11, 12);
        m = new hf("ConnectionKick", 12, 13);
        n = new hf("ApnsMessage", 13, 14);
        o = new hf("IOSDeviceTokenWrite", 14, 15);
        p = new hf("SaveInvalidRegId", 15, 16);
        q = new hf("ApnsCertChanged", 16, 17);
        r = new hf("RegisterDevice", 17, 18);
        s = new hf("ExpandTopicInXmq", 18, 19);
        t = new hf("SendMessageNew", 19, 22);
        u = new hf("ExpandTopicInXmqNew", 20, 23);
        v = new hf("DeleteInvalidMessage", 21, 24);
        w = new hf("BadAction", 22, 99);
        x = new hf("Presence", 23, 100);
        y = new hf("FetchOfflineMessage", 24, 101);
        z = new hf("SaveJob", 25, 102);
        A = new hf("Broadcast", 26, 103);
        B = new hf("BatchPresence", 27, 104);
        C = new hf("BatchMessage", 28, 105);
        D = new hf("StatCounter", 29, 107);
        E = new hf("FetchTopicMessage", 30, 108);
        F = new hf("DeleteAliasCache", 31, 109);
        G = new hf("UpdateRegistration", 32, 110);
        H = new hf("BatchMessageNew", 33, 112);
        I = new hf("PublicWelfareMessage", 34, 113);
        J = new hf("RevokeMessage", 35, 114);
        hf hfVar = new hf("SimulatorJob", 36, 200);
        K = hfVar;
        f475a = new hf[]{f77381a, f77382b, f77383c, f77384d, f77385e, f77386f, f77387g, f77388h, f77389i, f77390j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, hfVar};
    }

    public hf(String str, int i2, int i3) {
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
        this.f476a = i3;
    }

    public static hf a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 200) {
                switch (i2) {
                    case 1:
                        return f77381a;
                    case 2:
                        return f77382b;
                    case 3:
                        return f77383c;
                    case 4:
                        return f77384d;
                    case 5:
                        return f77385e;
                    case 6:
                        return f77386f;
                    case 7:
                        return f77387g;
                    case 8:
                        return f77388h;
                    case 9:
                        return f77389i;
                    case 10:
                        return f77390j;
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
        return (hf) invokeI.objValue;
    }

    public static hf valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (hf) Enum.valueOf(hf.class, str) : (hf) invokeL.objValue;
    }

    public static hf[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (hf[]) f475a.clone() : (hf[]) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f476a : invokeV.intValue;
    }
}
