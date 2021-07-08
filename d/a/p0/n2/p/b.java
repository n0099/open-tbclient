package d.a.p0.n2.p;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.o0.r.q.b2;
import d.a.p0.n2.h;
import d.a.p0.n2.o;
import d.a.p0.x1.j;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f60821a;

    /* renamed from: b  reason: collision with root package name */
    public long f60822b;

    /* renamed from: c  reason: collision with root package name */
    public long f60823c;

    /* renamed from: d  reason: collision with root package name */
    public b2 f60824d;

    /* renamed from: e  reason: collision with root package name */
    public o f60825e;

    /* renamed from: f  reason: collision with root package name */
    public String f60826f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60827g;

    /* renamed from: h  reason: collision with root package name */
    public j f60828h;

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
        this.f60821a = 0L;
        this.f60822b = 0L;
        this.f60826f = "1";
        this.f60828h = new j();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60822b <= 0) {
            return;
        }
        this.f60821a += System.currentTimeMillis() - this.f60822b;
        this.f60822b = 0L;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f60822b > 0) {
                this.f60821a += System.currentTimeMillis() - this.f60822b;
                this.f60822b = 0L;
            }
            this.f60827g = false;
        }
    }

    public void c(TbCyberVideoView tbCyberVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbCyberVideoView) == null) {
            this.f60828h.d(tbCyberVideoView);
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f60823c = j;
            this.f60828h.c();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f60828h.e();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f60822b != 0) {
                this.f60821a += System.currentTimeMillis() - this.f60822b;
            }
            this.f60822b = System.currentTimeMillis();
            this.f60827g = true;
            this.f60828h.b();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f60822b > 0) {
                this.f60821a += System.currentTimeMillis() - this.f60822b;
                this.f60822b = 0L;
            }
            h();
            this.f60821a = 0L;
            this.f60822b = 0L;
            this.f60827g = false;
            this.f60828h.a();
        }
    }

    public final void h() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            long j = this.f60821a;
            if (j < 0 || j >= 86400000) {
                return;
            }
            if (j > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f60821a);
                statisticItem.param("obj_type", this.f60826f);
                statisticItem.param("playduration", this.f60823c);
                statisticItem.param("player_type", 1);
                if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                o oVar = this.f60825e;
                if (oVar != null) {
                    oVar.a(statisticItem);
                }
                if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (b2Var = this.f60824d) != null) {
                    if (b2Var.J() != null) {
                        if (this.f60824d.J().oriUgcType == 2) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                        } else if (this.f60824d.J().oriUgcType == 4) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        }
                    } else {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                }
                b2 b2Var2 = this.f60824d;
                if (b2Var2 != null) {
                    statisticItem.param(TiebaStatic.Params.IS_ZP, b2Var2.u2() ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
                h.d(this.f60821a, this.f60826f, this.f60825e, "", this.f60823c);
            } else if (this.f60827g) {
                h.d(j, this.f60826f, this.f60825e, "", this.f60823c);
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f60826f = str;
        }
    }

    public void j(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, b2Var) == null) {
            this.f60824d = b2Var;
        }
    }

    public void k(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, oVar) == null) {
            this.f60825e = oVar;
        }
    }
}
