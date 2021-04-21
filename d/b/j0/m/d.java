package d.b.j0.m;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import d.b.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static volatile d f58579e;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f58580a;

    /* renamed from: b  reason: collision with root package name */
    public a f58581b;

    /* renamed from: c  reason: collision with root package name */
    public c f58582c;

    /* renamed from: d  reason: collision with root package name */
    public List<StatisticItem> f58583d;

    public d() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f58580a = arrayList;
        arrayList.add(1);
        this.f58580a.add(2);
        c cVar = new c();
        this.f58582c = cVar;
        this.f58581b = new a(cVar, this.f58580a);
        g(d.b.i0.r.d0.b.j().k("key_abtest_channel", 0));
    }

    public static d c() {
        if (f58579e == null) {
            synchronized (c.class) {
                if (f58579e == null) {
                    f58579e = new d();
                }
            }
        }
        return f58579e;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f58583d == null) {
            this.f58583d = new ArrayList();
        }
        this.f58583d.add(statisticItem);
    }

    public int b(String str, int i) {
        a aVar = this.f58581b;
        if (aVar == null) {
            return 0;
        }
        return aVar.a(str, i);
    }

    public void d(String str) {
        c cVar;
        if (k.isEmpty(str) || (cVar = this.f58582c) == null || !cVar.g()) {
            d.b.n0.a.a.d(str);
        }
    }

    public void e(String str) {
        c cVar;
        if (k.isEmpty(str) || (cVar = this.f58582c) == null || !cVar.g()) {
            d.b.n0.a.a.e(str);
        }
    }

    public void f(String str) {
        a aVar = this.f58581b;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    public void g(int i) {
        c cVar = this.f58582c;
        if (cVar != null) {
            cVar.k(i);
        }
    }

    public void h(String str, String str2) {
        c cVar;
        if (ListUtils.isEmpty(this.f58583d) || (cVar = this.f58582c) == null || !cVar.g()) {
            return;
        }
        int i = -1;
        for (StatisticItem statisticItem : this.f58583d) {
            if (statisticItem != null) {
                if (statisticItem.getPosition() == 0) {
                    i(str, str2, statisticItem);
                } else if (i != statisticItem.getPosition()) {
                    i = statisticItem.getPosition();
                    i(str, str2, statisticItem);
                }
            }
        }
        this.f58583d.clear();
    }

    public void i(String str, String str2, StatisticItem statisticItem) {
        c cVar;
        if (statisticItem == null || (cVar = this.f58582c) == null || !cVar.g()) {
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
        d.b.n0.a.a.c(str2 + statisticItem.getKey(), str, "", hashMap);
    }
}
