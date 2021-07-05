package d.f.b.a;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
/* loaded from: classes10.dex */
public interface q {

    /* loaded from: classes10.dex */
    public static abstract class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.f.b.a.q.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // d.f.b.a.q.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // d.f.b.a.q.b
        public void c(w wVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, wVar, obj) == null) {
            }
        }

        @Override // d.f.b.a.q.b
        public void d(ExoPlaybackException exoPlaybackException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, exoPlaybackException) == null) {
            }
        }

        @Override // d.f.b.a.q.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // d.f.b.a.q.b
        public void j(d.f.b.a.d0.t tVar, d.f.b.a.f0.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, tVar, gVar) == null) {
            }
        }

        @Override // d.f.b.a.q.b
        public void k(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) {
            }
        }

        @Override // d.f.b.a.q.b
        public void l(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            }
        }

        @Override // d.f.b.a.q.b
        public void onRepeatModeChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean z);

        void b(boolean z);

        void c(w wVar, Object obj);

        void d(ExoPlaybackException exoPlaybackException);

        void e();

        void j(d.f.b.a.d0.t tVar, d.f.b.a.f0.g gVar);

        void k(p pVar);

        void l(int i2);

        void m(boolean z, int i2);

        void onRepeatModeChanged(int i2);
    }

    void c(@Nullable p pVar);

    p d();

    boolean e();

    void f(b bVar);

    boolean g();

    long getCurrentPosition();

    long getDuration();

    int getPlaybackState();

    int getRepeatMode();

    void h(boolean z);

    void i(b bVar);

    int j();

    int k();

    void l(boolean z);

    w m();

    d.f.b.a.f0.g n();

    int o(int i2);

    void p(int i2, long j);

    long q();

    int r();

    void release();

    void setRepeatMode(int i2);

    void stop();

    long t();

    int u();

    boolean v();
}
