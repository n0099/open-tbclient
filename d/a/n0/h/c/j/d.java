package d.a.n0.h.c.j;

import android.media.MediaPlayer;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class d implements d.a.n0.h.c.j.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SwanAudioPlayer f49861e;

    /* renamed from: f  reason: collision with root package name */
    public String f49862f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49863g;

    /* renamed from: h  reason: collision with root package name */
    public float f49864h;

    /* renamed from: i  reason: collision with root package name */
    public int f49865i;
    public MediaPlayer.OnPreparedListener j;
    public MediaPlayer.OnCompletionListener k;
    public MediaPlayer.OnErrorListener l;
    public MediaPlayer.OnSeekCompleteListener m;
    public d.a.n0.l.a.c n;
    public Handler o;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f49866e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49866e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || 2 == this.f49866e.f49861e.getState(this.f49866e.f49865i)) {
                return;
            }
            this.f49866e.f49861e.play(this.f49866e.f49865i, this.f49866e.f49864h, this.f49866e.f49863g);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f49867e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49867e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49867e.f49861e.pause(this.f49867e.f49865i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f49868e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f49869f;

        public c(d dVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49869f = dVar;
            this.f49868e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49869f.f49861e.seek(this.f49869f.f49865i, (int) this.f49868e);
            }
        }
    }

    /* renamed from: d.a.n0.h.c.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1083d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f49870e;

        public RunnableC1083d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49870e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49870e.f49861e.stop(this.f49870e.f49865i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49871e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f49872f;

        /* loaded from: classes7.dex */
        public class a implements MediaPlayer.OnPreparedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f49873e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49873e = eVar;
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) || this.f49873e.f49872f.j == null) {
                    return;
                }
                this.f49873e.f49872f.j.onPrepared(mediaPlayer);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements MediaPlayer.OnCompletionListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f49874e;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49874e = eVar;
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) || this.f49874e.f49872f.k == null) {
                    return;
                }
                this.f49874e.f49872f.k.onCompletion(mediaPlayer);
            }
        }

        /* loaded from: classes7.dex */
        public class c implements MediaPlayer.OnSeekCompleteListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f49875e;

            public c(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49875e = eVar;
            }

            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) || this.f49875e.f49872f.m == null) {
                    return;
                }
                this.f49875e.f49872f.m.onSeekComplete(mediaPlayer);
            }
        }

        /* renamed from: d.a.n0.h.c.j.d$e$d  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1084d implements MediaPlayer.OnErrorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f49876e;

            public C1084d(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49876e = eVar;
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (this.f49876e.f49872f.l != null) {
                        return this.f49876e.f49872f.l.onError(mediaPlayer, i2, i3);
                    }
                    return false;
                }
                return invokeLII.booleanValue;
            }
        }

        /* renamed from: d.a.n0.h.c.j.d$e$e  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1085e implements d.a.n0.l.a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f49877a;

            public C1085e(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49877a = eVar;
            }

            @Override // d.a.n0.l.a.c
            public void onPause() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49877a.f49872f.n == null) {
                    return;
                }
                this.f49877a.f49872f.n.onPause();
            }
        }

        public e(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49872f = dVar;
            this.f49871e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49872f.f49862f = this.f49871e;
                File file = new File(this.f49871e);
                if (!file.exists() || file.isDirectory()) {
                    return;
                }
                d dVar = this.f49872f;
                dVar.f49865i = dVar.f49861e.setDataSource(this.f49871e, (int) file.length());
                this.f49872f.f49861e.setOnPreparedListener(this.f49872f.f49865i, new a(this));
                this.f49872f.f49861e.setOnCompletionListener(this.f49872f.f49865i, new b(this));
                this.f49872f.f49861e.setOnSeekCompleteListener(this.f49872f.f49865i, new c(this));
                this.f49872f.f49861e.setOnErrorListener(this.f49872f.f49865i, new C1084d(this));
                this.f49872f.f49861e.setOnPauseListener(this.f49872f.f49865i, new C1085e(this));
                this.f49872f.f49861e.prepare(this.f49872f.f49865i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49878e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f49879f;

        public f(d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49879f = dVar;
            this.f49878e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (2 == this.f49879f.f49861e.getState(this.f49879f.f49865i)) {
                    this.f49879f.f49861e.setLoop(this.f49879f.f49865i, this.f49878e);
                }
                this.f49879f.f49863g = this.f49878e;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f49880e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f49881f;

        public g(d dVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49881f = dVar;
            this.f49880e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (2 == this.f49881f.f49861e.getState(this.f49881f.f49865i)) {
                    this.f49881f.f49861e.setVolume(this.f49881f.f49865i, this.f49880e);
                }
                this.f49881f.f49864h = this.f49880e;
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49861e = SwanAudioPlayer.getInstance();
        this.o = d.a.n0.h.c.j.b.h().e();
    }

    @Override // d.a.n0.h.c.j.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.o.post(new f(this, z));
        }
    }

    @Override // d.a.n0.h.c.j.c
    public void c(String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.o.post(new e(this, str));
        }
    }

    @Override // d.a.n0.h.c.a
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49861e.release(this.f49865i);
            stop();
        }
    }

    @Override // d.a.n0.h.c.j.c
    public void e(d.a.n0.l.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.n = cVar;
        }
    }

    @Override // d.a.n0.h.c.j.c
    public void g(MediaPlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onInfoListener) == null) {
        }
    }

    @Override // d.a.n0.h.c.a
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f49861e.getDuration(this.f49865i) : invokeV.intValue;
    }

    @Override // d.a.n0.h.c.j.c
    public void h(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onSeekCompleteListener) == null) {
            this.m = onSeekCompleteListener;
        }
    }

    @Override // d.a.n0.h.c.j.c
    public void j(MediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onPreparedListener) == null) {
            this.j = onPreparedListener;
        }
    }

    @Override // d.a.n0.h.c.j.c
    public void l(MediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onErrorListener) == null) {
            this.l = onErrorListener;
        }
    }

    @Override // d.a.n0.h.c.j.c
    public void o(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onBufferingUpdateListener) == null) {
        }
    }

    @Override // d.a.n0.h.c.a
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o.post(new b(this));
        }
    }

    @Override // d.a.n0.h.c.a
    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o.post(new a(this));
        }
    }

    @Override // d.a.n0.h.c.j.c
    public void r(MediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onCompletionListener) == null) {
            this.k = onCompletionListener;
        }
    }

    @Override // d.a.n0.h.c.a
    public void seek(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.o.post(new c(this, f2));
        }
    }

    @Override // d.a.n0.h.c.j.c
    public void setVolume(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.o.post(new g(this, f2));
        }
    }

    @Override // d.a.n0.h.c.a
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.o.post(new RunnableC1083d(this));
        }
    }

    @Override // d.a.n0.h.c.j.c
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.h.c.a
    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f49861e.getPosition(this.f49865i) : invokeV.intValue;
    }
}
