package com.ksad.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.utils.HttpHelper;
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
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8404a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8405b;
    private final a c;

    private b(Context context, String str) {
        this.f8404a = context.getApplicationContext();
        this.f8405b = str;
        this.c = new a(this.f8404a, str);
    }

    public static k<d> a(Context context, String str) {
        return new b(context, str).b();
    }

    private k<d> b() {
        return new k<>(new Callable<j<d>>() { // from class: com.ksad.lottie.network.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public j<d> call() {
                return b.this.a();
            }
        });
    }

    @Nullable
    @WorkerThread
    private d c() {
        Pair<FileExtension, InputStream> a2 = this.c.a();
        if (a2 == null) {
            return null;
        }
        FileExtension fileExtension = a2.first;
        InputStream inputStream = a2.second;
        j<d> a3 = fileExtension == FileExtension.Zip ? e.a(new ZipInputStream(inputStream), this.f8405b) : e.a(inputStream, this.f8405b);
        if (a3.a() != null) {
            return a3.a();
        }
        return null;
    }

    @WorkerThread
    private j<d> d() {
        try {
            return e();
        } catch (IOException e) {
            return new j<>(e);
        }
    }

    @WorkerThread
    private j e() {
        FileExtension fileExtension;
        j<d> a2;
        c.a("Fetching " + this.f8405b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f8405b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", com.kwad.sdk.core.network.k.a());
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
            String contentType = httpURLConnection.getContentType();
            char c = 65535;
            switch (contentType.hashCode()) {
                case -1248325150:
                    if (contentType.equals("application/zip")) {
                        c = 0;
                        break;
                    }
                    break;
                case -43840953:
                    if (contentType.equals(HttpHelper.CONTENT_JSON)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    c.a("Handling zip response.");
                    fileExtension = FileExtension.Zip;
                    a2 = e.a(new ZipInputStream(new FileInputStream(this.c.a(httpURLConnection.getInputStream(), fileExtension))), this.f8405b);
                    break;
                default:
                    c.a("Received json response.");
                    fileExtension = FileExtension.Json;
                    a2 = e.a(new FileInputStream(new File(this.c.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f8405b);
                    break;
            }
            if (a2.a() != null) {
                this.c.a(fileExtension);
            }
            c.a("Completed fetch from network. Success: " + (a2.a() != null));
            return a2;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return new j((Throwable) new IllegalArgumentException("Unable to fetch " + this.f8405b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb)));
            }
            sb.append(readLine).append('\n');
        }
    }

    @WorkerThread
    public j<d> a() {
        d c = c();
        if (c != null) {
            return new j<>(c);
        }
        c.a("Animation for " + this.f8405b + " not found in cache. Fetching from network.");
        return d();
    }
}
