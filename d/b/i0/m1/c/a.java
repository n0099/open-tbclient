package d.b.i0.m1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C1343a> f56853a = new ArrayList<>();

    /* renamed from: d.b.i0.m1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1343a {

        /* renamed from: a  reason: collision with root package name */
        public String f56854a;

        /* renamed from: b  reason: collision with root package name */
        public String f56855b;

        public String a() {
            return this.f56854a;
        }

        public String b() {
            return this.f56855b;
        }

        public void c(Lbs lbs) {
            if (lbs == null) {
                return;
            }
            this.f56854a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f56855b = lbs.sn;
        }

        public void d(String str) {
            this.f56854a = str;
        }

        public void e(String str) {
            this.f56855b = str;
        }
    }

    public ArrayList<C1343a> a() {
        return this.f56853a;
    }

    public void b(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Lbs lbs : list) {
            C1343a c1343a = new C1343a();
            c1343a.c(lbs);
            this.f56853a.add(c1343a);
        }
    }

    public void c(ArrayList<C1343a> arrayList) {
        this.f56853a = arrayList;
    }
}
