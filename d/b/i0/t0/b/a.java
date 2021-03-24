package d.b.i0.t0.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetGiftList.PresentCategoryList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60994a;

    /* renamed from: b  reason: collision with root package name */
    public String f60995b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f60996c;

    public int a() {
        return this.f60994a;
    }

    public String b() {
        return this.f60995b;
    }

    public ArrayList<Integer> c() {
        return this.f60996c;
    }

    public void d(PresentCategoryList presentCategoryList) {
        if (presentCategoryList == null) {
            return;
        }
        this.f60994a = presentCategoryList.category_id.intValue();
        this.f60995b = presentCategoryList.category_name;
        List<Integer> list = presentCategoryList.gift_ids;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f60996c = arrayList;
        arrayList.addAll(presentCategoryList.gift_ids);
    }
}
