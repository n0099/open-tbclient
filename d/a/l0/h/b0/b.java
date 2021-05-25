package d.a.l0.h.b0;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.facebook.common.internal.Sets;
import d.a.l0.a.k;
import d.a.l0.a.n0.d;
import d.a.l0.a.n0.f;
import d.a.l0.a.v1.c.f.e;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class b extends d.a.l0.a.v1.a.a.a implements d.a.l0.a.v1.c.f.a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47167g = k.f43199a;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f47168h = Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline");

    /* renamed from: i  reason: collision with root package name */
    public static long f47169i = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: f  reason: collision with root package name */
    public int f47170f = SwanAppProcessInfo.UNKNOWN.index;

    /* loaded from: classes3.dex */
    public class a implements h.n.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47171e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f47172f;

        public a(boolean z, Bundle bundle) {
            this.f47171e = z;
            this.f47172f = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            if (this.f47171e) {
                if (b.f47167g) {
                    Log.i("SwanGameReloadDelegate", "execCall: addCallback CALLBACK_TERM = " + b.f47169i);
                }
                e.k().c(b.this, b.f47169i);
            }
            d d2 = f.c().d();
            if (d2 != null) {
                List<String> singletonList = Collections.singletonList(this.f47172f.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                d.a.l0.a.n0.l.c l = d.a.l0.a.n0.l.c.l();
                l.i(6);
                d2.h(singletonList, true, l.k());
            }
            if (b.f47167g) {
                Log.i("SwanGameReloadDelegate", "execCall: addCallback purge finish = " + d2);
            }
            if (this.f47171e) {
                return;
            }
            b.this.h();
        }
    }

    @Override // d.a.l0.a.v1.c.f.a
    public void a(String str, d.a.l0.a.v1.c.f.c cVar) {
        if (cVar.f45331f.index == this.f47170f && f47168h.contains(str)) {
            e.k().h(this);
            if (f47167g) {
                Log.i("SwanGameReloadDelegate", "onEvent: event = " + str);
            }
            h();
        }
    }

    @Override // d.a.l0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        int i2 = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
        this.f47170f = i2;
        boolean checkProcessId = SwanAppProcessInfo.checkProcessId(i2);
        if (f47167g) {
            Log.i("SwanGameReloadDelegate", "execCall: target = " + this.f47170f);
            Log.i("SwanGameReloadDelegate", "execCall: waitCallback = " + checkProcessId);
        }
        h.d.i("").o(Schedulers.io()).B(new a(checkProcessId, bundle));
    }

    public final void h() {
        String string = this.f45269a.getString("scheme");
        if (f47167g) {
            Log.i("SwanGameReloadDelegate", "invoke: scheme = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        SchemeRouter.invoke(AppRuntime.getAppContext(), string);
    }

    @Override // d.a.l0.a.v1.c.f.a
    public void timeout() {
        if (f47167g) {
            Log.i("SwanGameReloadDelegate", "timeout");
        }
        h();
    }
}
