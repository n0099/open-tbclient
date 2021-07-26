package d.a.q0.g1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter;
import com.baidu.tieba.hottopic.adapter.RelateCardForumAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a0.e0.l;
import d.a.q0.g1.c.m;
import d.a.q0.g1.c.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f56853a;

    /* renamed from: b  reason: collision with root package name */
    public i f56854b;

    /* renamed from: c  reason: collision with root package name */
    public g f56855c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f56856d;

    /* renamed from: e  reason: collision with root package name */
    public e f56857e;

    /* renamed from: f  reason: collision with root package name */
    public f f56858f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f56859g;

    /* renamed from: h  reason: collision with root package name */
    public h f56860h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.d.k.e.a> f56861i;

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotTopicActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56861i = new ArrayList();
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotTopicActivity, bdTypeListView) == null) {
            this.f56857e = new e(hotTopicActivity, d.a.q0.g1.c.g.f56965f);
            this.f56854b = new i(hotTopicActivity, m.p);
            this.f56855c = new g(hotTopicActivity, d.a.q0.g1.c.i.p);
            this.f56856d = new RelateCardForumAdapter(hotTopicActivity, n.f56990g);
            TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
            this.f56858f = new f(pageContext, d.a.q0.a0.e0.k.s0);
            this.f56859g = new HomePageVideoThreadAdapter(pageContext, l.X);
            this.f56860h = new h(pageContext, d.a.q0.a0.e0.k.v0);
            this.f56861i.add(this.f56854b);
            this.f56861i.add(this.f56855c);
            this.f56861i.add(this.f56856d);
            this.f56861i.add(this.f56857e);
            this.f56861i.add(this.f56858f);
            this.f56861i.add(this.f56859g);
            this.f56861i.add(this.f56860h);
            this.f56853a = bdTypeListView;
            bdTypeListView.a(this.f56861i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f56853a.getAdapter2() instanceof d.a.d.k.e.e)) {
            this.f56853a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (fVar = this.f56858f) == null) {
            return;
        }
        fVar.setFromCDN(z);
    }

    public void d(d.a.q0.g1.c.e eVar) {
        ArrayList<d.a.d.k.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            if (eVar.i() != null) {
                arrayList = eVar.i();
            } else {
                arrayList = new ArrayList<>();
            }
            BdTypeListView bdTypeListView = this.f56853a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
