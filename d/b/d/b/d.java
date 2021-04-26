package d.b.d.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.tea.crash.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Map<c, List<b>> f65153a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f65154b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final List<i> f65155c;

    /* renamed from: d  reason: collision with root package name */
    public final List<i> f65156d;

    /* renamed from: e  reason: collision with root package name */
    public k f65157e;

    public d() {
        new CopyOnWriteArrayList();
        this.f65155c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.f65156d = new CopyOnWriteArrayList();
        this.f65157e = null;
    }

    @Nullable
    public List<b> a(c cVar) {
        return this.f65153a.get(cVar);
    }

    public Map<String, String> b() {
        return this.f65154b;
    }

    public void c(k kVar) {
        this.f65157e = kVar;
    }

    public void d(Map<? extends String, ? extends String> map) {
        this.f65154b.putAll(map);
    }

    @NonNull
    public List<i> e() {
        return this.f65155c;
    }

    @NonNull
    public List<i> f() {
        return this.f65156d;
    }

    @Nullable
    public k g() {
        return this.f65157e;
    }
}
