package d.a.o0.a.i1.f.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.RouterCallback;
import d.a.o0.a.k;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f46077a;

    /* renamed from: b  reason: collision with root package name */
    public String f46078b;

    /* renamed from: c  reason: collision with root package name */
    public int f46079c;

    /* renamed from: d  reason: collision with root package name */
    public int f46080d;

    /* renamed from: e  reason: collision with root package name */
    public Context f46081e;

    /* renamed from: f  reason: collision with root package name */
    public String f46082f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f46083g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.a.i1.f.d.b f46084h;

    /* renamed from: i  reason: collision with root package name */
    public long f46085i;
    public long j;
    public d.a.o0.a.i1.f.a k;
    public d.a.o0.a.i1.f.b l;
    public boolean m;
    public TelephonyManager n;
    public d.a.o0.a.i1.f.d.a o;
    public boolean p;

    /* renamed from: d.a.o0.a.i1.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0792a implements d.a.o0.a.i1.f.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f46086a;

        public C0792a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46086a = aVar;
        }

        @Override // d.a.o0.a.i1.f.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a.q) {
                    Log.d("AudioRecorderManager", "record --- timeOut");
                }
                d.a.o0.a.e0.d.g("recorder", "time out");
                this.f46086a.F();
                this.f46086a.z();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements h.n.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46087e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46087e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool.booleanValue()) {
                return;
            }
            this.f46087e.f();
            d.a.o0.a.e0.d.b("recorder", "record error");
            this.f46087e.z();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46088e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46088e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(this.f46088e.C()) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.i1.f.d.b f46089e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f46090f;

        public d(a aVar, d.a.o0.a.i1.f.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46090f = aVar;
            this.f46089e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.i1.f.d.b bVar = this.f46089e;
                if (bVar != null) {
                    bVar.a();
                }
                this.f46090f.G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46091e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46091e = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f46091e.f46084h != null) {
                    this.f46091e.f46084h.a();
                }
                this.f46091e.G();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(219051101, "Ld/a/o0/a/i1/f/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(219051101, "Ld/a/o0/a/i1/f/e/a;");
                return;
            }
        }
        q = k.f46335a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46080d = -1;
        this.k = new d.a.o0.a.i1.f.a();
        this.p = false;
    }

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (r == null) {
                synchronized (a.class) {
                    if (r == null) {
                        r = new a();
                    }
                }
            }
            return r;
        }
        return (a) invokeV.objValue;
    }

    public static void r(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65543, null, z) == null) || r == null) {
            return;
        }
        r.s(z);
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || r == null) {
            return;
        }
        r.z();
        r.H();
        r.o();
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            x();
            r = null;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "resume record");
            }
            D(false);
            B();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "resume timer");
            }
            d.a.o0.a.e0.d.g("recorder", "resume timer");
            d.a.o0.a.i1.f.d.b bVar = this.f46084h;
            if (bVar != null) {
                if (this.j <= 0) {
                    bVar.a();
                    return;
                }
                Timer timer = new Timer();
                this.f46083g = timer;
                timer.schedule(new e(this), this.j);
                this.f46085i = System.currentTimeMillis();
            }
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte[] bArr = new byte[this.f46079c];
            d.a.o0.a.i1.f.a aVar = this.k;
            d.a.o0.a.i1.f.f.a aVar2 = new d.a.o0.a.i1.f.f.a(aVar.f46047b, aVar.f46048c, aVar.f46049d, aVar.f46050e);
            if (this.f46077a == null) {
                return false;
            }
            return v(bArr, aVar2);
        }
        return invokeV.booleanValue;
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (this.f46081e == null) {
                f();
                d.a.o0.a.e0.d.b("recorder", "start error, context is null");
                z();
            } else if (this.f46080d != -1 && !TextUtils.isEmpty(this.f46078b)) {
                if (z) {
                    String str = null;
                    int i2 = this.f46080d;
                    if (i2 == 1) {
                        str = "start fail: recorder is recording";
                    } else if (i2 != 0 && i2 != 3) {
                        str = "start fail: recorder is paused";
                    }
                    if (str != null) {
                        g(2003, str);
                        d.a.o0.a.e0.d.b("recorder", str);
                        return;
                    }
                }
                if (q) {
                    Log.d("AudioRecorderManager", "start record");
                }
                try {
                    this.f46077a.startRecording();
                    if (this.f46077a.getRecordingState() != 3) {
                        f();
                        d.a.o0.a.e0.d.b("recorder", "start error, no real permission");
                        z();
                        return;
                    }
                    if (z) {
                        E(new C0792a(this));
                        e(d.a.o0.a.i1.f.b.f46054d, "recorderStart");
                    } else {
                        e(d.a.o0.a.i1.f.b.f46056f, "recorderResume");
                    }
                    h.d.i("").D(Schedulers.io()).k(new c(this)).o(h.l.b.a.b()).B(new b(this));
                } catch (IllegalStateException e2) {
                    f();
                    d.a.o0.a.e0.d.c("recorder", "can't start", e2);
                    z();
                }
            } else {
                f();
                d.a.o0.a.e0.d.b("recorder", "start error, wrong state");
                z();
            }
        }
    }

    public void E(d.a.o0.a.i1.f.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "start timer:" + this.k.f46046a);
            }
            d.a.o0.a.e0.d.g("recorder", "start timer, totalTime:" + this.k.f46046a);
            this.f46084h = bVar;
            Timer timer = new Timer();
            this.f46083g = timer;
            timer.schedule(new d(this, bVar), this.k.f46046a);
            this.f46085i = System.currentTimeMillis();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "stop record");
            }
            AudioRecord audioRecord = this.f46077a;
            if (audioRecord == null) {
                f();
                d.a.o0.a.e0.d.b("recorder", "none audioRecord");
                z();
                return;
            }
            try {
                audioRecord.stop();
                G();
                this.f46080d = 3;
                h();
                H();
            } catch (IllegalStateException e2) {
                f();
                d.a.o0.a.e0.d.c("recorder", "stop error", e2);
                z();
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "stop timer");
            }
            d.a.o0.a.e0.d.g("recorder", "stop timer");
            this.f46084h = null;
            Timer timer = this.f46083g;
            if (timer != null) {
                timer.cancel();
                this.f46083g = null;
            }
        }
    }

    public final void H() {
        TelephonyManager telephonyManager;
        d.a.o0.a.i1.f.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (telephonyManager = this.n) == null || (aVar = this.o) == null) {
            return;
        }
        telephonyManager.listen(aVar, 0);
        this.n = null;
        this.o = null;
    }

    public final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
            }
            if (this.l != null && !TextUtils.isEmpty(str)) {
                this.l.b(str);
                return;
            }
            d.a.o0.a.g1.f.V().v(new d.a.o0.a.o0.d.b(str2));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g(2002, "error execute");
        }
    }

    public final void g(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            if (this.l != null && !TextUtils.isEmpty(d.a.o0.a.i1.f.b.f46058h)) {
                this.l.d(i2, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(RouterCallback.KEY_ERROR_CODE, i2);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                d.a.o0.a.g1.f.V().v(new d.a.o0.a.o0.d.b("recorderError", hashMap));
            } catch (JSONException e2) {
                d.a.o0.a.e0.d.c("recorder", "json error", e2);
                z();
            }
        }
    }

    public final void h() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String J = d.a.o0.a.k2.b.J(this.f46078b, this.f46082f);
            long j2 = -1;
            if (TextUtils.isEmpty(this.f46078b)) {
                j = -1;
            } else {
                j2 = d.a.o0.t.d.t(this.f46078b);
                j = new File(this.f46078b).length();
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
                if (this.l != null && !TextUtils.isEmpty(d.a.o0.a.i1.f.b.f46057g)) {
                    this.l.c(d.a.o0.a.i1.f.b.f46057g, jSONObject);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                d.a.o0.a.g1.f.V().v(new d.a.o0.a.o0.d.b("recorderStop", hashMap));
            } catch (JSONException e2) {
                f();
                d.a.o0.a.e0.d.c("recorder", "json error", e2);
                z();
            }
        }
    }

    public d.a.o0.a.i1.f.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (d.a.o0.a.i1.f.b) invokeV.objValue;
    }

    public d.a.o0.a.i1.f.a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (d.a.o0.a.i1.f.a) invokeV.objValue;
    }

    public void l(String str, d.a.o0.a.i1.f.a aVar, Context context, d.a.o0.a.i1.f.b bVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048590, this, str, aVar, context, bVar, str2) == null) {
            int i2 = this.f46080d;
            if (i2 != -1 && i2 != 3) {
                d.a.o0.a.e0.d.b("recorder", "wrong state, can't init");
                return;
            }
            this.k = aVar;
            m(str);
            this.l = bVar;
            int minBufferSize = AudioRecord.getMinBufferSize(aVar.f46049d, aVar.f46048c, 2);
            this.f46079c = minBufferSize;
            if (minBufferSize <= 0) {
                f();
                d.a.o0.a.e0.d.b("recorder", "wrong buffer size");
                z();
                return;
            }
            this.f46077a = new AudioRecord(aVar.f46051f, aVar.f46049d, aVar.f46048c == 1 ? 16 : 12, 2, this.f46079c);
            this.f46080d = 0;
            this.f46081e = context;
            this.f46082f = str2;
            w();
        }
    }

    public final void m(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (TextUtils.equals(this.k.f46047b, "mp3")) {
                str2 = EmotionResourceProvider.EMOTION_SOUND_SUFFIX;
            } else {
                str2 = TextUtils.equals(this.k.f46047b, "pcm") ? ".pcm" : ".aac";
            }
            this.f46078b = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i2 = this.f46080d;
            if (i2 == 0 || i2 == 1) {
                if (!this.p) {
                    this.p = true;
                    e(d.a.o0.a.i1.f.b.f46059i, "recorderInterruptionBegin");
                }
                t();
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.p) {
            this.p = false;
            e(d.a.o0.a.i1.f.b.j, "recorderInterruptionEnd");
        }
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        int i2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
                if (this.f46080d != 1) {
                    str2 = "pause fail: recorder is not recording";
                }
                str2 = null;
            } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
                if (this.f46080d != 2) {
                    str2 = "resume fail: recorder is not paused";
                }
                str2 = null;
            } else {
                if (TextUtils.equals(str, "/swanAPI/recorder/stop") && (i2 = this.f46080d) != 2 && i2 != 1) {
                    str2 = "stop fail: recorder is not started";
                }
                str2 = null;
            }
            if (str2 != null) {
                g(2003, str2);
                d.a.o0.a.e0.d.b("recorder", str2);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (this.m) {
                return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (z && this.f46080d == 1) {
                t();
            }
            this.m = z;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "pause record");
            }
            AudioRecord audioRecord = this.f46077a;
            if (audioRecord == null) {
                f();
                d.a.o0.a.e0.d.b("recorder", "none audio record");
                z();
                return;
            }
            try {
                audioRecord.stop();
                this.f46080d = 2;
                u();
                e(d.a.o0.a.i1.f.b.f46055e, "recorderPause");
            } catch (IllegalStateException e2) {
                f();
                d.a.o0.a.e0.d.c("recorder", "pause error", e2);
                z();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.j);
            }
            d.a.o0.a.e0.d.g("recorder", "pause timer, lastTime:" + this.j);
            Timer timer = this.f46083g;
            if (timer != null) {
                timer.cancel();
                this.f46083g = null;
            }
            this.j = this.k.f46046a - (System.currentTimeMillis() - this.f46085i);
        }
    }

    public final boolean v(byte[] bArr, d.a.o0.a.i1.f.f.a aVar) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, bArr, aVar)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    File file = new File(this.f46078b);
                    if (this.f46080d == 0) {
                        if (file.exists()) {
                            file.delete();
                        }
                        d.a.o0.t.d.h(file);
                    }
                    fileOutputStream = new FileOutputStream(file, true);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f46080d = 1;
                while (this.f46080d == 1) {
                    if (this.f46077a.read(bArr, 0, this.f46079c) >= 0) {
                        byte[] f2 = TextUtils.equals(this.k.f46047b, "pcm") ? bArr : aVar.f(bArr);
                        if (f2 != null && f2.length > 0) {
                            fileOutputStream.write(f2);
                        }
                    }
                }
                d.a.o0.t.d.d(fileOutputStream);
                return true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                d.a.o0.a.e0.d.c("recorder", "save record error", e);
                if (this.f46080d == 1) {
                    this.f46080d = 3;
                }
                d.a.o0.t.d.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                d.a.o0.t.d.d(fileOutputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void w() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (context = this.f46081e) == null) {
            return;
        }
        this.n = (TelephonyManager) context.getSystemService("phone");
        d.a.o0.a.i1.f.d.a aVar = new d.a.o0.a.i1.f.d.a();
        this.o = aVar;
        this.n.listen(aVar, 32);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            G();
            this.f46081e = null;
            this.f46080d = -1;
            AudioRecord audioRecord = this.f46077a;
            if (audioRecord != null) {
                audioRecord.release();
                this.f46077a = null;
            }
        }
    }
}
