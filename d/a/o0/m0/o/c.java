package d.a.o0.m0.o;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(16)
/* loaded from: classes7.dex */
public class c implements Choreographer.FrameCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f52202e;

    /* renamed from: f  reason: collision with root package name */
    public long f52203f;

    /* renamed from: g  reason: collision with root package name */
    public long f52204g;

    /* renamed from: h  reason: collision with root package name */
    public int f52205h;

    /* renamed from: i  reason: collision with root package name */
    public int f52206i;
    public boolean j;

    public c() {
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
        this.f52202e = 0L;
        this.f52205h = 0;
        this.f52206i = -1;
        this.j = false;
    }

    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            long j2 = this.f52204g;
            if (j2 <= 0) {
                return;
            }
            long j3 = j - j2;
            if (j3 <= 0 || this.f52206i > 0) {
                return;
            }
            this.f52206i = (int) (60 - ((this.f52205h * 1000) / j3));
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52206i : invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f52204g = currentTimeMillis;
            this.f52203f = currentTimeMillis + 1000;
            this.f52202e = 0L;
            this.f52205h = 0;
            this.f52206i = -1;
            this.j = false;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j = true;
            Choreographer.getInstance().removeFrameCallback(this);
            a(System.currentTimeMillis());
            this.f52205h = 0;
            this.f52204g = 0L;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            long j2 = this.f52202e;
            if (j2 != 0) {
                long j3 = (j - j2) / 1000000;
                if (j3 > 16 && j3 < 960) {
                    this.f52205h = (int) (this.f52205h + (j3 / 16));
                }
            }
            this.f52202e = j;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.f52203f && !this.j) {
                Choreographer.getInstance().postFrameCallback(this);
                return;
            }
            a(currentTimeMillis);
            this.f52205h = 0;
            this.f52204g = 0L;
        }
    }
}
