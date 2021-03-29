package d.b.i0.t0.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetGiftList.PresentCategoryList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60995a;

    /* renamed from: b  reason: collision with root package name */
    public String f60996b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f60997c;

    public int a() {
        return this.f60995a;
    }

    public String b() {
        return this.f60996b;
    }

    public ArrayList<Integer> c() {
        return this.f60997c;
    }

    public void d(PresentCategoryList presentCategoryList) {
        if (presentCategoryList == null) {
            return;
        }
        this.f60995a = presentCategoryList.category_id.intValue();
        this.f60996b = presentCategoryList.category_name;
        List<Integer> list = presentCategoryList.gift_ids;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f60997c = arrayList;
        arrayList.addAll(presentCategoryList.gift_ids);
    }
}
