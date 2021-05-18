package d.a.i0.q;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Set<String> f48147a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.q.e.a<List<d.a.i0.q.a>> f48148b;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f48149a = new d(null);
    }

    static {
        String str = ProcessUtils.getCurProcessName() + ".trace";
        AppRuntime.getAppContext().getExternalFilesDir(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d b() {
        return b.f48149a;
    }

    public void a(View view) {
    }

    public d.a.i0.q.e.a<List<d.a.i0.q.a>> c() {
        return this.f48148b;
    }

    public Set<String> d() {
        Set<String> set = this.f48147a;
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.f48147a = hashSet;
        hashSet.add("V8JavaScriptContext");
        this.f48147a.add(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
        return this.f48147a;
    }

    @SuppressLint({"NewApi"})
    public void e() {
    }

    public void f() {
    }

    public d() {
    }
}
