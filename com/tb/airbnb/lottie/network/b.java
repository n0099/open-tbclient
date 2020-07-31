package com.tb.airbnb.lottie.network;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.Pair;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.tb.airbnb.lottie.c;
import com.tb.airbnb.lottie.d;
import com.tb.airbnb.lottie.e;
import com.tb.airbnb.lottie.k;
import com.tb.airbnb.lottie.l;
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
    private final Context appContext;
    private final a nQg;
    private final String url;

    public static l<d> bd(Context context, String str) {
        return new b(context, str).dRS();
    }

    private b(Context context, String str) {
        this.appContext = context.getApplicationContext();
        this.url = str;
        this.nQg = new a(this.appContext, str);
    }

    private l<d> dRS() {
        return new l<>(new Callable<k<d>>() { // from class: com.tb.airbnb.lottie.network.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: dQO */
            public k<d> call() throws Exception {
                return b.this.dRT();
            }
        });
    }

    @WorkerThread
    public k<d> dRT() {
        d dRU = dRU();
        if (dRU != null) {
            return new k<>(dRU);
        }
        c.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return dRV();
    }

    @WorkerThread
    @Nullable
    private d dRU() {
        k<d> j;
        Pair<FileExtension, InputStream> jk = this.nQg.jk();
        if (jk == null) {
            return null;
        }
        FileExtension fileExtension = jk.first;
        InputStream inputStream = jk.second;
        if (fileExtension == FileExtension.Zip) {
            j = e.c(new ZipInputStream(inputStream), this.url);
        } else {
            j = e.j(inputStream, this.url);
        }
        if (j.getValue() != null) {
            return j.getValue();
        }
        return null;
    }

    @WorkerThread
    private k<d> dRV() {
        try {
            return dRW();
        } catch (IOException e) {
            return new k<>(e);
        }
    }

    @WorkerThread
    private k dRW() throws IOException {
        FileExtension fileExtension;
        k<d> c;
        c.debug("Fetching " + this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() != null || httpURLConnection.getResponseCode() != 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine).append('\n');
                } else {
                    return new k((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb)));
                }
            }
        } else {
            String contentType = httpURLConnection.getContentType();
            char c2 = 65535;
            switch (contentType.hashCode()) {
                case -1248325150:
                    if (contentType.equals("application/zip")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -43840953:
                    if (contentType.equals(HttpHelper.CONTENT_JSON)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    c.debug("Handling zip response.");
                    fileExtension = FileExtension.Zip;
                    c = e.c(new ZipInputStream(new FileInputStream(this.nQg.a(httpURLConnection.getInputStream(), fileExtension))), this.url);
                    break;
                default:
                    c.debug("Received json response.");
                    fileExtension = FileExtension.Json;
                    c = e.j(new FileInputStream(new File(this.nQg.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
                    break;
            }
            if (c.getValue() != null) {
                this.nQg.a(fileExtension);
            }
            c.debug("Completed fetch from network. Success: " + (c.getValue() != null));
            return c;
        }
    }
}
