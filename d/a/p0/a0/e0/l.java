package d.a.p0.a0.e0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
/* loaded from: classes7.dex */
public class l extends b implements IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId X;
    public static String Y;
    public static String Z;
    public static String a0;
    public static String b0;
    public static String c0;
    public static String i0;
    public static String j0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean U;
    public boolean V;
    public int W;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431536605, "Ld/a/p0/a0/e0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431536605, "Ld/a/p0/a0/e0/l;");
                return;
            }
        }
        X = BdUniqueId.gen();
        Y = "";
        Z = "";
        a0 = "";
        b0 = "";
        j0 = "";
    }

    public l(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b2Var};
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
        this.W = 0;
        this.f53795e = b2Var;
    }

    public static boolean R(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b2Var)) == null) ? (b2Var == null || b2Var.l1() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // d.a.p0.a0.e0.b
    public StatisticItem B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StatisticItem w = w(b0, true);
            if (getThreadData() != null) {
                b2 threadData = getThreadData();
                if (threadData.J() != null) {
                    w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.J().oriUgcNid);
                    w.param(TiebaStatic.Params.OBJ_PARAM6, threadData.J().oriUgcVid);
                }
                w.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData));
                w.param("nid", threadData.A0());
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
            return true;
        }
        return invokeV.booleanValue;
    }

    public StatisticItem N(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var)) == null) ? O(b2Var, -1) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem O(b2 b2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, b2Var, i2)) == null) {
            StatisticItem w = w(b0, true);
            if (w != null) {
                if (i2 != -1) {
                    w.param(TiebaStatic.Params.CLICK_LOCATE, i2);
                }
                if (getThreadData() != null) {
                    b2 threadData = getThreadData();
                    if (threadData.J() != null) {
                        w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.J().oriUgcNid);
                        w.param(TiebaStatic.Params.OBJ_PARAM6, threadData.J().oriUgcVid);
                    }
                    w.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData));
                }
            }
            return w;
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StatisticItem w = w(j0, true);
            if (w != null && getThreadData() != null) {
                b2 threadData = getThreadData();
                if (threadData.J() != null) {
                    w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.J().oriUgcNid);
                    w.param(TiebaStatic.Params.OBJ_PARAM6, threadData.J().oriUgcVid);
                }
                w.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData));
            }
            return w;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem Q(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, b2Var)) == null) {
            StatisticItem w = w(Y, true);
            if (w != null && getThreadData() != null) {
                b2 threadData = getThreadData();
                if (threadData.J() != null) {
                    w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.J().oriUgcNid);
                    w.param(TiebaStatic.Params.OBJ_PARAM6, threadData.J().oriUgcVid);
                    if (threadData.C1()) {
                        w.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                    } else {
                        w.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    }
                }
                if (threadData.H() != null && threadData.H().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.H().getAlaInfo());
                    if (threadData.H().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(w, threadData.H().getAlaInfo().mYyExtData);
                    }
                    w.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
                }
                w.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData));
            }
            return w;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public int S(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, b2Var)) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            b2 b2Var = this.f53795e;
            if (b2Var != null) {
                statisticItem.param("fid", b2Var.Q());
                statisticItem.param("tid", this.f53795e.n1());
                if (this.f53795e.H1()) {
                    statisticItem.param("obj_type", 8);
                } else if (this.f53795e.G1()) {
                    statisticItem.param("obj_type", 9);
                } else if (this.f53795e.q2()) {
                    statisticItem.param("obj_type", 2);
                }
                statisticItem.param("obj_param1", D() ? 2 : 1);
                if (this.f53795e.H() != null) {
                    statisticItem.param("obj_id", this.f53795e.H().getUserId());
                }
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // d.a.o0.r.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b2 b2Var = this.f53795e;
            if (b2Var == null) {
                return null;
            }
            return b2Var.X0;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.p0.a0.e0.b, d.a.o0.r.q.a
    public b2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b2 b2Var = this.f53795e;
            if (b2Var == null) {
                return null;
            }
            if (b2Var.Q0() != 5) {
                this.f53795e.S3(1);
            }
            return this.f53795e;
        }
        return (b2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b2 b2Var = this.f53795e;
            if (b2Var == null) {
                return k.s0;
            }
            if (this.F) {
                if (this.s) {
                    return b2.P2;
                }
                return b2Var.getType();
            } else if (this.r) {
                return k.C0;
            } else {
                if (this.x) {
                    return X;
                }
                if (this.E) {
                    return k.I0;
                }
                if (this.C) {
                    return k.K0;
                }
                if (this.B) {
                    return k.J0;
                }
                if (this.s) {
                    return k.D0;
                }
                if (this.y) {
                    return k.L0;
                }
                if (this.z) {
                    return k.M0;
                }
                if (this.A) {
                    return k.N0;
                }
                if (this.D) {
                    return k.O0;
                }
                return X;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            b2 b2Var = this.f53795e;
            if (b2Var == null || b2Var.l1() == null || this.f53795e.l1().video_url == null) {
                return null;
            }
            return this.f53795e.l1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.p0.a0.e0.b
    public StatisticItem h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            StatisticItem w = w(Z, true);
            if (w != null && getThreadData() != null) {
                b2 threadData = getThreadData();
                if (threadData.J() != null) {
                    w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.J().oriUgcNid);
                    w.param(TiebaStatic.Params.OBJ_PARAM6, threadData.J().oriUgcVid);
                }
                w.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData));
            }
            return w;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // d.a.p0.a0.e0.b
    public StatisticItem z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i2 = 1;
            StatisticItem w = w(a0, true);
            if (w != null && getThreadData() != null) {
                b2 threadData = getThreadData();
                w.param("obj_name", (threadData.p1() == null || (threadData.p1().K() == null && threadData.p1().V() == null)) ? 0 : 1);
                if (threadData.H() != null) {
                    w.param(TiebaStatic.Params.AB_TYPE, threadData.H().hadConcerned() ? 1 : 0);
                }
                if (threadData.J() != null) {
                    w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.J().oriUgcNid);
                    w.param(TiebaStatic.Params.OBJ_PARAM6, threadData.J().oriUgcVid);
                }
                w.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData));
                if (threadData.C1()) {
                    w.param(TiebaStatic.Params.OBJ_TO, 2);
                } else {
                    w.param(TiebaStatic.Params.OBJ_TO, 1);
                }
                if (threadData.H() != null && threadData.H().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.H().getAlaInfo());
                    if (threadData.H().getAlaInfo().live_status != 1 && threadData.H().getAlaInfo().friendRoomStatus != 2) {
                        i2 = 2;
                    }
                    if (threadData.H().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(w, threadData.H().getAlaInfo().mYyExtData);
                    }
                    w.param(TiebaStatic.Params.OBJ_PARAM7, i2);
                    w.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
                }
            }
            return w;
        }
        return (StatisticItem) invokeV.objValue;
    }
}
