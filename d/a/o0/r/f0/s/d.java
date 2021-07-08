package d.a.o0.r.f0.s;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f52404a;

    /* renamed from: b  reason: collision with root package name */
    public int f52405b;

    /* renamed from: c  reason: collision with root package name */
    public String f52406c;

    /* renamed from: d  reason: collision with root package name */
    public String f52407d;

    /* renamed from: e  reason: collision with root package name */
    public String f52408e;

    /* renamed from: f  reason: collision with root package name */
    public String f52409f;

    /* renamed from: g  reason: collision with root package name */
    public String f52410g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52411h;

    /* renamed from: i  reason: collision with root package name */
    public String f52412i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1989352814, "Ld/a/o0/r/f0/s/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1989352814, "Ld/a/o0/r/f0/s/d;");
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
        this.f52404a = dataRes.status.intValue();
        this.f52405b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f52407d = dataRes2.image;
        this.f52408e = dataRes2.title;
        this.f52409f = dataRes2.link_from;
        this.f52410g = dataRes2.price_txt;
        this.f52411h = dataRes2.is_recognize.intValue() == 1;
        this.f52412i = urlParserResIdl.data.description;
    }
}
