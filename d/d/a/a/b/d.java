package d.d.a.a.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import d.d.a.a.b.h;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f69778a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f69779b;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static d f69780a = new d(null);
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (d.d.a.a.a.c() == null) {
                return;
            }
            int i2 = message.what;
            if (10000 == i2) {
                d.this.d((String) message.obj);
                d.this.f();
            } else if (10001 == i2) {
                d.this.d("normal_log");
                d.this.f();
            }
        }
    }

    public /* synthetic */ d(b bVar) {
        this();
    }

    public static d h() {
        return a.f69780a;
    }

    public void a() {
        Context c2 = d.d.a.a.a.c();
        if (c2 != null) {
            k.b(f.a().e(c2));
        }
    }

    public final synchronized boolean c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String b2 = f.a().b(context);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        return b2.equals(e.e(str.getBytes(), false));
    }

    public boolean d(String str) {
        Context c2;
        if (h.a().g() || (c2 = d.d.a.a.a.c()) == null || !e.h(c2)) {
            return false;
        }
        h.b f2 = h.a().f(str);
        if (f2.f69789a == 0 || TextUtils.isEmpty(f2.f69790b) || !e(f2.f69790b, null)) {
            return false;
        }
        if (str.equals("normal_log")) {
            f.a().d(c2, e.e(f2.f69790b.getBytes(), false));
        }
        i.a().b(str, f2.f69789a);
        return true;
    }

    public final boolean e(String str, String str2) {
        c d2;
        String str3 = str.toString();
        Context c2 = d.d.a.a.a.c();
        if (c2 != null && g(c2, str)) {
            try {
                d.d.a.a.b.a f2 = d.d.a.a.a.e().f();
                if (f2 == null || (d2 = d.d.a.a.a.e().d()) == null) {
                    return false;
                }
                String uploadUrl = f2.getUploadUrl();
                String encodeToString = Base64.encodeToString(com.duxiaoman.dxmpay.statistics.internal.f.b(str3, f2.getCommonEvent(), f2.getDistinctId(), f2.getDistinctIdKey(), f2.isLogin(), f2.getProductName(), f2.getSDKVersion(), f2.getChannelId(), f2.getAppVersionName(), f2.getAppVersionCode()).getBytes(), 2);
                HashMap hashMap = new HashMap();
                hashMap.put("sign", e.e((encodeToString + "(null)").getBytes("GBK"), false));
                hashMap.put("data", encodeToString);
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("mk", str2);
                }
                return d2.send(c2, 1, uploadUrl, hashMap);
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public final void f() {
        Context c2 = d.d.a.a.a.c();
        if (c2 == null) {
            return;
        }
        this.f69779b.removeMessages(10001);
        int i2 = d.d.a.a.a.e().f().get3GSendingInterval();
        if (e.k(c2)) {
            i2 = d.d.a.a.a.e().f().getWifiSendingInterval();
        }
        this.f69779b.sendEmptyMessageDelayed(10001, i2 * 60000);
    }

    public final boolean g(Context context, String str) {
        if (h.a().g() || !c(context, str)) {
            return true;
        }
        h.a().d("normal_log");
        return false;
    }

    public void i(String str) {
        this.f69779b.obtainMessage(10000, str).sendToTarget();
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("SensorLogSenderThread");
        this.f69778a = handlerThread;
        handlerThread.start();
        this.f69779b = new b(this.f69778a.getLooper());
    }
}
