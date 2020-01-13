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
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class l implements HttpDataSource {
    private static final Pattern mFF = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> mFG = new AtomicReference<>();
    private long bytesRead;
    private g dataSpec;
    private InputStream inputStream;
    private final q<? super l> mEV;
    private boolean mEW;
    private final boolean mFH;
    private final int mFI;
    private final int mFJ;
    private final com.google.android.exoplayer2.util.n<String> mFK;
    private final HttpDataSource.b mFL;
    private final HttpDataSource.b mFM = new HttpDataSource.b();
    private HttpURLConnection mFN;
    private long mFO;
    private long mFP;
    private long mFQ;
    private final String userAgent;

    public l(String str, com.google.android.exoplayer2.util.n<String> nVar, q<? super l> qVar, int i, int i2, boolean z, HttpDataSource.b bVar) {
        this.userAgent = com.google.android.exoplayer2.util.a.checkNotEmpty(str);
        this.mFK = nVar;
        this.mEV = qVar;
        this.mFI = i;
        this.mFJ = i2;
        this.mFH = z;
        this.mFL = bVar;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        if (this.mFN == null) {
            return null;
        }
        return Uri.parse(this.mFN.getURL().toString());
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws HttpDataSource.HttpDataSourceException {
        long j = 0;
        this.dataSpec = gVar;
        this.bytesRead = 0L;
        this.mFQ = 0L;
        try {
            this.mFN = b(gVar);
            try {
                int responseCode = this.mFN.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = this.mFN.getHeaderFields();
                    dxT();
                    HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(responseCode, headerFields, gVar);
                    if (responseCode == 416) {
                        invalidResponseCodeException.initCause(new DataSourceException(0));
                    }
                    throw invalidResponseCodeException;
                }
                String contentType = this.mFN.getContentType();
                if (this.mFK != null && !this.mFK.bA(contentType)) {
                    dxT();
                    throw new HttpDataSource.InvalidContentTypeException(contentType, gVar);
                }
                if (responseCode == 200 && gVar.fLD != 0) {
                    j = gVar.fLD;
                }
                this.mFO = j;
                if (!gVar.LL(1)) {
                    if (gVar.length != -1) {
                        this.mFP = gVar.length;
                    } else {
                        long i = i(this.mFN);
                        this.mFP = i != -1 ? i - this.mFO : -1L;
                    }
                } else {
                    this.mFP = gVar.length;
                }
                try {
                    this.inputStream = this.mFN.getInputStream();
                    this.mEW = true;
                    if (this.mEV != null) {
                        this.mEV.a(this, gVar);
                    }
                    return this.mFP;
                } catch (IOException e) {
                    dxT();
                    throw new HttpDataSource.HttpDataSourceException(e, gVar, 1);
                }
            } catch (IOException e2) {
                dxT();
                throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + gVar.uri.toString(), e2, gVar, 1);
            }
        } catch (IOException e3) {
            throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + gVar.uri.toString(), e3, gVar, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            dxS();
            return readInternal(bArr, i, i2);
        } catch (IOException e) {
            throw new HttpDataSource.HttpDataSourceException(e, this.dataSpec, 2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            if (this.inputStream != null) {
                a(this.mFN, dxR());
                try {
                    this.inputStream.close();
                } catch (IOException e) {
                    throw new HttpDataSource.HttpDataSourceException(e, this.dataSpec, 3);
                }
            }
        } finally {
            this.inputStream = null;
            dxT();
            if (this.mEW) {
                this.mEW = false;
                if (this.mEV != null) {
                    this.mEV.bz(this);
                }
            }
        }
    }

    protected final long dxR() {
        return this.mFP == -1 ? this.mFP : this.mFP - this.bytesRead;
    }

    private HttpURLConnection b(g gVar) throws IOException {
        URL url = new URL(gVar.uri.toString());
        byte[] bArr = gVar.mFb;
        long j = gVar.fLD;
        long j2 = gVar.length;
        boolean LL = gVar.LL(1);
        if (!this.mFH) {
            return a(url, bArr, j, j2, LL, true);
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i <= 20) {
                HttpURLConnection a = a(url, bArr, j, j2, LL, false);
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
        httpURLConnection.setConnectTimeout(this.mFI);
        httpURLConnection.setReadTimeout(this.mFJ);
        if (this.mFL != null) {
            for (Map.Entry<String, String> entry : this.mFL.dxV().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.mFM.dxV().entrySet()) {
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
            httpURLConnection.setRequestProperty(Headers.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
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
            Matcher matcher = mFF.matcher(headerField2);
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

    private void dxS() throws IOException {
        if (this.mFQ != this.mFO) {
            byte[] andSet = mFG.getAndSet(null);
            if (andSet == null) {
                andSet = new byte[4096];
            }
            while (this.mFQ != this.mFO) {
                int read = this.inputStream.read(andSet, 0, (int) Math.min(this.mFO - this.mFQ, andSet.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                }
                if (read == -1) {
                    throw new EOFException();
                }
                this.mFQ += read;
                if (this.mEV != null) {
                    this.mEV.h(this, read);
                }
            }
            mFG.set(andSet);
        }
    }

    private int readInternal(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.mFP != -1) {
            long j = this.mFP - this.bytesRead;
            if (j == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j);
        }
        int read = this.inputStream.read(bArr, i, i2);
        if (read == -1) {
            if (this.mFP != -1) {
                throw new EOFException();
            }
            return -1;
        }
        this.bytesRead += read;
        if (this.mEV != null) {
            this.mEV.h(this, read);
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

    private void dxT() {
        if (this.mFN != null) {
            try {
                this.mFN.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.mFN = null;
        }
    }
}
