package d.a.p0.w2.c0.m;

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
    public volatile boolean f65876a;

    /* renamed from: b  reason: collision with root package name */
    public int f65877b;

    /* renamed from: c  reason: collision with root package name */
    public int f65878c;

    /* renamed from: d  reason: collision with root package name */
    public String f65879d;

    /* renamed from: e  reason: collision with root package name */
    public String f65880e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f65881f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f65882g;

    /* renamed from: h  reason: collision with root package name */
    public int f65883h;

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
        this.f65876a = false;
        this.f65877b = -1;
        this.f65879d = "";
        this.f65880e = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f65877b = httpURLConnection.getResponseCode();
        this.f65879d = httpURLConnection.getContentEncoding();
        httpURLConnection.getContentType();
        this.f65880e = httpURLConnection.getContentLength() + "";
        this.f65881f = httpURLConnection.getHeaderFields();
    }
}
