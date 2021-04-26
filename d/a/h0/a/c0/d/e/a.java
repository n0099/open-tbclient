package d.a.h0.a.c0.d.e;

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
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.y0.e.c;
import d.a.h0.a.z1.h;
import d.a.h0.a.z1.k.f;
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
    public c f41636c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f41637d;

    /* renamed from: e  reason: collision with root package name */
    public int f41638e;

    /* renamed from: d.a.h0.a.c0.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0592a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f41640f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41641g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41642h;

        public RunnableC0592a(Context context, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f41639e = context;
            this.f41640f = file;
            this.f41641g = unitedSchemeEntity;
            this.f41642h = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.q(this.f41639e, aVar.f41636c.f41651b, a.this.f41636c.f41652c, this.f41640f, this.f41641g, this.f41642h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41645f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41646g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f41647h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41648i;
        public final /* synthetic */ CallbackHandler j;

        public b(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f41644e = context;
            this.f41645f = str;
            this.f41646g = str2;
            this.f41647h = file;
            this.f41648i = unitedSchemeEntity;
            this.j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.q(this.f41644e, this.f41645f, this.f41646g, this.f41647h, this.f41648i, this.j);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/wirelessdebuglaunch");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
            c e2 = c.e(optParamsAsJo);
            this.f41636c = e2;
            if (e2 != null && !e2.d()) {
                l(context, unitedSchemeEntity, callbackHandler);
                return true;
            }
            if (a0.f44398b) {
                Log.e("WirelessDebugAction", "Wireless Debug params is invalid");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.h0.a.c0.c.b("WirelessDebugAction", "param is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        File b2 = d.a.h0.a.c0.d.e.b.b();
        if (b2.exists()) {
            b2.delete();
        }
        this.f41637d = Executors.newFixedThreadPool(4);
        this.f41638e = 0;
        JSONArray jSONArray = this.f41636c.f41656g;
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = this.f41636c.f41656g.length();
            for (int i2 = 0; i2 < length; i2++) {
                String a2 = this.f41636c.a(i2);
                if (TextUtils.isEmpty(a2)) {
                    int i3 = this.f41638e + 1;
                    this.f41638e = i3;
                    if (i3 >= length) {
                        d.a.h0.a.c0.c.b("WirelessDebugAction", "Hosts are invalid");
                        p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    }
                } else {
                    this.f41637d.execute(new b(context, a2, this.f41636c.c(i2), b2, unitedSchemeEntity, callbackHandler));
                }
            }
            return;
        }
        ExecutorUtilsExt.postOnSerial(new RunnableC0592a(context, b2, unitedSchemeEntity, callbackHandler), "WirelessDebugAction");
    }

    public final String m(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            if (a0.f44398b) {
                Log.e("WirelessDebugAction", "url encode fail", e2);
                return str;
            }
            return str;
        }
    }

    public final void n() {
        b.a J = d.a.h0.a.r1.d.e().p().J();
        f fVar = new f();
        fVar.j(J);
        fVar.f45411a = h.n(J.F());
        fVar.f45412b = "launch";
        fVar.f45413c = "adb-debug";
        fVar.f45414d = "download_fail";
        h.onEvent(fVar);
    }

    public final c.a o() {
        return (c.a) ((c.a) ((c.a) new c.a().q0(this.f41636c.f41650a)).v0(false)).H0(this.f41636c.f41653d);
    }

    public final void p(Context context, String str) {
        String string = d.a.h0.a.a2.g.h.a().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            d.a.h0.a.q1.b.f.d.f(context, "IPs are invalid ：" + str).C();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SchemeConfig.getSchemeHead());
        sb.append("://v1/easybrowse/open?url=");
        sb.append(m(string + "?" + str));
        SchemeRouter.invoke(context, sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b6, code lost:
        if (r4 >= r2.f41636c.f41656g.length()) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = d.a.h0.k.e.a.f().getRequest().url(str).connectionTimeout(1500).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                d.a.h0.p.f.a(executeSync.body().byteStream(), file);
                Intent W0 = d.a.h0.a.y0.e.c.W0(context, o());
                W0.putExtra("masterPreload", this.f41636c.f41654e);
                W0.putExtra("slavePreload", this.f41636c.f41655f);
                W0.putExtra("extraWSUrl", str2);
                context.startActivity(W0);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.f41637d != null) {
                    this.f41637d.shutdownNow();
                    this.f41637d = null;
                }
                if (!ProcessUtils.isMainProcess()) {
                    if (a0.f44398b) {
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
                if (this.f41636c.f41656g != null) {
                    int i2 = this.f41638e + 1;
                    this.f41638e = i2;
                }
                d.a.h0.a.c0.c.b("WirelessDebugAction", "Host IPs are invalid");
                p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                n();
            }
        }
    }
}
