package d.a.i0.a.i1.f.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.wallet.router.RouterCallback;
import d.a.i0.a.k;
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
    public static final boolean q = k.f43025a;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a r;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f42767a;

    /* renamed from: b  reason: collision with root package name */
    public String f42768b;

    /* renamed from: c  reason: collision with root package name */
    public int f42769c;

    /* renamed from: e  reason: collision with root package name */
    public Context f42771e;

    /* renamed from: f  reason: collision with root package name */
    public String f42772f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f42773g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.a.i1.f.d.b f42774h;

    /* renamed from: i  reason: collision with root package name */
    public long f42775i;
    public long j;
    public d.a.i0.a.i1.f.b l;
    public boolean m;
    public TelephonyManager n;
    public d.a.i0.a.i1.f.d.a o;

    /* renamed from: d  reason: collision with root package name */
    public int f42770d = -1;
    public d.a.i0.a.i1.f.a k = new d.a.i0.a.i1.f.a();
    public boolean p = false;

    /* renamed from: d.a.i0.a.i1.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0704a implements d.a.i0.a.i1.f.d.b {
        public C0704a() {
        }

        @Override // d.a.i0.a.i1.f.d.b
        public void a() {
            if (a.q) {
                Log.d("AudioRecorderManager", "record --- timeOut");
            }
            d.a.i0.a.e0.d.g("recorder", "time out");
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
            d.a.i0.a.e0.d.b("recorder", "record error");
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
        public final /* synthetic */ d.a.i0.a.i1.f.d.b f42779e;

        public d(d.a.i0.a.i1.f.d.b bVar) {
            this.f42779e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.a.i0.a.i1.f.d.b bVar = this.f42779e;
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
            if (a.this.f42774h != null) {
                a.this.f42774h.a();
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
        d.a.i0.a.e0.d.g("recorder", "resume timer");
        d.a.i0.a.i1.f.d.b bVar = this.f42774h;
        if (bVar != null) {
            if (this.j <= 0) {
                bVar.a();
                return;
            }
            Timer timer = new Timer();
            this.f42773g = timer;
            timer.schedule(new e(), this.j);
            this.f42775i = System.currentTimeMillis();
        }
    }

    public boolean C() {
        byte[] bArr = new byte[this.f42769c];
        d.a.i0.a.i1.f.a aVar = this.k;
        d.a.i0.a.i1.f.f.a aVar2 = new d.a.i0.a.i1.f.f.a(aVar.f42737b, aVar.f42738c, aVar.f42739d, aVar.f42740e);
        if (this.f42767a == null) {
            return false;
        }
        return v(bArr, aVar2);
    }

    public void D(boolean z) {
        if (this.f42771e == null) {
            f();
            d.a.i0.a.e0.d.b("recorder", "start error, context is null");
            z();
        } else if (this.f42770d != -1 && !TextUtils.isEmpty(this.f42768b)) {
            if (z) {
                String str = null;
                int i2 = this.f42770d;
                if (i2 == 1) {
                    str = "start fail: recorder is recording";
                } else if (i2 != 0 && i2 != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    g(2003, str);
                    d.a.i0.a.e0.d.b("recorder", str);
                    return;
                }
            }
            if (q) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.f42767a.startRecording();
                if (this.f42767a.getRecordingState() != 3) {
                    f();
                    d.a.i0.a.e0.d.b("recorder", "start error, no real permission");
                    z();
                    return;
                }
                if (z) {
                    E(new C0704a());
                    e(d.a.i0.a.i1.f.b.f42744d, "recorderStart");
                } else {
                    e(d.a.i0.a.i1.f.b.f42746f, "recorderResume");
                }
                h.d.i("").D(Schedulers.io()).k(new c()).o(h.l.b.a.b()).B(new b());
            } catch (IllegalStateException e2) {
                f();
                d.a.i0.a.e0.d.c("recorder", "can't start", e2);
                z();
            }
        } else {
            f();
            d.a.i0.a.e0.d.b("recorder", "start error, wrong state");
            z();
        }
    }

    public void E(d.a.i0.a.i1.f.d.b bVar) {
        if (q) {
            Log.d("AudioRecorderManager", "start timer:" + this.k.f42736a);
        }
        d.a.i0.a.e0.d.g("recorder", "start timer, totalTime:" + this.k.f42736a);
        this.f42774h = bVar;
        Timer timer = new Timer();
        this.f42773g = timer;
        timer.schedule(new d(bVar), this.k.f42736a);
        this.f42775i = System.currentTimeMillis();
    }

    public void F() {
        if (q) {
            Log.d("AudioRecorderManager", "stop record");
        }
        AudioRecord audioRecord = this.f42767a;
        if (audioRecord == null) {
            f();
            d.a.i0.a.e0.d.b("recorder", "none audioRecord");
            z();
            return;
        }
        try {
            audioRecord.stop();
            G();
            this.f42770d = 3;
            h();
            H();
        } catch (IllegalStateException e2) {
            f();
            d.a.i0.a.e0.d.c("recorder", "stop error", e2);
            z();
        }
    }

    public void G() {
        if (q) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        d.a.i0.a.e0.d.g("recorder", "stop timer");
        this.f42774h = null;
        Timer timer = this.f42773g;
        if (timer != null) {
            timer.cancel();
            this.f42773g = null;
        }
    }

    public final void H() {
        d.a.i0.a.i1.f.d.a aVar;
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
        d.a.i0.a.g1.f.V().v(new d.a.i0.a.o0.d.b(str2));
    }

    public final void f() {
        g(2002, "error execute");
    }

    public final void g(int i2, String str) {
        if (this.l != null && !TextUtils.isEmpty(d.a.i0.a.i1.f.b.f42748h)) {
            this.l.d(i2, str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, i2);
            jSONObject.put("errMsg", str);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            d.a.i0.a.g1.f.V().v(new d.a.i0.a.o0.d.b("recorderError", hashMap));
        } catch (JSONException e2) {
            d.a.i0.a.e0.d.c("recorder", "json error", e2);
            z();
        }
    }

    public final void h() {
        long j;
        String J = d.a.i0.a.k2.b.J(this.f42768b, this.f42772f);
        long j2 = -1;
        if (TextUtils.isEmpty(this.f42768b)) {
            j = -1;
        } else {
            j2 = d.a.i0.t.d.t(this.f42768b);
            j = new File(this.f42768b).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(J)) {
                jSONObject.put("tempFilePath", J);
            }
            if (j2 >= 0) {
                jSONObject.put("duration", j2);
            }
            if (j >= 0) {
                jSONObject.put("fileSize", j);
            }
            if (this.l != null && !TextUtils.isEmpty(d.a.i0.a.i1.f.b.f42747g)) {
                this.l.c(d.a.i0.a.i1.f.b.f42747g, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            d.a.i0.a.g1.f.V().v(new d.a.i0.a.o0.d.b("recorderStop", hashMap));
        } catch (JSONException e2) {
            f();
            d.a.i0.a.e0.d.c("recorder", "json error", e2);
            z();
        }
    }

    public d.a.i0.a.i1.f.b i() {
        return this.l;
    }

    public d.a.i0.a.i1.f.a j() {
        return this.k;
    }

    public void l(String str, d.a.i0.a.i1.f.a aVar, Context context, d.a.i0.a.i1.f.b bVar, String str2) {
        int i2 = this.f42770d;
        if (i2 != -1 && i2 != 3) {
            d.a.i0.a.e0.d.b("recorder", "wrong state, can't init");
            return;
        }
        this.k = aVar;
        m(str);
        this.l = bVar;
        int minBufferSize = AudioRecord.getMinBufferSize(aVar.f42739d, aVar.f42738c, 2);
        this.f42769c = minBufferSize;
        if (minBufferSize <= 0) {
            f();
            d.a.i0.a.e0.d.b("recorder", "wrong buffer size");
            z();
            return;
        }
        this.f42767a = new AudioRecord(aVar.f42741f, aVar.f42739d, aVar.f42738c == 1 ? 16 : 12, 2, this.f42769c);
        this.f42770d = 0;
        this.f42771e = context;
        this.f42772f = str2;
        w();
    }

    public final void m(String str) {
        String str2;
        if (TextUtils.equals(this.k.f42737b, "mp3")) {
            str2 = EmotionResourceProvider.EMOTION_SOUND_SUFFIX;
        } else {
            str2 = TextUtils.equals(this.k.f42737b, "pcm") ? ".pcm" : ".aac";
        }
        this.f42768b = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void n() {
        int i2 = this.f42770d;
        if (i2 == 0 || i2 == 1) {
            if (!this.p) {
                this.p = true;
                e(d.a.i0.a.i1.f.b.f42749i, "recorderInterruptionBegin");
            }
            t();
        }
    }

    public void o() {
        if (this.p) {
            this.p = false;
            e(d.a.i0.a.i1.f.b.j, "recorderInterruptionEnd");
        }
    }

    public boolean p(String str) {
        int i2;
        String str2;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.f42770d != 1) {
                str2 = "pause fail: recorder is not recording";
            }
            str2 = null;
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.f42770d != 2) {
                str2 = "resume fail: recorder is not paused";
            }
            str2 = null;
        } else {
            if (TextUtils.equals(str, "/swanAPI/recorder/stop") && (i2 = this.f42770d) != 2 && i2 != 1) {
                str2 = "stop fail: recorder is not started";
            }
            str2 = null;
        }
        if (str2 != null) {
            g(2003, str2);
            d.a.i0.a.e0.d.b("recorder", str2);
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
        if (z && this.f42770d == 1) {
            t();
        }
        this.m = z;
    }

    public void t() {
        if (q) {
            Log.d("AudioRecorderManager", "pause record");
        }
        AudioRecord audioRecord = this.f42767a;
        if (audioRecord == null) {
            f();
            d.a.i0.a.e0.d.b("recorder", "none audio record");
            z();
            return;
        }
        try {
            audioRecord.stop();
            this.f42770d = 2;
            u();
            e(d.a.i0.a.i1.f.b.f42745e, "recorderPause");
        } catch (IllegalStateException e2) {
            f();
            d.a.i0.a.e0.d.c("recorder", "pause error", e2);
            z();
        }
    }

    public void u() {
        if (q) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.j);
        }
        d.a.i0.a.e0.d.g("recorder", "pause timer, lastTime:" + this.j);
        Timer timer = this.f42773g;
        if (timer != null) {
            timer.cancel();
            this.f42773g = null;
        }
        this.j = this.k.f42736a - (System.currentTimeMillis() - this.f42775i);
    }

    public final boolean v(byte[] bArr, d.a.i0.a.i1.f.f.a aVar) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.f42768b);
                if (this.f42770d == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    d.a.i0.t.d.h(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            this.f42770d = 1;
            while (this.f42770d == 1) {
                if (this.f42767a.read(bArr, 0, this.f42769c) >= 0) {
                    byte[] f2 = TextUtils.equals(this.k.f42737b, "pcm") ? bArr : aVar.f(bArr);
                    if (f2 != null && f2.length > 0) {
                        fileOutputStream.write(f2);
                    }
                }
            }
            d.a.i0.t.d.d(fileOutputStream);
            return true;
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            d.a.i0.a.e0.d.c("recorder", "save record error", e);
            if (this.f42770d == 1) {
                this.f42770d = 3;
            }
            d.a.i0.t.d.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a.i0.t.d.d(fileOutputStream2);
            throw th;
        }
    }

    public final void w() {
        Context context = this.f42771e;
        if (context == null) {
            return;
        }
        this.n = (TelephonyManager) context.getSystemService("phone");
        d.a.i0.a.i1.f.d.a aVar = new d.a.i0.a.i1.f.d.a();
        this.o = aVar;
        this.n.listen(aVar, 32);
    }

    public final void z() {
        G();
        this.f42771e = null;
        this.f42770d = -1;
        AudioRecord audioRecord = this.f42767a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f42767a = null;
        }
    }
}
