package d.a.l0.b.n.c;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.core.Domains;
import d.a.l0.a.a2.e;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.u.c.c;
import d.a.l0.a.u.c.d;
import d.a.l0.a.v2.o0;
import d.a.l0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: d.a.l0.b.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0951a extends c {

        /* renamed from: d.a.l0.b.n.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0952a implements d.a.l0.a.v2.e1.b<i<b.e>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f46364e;

            public C0952a(c.b bVar) {
                this.f46364e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                if (d.a.l0.a.e2.c.d.h(iVar)) {
                    this.f46364e.a(a.this.t());
                    return;
                }
                int b2 = iVar.b();
                String f2 = d.a.l0.a.e2.c.d.f(b2);
                if (d.f44812c) {
                    Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f46364e.a(new d.a.l0.a.u.h.b(b2, f2));
            }
        }

        public C0951a(String str) {
            super(str);
        }

        @Override // d.a.l0.a.u.c.c
        @NonNull
        public d.a.l0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            e Q = e.Q();
            if (Q == null) {
                if (d.f44812c) {
                    Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: null swan runtime");
                }
                return new d.a.l0.a.u.h.b(1001, "null swan runtime");
            }
            Q.T().g(d.a.l0.a.a2.d.g(), "mapp_i_get_common_sys_info", new C0952a(bVar));
            return new d.a.l0.a.u.h.b(0);
        }

        @Override // d.a.l0.a.u.c.c
        @NonNull
        public d.a.l0.a.u.h.b e(@NonNull JSONObject jSONObject) {
            return a.this.t();
        }

        @Override // d.a.l0.a.u.c.c
        public boolean i() {
            return d.a.l0.a.a2.d.g().C() && d.a.l0.a.a2.d.g().r().T().f("mapp_i_get_common_sys_info");
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            String string = bundle.getString("httpUrl");
            Bundle bundle2 = new Bundle();
            bundle2.putString("zid", d.a.l0.b.j.a.D(d.a.l0.a.a2.d.g()));
            bundle2.putString("uid", d.a.l0.a.c1.a.a0().h(d.a.l0.a.a2.d.g()));
            bundle2.putString("cookie", TextUtils.isEmpty(string) ? "" : d.a.l0.a.c1.a.p().a().getCookie(string));
            return bundle2;
        }
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public d.a.l0.a.u.h.b s(String str) {
        return k(str, new C0951a("getCommonSysInfo"));
    }

    @NonNull
    public final d.a.l0.a.u.h.b t() {
        String str;
        String str2;
        d.a.l0.a.a2.d g2 = d.a.l0.a.a2.d.g();
        String i2 = d.a.l0.a.c1.a.a0().i(g2);
        String r = q0.r();
        Bundle bundle = new Bundle();
        bundle.putString("httpUrl", Domains.BAIDU);
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(g2, b.class, bundle);
        String str3 = "";
        if (callOnMainWithContentProvider.isOk()) {
            String string = callOnMainWithContentProvider.mResult.getString("zid");
            str2 = callOnMainWithContentProvider.mResult.getString("uid");
            str3 = callOnMainWithContentProvider.mResult.getString("cookie");
            str = string;
        } else {
            str = "";
            str2 = str;
        }
        String l = o0.l(str3, "BAIDUID");
        String l2 = o0.l(str3, "H_WISE_SIDS");
        String a2 = d.a.l0.u.b.b(AppRuntime.getAppContext()).a();
        if (d.f44812c) {
            Log.d("Api-getCommonSysInfo", "cuid = " + i2 + ", imei = " + r + ", zid = " + str + ", uid = " + str2 + ", baiduId = " + l + ", sid = " + l2 + ", uuid = " + a2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", i2);
            jSONObject.put("imei", r);
            jSONObject.put("zid", str);
            jSONObject.put("uid", str2);
            jSONObject.put("baidu_id", l);
            jSONObject.put("sid", l2);
            jSONObject.put("uuid", a2);
            if (d.f44812c) {
                Log.d("Api-getCommonSysInfo", "getCommonSysInfo success: " + jSONObject.toString());
            }
            return new d.a.l0.a.u.h.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.f44812c) {
                Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: JsonException");
                e2.printStackTrace();
            }
            return new d.a.l0.a.u.h.b(1001, "result JSONException");
        }
    }
}
