package d.a.u.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f67684a;

    /* renamed from: b  reason: collision with root package name */
    public long f67685b;

    /* renamed from: c  reason: collision with root package name */
    public int f67686c;

    /* renamed from: d  reason: collision with root package name */
    public String f67687d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67688e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f67689f;

    /* renamed from: g  reason: collision with root package name */
    public long f67690g;

    /* renamed from: h  reason: collision with root package name */
    public long f67691h;

    /* renamed from: i  reason: collision with root package name */
    public long f67692i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public long n;
    public boolean o;

    public b() {
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
        this.f67684a = new byte[0];
        this.f67685b = 15000L;
        this.f67686c = -1;
        this.f67687d = "";
        this.f67688e = false;
        this.f67689f = new byte[0];
        this.f67690g = 60000L;
        this.f67691h = -1L;
        this.f67692i = -1L;
        this.j = -1;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = -1L;
        this.o = false;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.m) {
                return "Request correlationId :" + this.n + ", serviceId :" + this.f67691h + ", methodId :" + this.f67692i + ", connectState :" + this.j + ", isNotify :" + this.f67688e + ", bodySize :" + this.f67684a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f67691h + ", methodId :" + this.f67692i + ", errorCode :" + this.f67686c + ", errorMsg :" + this.f67687d + ", intervalMs :" + this.f67690g + ", isNotify :" + this.f67688e + ", bodySize :" + this.f67689f.length;
        }
        return (String) invokeV.objValue;
    }
}
