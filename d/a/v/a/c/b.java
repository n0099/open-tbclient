package d.a.v.a.c;

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
    public byte[] f68362a;

    /* renamed from: b  reason: collision with root package name */
    public long f68363b;

    /* renamed from: c  reason: collision with root package name */
    public int f68364c;

    /* renamed from: d  reason: collision with root package name */
    public String f68365d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68366e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f68367f;

    /* renamed from: g  reason: collision with root package name */
    public long f68368g;

    /* renamed from: h  reason: collision with root package name */
    public long f68369h;

    /* renamed from: i  reason: collision with root package name */
    public long f68370i;
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
        this.f68362a = new byte[0];
        this.f68363b = 15000L;
        this.f68364c = -1;
        this.f68365d = "";
        this.f68366e = false;
        this.f68367f = new byte[0];
        this.f68368g = 60000L;
        this.f68369h = -1L;
        this.f68370i = -1L;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f68369h + ", methodId :" + this.f68370i + ", connectState :" + this.j + ", isNotify :" + this.f68366e + ", bodySize :" + this.f68362a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f68369h + ", methodId :" + this.f68370i + ", errorCode :" + this.f68364c + ", errorMsg :" + this.f68365d + ", intervalMs :" + this.f68368g + ", isNotify :" + this.f68366e + ", bodySize :" + this.f68367f.length;
        }
        return (String) invokeV.objValue;
    }
}
