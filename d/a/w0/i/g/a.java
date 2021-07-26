package d.a.w0.i.g;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.w0.i.c;
import d.a.w0.i.e;
import java.io.IOException;
/* loaded from: classes8.dex */
public class a extends c implements d.a.w0.l.d.j.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b B;
    public String C;
    public Thread D;
    public long E;
    public long F;

    /* renamed from: d.a.w0.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1934a extends d.a.w0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68590e;

        public C1934a(a aVar) {
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
            this.f68590e = aVar;
        }

        @Override // d.a.w0.l.d.j.c.a, d.a.w0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f68590e.A == null || this.f68590e.p) {
                return;
            }
            this.f68590e.A.onExceptionThrown(str);
        }

        @Override // d.a.w0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f68590e.o = true;
                if (this.f68590e.A == null || this.f68590e.p) {
                    return;
                }
                this.f68590e.A.onFinishedWriting(z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, String str2, int[] iArr) throws Exception {
        super(0, str, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, iArr};
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
        this.C = str2;
        this.B.e(str2);
        z(this);
    }

    @Override // d.a.w0.i.c
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.C();
            Thread thread = this.D;
            if (thread == null || !thread.isAlive()) {
                Thread thread2 = new Thread(this);
                this.D = thread2;
                thread2.start();
            }
            super.C();
        }
    }

    public void L(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            long j2 = j * 1000;
            this.F = j2;
            if (this.f68579i != null) {
                if (j2 > this.f68579i.getDuration()) {
                    j2 = this.f68579i.getDuration();
                }
                synchronized (this.f68577g) {
                    this.f68579i.h(j2);
                }
            }
        }
    }

    public void M(d.a.w0.l.d.j.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.A = aVar;
            this.B.d(new C1934a(this));
        }
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.p = true;
            this.o = true;
            Thread thread = this.D;
            if (thread != null) {
                try {
                    thread.interrupt();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.D = null;
            }
            try {
                this.B.g();
            } catch (Exception e3) {
                d.a.w0.t.c.e("VideoMuxer", "cancel finishWriting error:" + e3.getMessage());
            }
        }
    }

    @Override // d.a.w0.i.c
    public e l() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b bVar = new b(this.C, i(), f());
            this.B = bVar;
            return bVar;
        }
        return (e) invokeV.objValue;
    }

    @Override // d.a.w0.l.d.j.b
    public void onCancel() {
        d.a.w0.l.d.j.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.A) == null) {
            return;
        }
        aVar.onCancel();
    }

    @Override // d.a.w0.l.d.j.b
    public void onExceptionThrown(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.A == null || this.p) {
            return;
        }
        this.A.onExceptionThrown(str);
    }

    @Override // d.a.w0.l.d.j.b
    public void onProgressChanged(int i2, double d2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j)}) == null) || this.A == null || this.p) {
            return;
        }
        this.A.onProgressChanged(i2, d2, j);
    }

    @Override // d.a.w0.l.d.j.b
    public void onTrackEnd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            try {
                this.B.b();
            } catch (Exception e2) {
                d.a.w0.t.c.e("VideoMuxer", "onTrackEnd finishWriting error:" + e2.getMessage());
            }
        }
    }

    @Override // d.a.w0.i.c
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // d.a.w0.i.c
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // d.a.w0.i.c
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.D != null) {
                this.D = null;
            }
            try {
                this.B.b();
            } catch (Exception e2) {
                d.a.w0.t.c.e("VideoMuxer", "onStop finishWriting error:" + e2.getMessage());
            }
        }
    }

    @Override // d.a.w0.i.c
    public void w(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            long j2 = j * 1000;
            if (j2 < 0) {
                j2 = 0;
            }
            this.E = j2;
            if (this.f68579i != null) {
                if (j2 > this.f68579i.getDuration()) {
                    j2 = this.f68579i.getDuration();
                }
                synchronized (this.f68577g) {
                    this.f68579i.seek(j2);
                }
            }
        }
    }

    @Override // d.a.w0.i.c
    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.o) {
            return;
        }
        long currentPosition = this.f68579i.getCurrentPosition();
        long j = this.E;
        long j2 = currentPosition - j;
        long j3 = this.F;
        long duration = j3 > 0 ? j3 - j : this.f68579i.getDuration();
        double d2 = duration == 0 ? 0.0d : j2 / duration;
        double d3 = d2 >= 0.0d ? d2 : 0.0d;
        onProgressChanged(this.r, d3 > 1.0d ? 1.0d : d3, j2);
    }
}
