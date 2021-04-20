package d.b.g0.b.m.c;

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
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.b.c;
import d.b.g0.a.t.b.d;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: d.b.g0.b.m.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0920a extends c {

        /* renamed from: d.b.g0.b.m.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0921a implements d.b.g0.a.i2.u0.b<h<b.e>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f47794e;

            public C0921a(c.b bVar) {
                this.f47794e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(h<b.e> hVar) {
                if (d.b.g0.a.v1.c.c.h(hVar)) {
                    this.f47794e.a(a.this.s());
                    return;
                }
                int b2 = hVar.b();
                String f2 = d.b.g0.a.v1.c.c.f(b2);
                if (d.f46321c) {
                    Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f47794e.a(new d.b.g0.a.t.e.b(b2, f2));
            }
        }

        public C0920a(String str) {
            super(str);
        }

        @Override // d.b.g0.a.t.b.c
        @NonNull
        public d.b.g0.a.t.e.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            e O = e.O();
            if (O == null) {
                if (d.f46321c) {
                    Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: null swan runtime");
                }
                return new d.b.g0.a.t.e.b(1001, "null swan runtime");
            }
            O.R().g(d.b.g0.a.r1.d.e(), "mapp_i_get_common_sys_info", new C0921a(bVar));
            return new d.b.g0.a.t.e.b(0);
        }

        @Override // d.b.g0.a.t.b.c
        @NonNull
        public d.b.g0.a.t.e.b e(@NonNull JSONObject jSONObject) {
            return a.this.s();
        }

        @Override // d.b.g0.a.t.b.c
        public boolean i() {
            return d.b.g0.a.r1.d.e().x() && d.b.g0.a.r1.d.e().s().R().f("mapp_i_get_common_sys_info");
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            String string = bundle.getString("httpUrl");
            Bundle bundle2 = new Bundle();
            bundle2.putString("zid", d.b.g0.b.i.a.E(d.b.g0.a.r1.d.e()));
            bundle2.putString("uid", d.b.g0.a.w0.a.O().a(d.b.g0.a.r1.d.e()));
            bundle2.putString("cookie", TextUtils.isEmpty(string) ? "" : d.b.g0.a.w0.a.m().a().getCookie(string));
            return bundle2;
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public d.b.g0.a.t.e.b r(String str) {
        return j(str, new C0920a("getCommonSysInfo"));
    }

    @NonNull
    public final d.b.g0.a.t.e.b s() {
        String str;
        String str2;
        d.b.g0.a.r1.d e2 = d.b.g0.a.r1.d.e();
        String c2 = d.b.g0.a.w0.a.O().c(e2);
        String r = k0.r();
        Bundle bundle = new Bundle();
        bundle.putString("httpUrl", Domains.BAIDU);
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(e2, b.class, bundle);
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
        String k = i0.k(str3, "BAIDUID");
        String k2 = i0.k(str3, "H_WISE_SIDS");
        String a2 = d.b.g0.q.b.b(AppRuntime.getAppContext()).a();
        if (d.f46321c) {
            Log.d("Api-getCommonSysInfo", "cuid = " + c2 + ", imei = " + r + ", zid = " + str + ", uid = " + str2 + ", baiduId = " + k + ", sid = " + k2 + ", uuid = " + a2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", c2);
            jSONObject.put("imei", r);
            jSONObject.put("zid", str);
            jSONObject.put("uid", str2);
            jSONObject.put("baidu_id", k);
            jSONObject.put("sid", k2);
            jSONObject.put("uuid", a2);
            if (d.f46321c) {
                Log.d("Api-getCommonSysInfo", "getCommonSysInfo success: " + jSONObject.toString());
            }
            return new d.b.g0.a.t.e.b(0, jSONObject);
        } catch (JSONException e3) {
            if (d.f46321c) {
                Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: JsonException");
                e3.printStackTrace();
            }
            return new d.b.g0.a.t.e.b(1001, "result JSONException");
        }
    }
}
