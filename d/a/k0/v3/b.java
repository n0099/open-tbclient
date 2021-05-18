package d.a.k0.v3;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import d.a.k0.b0.c;
import d.a.k0.v3.q.d.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes5.dex */
public class b implements d.a.k0.b0.c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.v3.q.d.a f62597a;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f62599c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f62600d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62601e;

    /* renamed from: f  reason: collision with root package name */
    public int f62602f;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f62598b = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public a.b f62603g = new a();

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.k0.v3.q.d.a.b
        public void a(List<SimpleForum> list, int i2) {
            b.this.f62599c = list;
            b.this.f62602f = i2;
            b.this.h();
        }

        @Override // d.a.k0.v3.q.d.a.b
        public void onError() {
            b.this.g();
        }
    }

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        d.a.k0.v3.q.d.a aVar = new d.a.k0.v3.q.d.a(gen);
        this.f62597a = aVar;
        aVar.i(this.f62603g);
        this.f62597a.j(gen);
    }

    @Override // d.a.k0.b0.c
    public void a(c.a aVar) {
        this.f62600d = aVar;
    }

    @Override // d.a.k0.b0.c
    public void b() {
        d.a.k0.v3.q.d.a aVar;
        if (this.f62600d == null || (aVar = this.f62597a) == null) {
            return;
        }
        this.f62601e = false;
        aVar.l(null);
        this.f62597a.k(null);
        this.f62597a.h();
    }

    public final void g() {
        if (this.f62601e) {
            return;
        }
        c.a aVar = this.f62600d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f62601e = true;
    }

    public final void h() {
        Long l;
        this.f62598b.clear();
        if (ListUtils.getCount(this.f62599c) > 0) {
            for (SimpleForum simpleForum : this.f62599c) {
                if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.f62598b.add(transmitForumData);
                }
            }
        }
        c.a aVar = this.f62600d;
        if (aVar != null) {
            aVar.a(this.f62598b, true, 2, this.f62602f);
        }
    }
}
