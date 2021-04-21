package d.a.a.v;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.network.FileExtension;
import d.a.a.d;
import d.a.a.e;
import d.a.a.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f41827a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41828b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final a f41829c;

    public b(Context context, String str, @Nullable String str2) {
        Context applicationContext = context.getApplicationContext();
        this.f41827a = applicationContext;
        this.f41828b = str;
        if (str2 == null) {
            this.f41829c = null;
        } else {
            this.f41829c = new a(applicationContext);
        }
    }

    public static l<d> e(Context context, String str, @Nullable String str2) {
        return new b(context, str, str2).d();
    }

    @Nullable
    @WorkerThread
    public final d a() {
        Pair<FileExtension, InputStream> a2;
        l<d> i;
        a aVar = this.f41829c;
        if (aVar == null || (a2 = aVar.a(this.f41828b)) == null) {
            return null;
        }
        FileExtension fileExtension = a2.first;
        InputStream inputStream = a2.second;
        if (fileExtension == FileExtension.ZIP) {
            i = e.t(new ZipInputStream(inputStream), this.f41828b);
        } else {
            i = e.i(inputStream, this.f41828b);
        }
        if (i.b() != null) {
            return i.b();
        }
        return null;
    }

    @WorkerThread
    public final l<d> b() {
        try {
            return c();
        } catch (IOException e2) {
            return new l<>(e2);
        }
    }

    @WorkerThread
    public final l<d> c() throws IOException {
        d.a.a.x.d.a("Fetching " + this.f41828b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f41828b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                l<d> g2 = g(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(g2.b() != null);
                d.a.a.x.d.a(sb.toString());
                return g2;
            }
            String f2 = f(httpURLConnection);
            return new l<>(new IllegalArgumentException("Unable to fetch " + this.f41828b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + f2));
        } catch (Exception e2) {
            return new l<>(e2);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    @WorkerThread
    public l<d> d() {
        d a2 = a();
        if (a2 != null) {
            return new l<>(a2);
        }
        d.a.a.x.d.a("Animation for " + this.f41828b + " not found in cache. Fetching from network.");
        return b();
    }

    public final String f(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    @Nullable
    public final l<d> g(HttpURLConnection httpURLConnection) throws IOException {
        FileExtension fileExtension;
        l<d> i;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        if (contentType.contains("application/zip")) {
            d.a.a.x.d.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            a aVar = this.f41829c;
            if (aVar == null) {
                i = e.t(new ZipInputStream(httpURLConnection.getInputStream()), null);
            } else {
                i = e.t(new ZipInputStream(new FileInputStream(aVar.f(this.f41828b, httpURLConnection.getInputStream(), fileExtension))), this.f41828b);
            }
        } else {
            d.a.a.x.d.a("Received json response.");
            fileExtension = FileExtension.JSON;
            a aVar2 = this.f41829c;
            if (aVar2 == null) {
                i = e.i(httpURLConnection.getInputStream(), null);
            } else {
                i = e.i(new FileInputStream(new File(aVar2.f(this.f41828b, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f41828b);
            }
        }
        if (this.f41829c != null && i.b() != null) {
            this.f41829c.e(this.f41828b, fileExtension);
        }
        return i;
    }
}
