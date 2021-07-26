package d.a.q0.v.d.g.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListLiveDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import d.a.q0.v.d.a.c;
import d.a.q0.v.d.g.d.d;
import d.a.q0.v.d.g.d.f;
/* loaded from: classes8.dex */
public class b extends d.a.d.k.e.a<d.a.q0.v.d.g.b.b, AlaSubListLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public f n;
    public boolean o;
    public d p;
    public int q;
    public int r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.q0.v.d.g.b.b.f65231g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.m = tbPageContext;
    }

    public final void e0(d.a.q0.v.d.g.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        int i2 = this.r;
        if (i2 == 1) {
            if (bVar.f65232e != null) {
                d.a.q0.v.d.d.a c2 = d.a.q0.v.d.d.a.c();
                d.a.q0.v.d.d.a c3 = d.a.q0.v.d.d.a.c();
                int i3 = this.q;
                c cVar = bVar.f65232e;
                c2.a(c3.e(i3, "c12117", cVar.f64860e, cVar.f64861f, cVar.getThreadData()));
            }
            if (bVar.f65233f != null) {
                d.a.q0.v.d.d.a c4 = d.a.q0.v.d.d.a.c();
                d.a.q0.v.d.d.a c5 = d.a.q0.v.d.d.a.c();
                int i4 = this.q;
                c cVar2 = bVar.f65233f;
                c4.a(c5.e(i4, "c12117", cVar2.f64860e, cVar2.f64861f, cVar2.getThreadData()));
            }
        } else if (i2 == 2) {
            c cVar3 = bVar.f65232e;
            if (cVar3 != null && cVar3.getThreadData() != null && bVar.f65232e.getThreadData().h1() != null) {
                b2 threadData = bVar.f65232e.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.h1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.h1().appId).param("locate_type", bVar.f65232e.f64861f));
            }
            c cVar4 = bVar.f65233f;
            if (cVar4 == null || cVar4.getThreadData() == null || bVar.f65233f.getThreadData().h1() == null) {
                return;
            }
            b2 threadData2 = bVar.f65233f.getThreadData();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.h1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.h1().appId).param("locate_type", bVar.f65233f.f64861f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: f0 */
    public AlaSubListLiveDoubleViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.p = new d(this.m, this.o);
            return new AlaSubListLiveDoubleViewHolder(this.p);
        }
        return (AlaSubListLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.v.d.g.b.b bVar, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, alaSubListLiveDoubleViewHolder})) == null) {
            e0(bVar);
            alaSubListLiveDoubleViewHolder.f14215a.l(bVar);
            alaSubListLiveDoubleViewHolder.f14215a.s(this.n);
            return alaSubListLiveDoubleViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.r = i2;
        }
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.q = i2;
        }
    }

    public void k0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }
}
