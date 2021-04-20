package d.b.i0.a1.i.e;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.k0;
import d.b.h0.r.q.m;
import d.b.h0.r.q.o1;
import d.b.h0.r.q.s1;
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
    public boolean f52887a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f52888b = 1;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<a2> f52889c;

    /* renamed from: d  reason: collision with root package name */
    public m f52890d;

    /* renamed from: e  reason: collision with root package name */
    public k0 f52891e;

    /* renamed from: f  reason: collision with root package name */
    public o1 f52892f;

    /* renamed from: g  reason: collision with root package name */
    public s1 f52893g;

    /* renamed from: h  reason: collision with root package name */
    public b f52894h;
    public SpecialColumnListData i;

    public m a() {
        return this.f52890d;
    }

    public int b() {
        return this.f52888b;
    }

    public k0 c() {
        return this.f52891e;
    }

    public b d() {
        return this.f52894h;
    }

    public o1 e() {
        return this.f52892f;
    }

    public s1 f() {
        return this.f52893g;
    }

    public SpecialColumnListData g() {
        return this.i;
    }

    public ArrayList<a2> h() {
        return this.f52889c;
    }

    public boolean i() {
        return this.f52887a;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Page page = dataRes.page_info;
        if (page != null) {
            this.f52888b = page.current_page.intValue();
            this.f52887a = page.has_more.intValue() == 1;
        }
        this.f52889c = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            a2 a2Var = new a2();
            a2Var.R2(threadInfo);
            a2Var.J1();
            this.f52889c.add(a2Var);
        }
        List<BannerImage> list = dataRes.banner_image;
        if (!ListUtils.isEmpty(list)) {
            m mVar = new m();
            this.f52890d = mVar;
            mVar.parserProtobuf(list);
        }
        List<BannerImage> list2 = dataRes.grid;
        if (ListUtils.getCount(list2) >= 4) {
            k0 k0Var = new k0();
            this.f52891e = k0Var;
            k0Var.parserProtobuf(list2);
        }
        RecommendForumList recommendForumList = dataRes.recommend_forum;
        if (recommendForumList != null && ListUtils.getCount(recommendForumList.forum_list) >= 5) {
            o1 o1Var = new o1();
            this.f52892f = o1Var;
            o1Var.C(recommendForumList.forum_list);
            o1 o1Var2 = this.f52892f;
            o1Var2.j = recommendForumList.class_name;
            o1Var2.floorPosition = recommendForumList.floor_position.intValue();
            this.f52892f.f51261h = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
            this.f52892f.i = R.color.CAM_X0108;
        }
        RecommendUserList recommendUserList = dataRes.recommend_user;
        if (recommendUserList != null && ListUtils.getCount(recommendUserList.user_list) >= 4) {
            s1 s1Var = new s1();
            this.f52893g = s1Var;
            s1Var.A(recommendUserList.user_list);
            this.f52893g.floorPosition = recommendUserList.floor_position.intValue();
            this.f52893g.f51289e = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
            this.f52893g.f51290f = R.color.CAM_X0108;
        }
        HotTopic hotTopic = dataRes.hot_topic;
        if (hotTopic != null && ListUtils.getCount(hotTopic.topic_list) >= 4) {
            b bVar = new b();
            this.f52894h = bVar;
            bVar.B(hotTopic);
        }
        SpecialColumnList specialColumnList = dataRes.special_column;
        if (specialColumnList == null || ListUtils.getCount(specialColumnList.item_list) < 3) {
            return;
        }
        SpecialColumnListData specialColumnListData = new SpecialColumnListData();
        this.i = specialColumnListData;
        specialColumnListData.C(specialColumnList);
    }
}
