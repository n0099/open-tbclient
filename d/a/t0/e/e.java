package d.a.t0.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static String f68383c = "UnionIDHelper";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f68384d = d.a.t0.e.a.e();

    /* renamed from: e  reason: collision with root package name */
    public static final String f68385e = j(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});

    /* renamed from: f  reason: collision with root package name */
    public static final String f68386f = j(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});

    /* renamed from: g  reason: collision with root package name */
    public static final Object f68387g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public static e f68388h;

    /* renamed from: a  reason: collision with root package name */
    public volatile d.a.t0.e.f.c f68389a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f68390b;

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f68391e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f68392f;

        public a(Context context, b bVar) {
            this.f68391e = context;
            this.f68392f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.f68384d) {
                Log.d(e.f68383c, "asyncRequest, Thread runn！");
            }
            d.a.t0.e.f.a m = e.this.m(this.f68391e);
            if (e.f68384d) {
                String str = e.f68383c;
                StringBuilder sb = new StringBuilder();
                sb.append("asyncRequest, cachedBean == null ？");
                sb.append(m == null);
                Log.d(str, sb.toString());
            }
            if (m == null || e.this.q(m)) {
                if (e.f68384d) {
                    Log.d(e.f68383c, "asyncRequest, requestFromManufacturer");
                }
                e.this.r();
                if (e.f68384d) {
                    Log.d(e.f68383c, "asyncRequest, trySaveFiles！");
                }
                e.this.f68390b.set(e.this.t(this.f68391e));
                if (e.f68384d) {
                    Log.d(e.f68383c, "asyncRequest, trySaveFiles done");
                }
            }
            if (e.f68384d) {
                Log.d(e.f68383c, "asyncRequest, send  innerHandler message");
            }
            this.f68392f.obtainMessage(100, e.this.f68389a).sendToTarget();
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public d.a.t0.e.f.b f68394a;

        public b(Looper looper, d.a.t0.e.f.b bVar) {
            super(looper);
            this.f68394a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 100) {
                return;
            }
            d.a.t0.e.f.c cVar = (d.a.t0.e.f.c) message.obj;
            if (e.f68384d) {
                String str = e.f68383c;
                StringBuilder sb = new StringBuilder();
                sb.append("handleMessage ，what：");
                sb.append(cVar == null ? "" : cVar.getOAID());
                Log.d(str, sb.toString());
            }
            d.a.t0.e.f.b bVar = this.f68394a;
            if (bVar != null) {
                bVar.a(cVar);
            }
        }
    }

    public e() {
        new AtomicBoolean(false);
        this.f68390b = new AtomicBoolean(false);
    }

    public static String j(byte[]... bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte[] bArr2 : bArr) {
            sb.append(new String(d.a.t0.e.h.c.a(bArr2)));
        }
        return sb.toString();
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(d.a.t0.e.h.a.a(f68385e, f68386f, d.a.t0.e.h.c.a(str.getBytes())));
        } catch (Exception e2) {
            if (f68384d) {
                String str2 = f68383c;
                Log.d(str2, "getCacheObject ，decryptUnionID：" + e2.getMessage());
                return "";
            }
            return "";
        }
    }

    public static String l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return d.a.t0.e.h.c.c(d.a.t0.e.h.a.b(f68385e, f68386f, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception unused) {
            return "";
        }
    }

    public static e o() {
        if (f68388h == null) {
            synchronized (e.class) {
                if (f68388h == null) {
                    f68388h = new e();
                }
            }
        }
        return f68388h;
    }

    public synchronized void i(Context context, @NonNull Looper looper, @Nullable d.a.t0.e.f.b bVar) {
        if (looper != null) {
            b bVar2 = new b(looper, bVar);
            if (p()) {
                bVar2.obtainMessage(100, null).sendToTarget();
                return;
            }
            if (this.f68389a != null && this.f68390b.get()) {
                if (f68384d) {
                    String str = f68383c;
                    Log.d(str, "asyncRequest, mIUnionId.getOAID：" + this.f68389a.getOAID());
                    String str2 = f68383c;
                    Log.d(str2, "asyncRequest, mIUnionId.isTrackLimited：" + this.f68389a.c());
                    String str3 = f68383c;
                    Log.d(str3, "asyncRequest, mIUnionId.getStatusCode：" + this.f68389a.getStatusCode());
                }
                bVar2.obtainMessage(100, this.f68389a).sendToTarget();
            } else {
                if (!this.f68390b.get()) {
                    this.f68389a = new c(context).f68379a;
                }
                new Thread(new a(context, bVar2)).start();
            }
            return;
        }
        throw new NullPointerException("param looper not null");
    }

    public final d.a.t0.e.f.a m(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
        if (!file.exists()) {
            if (f68384d) {
                Log.d(f68383c, "getCacheObject dir 不存在 , 首次需要创建");
            }
            return null;
        }
        File file2 = new File(file, ".bd_un_info.so");
        if (!file2.exists()) {
            if (f68384d) {
                Log.d(f68383c, "getCacheObject  file 不存在, 首次需要创建");
            }
            return null;
        }
        String a2 = d.a.t0.e.h.e.a(file2, f68387g);
        if (f68384d) {
            String str = f68383c;
            Log.d(str, "getCacheObject ，content：" + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String k = k(a2);
        if (f68384d) {
            String str2 = f68383c;
            Log.d(str2, "getCacheObject ，json：" + k);
        }
        try {
            JSONObject jSONObject = new JSONObject(k);
            d.a.t0.e.f.a aVar = new d.a.t0.e.f.a();
            s(aVar, jSONObject);
            return aVar;
        } catch (Exception e2) {
            if (f68384d) {
                String str3 = f68383c;
                Log.d(str3, "getCacheObject , " + e2.getMessage());
            }
            return null;
        }
    }

    public final long n() {
        return d.a.t0.e.a.a(d.a.t0.e.b.a()) * 60 * 1000;
    }

    public final boolean p() {
        return d.a.t0.e.a.d(d.a.t0.e.b.a());
    }

    public final boolean q(@NonNull d.a.t0.e.f.a aVar) {
        if (Math.abs(System.currentTimeMillis() - aVar.f68395a) > n()) {
            if (f68384d) {
                Log.d(f68383c, "isExpireTime ：超过缓存有效期");
                return true;
            }
            return true;
        } else if (f68384d) {
            Log.d(f68383c, "isExpireTime ：没有超过缓存有效期");
            return false;
        } else {
            return false;
        }
    }

    public final void r() {
        this.f68389a = this.f68389a.d();
        if (f68384d) {
            String str = f68383c;
            Log.d(str, "asyncRequest, requestFromManufacturer done :" + this.f68389a.getOAID());
        }
    }

    public final boolean s(d.a.t0.e.f.a aVar, JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(new String(d.a.t0.e.h.c.a("dGltZQ==".getBytes())));
            aVar.f68395a = optLong;
            if (f68384d) {
                String str = f68383c;
                Log.d(str, "tryParseCacheJsonObject ，time：" + optLong);
                String str2 = f68383c;
                Log.d(str2, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
            }
            String str3 = new String(d.a.t0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
            if (f68384d) {
                String str4 = f68383c;
                Log.d(str4, "tryParseCacheJsonObject objKey：" + str3);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(str3);
            if (f68384d) {
                String str5 = f68383c;
                Log.d(str5, "tryParseCacheJsonObject ，jsonObject：" + optJSONObject);
            }
            if (optJSONObject != null) {
                String str6 = new String(d.a.t0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                String str7 = new String(d.a.t0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                String str8 = new String(d.a.t0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                String str9 = new String(d.a.t0.e.h.c.a("b2FpZA==".getBytes()));
                String str10 = new String(d.a.t0.e.h.c.a("YWFpZA==".getBytes()));
                String str11 = new String(d.a.t0.e.h.c.a("dmFpZA==".getBytes()));
                boolean optBoolean = optJSONObject.optBoolean(str6);
                boolean optBoolean2 = optJSONObject.optBoolean(str7);
                int optInt = optJSONObject.optInt(str8);
                String optString = optJSONObject.optString(str9);
                String optString2 = optJSONObject.optString(str10);
                String optString3 = optJSONObject.optString(str11);
                this.f68389a.i(optBoolean);
                this.f68389a.e(optBoolean2);
                this.f68389a.a(optInt);
                this.f68389a.g(optString);
                this.f68389a.f(optString2);
                this.f68389a.b(optString3);
                aVar.f68396b = this.f68389a;
                return true;
            }
            aVar.f68396b = null;
            if (f68384d) {
                Log.d(f68383c, "tryParseCacheJsonObject return cause null：");
            }
            return false;
        } catch (Exception e2) {
            if (f68384d) {
                String str12 = f68383c;
                Log.d(str12, "tryParseCacheJsonObject ：" + e2.getMessage());
            }
            return false;
        }
    }

    public final boolean t(Context context) {
        try {
            if (this.f68389a != null && !TextUtils.isEmpty(this.f68389a.getOAID())) {
                File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, ".bd_un_info.so");
                String str = new String(d.a.t0.e.h.c.a("dGltZQ==".getBytes()));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, System.currentTimeMillis());
                String str2 = new String(d.a.t0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
                JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                String str3 = new String(d.a.t0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                String str4 = new String(d.a.t0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                String str5 = new String(d.a.t0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                String str6 = new String(d.a.t0.e.h.c.a("b2FpZA==".getBytes()));
                String str7 = new String(d.a.t0.e.h.c.a("YWFpZA==".getBytes()));
                String str8 = new String(d.a.t0.e.h.c.a("dmFpZA==".getBytes()));
                optJSONObject.put(str3, this.f68389a.c());
                optJSONObject.put(str4, this.f68389a.h());
                optJSONObject.put(str5, this.f68389a.getStatusCode());
                optJSONObject.put(str6, this.f68389a.getOAID());
                optJSONObject.put(str7, this.f68389a.getAAID());
                optJSONObject.put(str8, this.f68389a.getVAID());
                jSONObject.put(str2, optJSONObject);
                d.a.t0.e.h.e.b(l(jSONObject.toString()), file2, false, f68387g);
                if (f68384d) {
                    String str9 = f68383c;
                    Log.d(str9, "trySaveFiles, app: " + jSONObject.toString());
                    return true;
                }
                return true;
            }
            return false;
        } catch (Exception e2) {
            if (f68384d) {
                String str10 = f68383c;
                Log.d(str10, "trySaveFiles, error " + e2.getMessage());
            }
            return false;
        }
    }
}
