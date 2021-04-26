package d.a.j0.n1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C1364a> f56929a = new ArrayList<>();

    /* renamed from: d.a.j0.n1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1364a {

        /* renamed from: a  reason: collision with root package name */
        public String f56930a;

        /* renamed from: b  reason: collision with root package name */
        public String f56931b;

        public String a() {
            return this.f56930a;
        }

        public String b() {
            return this.f56931b;
        }

        public void c(Lbs lbs) {
            if (lbs == null) {
                return;
            }
            this.f56930a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f56931b = lbs.sn;
        }

        public void d(String str) {
            this.f56930a = str;
        }

        public void e(String str) {
            this.f56931b = str;
        }
    }

    public ArrayList<C1364a> a() {
        return this.f56929a;
    }

    public void b(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Lbs lbs : list) {
            C1364a c1364a = new C1364a();
            c1364a.c(lbs);
            this.f56929a.add(c1364a);
        }
    }

    public void c(ArrayList<C1364a> arrayList) {
        this.f56929a = arrayList;
    }
}
