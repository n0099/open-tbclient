package d.a.n0.j0.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<f> f59541a = new ArrayList<>();

    public void a() {
        Iterator<f> it = this.f59541a.iterator();
        while (it.hasNext()) {
            it.next().V(0);
        }
    }

    public ArrayList<f> b() {
        return this.f59541a;
    }

    public void c(List<?> list) {
        if (list == null) {
            return;
        }
        d(list, null);
    }

    public void d(List<?> list, Context context) {
        if (list == null) {
            return;
        }
        try {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (!(list.get(i2) instanceof LikeForum)) {
                    return;
                }
                f fVar = new f();
                fVar.S((LikeForum) list.get(i2));
                if (!TextUtils.isEmpty(fVar.G())) {
                    this.f59541a.add(fVar);
                }
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
