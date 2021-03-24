package d.a.a.s;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LruCache;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public static final g f41345b = new g();

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, d.a.a.d> f41346a = new LruCache<>(10485760);

    public static g b() {
        return f41345b;
    }

    @Nullable
    public d.a.a.d a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f41346a.get(str);
    }

    public void c(@Nullable String str, d.a.a.d dVar) {
        if (str == null) {
            return;
        }
        this.f41346a.put(str, dVar);
    }
}
