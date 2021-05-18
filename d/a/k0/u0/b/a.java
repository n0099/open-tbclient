package d.a.k0.u0.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetGiftList.PresentCategoryList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f62039a;

    /* renamed from: b  reason: collision with root package name */
    public String f62040b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f62041c;

    public int a() {
        return this.f62039a;
    }

    public String b() {
        return this.f62040b;
    }

    public ArrayList<Integer> c() {
        return this.f62041c;
    }

    public void d(PresentCategoryList presentCategoryList) {
        if (presentCategoryList == null) {
            return;
        }
        this.f62039a = presentCategoryList.category_id.intValue();
        this.f62040b = presentCategoryList.category_name;
        List<Integer> list = presentCategoryList.gift_ids;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f62041c = arrayList;
        arrayList.addAll(presentCategoryList.gift_ids);
    }
}
