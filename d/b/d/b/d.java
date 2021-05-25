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
    public Map<c, List<b>> f65882a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f65883b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final List<i> f65884c;

    /* renamed from: d  reason: collision with root package name */
    public final List<i> f65885d;

    /* renamed from: e  reason: collision with root package name */
    public k f65886e;

    public d() {
        new CopyOnWriteArrayList();
        this.f65884c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.f65885d = new CopyOnWriteArrayList();
        this.f65886e = null;
    }

    @Nullable
    public List<b> a(c cVar) {
        return this.f65882a.get(cVar);
    }

    public Map<String, String> b() {
        return this.f65883b;
    }

    public void c(k kVar) {
        this.f65886e = kVar;
    }

    public void d(Map<? extends String, ? extends String> map) {
        this.f65883b.putAll(map);
    }

    @NonNull
    public List<i> e() {
        return this.f65884c;
    }

    @NonNull
    public List<i> f() {
        return this.f65885d;
    }

    @Nullable
    public k g() {
        return this.f65886e;
    }
}
