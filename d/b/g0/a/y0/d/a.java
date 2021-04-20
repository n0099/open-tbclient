package d.b.g0.a.y0.d;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Label;
import com.android.internal.http.multipart.Part;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.facebook.common.internal.Sets;
import d.b.g0.a.h;
import d.b.g0.a.i2.j;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.q;
import d.b.g0.a.i2.x;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.a.n1.c.f.e;
import d.b.g0.a.z0.f;
import d.b.g0.p.d;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47475a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f47476b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final long f47477c = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: d.b.g0.a.y0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0895a implements d.b.g0.a.n1.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f47478a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Set f47479b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47480c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47481d;

        public C0895a(int i, Set set, String str, String str2) {
            this.f47478a = i;
            this.f47479b = set;
            this.f47480c = str;
            this.f47481d = str2;
        }

        @Override // d.b.g0.a.n1.c.f.a
        public void a(String str, d.b.g0.a.n1.c.f.c cVar) {
            if (cVar.f45783f.index == this.f47478a && this.f47479b.contains(str)) {
                e.j().g(this);
                a.i(this.f47480c, this.f47481d);
            }
        }

        @Override // d.b.g0.a.n1.c.f.a
        public void timeout() {
            a.i(this.f47480c, this.f47481d);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements DialogInterface.OnDismissListener {
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            boolean unused = a.f47476b = false;
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            if (bundle != null) {
                a.j(bundle.getString("arg_title"), bundle.getString("arg_message"), bundle.getInt("arg_match_target_down", SwanAppProcessInfo.UNKNOWN.index));
                return null;
            }
            return null;
        }
    }

    public static void d(Context context, @NonNull d.b.g0.a.f2.a aVar, int i, String str) {
        e(context, aVar, i, str, null);
    }

    public static void e(Context context, @NonNull d.b.g0.a.f2.a aVar, int i, String str, Bundle bundle) {
        i.j(aVar);
        g(context, aVar, i, str, false, bundle);
    }

    public static void f(Context context, @NonNull d.b.g0.a.f2.a aVar, int i, String str, boolean z) {
        g(context, aVar, i, str, z, null);
    }

    public static void g(Context context, @NonNull d.b.g0.a.f2.a aVar, int i, String str, boolean z, Bundle bundle) {
        File a2;
        if (context == null) {
            return;
        }
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            d.b.g0.a.c0.c.h("LaunchError", "launch activity closed, ignore launch error");
            return;
        }
        d.b.g0.a.c0.c.h("LaunchError", "handleLaunchError errCode: " + aVar.toString());
        String g2 = d.b.g0.a.b2.b.g(f.V().L(), i);
        long g3 = aVar.g();
        String q = aVar.q();
        boolean z2 = 1020 == g3 && !TextUtils.isEmpty(q);
        String a3 = z2 ? q : d.b.g0.l.m.i.e.b().a(g3);
        String format = String.format(context.getResources().getString(h.aiapps_open_failed_detail_format), k0.z(), g2, String.valueOf(aVar.a()));
        if (!d.b.g0.a.w0.a.E().a(context, str, aVar)) {
            if (i == 0) {
                l(context, str, a3, format, bundle);
            } else if (i == 1) {
                m(context, str, a3, z2 ? q : d.b.g0.l.m.i.e.b().c(g3), format, (z ? SwanAppProcessInfo.current() : SwanAppProcessInfo.UNKNOWN).index);
            }
        }
        StringBuilder sb = new StringBuilder();
        String b2 = j.b(j.a(), "yyyy-MM-dd HH:mm:ss");
        if (!TextUtils.isEmpty(str)) {
            sb.append(b2);
            sb.append(": ");
            sb.append(str);
            sb.append(Part.CRLF);
        }
        sb.append(b2);
        sb.append(": ");
        sb.append(format);
        sb.append(Part.CRLF);
        q.c(sb.toString(), false);
        d.b.g0.a.z1.l.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
        if (k.f45443a) {
            String u = k0.u();
            if (TextUtils.isEmpty(u) || (a2 = d.b.g0.a.i2.k.a()) == null) {
                return;
            }
            File file = new File(a2.getPath(), "error_dialog_info.txt");
            d.f(file);
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(format)) {
                sb2.append(format);
                sb2.append("\n");
            }
            sb2.append(u);
            sb2.append("\n");
            d.y(sb2.toString(), file);
        }
    }

    public static boolean h(@NonNull Context context, @Nullable String str) {
        return (TextUtils.isEmpty(str) || SwanAppNetworkUtils.h(context) || d.b.g0.a.y0.h.a.d(str)) ? false : true;
    }

    public static void i(String str, String str2) {
        if (f47476b) {
            return;
        }
        BaseActivityDialog.c newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.B(str);
        newBuilder.x(new b());
        newBuilder.u(str2);
        newBuilder.y(h.aiapps_open_failed_button, null);
        newBuilder.C();
        f47476b = true;
    }

    public static void j(String str, String str2, int i) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString("arg_title", str);
            bundle.putString("arg_message", str2);
            bundle.putInt("arg_match_target_down", i);
            DelegateUtils.callOnMainWithContentProvider(d.b.g0.a.w0.a.c(), c.class, bundle);
            return;
        }
        if (f47475a) {
            Log.d("LaunchError", "show normal err dialog, isShowing=" + f47476b);
        }
        if (!SwanAppProcessInfo.checkProcessId(i)) {
            i(str, str2);
            return;
        }
        e.j().b(new C0895a(i, Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline"), str, str2), f47477c);
    }

    public static void k(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        String format = String.format(context.getResources().getString(h.swanapp_launch_err_toast_format), str, str2);
        if (f47475a) {
            Log.d("LaunchError", "show normal err toast: " + format);
        }
        d.b.g0.a.q1.b.f.d f2 = d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), format);
        f2.o(Integer.MAX_VALUE);
        f2.B();
    }

    public static void l(Context context, String str, String str2, String str3, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, h(context, str) ? SwanAppErrorActivity.TYPE_NETWORK_ERROR : SwanAppErrorActivity.TYPE_NORMAL);
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O != null) {
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(O.J(), str2, str3);
            forbiddenInfo.enableSlidingFlag = -1;
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_FORBIDDEN_INFO, forbiddenInfo);
        }
        intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    public static void m(Context context, String str, String str2, String str3, String str4, int i) {
        if (h(context, str)) {
            if (x.a(context)) {
                d.b.g0.a.q1.b.f.d.e(AppRuntime.getAppContext(), h.aiapps_net_error).C();
                return;
            }
            if (f47475a) {
                Log.w("LaunchError", "show network err toast: areNotificationsEnabled false");
            }
            j(str2, str4, i);
        } else if (x.a(context)) {
            k(context, str3, str4);
        } else {
            if (f47475a) {
                Log.w("LaunchError", "handleLaunchError: areNotificationsEnabled false");
            }
            j(str2, str4, i);
        }
    }
}
