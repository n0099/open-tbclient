package d.a.n0.o1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C1508a> f61497a = new ArrayList<>();

    /* renamed from: d.a.n0.o1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1508a {

        /* renamed from: a  reason: collision with root package name */
        public String f61498a;

        /* renamed from: b  reason: collision with root package name */
        public String f61499b;

        public String a() {
            return this.f61498a;
        }

        public String b() {
            return this.f61499b;
        }

        public void c(Lbs lbs) {
            if (lbs == null) {
                return;
            }
            this.f61498a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f61499b = lbs.sn;
        }

        public void d(String str) {
            this.f61498a = str;
        }

        public void e(String str) {
            this.f61499b = str;
        }
    }

    public ArrayList<C1508a> a() {
        return this.f61497a;
    }

    public void b(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Lbs lbs : list) {
            C1508a c1508a = new C1508a();
            c1508a.c(lbs);
            this.f61497a.add(c1508a);
        }
    }

    public void c(ArrayList<C1508a> arrayList) {
        this.f61497a = arrayList;
    }
}
