package d.a.o0.r.g0.c;

import android.media.MediaPlayer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.q.h;
import java.io.IOException;
/* loaded from: classes7.dex */
public class e extends MediaPlayer implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static Object f52474d;

    /* renamed from: e  reason: collision with root package name */
    public static e f52475e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f52476a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52477b;

    /* renamed from: c  reason: collision with root package name */
    public int f52478c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1102325758, "Ld/a/o0/r/g0/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1102325758, "Ld/a/o0/r/g0/c/e;");
                return;
            }
        }
        f52474d = new Object();
    }

    public e() {
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
        this.f52476a = false;
        this.f52477b = true;
        this.f52478c = -1;
    }

    public static e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f52475e == null) {
                synchronized (f52474d) {
                    if (f52475e == null) {
                        f52475e = new e();
                    }
                }
            }
            return f52475e;
        }
        return (e) invokeV.objValue;
    }

    @Override // d.a.o0.r.g0.c.c
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52477b) {
            return;
        }
        stop();
        this.f52477b = true;
        this.f52476a = false;
    }

    @Override // d.a.o0.r.g0.c.c
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f52478c = -1;
            if (!this.f52476a) {
                this.f52477b = true;
                reset();
                try {
                    setDataSource(str);
                    j(h.f41492b);
                    try {
                        prepare();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        this.f52478c = 2;
                        return false;
                    } catch (IllegalStateException unused) {
                        this.f52478c = 1;
                        return false;
                    }
                } catch (IOException unused2) {
                    this.f52478c = 2;
                    return false;
                } catch (IllegalArgumentException unused3) {
                    this.f52478c = 0;
                    return false;
                } catch (IllegalStateException unused4) {
                    this.f52478c = 1;
                    return false;
                }
            }
            this.f52476a = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.o0.r.g0.c.c
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52478c : invokeV.intValue;
    }

    @Override // d.a.o0.r.g0.c.c
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52476a : invokeV.booleanValue;
    }

    @Override // d.a.o0.r.g0.c.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pause();
        }
    }

    @Override // d.a.o0.r.g0.c.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            reset();
            this.f52476a = false;
            this.f52477b = true;
            this.f52478c = -1;
        }
    }

    @Override // d.a.o0.r.g0.c.c
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getCurrentPosition() : invokeV.intValue;
    }

    @Override // d.a.o0.r.g0.c.c
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            start();
            this.f52477b = false;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            setAudioStreamType(i2);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            try {
                seekTo(i2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // d.a.o0.r.g0.c.c
    public void seek(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            k(i2);
        }
    }
}
