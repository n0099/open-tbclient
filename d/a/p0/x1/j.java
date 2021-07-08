package d.a.p0.x1;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f66214a;

    /* renamed from: b  reason: collision with root package name */
    public long f66215b;

    /* renamed from: c  reason: collision with root package name */
    public long f66216c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66217d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1556078115, "Ld/a/p0/x1/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1556078115, "Ld/a/p0/x1/j;");
        }
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f66214a = 0L;
            this.f66215b = 0L;
            this.f66216c = 0L;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f66216c = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f66215b = SystemClock.elapsedRealtime();
        }
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, tbCyberVideoView) == null) && this.f66217d) {
            this.f66217d = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f66215b - this.f66214a;
            long j2 = elapsedRealtime - this.f66216c;
            long j3 = j2 + j;
            if ((d.a.c.e.p.j.I() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.R(j, j2, j3);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f66217d = true;
            this.f66214a = SystemClock.elapsedRealtime();
        }
    }
}
