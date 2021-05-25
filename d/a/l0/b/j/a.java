package d.a.l0.b.j;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.b.h;
import d.a.l0.b.j.l;
import d.a.l0.b.k.a;
import d.a.l0.b.l.b;
import d.a.l0.b.o.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46235a = d.a.l0.a.k.f43199a;

    /* renamed from: d.a.l0.b.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0941a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.m.a f46236a;

        public C0941a(d.a.l0.a.m.a aVar) {
            this.f46236a = aVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (this.f46236a == null) {
                return;
            }
            if (!delegateResult.isOk()) {
                this.f46236a.onResult(-1);
                return;
            }
            this.f46236a.onResult(delegateResult.mResult.getInt("result_code", -1));
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.a.l0.a.v1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.c f46237c;

        public b(b.c cVar) {
            this.f46237c = cVar;
        }

        @Override // d.a.l0.a.v1.a.b.c.b, d.a.l0.a.v1.a.b.c.a
        public long a() {
            return StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v1.a.b.c.b, d.a.l0.a.v1.a.b.c.c, d.a.l0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.l0.a.v1.a.b.a.b bVar) {
            if (a.f46235a) {
                Log.d("AccountUtils", "get openBduss messenger delegate observer receive event");
            }
            String str = null;
            if (bVar.a() != null) {
                if (a.f46235a) {
                    Log.d("AccountUtils", "get openBduss : result " + bVar.a());
                }
                str = bVar.a().getString("result");
            } else if (a.f46235a) {
                Log.d("AccountUtils", "get openBduss : result null");
            }
            this.f46237c.a(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends d.a.l0.a.v1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f46238c;

        public c(d.a.l0.a.v2.e1.b bVar) {
            this.f46238c = bVar;
        }

        @Override // d.a.l0.a.v1.a.b.c.b, d.a.l0.a.v1.a.b.c.a
        public long a() {
            return StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v1.a.b.c.b, d.a.l0.a.v1.a.b.c.c, d.a.l0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.l0.a.v1.a.b.a.b bVar) {
            if (a.f46235a) {
                Log.d("AccountUtils", "get stoken messenger delegate observer receive event");
            }
            Bundle bundle = null;
            if (bVar.a() != null) {
                if (a.f46235a) {
                    Log.d("AccountUtils", "get stoken : result " + bVar.a());
                }
                bundle = bVar.a().getBundle("key_result_stokent");
            } else if (a.f46235a) {
                Log.d("AccountUtils", "get stoken : result null");
            }
            this.f46238c.onCallback(bundle);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements l.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f46239a;

        public d(d.a.l0.a.v2.e1.b bVar) {
            this.f46239a = bVar;
        }

        @Override // d.a.l0.b.j.l.a
        public void a(l lVar) {
            this.f46239a.onCallback(null);
        }

        @Override // d.a.l0.b.j.l.a
        public void b(l lVar) {
            if (lVar.f46252a != 0 || lVar.f46253b == null) {
                this.f46239a.onCallback(null);
            }
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : lVar.f46253b.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    bundle.putString(key, entry.getValue());
                }
            }
            this.f46239a.onCallback(bundle);
        }

        @Override // d.a.l0.b.j.l.a
        public void onFinish() {
        }

        @Override // d.a.l0.b.j.l.a
        public void onStart() {
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.n.a.b f46240a;

        public e(d.a.l0.a.n.a.b bVar) {
            this.f46240a = bVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            String string = delegateResult.mResult.getString("address_info");
            if (TextUtils.isEmpty(string)) {
                if (d.a.l0.a.k.f43199a) {
                    Log.e("AccountUtils", delegateResult.mResult.getString("errorMsg"));
                }
                this.f46240a.a(0);
                return;
            }
            if (d.a.l0.a.k.f43199a) {
                Log.i("AccountUtils", string);
            }
            this.f46240a.b(d.a.l0.a.v2.w.d(string));
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements b0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f46241a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f46242b;

        public f(Bundle bundle, d.a.l0.a.v2.e1.b bVar) {
            this.f46241a = bundle;
            this.f46242b = bVar;
        }

        @Override // d.a.l0.b.j.b0
        public void a(z zVar) {
            if (a.f46235a) {
                Log.d("AccountUtils", "callbackkey=" + zVar.f46268a);
            }
            this.f46241a.putString("callbackKey", zVar.f46268a);
            d.a.l0.a.v2.e1.b bVar = this.f46242b;
            if (bVar != null) {
                bVar.onCallback(this.f46241a);
            }
        }

        @Override // d.a.l0.b.j.b0
        public void onFailure(String str) {
            if (a.f46235a) {
                Log.d("AccountUtils", "onFailure=" + str);
            }
            this.f46241a.putString("failMsg", str);
            d.a.l0.a.v2.e1.b bVar = this.f46242b;
            if (bVar != null) {
                bVar.onCallback(this.f46241a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f46243a;

        public g(d.a.l0.a.v2.e1.b bVar) {
            this.f46243a = bVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Bundle bundle = delegateResult.mResult;
            d.a.l0.a.v2.e1.b bVar = this.f46243a;
            if (bVar != null) {
                bVar.onCallback(d.a.l0.a.v2.v.d(bundle, "result"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46244e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46245f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46246g;

        public h(Activity activity, String str, String str2) {
            this.f46244e = activity;
            this.f46245f = str;
            this.f46246g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.P(this.f46244e, this.f46245f, this.f46246g);
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46247e;

        public i(Activity activity) {
            this.f46247e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            a.N(this.f46247e, true, null, null);
        }
    }

    public static a0 A(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return v.a().d(context);
        }
        return null;
    }

    public static a0 B(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.a.l0.b.j.i.class, null);
        if (callOnMainWithContentProvider.isOk()) {
            a0 a0Var = new a0();
            a0Var.f46248a = callOnMainWithContentProvider.mResult.getString("NICK_NAME", "");
            a0Var.f46249b = callOnMainWithContentProvider.mResult.getString("AVATAR_URL", "");
            return a0Var;
        }
        return null;
    }

    public static b0 C(d.a.l0.a.v2.e1.b<Bundle> bVar) {
        return new f(new Bundle(), bVar);
    }

    public static String D(Context context) {
        return v.a().e(context);
    }

    public static void E(Activity activity, JSONObject jSONObject) {
        JSONObject c2 = d.a.l0.a.e2.c.d.c(jSONObject);
        if (c2 == null || activity == null) {
            return;
        }
        int optInt = c2.optInt("errno", 10001);
        String optString = c2.optString("tipmsg");
        if (optInt == 401 || optInt == 400701) {
            JSONObject optJSONObject = c2.optJSONObject("tipoption");
            String optString2 = optJSONObject != null ? optJSONObject.optString("title") : null;
            if (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString)) {
                return;
            }
            q0.b0(new h(activity, optString2, optString));
        }
    }

    public static boolean F(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return v.a().h(context);
        }
        return false;
    }

    public static boolean G(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return F(context);
        }
        return H(context);
    }

    public static boolean H(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, j.class, null);
        return callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false);
    }

    public static void I(Activity activity, String str, d.a.l0.a.v2.e1.b<Bundle> bVar) {
        v.a().m(activity, "baidu_mini_programs_" + str, i(activity), C(bVar));
    }

    public static void J(Activity activity, boolean z, String str, d.a.l0.a.v2.e1.b<Bundle> bVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isRealName", z);
        bundle.putString("swanAppId", str);
        DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, d.a.l0.b.j.b.class, bundle, new g(bVar));
    }

    public static void K(Activity activity, String str, String str2, d.a.l0.a.v2.e1.b<Bundle> bVar) {
        boolean equals = TextUtils.equals(str, "1");
        if (!ProcessUtils.isMainProcess()) {
            J(activity, equals, str2, bVar);
        } else if (equals) {
            I(activity, str2, bVar);
        } else {
            L(activity, str2, bVar);
        }
    }

    public static void L(Activity activity, String str, d.a.l0.a.v2.e1.b<Bundle> bVar) {
        v.a().f(activity, "baidu_mini_programs_" + str, i(activity), C(bVar));
    }

    public static void M(Context context, Bundle bundle, d.a.l0.a.m.a aVar) {
        if (!ProcessUtils.isMainProcess()) {
            aVar.onResult(-1);
        } else {
            v.a().c(context, bundle, aVar);
        }
    }

    public static void N(Activity activity, boolean z, Bundle bundle, d.a.l0.a.m.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            M(activity, bundle, aVar);
        } else {
            O(activity, z, bundle, aVar);
        }
    }

    public static void O(Activity activity, boolean z, Bundle bundle, d.a.l0.a.m.a aVar) {
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("key_login_force", z);
        bundle2.putBundle("key_login_params", bundle);
        DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, k.class, bundle2, new C0941a(aVar));
    }

    public static void P(Activity activity, String str, String str2) {
        h.a aVar = new h.a(activity);
        aVar.V(str);
        aVar.x(str2);
        aVar.n(new d.a.l0.a.w2.h.a());
        aVar.m(true);
        aVar.P(activity.getString(d.a.l0.b.g.aiapps_login_immediately), new i(activity));
        aVar.C(activity.getString(d.a.l0.b.g.aiapps_login_refuse), null);
        aVar.X();
    }

    public static void Q(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        v.a().k(context, gVar, str);
    }

    public static void c(d.a.l0.a.m.c cVar) {
        if (cVar == null) {
            return;
        }
        v.a().i(cVar);
    }

    public static void d(Context context, a.d dVar) {
        if (ProcessUtils.isMainProcess()) {
            v.a().j(context, dVar);
        }
    }

    public static void e(Activity activity, d.a.l0.a.n.a.b bVar) {
        DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, d.a.l0.b.k.a.class, new e(bVar));
    }

    public static void f(Context context, a.d dVar) {
        if (ProcessUtils.isMainProcess()) {
            v.a().g(context, dVar);
        }
    }

    public static a0 g(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return A(context);
        }
        return B(context);
    }

    public static String h(Context context) {
        if (ProcessUtils.isMainProcess()) {
            String bduss = v.a().getBduss(context);
            return TextUtils.isEmpty(bduss) ? "" : bduss;
        }
        return "";
    }

    public static String i(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return h(context);
        }
        return j(context);
    }

    public static String j(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.a.l0.b.j.c.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String k(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : v.a().l(context);
    }

    public static String l(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return k(context);
        }
        return m(context);
    }

    public static String m(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.a.l0.b.j.d.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static void n(String str, ArrayList<String> arrayList, b.c cVar) {
        if (ProcessUtils.isMainProcess()) {
            v.a().o(str, arrayList, cVar);
        }
    }

    public static void o(Context context, String str, ArrayList<String> arrayList, b.c cVar) {
        if (ProcessUtils.isMainProcess()) {
            n(str, arrayList, cVar);
        } else {
            p(context, str, arrayList, cVar);
        }
    }

    public static void p(Context context, String str, ArrayList<String> arrayList, b.c cVar) {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null) {
            cVar.a(null);
            return;
        }
        d.a.l0.a.v1.c.e.a z = i2.z();
        if (z == null) {
            cVar.a(null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_result_client_id", str);
        bundle.putStringArrayList("key_param_tpl_list", arrayList);
        z.L(bundle, d.a.l0.b.j.e.class, new b(cVar));
    }

    public static String q(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : v.a().a(context);
    }

    public static String r(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return q(context);
        }
        return s(context);
    }

    public static String s(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.a.l0.b.j.f.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static void t(Context context, d.a.l0.a.v2.e1.b<Bundle> bVar, @Nullable String... strArr) {
        if (ProcessUtils.isMainProcess()) {
            u(context, bVar, strArr);
        } else {
            w(bVar, strArr);
        }
    }

    public static void u(Context context, d.a.l0.a.v2.e1.b<Bundle> bVar, @Nullable String... strArr) {
        if (ProcessUtils.isMainProcess()) {
            String h2 = h(context);
            if (TextUtils.isEmpty(h2)) {
                bVar.onCallback(null);
                return;
            } else {
                v(new d(bVar), h2, strArr == null ? Collections.emptyList() : Arrays.asList(strArr));
                return;
            }
        }
        throw new IllegalStateException("must call in MainProcess");
    }

    public static void v(l.a aVar, String str, List<String> list) {
        v.a().p(aVar, str, list);
    }

    public static void w(d.a.l0.a.v2.e1.b<Bundle> bVar, String... strArr) {
        if (strArr != null && strArr.length >= 1) {
            d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
            if (i2 == null) {
                bVar.onCallback(null);
                return;
            }
            d.a.l0.a.v1.c.e.a z = i2.z();
            if (z == null) {
                bVar.onCallback(null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArray("key_param_tpl_list", strArr);
            z.L(bundle, d.a.l0.b.j.g.class, new c(bVar));
            return;
        }
        bVar.onCallback(null);
    }

    public static String x(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : v.a().b(context);
    }

    public static String y(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return x(context);
        }
        return z(context);
    }

    public static String z(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.a.l0.b.j.h.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }
}
