package d.b.h0.r.q;

import java.util.ArrayList;
import java.util.List;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes3.dex */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    public int f51124a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f51125b;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f51126a;
    }

    public ArrayList<a> a() {
        return this.f51125b;
    }

    public int b() {
        return this.f51124a;
    }

    public void c(PbPresent pbPresent) {
        if (pbPresent == null) {
            return;
        }
        this.f51124a = pbPresent.total.intValue();
        List<PbPresentList> list = pbPresent.list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f51125b = new ArrayList<>();
        for (PbPresentList pbPresentList : pbPresent.list) {
            if (pbPresentList != null) {
                a aVar = new a();
                pbPresentList.gift_id.intValue();
                String str = pbPresentList.gift_name;
                aVar.f51126a = pbPresentList.thumbnail_url;
                pbPresentList.num.intValue();
                this.f51125b.add(aVar);
            }
        }
    }

    public void d(ArrayList<a> arrayList) {
        this.f51125b = arrayList;
    }

    public void e(int i) {
        this.f51124a = i;
    }
}
