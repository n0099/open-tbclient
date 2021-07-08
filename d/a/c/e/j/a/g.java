package d.a.c.e.j.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f41222a;

    /* renamed from: b  reason: collision with root package name */
    public int f41223b;

    /* renamed from: c  reason: collision with root package name */
    public int f41224c;

    /* renamed from: d  reason: collision with root package name */
    public String f41225d;

    /* renamed from: e  reason: collision with root package name */
    public String f41226e;

    /* renamed from: f  reason: collision with root package name */
    public String f41227f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f41228g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f41229h;

    /* renamed from: i  reason: collision with root package name */
    public int f41230i;

    public g() {
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
        this.f41222a = false;
        this.f41223b = -1;
        this.f41224c = -1;
        this.f41225d = "";
        this.f41226e = "";
        this.f41227f = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f41223b = httpURLConnection.getResponseCode();
        this.f41225d = httpURLConnection.getContentEncoding();
        this.f41226e = httpURLConnection.getContentType();
        this.f41227f = httpURLConnection.getContentLength() + "";
        this.f41228g = httpURLConnection.getHeaderFields();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41223b == 200 : invokeV.booleanValue;
    }
}
