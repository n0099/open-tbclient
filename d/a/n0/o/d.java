package d.a.n0.o;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static volatile d f57754e;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f57755a;

    /* renamed from: b  reason: collision with root package name */
    public a f57756b;

    /* renamed from: c  reason: collision with root package name */
    public c f57757c;

    /* renamed from: d  reason: collision with root package name */
    public List<StatisticItem> f57758d;

    public d() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f57755a = arrayList;
        arrayList.add(1);
        this.f57755a.add(2);
        c cVar = new c();
        this.f57757c = cVar;
        this.f57756b = new a(cVar, this.f57755a);
        g(d.a.m0.r.d0.b.j().k("key_abtest_channel", 0));
    }

    public static d c() {
        if (f57754e == null) {
            synchronized (c.class) {
                if (f57754e == null) {
                    f57754e = new d();
                }
            }
        }
        return f57754e;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f57758d == null) {
            this.f57758d = new ArrayList();
        }
        this.f57758d.add(statisticItem);
    }

    public int b(String str, int i2) {
        a aVar = this.f57756b;
        if (aVar == null) {
            return 0;
        }
        return aVar.a(str, i2);
    }

    public void d(String str) {
        c cVar;
        if (k.isEmpty(str) || (cVar = this.f57757c) == null || !cVar.g()) {
            d.a.r0.a.a.d(str);
        }
    }

    public void e(String str) {
        c cVar;
        if (k.isEmpty(str) || (cVar = this.f57757c) == null || !cVar.g()) {
            d.a.r0.a.a.e(str);
        }
    }

    public void f(String str) {
        a aVar = this.f57756b;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    public void g(int i2) {
        c cVar = this.f57757c;
        if (cVar != null) {
            cVar.k(i2);
        }
    }

    public void h(String str, String str2) {
        c cVar;
        if (ListUtils.isEmpty(this.f57758d) || (cVar = this.f57757c) == null || !cVar.g()) {
            return;
        }
        int i2 = -1;
        for (StatisticItem statisticItem : this.f57758d) {
            if (statisticItem != null) {
                if (statisticItem.getPosition() == 0) {
                    i(str, str2, statisticItem);
                } else if (i2 != statisticItem.getPosition()) {
                    i2 = statisticItem.getPosition();
                    i(str, str2, statisticItem);
                }
            }
        }
        this.f57758d.clear();
    }

    public void i(String str, String str2, StatisticItem statisticItem) {
        c cVar;
        if (statisticItem == null || (cVar = this.f57757c) == null || !cVar.g()) {
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
        d.a.r0.a.a.c(str2 + statisticItem.getKey(), str, "", hashMap);
    }
}
