package d.b.o0.e;

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
    public static String f64198c = "UnionIDHelper";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f64199d = d.b.o0.e.a.e();

    /* renamed from: e  reason: collision with root package name */
    public static final String f64200e = j(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});

    /* renamed from: f  reason: collision with root package name */
    public static final String f64201f = j(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});

    /* renamed from: g  reason: collision with root package name */
    public static final Object f64202g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public static e f64203h;

    /* renamed from: a  reason: collision with root package name */
    public volatile d.b.o0.e.f.c f64204a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f64205b;

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f64206e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f64207f;

        public a(Context context, b bVar) {
            this.f64206e = context;
            this.f64207f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.f64199d) {
                Log.d(e.f64198c, "asyncRequest, Thread runn！");
            }
            d.b.o0.e.f.a m = e.this.m(this.f64206e);
            if (e.f64199d) {
                String str = e.f64198c;
                StringBuilder sb = new StringBuilder();
                sb.append("asyncRequest, cachedBean == null ？");
                sb.append(m == null);
                Log.d(str, sb.toString());
            }
            if (m == null || e.this.q(m)) {
                if (e.f64199d) {
                    Log.d(e.f64198c, "asyncRequest, requestFromManufacturer");
                }
                e.this.r();
                if (e.f64199d) {
                    Log.d(e.f64198c, "asyncRequest, trySaveFiles！");
                }
                e.this.f64205b.set(e.this.t(this.f64206e));
                if (e.f64199d) {
                    Log.d(e.f64198c, "asyncRequest, trySaveFiles done");
                }
            }
            if (e.f64199d) {
                Log.d(e.f64198c, "asyncRequest, send  innerHandler message");
            }
            this.f64207f.obtainMessage(100, e.this.f64204a).sendToTarget();
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public d.b.o0.e.f.b f64209a;

        public b(Looper looper, d.b.o0.e.f.b bVar) {
            super(looper);
            this.f64209a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 100) {
                return;
            }
            d.b.o0.e.f.c cVar = (d.b.o0.e.f.c) message.obj;
            if (e.f64199d) {
                String str = e.f64198c;
                StringBuilder sb = new StringBuilder();
                sb.append("handleMessage ，what：");
                sb.append(cVar == null ? "" : cVar.getOAID());
                Log.d(str, sb.toString());
            }
            d.b.o0.e.f.b bVar = this.f64209a;
            if (bVar != null) {
                bVar.a(cVar);
            }
        }
    }

    public e() {
        new AtomicBoolean(false);
        this.f64205b = new AtomicBoolean(false);
    }

    public static String j(byte[]... bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte[] bArr2 : bArr) {
            sb.append(new String(d.b.o0.e.h.c.a(bArr2)));
        }
        return sb.toString();
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(d.b.o0.e.h.a.a(f64200e, f64201f, d.b.o0.e.h.c.a(str.getBytes())));
        } catch (Exception e2) {
            if (f64199d) {
                String str2 = f64198c;
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
            return d.b.o0.e.h.c.c(d.b.o0.e.h.a.b(f64200e, f64201f, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception unused) {
            return "";
        }
    }

    public static e o() {
        if (f64203h == null) {
            synchronized (e.class) {
                if (f64203h == null) {
                    f64203h = new e();
                }
            }
        }
        return f64203h;
    }

    public synchronized void i(Context context, @NonNull Looper looper, @Nullable d.b.o0.e.f.b bVar) {
        if (looper != null) {
            b bVar2 = new b(looper, bVar);
            if (p()) {
                bVar2.obtainMessage(100, null).sendToTarget();
                return;
            }
            if (this.f64204a != null && this.f64205b.get()) {
                if (f64199d) {
                    String str = f64198c;
                    Log.d(str, "asyncRequest, mIUnionId.getOAID：" + this.f64204a.getOAID());
                    String str2 = f64198c;
                    Log.d(str2, "asyncRequest, mIUnionId.isTrackLimited：" + this.f64204a.b());
                    String str3 = f64198c;
                    Log.d(str3, "asyncRequest, mIUnionId.getStatusCode：" + this.f64204a.getStatusCode());
                }
                bVar2.obtainMessage(100, this.f64204a).sendToTarget();
            } else {
                if (!this.f64205b.get()) {
                    this.f64204a = new c(context).f64194a;
                }
                new Thread(new a(context, bVar2)).start();
            }
            return;
        }
        throw new NullPointerException("param looper not null");
    }

    public final d.b.o0.e.f.a m(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
        if (!file.exists()) {
            if (f64199d) {
                Log.d(f64198c, "getCacheObject dir 不存在 , 首次需要创建");
            }
            return null;
        }
        File file2 = new File(file, ".bd_un_info.so");
        if (!file2.exists()) {
            if (f64199d) {
                Log.d(f64198c, "getCacheObject  file 不存在, 首次需要创建");
            }
            return null;
        }
        String a2 = d.b.o0.e.h.e.a(file2, f64202g);
        if (f64199d) {
            String str = f64198c;
            Log.d(str, "getCacheObject ，content：" + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String k = k(a2);
        if (f64199d) {
            String str2 = f64198c;
            Log.d(str2, "getCacheObject ，json：" + k);
        }
        try {
            JSONObject jSONObject = new JSONObject(k);
            d.b.o0.e.f.a aVar = new d.b.o0.e.f.a();
            s(aVar, jSONObject);
            return aVar;
        } catch (Exception e2) {
            if (f64199d) {
                String str3 = f64198c;
                Log.d(str3, "getCacheObject , " + e2.getMessage());
            }
            return null;
        }
    }

    public final long n() {
        return d.b.o0.e.a.a(d.b.o0.e.b.a()) * 60 * 1000;
    }

    public final boolean p() {
        return d.b.o0.e.a.d(d.b.o0.e.b.a());
    }

    public final boolean q(@NonNull d.b.o0.e.f.a aVar) {
        if (Math.abs(System.currentTimeMillis() - aVar.f64210a) > n()) {
            if (f64199d) {
                Log.d(f64198c, "isExpireTime ：超过缓存有效期");
                return true;
            }
            return true;
        } else if (f64199d) {
            Log.d(f64198c, "isExpireTime ：没有超过缓存有效期");
            return false;
        } else {
            return false;
        }
    }

    public final void r() {
        this.f64204a = this.f64204a.d();
        if (f64199d) {
            String str = f64198c;
            Log.d(str, "asyncRequest, requestFromManufacturer done :" + this.f64204a.getOAID());
        }
    }

    public final boolean s(d.b.o0.e.f.a aVar, JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(new String(d.b.o0.e.h.c.a("dGltZQ==".getBytes())));
            aVar.f64210a = optLong;
            if (f64199d) {
                String str = f64198c;
                Log.d(str, "tryParseCacheJsonObject ，time：" + optLong);
                String str2 = f64198c;
                Log.d(str2, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
            }
            String str3 = new String(d.b.o0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
            if (f64199d) {
                String str4 = f64198c;
                Log.d(str4, "tryParseCacheJsonObject objKey：" + str3);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(str3);
            if (f64199d) {
                String str5 = f64198c;
                Log.d(str5, "tryParseCacheJsonObject ，jsonObject：" + optJSONObject);
            }
            if (optJSONObject != null) {
                String str6 = new String(d.b.o0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                String str7 = new String(d.b.o0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                String str8 = new String(d.b.o0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                String str9 = new String(d.b.o0.e.h.c.a("b2FpZA==".getBytes()));
                String str10 = new String(d.b.o0.e.h.c.a("YWFpZA==".getBytes()));
                String str11 = new String(d.b.o0.e.h.c.a("dmFpZA==".getBytes()));
                boolean optBoolean = optJSONObject.optBoolean(str6);
                boolean optBoolean2 = optJSONObject.optBoolean(str7);
                int optInt = optJSONObject.optInt(str8);
                String optString = optJSONObject.optString(str9);
                String optString2 = optJSONObject.optString(str10);
                String optString3 = optJSONObject.optString(str11);
                this.f64204a.i(optBoolean);
                this.f64204a.e(optBoolean2);
                this.f64204a.c(optInt);
                this.f64204a.g(optString);
                this.f64204a.f(optString2);
                this.f64204a.a(optString3);
                aVar.f64211b = this.f64204a;
                return true;
            }
            aVar.f64211b = null;
            if (f64199d) {
                Log.d(f64198c, "tryParseCacheJsonObject return cause null：");
            }
            return false;
        } catch (Exception e2) {
            if (f64199d) {
                String str12 = f64198c;
                Log.d(str12, "tryParseCacheJsonObject ：" + e2.getMessage());
            }
            return false;
        }
    }

    public final boolean t(Context context) {
        try {
            if (this.f64204a != null && !TextUtils.isEmpty(this.f64204a.getOAID())) {
                File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, ".bd_un_info.so");
                String str = new String(d.b.o0.e.h.c.a("dGltZQ==".getBytes()));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, System.currentTimeMillis());
                String str2 = new String(d.b.o0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
                JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                String str3 = new String(d.b.o0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                String str4 = new String(d.b.o0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                String str5 = new String(d.b.o0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                String str6 = new String(d.b.o0.e.h.c.a("b2FpZA==".getBytes()));
                String str7 = new String(d.b.o0.e.h.c.a("YWFpZA==".getBytes()));
                String str8 = new String(d.b.o0.e.h.c.a("dmFpZA==".getBytes()));
                optJSONObject.put(str3, this.f64204a.b());
                optJSONObject.put(str4, this.f64204a.h());
                optJSONObject.put(str5, this.f64204a.getStatusCode());
                optJSONObject.put(str6, this.f64204a.getOAID());
                optJSONObject.put(str7, this.f64204a.getAAID());
                optJSONObject.put(str8, this.f64204a.getVAID());
                jSONObject.put(str2, optJSONObject);
                d.b.o0.e.h.e.b(l(jSONObject.toString()), file2, false, f64202g);
                if (f64199d) {
                    String str9 = f64198c;
                    Log.d(str9, "trySaveFiles, app: " + jSONObject.toString());
                    return true;
                }
                return true;
            }
            return false;
        } catch (Exception e2) {
            if (f64199d) {
                String str10 = f64198c;
                Log.d(str10, "trySaveFiles, error " + e2.getMessage());
            }
            return false;
        }
    }
}
