package d.a.o0.m.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f51097a;

    /* renamed from: b  reason: collision with root package name */
    public String f51098b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f51099c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f51100d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f51101e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51102f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51103g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51104h;

    /* renamed from: i  reason: collision with root package name */
    public Object f51105i;
    public int j;
    public int k;
    public C1150a l;

    /* renamed from: d.a.o0.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1150a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f51106a;

        /* renamed from: b  reason: collision with root package name */
        public int f51107b;

        /* renamed from: c  reason: collision with root package name */
        public int f51108c;
    }

    public a() {
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
        this.f51098b = "GET";
        this.f51102f = false;
        this.f51103g = false;
        this.f51104h = false;
        this.j = 6;
        this.k = 0;
    }

    public a a(MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaType, str)) == null) {
            if (mediaType != null && str != null) {
                this.f51100d = RequestBody.create(mediaType, str);
            }
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public C1150a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (C1150a) invokeV.objValue;
    }

    public a(String str, ResponseCallback responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, responseCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51098b = "GET";
        this.f51102f = false;
        this.f51103g = false;
        this.f51104h = false;
        this.j = 6;
        this.k = 0;
        this.f51097a = str;
        this.f51101e = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, requestBody, responseCallback};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f51098b = "GET";
        this.f51102f = false;
        this.f51103g = false;
        this.f51104h = false;
        this.j = 6;
        this.k = 0;
        this.f51097a = str;
        this.f51100d = requestBody;
        this.f51101e = responseCallback;
    }
}
