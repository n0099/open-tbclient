package d.a.m0.q;

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
    public Set<String> f52105a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.q.e.a<List<d.a.m0.q.a>> f52106b;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f52107a = new d(null);
    }

    static {
        String str = ProcessUtils.getCurProcessName() + ".trace";
        AppRuntime.getAppContext().getExternalFilesDir(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d b() {
        return b.f52107a;
    }

    public void a(View view) {
    }

    public d.a.m0.q.e.a<List<d.a.m0.q.a>> c() {
        return this.f52106b;
    }

    public Set<String> d() {
        Set<String> set = this.f52105a;
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.f52105a = hashSet;
        hashSet.add("V8JavaScriptContext");
        this.f52105a.add(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
        return this.f52105a;
    }

    @SuppressLint({"NewApi"})
    public void e() {
    }

    public void f() {
    }

    public d() {
    }
}
