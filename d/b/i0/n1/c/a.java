package d.b.i0.n1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C1402a> f58491a = new ArrayList<>();

    /* renamed from: d.b.i0.n1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1402a {

        /* renamed from: a  reason: collision with root package name */
        public String f58492a;

        /* renamed from: b  reason: collision with root package name */
        public String f58493b;

        public String a() {
            return this.f58492a;
        }

        public String b() {
            return this.f58493b;
        }

        public void c(Lbs lbs) {
            if (lbs == null) {
                return;
            }
            this.f58492a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f58493b = lbs.sn;
        }

        public void d(String str) {
            this.f58492a = str;
        }

        public void e(String str) {
            this.f58493b = str;
        }
    }

    public ArrayList<C1402a> a() {
        return this.f58491a;
    }

    public void b(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Lbs lbs : list) {
            C1402a c1402a = new C1402a();
            c1402a.c(lbs);
            this.f58491a.add(c1402a);
        }
    }

    public void c(ArrayList<C1402a> arrayList) {
        this.f58491a = arrayList;
    }
}
