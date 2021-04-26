package d.a.h0.a.b1.f.e;

import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.wallet.router.RouterCallback;
import d.a.h0.a.k;
import h.n.f;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class a {
    public static final boolean q = k.f43101a;
    public static volatile a r;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f41494a;

    /* renamed from: b  reason: collision with root package name */
    public String f41495b;

    /* renamed from: c  reason: collision with root package name */
    public int f41496c;

    /* renamed from: e  reason: collision with root package name */
    public Context f41498e;

    /* renamed from: f  reason: collision with root package name */
    public String f41499f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f41500g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.h0.a.b1.f.d.b f41501h;

    /* renamed from: i  reason: collision with root package name */
    public long f41502i;
    public long j;
    public d.a.h0.a.b1.f.b l;
    public boolean m;
    public TelephonyManager n;
    public d.a.h0.a.b1.f.d.a o;

    /* renamed from: d  reason: collision with root package name */
    public int f41497d = -1;
    public d.a.h0.a.b1.f.a k = new d.a.h0.a.b1.f.a();
    public boolean p = false;

    /* renamed from: d.a.h0.a.b1.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0581a implements d.a.h0.a.b1.f.d.b {
        public C0581a() {
        }

        @Override // d.a.h0.a.b1.f.d.b
        public void a() {
            if (a.q) {
                Log.d("AudioRecorderManager", "record --- timeOut");
            }
            d.a.h0.a.c0.c.g("recorder", "time out");
            a.this.F();
            a.this.z();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h.n.b<Boolean> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Boolean bool) {
            if (bool.booleanValue()) {
                return;
            }
            a.this.f();
            d.a.h0.a.c0.c.b("recorder", "record error");
            a.this.z();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements f<String, Boolean> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(String str) {
            return Boolean.valueOf(a.this.C());
        }
    }

    /* loaded from: classes3.dex */
    public class d extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.b1.f.d.b f41506e;

        public d(d.a.h0.a.b1.f.d.b bVar) {
            this.f41506e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.a.h0.a.b1.f.d.b bVar = this.f41506e;
            if (bVar != null) {
                bVar.a();
            }
            a.this.G();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends TimerTask {
        public e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (a.this.f41501h != null) {
                a.this.f41501h.a();
            }
            a.this.G();
        }
    }

    public static a k() {
        if (r == null) {
            synchronized (a.class) {
                if (r == null) {
                    r = new a();
                }
            }
        }
        return r;
    }

    public static void r(boolean z) {
        if (r == null) {
            return;
        }
        r.s(z);
    }

    public static void x() {
        if (r == null) {
            return;
        }
        r.z();
        r.H();
        r.o();
    }

    public static void y() {
        x();
        r = null;
    }

    public void A() {
        if (q) {
            Log.d("AudioRecorderManager", "resume record");
        }
        D(false);
        B();
    }

    public void B() {
        if (q) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        d.a.h0.a.c0.c.g("recorder", "resume timer");
        d.a.h0.a.b1.f.d.b bVar = this.f41501h;
        if (bVar != null) {
            if (this.j <= 0) {
                bVar.a();
                return;
            }
            Timer timer = new Timer();
            this.f41500g = timer;
            timer.schedule(new e(), this.j);
            this.f41502i = System.currentTimeMillis();
        }
    }

    public boolean C() {
        byte[] bArr = new byte[this.f41496c];
        d.a.h0.a.b1.f.a aVar = this.k;
        d.a.h0.a.b1.f.f.a aVar2 = new d.a.h0.a.b1.f.f.a(aVar.f41464b, aVar.f41465c, aVar.f41466d, aVar.f41467e);
        if (this.f41494a == null) {
            return false;
        }
        return v(bArr, aVar2);
    }

    public void D(boolean z) {
        if (this.f41498e == null) {
            f();
            d.a.h0.a.c0.c.b("recorder", "start error, context is null");
            z();
        } else if (this.f41497d != -1 && !TextUtils.isEmpty(this.f41495b)) {
            if (z) {
                String str = null;
                int i2 = this.f41497d;
                if (i2 == 1) {
                    str = "start fail: recorder is recording";
                } else if (i2 != 0 && i2 != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    g(2003, str);
                    d.a.h0.a.c0.c.b("recorder", str);
                    return;
                }
            }
            if (q) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.f41494a.startRecording();
                if (this.f41494a.getRecordingState() != 3) {
                    f();
                    d.a.h0.a.c0.c.b("recorder", "start error, no real permission");
                    z();
                    return;
                }
                if (z) {
                    E(new C0581a());
                    e(d.a.h0.a.b1.f.b.f41471d, "recorderStart");
                } else {
                    e(d.a.h0.a.b1.f.b.f41473f, "recorderResume");
                }
                h.d.i("").D(Schedulers.io()).k(new c()).o(h.l.b.a.b()).B(new b());
            } catch (IllegalStateException e2) {
                f();
                d.a.h0.a.c0.c.c("recorder", "can't start", e2);
                z();
            }
        } else {
            f();
            d.a.h0.a.c0.c.b("recorder", "start error, wrong state");
            z();
        }
    }

    public void E(d.a.h0.a.b1.f.d.b bVar) {
        if (q) {
            Log.d("AudioRecorderManager", "start timer:" + this.k.f41463a);
        }
        d.a.h0.a.c0.c.g("recorder", "start timer, totalTime:" + this.k.f41463a);
        this.f41501h = bVar;
        Timer timer = new Timer();
        this.f41500g = timer;
        timer.schedule(new d(bVar), this.k.f41463a);
        this.f41502i = System.currentTimeMillis();
    }

    public void F() {
        if (q) {
            Log.d("AudioRecorderManager", "stop record");
        }
        AudioRecord audioRecord = this.f41494a;
        if (audioRecord == null) {
            f();
            d.a.h0.a.c0.c.b("recorder", "none audioRecord");
            z();
            return;
        }
        try {
            audioRecord.stop();
            G();
            this.f41497d = 3;
            h();
            H();
        } catch (IllegalStateException e2) {
            f();
            d.a.h0.a.c0.c.c("recorder", "stop error", e2);
            z();
        }
    }

    public void G() {
        if (q) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        d.a.h0.a.c0.c.g("recorder", "stop timer");
        this.f41501h = null;
        Timer timer = this.f41500g;
        if (timer != null) {
            timer.cancel();
            this.f41500g = null;
        }
    }

    public final void H() {
        d.a.h0.a.b1.f.d.a aVar;
        TelephonyManager telephonyManager = this.n;
        if (telephonyManager == null || (aVar = this.o) == null) {
            return;
        }
        telephonyManager.listen(aVar, 0);
        this.n = null;
        this.o = null;
    }

    public final void e(String str, String str2) {
        if (q) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.l != null && !TextUtils.isEmpty(str)) {
            this.l.b(str);
            return;
        }
        d.a.h0.a.z0.f.V().x(new d.a.h0.a.k0.b.b(str2));
    }

    public final void f() {
        g(2002, "error execute");
    }

    public final void g(int i2, String str) {
        if (this.l != null && !TextUtils.isEmpty(d.a.h0.a.b1.f.b.f41475h)) {
            this.l.d(i2, str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, i2);
            jSONObject.put("errMsg", str);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            d.a.h0.a.z0.f.V().x(new d.a.h0.a.k0.b.b("recorderError", hashMap));
        } catch (JSONException e2) {
            d.a.h0.a.c0.c.c("recorder", "json error", e2);
            z();
        }
    }

    public final void h() {
        long j;
        String r2 = d.a.h0.a.a2.b.r(this.f41495b, this.f41499f);
        long j2 = -1;
        if (TextUtils.isEmpty(this.f41495b)) {
            j = -1;
        } else {
            j2 = d.a.h0.p.d.m(this.f41495b);
            j = new File(this.f41495b).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(r2)) {
                jSONObject.put("tempFilePath", r2);
            }
            if (j2 >= 0) {
                jSONObject.put("duration", j2);
            }
            if (j >= 0) {
                jSONObject.put("fileSize", j);
            }
            if (this.l != null && !TextUtils.isEmpty(d.a.h0.a.b1.f.b.f41474g)) {
                this.l.c(d.a.h0.a.b1.f.b.f41474g, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            d.a.h0.a.z0.f.V().x(new d.a.h0.a.k0.b.b("recorderStop", hashMap));
        } catch (JSONException e2) {
            f();
            d.a.h0.a.c0.c.c("recorder", "json error", e2);
            z();
        }
    }

    public d.a.h0.a.b1.f.b i() {
        return this.l;
    }

    public d.a.h0.a.b1.f.a j() {
        return this.k;
    }

    public void l(String str, d.a.h0.a.b1.f.a aVar, Context context, d.a.h0.a.b1.f.b bVar, String str2) {
        int i2 = this.f41497d;
        if (i2 != -1 && i2 != 3) {
            d.a.h0.a.c0.c.b("recorder", "wrong state, can't init");
            return;
        }
        this.k = aVar;
        m(str);
        this.l = bVar;
        int minBufferSize = AudioRecord.getMinBufferSize(aVar.f41466d, aVar.f41465c, 2);
        this.f41496c = minBufferSize;
        if (minBufferSize <= 0) {
            f();
            d.a.h0.a.c0.c.b("recorder", "wrong buffer size");
            z();
            return;
        }
        this.f41494a = new AudioRecord(aVar.f41468f, aVar.f41466d, aVar.f41465c == 1 ? 16 : 12, 2, this.f41496c);
        this.f41497d = 0;
        this.f41498e = context;
        this.f41499f = str2;
        w();
    }

    public final void m(String str) {
        String str2;
        if (TextUtils.equals(this.k.f41464b, "mp3")) {
            str2 = EmotionResourceProvider.EMOTION_SOUND_SUFFIX;
        } else {
            str2 = TextUtils.equals(this.k.f41464b, "pcm") ? ".pcm" : ".aac";
        }
        this.f41495b = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void n() {
        int i2 = this.f41497d;
        if (i2 == 0 || i2 == 1) {
            if (!this.p) {
                this.p = true;
                e(d.a.h0.a.b1.f.b.f41476i, "recorderInterruptionBegin");
            }
            t();
        }
    }

    public void o() {
        if (this.p) {
            this.p = false;
            e(d.a.h0.a.b1.f.b.j, "recorderInterruptionEnd");
        }
    }

    public boolean p(String str) {
        int i2;
        String str2;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.f41497d != 1) {
                str2 = "pause fail: recorder is not recording";
            }
            str2 = null;
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.f41497d != 2) {
                str2 = "resume fail: recorder is not paused";
            }
            str2 = null;
        } else {
            if (TextUtils.equals(str, "/swanAPI/recorder/stop") && (i2 = this.f41497d) != 2 && i2 != 1) {
                str2 = "stop fail: recorder is not started";
            }
            str2 = null;
        }
        if (str2 != null) {
            g(2003, str2);
            d.a.h0.a.c0.c.b("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean q(String str) {
        if (this.m) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    public void s(boolean z) {
        if (z && this.f41497d == 1) {
            t();
        }
        this.m = z;
    }

    public void t() {
        if (q) {
            Log.d("AudioRecorderManager", "pause record");
        }
        AudioRecord audioRecord = this.f41494a;
        if (audioRecord == null) {
            f();
            d.a.h0.a.c0.c.b("recorder", "none audio record");
            z();
            return;
        }
        try {
            audioRecord.stop();
            this.f41497d = 2;
            u();
            e(d.a.h0.a.b1.f.b.f41472e, "recorderPause");
        } catch (IllegalStateException e2) {
            f();
            d.a.h0.a.c0.c.c("recorder", "pause error", e2);
            z();
        }
    }

    public void u() {
        if (q) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.j);
        }
        d.a.h0.a.c0.c.g("recorder", "pause timer, lastTime:" + this.j);
        Timer timer = this.f41500g;
        if (timer != null) {
            timer.cancel();
            this.f41500g = null;
        }
        this.j = this.k.f41463a - (System.currentTimeMillis() - this.f41502i);
    }

    public final boolean v(byte[] bArr, d.a.h0.a.b1.f.f.a aVar) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.f41495b);
                if (this.f41497d == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    d.a.h0.p.d.e(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            this.f41497d = 1;
            while (this.f41497d == 1) {
                if (this.f41494a.read(bArr, 0, this.f41496c) >= 0) {
                    byte[] f2 = TextUtils.equals(this.k.f41464b, "pcm") ? bArr : aVar.f(bArr);
                    if (f2 != null && f2.length > 0) {
                        fileOutputStream.write(f2);
                    }
                }
            }
            d.a.h0.p.d.a(fileOutputStream);
            return true;
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            d.a.h0.a.c0.c.c("recorder", "save record error", e);
            if (this.f41497d == 1) {
                this.f41497d = 3;
            }
            d.a.h0.p.d.a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a.h0.p.d.a(fileOutputStream2);
            throw th;
        }
    }

    public final void w() {
        Context context = this.f41498e;
        if (context == null) {
            return;
        }
        this.n = (TelephonyManager) context.getSystemService("phone");
        d.a.h0.a.b1.f.d.a aVar = new d.a.h0.a.b1.f.d.a();
        this.o = aVar;
        this.n.listen(aVar, 32);
    }

    public final void z() {
        G();
        this.f41498e = null;
        this.f41497d = -1;
        AudioRecord audioRecord = this.f41494a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f41494a = null;
        }
    }
}
