package d.c.d.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.tea.crash.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Map<c, List<b>> f65809a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f65810b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final List<i> f65811c;

    /* renamed from: d  reason: collision with root package name */
    public final List<i> f65812d;

    /* renamed from: e  reason: collision with root package name */
    public k f65813e;

    public d() {
        new CopyOnWriteArrayList();
        this.f65811c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.f65812d = new CopyOnWriteArrayList();
        this.f65813e = null;
    }

    @Nullable
    public List<b> a(c cVar) {
        return this.f65809a.get(cVar);
    }

    public Map<String, String> b() {
        return this.f65810b;
    }

    public void c(k kVar) {
        this.f65813e = kVar;
    }

    public void d(Map<? extends String, ? extends String> map) {
        this.f65810b.putAll(map);
    }

    @NonNull
    public List<i> e() {
        return this.f65811c;
    }

    @NonNull
    public List<i> f() {
        return this.f65812d;
    }

    @Nullable
    public k g() {
        return this.f65813e;
    }
}
