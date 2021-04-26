package d.a.i0.r.q;

import java.util.ArrayList;
import java.util.List;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes3.dex */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    public int f49083a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f49084b;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f49085a;
    }

    public ArrayList<a> a() {
        return this.f49084b;
    }

    public int b() {
        return this.f49083a;
    }

    public void c(PbPresent pbPresent) {
        if (pbPresent == null) {
            return;
        }
        this.f49083a = pbPresent.total.intValue();
        List<PbPresentList> list = pbPresent.list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f49084b = new ArrayList<>();
        for (PbPresentList pbPresentList : pbPresent.list) {
            if (pbPresentList != null) {
                a aVar = new a();
                pbPresentList.gift_id.intValue();
                String str = pbPresentList.gift_name;
                aVar.f49085a = pbPresentList.thumbnail_url;
                pbPresentList.num.intValue();
                this.f49084b.add(aVar);
            }
        }
    }

    public void d(ArrayList<a> arrayList) {
        this.f49084b = arrayList;
    }

    public void e(int i2) {
        this.f49083a = i2;
    }
}
