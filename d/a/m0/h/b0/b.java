package d.a.m0.h.b0;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.facebook.common.internal.Sets;
import d.a.m0.a.k;
import d.a.m0.a.n0.d;
import d.a.m0.a.n0.f;
import d.a.m0.a.v1.c.f.e;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class b extends d.a.m0.a.v1.a.a.a implements d.a.m0.a.v1.c.f.a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f50949g = k.f46983a;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f50950h = Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline");

    /* renamed from: i  reason: collision with root package name */
    public static long f50951i = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: f  reason: collision with root package name */
    public int f50952f = SwanAppProcessInfo.UNKNOWN.index;

    /* loaded from: classes3.dex */
    public class a implements h.n.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50953e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f50954f;

        public a(boolean z, Bundle bundle) {
            this.f50953e = z;
            this.f50954f = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            if (this.f50953e) {
                if (b.f50949g) {
                    Log.i("SwanGameReloadDelegate", "execCall: addCallback CALLBACK_TERM = " + b.f50951i);
                }
                e.k().c(b.this, b.f50951i);
            }
            d d2 = f.c().d();
            if (d2 != null) {
                List<String> singletonList = Collections.singletonList(this.f50954f.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                d.a.m0.a.n0.l.c l = d.a.m0.a.n0.l.c.l();
                l.i(6);
                d2.h(singletonList, true, l.k());
            }
            if (b.f50949g) {
                Log.i("SwanGameReloadDelegate", "execCall: addCallback purge finish = " + d2);
            }
            if (this.f50953e) {
                return;
            }
            b.this.h();
        }
    }

    @Override // d.a.m0.a.v1.c.f.a
    public void a(String str, d.a.m0.a.v1.c.f.c cVar) {
        if (cVar.f49113f.index == this.f50952f && f50950h.contains(str)) {
            e.k().h(this);
            if (f50949g) {
                Log.i("SwanGameReloadDelegate", "onEvent: event = " + str);
            }
            h();
        }
    }

    @Override // d.a.m0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        int i2 = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
        this.f50952f = i2;
        boolean checkProcessId = SwanAppProcessInfo.checkProcessId(i2);
        if (f50949g) {
            Log.i("SwanGameReloadDelegate", "execCall: target = " + this.f50952f);
            Log.i("SwanGameReloadDelegate", "execCall: waitCallback = " + checkProcessId);
        }
        h.d.i("").o(Schedulers.io()).B(new a(checkProcessId, bundle));
    }

    public final void h() {
        String string = this.f49051a.getString("scheme");
        if (f50949g) {
            Log.i("SwanGameReloadDelegate", "invoke: scheme = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        SchemeRouter.invoke(AppRuntime.getAppContext(), string);
    }

    @Override // d.a.m0.a.v1.c.f.a
    public void timeout() {
        if (f50949g) {
            Log.i("SwanGameReloadDelegate", "timeout");
        }
        h();
    }
}
