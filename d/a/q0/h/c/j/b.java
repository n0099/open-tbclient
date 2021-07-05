package d.a.q0.h.c.j;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.h.c.f;
import d.a.q0.h.c.j.a;
import java.net.MalformedURLException;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f53152g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f53153h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.h.c.i.b f53154a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f53155b;

    /* renamed from: c  reason: collision with root package name */
    public String f53156c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f53157d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f53158e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAudioPlayer f53159f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f53160e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53160e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53160e.f53159f = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        }
    }

    /* renamed from: d.a.q0.h.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1133b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f53161e;

        public RunnableC1133b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53161e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53161e.f53159f.pauseAll();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f53162e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53162e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53162e.f53159f.resume();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1497574692, "Ld/a/q0/h/c/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1497574692, "Ld/a/q0/h/c/j/b;");
                return;
            }
        }
        f53152g = k.f49133a;
        d.a.q0.a.h2.d.b();
    }

    public b() {
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
        this.f53155b = new HashMap<>();
        this.f53156c = f.g();
        this.f53154a = new d.a.q0.h.c.i.b(this.f53156c);
        c();
        e().post(new a(this));
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (f53153h == null) {
                synchronized (b.class) {
                    if (f53153h == null) {
                        f53153h = new b();
                    }
                }
            }
            return f53153h;
        }
        return (b) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f53157d == null) {
            HandlerThread handlerThread = new HandlerThread("audio_thread");
            this.f53157d = handlerThread;
            handlerThread.start();
            this.f53158e = new Handler(this.f53157d.getLooper());
        }
    }

    public synchronized d.a.q0.h.c.j.c d(String str, boolean z) {
        InterceptResult invokeLZ;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            synchronized (this) {
                if (f53152g) {
                    Log.e("AudioPlayerManager", "create media player src = " + str);
                }
                dVar = new d();
            }
            return dVar;
        }
        return (d.a.q0.h.c.j.c) invokeLZ.objValue;
    }

    public Handler e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f53158e : (Handler) invokeV.objValue;
    }

    public long f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.f53155b.containsKey(str)) {
                return this.f53155b.get(str).longValue();
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                    mediaMetadataRetriever.release();
                    this.f53155b.put(str, Long.valueOf(parseLong));
                    return parseLong;
                } catch (Exception e2) {
                    if (f53152g) {
                        e2.printStackTrace();
                    }
                    mediaMetadataRetriever.release();
                    return 0L;
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        }
        return invokeL.longValue;
    }

    public String g(String str) throws MalformedURLException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.f53156c + f.d(str);
        }
        return (String) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SwanAudioPlayer swanAudioPlayer = this.f53159f;
            if (swanAudioPlayer != null) {
                swanAudioPlayer.isAudioPlayer();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j(String str, d.a.q0.h.c.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) {
            this.f53154a.e(str, aVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f53159f == null) {
            return;
        }
        e().post(new c(this));
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f53159f == null) {
            return;
        }
        e().postDelayed(new RunnableC1133b(this), 50L);
    }

    public void m(JsArrayBuffer jsArrayBuffer, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, jsArrayBuffer, bVar) == null) {
            d.a.q0.h.c.j.a.f().h(jsArrayBuffer, bVar);
        }
    }
}
