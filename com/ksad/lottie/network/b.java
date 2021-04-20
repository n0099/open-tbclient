package com.ksad.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f31891a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31892b;

    /* renamed from: c  reason: collision with root package name */
    public final a f31893c;

    public b(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f31891a = applicationContext;
        this.f31892b = str;
        this.f31893c = new a(applicationContext, str);
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
        Pair<FileExtension, InputStream> a2 = this.f31893c.a();
        if (a2 == null) {
            return null;
        }
        FileExtension fileExtension = a2.first;
        InputStream inputStream = a2.second;
        j<d> a3 = fileExtension == FileExtension.Zip ? e.a(new ZipInputStream(inputStream), this.f31892b) : e.a(inputStream, this.f31892b);
        if (a3.a() != null) {
            return a3.a();
        }
        return null;
    }

    @WorkerThread
    private j<d> d() {
        try {
            return e();
        } catch (IOException e2) {
            return new j<>(e2);
        }
    }

    @WorkerThread
    private j e() {
        FileExtension fileExtension;
        j<d> a2;
        c.a("Fetching " + this.f31892b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f31892b).openConnection();
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
                a2 = e.a(new FileInputStream(new File(this.f31893c.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f31892b);
            } else {
                c.a("Handling zip response.");
                fileExtension = FileExtension.Zip;
                a2 = e.a(new ZipInputStream(new FileInputStream(this.f31893c.a(httpURLConnection.getInputStream(), fileExtension))), this.f31892b);
            }
            if (a2.a() != null) {
                this.f31893c.a(fileExtension);
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
                return new j((Throwable) new IllegalArgumentException("Unable to fetch " + this.f31892b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb2)));
            }
            sb2.append(readLine);
            sb2.append('\n');
        }
    }

    @WorkerThread
    public j<d> a() {
        d c2 = c();
        if (c2 != null) {
            return new j<>(c2);
        }
        c.a("Animation for " + this.f31892b + " not found in cache. Fetching from network.");
        return d();
    }
}
