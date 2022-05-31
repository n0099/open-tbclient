package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
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
public class xn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile xn2 r;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioRecord a;
    public String b;
    public int c;
    public int d;
    public Context e;
    public String f;
    public Timer g;
    public wn2 h;
    public long i;
    public long j;
    public sn2 k;
    public tn2 l;
    public boolean m;
    public TelephonyManager n;
    public vn2 o;
    public boolean p;

    /* loaded from: classes7.dex */
    public class a implements wn2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn2 a;

        public a(xn2 xn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn2Var;
        }

        @Override // com.repackage.wn2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (xn2.q) {
                    Log.d("AudioRecorderManager", "record --- timeOut");
                }
                hw1.i("recorder", "time out");
                this.a.F();
                this.a.z();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ev9<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn2 a;

        public b(xn2 xn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ev9
        public void call(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool.booleanValue()) {
                return;
            }
            this.a.f();
            hw1.c("recorder", "record error");
            this.a.z();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements iv9<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn2 a;

        public c(xn2 xn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.iv9
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(this.a.C()) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ xn2 b;

        public d(xn2 xn2Var, wn2 wn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn2Var, wn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn2Var;
            this.a = wn2Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wn2 wn2Var = this.a;
                if (wn2Var != null) {
                    wn2Var.a();
                }
                this.b.G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn2 a;

        public e(xn2 xn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn2Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h != null) {
                    this.a.h.a();
                }
                this.a.G();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755165899, "Lcom/repackage/xn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755165899, "Lcom/repackage/xn2;");
                return;
            }
        }
        q = rf1.a;
    }

    public xn2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = -1;
        this.k = new sn2();
        this.p = false;
    }

    public static xn2 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (r == null) {
                synchronized (xn2.class) {
                    if (r == null) {
                        r = new xn2();
                    }
                }
            }
            return r;
        }
        return (xn2) invokeV.objValue;
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
            hw1.i("recorder", "resume timer");
            wn2 wn2Var = this.h;
            if (wn2Var != null) {
                if (this.j <= 0) {
                    wn2Var.a();
                    return;
                }
                Timer timer = new Timer();
                this.g = timer;
                timer.schedule(new e(this), this.j);
                this.i = System.currentTimeMillis();
            }
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte[] bArr = new byte[this.c];
            sn2 sn2Var = this.k;
            yn2 yn2Var = new yn2(sn2Var.b, sn2Var.c, sn2Var.d, sn2Var.e);
            if (this.a == null) {
                return false;
            }
            return v(bArr, yn2Var);
        }
        return invokeV.booleanValue;
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (this.e == null) {
                f();
                hw1.c("recorder", "start error, context is null");
                z();
            } else if (this.d != -1 && !TextUtils.isEmpty(this.b)) {
                if (z) {
                    String str = null;
                    int i = this.d;
                    if (i == 1) {
                        str = "start fail: recorder is recording";
                    } else if (i != 0 && i != 3) {
                        str = "start fail: recorder is paused";
                    }
                    if (str != null) {
                        g(2003, str);
                        hw1.c("recorder", str);
                        return;
                    }
                }
                if (q) {
                    Log.d("AudioRecorderManager", "start record");
                }
                try {
                    this.a.startRecording();
                    if (this.a.getRecordingState() != 3) {
                        f();
                        hw1.c("recorder", "start error, no real permission");
                        z();
                        return;
                    }
                    if (z) {
                        E(new a(this));
                        e(tn2.d, "recorderStart");
                    } else {
                        e(tn2.f, "recorderResume");
                    }
                    qu9.f("").y(Schedulers.io()).h(new c(this)).k(av9.b()).w(new b(this));
                } catch (IllegalStateException e2) {
                    f();
                    hw1.d("recorder", "can't start", e2);
                    z();
                }
            } else {
                f();
                hw1.c("recorder", "start error, wrong state");
                z();
            }
        }
    }

    public void E(wn2 wn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wn2Var) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "start timer:" + this.k.a);
            }
            hw1.i("recorder", "start timer, totalTime:" + this.k.a);
            this.h = wn2Var;
            Timer timer = new Timer();
            this.g = timer;
            timer.schedule(new d(this, wn2Var), this.k.a);
            this.i = System.currentTimeMillis();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (q) {
                Log.d("AudioRecorderManager", "stop record");
            }
            AudioRecord audioRecord = this.a;
            if (audioRecord == null) {
                f();
                hw1.c("recorder", "none audioRecord");
                z();
                return;
            }
            try {
                audioRecord.stop();
                G();
                this.d = 3;
                h();
                H();
            } catch (IllegalStateException e2) {
                f();
                hw1.d("recorder", "stop error", e2);
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
            hw1.i("recorder", "stop timer");
            this.h = null;
            Timer timer = this.g;
            if (timer != null) {
                timer.cancel();
                this.g = null;
            }
        }
    }

    public final void H() {
        TelephonyManager telephonyManager;
        vn2 vn2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (telephonyManager = this.n) == null || (vn2Var = this.o) == null) {
            return;
        }
        telephonyManager.listen(vn2Var, 0);
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
            uk2.U().u(new i92(str2));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g(2002, "error execute");
        }
    }

    public final void g(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            if (this.l != null && !TextUtils.isEmpty(tn2.h)) {
                this.l.d(i, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(StatConstants.KEY_EXT_ERR_CODE, i);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                uk2.U().u(new i92("recorderError", hashMap));
            } catch (JSONException e2) {
                hw1.d("recorder", "json error", e2);
                z();
            }
        }
    }

    public final void h() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String J = p63.J(this.b, this.f);
            long j2 = -1;
            if (TextUtils.isEmpty(this.b)) {
                j = -1;
            } else {
                j2 = kf4.u(this.b);
                j = new File(this.b).length();
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
                if (this.l != null && !TextUtils.isEmpty(tn2.g)) {
                    this.l.c(tn2.g, jSONObject);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                uk2.U().u(new i92("recorderStop", hashMap));
            } catch (JSONException e2) {
                f();
                hw1.d("recorder", "json error", e2);
                z();
            }
        }
    }

    public tn2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (tn2) invokeV.objValue;
    }

    public sn2 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (sn2) invokeV.objValue;
    }

    public void l(String str, sn2 sn2Var, Context context, tn2 tn2Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048590, this, str, sn2Var, context, tn2Var, str2) == null) {
            int i = this.d;
            if (i != -1 && i != 3) {
                hw1.c("recorder", "wrong state, can't init");
                return;
            }
            this.k = sn2Var;
            m(str);
            this.l = tn2Var;
            int minBufferSize = AudioRecord.getMinBufferSize(sn2Var.d, sn2Var.c, 2);
            this.c = minBufferSize;
            if (minBufferSize <= 0) {
                f();
                hw1.c("recorder", "wrong buffer size");
                z();
                return;
            }
            this.a = new AudioRecord(sn2Var.f, sn2Var.d, sn2Var.c == 1 ? 16 : 12, 2, this.c);
            this.d = 0;
            this.e = context;
            this.f = str2;
            w();
        }
    }

    public final void m(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (TextUtils.equals(this.k.b, "mp3")) {
                str2 = ".mp3";
            } else {
                str2 = TextUtils.equals(this.k.b, "pcm") ? ".pcm" : DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
            }
            this.b = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i = this.d;
            if (i == 0 || i == 1) {
                if (!this.p) {
                    this.p = true;
                    e(tn2.i, "recorderInterruptionBegin");
                }
                t();
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.p) {
            this.p = false;
            e(tn2.j, "recorderInterruptionEnd");
        }
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
                if (this.d != 1) {
                    str2 = "pause fail: recorder is not recording";
                }
                str2 = null;
            } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
                if (this.d != 2) {
                    str2 = "resume fail: recorder is not paused";
                }
                str2 = null;
            } else {
                if (TextUtils.equals(str, "/swanAPI/recorder/stop") && (i = this.d) != 2 && i != 1) {
                    str2 = "stop fail: recorder is not started";
                }
                str2 = null;
            }
            if (str2 != null) {
                g(2003, str2);
                hw1.c("recorder", str2);
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
            if (z && this.d == 1) {
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
            AudioRecord audioRecord = this.a;
            if (audioRecord == null) {
                f();
                hw1.c("recorder", "none audio record");
                z();
                return;
            }
            try {
                audioRecord.stop();
                this.d = 2;
                u();
                e(tn2.e, "recorderPause");
            } catch (IllegalStateException e2) {
                f();
                hw1.d("recorder", "pause error", e2);
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
            hw1.i("recorder", "pause timer, lastTime:" + this.j);
            Timer timer = this.g;
            if (timer != null) {
                timer.cancel();
                this.g = null;
            }
            this.j = this.k.a - (System.currentTimeMillis() - this.i);
        }
    }

    public final boolean v(byte[] bArr, yn2 yn2Var) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, bArr, yn2Var)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    File file = new File(this.b);
                    if (this.d == 0) {
                        if (file.exists()) {
                            file.delete();
                        }
                        kf4.h(file);
                    }
                    fileOutputStream = new FileOutputStream(file, true);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.d = 1;
                while (this.d == 1) {
                    if (this.a.read(bArr, 0, this.c) >= 0) {
                        byte[] f = TextUtils.equals(this.k.b, "pcm") ? bArr : yn2Var.f(bArr);
                        if (f != null && f.length > 0) {
                            fileOutputStream.write(f);
                        }
                    }
                }
                kf4.d(fileOutputStream);
                return true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                hw1.d("recorder", "save record error", e);
                if (this.d == 1) {
                    this.d = 3;
                }
                kf4.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                kf4.d(fileOutputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void w() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (context = this.e) == null) {
            return;
        }
        this.n = (TelephonyManager) context.getSystemService("phone");
        vn2 vn2Var = new vn2();
        this.o = vn2Var;
        this.n.listen(vn2Var, 32);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            G();
            this.e = null;
            this.d = -1;
            AudioRecord audioRecord = this.a;
            if (audioRecord != null) {
                audioRecord.release();
                this.a = null;
            }
        }
    }
}
