package com.tb.airbnb.lottie.network;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.Pair;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.tb.airbnb.lottie.d;
import com.tb.airbnb.lottie.e;
import com.tb.airbnb.lottie.f;
import com.tb.airbnb.lottie.l;
import com.tb.airbnb.lottie.m;
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
/* loaded from: classes20.dex */
public class b {
    private final Context appContext;
    private final a pCU;
    private final String url;

    public static m<e> by(Context context, String str) {
        return new b(context, str).eBZ();
    }

    private b(Context context, String str) {
        this.appContext = context.getApplicationContext();
        this.url = str;
        this.pCU = new a(this.appContext, str);
    }

    private m<e> eBZ() {
        return new m<>(new Callable<l<e>>() { // from class: com.tb.airbnb.lottie.network.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: eAV */
            public l<e> call() throws Exception {
                return b.this.eCa();
            }
        });
    }

    @WorkerThread
    public l<e> eCa() {
        e eCb = eCb();
        if (eCb != null) {
            return new l<>(eCb);
        }
        d.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return eCc();
    }

    @WorkerThread
    @Nullable
    private e eCb() {
        l<e> j;
        Pair<FileExtension, InputStream> kL = this.pCU.kL();
        if (kL == null) {
            return null;
        }
        FileExtension fileExtension = kL.first;
        InputStream inputStream = kL.second;
        if (fileExtension == FileExtension.Zip) {
            j = f.c(new ZipInputStream(inputStream), this.url);
        } else {
            j = f.j(inputStream, this.url);
        }
        if (j.getValue() != null) {
            return j.getValue();
        }
        return null;
    }

    @WorkerThread
    private l<e> eCc() {
        try {
            return eCd();
        } catch (IOException e) {
            return new l<>(e);
        }
    }

    @WorkerThread
    private l eCd() throws IOException {
        FileExtension fileExtension;
        l<e> c;
        d.debug("Fetching " + this.url);
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
                    return new l((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb)));
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
                    d.debug("Handling zip response.");
                    fileExtension = FileExtension.Zip;
                    c = f.c(new ZipInputStream(new FileInputStream(this.pCU.a(httpURLConnection.getInputStream(), fileExtension))), this.url);
                    break;
                default:
                    d.debug("Received json response.");
                    fileExtension = FileExtension.Json;
                    c = f.j(new FileInputStream(new File(this.pCU.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
                    break;
            }
            if (c.getValue() != null) {
                this.pCU.a(fileExtension);
            }
            d.debug("Completed fetch from network. Success: " + (c.getValue() != null));
            return c;
        }
    }
}
