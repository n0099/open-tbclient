package d.c.c.b.b;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.webkit.net.BdNetTask;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import d.c.c.b.d.k;
import d.c.c.b.d.o;
import d.c.c.b.d.q;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes5.dex */
public class c extends Request<File> {
    @Nullable
    @GuardedBy("mLock")
    public o.a<File> A;
    public File x;
    public File y;
    public final Object z;

    /* loaded from: classes5.dex */
    public interface a extends o.a<File> {
        void a(long j, long j2);
    }

    public c(String str, String str2, o.a<File> aVar) {
        super(str2, aVar);
        this.z = new Object();
        this.A = aVar;
        this.x = new File(str);
        this.y = new File(str + ".tmp");
        try {
            if (this.x != null && this.x.getParentFile() != null && !this.x.getParentFile().exists()) {
                this.x.getParentFile().mkdirs();
            }
        } catch (Throwable unused) {
        }
        setRetryPolicy(new d.c.c.b.d.g(BdNetTask.TIMEOUT_READ, 1, 1.0f));
        setShouldCache(false);
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public o<File> a(k kVar) {
        if (!isCanceled()) {
            if (this.y.canRead() && this.y.length() > 0) {
                if (this.y.renameTo(this.x)) {
                    return o.c(null, d.c.c.b.e.c.b(kVar));
                }
                l();
                return o.b(new VAdError("Can't rename the download temporary file!", (int) VAdError.RENAME_DOWNLOAD_FILE_FAIL_CODE));
            }
            l();
            return o.b(new VAdError("Download temporary file was invalid!", 610));
        }
        l();
        return o.b(new VAdError("Request was Canceled!", (int) VAdError.DOWNLOAD_FILE_CANCEL_FAIL_CODE));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.z) {
            this.A = null;
        }
    }

    public final String f(d.c.c.b.d.b bVar, String str) {
        if (bVar == null || bVar.c() == null || bVar.c().isEmpty()) {
            return null;
        }
        for (d.c.c.b.d.a aVar : bVar.c()) {
            if (aVar != null && TextUtils.equals(aVar.a(), str)) {
                return aVar.b();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] g(d.c.c.b.d.b bVar) throws IOException, com.bytedance.sdk.adnet.err.f {
        RandomAccessFile randomAccessFile;
        int i;
        InputStream inputStream;
        int i2;
        int i3;
        long b2 = bVar.b();
        if (b2 <= 0) {
            q.c("Response doesn't present Content-Length!", new Object[0]);
        }
        long length = k().length();
        boolean i4 = i(bVar);
        if (i4) {
            b2 += length;
            String f2 = f(bVar, "Content-Range");
            if (!TextUtils.isEmpty(f2)) {
                String str = "bytes " + length + "-" + (b2 - 1);
                if (TextUtils.indexOf(f2, str) == -1) {
                    throw new IllegalStateException("The Content-Range Header is invalid Assume[" + str + "] vs Real[" + f2 + "], please remove the temporary file [" + k() + "].");
                }
            }
        }
        if (b2 > 0 && j().length() == b2) {
            j().renameTo(k());
            a(b2, b2);
            return null;
        }
        if (j() != null && j().exists()) {
            j().delete();
        }
        try {
            randomAccessFile = new RandomAccessFile(k(), "rw");
            try {
                if (i4) {
                    randomAccessFile.seek(length);
                } else {
                    randomAccessFile.setLength(0L);
                    length = 0;
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        try {
            inputStream = bVar.a();
            try {
                if (h(bVar) && !(inputStream instanceof GZIPInputStream)) {
                    inputStream = new GZIPInputStream(inputStream);
                }
                byte[] bArr = new byte[1024];
                a(length, b2);
                do {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    randomAccessFile.write(bArr, 0, read);
                    length += read;
                    a(length, b2);
                } while (!isCanceled());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused3) {
                        i3 = 0;
                        q.a("Error occured when calling InputStream.close", new Object[0]);
                    }
                }
                i3 = 0;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused4) {
                        q.a("Error occured when calling consumingContent", new Object[i3]);
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (Throwable unused5) {
                    q.a("Error occured when calling tmpFile.close", new Object[i3]);
                }
            } catch (Throwable unused6) {
                i = 0;
                try {
                    q.a("Error occured when FileRequest.parseHttpResponse", new Object[i]);
                    l();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused7) {
                            q.a("Error occured when calling InputStream.close", new Object[i]);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused8) {
                            q.a("Error occured when calling consumingContent", new Object[i]);
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Throwable unused9) {
                        q.a("Error occured when calling tmpFile.close", new Object[i]);
                    }
                    return null;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused10) {
                            i2 = 0;
                            q.a("Error occured when calling InputStream.close", new Object[0]);
                            if (inputStream != null) {
                            }
                            randomAccessFile.close();
                            throw th;
                        }
                    }
                    i2 = 0;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused11) {
                            q.a("Error occured when calling consumingContent", new Object[i2]);
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Throwable unused12) {
                        q.a("Error occured when calling tmpFile.close", new Object[i2]);
                    }
                    throw th;
                }
            }
        } catch (Throwable unused13) {
            i = 0;
            inputStream = null;
        }
        return null;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
        HashMap hashMap = new HashMap();
        hashMap.put("Range", "bytes=" + this.y.length() + "-");
        hashMap.put("Accept-Encoding", "identity");
        return hashMap;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    public final boolean h(d.c.c.b.d.b bVar) {
        return TextUtils.equals(f(bVar, "Content-Encoding"), AsyncHttpClient.ENCODING_GZIP);
    }

    public final boolean i(d.c.c.b.d.b bVar) {
        if (TextUtils.equals(f(bVar, Util.ACCEPT_RANGES), "bytes")) {
            return true;
        }
        String f2 = f(bVar, "Content-Range");
        return f2 != null && f2.startsWith("bytes");
    }

    public File j() {
        return this.x;
    }

    public File k() {
        return this.y;
    }

    public final void l() {
        try {
            this.x.delete();
        } catch (Throwable unused) {
        }
        try {
            this.y.delete();
        } catch (Throwable unused2) {
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(o<File> oVar) {
        o.a<File> aVar;
        synchronized (this.z) {
            aVar = this.A;
        }
        if (aVar != null) {
            aVar.a(o.c(this.x, oVar.f66585b));
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(long j, long j2) {
        o.a<File> aVar;
        synchronized (this.z) {
            aVar = this.A;
        }
        if (aVar instanceof a) {
            ((a) aVar).a(j, j2);
        }
    }
}
