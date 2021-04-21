package d.b.j0.u0.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetGiftList.PresentCategoryList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f63105a;

    /* renamed from: b  reason: collision with root package name */
    public String f63106b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f63107c;

    public int a() {
        return this.f63105a;
    }

    public String b() {
        return this.f63106b;
    }

    public ArrayList<Integer> c() {
        return this.f63107c;
    }

    public void d(PresentCategoryList presentCategoryList) {
        if (presentCategoryList == null) {
            return;
        }
        this.f63105a = presentCategoryList.category_id.intValue();
        this.f63106b = presentCategoryList.category_name;
        List<Integer> list = presentCategoryList.gift_ids;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f63107c = arrayList;
        arrayList.addAll(presentCategoryList.gift_ids);
    }
}
