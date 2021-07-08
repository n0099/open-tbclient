package d.a.p0.a0.e0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class k extends b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId A0;
    public static final BdUniqueId B0;
    public static final BdUniqueId C0;
    public static final BdUniqueId D0;
    public static final BdUniqueId E0;
    public static final BdUniqueId F0;
    public static final BdUniqueId G0;
    public static final BdUniqueId H0;
    public static final BdUniqueId I0;
    public static final BdUniqueId J0;
    public static final BdUniqueId K0;
    public static final BdUniqueId L0;
    public static final BdUniqueId M0;
    public static final BdUniqueId N0;
    public static final BdUniqueId O0;
    public static String W = "";
    public static String X = "";
    public static String Y = "";
    public static String Z = "";
    public static String a0 = "";
    public static String b0 = "";
    public static String c0 = "";
    public static String i0 = "";
    public static String j0 = "";
    public static String k0 = "";
    public static String l0 = "";
    public static String m0 = "";
    public static String n0 = "";
    public static String o0 = "";
    public static String p0 = "";
    public static String q0 = "";
    public static String r0 = "";
    public static final BdUniqueId s0;
    public static final BdUniqueId t0;
    public static final BdUniqueId u0;
    public static final BdUniqueId v0;
    public static final BdUniqueId w0;
    public static final BdUniqueId x0;
    public static final BdUniqueId y0;
    public static final BdUniqueId z0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean U;
    public boolean V;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431536574, "Ld/a/p0/a0/e0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431536574, "Ld/a/p0/a0/e0/k;");
                return;
            }
        }
        s0 = BdUniqueId.gen();
        t0 = BdUniqueId.gen();
        u0 = BdUniqueId.gen();
        v0 = BdUniqueId.gen();
        w0 = BdUniqueId.gen();
        x0 = BdUniqueId.gen();
        y0 = BdUniqueId.gen();
        z0 = BdUniqueId.gen();
        A0 = BdUniqueId.gen();
        B0 = BdUniqueId.gen();
        C0 = BdUniqueId.gen();
        D0 = BdUniqueId.gen();
        E0 = BdUniqueId.gen();
        F0 = BdUniqueId.gen();
        G0 = BdUniqueId.gen();
        H0 = BdUniqueId.gen();
        I0 = BdUniqueId.gen();
        J0 = BdUniqueId.gen();
        K0 = BdUniqueId.gen();
        L0 = BdUniqueId.gen();
        M0 = BdUniqueId.gen();
        N0 = BdUniqueId.gen();
        O0 = BdUniqueId.gen();
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.U = false;
        this.V = true;
    }

    public static boolean W(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b2Var)) == null) {
            if (b2Var == null) {
                return false;
            }
            return b2Var.getType() == b2.O2 || b2Var.getType() == b2.k3 || b2Var.getType() == b2.j3 || b2Var.getType() == b2.q3 || b2Var.getType() == b2.v3;
        }
        return invokeL.booleanValue;
    }

    public static boolean X(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, b2Var)) == null) {
            if (b2Var == null) {
                return false;
            }
            return b2Var.getType() == b2.x3 || b2Var.getType() == b2.y3;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.p0.a0.e0.b
    public StatisticItem B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StatisticItem w = w(o0, true);
            if (getThreadData() != null) {
                b2 threadData = getThreadData();
                if (threadData.J() != null) {
                    w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.J().oriUgcNid);
                    w.param(TiebaStatic.Params.OBJ_PARAM6, threadData.J().oriUgcVid);
                }
                w.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
            }
            return w;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // d.a.p0.a0.e0.b
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b2 b2Var = this.f53795e;
            return b2Var != null && b2Var.q2();
        }
        return invokeV.booleanValue;
    }

    public int N(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var)) == null) {
            if (b2Var == null) {
                return 0;
            }
            if (b2Var.E1()) {
                return 1;
            }
            if (b2Var.q2()) {
                return 2;
            }
            if (b2Var.F1()) {
                return 3;
            }
            return b2Var.G1() ? 4 : 0;
        }
        return invokeL.intValue;
    }

    public StatisticItem O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            StatisticItem q = q(str);
            if (q != null) {
                q.param("ab_tag", c()).param(TiebaStatic.Params.AB_ACTION, "show");
                if (getThreadData() != null) {
                    b2 threadData = getThreadData();
                    int i2 = (threadData.p1() == null || (threadData.p1().K() == null && threadData.p1().V() == null)) ? 0 : 1;
                    q.param("obj_name", i2);
                    if (i2 != 0 && threadData.p1().K() != null && threadData.p1().K().y() != null && threadData.p1().K().y().size() > 0) {
                        q.param(TiebaStatic.Params.OBJ_TO, threadData.p1().N ? 2 : 1);
                    }
                }
            }
            return q;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (V()) {
                return q(k0);
            }
            StatisticItem q = q(a0);
            if (q != null) {
                q.param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                if (getThreadData() != null) {
                    b2 threadData = getThreadData();
                    if (threadData.J() != null) {
                        q.param(TiebaStatic.Params.OBJ_PARAM4, threadData.J().oriUgcNid);
                    }
                    q.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                }
            }
            return q;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? q(str) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            StatisticItem q = q(str);
            b2 b2Var = this.f53795e;
            if (b2Var != null && b2Var.H() != null) {
                q.param(TiebaStatic.Params.AB_TYPE, this.f53795e.H().hadConcerned() ? 1 : 0);
            }
            return q;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (l.R(this.f53795e)) {
                StatisticItem w = w(p0, true);
                if (w != null && getThreadData() != null) {
                    b2 threadData = getThreadData();
                    if (threadData.J() != null) {
                        w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.J().oriUgcNid);
                        w.param(TiebaStatic.Params.OBJ_PARAM6, threadData.J().oriUgcVid);
                    }
                    w.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                    if (threadData.C1()) {
                        w.addParam(TiebaStatic.Params.OBJ_PARAM2, 2);
                    } else {
                        w.addParam(TiebaStatic.Params.OBJ_PARAM2, 1);
                    }
                    if (threadData.H() != null && threadData.H().getAlaInfo() != null) {
                        int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.H().getAlaInfo());
                        if (threadData.H().getAlaInfo().mYyExtData != null) {
                            TiebaStaticHelper.addYYParam(w, threadData.H().getAlaInfo().mYyExtData);
                        }
                        w.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
                    }
                }
                return w;
            } else if (V()) {
                return q(j0);
            } else {
                StatisticItem q = q(Z);
                if (q != null) {
                    q.param("ab_tag", c()).param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                    if (getThreadData() != null) {
                        b2 threadData2 = getThreadData();
                        if (threadData2.J() != null) {
                            q.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.J().oriUgcNid);
                        }
                        q.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData2));
                        q.param("nid", threadData2.A0());
                        if (threadData2.C1()) {
                            q.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                        } else {
                            q.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                        }
                        if (threadData2.H() != null && threadData2.H().getAlaInfo() != null) {
                            int calculateLiveType2 = YYLiveUtil.calculateLiveType(threadData2.H().getAlaInfo());
                            if (threadData2.H().getAlaInfo().mYyExtData != null) {
                                TiebaStaticHelper.addYYParam(q, threadData2.H().getAlaInfo().mYyExtData);
                            }
                            q.param(TiebaStatic.Params.OBJ_PARAM6, calculateLiveType2);
                        }
                    }
                }
                return q;
            }
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? q(l0) : (StatisticItem) invokeV.objValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b2 b2Var = this.f53795e;
            return b2Var == null || b2Var.j2();
        }
        return invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b2 b2Var = this.f53795e;
            return (b2Var == null || ListUtils.getCount(b2Var.x1()) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int Y(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, b2Var)) == null) {
            if (b2Var == null) {
                return 1;
            }
            if (b2Var.G1() || b2Var.F1()) {
                return 2;
            }
            return (b2Var.E1() || b2Var.H1()) ? 3 : 1;
        }
        return invokeL.intValue;
    }

    @Override // d.a.p0.a0.e0.b
    public StatisticItem d(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            b2 b2Var = this.f53795e;
            if (b2Var != null) {
                if (b2Var.J() == null) {
                    statisticItem.param("fid", this.f53795e.Q());
                    statisticItem.param("tid", this.f53795e.n1());
                } else {
                    statisticItem.param("tid", this.f53795e.J().oriUgcNid);
                }
                if (this.f53795e.q2()) {
                    i2 = 2;
                } else if (this.f53795e.V1()) {
                    i2 = 4;
                } else {
                    b2 b2Var2 = this.f53795e;
                    if (b2Var2.v1) {
                        i2 = 5;
                    } else if (b2Var2.E1()) {
                        i2 = 6;
                    } else if (this.f53795e.F1()) {
                        i2 = 7;
                    } else if (this.f53795e.H1()) {
                        i2 = 8;
                    } else {
                        i2 = this.f53795e.G1() ? 9 : 1;
                    }
                }
                statisticItem.param("obj_type", i2);
                statisticItem.param("obj_id", this.f53795e.H().getUserId());
                statisticItem.param("obj_param1", D() ? 2 : 1);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // d.a.p0.a0.e0.b, d.a.o0.r.q.a
    public b2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            b2 b2Var = this.f53795e;
            if (b2Var == null) {
                return null;
            }
            if (b2Var.Q0() == 5) {
                return this.f53795e;
            }
            this.f53795e.S3(1);
            return this.f53795e;
        }
        return (b2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int indexOf;
        int indexOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            b2 b2Var = this.f53795e;
            if (b2Var == null) {
                return s0;
            }
            if (this.F && b.T.length > 1) {
                BdUniqueId type = b2Var.getType();
                if (type == b2.O2 || type == b2.j3 || type == b2.v3 || type == b2.k3) {
                    if (this.s) {
                        indexOf = b.R.indexOf(b.I);
                    } else {
                        indexOf = b.R.indexOf(b.H);
                    }
                    if (this.t) {
                        indexOf2 = b.S.indexOf(b.J);
                    } else if (this.v) {
                        indexOf2 = b.S.indexOf(b.L);
                    } else if (this.u) {
                        indexOf2 = b.S.indexOf(b.K);
                    } else {
                        indexOf2 = b.S.indexOf(b.M);
                    }
                    if (indexOf >= 0) {
                        BdUniqueId[][] bdUniqueIdArr = b.T;
                        return (indexOf >= bdUniqueIdArr.length || indexOf2 < 0 || indexOf2 >= bdUniqueIdArr[0].length) ? type : bdUniqueIdArr[indexOf][indexOf2];
                    }
                    return type;
                }
                return type;
            }
            b2 b2Var2 = this.f53795e;
            int i2 = b2Var2.Z;
            if (i2 == 63) {
                return z0;
            }
            if (i2 == 64) {
                return A0;
            }
            if (b2Var2.v1 && (originalThreadInfo = b2Var2.u1) != null) {
                if (originalThreadInfo.u) {
                    if (originalThreadInfo.r != null) {
                        return y0;
                    }
                    if (originalThreadInfo.d()) {
                        return x0;
                    }
                    return w0;
                }
                return v0;
            } else if (this.r) {
                return C0;
            } else {
                if (this.w) {
                    return E0;
                }
                if (this.u) {
                    return F0;
                }
                if (this.v) {
                    return G0;
                }
                if (this.t) {
                    return H0;
                }
                if (this.E) {
                    return I0;
                }
                if (this.C) {
                    return K0;
                }
                if (this.B) {
                    return J0;
                }
                if (this.s) {
                    return D0;
                }
                if (this.y) {
                    return L0;
                }
                if (this.z) {
                    return M0;
                }
                if (this.A) {
                    return N0;
                }
                if (this.D) {
                    return O0;
                }
                return s0;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // d.a.p0.a0.e0.b
    public StatisticItem h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (V()) {
                return q(i0);
            }
            if (l.R(this.f53795e)) {
                StatisticItem w = w(q0, true);
                if (w != null && getThreadData() != null) {
                    b2 threadData = getThreadData();
                    if (threadData.J() != null) {
                        w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.J().oriUgcNid);
                        w.param(TiebaStatic.Params.OBJ_PARAM6, threadData.J().oriUgcVid);
                    }
                    w.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                }
                return w;
            }
            StatisticItem t = t(Y, 0);
            if (t != null) {
                t.param("ab_tag", c()).param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                if (getThreadData() != null) {
                    b2 threadData2 = getThreadData();
                    if (threadData2.J() != null) {
                        t.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.J().oriUgcNid);
                    }
                    t.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData2));
                    t.param("nid", threadData2.A0());
                }
            }
            return t;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // d.a.p0.a0.e0.b
    public StatisticItem y() {
        InterceptResult invokeV;
        StatisticItem q;
        SmartApp Z0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (V()) {
                q = q(c0);
            } else if (U()) {
                StatisticItem q2 = q(n0);
                if (q2 != null && getThreadData() != null && (Z0 = getThreadData().Z0()) != null) {
                    TiebaStatic.deleteParamByKey(q2, "obj_type");
                    q2.param("obj_type", Z0.id);
                    q2.param("obj_name", Z0.name);
                }
                return q2;
            } else {
                q = q(X);
                if (q != null) {
                    q.param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                    if (getThreadData() != null) {
                        b2 threadData = getThreadData();
                        if (threadData.J() != null) {
                            q.param(TiebaStatic.Params.OBJ_PARAM4, threadData.J().oriUgcNid);
                        }
                        q.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                    }
                }
            }
            if (q != null && getThreadData() != null) {
                q.param(TiebaStatic.Params.IS_FULL, getThreadData().i2() ? 1 : 0);
            }
            return q;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // d.a.p0.a0.e0.b
    public StatisticItem z() {
        InterceptResult invokeV;
        SmartApp Z0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i2 = 0;
            int i3 = 1;
            if (V()) {
                StatisticItem q = q(b0);
                if (q != null) {
                    q.setPosition(this.position);
                    if (getThreadData() != null) {
                        b2 threadData = getThreadData();
                        if (threadData.p1() != null && (threadData.p1().K() != null || threadData.p1().V() != null)) {
                            i2 = 1;
                        }
                        q.param("obj_name", i2);
                        if (threadData.H() != null) {
                            q.param(TiebaStatic.Params.AB_TYPE, threadData.H().hadConcerned() ? 1 : 0);
                        }
                        q.param(TiebaStatic.Params.IS_FULL, threadData.i2() ? 1 : 0);
                    }
                }
                return q;
            } else if (U()) {
                StatisticItem q2 = q(m0);
                if (q2 != null) {
                    q2.setPosition(this.position);
                    if (getThreadData() != null && (Z0 = getThreadData().Z0()) != null) {
                        TiebaStatic.deleteParamByKey(q2, "obj_type");
                        q2.param("obj_type", Z0.id);
                        q2.param("obj_name", Z0.name);
                    }
                }
                return q2;
            } else if (E()) {
                return null;
            } else {
                StatisticItem q3 = q(W);
                if (q3 != null) {
                    q3.setPosition(this.position);
                    q3.param(TiebaStatic.Params.AB_ACTION, "show");
                    if (getThreadData() != null) {
                        b2 threadData2 = getThreadData();
                        int i4 = (threadData2.p1() == null || (threadData2.p1().K() == null && threadData2.p1().V() == null)) ? 0 : 1;
                        q3.param("obj_name", i4);
                        if (i4 != 0 && threadData2.p1().K() != null && threadData2.p1().K().y() != null && threadData2.p1().K().y().size() > 0) {
                            q3.param(TiebaStatic.Params.OBJ_TO, threadData2.p1().N ? 2 : 1);
                        }
                        if (threadData2.H() != null) {
                            q3.param(TiebaStatic.Params.AB_TYPE, threadData2.H().hadConcerned() ? 1 : 0);
                        }
                        q3.param(TiebaStatic.Params.IS_FULL, threadData2.i2() ? 1 : 0);
                        if (threadData2.J() != null) {
                            q3.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.J().oriUgcNid);
                        }
                        q3.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData2));
                        if (threadData2.C1()) {
                            q3.param(TiebaStatic.Params.OBJ_PARAM6, 2);
                        } else {
                            q3.param(TiebaStatic.Params.OBJ_PARAM6, 1);
                        }
                        if (threadData2.R1()) {
                            q3.param(TiebaStatic.Params.GUA_TYPE, 1);
                        } else if (threadData2.n0() != null) {
                            q3.param(TiebaStatic.Params.GUA_TYPE, 2);
                        } else {
                            q3.param(TiebaStatic.Params.GUA_TYPE, 0);
                        }
                        if (threadData2.H() != null && threadData2.H().getAlaInfo() != null) {
                            int calculateLiveType = YYLiveUtil.calculateLiveType(threadData2.H().getAlaInfo());
                            if (threadData2.H().getAlaInfo().live_status != 1 && threadData2.H().getAlaInfo().friendRoomStatus != 2) {
                                i3 = 2;
                            }
                            if (threadData2.H().getAlaInfo().mYyExtData != null) {
                                TiebaStaticHelper.addYYParam(q3, threadData2.H().getAlaInfo().mYyExtData);
                            }
                            q3.param(TiebaStatic.Params.OBJ_PARAM7, i3);
                            q3.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
                        }
                    }
                }
                return q3;
            }
        }
        return (StatisticItem) invokeV.objValue;
    }
}
