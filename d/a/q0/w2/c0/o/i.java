package d.a.q0.w2.c0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f66551a;

    /* renamed from: b  reason: collision with root package name */
    public int f66552b;

    /* renamed from: c  reason: collision with root package name */
    public int f66553c;

    /* renamed from: d  reason: collision with root package name */
    public String f66554d;

    /* renamed from: e  reason: collision with root package name */
    public String f66555e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f66556f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f66557g;

    /* renamed from: h  reason: collision with root package name */
    public int f66558h;

    public i() {
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
        this.f66551a = false;
        this.f66552b = -1;
        this.f66554d = "";
        this.f66555e = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f66552b = httpURLConnection.getResponseCode();
        this.f66554d = httpURLConnection.getContentEncoding();
        httpURLConnection.getContentType();
        this.f66555e = httpURLConnection.getContentLength() + "";
        this.f66556f = httpURLConnection.getHeaderFields();
    }
}
