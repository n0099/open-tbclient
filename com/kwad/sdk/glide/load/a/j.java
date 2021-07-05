package com.kwad.sdk.glide.load.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.HttpException;
import com.kwad.sdk.glide.load.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
/* loaded from: classes7.dex */
public class j implements d<InputStream> {
    public static /* synthetic */ Interceptable $ic;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public static final b f37805a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.b.g f37806b;

    /* renamed from: c  reason: collision with root package name */
    public final int f37807c;

    /* renamed from: d  reason: collision with root package name */
    public final b f37808d;

    /* renamed from: e  reason: collision with root package name */
    public HttpURLConnection f37809e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f37810f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f37811g;

    /* loaded from: classes7.dex */
    public static class a implements b {
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

        @Override // com.kwad.sdk.glide.load.a.j.b
        public HttpURLConnection a(URL url) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, url)) == null) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        HttpURLConnection a(URL url);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(85330659, "Lcom/kwad/sdk/glide/load/a/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(85330659, "Lcom/kwad/sdk/glide/load/a/j;");
                return;
            }
        }
        f37805a = new a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(com.kwad.sdk.glide.load.b.g gVar, int i2) {
        this(gVar, i2, f37805a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.glide.load.b.g) objArr2[0], ((Integer) objArr2[1]).intValue(), (b) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @VisibleForTesting
    public j(com.kwad.sdk.glide.load.b.g gVar, int i2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, Integer.valueOf(i2), bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37806b = gVar;
        this.f37807c = i2;
        this.f37808d = bVar;
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, httpURLConnection)) == null) {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                inputStream = com.kwad.sdk.glide.g.c.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable(HttpUrlFetcher.TAG, 3)) {
                    Log.d(HttpUrlFetcher.TAG, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                inputStream = httpURLConnection.getInputStream();
            }
            this.f37810f = inputStream;
            return this.f37810f;
        }
        return (InputStream) invokeL.objValue;
    }

    private InputStream a(URL url, int i2, URL url2, Map<String, String> map) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65540, this, url, i2, url2, map)) == null) {
            if (i2 < 5) {
                if (url2 != null) {
                    try {
                        if (url.toURI().equals(url2.toURI())) {
                            throw new HttpException("In re-direct loop");
                        }
                    } catch (URISyntaxException unused) {
                    }
                }
                this.f37809e = this.f37808d.a(url);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    this.f37809e.addRequestProperty(entry.getKey(), entry.getValue());
                }
                this.f37809e.setConnectTimeout(this.f37807c);
                this.f37809e.setReadTimeout(this.f37807c);
                this.f37809e.setUseCaches(false);
                this.f37809e.setDoInput(true);
                this.f37809e.setInstanceFollowRedirects(false);
                this.f37809e.connect();
                this.f37810f = this.f37809e.getInputStream();
                if (this.f37811g) {
                    return null;
                }
                int responseCode = this.f37809e.getResponseCode();
                if (a(responseCode)) {
                    return a(this.f37809e);
                }
                if (!b(responseCode)) {
                    if (responseCode == -1) {
                        throw new HttpException(responseCode);
                    }
                    throw new HttpException(this.f37809e.getResponseMessage(), responseCode);
                }
                String headerField = this.f37809e.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new HttpException("Received empty or null redirect url");
                }
                URL url3 = new URL(url, headerField);
                b();
                return a(url3, i2 + 1, url, map);
            }
            throw new HttpException("Too many (> 5) redirects!");
        }
        return (InputStream) invokeLILL.objValue;
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? i2 / 100 == 2 : invokeI.booleanValue;
    }

    public static boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? i2 / 100 == 3 : invokeI.booleanValue;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public Class<InputStream> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? InputStream.class : (Class) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, priority, aVar) == null) {
            long a2 = com.kwad.sdk.glide.g.f.a();
            try {
                try {
                    aVar.a((d.a<? super InputStream>) a(this.f37806b.a(), 0, null, this.f37806b.b()));
                } catch (IOException e2) {
                    if (Log.isLoggable(HttpUrlFetcher.TAG, 3)) {
                        Log.d(HttpUrlFetcher.TAG, "Failed to load data for url", e2);
                    }
                    aVar.a((Exception) e2);
                    if (!Log.isLoggable(HttpUrlFetcher.TAG, 2)) {
                        return;
                    }
                    sb = new StringBuilder();
                }
                if (Log.isLoggable(HttpUrlFetcher.TAG, 2)) {
                    sb = new StringBuilder();
                    sb.append("Finished http url fetcher fetch in ");
                    sb.append(com.kwad.sdk.glide.g.f.a(a2));
                    Log.v(HttpUrlFetcher.TAG, sb.toString());
                }
            } catch (Throwable th) {
                if (Log.isLoggable(HttpUrlFetcher.TAG, 2)) {
                    Log.v(HttpUrlFetcher.TAG, "Finished http url fetcher fetch in " + com.kwad.sdk.glide.g.f.a(a2));
                }
                throw th;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InputStream inputStream = this.f37810f;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            HttpURLConnection httpURLConnection = this.f37809e;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.f37809e = null;
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f37811g = true;
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public DataSource d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? DataSource.REMOTE : (DataSource) invokeV.objValue;
    }
}
