package d.a.m0.a.i1.f.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.wallet.router.RouterCallback;
import d.a.m0.a.k;
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
    public static final boolean q = k.f46983a;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a r;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f46725a;

    /* renamed from: b  reason: collision with root package name */
    public String f46726b;

    /* renamed from: c  reason: collision with root package name */
    public int f46727c;

    /* renamed from: e  reason: collision with root package name */
    public Context f46729e;

    /* renamed from: f  reason: collision with root package name */
    public String f46730f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f46731g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.a.i1.f.d.b f46732h;

    /* renamed from: i  reason: collision with root package name */
    public long f46733i;
    public long j;
    public d.a.m0.a.i1.f.b l;
    public boolean m;
    public TelephonyManager n;
    public d.a.m0.a.i1.f.d.a o;

    /* renamed from: d  reason: collision with root package name */
    public int f46728d = -1;
    public d.a.m0.a.i1.f.a k = new d.a.m0.a.i1.f.a();
    public boolean p = false;

    /* renamed from: d.a.m0.a.i1.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0774a implements d.a.m0.a.i1.f.d.b {
        public C0774a() {
        }

        @Override // d.a.m0.a.i1.f.d.b
        public void a() {
            if (a.q) {
                Log.d("AudioRecorderManager", "record --- timeOut");
            }
            d.a.m0.a.e0.d.g("recorder", "time out");
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
            d.a.m0.a.e0.d.b("recorder", "record error");
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
        public final /* synthetic */ d.a.m0.a.i1.f.d.b f46737e;

        public d(d.a.m0.a.i1.f.d.b bVar) {
            this.f46737e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.a.m0.a.i1.f.d.b bVar = this.f46737e;
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
            if (a.this.f46732h != null) {
                a.this.f46732h.a();
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
        d.a.m0.a.e0.d.g("recorder", "resume timer");
        d.a.m0.a.i1.f.d.b bVar = this.f46732h;
        if (bVar != null) {
            if (this.j <= 0) {
                bVar.a();
                return;
            }
            Timer timer = new Timer();
            this.f46731g = timer;
            timer.schedule(new e(), this.j);
            this.f46733i = System.currentTimeMillis();
        }
    }

    public boolean C() {
        byte[] bArr = new byte[this.f46727c];
        d.a.m0.a.i1.f.a aVar = this.k;
        d.a.m0.a.i1.f.f.a aVar2 = new d.a.m0.a.i1.f.f.a(aVar.f46695b, aVar.f46696c, aVar.f46697d, aVar.f46698e);
        if (this.f46725a == null) {
            return false;
        }
        return v(bArr, aVar2);
    }

    public void D(boolean z) {
        if (this.f46729e == null) {
            f();
            d.a.m0.a.e0.d.b("recorder", "start error, context is null");
            z();
        } else if (this.f46728d != -1 && !TextUtils.isEmpty(this.f46726b)) {
            if (z) {
                String str = null;
                int i2 = this.f46728d;
                if (i2 == 1) {
                    str = "start fail: recorder is recording";
                } else if (i2 != 0 && i2 != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    g(2003, str);
                    d.a.m0.a.e0.d.b("recorder", str);
                    return;
                }
            }
            if (q) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.f46725a.startRecording();
                if (this.f46725a.getRecordingState() != 3) {
                    f();
                    d.a.m0.a.e0.d.b("recorder", "start error, no real permission");
                    z();
                    return;
                }
                if (z) {
                    E(new C0774a());
                    e(d.a.m0.a.i1.f.b.f46702d, "recorderStart");
                } else {
                    e(d.a.m0.a.i1.f.b.f46704f, "recorderResume");
                }
                h.d.i("").D(Schedulers.io()).k(new c()).o(h.l.b.a.b()).B(new b());
            } catch (IllegalStateException e2) {
                f();
                d.a.m0.a.e0.d.c("recorder", "can't start", e2);
                z();
            }
        } else {
            f();
            d.a.m0.a.e0.d.b("recorder", "start error, wrong state");
            z();
        }
    }

    public void E(d.a.m0.a.i1.f.d.b bVar) {
        if (q) {
            Log.d("AudioRecorderManager", "start timer:" + this.k.f46694a);
        }
        d.a.m0.a.e0.d.g("recorder", "start timer, totalTime:" + this.k.f46694a);
        this.f46732h = bVar;
        Timer timer = new Timer();
        this.f46731g = timer;
        timer.schedule(new d(bVar), this.k.f46694a);
        this.f46733i = System.currentTimeMillis();
    }

    public void F() {
        if (q) {
            Log.d("AudioRecorderManager", "stop record");
        }
        AudioRecord audioRecord = this.f46725a;
        if (audioRecord == null) {
            f();
            d.a.m0.a.e0.d.b("recorder", "none audioRecord");
            z();
            return;
        }
        try {
            audioRecord.stop();
            G();
            this.f46728d = 3;
            h();
            H();
        } catch (IllegalStateException e2) {
            f();
            d.a.m0.a.e0.d.c("recorder", "stop error", e2);
            z();
        }
    }

    public void G() {
        if (q) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        d.a.m0.a.e0.d.g("recorder", "stop timer");
        this.f46732h = null;
        Timer timer = this.f46731g;
        if (timer != null) {
            timer.cancel();
            this.f46731g = null;
        }
    }

    public final void H() {
        d.a.m0.a.i1.f.d.a aVar;
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
        d.a.m0.a.g1.f.V().v(new d.a.m0.a.o0.d.b(str2));
    }

    public final void f() {
        g(2002, "error execute");
    }

    public final void g(int i2, String str) {
        if (this.l != null && !TextUtils.isEmpty(d.a.m0.a.i1.f.b.f46706h)) {
            this.l.d(i2, str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, i2);
            jSONObject.put("errMsg", str);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            d.a.m0.a.g1.f.V().v(new d.a.m0.a.o0.d.b("recorderError", hashMap));
        } catch (JSONException e2) {
            d.a.m0.a.e0.d.c("recorder", "json error", e2);
            z();
        }
    }

    public final void h() {
        long j;
        String J = d.a.m0.a.k2.b.J(this.f46726b, this.f46730f);
        long j2 = -1;
        if (TextUtils.isEmpty(this.f46726b)) {
            j = -1;
        } else {
            j2 = d.a.m0.t.d.t(this.f46726b);
            j = new File(this.f46726b).length();
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
            if (this.l != null && !TextUtils.isEmpty(d.a.m0.a.i1.f.b.f46705g)) {
                this.l.c(d.a.m0.a.i1.f.b.f46705g, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            d.a.m0.a.g1.f.V().v(new d.a.m0.a.o0.d.b("recorderStop", hashMap));
        } catch (JSONException e2) {
            f();
            d.a.m0.a.e0.d.c("recorder", "json error", e2);
            z();
        }
    }

    public d.a.m0.a.i1.f.b i() {
        return this.l;
    }

    public d.a.m0.a.i1.f.a j() {
        return this.k;
    }

    public void l(String str, d.a.m0.a.i1.f.a aVar, Context context, d.a.m0.a.i1.f.b bVar, String str2) {
        int i2 = this.f46728d;
        if (i2 != -1 && i2 != 3) {
            d.a.m0.a.e0.d.b("recorder", "wrong state, can't init");
            return;
        }
        this.k = aVar;
        m(str);
        this.l = bVar;
        int minBufferSize = AudioRecord.getMinBufferSize(aVar.f46697d, aVar.f46696c, 2);
        this.f46727c = minBufferSize;
        if (minBufferSize <= 0) {
            f();
            d.a.m0.a.e0.d.b("recorder", "wrong buffer size");
            z();
            return;
        }
        this.f46725a = new AudioRecord(aVar.f46699f, aVar.f46697d, aVar.f46696c == 1 ? 16 : 12, 2, this.f46727c);
        this.f46728d = 0;
        this.f46729e = context;
        this.f46730f = str2;
        w();
    }

    public final void m(String str) {
        String str2;
        if (TextUtils.equals(this.k.f46695b, "mp3")) {
            str2 = EmotionResourceProvider.EMOTION_SOUND_SUFFIX;
        } else {
            str2 = TextUtils.equals(this.k.f46695b, "pcm") ? ".pcm" : ".aac";
        }
        this.f46726b = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void n() {
        int i2 = this.f46728d;
        if (i2 == 0 || i2 == 1) {
            if (!this.p) {
                this.p = true;
                e(d.a.m0.a.i1.f.b.f46707i, "recorderInterruptionBegin");
            }
            t();
        }
    }

    public void o() {
        if (this.p) {
            this.p = false;
            e(d.a.m0.a.i1.f.b.j, "recorderInterruptionEnd");
        }
    }

    public boolean p(String str) {
        int i2;
        String str2;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.f46728d != 1) {
                str2 = "pause fail: recorder is not recording";
            }
            str2 = null;
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.f46728d != 2) {
                str2 = "resume fail: recorder is not paused";
            }
            str2 = null;
        } else {
            if (TextUtils.equals(str, "/swanAPI/recorder/stop") && (i2 = this.f46728d) != 2 && i2 != 1) {
                str2 = "stop fail: recorder is not started";
            }
            str2 = null;
        }
        if (str2 != null) {
            g(2003, str2);
            d.a.m0.a.e0.d.b("recorder", str2);
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
        if (z && this.f46728d == 1) {
            t();
        }
        this.m = z;
    }

    public void t() {
        if (q) {
            Log.d("AudioRecorderManager", "pause record");
        }
        AudioRecord audioRecord = this.f46725a;
        if (audioRecord == null) {
            f();
            d.a.m0.a.e0.d.b("recorder", "none audio record");
            z();
            return;
        }
        try {
            audioRecord.stop();
            this.f46728d = 2;
            u();
            e(d.a.m0.a.i1.f.b.f46703e, "recorderPause");
        } catch (IllegalStateException e2) {
            f();
            d.a.m0.a.e0.d.c("recorder", "pause error", e2);
            z();
        }
    }

    public void u() {
        if (q) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.j);
        }
        d.a.m0.a.e0.d.g("recorder", "pause timer, lastTime:" + this.j);
        Timer timer = this.f46731g;
        if (timer != null) {
            timer.cancel();
            this.f46731g = null;
        }
        this.j = this.k.f46694a - (System.currentTimeMillis() - this.f46733i);
    }

    public final boolean v(byte[] bArr, d.a.m0.a.i1.f.f.a aVar) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.f46726b);
                if (this.f46728d == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    d.a.m0.t.d.h(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            this.f46728d = 1;
            while (this.f46728d == 1) {
                if (this.f46725a.read(bArr, 0, this.f46727c) >= 0) {
                    byte[] f2 = TextUtils.equals(this.k.f46695b, "pcm") ? bArr : aVar.f(bArr);
                    if (f2 != null && f2.length > 0) {
                        fileOutputStream.write(f2);
                    }
                }
            }
            d.a.m0.t.d.d(fileOutputStream);
            return true;
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            d.a.m0.a.e0.d.c("recorder", "save record error", e);
            if (this.f46728d == 1) {
                this.f46728d = 3;
            }
            d.a.m0.t.d.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a.m0.t.d.d(fileOutputStream2);
            throw th;
        }
    }

    public final void w() {
        Context context = this.f46729e;
        if (context == null) {
            return;
        }
        this.n = (TelephonyManager) context.getSystemService("phone");
        d.a.m0.a.i1.f.d.a aVar = new d.a.m0.a.i1.f.d.a();
        this.o = aVar;
        this.n.listen(aVar, 32);
    }

    public final void z() {
        G();
        this.f46729e = null;
        this.f46728d = -1;
        AudioRecord audioRecord = this.f46725a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f46725a = null;
        }
    }
}
