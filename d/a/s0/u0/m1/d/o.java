package d.a.s0.u0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
/* loaded from: classes9.dex */
public class o extends d.a.s0.u0.k<a2, FrsCardVideoViewHolder<d.a.s0.u0.m1.g.b>> implements d.a.s0.a0.z, d.a.s0.u0.j2.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int B = 5;
    public static int C = 10;
    public static int D = 15;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.s0.a0.b0<b2> A;
    public TbPageContext<?> x;
    public String y;
    public d.a.s0.u0.j2.b z;

    /* loaded from: classes9.dex */
    public class a extends d.a.s0.a0.b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f66351b;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66351b = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) || view == null || b2Var == null) {
                return;
            }
            if (view.getId() == R.id.frame_video) {
                this.f66351b.B0(b2Var, "c11718");
            } else if (view.getId() == R.id.layout_root) {
                this.f66351b.B0(b2Var, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                this.f66351b.B0(b2Var, "c10241");
            } else if (view.getId() == R.id.card_divider_tv) {
                d.a.s0.u0.n2.l.a(this.f66351b.z, b2Var.getRecomReason());
            }
            if (view.getId() != R.id.card_home_page_normal_thread_user_name && !(view instanceof HeadImageView) && !(view instanceof HeadPendantView)) {
                if (view.getId() == R.id.frame_video) {
                    d.a.s0.u0.j2.a.c(b2Var, 4, this.f66351b.f44825i, this.f66351b.z, this.f66351b.g0());
                    return;
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.s0.u0.j2.a.c(b2Var, 5, this.f66351b.f44825i, this.f66351b.z, this.f66351b.g0());
                    return;
                } else {
                    d.a.s0.u0.j2.a.c(b2Var, 1, this.f66351b.f44825i, this.f66351b.z, this.f66351b.g0());
                    return;
                }
            }
            d.a.s0.u0.j2.a.c(b2Var, 2, this.f66351b.f44825i, this.f66351b.z, this.f66351b.g0());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(412782811, "Ld/a/s0/u0/m1/d/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(412782811, "Ld/a/s0/u0/m1/d/o;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z = new d.a.s0.u0.j2.b();
        this.A = new a(this);
        this.x = tbPageContext;
    }

    public final void B0(b2 b2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, b2Var, str) == null) || b2Var == null) {
            return;
        }
        int e0 = b2Var.e0();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", C0(e0));
        statisticItem.param("tid", b2Var.n1());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }

    public final String C0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 == B ? "3" : i2 == C ? "10" : i2 == D ? "11" : "" : (String) invokeI.objValue;
    }

    public final d.a.s0.n2.o D0(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var)) == null) {
            if (b2Var != null) {
                d.a.s0.n2.o oVar = new d.a.s0.n2.o();
                oVar.f64043a = C0(b2Var.e0());
                oVar.f64046d = this.z.f66177c;
                oVar.f64045c = b2Var.n1();
                oVar.l = b2Var.V0;
                if (b2Var.l1() != null) {
                    oVar.m = b2Var.l1().video_md5;
                }
                b2Var.q4();
                return oVar;
            }
            return null;
        }
        return (d.a.s0.n2.o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: E0 */
    public FrsCardVideoViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            d.a.s0.u0.m1.g.b bVar = new d.a.s0.u0.m1.g.b(this.x, this.f44825i);
            bVar.Z(this.f44825i);
            bVar.a(this.y);
            return new FrsCardVideoViewHolder(bVar);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.u0.k, d.a.c.k.e.a
    /* renamed from: F0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, a2Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.b() == null) {
                return null;
            }
            frsCardVideoViewHolder.b().g0(D0(a2Var.w));
            frsCardVideoViewHolder.b().m(a2Var.w);
            frsCardVideoViewHolder.b().o(this.A);
            d.a.s0.u0.j2.a.j(a2Var.w, this.f44825i, this.z, g0());
            return frsCardVideoViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.s0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.y = str;
        }
    }

    @Override // d.a.s0.u0.j2.d
    public d.a.s0.u0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.z : (d.a.s0.u0.j2.b) invokeV.objValue;
    }

    @Override // d.a.s0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }
}
