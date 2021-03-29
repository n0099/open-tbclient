package d.b.g0.g.y;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.facebook.common.internal.Sets;
import d.b.g0.a.k;
import d.b.g0.a.n1.c.f.e;
import h.d;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class b extends d.b.g0.a.n1.a.a.a implements d.b.g0.a.n1.c.f.a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f48687g = k.f45051a;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f48688h = Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline");
    public static long i = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: f  reason: collision with root package name */
    public int f48689f = SwanAppProcessInfo.UNKNOWN.index;

    /* loaded from: classes3.dex */
    public class a implements h.n.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48690e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f48691f;

        public a(boolean z, Bundle bundle) {
            this.f48690e = z;
            this.f48691f = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            if (this.f48690e) {
                if (b.f48687g) {
                    Log.i("SwanGameReloadDelegate", "execCall: addCallback CALLBACK_TERM = " + b.i);
                }
                e.j().b(b.this, b.i);
            }
            d.b.g0.a.j0.c d2 = d.b.g0.a.j0.e.c().d();
            if (d2 != null) {
                List<String> singletonList = Collections.singletonList(this.f48691f.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                d.b.g0.a.j0.j.c k = d.b.g0.a.j0.j.c.k();
                k.h(6);
                d2.h(singletonList, true, k.j());
            }
            if (b.f48687g) {
                Log.i("SwanGameReloadDelegate", "execCall: addCallback purge finish = " + d2);
            }
            if (this.f48690e) {
                return;
            }
            b.this.h();
        }
    }

    @Override // d.b.g0.a.n1.c.f.a
    public void a(String str, d.b.g0.a.n1.c.f.c cVar) {
        if (cVar.f45391f.index == this.f48689f && f48688h.contains(str)) {
            e.j().g(this);
            if (f48687g) {
                Log.i("SwanGameReloadDelegate", "onEvent: event = " + str);
            }
            h();
        }
    }

    @Override // d.b.g0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        int i2 = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
        this.f48689f = i2;
        boolean checkProcessId = SwanAppProcessInfo.checkProcessId(i2);
        if (f48687g) {
            Log.i("SwanGameReloadDelegate", "execCall: target = " + this.f48689f);
            Log.i("SwanGameReloadDelegate", "execCall: waitCallback = " + checkProcessId);
        }
        d.j("").p(Schedulers.io()).D(new a(checkProcessId, bundle));
    }

    public final void h() {
        String string = this.f45337a.getString("scheme");
        if (f48687g) {
            Log.i("SwanGameReloadDelegate", "invoke: scheme = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        SchemeRouter.invoke(AppRuntime.getAppContext(), string);
    }

    @Override // d.b.g0.a.n1.c.f.a
    public void timeout() {
        if (f48687g) {
            Log.i("SwanGameReloadDelegate", com.alipay.sdk.data.a.i);
        }
        h();
    }
}
