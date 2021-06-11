package d.a.l0.q;

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
    public Set<String> f51997a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.q.e.a<List<d.a.l0.q.a>> f51998b;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f51999a = new d(null);
    }

    static {
        String str = ProcessUtils.getCurProcessName() + ".trace";
        AppRuntime.getAppContext().getExternalFilesDir(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d b() {
        return b.f51999a;
    }

    public void a(View view) {
    }

    public d.a.l0.q.e.a<List<d.a.l0.q.a>> c() {
        return this.f51998b;
    }

    public Set<String> d() {
        Set<String> set = this.f51997a;
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.f51997a = hashSet;
        hashSet.add("V8JavaScriptContext");
        this.f51997a.add(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
        return this.f51997a;
    }

    @SuppressLint({"NewApi"})
    public void e() {
    }

    public void f() {
    }

    public d() {
    }
}
