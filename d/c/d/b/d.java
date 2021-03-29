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
    public Map<c, List<b>> f65810a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f65811b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final List<i> f65812c;

    /* renamed from: d  reason: collision with root package name */
    public final List<i> f65813d;

    /* renamed from: e  reason: collision with root package name */
    public k f65814e;

    public d() {
        new CopyOnWriteArrayList();
        this.f65812c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.f65813d = new CopyOnWriteArrayList();
        this.f65814e = null;
    }

    @Nullable
    public List<b> a(c cVar) {
        return this.f65810a.get(cVar);
    }

    public Map<String, String> b() {
        return this.f65811b;
    }

    public void c(k kVar) {
        this.f65814e = kVar;
    }

    public void d(Map<? extends String, ? extends String> map) {
        this.f65811b.putAll(map);
    }

    @NonNull
    public List<i> e() {
        return this.f65812c;
    }

    @NonNull
    public List<i> f() {
        return this.f65813d;
    }

    @Nullable
    public k g() {
        return this.f65814e;
    }
}
