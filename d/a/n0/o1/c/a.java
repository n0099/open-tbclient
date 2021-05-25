package d.a.n0.o1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C1452a> f57808a = new ArrayList<>();

    /* renamed from: d.a.n0.o1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1452a {

        /* renamed from: a  reason: collision with root package name */
        public String f57809a;

        /* renamed from: b  reason: collision with root package name */
        public String f57810b;

        public String a() {
            return this.f57809a;
        }

        public String b() {
            return this.f57810b;
        }

        public void c(Lbs lbs) {
            if (lbs == null) {
                return;
            }
            this.f57809a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f57810b = lbs.sn;
        }

        public void d(String str) {
            this.f57809a = str;
        }

        public void e(String str) {
            this.f57810b = str;
        }
    }

    public ArrayList<C1452a> a() {
        return this.f57808a;
    }

    public void b(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Lbs lbs : list) {
            C1452a c1452a = new C1452a();
            c1452a.c(lbs);
            this.f57808a.add(c1452a);
        }
    }

    public void c(ArrayList<C1452a> arrayList) {
        this.f57808a = arrayList;
    }
}
