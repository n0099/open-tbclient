package d.a.n0.b1.i.e;

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
    public boolean f51893a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f51894b = 1;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<a2> f51895c;

    /* renamed from: d  reason: collision with root package name */
    public m f51896d;

    /* renamed from: e  reason: collision with root package name */
    public k0 f51897e;

    /* renamed from: f  reason: collision with root package name */
    public o1 f51898f;

    /* renamed from: g  reason: collision with root package name */
    public s1 f51899g;

    /* renamed from: h  reason: collision with root package name */
    public b f51900h;

    /* renamed from: i  reason: collision with root package name */
    public SpecialColumnListData f51901i;

    public m a() {
        return this.f51896d;
    }

    public int b() {
        return this.f51894b;
    }

    public k0 c() {
        return this.f51897e;
    }

    public b d() {
        return this.f51900h;
    }

    public o1 e() {
        return this.f51898f;
    }

    public s1 f() {
        return this.f51899g;
    }

    public SpecialColumnListData g() {
        return this.f51901i;
    }

    public ArrayList<a2> h() {
        return this.f51895c;
    }

    public boolean i() {
        return this.f51893a;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Page page = dataRes.page_info;
        if (page != null) {
            this.f51894b = page.current_page.intValue();
            this.f51893a = page.has_more.intValue() == 1;
        }
        this.f51895c = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            a2 a2Var = new a2();
            a2Var.U2(threadInfo);
            a2Var.L1();
            this.f51895c.add(a2Var);
        }
        List<BannerImage> list = dataRes.banner_image;
        if (!ListUtils.isEmpty(list)) {
            m mVar = new m();
            this.f51896d = mVar;
            mVar.parserProtobuf(list);
        }
        List<BannerImage> list2 = dataRes.grid;
        if (ListUtils.getCount(list2) >= 4) {
            k0 k0Var = new k0();
            this.f51897e = k0Var;
            k0Var.parserProtobuf(list2);
        }
        RecommendForumList recommendForumList = dataRes.recommend_forum;
        if (recommendForumList != null && ListUtils.getCount(recommendForumList.forum_list) >= 5) {
            o1 o1Var = new o1();
            this.f51898f = o1Var;
            o1Var.C(recommendForumList.forum_list);
            o1 o1Var2 = this.f51898f;
            o1Var2.j = recommendForumList.class_name;
            o1Var2.floorPosition = recommendForumList.floor_position.intValue();
            this.f51898f.f50090h = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
            this.f51898f.f50091i = R.color.CAM_X0108;
        }
        RecommendUserList recommendUserList = dataRes.recommend_user;
        if (recommendUserList != null && ListUtils.getCount(recommendUserList.user_list) >= 4) {
            s1 s1Var = new s1();
            this.f51899g = s1Var;
            s1Var.A(recommendUserList.user_list);
            this.f51899g.floorPosition = recommendUserList.floor_position.intValue();
            this.f51899g.f50121e = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
            this.f51899g.f50122f = R.color.CAM_X0108;
        }
        HotTopic hotTopic = dataRes.hot_topic;
        if (hotTopic != null && ListUtils.getCount(hotTopic.topic_list) >= 4) {
            b bVar = new b();
            this.f51900h = bVar;
            bVar.B(hotTopic);
        }
        SpecialColumnList specialColumnList = dataRes.special_column;
        if (specialColumnList == null || ListUtils.getCount(specialColumnList.item_list) < 3) {
            return;
        }
        SpecialColumnListData specialColumnListData = new SpecialColumnListData();
        this.f51901i = specialColumnListData;
        specialColumnListData.C(specialColumnList);
    }
}
