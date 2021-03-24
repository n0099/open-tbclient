package d.b.g0.a.b1.f.e;

import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.wallet.router.RouterCallback;
import d.b.g0.a.k;
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
    public static final boolean q = k.f45050a;
    public static volatile a r;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f43492a;

    /* renamed from: b  reason: collision with root package name */
    public String f43493b;

    /* renamed from: c  reason: collision with root package name */
    public int f43494c;

    /* renamed from: e  reason: collision with root package name */
    public Context f43496e;

    /* renamed from: f  reason: collision with root package name */
    public String f43497f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f43498g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.a.b1.f.d.b f43499h;
    public long i;
    public long j;
    public d.b.g0.a.b1.f.b l;
    public boolean m;
    public TelephonyManager n;
    public d.b.g0.a.b1.f.d.a o;

    /* renamed from: d  reason: collision with root package name */
    public int f43495d = -1;
    public d.b.g0.a.b1.f.a k = new d.b.g0.a.b1.f.a();
    public boolean p = false;

    /* renamed from: d.b.g0.a.b1.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0609a implements d.b.g0.a.b1.f.d.b {
        public C0609a() {
        }

        @Override // d.b.g0.a.b1.f.d.b
        public void a() {
            if (a.q) {
                Log.d("AudioRecorderManager", "record --- timeOut");
            }
            d.b.g0.a.c0.c.g("recorder", "time out");
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
            d.b.g0.a.c0.c.b("recorder", "record error");
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
        public final /* synthetic */ d.b.g0.a.b1.f.d.b f43503e;

        public d(d.b.g0.a.b1.f.d.b bVar) {
            this.f43503e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.b.g0.a.b1.f.d.b bVar = this.f43503e;
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
            if (a.this.f43499h != null) {
                a.this.f43499h.a();
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
        d.b.g0.a.c0.c.g("recorder", "resume timer");
        d.b.g0.a.b1.f.d.b bVar = this.f43499h;
        if (bVar != null) {
            if (this.j <= 0) {
                bVar.a();
                return;
            }
            Timer timer = new Timer();
            this.f43498g = timer;
            timer.schedule(new e(), this.j);
            this.i = System.currentTimeMillis();
        }
    }

    public boolean C() {
        byte[] bArr = new byte[this.f43494c];
        d.b.g0.a.b1.f.a aVar = this.k;
        d.b.g0.a.b1.f.f.a aVar2 = new d.b.g0.a.b1.f.f.a(aVar.f43465b, aVar.f43466c, aVar.f43467d, aVar.f43468e);
        if (this.f43492a == null) {
            return false;
        }
        return v(bArr, aVar2);
    }

    public void D(boolean z) {
        if (this.f43496e == null) {
            f();
            d.b.g0.a.c0.c.b("recorder", "start error, context is null");
            z();
        } else if (this.f43495d != -1 && !TextUtils.isEmpty(this.f43493b)) {
            if (z) {
                String str = null;
                int i = this.f43495d;
                if (i == 1) {
                    str = "start fail: recorder is recording";
                } else if (i != 0 && i != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    g(2003, str);
                    d.b.g0.a.c0.c.b("recorder", str);
                    return;
                }
            }
            if (q) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.f43492a.startRecording();
                if (this.f43492a.getRecordingState() != 3) {
                    f();
                    d.b.g0.a.c0.c.b("recorder", "start error, no real permission");
                    z();
                    return;
                }
                if (z) {
                    E(new C0609a());
                    e(d.b.g0.a.b1.f.b.f43472d, "recorderStart");
                } else {
                    e(d.b.g0.a.b1.f.b.f43474f, "recorderResume");
                }
                h.d.j("").F(Schedulers.io()).l(new c()).p(h.l.b.a.b()).D(new b());
            } catch (IllegalStateException e2) {
                f();
                d.b.g0.a.c0.c.c("recorder", "can't start", e2);
                z();
            }
        } else {
            f();
            d.b.g0.a.c0.c.b("recorder", "start error, wrong state");
            z();
        }
    }

    public void E(d.b.g0.a.b1.f.d.b bVar) {
        if (q) {
            Log.d("AudioRecorderManager", "start timer:" + this.k.f43464a);
        }
        d.b.g0.a.c0.c.g("recorder", "start timer, totalTime:" + this.k.f43464a);
        this.f43499h = bVar;
        Timer timer = new Timer();
        this.f43498g = timer;
        timer.schedule(new d(bVar), this.k.f43464a);
        this.i = System.currentTimeMillis();
    }

    public void F() {
        if (q) {
            Log.d("AudioRecorderManager", "stop record");
        }
        AudioRecord audioRecord = this.f43492a;
        if (audioRecord == null) {
            f();
            d.b.g0.a.c0.c.b("recorder", "none audioRecord");
            z();
            return;
        }
        try {
            audioRecord.stop();
            G();
            this.f43495d = 3;
            h();
            H();
        } catch (IllegalStateException e2) {
            f();
            d.b.g0.a.c0.c.c("recorder", "stop error", e2);
            z();
        }
    }

    public void G() {
        if (q) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        d.b.g0.a.c0.c.g("recorder", "stop timer");
        this.f43499h = null;
        Timer timer = this.f43498g;
        if (timer != null) {
            timer.cancel();
            this.f43498g = null;
        }
    }

    public final void H() {
        d.b.g0.a.b1.f.d.a aVar;
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
        d.b.g0.a.z0.f.V().N(new d.b.g0.a.k0.b.b(str2));
    }

    public final void f() {
        g(2002, "error execute");
    }

    public final void g(int i, String str) {
        if (this.l != null && !TextUtils.isEmpty(d.b.g0.a.b1.f.b.f43476h)) {
            this.l.d(i, str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, i);
            jSONObject.put("errMsg", str);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            d.b.g0.a.z0.f.V().N(new d.b.g0.a.k0.b.b("recorderError", hashMap));
        } catch (JSONException e2) {
            d.b.g0.a.c0.c.c("recorder", "json error", e2);
            z();
        }
    }

    public final void h() {
        long j;
        String r2 = d.b.g0.a.a2.b.r(this.f43493b, this.f43497f);
        long j2 = -1;
        if (TextUtils.isEmpty(this.f43493b)) {
            j = -1;
        } else {
            j2 = d.b.g0.p.d.m(this.f43493b);
            j = new File(this.f43493b).length();
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
            if (this.l != null && !TextUtils.isEmpty(d.b.g0.a.b1.f.b.f43475g)) {
                this.l.c(d.b.g0.a.b1.f.b.f43475g, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            d.b.g0.a.z0.f.V().N(new d.b.g0.a.k0.b.b("recorderStop", hashMap));
        } catch (JSONException e2) {
            f();
            d.b.g0.a.c0.c.c("recorder", "json error", e2);
            z();
        }
    }

    public d.b.g0.a.b1.f.b i() {
        return this.l;
    }

    public d.b.g0.a.b1.f.a j() {
        return this.k;
    }

    public void l(String str, d.b.g0.a.b1.f.a aVar, Context context, d.b.g0.a.b1.f.b bVar, String str2) {
        int i = this.f43495d;
        if (i != -1 && i != 3) {
            d.b.g0.a.c0.c.b("recorder", "wrong state, can't init");
            return;
        }
        this.k = aVar;
        m(str);
        this.l = bVar;
        int minBufferSize = AudioRecord.getMinBufferSize(aVar.f43467d, aVar.f43466c, 2);
        this.f43494c = minBufferSize;
        if (minBufferSize <= 0) {
            f();
            d.b.g0.a.c0.c.b("recorder", "wrong buffer size");
            z();
            return;
        }
        this.f43492a = new AudioRecord(aVar.f43469f, aVar.f43467d, aVar.f43466c == 1 ? 16 : 12, 2, this.f43494c);
        this.f43495d = 0;
        this.f43496e = context;
        this.f43497f = str2;
        w();
    }

    public final void m(String str) {
        String str2;
        if (TextUtils.equals(this.k.f43465b, "mp3")) {
            str2 = EmotionResourceProvider.EMOTION_SOUND_SUFFIX;
        } else {
            str2 = TextUtils.equals(this.k.f43465b, "pcm") ? ".pcm" : ".aac";
        }
        this.f43493b = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void n() {
        int i = this.f43495d;
        if (i == 0 || i == 1) {
            if (!this.p) {
                this.p = true;
                e(d.b.g0.a.b1.f.b.i, "recorderInterruptionBegin");
            }
            t();
        }
    }

    public void o() {
        if (this.p) {
            this.p = false;
            e(d.b.g0.a.b1.f.b.j, "recorderInterruptionEnd");
        }
    }

    public boolean p(String str) {
        int i;
        String str2;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.f43495d != 1) {
                str2 = "pause fail: recorder is not recording";
            }
            str2 = null;
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.f43495d != 2) {
                str2 = "resume fail: recorder is not paused";
            }
            str2 = null;
        } else {
            if (TextUtils.equals(str, "/swanAPI/recorder/stop") && (i = this.f43495d) != 2 && i != 1) {
                str2 = "stop fail: recorder is not started";
            }
            str2 = null;
        }
        if (str2 != null) {
            g(2003, str2);
            d.b.g0.a.c0.c.b("recorder", str2);
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
        if (z && this.f43495d == 1) {
            t();
        }
        this.m = z;
    }

    public void t() {
        if (q) {
            Log.d("AudioRecorderManager", "pause record");
        }
        AudioRecord audioRecord = this.f43492a;
        if (audioRecord == null) {
            f();
            d.b.g0.a.c0.c.b("recorder", "none audio record");
            z();
            return;
        }
        try {
            audioRecord.stop();
            this.f43495d = 2;
            u();
            e(d.b.g0.a.b1.f.b.f43473e, "recorderPause");
        } catch (IllegalStateException e2) {
            f();
            d.b.g0.a.c0.c.c("recorder", "pause error", e2);
            z();
        }
    }

    public void u() {
        if (q) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.j);
        }
        d.b.g0.a.c0.c.g("recorder", "pause timer, lastTime:" + this.j);
        Timer timer = this.f43498g;
        if (timer != null) {
            timer.cancel();
            this.f43498g = null;
        }
        this.j = this.k.f43464a - (System.currentTimeMillis() - this.i);
    }

    public final boolean v(byte[] bArr, d.b.g0.a.b1.f.f.a aVar) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.f43493b);
                if (this.f43495d == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    d.b.g0.p.d.e(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            this.f43495d = 1;
            while (this.f43495d == 1) {
                if (this.f43492a.read(bArr, 0, this.f43494c) >= 0) {
                    byte[] f2 = TextUtils.equals(this.k.f43465b, "pcm") ? bArr : aVar.f(bArr);
                    if (f2 != null && f2.length > 0) {
                        fileOutputStream.write(f2);
                    }
                }
            }
            d.b.g0.p.d.a(fileOutputStream);
            return true;
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            d.b.g0.a.c0.c.c("recorder", "save record error", e);
            if (this.f43495d == 1) {
                this.f43495d = 3;
            }
            d.b.g0.p.d.a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.b.g0.p.d.a(fileOutputStream2);
            throw th;
        }
    }

    public final void w() {
        Context context = this.f43496e;
        if (context == null) {
            return;
        }
        this.n = (TelephonyManager) context.getSystemService("phone");
        d.b.g0.a.b1.f.d.a aVar = new d.b.g0.a.b1.f.d.a();
        this.o = aVar;
        this.n.listen(aVar, 32);
    }

    public final void z() {
        G();
        this.f43496e = null;
        this.f43495d = -1;
        AudioRecord audioRecord = this.f43492a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f43492a = null;
        }
    }
}
