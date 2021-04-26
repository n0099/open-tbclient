package d.a.h0.b.m.c;

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
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.r1.e;
import d.a.h0.a.t.b.c;
import d.a.h0.a.t.b.d;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: d.a.h0.b.m.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0879a extends c {

        /* renamed from: d.a.h0.b.m.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0880a implements d.a.h0.a.i2.u0.b<h<b.e>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f45569e;

            public C0880a(c.b bVar) {
                this.f45569e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(h<b.e> hVar) {
                if (d.a.h0.a.v1.c.c.h(hVar)) {
                    this.f45569e.a(a.this.s());
                    return;
                }
                int b2 = hVar.b();
                String f2 = d.a.h0.a.v1.c.c.f(b2);
                if (d.f44021c) {
                    Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f45569e.a(new d.a.h0.a.t.e.b(b2, f2));
            }
        }

        public C0879a(String str) {
            super(str);
        }

        @Override // d.a.h0.a.t.b.c
        @NonNull
        public d.a.h0.a.t.e.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            e O = e.O();
            if (O == null) {
                if (d.f44021c) {
                    Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: null swan runtime");
                }
                return new d.a.h0.a.t.e.b(1001, "null swan runtime");
            }
            O.R().g(d.a.h0.a.r1.d.e(), "mapp_i_get_common_sys_info", new C0880a(bVar));
            return new d.a.h0.a.t.e.b(0);
        }

        @Override // d.a.h0.a.t.b.c
        @NonNull
        public d.a.h0.a.t.e.b e(@NonNull JSONObject jSONObject) {
            return a.this.s();
        }

        @Override // d.a.h0.a.t.b.c
        public boolean i() {
            return d.a.h0.a.r1.d.e().z() && d.a.h0.a.r1.d.e().p().R().f("mapp_i_get_common_sys_info");
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            String string = bundle.getString("httpUrl");
            Bundle bundle2 = new Bundle();
            bundle2.putString("zid", d.a.h0.b.i.a.E(d.a.h0.a.r1.d.e()));
            bundle2.putString("uid", d.a.h0.a.w0.a.O().e(d.a.h0.a.r1.d.e()));
            bundle2.putString("cookie", TextUtils.isEmpty(string) ? "" : d.a.h0.a.w0.a.m().a().getCookie(string));
            return bundle2;
        }
    }

    public a(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public d.a.h0.a.t.e.b r(String str) {
        return j(str, new C0879a("getCommonSysInfo"));
    }

    @NonNull
    public final d.a.h0.a.t.e.b s() {
        String str;
        String str2;
        d.a.h0.a.r1.d e2 = d.a.h0.a.r1.d.e();
        String f2 = d.a.h0.a.w0.a.O().f(e2);
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
        String a2 = d.a.h0.q.b.b(AppRuntime.getAppContext()).a();
        if (d.f44021c) {
            Log.d("Api-getCommonSysInfo", "cuid = " + f2 + ", imei = " + r + ", zid = " + str + ", uid = " + str2 + ", baiduId = " + k + ", sid = " + k2 + ", uuid = " + a2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", f2);
            jSONObject.put("imei", r);
            jSONObject.put("zid", str);
            jSONObject.put("uid", str2);
            jSONObject.put("baidu_id", k);
            jSONObject.put("sid", k2);
            jSONObject.put("uuid", a2);
            if (d.f44021c) {
                Log.d("Api-getCommonSysInfo", "getCommonSysInfo success: " + jSONObject.toString());
            }
            return new d.a.h0.a.t.e.b(0, jSONObject);
        } catch (JSONException e3) {
            if (d.f44021c) {
                Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: JsonException");
                e3.printStackTrace();
            }
            return new d.a.h0.a.t.e.b(1001, "result JSONException");
        }
    }
}
