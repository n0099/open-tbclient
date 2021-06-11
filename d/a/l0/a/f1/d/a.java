package d.a.l0.a.f1.d;

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
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.facebook.common.internal.Sets;
import d.a.l0.a.e0.d;
import d.a.l0.a.g1.f;
import d.a.l0.a.k;
import d.a.l0.a.r1.h;
import d.a.l0.a.v1.c.f.e;
import d.a.l0.a.v2.l;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.r;
import d.a.l0.a.v2.z;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45504a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f45505b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final long f45506c = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: d.a.l0.a.f1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0686a implements d.a.l0.a.v1.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45507a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Set f45508b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45509c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f45510d;

        public C0686a(int i2, Set set, String str, String str2) {
            this.f45507a = i2;
            this.f45508b = set;
            this.f45509c = str;
            this.f45510d = str2;
        }

        @Override // d.a.l0.a.v1.c.f.a
        public void a(String str, d.a.l0.a.v1.c.f.c cVar) {
            if (cVar.f49005f.index == this.f45507a && this.f45508b.contains(str)) {
                e.k().h(this);
                a.h(this.f45509c, this.f45510d);
            }
        }

        @Override // d.a.l0.a.v1.c.f.a
        public void timeout() {
            a.h(this.f45509c, this.f45510d);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements DialogInterface.OnDismissListener {
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            boolean unused = a.f45505b = false;
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends ProviderDelegation {

        /* renamed from: d.a.l0.a.f1.d.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0687a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bundle f45511e;

            public RunnableC0687a(c cVar, Bundle bundle) {
                this.f45511e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.i(this.f45511e.getString("arg_title"), this.f45511e.getString("arg_message"), this.f45511e.getInt("arg_match_target_down", SwanAppProcessInfo.UNKNOWN.index));
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            if (bundle != null) {
                q0.b0(new RunnableC0687a(this, bundle));
                return null;
            }
            return null;
        }
    }

    public static void d(Context context, @NonNull d.a.l0.a.q2.a aVar, int i2, String str) {
        e(context, aVar, i2, str, null);
    }

    public static void e(Context context, @NonNull d.a.l0.a.q2.a aVar, int i2, String str, Bundle bundle) {
        h.k(aVar);
        f(context, aVar, i2, str, false, bundle);
    }

    public static void f(Context context, @NonNull d.a.l0.a.q2.a aVar, int i2, String str, boolean z, Bundle bundle) {
        File a2;
        if (context == null) {
            return;
        }
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            d.h("LaunchError", "launch activity closed, ignore launch error");
            return;
        }
        d.h("LaunchError", "handleLaunchError errCode: " + aVar.toString());
        String i3 = d.a.l0.a.m2.b.i(f.V().N(), i2);
        long g2 = aVar.g();
        String q = aVar.q();
        boolean z2 = 1020 == g2 && !TextUtils.isEmpty(q);
        String a3 = z2 ? q : d.a.l0.n.j.i.f.b().a(g2);
        String format = String.format(context.getResources().getString(d.a.l0.a.h.aiapps_open_failed_detail_format), q0.D(), i3, String.valueOf(aVar.a()));
        if (!d.a.l0.a.c1.a.O().a(context, str, aVar)) {
            if (i2 == 0) {
                String str2 = g(context, str) ? SwanAppErrorActivity.TYPE_NETWORK_ERROR : SwanAppErrorActivity.TYPE_NORMAL;
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(d.a.l0.a.a2.d.g().r().L(), a3, format);
                forbiddenInfo.enableSlidingFlag = -1;
                k(context, str2, bundle, forbiddenInfo);
            } else if (i2 == 1) {
                l(context, str, a3, z2 ? q : d.a.l0.n.j.i.f.b().c(g2), format, (z ? SwanAppProcessInfo.current() : SwanAppProcessInfo.UNKNOWN).index);
            }
        }
        StringBuilder sb = new StringBuilder();
        String b2 = d.a.l0.a.v2.k.b(d.a.l0.a.v2.k.a(), "yyyy-MM-dd HH:mm:ss");
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
        r.c(sb.toString(), false);
        if (k.f46875a) {
            String y = q0.y();
            if (TextUtils.isEmpty(y) || (a2 = l.a()) == null) {
                return;
            }
            File file = new File(a2.getPath(), "error_dialog_info.txt");
            d.a.l0.t.d.i(file);
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(format)) {
                sb2.append(format);
                sb2.append("\n");
            }
            sb2.append(y);
            sb2.append("\n");
            d.a.l0.t.d.M(sb2.toString(), file);
        }
    }

    public static boolean g(@NonNull Context context, @Nullable String str) {
        return (TextUtils.isEmpty(str) || SwanAppNetworkUtils.i(context) || d.a.l0.a.f1.h.a.d(str)) ? false : true;
    }

    public static void h(String str, String str2) {
        if (f45505b) {
            return;
        }
        BaseActivityDialog.e newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.C(str);
        newBuilder.y(new b());
        newBuilder.v(str2);
        newBuilder.z(d.a.l0.a.h.aiapps_confirm_text, null);
        newBuilder.D();
        f45505b = true;
    }

    public static void i(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString("arg_title", str);
            bundle.putString("arg_message", str2);
            bundle.putInt("arg_match_target_down", i2);
            d.a.l0.a.v1.b.d.b(c.class, bundle);
            return;
        }
        if (f45504a) {
            Log.d("LaunchError", "show normal err dialog, isShowing=" + f45505b);
        }
        if (!SwanAppProcessInfo.checkProcessId(i2)) {
            h(str, str2);
            return;
        }
        e.k().c(new C0686a(i2, Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline"), str, str2), f45506c);
    }

    public static void j(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        String format = String.format(context.getResources().getString(d.a.l0.a.h.swanapp_launch_err_toast_format), str, str2);
        if (f45504a) {
            Log.d("LaunchError", "show normal err toast: " + format);
        }
        d.a.l0.a.z1.b.f.e g2 = d.a.l0.a.z1.b.f.e.g(AppRuntime.getAppContext(), format);
        g2.p(Integer.MAX_VALUE);
        g2.E();
    }

    public static void k(Context context, String str, Bundle bundle, ForbiddenInfo forbiddenInfo) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        int g2 = d.a.l0.a.k1.a.g();
        int h2 = d.a.l0.a.k1.a.h(context);
        intent.putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, str);
        intent.putExtra(SwanAppErrorActivity.KEY_ERROR_FORBIDDEN_INFO, forbiddenInfo);
        intent.putExtra(SwanAppErrorActivity.KEY_ERROR_MENU_NOTICE_COUNT, g2);
        intent.putExtra(SwanAppErrorActivity.KEY_ERROR_MENU_PRIVACY_COUNT, h2);
        intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    public static void l(Context context, String str, String str2, String str3, String str4, int i2) {
        if (g(context, str)) {
            if (z.a(context)) {
                d.a.l0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.l0.a.h.aiapps_net_error).F();
                return;
            }
            if (f45504a) {
                Log.w("LaunchError", "show network err toast: areNotificationsEnabled false");
            }
            i(str2, str4, i2);
        } else if (z.a(context)) {
            j(context, str3, str4);
        } else {
            if (f45504a) {
                Log.w("LaunchError", "handleLaunchError: areNotificationsEnabled false");
            }
            i(str2, str4, i2);
        }
    }
}
