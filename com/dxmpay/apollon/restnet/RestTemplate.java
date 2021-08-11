package com.dxmpay.apollon.restnet;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.f.a.g.d.d;
import c.f.a.g.d.e;
import c.f.a.g.d.f;
import c.f.a.g.d.h.c;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.restnet.converter.AbstractHttpMessageConverter;
import com.dxmpay.apollon.restnet.http.HttpDefines$HttpMethod;
import com.dxmpay.apollon.restnet.http.HttpStatus;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.dxmpay.apollon.utils.LogUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class RestTemplate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AbstractHttpMessageConverter<?> f68991a;

    /* renamed from: b  reason: collision with root package name */
    public List<RestHttpRequestInterceptor> f68992b;

    /* renamed from: c  reason: collision with root package name */
    public Context f68993c;

    /* renamed from: d  reason: collision with root package name */
    public String f68994d;

    /* renamed from: e  reason: collision with root package name */
    public String f68995e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68996f;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class b implements RestHttpRequestInterceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Class<?> f68997a;

        public /* synthetic */ b(RestTemplate restTemplate, Class cls, a aVar) {
            this(restTemplate, cls);
        }

        @Override // com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor
        public void a(Context context, d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) || this.f68997a == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (arrayList.isEmpty()) {
                return;
            }
            LogUtil.d("RestTemplate", "Setting request Accept header to " + arrayList);
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                if (it.hasNext()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            dVar.a().d(sb.toString());
        }

        public b(RestTemplate restTemplate, Class<?> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {restTemplate, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68997a = cls;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RestTemplate(Context context) {
        this(true, context, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (Context) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final d a(String str, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2, HttpDefines$HttpMethod httpDefines$HttpMethod, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, list, restMultipartEntity, str2, httpDefines$HttpMethod, Boolean.valueOf(z)})) == null) {
            if (str == null || httpDefines$HttpMethod == null) {
                return null;
            }
            if (ApollonConstants.DEBUG) {
                StringBuilder sb = new StringBuilder(str);
                if (list != null && !list.isEmpty()) {
                    sb.append("? params : ");
                    for (RestNameValuePair restNameValuePair : list) {
                        sb.append(restNameValuePair.getName() + "=" + restNameValuePair.getValue() + ",");
                    }
                    sb.delete(sb.length() - 1, sb.length());
                }
                LogUtil.d("RestTemplate", sb.toString());
            }
            d a2 = c.b().a(this.f68993c, this.f68995e, this.f68994d, str, httpDefines$HttpMethod, list, restMultipartEntity, str2, z);
            for (RestHttpRequestInterceptor restHttpRequestInterceptor : f()) {
                restHttpRequestInterceptor.a(this.f68993c, a2);
            }
            return a2;
        }
        return (d) invokeCommon.objValue;
    }

    public final e b(d dVar) throws RestRuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
            try {
                URL url = new URL(dVar.b());
                String host = url.getHost();
                int port = url.getPort();
                if (port > 0) {
                    String str = host + ":" + port;
                }
                if (this.f68996f) {
                    ((RestUrlConnectionRequest) dVar).c(RestHttpDNSEnabler.a(url));
                }
                dVar.a(url.toString());
                e c2 = dVar.c();
                if (ApollonConstants.DEBUG) {
                    LogUtil.v(ApollonConstants.APOLLON_REST_TAG, "rtt:" + c2.c().k());
                }
                return c2;
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    RestHttpDNSEnabler.e(new URL(dVar.b()).getHost());
                } catch (MalformedURLException e3) {
                    e3.printStackTrace();
                }
                if (dVar != null) {
                    dVar.e();
                }
                throw new RestRuntimeException("RestRuntimeException: " + e2.getMessage(), e2);
            }
        }
        return (e) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
        r5.e();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> T c(d dVar, e eVar, f<T> fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, eVar, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            if (eVar != null) {
                try {
                    try {
                        if (eVar.d().series() != HttpStatus.Series.CLIENT_ERROR && eVar.d().series() != HttpStatus.Series.SERVER_ERROR) {
                            T a2 = fVar.a(eVar);
                            if (a2 != null) {
                                return a2;
                            }
                            if (dVar != null) {
                                dVar.e();
                            }
                            if (eVar != null) {
                                eVar.e();
                            }
                            return null;
                        }
                    } catch (Exception e2) {
                        throw new RestRuntimeException("error: " + e2.getMessage(), e2);
                    }
                } finally {
                    if (dVar != null) {
                        dVar.e();
                    }
                    if (eVar != null) {
                        eVar.e();
                    }
                }
            }
            if (eVar != null) {
                eVar.e();
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public <T> T d(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, list, str2, cls)) == null) ? (T) e(str, list, str2, cls, false) : (T) invokeLLLL.objValue;
    }

    public <T> T e(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            f().add(new b(this, cls, null));
            f<T> fVar = new f<>(cls, k());
            d a2 = a(str, list, null, str2, HttpDefines$HttpMethod.GET, z);
            e b2 = b(a2);
            g(HttpDefines$HttpMethod.GET, str, b2);
            return (T) c(a2, b2, fVar);
        }
        return (T) invokeCommon.objValue;
    }

    public List<RestHttpRequestInterceptor> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f68992b : (List) invokeV.objValue;
    }

    public final void g(HttpDefines$HttpMethod httpDefines$HttpMethod, String str, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, httpDefines$HttpMethod, str, eVar) == null) || eVar == null) {
            return;
        }
        try {
            LogUtil.d("RestTemplate", httpDefines$HttpMethod.name() + " request for \"" + str + "\" resulted in " + eVar.d() + " (" + eVar.a() + SmallTailInfo.EMOTION_SUFFIX);
        } catch (Exception e2) {
            LogUtil.d("RestTemplate", "IOException : " + e2.getMessage());
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
        r5.e();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> RestResponseEntity<T> h(d dVar, e eVar, f<T> fVar) {
        InterceptResult invokeLLL;
        RestResponseEntity<T> restResponseEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, dVar, eVar, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            try {
                if (eVar != null) {
                    try {
                        if (eVar.d().series() != HttpStatus.Series.CLIENT_ERROR && eVar.d().series() != HttpStatus.Series.SERVER_ERROR) {
                            T a2 = fVar.a(eVar);
                            if (a2 != null) {
                                restResponseEntity = new RestResponseEntity<>(a2, eVar.c(), eVar.d());
                            } else {
                                restResponseEntity = new RestResponseEntity<>(eVar.c(), eVar.d());
                            }
                            restResponseEntity.c(fVar.b());
                            return restResponseEntity;
                        }
                    } catch (Exception e2) {
                        throw new RestRuntimeException("error: " + e2.getMessage(), e2);
                    }
                }
                if (eVar != null) {
                    eVar.e();
                }
                return null;
            } finally {
                if (dVar != null) {
                    dVar.e();
                }
                if (eVar != null) {
                    eVar.e();
                }
            }
        }
        return (RestResponseEntity) invokeLLL.objValue;
    }

    public <T> RestResponseEntity<T> i(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, list, str2, cls)) == null) ? j(str, list, str2, cls, false) : (RestResponseEntity) invokeLLLL.objValue;
    }

    public <T> RestResponseEntity<T> j(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            f().add(new b(this, cls, null));
            f<T> fVar = new f<>(cls, k());
            d a2 = a(str, list, null, str2, HttpDefines$HttpMethod.GET, z);
            e b2 = b(a2);
            g(HttpDefines$HttpMethod.GET, str, b2);
            return h(a2, b2, fVar);
        }
        return (RestResponseEntity) invokeCommon.objValue;
    }

    public AbstractHttpMessageConverter<?> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f68991a : (AbstractHttpMessageConverter) invokeV.objValue;
    }

    public <T> T l(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, str, list, str2, cls)) == null) ? (T) m(str, list, str2, cls, false) : (T) invokeLLLL.objValue;
    }

    public <T> T m(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            f().add(new b(this, cls, null));
            f<T> fVar = new f<>(cls, k());
            d a2 = a(str, list, null, str2, HttpDefines$HttpMethod.POST, z);
            e b2 = b(a2);
            g(HttpDefines$HttpMethod.POST, str, b2);
            return (T) c(a2, b2, fVar);
        }
        return (T) invokeCommon.objValue;
    }

    public <T> RestResponseEntity<T> n(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, str, list, str2, cls)) == null) ? o(str, list, str2, cls, false) : (RestResponseEntity) invokeLLLL.objValue;
    }

    public <T> RestResponseEntity<T> o(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            LogUtil.d("#####. postForEntity. url = " + str);
            f().add(new b(this, cls, null));
            f<T> fVar = new f<>(cls, k());
            d a2 = a(str, list, null, str2, HttpDefines$HttpMethod.POST, z);
            e b2 = b(a2);
            g(HttpDefines$HttpMethod.POST, str, b2);
            return h(a2, b2, fVar);
        }
        return (RestResponseEntity) invokeCommon.objValue;
    }

    public <T> T postMultipartForObject(String str, RestMultipartEntity restMultipartEntity, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048591, this, str, restMultipartEntity, str2, cls)) == null) {
            f().add(new b(this, cls, null));
            f<T> fVar = new f<>(cls, k());
            d a2 = a(str, null, restMultipartEntity, str2, HttpDefines$HttpMethod.POST, false);
            e b2 = b(a2);
            g(HttpDefines$HttpMethod.POST, str, b2);
            return (T) c(a2, b2, fVar);
        }
        return (T) invokeLLLL.objValue;
    }

    public void setMessageConverter(AbstractHttpMessageConverter<?> abstractHttpMessageConverter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, abstractHttpMessageConverter) == null) {
            this.f68991a = abstractHttpMessageConverter;
        }
    }

    public void setRequestInterceptor(List<RestHttpRequestInterceptor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.f68992b = list;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RestTemplate(Context context, String str, String str2) {
        this(true, context, str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (Context) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public RestTemplate(boolean z, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), context, str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f68991a = null;
        this.f68992b = new ArrayList();
        this.f68993c = null;
        this.f68994d = null;
        this.f68995e = "";
        this.f68996f = true;
        this.f68995e = str2;
        this.f68993c = context.getApplicationContext();
        this.f68994d = str;
    }
}
