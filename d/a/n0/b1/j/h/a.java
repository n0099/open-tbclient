package d.a.n0.b1.j.h;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.k0;
import d.a.m0.r.q.m;
import d.a.m0.r.q.o1;
import d.a.m0.r.q.s1;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.DataRes;
import tbclient.ActivityPage.HotTopic;
import tbclient.ActivityPage.RecommendForumList;
import tbclient.ActivityPage.RecommendUserList;
import tbclient.ActivityPage.SpecialColumnList;
import tbclient.BannerImage;
import tbclient.Page;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f55579a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f55580b = 1;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<a2> f55581c;

    /* renamed from: d  reason: collision with root package name */
    public m f55582d;

    /* renamed from: e  reason: collision with root package name */
    public k0 f55583e;

    /* renamed from: f  reason: collision with root package name */
    public o1 f55584f;

    /* renamed from: g  reason: collision with root package name */
    public s1 f55585g;

    /* renamed from: h  reason: collision with root package name */
    public b f55586h;

    /* renamed from: i  reason: collision with root package name */
    public SpecialColumnListData f55587i;

    public m a() {
        return this.f55582d;
    }

    public int b() {
        return this.f55580b;
    }

    public k0 c() {
        return this.f55583e;
    }

    public b d() {
        return this.f55586h;
    }

    public o1 e() {
        return this.f55584f;
    }

    public s1 f() {
        return this.f55585g;
    }

    public SpecialColumnListData g() {
        return this.f55587i;
    }

    public ArrayList<a2> h() {
        return this.f55581c;
    }

    public boolean i() {
        return this.f55579a;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Page page = dataRes.page_info;
        if (page != null) {
            this.f55580b = page.current_page.intValue();
            this.f55579a = page.has_more.intValue() == 1;
        }
        this.f55581c = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            a2 a2Var = new a2();
            a2Var.V2(threadInfo);
            a2Var.M1();
            this.f55581c.add(a2Var);
        }
        List<BannerImage> list = dataRes.banner_image;
        if (!ListUtils.isEmpty(list)) {
            m mVar = new m();
            this.f55582d = mVar;
            mVar.parserProtobuf(list);
        }
        List<BannerImage> list2 = dataRes.grid;
        if (ListUtils.getCount(list2) >= 4) {
            k0 k0Var = new k0();
            this.f55583e = k0Var;
            k0Var.parserProtobuf(list2);
        }
        RecommendForumList recommendForumList = dataRes.recommend_forum;
        if (recommendForumList != null && ListUtils.getCount(recommendForumList.forum_list) >= 5) {
            o1 o1Var = new o1();
            this.f55584f = o1Var;
            o1Var.C(recommendForumList.forum_list);
            o1 o1Var2 = this.f55584f;
            o1Var2.j = recommendForumList.class_name;
            o1Var2.floorPosition = recommendForumList.floor_position.intValue();
            this.f55584f.f53766h = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
            this.f55584f.f53767i = R.color.CAM_X0108;
        }
        RecommendUserList recommendUserList = dataRes.recommend_user;
        if (recommendUserList != null && ListUtils.getCount(recommendUserList.user_list) >= 4) {
            s1 s1Var = new s1();
            this.f55585g = s1Var;
            s1Var.A(recommendUserList.user_list);
            this.f55585g.floorPosition = recommendUserList.floor_position.intValue();
            this.f55585g.f53797e = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
            this.f55585g.f53798f = R.color.CAM_X0108;
        }
        HotTopic hotTopic = dataRes.hot_topic;
        if (hotTopic != null && ListUtils.getCount(hotTopic.topic_list) >= 4) {
            b bVar = new b();
            this.f55586h = bVar;
            bVar.B(hotTopic);
        }
        SpecialColumnList specialColumnList = dataRes.special_column;
        if (specialColumnList == null || ListUtils.getCount(specialColumnList.item_list) < 3) {
            return;
        }
        SpecialColumnListData specialColumnListData = new SpecialColumnListData();
        this.f55587i = specialColumnListData;
        specialColumnListData.C(specialColumnList);
    }
}
