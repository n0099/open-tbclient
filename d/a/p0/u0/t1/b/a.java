package d.a.p0.u0.t1.b;

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
import d.a.c.k.e.n;
import d.a.p0.a0.b0;
import d.a.p0.g0.h;
import d.a.p0.u0.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63808a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f63809b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f63810c;

    /* renamed from: d  reason: collision with root package name */
    public String f63811d;

    /* renamed from: e  reason: collision with root package name */
    public String f63812e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f63813f;

    /* renamed from: d.a.p0.u0.t1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1728a extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f63814b;

        public C1728a(a aVar) {
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
            this.f63814b = aVar;
        }

        @Override // d.a.p0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f63814b.b();
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
        this.f63813f = new C1728a(this);
        this.f63808a = tbPageContext;
        this.f63809b = bdTypeListView;
        this.f63811d = str;
        this.f63812e = str2;
        this.f63810c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.f63808a, this.f63811d, this.f63812e);
            bVar.k0(this.f63813f);
            this.f63810c.add(bVar);
            c cVar = new c(this.f63808a, this.f63811d);
            cVar.k0(this.f63813f);
            this.f63810c.add(cVar);
            this.f63810c.add(new f(this.f63808a, this.f63811d));
            this.f63810c.add(new e(this.f63808a, this.f63811d));
            List<d.a.c.k.e.a> list = this.f63810c;
            TbPageContext tbPageContext = this.f63808a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f56297f, tbPageContext.getUniqueId(), this.f63811d));
            d dVar = new d(this.f63808a, this.f63811d);
            dVar.i0(this.f63813f);
            this.f63810c.add(dVar);
            List<d.a.c.k.e.a> list2 = this.f63810c;
            TbPageContext tbPageContext2 = this.f63808a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, d.a.p0.g0.c.f56287f, tbPageContext2.getUniqueId(), this.f63811d));
            List<d.a.c.k.e.a> list3 = this.f63810c;
            TbPageContext tbPageContext3 = this.f63808a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, d.a.p0.g0.f.f56293f, tbPageContext3.getUniqueId(), this.f63811d));
            TbPageContext tbPageContext4 = this.f63808a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f63946i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.z0();
            frsUserRecommendAdapter.y0(this.f63811d);
            this.f63810c.add(frsUserRecommendAdapter);
            this.f63809b.a(this.f63810c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f63809b.getAdapter2() instanceof d.a.c.k.e.e)) {
            this.f63809b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f63809b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
