package d.a.s0.l0.k.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.s0.a0.b0;
import d.a.s0.l0.k.c.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62934a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62935b;

    /* renamed from: c  reason: collision with root package name */
    public s f62936c;

    /* renamed from: d  reason: collision with root package name */
    public b f62937d;

    /* renamed from: e  reason: collision with root package name */
    public c f62938e;

    /* renamed from: f  reason: collision with root package name */
    public d f62939f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f62940g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f62941h;

    /* renamed from: d.a.s0.l0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1568a extends b0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f62942b;

        public C1568a(a aVar) {
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
            this.f62942b = aVar;
        }

        @Override // d.a.s0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof d.a.s0.l0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((d.a.s0.l0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f62942b.f62940g) {
                    if (nVar instanceof d.a.s0.l0.k.c.d) {
                        d.a.s0.l0.k.c.d dVar = (d.a.s0.l0.k.c.d) nVar;
                        if (title.equals(dVar.getTitle())) {
                            List<d.a.s0.l0.k.c.c> o = dVar.o();
                            arrayList.add(nVar);
                            arrayList.addAll(o);
                        } else {
                            List<d.a.s0.l0.k.c.c> j = dVar.j();
                            arrayList.add(nVar);
                            arrayList.addAll(j);
                        }
                    }
                }
                e eVar = new e();
                eVar.f62965e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f62942b.f62936c.setData(arrayList);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62941h = new C1568a(this);
        this.f62934a = tbPageContext;
        this.f62936c = sVar;
        c();
        this.f62936c.a(this.f62935b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62935b = new ArrayList();
            b bVar = new b(this.f62934a);
            this.f62937d = bVar;
            this.f62935b.add(bVar);
            c cVar = new c(this.f62934a, this.f62941h);
            this.f62938e = cVar;
            this.f62935b.add(cVar);
            d dVar = new d(this.f62934a);
            this.f62939f = dVar;
            this.f62935b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f62936c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f62940g = list;
            this.f62936c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (d.a.c.k.e.a aVar : this.f62935b) {
                aVar.c0(bdUniqueId);
            }
        }
    }
}
