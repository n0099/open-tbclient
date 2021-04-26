package d.a.j0.m;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static volatile d f56588e;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f56589a;

    /* renamed from: b  reason: collision with root package name */
    public a f56590b;

    /* renamed from: c  reason: collision with root package name */
    public c f56591c;

    /* renamed from: d  reason: collision with root package name */
    public List<StatisticItem> f56592d;

    public d() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f56589a = arrayList;
        arrayList.add(1);
        this.f56589a.add(2);
        c cVar = new c();
        this.f56591c = cVar;
        this.f56590b = new a(cVar, this.f56589a);
        g(d.a.i0.r.d0.b.j().k("key_abtest_channel", 0));
    }

    public static d c() {
        if (f56588e == null) {
            synchronized (c.class) {
                if (f56588e == null) {
                    f56588e = new d();
                }
            }
        }
        return f56588e;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f56592d == null) {
            this.f56592d = new ArrayList();
        }
        this.f56592d.add(statisticItem);
    }

    public int b(String str, int i2) {
        a aVar = this.f56590b;
        if (aVar == null) {
            return 0;
        }
        return aVar.a(str, i2);
    }

    public void d(String str) {
        c cVar;
        if (k.isEmpty(str) || (cVar = this.f56591c) == null || !cVar.g()) {
            d.a.n0.a.a.d(str);
        }
    }

    public void e(String str) {
        c cVar;
        if (k.isEmpty(str) || (cVar = this.f56591c) == null || !cVar.g()) {
            d.a.n0.a.a.e(str);
        }
    }

    public void f(String str) {
        a aVar = this.f56590b;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    public void g(int i2) {
        c cVar = this.f56591c;
        if (cVar != null) {
            cVar.k(i2);
        }
    }

    public void h(String str, String str2) {
        c cVar;
        if (ListUtils.isEmpty(this.f56592d) || (cVar = this.f56591c) == null || !cVar.g()) {
            return;
        }
        int i2 = -1;
        for (StatisticItem statisticItem : this.f56592d) {
            if (statisticItem != null) {
                if (statisticItem.getPosition() == 0) {
                    i(str, str2, statisticItem);
                } else if (i2 != statisticItem.getPosition()) {
                    i2 = statisticItem.getPosition();
                    i(str, str2, statisticItem);
                }
            }
        }
        this.f56592d.clear();
    }

    public void i(String str, String str2, StatisticItem statisticItem) {
        c cVar;
        if (statisticItem == null || (cVar = this.f56591c) == null || !cVar.g()) {
            return;
        }
        HashMap hashMap = new HashMap();
        List<Object> params = statisticItem.getParams();
        if (params != null) {
            int size = params.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                Object obj = params.get(i2);
                String obj2 = obj != null ? obj.toString() : "";
                Object obj3 = params.get(i2 + 1);
                hashMap.put(obj2, obj3 != null ? obj3.toString() : "");
            }
        }
        d.a.n0.a.a.c(str2 + statisticItem.getKey(), str, "", hashMap);
    }
}
