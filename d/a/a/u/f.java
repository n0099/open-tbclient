package d.a.a.u;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LruCache;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static final f f41740b = new f();

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, d.a.a.d> f41741a = new LruCache<>(20);

    public static f b() {
        return f41740b;
    }

    @Nullable
    public d.a.a.d a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f41741a.get(str);
    }

    public void c(@Nullable String str, d.a.a.d dVar) {
        if (str == null) {
            return;
        }
        this.f41741a.put(str, dVar);
    }
}
