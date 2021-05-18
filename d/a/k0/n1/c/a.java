package d.a.k0.n1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C1436a> f57636a = new ArrayList<>();

    /* renamed from: d.a.k0.n1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1436a {

        /* renamed from: a  reason: collision with root package name */
        public String f57637a;

        /* renamed from: b  reason: collision with root package name */
        public String f57638b;

        public String a() {
            return this.f57637a;
        }

        public String b() {
            return this.f57638b;
        }

        public void c(Lbs lbs) {
            if (lbs == null) {
                return;
            }
            this.f57637a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f57638b = lbs.sn;
        }

        public void d(String str) {
            this.f57637a = str;
        }

        public void e(String str) {
            this.f57638b = str;
        }
    }

    public ArrayList<C1436a> a() {
        return this.f57636a;
    }

    public void b(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Lbs lbs : list) {
            C1436a c1436a = new C1436a();
            c1436a.c(lbs);
            this.f57636a.add(c1436a);
        }
    }

    public void c(ArrayList<C1436a> arrayList) {
        this.f57636a = arrayList;
    }
}
