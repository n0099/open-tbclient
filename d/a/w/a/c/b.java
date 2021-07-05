package d.a.w.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f70791a;

    /* renamed from: b  reason: collision with root package name */
    public long f70792b;

    /* renamed from: c  reason: collision with root package name */
    public int f70793c;

    /* renamed from: d  reason: collision with root package name */
    public String f70794d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f70795e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f70796f;

    /* renamed from: g  reason: collision with root package name */
    public long f70797g;

    /* renamed from: h  reason: collision with root package name */
    public long f70798h;

    /* renamed from: i  reason: collision with root package name */
    public long f70799i;
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
        this.f70791a = new byte[0];
        this.f70792b = 15000L;
        this.f70793c = -1;
        this.f70794d = "";
        this.f70795e = false;
        this.f70796f = new byte[0];
        this.f70797g = 60000L;
        this.f70798h = -1L;
        this.f70799i = -1L;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f70798h + ", methodId :" + this.f70799i + ", connectState :" + this.j + ", isNotify :" + this.f70795e + ", bodySize :" + this.f70791a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f70798h + ", methodId :" + this.f70799i + ", errorCode :" + this.f70793c + ", errorMsg :" + this.f70794d + ", intervalMs :" + this.f70797g + ", isNotify :" + this.f70795e + ", bodySize :" + this.f70796f.length;
        }
        return (String) invokeV.objValue;
    }
}
