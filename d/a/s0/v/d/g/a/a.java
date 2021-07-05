package d.a.s0.v.d.g.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.s0.v.d.a.c;
import d.a.s0.v.d.g.d.f;
/* loaded from: classes9.dex */
public class a extends d.a.c.k.e.a<d.a.s0.v.d.g.b.a, AlaSubListGameDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public f n;
    public boolean o;
    public d.a.s0.v.d.g.d.a p;
    public int q;
    public int r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.s0.v.d.g.b.a.f67801g);
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

    public final void f0(d.a.s0.v.d.g.b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = this.r;
        if (i2 == 1) {
            if (aVar.f67802e != null) {
                d.a.s0.v.d.d.a c2 = d.a.s0.v.d.d.a.c();
                d.a.s0.v.d.d.a c3 = d.a.s0.v.d.d.a.c();
                int i3 = this.q;
                c cVar = aVar.f67802e;
                c2.a(c3.e(i3, "c12117", cVar.f67433e, cVar.f67434f, cVar.getThreadData()));
            }
            if (aVar.f67803f != null) {
                d.a.s0.v.d.d.a c4 = d.a.s0.v.d.d.a.c();
                d.a.s0.v.d.d.a c5 = d.a.s0.v.d.d.a.c();
                int i4 = this.q;
                c cVar2 = aVar.f67803f;
                c4.a(c5.e(i4, "c12117", cVar2.f67433e, cVar2.f67434f, cVar2.getThreadData()));
            }
        } else if (i2 == 2) {
            c cVar3 = aVar.f67802e;
            if (cVar3 != null && cVar3.getThreadData() != null && aVar.f67802e.getThreadData().g1() != null) {
                b2 threadData = aVar.f67802e.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.g1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.g1().appId).param("locate_type", aVar.f67802e.f67434f));
            }
            c cVar4 = aVar.f67803f;
            if (cVar4 == null || cVar4.getThreadData() == null || aVar.f67803f.getThreadData().g1() == null) {
                return;
            }
            b2 threadData2 = aVar.f67803f.getThreadData();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.g1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.g1().appId).param("locate_type", aVar.f67803f.f67434f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public AlaSubListGameDoubleViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.p = new d.a.s0.v.d.g.d.a(this.m, this.o);
            return new AlaSubListGameDoubleViewHolder(this.p);
        }
        return (AlaSubListGameDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.s0.v.d.g.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, alaSubListGameDoubleViewHolder})) == null) {
            f0(aVar);
            alaSubListGameDoubleViewHolder.f14127a.m(aVar);
            alaSubListGameDoubleViewHolder.f14127a.t(this.n);
            return alaSubListGameDoubleViewHolder.a();
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
