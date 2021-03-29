package d.b.g0.b.i;

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
import d.b.g0.a.i2.k0;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.b.i.l;
import d.b.g0.b.j.a;
import d.b.g0.b.k.b;
import d.b.g0.b.n.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47273a = d.b.g0.a.k.f45051a;

    /* renamed from: d.b.g0.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0898a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.m.a f47274a;

        public C0898a(d.b.g0.a.m.a aVar) {
            this.f47274a = aVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (this.f47274a == null) {
                return;
            }
            if (!delegateResult.isOk()) {
                this.f47274a.onResult(-1);
                return;
            }
            this.f47274a.onResult(delegateResult.mResult.getInt("result_code", -1));
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.b.g0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.c f47275c;

        public b(b.c cVar) {
            this.f47275c = cVar;
        }

        @Override // d.b.g0.a.n1.a.b.c.b, d.b.g0.a.n1.a.b.c.a
        public long a() {
            return StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.n1.a.b.c.b, d.b.g0.a.n1.a.b.c.c, d.b.g0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.g0.a.n1.a.b.a.b bVar) {
            if (a.f47273a) {
                Log.d("AccountUtils", "get openBduss messenger delegate observer receive event");
            }
            String str = null;
            if (bVar.a() != null) {
                if (a.f47273a) {
                    Log.d("AccountUtils", "get openBduss : result " + bVar.a());
                }
                str = bVar.a().getString("result");
            } else if (a.f47273a) {
                Log.d("AccountUtils", "get openBduss : result null");
            }
            this.f47275c.a(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends d.b.g0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47276c;

        public c(d.b.g0.a.i2.u0.b bVar) {
            this.f47276c = bVar;
        }

        @Override // d.b.g0.a.n1.a.b.c.b, d.b.g0.a.n1.a.b.c.a
        public long a() {
            return StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.n1.a.b.c.b, d.b.g0.a.n1.a.b.c.c, d.b.g0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.g0.a.n1.a.b.a.b bVar) {
            if (a.f47273a) {
                Log.d("AccountUtils", "get stoken messenger delegate observer receive event");
            }
            Bundle bundle = null;
            if (bVar.a() != null) {
                if (a.f47273a) {
                    Log.d("AccountUtils", "get stoken : result " + bVar.a());
                }
                bundle = bVar.a().getBundle("key_result_stokent");
            } else if (a.f47273a) {
                Log.d("AccountUtils", "get stoken : result null");
            }
            this.f47276c.onCallback(bundle);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements l.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47277a;

        public d(d.b.g0.a.i2.u0.b bVar) {
            this.f47277a = bVar;
        }

        @Override // d.b.g0.b.i.l.a
        public void a(l lVar) {
            if (lVar.f47290a != 0 || lVar.f47291b == null) {
                this.f47277a.onCallback(null);
            }
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : lVar.f47291b.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    bundle.putString(key, entry.getValue());
                }
            }
            this.f47277a.onCallback(bundle);
        }

        @Override // d.b.g0.b.i.l.a
        public void b(l lVar) {
            this.f47277a.onCallback(null);
        }

        @Override // d.b.g0.b.i.l.a
        public void onFinish() {
        }

        @Override // d.b.g0.b.i.l.a
        public void onStart() {
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.n.a.b f47278a;

        public e(d.b.g0.a.n.a.b bVar) {
            this.f47278a = bVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            String string = delegateResult.mResult.getString("address_info");
            if (TextUtils.isEmpty(string)) {
                if (d.b.g0.a.k.f45051a) {
                    Log.e("AccountUtils", delegateResult.mResult.getString("errorMsg"));
                }
                this.f47278a.a(0);
                return;
            }
            if (d.b.g0.a.k.f45051a) {
                Log.i("AccountUtils", string);
            }
            this.f47278a.b(d.b.g0.a.i2.v.b(string));
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements b0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f47279a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47280b;

        public f(Bundle bundle, d.b.g0.a.i2.u0.b bVar) {
            this.f47279a = bundle;
            this.f47280b = bVar;
        }

        @Override // d.b.g0.b.i.b0
        public void a(z zVar) {
            if (a.f47273a) {
                Log.d("AccountUtils", "callbackkey=" + zVar.f47306a);
            }
            this.f47279a.putString("callbackKey", zVar.f47306a);
            d.b.g0.a.i2.u0.b bVar = this.f47280b;
            if (bVar != null) {
                bVar.onCallback(this.f47279a);
            }
        }

        @Override // d.b.g0.b.i.b0
        public void onFailure(String str) {
            if (a.f47273a) {
                Log.d("AccountUtils", "onFailure=" + str);
            }
            this.f47279a.putString("failMsg", str);
            d.b.g0.a.i2.u0.b bVar = this.f47280b;
            if (bVar != null) {
                bVar.onCallback(this.f47279a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47281a;

        public g(d.b.g0.a.i2.u0.b bVar) {
            this.f47281a = bVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Bundle bundle = delegateResult.mResult;
            d.b.g0.a.i2.u0.b bVar = this.f47281a;
            if (bVar != null) {
                bVar.onCallback(d.b.g0.a.i2.u.d(bundle, "result"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47284g;

        public h(Activity activity, String str, String str2) {
            this.f47282e = activity;
            this.f47283f = str;
            this.f47284g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.R(this.f47282e, this.f47283f, this.f47284g);
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47285e;

        public i(Activity activity) {
            this.f47285e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            a.P(this.f47285e, true, null, null);
        }
    }

    public static a0 A(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return v.a().i(context);
        }
        return null;
    }

    public static a0 B(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.b.g0.b.i.i.class, null);
        if (callOnMainWithContentProvider.isOk()) {
            a0 a0Var = new a0();
            a0Var.f47286a = callOnMainWithContentProvider.mResult.getString("NICK_NAME", "");
            a0Var.f47287b = callOnMainWithContentProvider.mResult.getString("AVATAR_URL", "");
            return a0Var;
        }
        return null;
    }

    public static b0 C(d.b.g0.a.i2.u0.b<Bundle> bVar) {
        return new f(new Bundle(), bVar);
    }

    public static String D(Context context) {
        return v.a().e(context);
    }

    public static String E(Context context) {
        if (!ProcessUtils.isMainProcess()) {
            return F(context);
        }
        return D(context);
    }

    public static String F(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.b.g0.d.k.a.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static void G(Activity activity, JSONObject jSONObject) {
        JSONObject c2 = d.b.g0.a.v1.c.c.c(jSONObject);
        if (c2 == null || activity == null) {
            return;
        }
        int optInt = c2.optInt("errno", 11001);
        String optString = c2.optString("tipmsg");
        if (optInt == 401 || optInt == 400701) {
            JSONObject optJSONObject = c2.optJSONObject("tipoption");
            String optString2 = optJSONObject != null ? optJSONObject.optString("title") : null;
            if (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString)) {
                return;
            }
            k0.X(new h(activity, optString2, optString));
        }
    }

    public static boolean H(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return v.a().m(context);
        }
        return false;
    }

    public static boolean I(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return H(context);
        }
        return J(context);
    }

    public static boolean J(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, j.class, null);
        return callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false);
    }

    public static void K(Activity activity, String str, d.b.g0.a.i2.u0.b<Bundle> bVar) {
        v.a().h(activity, "baidu_mini_programs_" + str, i(activity), C(bVar));
    }

    public static void L(Activity activity, boolean z, String str, d.b.g0.a.i2.u0.b<Bundle> bVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isRealName", z);
        bundle.putString("swanAppId", str);
        DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, d.b.g0.b.i.b.class, bundle, new g(bVar));
    }

    public static void M(Activity activity, String str, String str2, d.b.g0.a.i2.u0.b<Bundle> bVar) {
        boolean equals = TextUtils.equals(str, "1");
        if (!ProcessUtils.isMainProcess()) {
            L(activity, equals, str2, bVar);
        } else if (equals) {
            K(activity, str2, bVar);
        } else {
            N(activity, str2, bVar);
        }
    }

    public static void N(Activity activity, String str, d.b.g0.a.i2.u0.b<Bundle> bVar) {
        v.a().j(activity, "baidu_mini_programs_" + str, i(activity), C(bVar));
    }

    public static void O(Context context, Bundle bundle, d.b.g0.a.m.a aVar) {
        if (!ProcessUtils.isMainProcess()) {
            aVar.onResult(-1);
        } else {
            v.a().g(context, bundle, aVar);
        }
    }

    public static void P(Activity activity, boolean z, Bundle bundle, d.b.g0.a.m.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            O(activity, bundle, aVar);
        } else {
            Q(activity, z, bundle, aVar);
        }
    }

    public static void Q(Activity activity, boolean z, Bundle bundle, d.b.g0.a.m.a aVar) {
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("key_login_force", z);
        bundle2.putBundle("key_login_params", bundle);
        DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, k.class, bundle2, new C0898a(aVar));
    }

    public static void R(Activity activity, String str, String str2) {
        g.a aVar = new g.a(activity);
        aVar.V(str);
        aVar.y(str2);
        aVar.n(new d.b.g0.a.j2.g.a());
        aVar.m(true);
        aVar.P(activity.getString(d.b.g0.b.g.aiapps_login_immediately), new i(activity));
        aVar.D(activity.getString(d.b.g0.b.g.aiapps_login_refuse), null);
        aVar.X();
    }

    public static void S(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        v.a().c(context, gVar, str);
    }

    public static void c(d.b.g0.a.m.c cVar) {
        if (cVar == null) {
            return;
        }
        v.a().p(cVar);
    }

    public static void d(Context context, a.d dVar) {
        if (ProcessUtils.isMainProcess()) {
            v.a().a(context, dVar);
        }
    }

    public static void e(Activity activity, d.b.g0.a.n.a.b bVar) {
        DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, d.b.g0.b.j.a.class, new e(bVar));
    }

    public static void f(Context context, a.d dVar) {
        if (ProcessUtils.isMainProcess()) {
            v.a().l(context, dVar);
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
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.b.g0.b.i.c.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String k(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : v.a().f(context);
    }

    public static String l(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return k(context);
        }
        return m(context);
    }

    public static String m(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.b.g0.b.i.d.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static void n(String str, ArrayList<String> arrayList, b.c cVar) {
        if (ProcessUtils.isMainProcess()) {
            v.a().n(str, arrayList, cVar);
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
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null) {
            cVar.a(null);
            return;
        }
        d.b.g0.a.n1.c.e.a q = y.q();
        if (q == null) {
            cVar.a(null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_result_client_id", str);
        bundle.putStringArrayList("key_param_tpl_list", arrayList);
        q.J(bundle, d.b.g0.b.i.e.class, new b(cVar));
    }

    public static String q(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : v.a().b(context);
    }

    public static String r(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return q(context);
        }
        return s(context);
    }

    public static String s(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.b.g0.b.i.f.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static void t(Context context, d.b.g0.a.i2.u0.b<Bundle> bVar, @Nullable String... strArr) {
        if (ProcessUtils.isMainProcess()) {
            u(context, bVar, strArr);
        } else {
            w(bVar, strArr);
        }
    }

    public static void u(Context context, d.b.g0.a.i2.u0.b<Bundle> bVar, @Nullable String... strArr) {
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
        v.a().o(aVar, str, list);
    }

    public static void w(d.b.g0.a.i2.u0.b<Bundle> bVar, String... strArr) {
        if (strArr != null && strArr.length >= 1) {
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            if (y == null) {
                bVar.onCallback(null);
                return;
            }
            d.b.g0.a.n1.c.e.a q = y.q();
            if (q == null) {
                bVar.onCallback(null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArray("key_param_tpl_list", strArr);
            q.J(bundle, d.b.g0.b.i.g.class, new c(bVar));
            return;
        }
        bVar.onCallback(null);
    }

    public static String x(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : v.a().d(context);
    }

    public static String y(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return x(context);
        }
        return z(context);
    }

    public static String z(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.b.g0.b.i.h.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }
}
