package d.b.i0.u3;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import d.b.i0.b0.c;
import d.b.i0.u3.r.d.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes5.dex */
public class b implements d.b.i0.b0.c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.u3.r.d.a f61472a;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f61474c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f61475d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61476e;

    /* renamed from: f  reason: collision with root package name */
    public int f61477f;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f61473b = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public a.b f61478g = new a();

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.i0.u3.r.d.a.b
        public void a(List<SimpleForum> list, int i) {
            b.this.f61474c = list;
            b.this.f61477f = i;
            b.this.h();
        }

        @Override // d.b.i0.u3.r.d.a.b
        public void onError() {
            b.this.g();
        }
    }

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        d.b.i0.u3.r.d.a aVar = new d.b.i0.u3.r.d.a(gen);
        this.f61472a = aVar;
        aVar.i(this.f61478g);
        this.f61472a.j(gen);
    }

    @Override // d.b.i0.b0.c
    public void a(c.a aVar) {
        this.f61475d = aVar;
    }

    @Override // d.b.i0.b0.c
    public void b() {
        d.b.i0.u3.r.d.a aVar;
        if (this.f61475d == null || (aVar = this.f61472a) == null) {
            return;
        }
        this.f61476e = false;
        aVar.l(null);
        this.f61472a.k(null);
        this.f61472a.h();
    }

    public final void g() {
        if (this.f61476e) {
            return;
        }
        c.a aVar = this.f61475d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f61476e = true;
    }

    public final void h() {
        Long l;
        this.f61473b.clear();
        if (ListUtils.getCount(this.f61474c) > 0) {
            for (SimpleForum simpleForum : this.f61474c) {
                if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.f61473b.add(transmitForumData);
                }
            }
        }
        c.a aVar = this.f61475d;
        if (aVar != null) {
            aVar.a(this.f61473b, true, 2, this.f61477f);
        }
    }
}
