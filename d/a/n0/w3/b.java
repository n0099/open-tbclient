package d.a.n0.w3;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import d.a.n0.d0.c;
import d.a.n0.w3.q.d.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes5.dex */
public class b implements d.a.n0.d0.c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.w3.q.d.a f66419a;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f66421c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f66422d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66423e;

    /* renamed from: f  reason: collision with root package name */
    public int f66424f;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f66420b = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public a.b f66425g = new a();

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.n0.w3.q.d.a.b
        public void a(List<SimpleForum> list, int i2) {
            b.this.f66421c = list;
            b.this.f66424f = i2;
            b.this.h();
        }

        @Override // d.a.n0.w3.q.d.a.b
        public void onError() {
            b.this.g();
        }
    }

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        d.a.n0.w3.q.d.a aVar = new d.a.n0.w3.q.d.a(gen);
        this.f66419a = aVar;
        aVar.i(this.f66425g);
        this.f66419a.j(gen);
    }

    @Override // d.a.n0.d0.c
    public void a(c.a aVar) {
        this.f66422d = aVar;
    }

    @Override // d.a.n0.d0.c
    public void b() {
        d.a.n0.w3.q.d.a aVar;
        if (this.f66422d == null || (aVar = this.f66419a) == null) {
            return;
        }
        this.f66423e = false;
        aVar.l(null);
        this.f66419a.k(null);
        this.f66419a.h();
    }

    public final void g() {
        if (this.f66423e) {
            return;
        }
        c.a aVar = this.f66422d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f66423e = true;
    }

    public final void h() {
        Long l;
        this.f66420b.clear();
        if (ListUtils.getCount(this.f66421c) > 0) {
            for (SimpleForum simpleForum : this.f66421c) {
                if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.f66420b.add(transmitForumData);
                }
            }
        }
        c.a aVar = this.f66422d;
        if (aVar != null) {
            aVar.a(this.f66420b, true, 2, this.f66424f);
        }
    }
}
