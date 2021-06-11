package d.a.m0.r.q;

import java.util.ArrayList;
import java.util.List;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes3.dex */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    public int f53622a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f53623b;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f53624a;
    }

    public ArrayList<a> a() {
        return this.f53623b;
    }

    public int b() {
        return this.f53622a;
    }

    public void c(PbPresent pbPresent) {
        if (pbPresent == null) {
            return;
        }
        this.f53622a = pbPresent.total.intValue();
        List<PbPresentList> list = pbPresent.list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f53623b = new ArrayList<>();
        for (PbPresentList pbPresentList : pbPresent.list) {
            if (pbPresentList != null) {
                a aVar = new a();
                pbPresentList.gift_id.intValue();
                String str = pbPresentList.gift_name;
                aVar.f53624a = pbPresentList.thumbnail_url;
                pbPresentList.num.intValue();
                this.f53623b.add(aVar);
            }
        }
    }

    public void d(ArrayList<a> arrayList) {
        this.f53623b = arrayList;
    }

    public void e(int i2) {
        this.f53622a = i2;
    }
}
