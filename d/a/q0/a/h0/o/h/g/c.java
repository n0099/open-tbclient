package d.a.q0.a.h0.o.h.g;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public final class c implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<a> f48420a;

    /* renamed from: b  reason: collision with root package name */
    public String f48421b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f48422c;

    /* renamed from: d  reason: collision with root package name */
    public int f48423d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48424e;

    /* renamed from: f  reason: collision with root package name */
    public String f48425f;

    public c(CopyOnWriteArrayList<a> copyOnWriteArrayList, String str, Map<String, String> map, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {copyOnWriteArrayList, str, map, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48420a = copyOnWriteArrayList;
        this.f48421b = str;
        this.f48422c = map;
        this.f48423d = i2;
        this.f48424e = z;
    }

    @Override // d.a.q0.a.h0.o.h.g.g
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f48425f = str;
        }
    }

    @Override // d.a.q0.a.h0.o.h.g.g
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, z)) == null) {
            if (this.f48423d >= this.f48420a.size()) {
                return null;
            }
            return this.f48420a.get(this.f48423d).h(new c(this.f48420a, this.f48421b, this.f48422c, this.f48423d + 1, z));
        }
        return (WebResourceResponse) invokeLLZ.objValue;
    }

    @Override // d.a.q0.a.h0.o.h.g.g
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48424e : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.o.h.g.g
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48421b : (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.h0.o.h.g.g
    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.f48425f)) {
                this.f48425f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f48421b));
            }
            return this.f48425f;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.h0.o.h.g.g
    public Map<String, String> getRequestHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f48422c : (Map) invokeV.objValue;
    }
}
