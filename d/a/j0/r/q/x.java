package d.a.j0.r.q;

import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
import tbclient.FrsPage.Size;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a0> f50122a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f50123b;

    public ArrayList<a0> a() {
        return this.f50122a;
    }

    public String b() {
        return this.f50123b;
    }

    public void c(ActivityHead activityHead) {
        if (activityHead == null) {
            return;
        }
        activityHead.activity_type.intValue();
        String str = activityHead.activity_title;
        Size size = activityHead.top_size;
        if (size != null) {
            size.width.intValue();
        }
        Size size2 = activityHead.top_size;
        if (size2 != null) {
            size2.height.intValue();
        }
        this.f50123b = activityHead.obj_id;
        e(activityHead.head_imgs);
    }

    public void d(HeadImgs headImgs) {
        if (headImgs == null) {
            return;
        }
        a0 a0Var = new a0();
        a0Var.k(headImgs);
        this.f50122a.add(a0Var);
    }

    public void e(List<HeadImgs> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (HeadImgs headImgs : list) {
            d(headImgs);
        }
    }

    public void f(ArrayList<a0> arrayList) {
        this.f50122a = arrayList;
    }
}
