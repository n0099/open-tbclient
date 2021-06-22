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
    public Map<c, List<b>> f69717a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f69718b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final List<i> f69719c;

    /* renamed from: d  reason: collision with root package name */
    public final List<i> f69720d;

    /* renamed from: e  reason: collision with root package name */
    public k f69721e;

    public d() {
        new CopyOnWriteArrayList();
        this.f69719c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.f69720d = new CopyOnWriteArrayList();
        this.f69721e = null;
    }

    @Nullable
    public List<b> a(c cVar) {
        return this.f69717a.get(cVar);
    }

    public Map<String, String> b() {
        return this.f69718b;
    }

    public void c(k kVar) {
        this.f69721e = kVar;
    }

    public void d(Map<? extends String, ? extends String> map) {
        this.f69718b.putAll(map);
    }

    @NonNull
    public List<i> e() {
        return this.f69719c;
    }

    @NonNull
    public List<i> f() {
        return this.f69720d;
    }

    @Nullable
    public k g() {
        return this.f69721e;
    }
}
