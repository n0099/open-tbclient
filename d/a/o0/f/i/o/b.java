package d.a.o0.f.i.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements d.a.o0.f.i.l.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f49905a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49906b;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return "";
                }
                response.body().close();
                return "";
            }
            return (String) invokeLI.objValue;
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49906b = context;
    }

    @Override // d.a.o0.f.i.l.g
    public void a(String str, JSONObject jSONObject, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, responseCallback) == null) {
            boolean startsWith = str.startsWith("https://");
            this.f49905a = startsWith;
            if (startsWith) {
                ((PostBodyRequest.PostBodyRequestBuilder) d.a.o0.m.e.a.g().postRequest().url(str)).requestBody(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString())).build().executeAsync(responseCallback);
            } else {
                ((PostBodyRequest.PostBodyRequestBuilder) d.a.o0.m.e.a.g().postRequest().url(str)).requestBody(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString())).build().executeAsync(responseCallback);
            }
        }
    }

    @Override // d.a.o0.f.i.l.g
    public void b(String str, ResponseCallback<d.a.o0.f.i.k.a> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, responseCallback) == null) {
            boolean startsWith = str.startsWith("https://");
            this.f49905a = startsWith;
            if (startsWith) {
                d.a.o0.m.e.a.g().getRequest().url(str).build().executeAsync(responseCallback);
            } else {
                d.a.o0.m.e.a.g().getRequest().url(str).build().executeAsync(responseCallback);
            }
        }
    }

    @Override // d.a.o0.f.i.l.g
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d.a.o0.m.d.a aVar = new d.a.o0.m.d.a();
        aVar.f51098b = "POST";
        aVar.f51097a = "https://pimlog.baidu.com/mapp/advlog";
        aVar.f51100d = RequestBody.create(MediaType.get("application/json; charset=utf-8"), str);
        d.a.o0.m.e.a.g().e(aVar);
    }

    @Override // d.a.o0.f.i.l.g
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            a aVar = new a(this);
            boolean startsWith = str.startsWith("https://");
            this.f49905a = startsWith;
            if (startsWith) {
                d.a.o0.m.e.a.g().getRequest().url(str).build().executeAsync(aVar);
            } else {
                d.a.o0.m.e.a.g().getRequest().url(str).build().executeAsync(aVar);
            }
        }
    }

    @Override // d.a.o0.f.i.l.g
    public void e(String str, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, responseCallback) == null) {
            boolean startsWith = str.startsWith("https://");
            this.f49905a = startsWith;
            if (startsWith) {
                d.a.o0.m.e.a.g().getRequest().url(str).build().executeAsync(responseCallback);
            } else {
                d.a.o0.m.e.a.g().getRequest().url(str).build().executeAsync(responseCallback);
            }
        }
    }
}
