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
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f44206a;

    /* renamed from: b  reason: collision with root package name */
    public int f44207b;

    /* renamed from: c  reason: collision with root package name */
    public int f44208c;

    /* renamed from: d  reason: collision with root package name */
    public String f44209d;

    /* renamed from: e  reason: collision with root package name */
    public String f44210e;

    /* renamed from: f  reason: collision with root package name */
    public String f44211f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f44212g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f44213h;

    /* renamed from: i  reason: collision with root package name */
    public int f44214i;

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
        this.f44206a = false;
        this.f44207b = -1;
        this.f44208c = -1;
        this.f44209d = "";
        this.f44210e = "";
        this.f44211f = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f44207b = httpURLConnection.getResponseCode();
        this.f44209d = httpURLConnection.getContentEncoding();
        this.f44210e = httpURLConnection.getContentType();
        this.f44211f = httpURLConnection.getContentLength() + "";
        this.f44212g = httpURLConnection.getHeaderFields();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f44207b == 200 : invokeV.booleanValue;
    }
}
