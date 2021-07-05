package d.a.s0.g1.a;

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
import d.a.s0.a0.e0.l;
import d.a.s0.g1.c.m;
import d.a.s0.g1.c.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f59567a;

    /* renamed from: b  reason: collision with root package name */
    public i f59568b;

    /* renamed from: c  reason: collision with root package name */
    public g f59569c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f59570d;

    /* renamed from: e  reason: collision with root package name */
    public e f59571e;

    /* renamed from: f  reason: collision with root package name */
    public f f59572f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f59573g;

    /* renamed from: h  reason: collision with root package name */
    public h f59574h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59575i;

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
        this.f59575i = new ArrayList();
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotTopicActivity, bdTypeListView) == null) {
            this.f59571e = new e(hotTopicActivity, d.a.s0.g1.c.g.f59679f);
            this.f59568b = new i(hotTopicActivity, m.p);
            this.f59569c = new g(hotTopicActivity, d.a.s0.g1.c.i.p);
            this.f59570d = new RelateCardForumAdapter(hotTopicActivity, n.f59704g);
            TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
            this.f59572f = new f(pageContext, d.a.s0.a0.e0.k.s0);
            this.f59573g = new HomePageVideoThreadAdapter(pageContext, l.X);
            this.f59574h = new h(pageContext, d.a.s0.a0.e0.k.v0);
            this.f59575i.add(this.f59568b);
            this.f59575i.add(this.f59569c);
            this.f59575i.add(this.f59570d);
            this.f59575i.add(this.f59571e);
            this.f59575i.add(this.f59572f);
            this.f59575i.add(this.f59573g);
            this.f59575i.add(this.f59574h);
            this.f59567a = bdTypeListView;
            bdTypeListView.a(this.f59575i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f59567a.getAdapter2() instanceof d.a.c.k.e.e)) {
            this.f59567a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (fVar = this.f59572f) == null) {
            return;
        }
        fVar.setFromCDN(z);
    }

    public void d(d.a.s0.g1.c.e eVar) {
        ArrayList<d.a.c.k.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            if (eVar.i() != null) {
                arrayList = eVar.i();
            } else {
                arrayList = new ArrayList<>();
            }
            BdTypeListView bdTypeListView = this.f59567a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
