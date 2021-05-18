package d.a.i0.a.e0.f.f;

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
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.f1.e.c;
import d.a.i0.a.j2.k;
import d.a.i0.a.j2.p.f;
import d.a.i0.a.k2.g.h;
import d.a.i0.t.g;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public c f41282c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f41283d;

    /* renamed from: e  reason: collision with root package name */
    public int f41284e;

    /* renamed from: d.a.i0.a.e0.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0590a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41285e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f41286f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41287g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41288h;

        public RunnableC0590a(Context context, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f41285e = context;
            this.f41286f = file;
            this.f41287g = unitedSchemeEntity;
            this.f41288h = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.q(this.f41285e, aVar.f41282c.f41297b, a.this.f41282c.f41298c, this.f41286f, this.f41287g, this.f41288h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41290e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41291f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41292g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f41293h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41294i;
        public final /* synthetic */ CallbackHandler j;

        public b(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f41290e = context;
            this.f41291f = str;
            this.f41292g = str2;
            this.f41293h = file;
            this.f41294i = unitedSchemeEntity;
            this.j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.q(this.f41290e, this.f41291f, this.f41292g, this.f41293h, this.f41294i, this.j);
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/wirelessdebuglaunch");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
            c e2 = c.e(optParamsAsJo);
            this.f41282c = e2;
            if (e2 != null && !e2.d()) {
                l(context, unitedSchemeEntity, callbackHandler);
                return true;
            }
            if (a0.f40775b) {
                Log.e("WirelessDebugAction", "Wireless Debug params is invalid");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.i0.a.e0.d.b("WirelessDebugAction", "param is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        File b2 = d.a.i0.a.e0.f.f.b.b();
        if (b2.exists()) {
            b2.delete();
        }
        this.f41283d = Executors.newFixedThreadPool(4);
        this.f41284e = 0;
        JSONArray jSONArray = this.f41282c.f41302g;
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = this.f41282c.f41302g.length();
            for (int i2 = 0; i2 < length; i2++) {
                String a2 = this.f41282c.a(i2);
                if (TextUtils.isEmpty(a2)) {
                    int i3 = this.f41284e + 1;
                    this.f41284e = i3;
                    if (i3 >= length) {
                        d.a.i0.a.e0.d.b("WirelessDebugAction", "Hosts are invalid");
                        p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    }
                } else {
                    this.f41283d.execute(new b(context, a2, this.f41282c.c(i2), b2, unitedSchemeEntity, callbackHandler));
                }
            }
            return;
        }
        ExecutorUtilsExt.postOnSerial(new RunnableC0590a(context, b2, unitedSchemeEntity, callbackHandler), "WirelessDebugAction");
    }

    public final String m(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            if (a0.f40775b) {
                Log.e("WirelessDebugAction", "url encode fail", e2);
                return str;
            }
            return str;
        }
    }

    public final void n() {
        b.a L = d.a.i0.a.a2.d.g().r().L();
        f fVar = new f();
        fVar.j(L);
        fVar.f43011a = k.m(L.G());
        fVar.f43012b = "launch";
        fVar.f43013c = "adb-debug";
        fVar.f43015e = "download_fail";
        k.onEvent(fVar);
    }

    public final c.a o() {
        return (c.a) ((c.a) ((c.a) new c.a().u0(this.f41282c.f41296a)).z0(false)).O0(this.f41282c.f41299d);
    }

    public final void p(Context context, String str) {
        String string = h.a().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            d.a.i0.a.z1.b.f.e.g(context, "IPs are invalid ：" + str).F();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SchemeConfig.getSchemeHead());
        sb.append("://v1/easybrowse/open?url=");
        sb.append(m(string + "?" + str));
        SchemeRouter.invoke(context, sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b6, code lost:
        if (r4 >= r2.f41282c.f41302g.length()) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = d.a.i0.m.e.a.g().getRequest().url(str).connectionTimeout(1500).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                g.a(executeSync.body().byteStream(), file);
                Intent d1 = d.a.i0.a.f1.e.c.d1(context, o());
                d1.putExtra(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, this.f41282c.f41300e);
                d1.putExtra("slavePreload", this.f41282c.f41301f);
                d1.putExtra("extraWSUrl", str2);
                context.startActivity(d1);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.f41283d != null) {
                    this.f41283d.shutdownNow();
                    this.f41283d = null;
                }
                if (!ProcessUtils.isMainProcess()) {
                    if (a0.f40775b) {
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
                if (this.f41282c.f41302g != null) {
                    int i2 = this.f41284e + 1;
                    this.f41284e = i2;
                }
                d.a.i0.a.e0.d.b("WirelessDebugAction", "Host IPs are invalid");
                p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                n();
            }
        }
    }
}
