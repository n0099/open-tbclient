package d.b.g0.a.j0.h;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f45206b;

    public b(int i) {
        this.f45206b = i;
    }

    @Override // d.b.g0.a.j0.h.a
    @Nullable
    public List<String> a(@Nullable List<String> list) {
        if (list == null || list.size() == 0 || this.f45206b < 0) {
            return null;
        }
        if (list.size() < this.f45206b) {
            if (a.f45205a) {
                Log.d("IDiskCleanStrategy", "数量未达到上限，无需删除");
            }
            return null;
        }
        int size = list.size() - this.f45206b;
        int size2 = list.size() - size;
        int size3 = list.size();
        if (a.f45205a) {
            Log.d("IDiskCleanStrategy", "过滤后的列表有" + list.size() + "个小程序，上限" + this.f45206b + "个，删除最早的" + size + "个");
        }
        return list.subList(size2, size3);
    }
}
