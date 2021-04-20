package d.c.d.b;

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
    public Map<c, List<b>> f66655a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f66656b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final List<i> f66657c;

    /* renamed from: d  reason: collision with root package name */
    public final List<i> f66658d;

    /* renamed from: e  reason: collision with root package name */
    public k f66659e;

    public d() {
        new CopyOnWriteArrayList();
        this.f66657c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.f66658d = new CopyOnWriteArrayList();
        this.f66659e = null;
    }

    @Nullable
    public List<b> a(c cVar) {
        return this.f66655a.get(cVar);
    }

    public Map<String, String> b() {
        return this.f66656b;
    }

    public void c(k kVar) {
        this.f66659e = kVar;
    }

    public void d(Map<? extends String, ? extends String> map) {
        this.f66656b.putAll(map);
    }

    @NonNull
    public List<i> e() {
        return this.f66657c;
    }

    @NonNull
    public List<i> f() {
        return this.f66658d;
    }

    @Nullable
    public k g() {
        return this.f66659e;
    }
}
