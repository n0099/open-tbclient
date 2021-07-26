package d.a.q0.u0.t1.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.q0.a0.b0;
import d.a.q0.g0.h;
import d.a.q0.u0.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64453a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f64454b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.d.k.e.a> f64455c;

    /* renamed from: d  reason: collision with root package name */
    public String f64456d;

    /* renamed from: e  reason: collision with root package name */
    public String f64457e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f64458f;

    /* renamed from: d.a.q0.u0.t1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1731a extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f64459b;

        public C1731a(a aVar) {
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
            this.f64459b = aVar;
        }

        @Override // d.a.q0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f64459b.b();
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64458f = new C1731a(this);
        this.f64453a = tbPageContext;
        this.f64454b = bdTypeListView;
        this.f64456d = str;
        this.f64457e = str2;
        this.f64455c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.f64453a, this.f64456d, this.f64457e);
            bVar.k0(this.f64458f);
            this.f64455c.add(bVar);
            c cVar = new c(this.f64453a, this.f64456d);
            cVar.k0(this.f64458f);
            this.f64455c.add(cVar);
            this.f64455c.add(new f(this.f64453a, this.f64456d));
            this.f64455c.add(new e(this.f64453a, this.f64456d));
            List<d.a.d.k.e.a> list = this.f64455c;
            TbPageContext tbPageContext = this.f64453a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f56841f, tbPageContext.getUniqueId(), this.f64456d));
            d dVar = new d(this.f64453a, this.f64456d);
            dVar.i0(this.f64458f);
            this.f64455c.add(dVar);
            List<d.a.d.k.e.a> list2 = this.f64455c;
            TbPageContext tbPageContext2 = this.f64453a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, d.a.q0.g0.c.f56831f, tbPageContext2.getUniqueId(), this.f64456d));
            List<d.a.d.k.e.a> list3 = this.f64455c;
            TbPageContext tbPageContext3 = this.f64453a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, d.a.q0.g0.f.f56837f, tbPageContext3.getUniqueId(), this.f64456d));
            TbPageContext tbPageContext4 = this.f64453a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f64591i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.z0();
            frsUserRecommendAdapter.x0(this.f64456d);
            this.f64455c.add(frsUserRecommendAdapter);
            this.f64454b.a(this.f64455c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f64454b.getAdapter2() instanceof d.a.d.k.e.e)) {
            this.f64454b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f64454b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
