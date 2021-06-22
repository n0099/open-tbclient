package d.a.m0.a.e0.f.f;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.components.countly.XAdRemoteSDKCountly;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.f1.e.c;
import d.a.m0.a.j2.k;
import d.a.m0.a.j2.p.f;
import d.a.m0.a.k2.g.h;
import d.a.m0.t.g;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public c f45240c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f45241d;

    /* renamed from: e  reason: collision with root package name */
    public int f45242e;

    /* renamed from: d.a.m0.a.e0.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0660a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45243e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f45244f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45245g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45246h;

        public RunnableC0660a(Context context, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f45243e = context;
            this.f45244f = file;
            this.f45245g = unitedSchemeEntity;
            this.f45246h = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.q(this.f45243e, aVar.f45240c.f45255b, a.this.f45240c.f45256c, this.f45244f, this.f45245g, this.f45246h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45248e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45249f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45250g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f45251h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45252i;
        public final /* synthetic */ CallbackHandler j;

        public b(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f45248e = context;
            this.f45249f = str;
            this.f45250g = str2;
            this.f45251h = file;
            this.f45252i = unitedSchemeEntity;
            this.j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.q(this.f45248e, this.f45249f, this.f45250g, this.f45251h, this.f45252i, this.j);
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/wirelessdebuglaunch");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
            c e2 = c.e(optParamsAsJo);
            this.f45240c = e2;
            if (e2 != null && !e2.d()) {
                l(context, unitedSchemeEntity, callbackHandler);
                return true;
            }
            if (a0.f44733b) {
                Log.e("WirelessDebugAction", "Wireless Debug params is invalid");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.m0.a.e0.d.b("WirelessDebugAction", "param is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        File b2 = d.a.m0.a.e0.f.f.b.b();
        if (b2.exists()) {
            b2.delete();
        }
        this.f45241d = Executors.newFixedThreadPool(4);
        this.f45242e = 0;
        JSONArray jSONArray = this.f45240c.f45260g;
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = this.f45240c.f45260g.length();
            for (int i2 = 0; i2 < length; i2++) {
                String a2 = this.f45240c.a(i2);
                if (TextUtils.isEmpty(a2)) {
                    int i3 = this.f45242e + 1;
                    this.f45242e = i3;
                    if (i3 >= length) {
                        d.a.m0.a.e0.d.b("WirelessDebugAction", "Hosts are invalid");
                        p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    }
                } else {
                    this.f45241d.execute(new b(context, a2, this.f45240c.c(i2), b2, unitedSchemeEntity, callbackHandler));
                }
            }
            return;
        }
        ExecutorUtilsExt.postOnSerial(new RunnableC0660a(context, b2, unitedSchemeEntity, callbackHandler), "WirelessDebugAction");
    }

    public final String m(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            if (a0.f44733b) {
                Log.e("WirelessDebugAction", "url encode fail", e2);
                return str;
            }
            return str;
        }
    }

    public final void n() {
        b.a L = d.a.m0.a.a2.d.g().r().L();
        f fVar = new f();
        fVar.j(L);
        fVar.f46969a = k.m(L.G());
        fVar.f46970b = "launch";
        fVar.f46971c = "adb-debug";
        fVar.f46973e = "download_fail";
        k.onEvent(fVar);
    }

    public final c.a o() {
        return (c.a) ((c.a) ((c.a) new c.a().u0(this.f45240c.f45254a)).z0(false)).O0(this.f45240c.f45257d);
    }

    public final void p(Context context, String str) {
        String string = h.a().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            d.a.m0.a.z1.b.f.e.g(context, "IPs are invalid ：" + str).F();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SchemeConfig.getSchemeHead());
        sb.append("://v1/easybrowse/open?url=");
        sb.append(m(string + "?" + str));
        SchemeRouter.invoke(context, sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b5, code lost:
        if (r4 >= r2.f45240c.f45260g.length()) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = d.a.m0.m.e.a.g().getRequest().url(str).connectionTimeout(1500).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                g.a(executeSync.body().byteStream(), file);
                Intent d1 = d.a.m0.a.f1.e.c.d1(context, o());
                d1.putExtra(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, this.f45240c.f45258e);
                d1.putExtra("slavePreload", this.f45240c.f45259f);
                d1.putExtra("extraWSUrl", str2);
                context.startActivity(d1);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.f45241d != null) {
                    this.f45241d.shutdownNow();
                    this.f45241d = null;
                }
                if (!ProcessUtils.isMainProcess()) {
                    if (a0.f44733b) {
                        Log.d("WirelessDebugAction", "Suicide for reload.");
                    }
                    d.d();
                }
            }
            if (executeSync != null) {
                executeSync.close();
            }
        } catch (IOException unused) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            synchronized (this) {
                if (this.f45240c.f45260g != null) {
                    int i2 = this.f45242e + 1;
                    this.f45242e = i2;
                }
                d.a.m0.a.e0.d.b("WirelessDebugAction", "Host IPs are invalid");
                p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                n();
            }
        }
    }
}
