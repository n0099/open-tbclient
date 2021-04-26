package d.a.j0.v3;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import d.a.j0.b0.c;
import d.a.j0.v3.q.d.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes5.dex */
public class b implements d.a.j0.b0.c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.v3.q.d.a f61873a;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f61875c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f61876d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61877e;

    /* renamed from: f  reason: collision with root package name */
    public int f61878f;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f61874b = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public a.b f61879g = new a();

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.j0.v3.q.d.a.b
        public void a(List<SimpleForum> list, int i2) {
            b.this.f61875c = list;
            b.this.f61878f = i2;
            b.this.h();
        }

        @Override // d.a.j0.v3.q.d.a.b
        public void onError() {
            b.this.g();
        }
    }

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        d.a.j0.v3.q.d.a aVar = new d.a.j0.v3.q.d.a(gen);
        this.f61873a = aVar;
        aVar.i(this.f61879g);
        this.f61873a.j(gen);
    }

    @Override // d.a.j0.b0.c
    public void a(c.a aVar) {
        this.f61876d = aVar;
    }

    @Override // d.a.j0.b0.c
    public void b() {
        d.a.j0.v3.q.d.a aVar;
        if (this.f61876d == null || (aVar = this.f61873a) == null) {
            return;
        }
        this.f61877e = false;
        aVar.l(null);
        this.f61873a.k(null);
        this.f61873a.h();
    }

    public final void g() {
        if (this.f61877e) {
            return;
        }
        c.a aVar = this.f61876d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f61877e = true;
    }

    public final void h() {
        Long l;
        this.f61874b.clear();
        if (ListUtils.getCount(this.f61875c) > 0) {
            for (SimpleForum simpleForum : this.f61875c) {
                if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.f61874b.add(transmitForumData);
                }
            }
        }
        c.a aVar = this.f61876d;
        if (aVar != null) {
            aVar.a(this.f61874b, true, 2, this.f61878f);
        }
    }
}
