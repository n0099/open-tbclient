package d.b.g0.a.j0.h;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class d implements a {
    @Override // d.b.g0.a.j0.h.a
    @Nullable
    public List<String> a(@Nullable List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        Set<String> i = d.b.g0.a.g0.d.b.i(AppRuntime.getAppContext().getContentResolver());
        if (i.size() == 0) {
            return list;
        }
        list.removeAll(i);
        if (a.f44813a) {
            Log.d("IDiskCleanStrategy", "共" + i.size() + "个历史，尝试过滤");
        }
        return list;
    }
}
