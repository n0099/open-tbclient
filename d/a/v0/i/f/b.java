package d.a.v0.i.f;

import android.media.AudioTrack;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.v0.i.c;
import d.a.v0.i.e;
import java.io.IOException;
/* loaded from: classes8.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a B;
    public Thread C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, int[] iArr) throws Exception {
        super(0, str, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (int[]) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.v0.i.c
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Thread thread = this.C;
            if (thread == null || !thread.isAlive()) {
                Thread thread2 = new Thread(this);
                this.C = thread2;
                thread2.start();
            }
            super.C();
        }
    }

    public final void E() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f() == 1) {
                i2 = 4;
            } else {
                f();
                i2 = 12;
            }
            int i3 = this.u;
            if (i3 != 1 && i3 != 2) {
                this.u = 2;
            }
            this.B = new a(3, i(), i2, e() == 2 ? 2 : 3, AudioTrack.getMinBufferSize(i(), i2, e() == 2 ? 2 : 3), 1);
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a aVar = this.B;
            return aVar != null && aVar.getState() == 1;
        }
        return invokeV.booleanValue;
    }

    public final void G(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (j < 0) {
                j = 0;
            }
            if (this.f67901i != null && j > this.f67901i.getDuration()) {
                j = this.f67901i.getDuration();
            }
            if (z) {
                int playState = F() ? this.B.getPlayState() : 2;
                if (playState == 2) {
                    pause();
                }
                synchronized (this.f67898f) {
                    if (F()) {
                        this.B.flush();
                    }
                    this.f67900h = 0L;
                }
                c();
                b();
                if (playState == 3) {
                    C();
                }
            }
            synchronized (this.f67899g) {
                if (this.f67901i != null) {
                    this.f67901i.seek(j);
                }
            }
        }
    }

    public void H(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            synchronized (this.f67898f) {
                if (F()) {
                    this.B.setStereoVolume(f2, f3);
                }
            }
        }
    }

    @Override // d.a.v0.i.c
    public e l() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            E();
            return this.B;
        }
        return (e) invokeV.objValue;
    }

    @Override // d.a.v0.i.c
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.f67898f) {
                if (F() && this.B.getPlayState() != 2) {
                    this.B.pause();
                }
            }
        }
    }

    @Override // d.a.v0.i.c
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.f67898f) {
                if (F() && this.B.getPlayState() != 3) {
                    this.B.play();
                }
            }
        }
    }

    @Override // d.a.v0.i.c
    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.C == null) {
            return;
        }
        this.C = null;
    }

    @Override // d.a.v0.i.c
    public void w(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            G(j * 1000, true);
        }
    }
}
