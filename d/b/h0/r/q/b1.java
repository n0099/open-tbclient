package d.b.h0.r.q;

import java.util.ArrayList;
import java.util.List;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes3.dex */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    public int f50716a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f50717b;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f50718a;
    }

    public ArrayList<a> a() {
        return this.f50717b;
    }

    public int b() {
        return this.f50716a;
    }

    public void c(PbPresent pbPresent) {
        if (pbPresent == null) {
            return;
        }
        this.f50716a = pbPresent.total.intValue();
        List<PbPresentList> list = pbPresent.list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f50717b = new ArrayList<>();
        for (PbPresentList pbPresentList : pbPresent.list) {
            if (pbPresentList != null) {
                a aVar = new a();
                pbPresentList.gift_id.intValue();
                String str = pbPresentList.gift_name;
                aVar.f50718a = pbPresentList.thumbnail_url;
                pbPresentList.num.intValue();
                this.f50717b.add(aVar);
            }
        }
    }

    public void d(ArrayList<a> arrayList) {
        this.f50717b = arrayList;
    }

    public void e(int i) {
        this.f50716a = i;
    }
}
