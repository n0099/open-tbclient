package d.b.i0.v3;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import d.b.i0.b0.c;
import d.b.i0.v3.r.d.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes5.dex */
public class b implements d.b.i0.b0.c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.v3.r.d.a f63211a;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f63213c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f63214d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63215e;

    /* renamed from: f  reason: collision with root package name */
    public int f63216f;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f63212b = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public a.b f63217g = new a();

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.i0.v3.r.d.a.b
        public void a(List<SimpleForum> list, int i) {
            b.this.f63213c = list;
            b.this.f63216f = i;
            b.this.h();
        }

        @Override // d.b.i0.v3.r.d.a.b
        public void onError() {
            b.this.g();
        }
    }

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        d.b.i0.v3.r.d.a aVar = new d.b.i0.v3.r.d.a(gen);
        this.f63211a = aVar;
        aVar.i(this.f63217g);
        this.f63211a.j(gen);
    }

    @Override // d.b.i0.b0.c
    public void a(c.a aVar) {
        this.f63214d = aVar;
    }

    @Override // d.b.i0.b0.c
    public void b() {
        d.b.i0.v3.r.d.a aVar;
        if (this.f63214d == null || (aVar = this.f63211a) == null) {
            return;
        }
        this.f63215e = false;
        aVar.l(null);
        this.f63211a.k(null);
        this.f63211a.h();
    }

    public final void g() {
        if (this.f63215e) {
            return;
        }
        c.a aVar = this.f63214d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f63215e = true;
    }

    public final void h() {
        Long l;
        this.f63212b.clear();
        if (ListUtils.getCount(this.f63213c) > 0) {
            for (SimpleForum simpleForum : this.f63213c) {
                if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.f63212b.add(transmitForumData);
                }
            }
        }
        c.a aVar = this.f63214d;
        if (aVar != null) {
            aVar.a(this.f63212b, true, 2, this.f63216f);
        }
    }
}
