package d.b.i0.m;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import d.b.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static volatile d f58158e;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f58159a;

    /* renamed from: b  reason: collision with root package name */
    public a f58160b;

    /* renamed from: c  reason: collision with root package name */
    public c f58161c;

    /* renamed from: d  reason: collision with root package name */
    public List<StatisticItem> f58162d;

    public d() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f58159a = arrayList;
        arrayList.add(1);
        this.f58159a.add(2);
        c cVar = new c();
        this.f58161c = cVar;
        this.f58160b = new a(cVar, this.f58159a);
        g(d.b.h0.r.d0.b.j().k("key_abtest_channel", 0));
    }

    public static d c() {
        if (f58158e == null) {
            synchronized (c.class) {
                if (f58158e == null) {
                    f58158e = new d();
                }
            }
        }
        return f58158e;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f58162d == null) {
            this.f58162d = new ArrayList();
        }
        this.f58162d.add(statisticItem);
    }

    public int b(String str, int i) {
        a aVar = this.f58160b;
        if (aVar == null) {
            return 0;
        }
        return aVar.a(str, i);
    }

    public void d(String str) {
        c cVar;
        if (k.isEmpty(str) || (cVar = this.f58161c) == null || !cVar.g()) {
            d.b.m0.a.a.d(str);
        }
    }

    public void e(String str) {
        c cVar;
        if (k.isEmpty(str) || (cVar = this.f58161c) == null || !cVar.g()) {
            d.b.m0.a.a.e(str);
        }
    }

    public void f(String str) {
        a aVar = this.f58160b;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    public void g(int i) {
        c cVar = this.f58161c;
        if (cVar != null) {
            cVar.k(i);
        }
    }

    public void h(String str, String str2) {
        c cVar;
        if (ListUtils.isEmpty(this.f58162d) || (cVar = this.f58161c) == null || !cVar.g()) {
            return;
        }
        int i = -1;
        for (StatisticItem statisticItem : this.f58162d) {
            if (statisticItem != null) {
                if (statisticItem.getPosition() == 0) {
                    i(str, str2, statisticItem);
                } else if (i != statisticItem.getPosition()) {
                    i = statisticItem.getPosition();
                    i(str, str2, statisticItem);
                }
            }
        }
        this.f58162d.clear();
    }

    public void i(String str, String str2, StatisticItem statisticItem) {
        c cVar;
        if (statisticItem == null || (cVar = this.f58161c) == null || !cVar.g()) {
            return;
        }
        HashMap hashMap = new HashMap();
        List<Object> params = statisticItem.getParams();
        if (params != null) {
            int size = params.size();
            for (int i = 0; i < size; i += 2) {
                Object obj = params.get(i);
                String obj2 = obj != null ? obj.toString() : "";
                Object obj3 = params.get(i + 1);
                hashMap.put(obj2, obj3 != null ? obj3.toString() : "");
            }
        }
        d.b.m0.a.a.c(str2 + statisticItem.getKey(), str, "", hashMap);
    }
}
