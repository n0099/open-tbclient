package d.a.p0.g1.a;

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
import d.a.p0.a0.e0.l;
import d.a.p0.g1.c.m;
import d.a.p0.g1.c.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f56309a;

    /* renamed from: b  reason: collision with root package name */
    public i f56310b;

    /* renamed from: c  reason: collision with root package name */
    public g f56311c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f56312d;

    /* renamed from: e  reason: collision with root package name */
    public e f56313e;

    /* renamed from: f  reason: collision with root package name */
    public f f56314f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f56315g;

    /* renamed from: h  reason: collision with root package name */
    public h f56316h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.k.e.a> f56317i;

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
        this.f56317i = new ArrayList();
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotTopicActivity, bdTypeListView) == null) {
            this.f56313e = new e(hotTopicActivity, d.a.p0.g1.c.g.f56421f);
            this.f56310b = new i(hotTopicActivity, m.p);
            this.f56311c = new g(hotTopicActivity, d.a.p0.g1.c.i.p);
            this.f56312d = new RelateCardForumAdapter(hotTopicActivity, n.f56446g);
            TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
            this.f56314f = new f(pageContext, d.a.p0.a0.e0.k.s0);
            this.f56315g = new HomePageVideoThreadAdapter(pageContext, l.X);
            this.f56316h = new h(pageContext, d.a.p0.a0.e0.k.v0);
            this.f56317i.add(this.f56310b);
            this.f56317i.add(this.f56311c);
            this.f56317i.add(this.f56312d);
            this.f56317i.add(this.f56313e);
            this.f56317i.add(this.f56314f);
            this.f56317i.add(this.f56315g);
            this.f56317i.add(this.f56316h);
            this.f56309a = bdTypeListView;
            bdTypeListView.a(this.f56317i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f56309a.getAdapter2() instanceof d.a.c.k.e.e)) {
            this.f56309a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (fVar = this.f56314f) == null) {
            return;
        }
        fVar.setFromCDN(z);
    }

    public void d(d.a.p0.g1.c.e eVar) {
        ArrayList<d.a.c.k.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            if (eVar.i() != null) {
                arrayList = eVar.i();
            } else {
                arrayList = new ArrayList<>();
            }
            BdTypeListView bdTypeListView = this.f56309a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
