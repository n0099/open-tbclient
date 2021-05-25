package d.a.n0.d1.c;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.PostForumData;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.n1;
import d.a.m0.r.q.o1;
import d.a.m0.r.q.z0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.Hottopic.PkModule;
import tbclient.Hottopic.RelateForum;
import tbclient.Hottopic.SpecialTopic;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.c.j.e.n> f52564a;

    /* renamed from: d  reason: collision with root package name */
    public o1 f52567d;
    public boolean r;
    public int s;

    /* renamed from: b  reason: collision with root package name */
    public f f52565b = null;

    /* renamed from: c  reason: collision with root package name */
    public n f52566c = null;

    /* renamed from: e  reason: collision with root package name */
    public PostForumData f52568e = null;

    /* renamed from: f  reason: collision with root package name */
    public i f52569f = null;

    /* renamed from: g  reason: collision with root package name */
    public a f52570g = null;

    /* renamed from: h  reason: collision with root package name */
    public a f52571h = null;

    /* renamed from: i  reason: collision with root package name */
    public a f52572i = null;
    public g j = null;
    public d k = null;
    public g l = null;
    public List<d.a.n0.z.e0.b> m = null;
    public List<d.a.c.j.e.n> n = null;
    public z0 o = null;
    public boolean p = true;
    public int q = 0;

    public e() {
        this.f52564a = null;
        this.f52564a = new ArrayList<>();
    }

    public void a(d dVar) {
        if (dVar == null || ListUtils.getCount(dVar.G3) == 0) {
            return;
        }
        for (d.a.n0.z.e0.b bVar : dVar.G3) {
            this.f52564a.add(bVar);
        }
    }

    public void b(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        d.a.n0.z.e0.k kVar = new d.a.n0.z.e0.k();
        kVar.f63459e = a2Var;
        a2Var.d4(5);
        this.f52564a.add(0, kVar);
    }

    public a c() {
        return this.f52570g;
    }

    public a d() {
        return this.f52571h;
    }

    public o1 e() {
        return this.f52567d;
    }

    public int f() {
        return this.q;
    }

    public i g() {
        return this.f52569f;
    }

    public f h() {
        return this.f52565b;
    }

    public ArrayList<d.a.c.j.e.n> i() {
        return this.f52564a;
    }

    public z0 j() {
        return this.o;
    }

    public n k() {
        return this.f52566c;
    }

    public List<d.a.c.j.e.n> l() {
        return this.n;
    }

    public a m() {
        return this.f52572i;
    }

    public boolean n() {
        return this.p;
    }

    public void o(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.p = dataRes.is_new_url.intValue() == 1;
        if (dataRes.topic_info != null) {
            f fVar = new f();
            this.f52565b = fVar;
            fVar.c(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            g gVar = new g();
            this.l = gVar;
            gVar.c(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                a2 a2Var = new a2();
                a2Var.d4(5);
                a2Var.U2(threadInfo);
                d.a.n0.z.e0.b bVar = null;
                if (a2Var.t1) {
                    bVar = new d.a.n0.z.e0.k();
                    bVar.f63459e = a2Var;
                } else if (d.a.n0.z.e0.l.d0(a2Var)) {
                    bVar = new d.a.n0.z.e0.l(a2Var);
                    bVar.x = true;
                } else if (d.a.n0.z.e0.k.i0(a2Var)) {
                    bVar = new d.a.n0.z.e0.k();
                    bVar.f63459e = a2Var;
                }
                if (bVar != null && bVar.isValid()) {
                    bVar.X("c10814");
                    this.m.add(bVar);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            n nVar = new n();
            this.f52566c = nVar;
            nVar.parserProtobuf(dataRes.relate_forum);
            o1 o1Var = new o1();
            this.f52567d = o1Var;
            o1Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.f52567d.f50090h = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
            } else {
                this.f52567d.f50090h = dataRes.relate_forum_title;
            }
            o1 o1Var2 = this.f52567d;
            o1Var2.f50091i = R.color.CAM_X0108;
            ArrayList<n1> B = o1Var2.B();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    n1 n1Var = new n1();
                    n1Var.O(relateForum.forum_id.intValue());
                    n1Var.P(relateForum.forum_name);
                    n1Var.N(relateForum.avatar);
                    n1Var.L(relateForum.desc);
                    n1Var.M(relateForum.thread_num.intValue());
                    n1Var.K(relateForum.member_num.intValue());
                    n1Var.J(relateForum.is_liked.intValue() != 0);
                    B.add(n1Var);
                }
            }
        }
        List<RelateForum> list2 = dataRes.post_forum;
        if (list2 != null && list2.size() != 0) {
            PostForumData postForumData = new PostForumData();
            this.f52568e = postForumData;
            postForumData.parserProtobuf(dataRes.post_forum);
        }
        PkModule pkModule = dataRes.pk_module;
        if (pkModule != null && !StringUtils.isNull(pkModule.ques_desc)) {
            i iVar = new i();
            this.f52569f = iVar;
            iVar.c(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            a aVar = new a();
            this.f52570g = aVar;
            aVar.c(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            a aVar2 = new a();
            this.f52571h = aVar2;
            aVar2.c(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            a aVar3 = new a();
            this.f52572i = aVar3;
            aVar3.c(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            g gVar2 = new g();
            this.j = gVar2;
            gVar2.c(dataRes.hot_thread);
            d dVar = new d();
            this.k = dVar;
            dVar.H4(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                z0 z0Var = new z0();
                this.o = z0Var;
                z0Var.j(dataRes.hot_thread.page);
                this.r = this.o.b() != 0;
            }
            this.q = dataRes.is_global_block.intValue();
        }
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.n = new ArrayList();
            boolean z = this.f52569f != null;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        d.a.n0.y1.e.c cVar = new d.a.n0.y1.e.c(specialTopic.title);
                        if (!z) {
                            cVar.f63407f = false;
                            z = true;
                        }
                        this.n.add(cVar);
                    }
                    int size = specialTopic.thread_list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        List<d.a.c.j.e.n> list3 = this.n;
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i2);
                        i2++;
                        list3.add(new d.a.n0.y1.e.b(threadInfo2, i2 == size));
                    }
                }
            }
        }
        p();
    }

    public final ArrayList<d.a.c.j.e.n> p() {
        i iVar = this.f52569f;
        if (iVar != null) {
            this.f52564a.add(iVar);
        }
        if (ListUtils.getCount(this.m) > 0) {
            this.f52564a.add(this.l);
            if (this.m.size() > 5) {
                this.m = this.m.subList(0, 5);
            }
            for (d.a.n0.z.e0.b bVar : this.m) {
                this.f52564a.add(bVar);
            }
        }
        n nVar = this.f52566c;
        if (nVar != null && nVar.getCount() > 0 && this.s == 1) {
            this.f52564a.add(this.f52566c);
        }
        d dVar = this.k;
        if (dVar != null && !ListUtils.isEmpty(dVar.G3)) {
            this.f52564a.add(this.j);
            for (int i2 = 0; i2 < this.k.G3.size(); i2++) {
                this.f52564a.add((d.a.n0.z.e0.b) ListUtils.getItem(this.k.G3, i2));
                n nVar2 = this.f52566c;
                if (nVar2 != null && nVar2.getCount() > 0 && i2 == 2 && this.s == 0) {
                    this.f52564a.add(this.f52566c);
                }
            }
        }
        return this.f52564a;
    }

    public void q(z0 z0Var) {
        this.o = z0Var;
    }
}
