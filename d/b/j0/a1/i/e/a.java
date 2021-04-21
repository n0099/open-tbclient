package d.b.j0.a1.i.e;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.k0;
import d.b.i0.r.q.m;
import d.b.i0.r.q.o1;
import d.b.i0.r.q.s1;
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
    public boolean f53308a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f53309b = 1;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<a2> f53310c;

    /* renamed from: d  reason: collision with root package name */
    public m f53311d;

    /* renamed from: e  reason: collision with root package name */
    public k0 f53312e;

    /* renamed from: f  reason: collision with root package name */
    public o1 f53313f;

    /* renamed from: g  reason: collision with root package name */
    public s1 f53314g;

    /* renamed from: h  reason: collision with root package name */
    public b f53315h;
    public SpecialColumnListData i;

    public m a() {
        return this.f53311d;
    }

    public int b() {
        return this.f53309b;
    }

    public k0 c() {
        return this.f53312e;
    }

    public b d() {
        return this.f53315h;
    }

    public o1 e() {
        return this.f53313f;
    }

    public s1 f() {
        return this.f53314g;
    }

    public SpecialColumnListData g() {
        return this.i;
    }

    public ArrayList<a2> h() {
        return this.f53310c;
    }

    public boolean i() {
        return this.f53308a;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Page page = dataRes.page_info;
        if (page != null) {
            this.f53309b = page.current_page.intValue();
            this.f53308a = page.has_more.intValue() == 1;
        }
        this.f53310c = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            a2 a2Var = new a2();
            a2Var.R2(threadInfo);
            a2Var.J1();
            this.f53310c.add(a2Var);
        }
        List<BannerImage> list = dataRes.banner_image;
        if (!ListUtils.isEmpty(list)) {
            m mVar = new m();
            this.f53311d = mVar;
            mVar.parserProtobuf(list);
        }
        List<BannerImage> list2 = dataRes.grid;
        if (ListUtils.getCount(list2) >= 4) {
            k0 k0Var = new k0();
            this.f53312e = k0Var;
            k0Var.parserProtobuf(list2);
        }
        RecommendForumList recommendForumList = dataRes.recommend_forum;
        if (recommendForumList != null && ListUtils.getCount(recommendForumList.forum_list) >= 5) {
            o1 o1Var = new o1();
            this.f53313f = o1Var;
            o1Var.C(recommendForumList.forum_list);
            o1 o1Var2 = this.f53313f;
            o1Var2.j = recommendForumList.class_name;
            o1Var2.floorPosition = recommendForumList.floor_position.intValue();
            this.f53313f.f51597h = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
            this.f53313f.i = R.color.CAM_X0108;
        }
        RecommendUserList recommendUserList = dataRes.recommend_user;
        if (recommendUserList != null && ListUtils.getCount(recommendUserList.user_list) >= 4) {
            s1 s1Var = new s1();
            this.f53314g = s1Var;
            s1Var.A(recommendUserList.user_list);
            this.f53314g.floorPosition = recommendUserList.floor_position.intValue();
            this.f53314g.f51625e = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
            this.f53314g.f51626f = R.color.CAM_X0108;
        }
        HotTopic hotTopic = dataRes.hot_topic;
        if (hotTopic != null && ListUtils.getCount(hotTopic.topic_list) >= 4) {
            b bVar = new b();
            this.f53315h = bVar;
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
