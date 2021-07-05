package d.a.r0.r.q;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a2 extends a implements d.a.c.k.e.n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55850e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55851f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55852g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55853h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55854i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public b2 w;
    public int x;
    public int y;

    public a2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55850e = false;
        this.f55851f = false;
        this.f55852g = false;
        this.f55853h = false;
        this.f55854i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.x = 0;
        this.y = 0;
    }

    @Override // d.a.r0.r.q.a
    public w0 getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b2 b2Var = this.w;
            if (b2Var == null || (sparseArray = b2Var.g1) == null || sparseArray.size() <= 0) {
                return null;
            }
            w0 w0Var = new w0();
            w0Var.n(getThreadData().n1());
            w0Var.k(getThreadData().Q());
            w0Var.m(getThreadData().A0());
            w0Var.j(this.w.g1);
            b2 b2Var2 = this.w;
            w0Var.f56085g = b2Var2.h1;
            w0Var.o = b2Var2.V0;
            w0Var.j = b2Var2.U0;
            w0Var.l = b2Var2.W0;
            w0Var.k = b2Var2.T0;
            w0Var.p = b2Var2.P1;
            w0Var.n = b2Var2.L0();
            return w0Var;
        }
        return (w0) invokeV.objValue;
    }

    @Override // d.a.r0.r.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w.X0 : (String) invokeV.objValue;
    }

    @Override // d.a.r0.r.q.a
    public b2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w : (b2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b2 b2Var = this.w;
            if (b2Var == null) {
                return null;
            }
            if (b2Var.f0()) {
                if (this.w.l1() != null) {
                    return b2.l3;
                }
                return b2.O2;
            }
            int m0 = this.w.m0();
            b2 b2Var2 = this.w;
            int i3 = b2Var2.Z;
            if (i3 == 63) {
                return b2.x3;
            }
            if (i3 == 64) {
                return b2.y3;
            }
            if (i3 == 65) {
                return b2.d3;
            }
            if (b2Var2.g1() != null && this.w.Z == 60) {
                return b2.o3;
            }
            if (this.w.g1() != null && ((i2 = this.w.Z) == 49 || i2 == 69)) {
                return b2.m3;
            }
            if (this.w.g1() != null && this.w.Z == 67) {
                return b2.p3;
            }
            b2 b2Var3 = this.w;
            if (b2Var3.Z == 51) {
                return b2.n3;
            }
            if (m0 != 2 && m0 != 1) {
                if (b2Var3.l1() != null && this.w.S1() && !this.w.W1()) {
                    return b2.D3;
                }
                b2 b2Var4 = this.w;
                if (b2Var4.v1 && (originalThreadInfo = b2Var4.u1) != null) {
                    if (originalThreadInfo.u) {
                        if (originalThreadInfo.r != null) {
                            return b2.t3;
                        }
                        if (originalThreadInfo.d()) {
                            return b2.s3;
                        }
                        return b2.r3;
                    }
                    return b2.q3;
                } else if (this.w.U1()) {
                    return b2.A3.get() ? b2.H3 : b2.O2;
                } else if (this.w.B1() && this.w.q() == 1) {
                    return b2.A3.get() ? b2.I3 : b2.O2;
                } else if (this.w.V1()) {
                    return b2.j3;
                } else {
                    if (this.w.n2()) {
                        return this.w.b0() != null ? b2.w3 : b2.v3;
                    }
                    d.a.s0.h3.h0.n nVar = this.w.G2;
                    if (nVar != null && nVar.f()) {
                        return this.w.G2.g() ? AdvertAppInfo.p4 : AdvertAppInfo.q4;
                    } else if (this.v) {
                        return b2.T2;
                    } else {
                        if (this.f55850e) {
                            return b2.U2;
                        }
                        if (this.f55851f) {
                            return b2.V2;
                        }
                        if (this.f55852g) {
                            return b2.W2;
                        }
                        if (this.f55853h) {
                            return b2.X2;
                        }
                        if (this.f55854i) {
                            return b2.Y2;
                        }
                        if (this.j) {
                            return b2.Z2;
                        }
                        if (this.k) {
                            return b2.a3;
                        }
                        if (this.l) {
                            return b2.b3;
                        }
                        if (this.m) {
                            return b2.l3;
                        }
                        if (this.n) {
                            return b2.E3;
                        }
                        if (this.w.Q1()) {
                            if (this.o) {
                                return b2.u3;
                            }
                            return b2.k3;
                        } else if (this.p) {
                            return b2.z3;
                        } else {
                            if (this.q) {
                                return b2.e3;
                            }
                            if (this.r) {
                                return b2.f3;
                            }
                            if (this.s) {
                                return b2.g3;
                            }
                            if (this.t) {
                                return b2.h3;
                            }
                            if (this.u) {
                                return b2.i3;
                            }
                            return b2.O2;
                        }
                    }
                }
            }
            return b2.N2;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
