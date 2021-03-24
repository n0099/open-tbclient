package d.a.a.t;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.network.FileExtension;
import d.a.a.c;
import d.a.a.d;
import d.a.a.e;
import d.a.a.k;
import d.a.a.l;
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
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f41421a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41422b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.t.a f41423c;

    /* loaded from: classes.dex */
    public class a implements Callable<k<d>> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public k<d> call() throws Exception {
            return b.this.f();
        }
    }

    public b(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f41421a = applicationContext;
        this.f41422b = str;
        this.f41423c = new d.a.a.t.a(applicationContext, str);
    }

    public static l<d> b(Context context, String str) {
        return new b(context, str).a();
    }

    public final l<d> a() {
        return new l<>(new a());
    }

    @Nullable
    @WorkerThread
    public final d c() {
        k<d> g2;
        Pair<FileExtension, InputStream> a2 = this.f41423c.a();
        if (a2 == null) {
            return null;
        }
        FileExtension fileExtension = a2.first;
        InputStream inputStream = a2.second;
        if (fileExtension == FileExtension.Zip) {
            g2 = e.n(new ZipInputStream(inputStream), this.f41422b);
        } else {
            g2 = e.g(inputStream, this.f41422b);
        }
        if (g2.b() != null) {
            return g2.b();
        }
        return null;
    }

    @WorkerThread
    public final k<d> d() {
        try {
            return e();
        } catch (IOException e2) {
            return new k<>(e2);
        }
    }

    @WorkerThread
    public final k e() throws IOException {
        FileExtension fileExtension;
        k<d> n;
        c.b("Fetching " + this.f41422b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f41422b).openConnection();
        httpURLConnection.setRequestMethod("GET");
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
                c.b("Received json response.");
                fileExtension = FileExtension.Json;
                n = e.g(new FileInputStream(new File(this.f41423c.e(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f41422b);
            } else {
                c.b("Handling zip response.");
                fileExtension = FileExtension.Zip;
                n = e.n(new ZipInputStream(new FileInputStream(this.f41423c.e(httpURLConnection.getInputStream(), fileExtension))), this.f41422b);
            }
            if (n.b() != null) {
                this.f41423c.d(fileExtension);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Completed fetch from network. Success: ");
            sb.append(n.b() != null);
            c.b(sb.toString());
            return n;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
                sb2.append('\n');
            } else {
                return new k((Throwable) new IllegalArgumentException("Unable to fetch " + this.f41422b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb2)));
            }
        }
    }

    @WorkerThread
    public k<d> f() {
        d c2 = c();
        if (c2 != null) {
            return new k<>(c2);
        }
        c.b("Animation for " + this.f41422b + " not found in cache. Fetching from network.");
        return d();
    }
}
