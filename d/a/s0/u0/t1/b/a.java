package d.a.s0.u0.t1.b;

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
import d.a.s0.a0.b0;
import d.a.s0.g0.h;
import d.a.s0.u0.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f67025a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f67026b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f67027c;

    /* renamed from: d  reason: collision with root package name */
    public String f67028d;

    /* renamed from: e  reason: collision with root package name */
    public String f67029e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f67030f;

    /* renamed from: d.a.s0.u0.t1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1769a extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f67031b;

        public C1769a(a aVar) {
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
            this.f67031b = aVar;
        }

        @Override // d.a.s0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) {
                super.a(view, baseCardInfo);
                this.f67031b.b();
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
        this.f67030f = new C1769a(this);
        this.f67025a = tbPageContext;
        this.f67026b = bdTypeListView;
        this.f67028d = str;
        this.f67029e = str2;
        this.f67027c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.f67025a, this.f67028d, this.f67029e);
            bVar.k0(this.f67030f);
            this.f67027c.add(bVar);
            c cVar = new c(this.f67025a, this.f67028d);
            cVar.k0(this.f67030f);
            this.f67027c.add(cVar);
            this.f67027c.add(new f(this.f67025a, this.f67028d));
            this.f67027c.add(new e(this.f67025a, this.f67028d));
            List<d.a.c.k.e.a> list = this.f67027c;
            TbPageContext tbPageContext = this.f67025a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, h.f59555f, tbPageContext.getUniqueId(), this.f67028d));
            d dVar = new d(this.f67025a, this.f67028d);
            dVar.i0(this.f67030f);
            this.f67027c.add(dVar);
            List<d.a.c.k.e.a> list2 = this.f67027c;
            TbPageContext tbPageContext2 = this.f67025a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, d.a.s0.g0.c.f59545f, tbPageContext2.getUniqueId(), this.f67028d));
            List<d.a.c.k.e.a> list3 = this.f67027c;
            TbPageContext tbPageContext3 = this.f67025a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, d.a.s0.g0.f.f59551f, tbPageContext3.getUniqueId(), this.f67028d));
            TbPageContext tbPageContext4 = this.f67025a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, w.f67163i, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.z0();
            frsUserRecommendAdapter.y0(this.f67028d);
            this.f67027c.add(frsUserRecommendAdapter);
            this.f67026b.a(this.f67027c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f67026b.getAdapter2() instanceof d.a.c.k.e.e)) {
            this.f67026b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f67026b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
