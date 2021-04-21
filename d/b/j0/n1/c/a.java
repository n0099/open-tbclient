package d.b.j0.n1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C1425a> f58912a = new ArrayList<>();

    /* renamed from: d.b.j0.n1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1425a {

        /* renamed from: a  reason: collision with root package name */
        public String f58913a;

        /* renamed from: b  reason: collision with root package name */
        public String f58914b;

        public String a() {
            return this.f58913a;
        }

        public String b() {
            return this.f58914b;
        }

        public void c(Lbs lbs) {
            if (lbs == null) {
                return;
            }
            this.f58913a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f58914b = lbs.sn;
        }

        public void d(String str) {
            this.f58913a = str;
        }

        public void e(String str) {
            this.f58914b = str;
        }
    }

    public ArrayList<C1425a> a() {
        return this.f58912a;
    }

    public void b(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Lbs lbs : list) {
            C1425a c1425a = new C1425a();
            c1425a.c(lbs);
            this.f58912a.add(c1425a);
        }
    }

    public void c(ArrayList<C1425a> arrayList) {
        this.f58912a = arrayList;
    }
}
