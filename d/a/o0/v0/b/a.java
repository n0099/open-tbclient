package d.a.o0.v0.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetGiftList.PresentCategoryList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f66036a;

    /* renamed from: b  reason: collision with root package name */
    public String f66037b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f66038c;

    public int a() {
        return this.f66036a;
    }

    public String b() {
        return this.f66037b;
    }

    public ArrayList<Integer> c() {
        return this.f66038c;
    }

    public void d(PresentCategoryList presentCategoryList) {
        if (presentCategoryList == null) {
            return;
        }
        this.f66036a = presentCategoryList.category_id.intValue();
        this.f66037b = presentCategoryList.category_name;
        List<Integer> list = presentCategoryList.gift_ids;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f66038c = arrayList;
        arrayList.addAll(presentCategoryList.gift_ids);
    }
}
