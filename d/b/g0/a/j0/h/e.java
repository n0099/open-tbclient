package d.b.g0.a.j0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class e implements a {

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f44815b;

    public e(@Nullable Set<String> set) {
        this.f44815b = set;
    }

    @Override // d.b.g0.a.j0.h.a
    @Nullable
    public List<String> a(@Nullable List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                if (TextUtils.equals(next, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                    if (a.f44813a) {
                        Log.d("IDiskCleanStrategy", "过滤「智能小程序」");
                    }
                    it.remove();
                } else {
                    Set<String> set = this.f44815b;
                    if (set != null && set.contains(next)) {
                        if (a.f44813a) {
                            Log.d("IDiskCleanStrategy", "过滤指定id: " + next);
                        }
                        it.remove();
                    }
                }
            }
        }
        return list;
    }
}
