package d.a.s0.w2.c0.m;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f69092a;

    /* renamed from: b  reason: collision with root package name */
    public int f69093b;

    /* renamed from: c  reason: collision with root package name */
    public int f69094c;

    /* renamed from: d  reason: collision with root package name */
    public String f69095d;

    /* renamed from: e  reason: collision with root package name */
    public String f69096e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f69097f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f69098g;

    /* renamed from: h  reason: collision with root package name */
    public int f69099h;

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
        this.f69092a = false;
        this.f69093b = -1;
        this.f69095d = "";
        this.f69096e = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f69093b = httpURLConnection.getResponseCode();
        this.f69095d = httpURLConnection.getContentEncoding();
        httpURLConnection.getContentType();
        this.f69096e = httpURLConnection.getContentLength() + "";
        this.f69097f = httpURLConnection.getHeaderFields();
    }
}
