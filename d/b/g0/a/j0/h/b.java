package d.b.g0.a.j0.h;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f44813b;

    public b(int i) {
        this.f44813b = i;
    }

    @Override // d.b.g0.a.j0.h.a
    @Nullable
    public List<String> a(@Nullable List<String> list) {
        if (list == null || list.size() == 0 || this.f44813b < 0) {
            return null;
        }
        if (list.size() < this.f44813b) {
            if (a.f44812a) {
                Log.d("IDiskCleanStrategy", "数量未达到上限，无需删除");
            }
            return null;
        }
        int size = list.size() - this.f44813b;
        int size2 = list.size() - size;
        int size3 = list.size();
        if (a.f44812a) {
            Log.d("IDiskCleanStrategy", "过滤后的列表有" + list.size() + "个小程序，上限" + this.f44813b + "个，删除最早的" + size + "个");
        }
        return list.subList(size2, size3);
    }
}
