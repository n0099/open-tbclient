package d.a.o0.o1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C1512a> f61622a = new ArrayList<>();

    /* renamed from: d.a.o0.o1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1512a {

        /* renamed from: a  reason: collision with root package name */
        public String f61623a;

        /* renamed from: b  reason: collision with root package name */
        public String f61624b;

        public String a() {
            return this.f61623a;
        }

        public String b() {
            return this.f61624b;
        }

        public void c(Lbs lbs) {
            if (lbs == null) {
                return;
            }
            this.f61623a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f61624b = lbs.sn;
        }

        public void d(String str) {
            this.f61623a = str;
        }

        public void e(String str) {
            this.f61624b = str;
        }
    }

    public ArrayList<C1512a> a() {
        return this.f61622a;
    }

    public void b(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Lbs lbs : list) {
            C1512a c1512a = new C1512a();
            c1512a.c(lbs);
            this.f61622a.add(c1512a);
        }
    }

    public void c(ArrayList<C1512a> arrayList) {
        this.f61622a = arrayList;
    }
}
