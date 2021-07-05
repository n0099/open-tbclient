package d.a.s0.n2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f63996a;

    /* renamed from: b  reason: collision with root package name */
    public int f63997b;

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f63998c;

    /* renamed from: d  reason: collision with root package name */
    public b f63999d;

    /* renamed from: e  reason: collision with root package name */
    public d f64000e;

    /* renamed from: f  reason: collision with root package name */
    public c f64001f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f64002g;

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f64003a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64003a = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message != null && message.what == 1 && this.f64003a.f63998c != null && this.f64003a.f63998c.isPlaying()) {
                int currentPosition = this.f64003a.f63998c.getCurrentPosition();
                int duration = this.f64003a.f63998c.getDuration();
                if (currentPosition < this.f64003a.f63997b) {
                    if (this.f64003a.f63999d != null) {
                        this.f64003a.f63999d.a();
                    }
                } else if (currentPosition == this.f64003a.f63997b && this.f64003a.f64000e != null) {
                    this.f64003a.f64000e.a();
                }
                if (this.f64003a.f64001f != null) {
                    this.f64003a.f64001f.a(duration, currentPosition);
                }
                this.f64003a.f63997b = currentPosition;
                this.f64003a.h();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(int i2, int i3);
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a();
    }

    public f() {
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
        this.f63996a = 1000;
        this.f63997b = 0;
        this.f64002g = new a(this, Looper.getMainLooper());
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64002g.removeMessages(1);
            Handler handler = this.f64002g;
            handler.sendMessageDelayed(handler.obtainMessage(1), this.f63996a);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f63999d = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f64001f = cVar;
        }
    }

    public void k(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f64000e = dVar;
        }
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mediaPlayerControl) == null) {
            this.f63998c = mediaPlayerControl;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f63997b = 0;
            h();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f64002g.removeMessages(1);
        }
    }
}
