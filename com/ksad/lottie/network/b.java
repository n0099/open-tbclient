package com.ksad.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.c;
import com.ksad.lottie.d;
import com.ksad.lottie.e;
import com.ksad.lottie.j;
import com.ksad.lottie.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f34004a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34005b;

    /* renamed from: c  reason: collision with root package name */
    public final a f34006c;

    public b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Context applicationContext = context.getApplicationContext();
        this.f34004a = applicationContext;
        this.f34005b = str;
        this.f34006c = new a(applicationContext, str);
    }

    public static k<d> a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) ? new b(context, str).b() : (k) invokeLL.objValue;
    }

    private k<d> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new k<>(new Callable<j<d>>(this) { // from class: com.ksad.lottie.network.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34007a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34007a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public j<d> call() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? this.f34007a.a() : (j) invokeV2.objValue;
            }
        }) : (k) invokeV.objValue;
    }

    @Nullable
    @WorkerThread
    private d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Pair<FileExtension, InputStream> a2 = this.f34006c.a();
            if (a2 == null) {
                return null;
            }
            FileExtension fileExtension = a2.first;
            InputStream inputStream = a2.second;
            j<d> a3 = fileExtension == FileExtension.Zip ? e.a(new ZipInputStream(inputStream), this.f34005b) : e.a(inputStream, this.f34005b);
            if (a3.a() != null) {
                return a3.a();
            }
            return null;
        }
        return (d) invokeV.objValue;
    }

    @WorkerThread
    private j<d> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            try {
                return e();
            } catch (IOException e2) {
                return new j<>(e2);
            }
        }
        return (j) invokeV.objValue;
    }

    @WorkerThread
    private j e() {
        InterceptResult invokeV;
        FileExtension fileExtension;
        j<d> a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) != null) {
            return (j) invokeV.objValue;
        }
        c.a("Fetching " + this.f34005b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f34005b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", com.kwad.sdk.core.network.k.a());
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
            String contentType = httpURLConnection.getContentType();
            char c2 = 65535;
            int hashCode = contentType.hashCode();
            if (hashCode != -1248325150) {
                if (hashCode == -43840953 && contentType.equals("application/json")) {
                    c2 = 1;
                }
            } else if (contentType.equals("application/zip")) {
                c2 = 0;
            }
            if (c2 != 0) {
                c.a("Received json response.");
                fileExtension = FileExtension.Json;
                a2 = e.a(new FileInputStream(new File(this.f34006c.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f34005b);
            } else {
                c.a("Handling zip response.");
                fileExtension = FileExtension.Zip;
                a2 = e.a(new ZipInputStream(new FileInputStream(this.f34006c.a(httpURLConnection.getInputStream(), fileExtension))), this.f34005b);
            }
            if (a2.a() != null) {
                this.f34006c.a(fileExtension);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Completed fetch from network. Success: ");
            sb.append(a2.a() != null);
            c.a(sb.toString());
            return a2;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return new j((Throwable) new IllegalArgumentException("Unable to fetch " + this.f34005b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb2)));
            }
            sb2.append(readLine);
            sb2.append('\n');
        }
    }

    @WorkerThread
    public j<d> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d c2 = c();
            if (c2 != null) {
                return new j<>(c2);
            }
            c.a("Animation for " + this.f34005b + " not found in cache. Fetching from network.");
            return d();
        }
        return (j) invokeV.objValue;
    }
}
