package d.a.q0.n2.p;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import d.a.d.e.p.k;
import d.a.p0.s.q.b2;
import d.a.q0.n2.h;
import d.a.q0.n2.o;
import d.a.q0.x1.j;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f61435a;

    /* renamed from: b  reason: collision with root package name */
    public long f61436b;

    /* renamed from: c  reason: collision with root package name */
    public long f61437c;

    /* renamed from: d  reason: collision with root package name */
    public b2 f61438d;

    /* renamed from: e  reason: collision with root package name */
    public o f61439e;

    /* renamed from: f  reason: collision with root package name */
    public String f61440f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61441g;

    /* renamed from: h  reason: collision with root package name */
    public j f61442h;

    public b() {
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
        this.f61435a = 0L;
        this.f61436b = 0L;
        this.f61440f = "1";
        this.f61442h = new j();
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j = this.f61437c;
            float f2 = ((float) this.f61435a) / ((float) j);
            return j <= 60000 ? ((double) f2) >= 0.9d : j <= 180000 ? ((double) f2) >= 0.8d : j <= TTAdConstant.AD_MAX_EVENT_TIME ? ((double) f2) >= 0.7d : ((double) f2) >= 0.6d;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f61436b <= 0) {
            return;
        }
        this.f61435a += System.currentTimeMillis() - this.f61436b;
        this.f61436b = 0L;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f61436b > 0) {
                this.f61435a += System.currentTimeMillis() - this.f61436b;
                this.f61436b = 0L;
            }
            this.f61441g = false;
        }
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbCyberVideoView) == null) {
            this.f61442h.d(tbCyberVideoView);
        }
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f61437c = j;
            this.f61442h.c();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f61442h.e();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f61436b != 0) {
                this.f61435a += System.currentTimeMillis() - this.f61436b;
            }
            this.f61436b = System.currentTimeMillis();
            this.f61441g = true;
            this.f61442h.b();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f61436b > 0) {
                this.f61435a += System.currentTimeMillis() - this.f61436b;
                this.f61436b = 0L;
            }
            i();
            this.f61435a = 0L;
            this.f61436b = 0L;
            this.f61441g = false;
            this.f61442h.a();
        }
    }

    public final void i() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            long j = this.f61435a;
            if (j < 0 || j >= 86400000) {
                return;
            }
            if (j > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f61435a);
                statisticItem.param("obj_type", this.f61440f);
                statisticItem.param("playduration", this.f61437c);
                statisticItem.param("player_type", 1);
                statisticItem.param("is_finish", a() ? 1 : 0);
                if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                o oVar = this.f61439e;
                if (oVar != null) {
                    oVar.a(statisticItem);
                }
                if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (b2Var = this.f61438d) != null) {
                    if (b2Var.J() != null) {
                        if (this.f61438d.J().oriUgcType == 2) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                        } else if (this.f61438d.J().oriUgcType == 4) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        }
                    } else {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                }
                b2 b2Var2 = this.f61438d;
                if (b2Var2 != null) {
                    statisticItem.param(TiebaStatic.Params.IS_ZP, b2Var2.w2() ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
                h.d(this.f61435a, this.f61440f, this.f61439e, "", this.f61437c);
            } else if (this.f61441g) {
                h.d(j, this.f61440f, this.f61439e, "", this.f61437c);
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f61440f = str;
        }
    }

    public void k(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, b2Var) == null) {
            this.f61438d = b2Var;
        }
    }

    public void l(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, oVar) == null) {
            this.f61439e = oVar;
        }
    }
}
