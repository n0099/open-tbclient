package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidubce.http.Headers;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.v;
import com.xiaomi.mipush.sdk.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class l implements HttpDataSource {
    private static final Pattern mGs = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> mGt = new AtomicReference<>();
    private long bytesRead;
    private g dataSpec;
    private InputStream inputStream;
    private final q<? super l> mFJ;
    private boolean mFK;
    private HttpURLConnection mGA;
    private long mGB;
    private long mGC;
    private long mGD;
    private final boolean mGu;
    private final int mGv;
    private final int mGw;
    private final com.google.android.exoplayer2.util.n<String> mGx;
    private final HttpDataSource.b mGy;
    private final HttpDataSource.b mGz = new HttpDataSource.b();
    private final String userAgent;

    public l(String str, com.google.android.exoplayer2.util.n<String> nVar, q<? super l> qVar, int i, int i2, boolean z, HttpDataSource.b bVar) {
        this.userAgent = com.google.android.exoplayer2.util.a.checkNotEmpty(str);
        this.mGx = nVar;
        this.mFJ = qVar;
        this.mGv = i;
        this.mGw = i2;
        this.mGu = z;
        this.mGy = bVar;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        if (this.mGA == null) {
            return null;
        }
        return Uri.parse(this.mGA.getURL().toString());
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws HttpDataSource.HttpDataSourceException {
        long j = 0;
        this.dataSpec = gVar;
        this.bytesRead = 0L;
        this.mGD = 0L;
        try {
            this.mGA = b(gVar);
            try {
                int responseCode = this.mGA.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = this.mGA.getHeaderFields();
                    dzh();
                    HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(responseCode, headerFields, gVar);
                    if (responseCode == 416) {
                        invalidResponseCodeException.initCause(new DataSourceException(0));
                    }
                    throw invalidResponseCodeException;
                }
                String contentType = this.mGA.getContentType();
                if (this.mGx != null && !this.mGx.bC(contentType)) {
                    dzh();
                    throw new HttpDataSource.InvalidContentTypeException(contentType, gVar);
                }
                if (responseCode == 200 && gVar.fOb != 0) {
                    j = gVar.fOb;
                }
                this.mGB = j;
                if (!gVar.LQ(1)) {
                    if (gVar.length != -1) {
                        this.mGC = gVar.length;
                    } else {
                        long i = i(this.mGA);
                        this.mGC = i != -1 ? i - this.mGB : -1L;
                    }
                } else {
                    this.mGC = gVar.length;
                }
                try {
                    this.inputStream = this.mGA.getInputStream();
                    this.mFK = true;
                    if (this.mFJ != null) {
                        this.mFJ.a(this, gVar);
                    }
                    return this.mGC;
                } catch (IOException e) {
                    dzh();
                    throw new HttpDataSource.HttpDataSourceException(e, gVar, 1);
                }
            } catch (IOException e2) {
                dzh();
                throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + gVar.uri.toString(), e2, gVar, 1);
            }
        } catch (IOException e3) {
            throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + gVar.uri.toString(), e3, gVar, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            dzg();
            return readInternal(bArr, i, i2);
        } catch (IOException e) {
            throw new HttpDataSource.HttpDataSourceException(e, this.dataSpec, 2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            if (this.inputStream != null) {
                a(this.mGA, dzf());
                try {
                    this.inputStream.close();
                } catch (IOException e) {
                    throw new HttpDataSource.HttpDataSourceException(e, this.dataSpec, 3);
                }
            }
        } finally {
            this.inputStream = null;
            dzh();
            if (this.mFK) {
                this.mFK = false;
                if (this.mFJ != null) {
                    this.mFJ.bB(this);
                }
            }
        }
    }

    protected final long dzf() {
        return this.mGC == -1 ? this.mGC : this.mGC - this.bytesRead;
    }

    private HttpURLConnection b(g gVar) throws IOException {
        URL url = new URL(gVar.uri.toString());
        byte[] bArr = gVar.mFP;
        long j = gVar.fOb;
        long j2 = gVar.length;
        boolean LQ = gVar.LQ(1);
        if (!this.mGu) {
            return a(url, bArr, j, j2, LQ, true);
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i <= 20) {
                HttpURLConnection a = a(url, bArr, j, j2, LQ, false);
                int responseCode = a.getResponseCode();
                if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303) {
                    if (bArr != null) {
                        return a;
                    }
                    if (responseCode != 307 && responseCode != 308) {
                        return a;
                    }
                }
                bArr = null;
                String headerField = a.getHeaderField(Headers.LOCATION);
                a.disconnect();
                url = a(url, headerField);
                i = i2;
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i2);
            }
        }
    }

    private HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.mGv);
        httpURLConnection.setReadTimeout(this.mGw);
        if (this.mGy != null) {
            for (Map.Entry<String, String> entry : this.mGy.dzj().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.mGz.dzj().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty(Headers.RANGE, str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.userAgent);
        if (!z) {
            httpURLConnection.setRequestProperty(Headers.ACCEPT_ENCODING, "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static URL a(URL url, String str) throws IOException {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if (!"https".equals(protocol) && !HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
            throw new ProtocolException("Unsupported protocol redirect: " + protocol);
        }
        return url2;
    }

    private static long i(HttpURLConnection httpURLConnection) {
        long j = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException e) {
                Log.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]");
            }
        }
        String headerField2 = httpURLConnection.getHeaderField(Headers.CONTENT_RANGE);
        if (!TextUtils.isEmpty(headerField2)) {
            Matcher matcher = mGs.matcher(headerField2);
            if (matcher.find()) {
                try {
                    long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                    if (j < 0) {
                        return parseLong;
                    }
                    if (j != parseLong) {
                        Log.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
                        return Math.max(j, parseLong);
                    }
                    return j;
                } catch (NumberFormatException e2) {
                    Log.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]");
                    return j;
                }
            }
            return j;
        }
        return j;
    }

    private void dzg() throws IOException {
        if (this.mGD != this.mGB) {
            byte[] andSet = mGt.getAndSet(null);
            if (andSet == null) {
                andSet = new byte[4096];
            }
            while (this.mGD != this.mGB) {
                int read = this.inputStream.read(andSet, 0, (int) Math.min(this.mGB - this.mGD, andSet.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                }
                if (read == -1) {
                    throw new EOFException();
                }
                this.mGD += read;
                if (this.mFJ != null) {
                    this.mFJ.h(this, read);
                }
            }
            mGt.set(andSet);
        }
    }

    private int readInternal(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.mGC != -1) {
            long j = this.mGC - this.bytesRead;
            if (j == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j);
        }
        int read = this.inputStream.read(bArr, i, i2);
        if (read == -1) {
            if (this.mGC != -1) {
                throw new EOFException();
            }
            return -1;
        }
        this.bytesRead += read;
        if (this.mFJ != null) {
            this.mFJ.h(this, read);
        }
        return read;
    }

    private static void a(HttpURLConnection httpURLConnection, long j) {
        if (v.SDK_INT == 19 || v.SDK_INT == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception e) {
            }
        }
    }

    private void dzh() {
        if (this.mGA != null) {
            try {
                this.mGA.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.mGA = null;
        }
    }
}
