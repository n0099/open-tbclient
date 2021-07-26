package d.a.e.l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.adapter.AdCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.e.d;
import d.a.q0.n1.o.l.f;
import d.a.q0.n1.o.l.h;
import d.a.q0.n1.o.l.j;
import d.a.q0.u0.p2.c;
import d.a.q0.w2.i0.e;
import d.a.q0.w2.i0.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends d.a.d.k.e.a<d, AdCardViewHolder> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ICardInfo m;
    public d n;
    public TbPageContext o;
    public d.a.q0.u0.h1.a p;
    public c q;
    public j r;
    public List<j> s;
    public f t;

    /* renamed from: d.a.e.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0577a implements d.a.q0.n1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42494a;

        public C0577a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42494a = aVar;
        }

        @Override // d.a.q0.n1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) {
                a aVar = this.f42494a;
                aVar.j0(aVar.n, this.f42494a.n.e());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, d.a.q0.u0.h1.a aVar, c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, aVar, cVar, fVar};
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
        this.s = new ArrayList();
        this.o = tbPageContext;
        this.p = aVar;
        this.q = cVar;
        this.t = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public View I(int i2, View view, ViewGroup viewGroup, d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar})) == null) {
            this.n = dVar;
            this.m = dVar.h();
            return super.I(i2, view, viewGroup, dVar);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.q0.n1.o.l.f
    public void h(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.r = jVar;
            f fVar = this.t;
            if (fVar != null) {
                fVar.h(jVar);
            }
        }
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j jVar = this.r;
            if (jVar != null) {
                return jVar.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j0(d dVar, int i2) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, dVar, i2) == null) || dVar == null) {
            return;
        }
        AdvertAppInfo q = dVar.q();
        int i3 = 2;
        if (q != null && (iLegoAdvert = q.Z3) != null && iLegoAdvert.forFree()) {
            i3 = 102;
        }
        e.b().d(g.b(q, i3, i2));
        d.a.q0.n1.o.h.c.h(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: k0 */
    public AdCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        d.a.q0.n1.o.l.e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            if (this.m == null || (a2 = d.a.q0.n1.o.b.h().a(this.o, this.m, 2)) == null) {
                return null;
            }
            if (a2 instanceof j) {
                this.s.add((j) a2);
            }
            a2.setAfterClickSchemeListener(new C0577a(this));
            return new AdCardViewHolder(a2);
        }
        return (AdCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: l0 */
    public AdCardViewHolder R(ViewGroup viewGroup, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, viewGroup, dVar)) == null) {
            if (dVar == null || dVar.h() == null) {
                return null;
            }
            this.n = dVar;
            this.m = dVar.h();
            return Q(viewGroup);
        }
        return (AdCardViewHolder) invokeLL.objValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            for (j jVar : this.s) {
                if (jVar != null) {
                    jVar.onDestroy();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: n0 */
    public View X(int i2, View view, ViewGroup viewGroup, d dVar, AdCardViewHolder adCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, adCardViewHolder})) == null) {
            if (dVar == null || adCardViewHolder == null) {
                return null;
            }
            if (adCardViewHolder.b() instanceof h) {
                h hVar = (h) adCardViewHolder.b();
                hVar.setAutoPlayCallBack(this.p);
                hVar.setOnVideoContainerForegroundClickListener(this.q);
                hVar.setCurrentPlayCallBack(this);
            }
            dVar.o();
            if (adCardViewHolder.b() != null) {
                adCardViewHolder.b().setPosition(i2);
                adCardViewHolder.b().h(dVar.h());
            }
            return adCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void o0() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (jVar = this.r) == null) {
            return;
        }
        jVar.pausePlay();
    }

    public void p0() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (jVar = this.r) == null) {
            return;
        }
        jVar.stopPlay();
    }
}
