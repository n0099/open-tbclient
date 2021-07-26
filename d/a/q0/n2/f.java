package d.a.q0.n2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f61376a;

    /* renamed from: b  reason: collision with root package name */
    public int f61377b;

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f61378c;

    /* renamed from: d  reason: collision with root package name */
    public b f61379d;

    /* renamed from: e  reason: collision with root package name */
    public d f61380e;

    /* renamed from: f  reason: collision with root package name */
    public c f61381f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f61382g;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f61383a;

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
            this.f61383a = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message != null && message.what == 1 && this.f61383a.f61378c != null && this.f61383a.f61378c.isPlaying()) {
                int currentPosition = this.f61383a.f61378c.getCurrentPosition();
                int duration = this.f61383a.f61378c.getDuration();
                if (currentPosition < this.f61383a.f61377b) {
                    if (this.f61383a.f61379d != null) {
                        this.f61383a.f61379d.a();
                    }
                } else if (currentPosition == this.f61383a.f61377b && this.f61383a.f61380e != null) {
                    this.f61383a.f61380e.a();
                }
                if (this.f61383a.f61381f != null) {
                    this.f61383a.f61381f.a(duration, currentPosition);
                }
                this.f61383a.f61377b = currentPosition;
                this.f61383a.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(int i2, int i3);
    }

    /* loaded from: classes8.dex */
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
        this.f61376a = 1000;
        this.f61377b = 0;
        this.f61382g = new a(this, Looper.getMainLooper());
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f61382g.removeMessages(1);
            Handler handler = this.f61382g;
            handler.sendMessageDelayed(handler.obtainMessage(1), this.f61376a);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f61379d = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f61381f = cVar;
        }
    }

    public void k(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f61380e = dVar;
        }
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mediaPlayerControl) == null) {
            this.f61378c = mediaPlayerControl;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f61377b = 0;
            h();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f61382g.removeMessages(1);
        }
    }
}
