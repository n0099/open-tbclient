package d.b.g0.a.c0.d.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.y0.e.c;
import d.b.g0.a.z1.h;
import d.b.g0.a.z1.k.f;
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
    public c f43630c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f43631d;

    /* renamed from: e  reason: collision with root package name */
    public int f43632e;

    /* renamed from: d.b.g0.a.c0.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0621a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43633e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f43634f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43635g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43636h;

        public RunnableC0621a(Context context, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f43633e = context;
            this.f43634f = file;
            this.f43635g = unitedSchemeEntity;
            this.f43636h = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.q(this.f43633e, aVar.f43630c.f43643b, a.this.f43630c.f43644c, this.f43634f, this.f43635g, this.f43636h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43637e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43638f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43639g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f43640h;
        public final /* synthetic */ UnitedSchemeEntity i;
        public final /* synthetic */ CallbackHandler j;

        public b(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f43637e = context;
            this.f43638f = str;
            this.f43639g = str2;
            this.f43640h = file;
            this.i = unitedSchemeEntity;
            this.j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.q(this.f43637e, this.f43638f, this.f43639g, this.f43640h, this.i, this.j);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/wirelessdebuglaunch");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
            c e2 = c.e(optParamsAsJo);
            this.f43630c = e2;
            if (e2 != null && !e2.d()) {
                l(context, unitedSchemeEntity, callbackHandler);
                return true;
            }
            if (a0.f46288b) {
                Log.e("WirelessDebugAction", "Wireless Debug params is invalid");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.g0.a.c0.c.b("WirelessDebugAction", "param is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        File b2 = d.b.g0.a.c0.d.e.b.b();
        if (b2.exists()) {
            b2.delete();
        }
        this.f43631d = Executors.newFixedThreadPool(4);
        this.f43632e = 0;
        JSONArray jSONArray = this.f43630c.f43648g;
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = this.f43630c.f43648g.length();
            for (int i = 0; i < length; i++) {
                String a2 = this.f43630c.a(i);
                if (TextUtils.isEmpty(a2)) {
                    int i2 = this.f43632e + 1;
                    this.f43632e = i2;
                    if (i2 >= length) {
                        d.b.g0.a.c0.c.b("WirelessDebugAction", "Hosts are invalid");
                        p(context, "404");
                    }
                } else {
                    this.f43631d.execute(new b(context, a2, this.f43630c.c(i), b2, unitedSchemeEntity, callbackHandler));
                }
            }
            return;
        }
        ExecutorUtilsExt.postOnSerial(new RunnableC0621a(context, b2, unitedSchemeEntity, callbackHandler), "WirelessDebugAction");
    }

    public final String m(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            if (a0.f46288b) {
                Log.e("WirelessDebugAction", "url encode fail", e2);
                return str;
            }
            return str;
        }
    }

    public final void n() {
        b.a J = d.b.g0.a.r1.d.e().s().J();
        f fVar = new f();
        fVar.j(J);
        fVar.f47251a = h.n(J.F());
        fVar.f47252b = Config.LAUNCH;
        fVar.f47253c = "adb-debug";
        fVar.f47254d = "download_fail";
        h.onEvent(fVar);
    }

    public final c.a o() {
        return (c.a) ((c.a) ((c.a) new c.a().q0(this.f43630c.f43642a)).v0(false)).H0(this.f43630c.f43645d);
    }

    public final void p(Context context, String str) {
        String string = d.b.g0.a.a2.g.h.a().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            d.b.g0.a.q1.b.f.d.f(context, "IPs are invalid ：" + str).C();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SchemeConfig.getSchemeHead());
        sb.append("://v1/easybrowse/open?url=");
        sb.append(m(string + "?" + str));
        SchemeRouter.invoke(context, sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b5, code lost:
        if (r4 >= r2.f43630c.f43648g.length()) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = d.b.g0.k.e.a.f().getRequest().url(str).connectionTimeout(1500).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                d.b.g0.p.f.a(executeSync.body().byteStream(), file);
                Intent W0 = d.b.g0.a.y0.e.c.W0(context, o());
                W0.putExtra("masterPreload", this.f43630c.f43646e);
                W0.putExtra("slavePreload", this.f43630c.f43647f);
                W0.putExtra("extraWSUrl", str2);
                context.startActivity(W0);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.f43631d != null) {
                    this.f43631d.shutdownNow();
                    this.f43631d = null;
                }
                if (!ProcessUtils.isMainProcess()) {
                    if (a0.f46288b) {
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
                if (this.f43630c.f43648g != null) {
                    int i = this.f43632e + 1;
                    this.f43632e = i;
                }
                d.b.g0.a.c0.c.b("WirelessDebugAction", "Host IPs are invalid");
                p(context, "404");
                n();
            }
        }
    }
}
