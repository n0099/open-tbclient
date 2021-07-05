package d.a.r0.r.f0.r;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f55698a;

    /* renamed from: b  reason: collision with root package name */
    public int f55699b;

    /* renamed from: c  reason: collision with root package name */
    public String f55700c;

    /* renamed from: d  reason: collision with root package name */
    public String f55701d;

    /* renamed from: e  reason: collision with root package name */
    public String f55702e;

    /* renamed from: f  reason: collision with root package name */
    public String f55703f;

    /* renamed from: g  reason: collision with root package name */
    public String f55704g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55705h;

    /* renamed from: i  reason: collision with root package name */
    public String f55706i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1602134448, "Ld/a/r0/r/f0/r/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1602134448, "Ld/a/r0/r/f0/r/d;");
        }
    }

    public d() {
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

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, urlParserResIdl) == null) || urlParserResIdl == null || (dataRes = urlParserResIdl.data) == null) {
            return;
        }
        this.f55698a = dataRes.status.intValue();
        this.f55699b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f55701d = dataRes2.image;
        this.f55702e = dataRes2.title;
        this.f55703f = dataRes2.link_from;
        this.f55704g = dataRes2.price_txt;
        this.f55705h = dataRes2.is_recognize.intValue() == 1;
        this.f55706i = urlParserResIdl.data.description;
    }
}
