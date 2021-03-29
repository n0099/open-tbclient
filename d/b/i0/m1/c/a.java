package d.b.i0.m1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C1344a> f56854a = new ArrayList<>();

    /* renamed from: d.b.i0.m1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1344a {

        /* renamed from: a  reason: collision with root package name */
        public String f56855a;

        /* renamed from: b  reason: collision with root package name */
        public String f56856b;

        public String a() {
            return this.f56855a;
        }

        public String b() {
            return this.f56856b;
        }

        public void c(Lbs lbs) {
            if (lbs == null) {
                return;
            }
            this.f56855a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f56856b = lbs.sn;
        }

        public void d(String str) {
            this.f56855a = str;
        }

        public void e(String str) {
            this.f56856b = str;
        }
    }

    public ArrayList<C1344a> a() {
        return this.f56854a;
    }

    public void b(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Lbs lbs : list) {
            C1344a c1344a = new C1344a();
            c1344a.c(lbs);
            this.f56854a.add(c1344a);
        }
    }

    public void c(ArrayList<C1344a> arrayList) {
        this.f56854a = arrayList;
    }
}
