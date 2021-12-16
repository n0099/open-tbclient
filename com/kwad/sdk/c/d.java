package com.kwad.sdk.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.utils.StatHelper;
import com.kwad.sdk.c.kwai.e;
import com.kwad.sdk.c.kwai.f;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<f, e> a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f57642b;

    /* renamed from: c  reason: collision with root package name */
    public Context f57643c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, com.kwad.sdk.c.kwai.b> f57644d;

    /* loaded from: classes3.dex */
    public static class a implements com.kwad.sdk.c.a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.kwad.sdk.c.a.c
        public boolean a(com.kwad.sdk.c.kwai.d dVar) {
            InterceptResult invokeL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                String a = dVar.a();
                String a2 = com.kwad.sdk.utils.c.a(dVar.e());
                if (a2 != null && a2.length() > 10) {
                    a2 = a2.substring(0, 10);
                }
                if (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2) || !a2.equalsIgnoreCase(a)) {
                    return false;
                }
                InputStream inputStream = null;
                try {
                    try {
                        inputStream = q.b(dVar.e());
                        i2 = inputStream != null ? inputStream.available() : 0;
                    } catch (IOException e2) {
                        com.kwad.sdk.core.d.a.e("resource file is error ", e2.getMessage());
                        q.b(inputStream);
                        i2 = 0;
                    }
                    return i2 != 0;
                } finally {
                    q.b(inputStream);
                }
            }
            return invokeL.booleanValue;
        }
    }

    public d(Context context) {
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
        this.f57644d = new HashMap();
        this.f57643c = context;
        this.a = new ConcurrentHashMap(16);
        this.f57642b = new ReentrantLock();
    }

    private WebResourceResponse a(InputStream inputStream, e eVar, com.kwad.sdk.c.kwai.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, inputStream, eVar, bVar)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                HashMap hashMap = new HashMap();
                hashMap.put("Access-Control-Allow-Origin", bVar.f57651e.a);
                hashMap.put("Access-Control-Allow-Credentials", "true");
                hashMap.put("Timing-Allow-Origin", bVar.f57651e.f57645b);
                hashMap.put("content-type", bVar.f57651e.f57646c);
                hashMap.put("Date", bVar.f57651e.f57647d);
                return new WebResourceResponse(bVar.f57650d, "", bVar.a, StatHelper.SENSOR_OK, hashMap, inputStream);
            }
            return new WebResourceResponse(eVar.c(), "UTF-8", inputStream);
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }

    private com.kwad.sdk.c.kwai.b a(com.kwad.sdk.c.kwai.d dVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, dVar, str)) == null) {
            String d2 = com.kwad.sdk.c.b.a.d(this.f57643c, dVar.f());
            com.kwad.sdk.c.kwai.b bVar = this.f57644d.get(str);
            if (bVar != null) {
                return bVar;
            }
            try {
                return a(str, d2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (com.kwad.sdk.c.kwai.b) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e A[LOOP:0: B:28:0x004e->B:30:0x0054, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.kwad.sdk.c.kwai.b a(String str, String str2) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        String str3;
        JSONObject jSONObject;
        Iterator<String> keys;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            File file = new File(str2);
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    fileInputStream = null;
                }
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    try {
                        str3 = h.b(inputStreamReader);
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        q.b(fileInputStream);
                        q.b(inputStreamReader);
                        str3 = null;
                    }
                    if (str3 != null) {
                        try {
                            jSONObject = new JSONObject(str3);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        keys = jSONObject != null ? jSONObject.keys() : null;
                        if (keys != null) {
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                                com.kwad.sdk.c.kwai.b bVar = new com.kwad.sdk.c.kwai.b();
                                bVar.parseJson(jSONObject2);
                                this.f57644d.put(next, bVar);
                            }
                        }
                        return this.f57644d.get(str);
                    }
                    jSONObject = null;
                    if (jSONObject != null) {
                    }
                    if (keys != null) {
                    }
                    return this.f57644d.get(str);
                } finally {
                    q.b(fileInputStream);
                    q.b(inputStreamReader);
                }
            }
            return null;
        }
        return (com.kwad.sdk.c.kwai.b) invokeLL.objValue;
    }

    private void a(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, fVar) == null) && this.f57642b.tryLock()) {
            this.a.remove(fVar);
            this.f57642b.unlock();
        }
    }

    public WebResourceResponse a(String str, com.kwad.sdk.c.kwai.d dVar, String str2) {
        InterceptResult invokeLLL;
        e d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, dVar, str2)) == null) {
            f fVar = new f(str);
            if (this.a.get(fVar) != null) {
                d2 = this.a.get(fVar);
            } else {
                StringBuilder sb = new StringBuilder(com.kwad.sdk.c.b.a.c(this.f57643c, dVar.f()));
                sb.append("/");
                sb.append(fVar.a());
                d2 = new e().a(dVar.a).b(str).e(dVar.a()).c(sb.toString()).d(URLConnection.getFileNameMap().getContentTypeFor(sb.toString()));
                this.a.put(new f(d2.a()), d2);
            }
            if (!com.kwad.sdk.c.b.c.a(d2.c())) {
                a(fVar);
                return null;
            }
            InputStream b2 = q.b(d2.b());
            if (b2 != null) {
                com.kwad.sdk.c.kwai.b a2 = a(dVar, fVar.a());
                if (a2 == null) {
                    return null;
                }
                return a(b2, d2, a2);
            }
            com.kwad.sdk.core.d.a.a("HybridResourceManagerImpl", "getResource [" + str + "] inputStream is null");
            a(fVar);
            return null;
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? new f(str).b() : (String) invokeL.objValue;
    }
}
