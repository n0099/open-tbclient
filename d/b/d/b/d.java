package d.b.d.b;

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
    public Map<c, List<b>> f69613a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f69614b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final List<i> f69615c;

    /* renamed from: d  reason: collision with root package name */
    public final List<i> f69616d;

    /* renamed from: e  reason: collision with root package name */
    public k f69617e;

    public d() {
        new CopyOnWriteArrayList();
        this.f69615c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.f69616d = new CopyOnWriteArrayList();
        this.f69617e = null;
    }

    @Nullable
    public List<b> a(c cVar) {
        return this.f69613a.get(cVar);
    }

    public Map<String, String> b() {
        return this.f69614b;
    }

    public void c(k kVar) {
        this.f69617e = kVar;
    }

    public void d(Map<? extends String, ? extends String> map) {
        this.f69614b.putAll(map);
    }

    @NonNull
    public List<i> e() {
        return this.f69615c;
    }

    @NonNull
    public List<i> f() {
        return this.f69616d;
    }

    @Nullable
    public k g() {
        return this.f69617e;
    }
}
