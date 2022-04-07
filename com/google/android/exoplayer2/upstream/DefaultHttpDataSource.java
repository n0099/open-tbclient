package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.util.Util;
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
/* loaded from: classes4.dex */
public class DefaultHttpDataSource implements HttpDataSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern CONTENT_RANGE_HEADER;
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    public static final long MAX_BYTES_TO_DRAIN = 2048;
    public static final int MAX_REDIRECTS = 20;
    public static final String TAG = "DefaultHttpDataSource";
    public static final AtomicReference<byte[]> skipBufferReference;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean allowCrossProtocolRedirects;
    public long bytesRead;
    public long bytesSkipped;
    public long bytesToRead;
    public long bytesToSkip;
    public final int connectTimeoutMillis;
    public HttpURLConnection connection;
    public final Predicate<String> contentTypePredicate;
    public DataSpec dataSpec;
    public final HttpDataSource.RequestProperties defaultRequestProperties;
    public InputStream inputStream;
    public final TransferListener<? super DefaultHttpDataSource> listener;
    public boolean opened;
    public final int readTimeoutMillis;
    public final HttpDataSource.RequestProperties requestProperties;
    public final String userAgent;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-79009213, "Lcom/google/android/exoplayer2/upstream/DefaultHttpDataSource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-79009213, "Lcom/google/android/exoplayer2/upstream/DefaultHttpDataSource;");
                return;
            }
        }
        CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
        skipBufferReference = new AtomicReference<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultHttpDataSource(String str, Predicate<String> predicate) {
        this(str, predicate, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, predicate};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Predicate) objArr2[1], (TransferListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (httpURLConnection = this.connection) == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Exception e) {
            Log.e(TAG, "Unexpected error while disconnecting", e);
        }
        this.connection = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getContentLength(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        long parseLong;
        String headerField;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65542, null, httpURLConnection)) != null) {
            return invokeL.longValue;
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                Log.e(TAG, "Unexpected Content-Length [" + headerField2 + PreferencesUtil.RIGHT_MOUNT);
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (TextUtils.isEmpty(headerField)) {
                Matcher matcher = CONTENT_RANGE_HEADER.matcher(headerField);
                if (matcher.find()) {
                    try {
                        long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                        if (parseLong < 0) {
                            return parseLong2;
                        }
                        if (parseLong != parseLong2) {
                            Log.w(TAG, "Inconsistent headers [" + headerField2 + "] [" + headerField + PreferencesUtil.RIGHT_MOUNT);
                            return Math.max(parseLong, parseLong2);
                        }
                        return parseLong;
                    } catch (NumberFormatException unused2) {
                        Log.e(TAG, "Unexpected Content-Range [" + headerField + PreferencesUtil.RIGHT_MOUNT);
                        return parseLong;
                    }
                }
                return parseLong;
            }
            return parseLong;
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField)) {
        }
    }

    public static URL handleRedirect(URL url, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, url, str)) == null) {
            if (str != null) {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if ("https".equals(protocol) || "http".equals(protocol)) {
                    return url2;
                }
                throw new ProtocolException("Unsupported protocol redirect: " + protocol);
            }
            throw new ProtocolException("Null location redirect");
        }
        return (URL) invokeLL.objValue;
    }

    private HttpURLConnection makeConnection(DataSpec dataSpec) throws IOException {
        InterceptResult invokeL;
        HttpURLConnection makeConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, dataSpec)) == null) {
            URL url = new URL(dataSpec.uri.toString());
            byte[] bArr = dataSpec.postBody;
            long j = dataSpec.position;
            long j2 = dataSpec.length;
            boolean isFlagSet = dataSpec.isFlagSet(1);
            if (this.allowCrossProtocolRedirects) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        long j3 = j;
                        makeConnection = makeConnection(url, bArr, j, j2, isFlagSet, false);
                        int responseCode = makeConnection.getResponseCode();
                        if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                            bArr = null;
                            String headerField = makeConnection.getHeaderField(Headers.LOCATION);
                            makeConnection.disconnect();
                            url = handleRedirect(url, headerField);
                            i = i2;
                            j = j3;
                        }
                    } else {
                        throw new NoRouteToHostException("Too many redirects: " + i2);
                    }
                }
                return makeConnection;
            }
            return makeConnection(url, bArr, j, j2, isFlagSet, true);
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    public static void maybeTerminateInputStream(HttpURLConnection httpURLConnection, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65546, null, httpURLConnection, j) == null) {
            int i = Util.SDK_INT;
            if (i == 19 || i == 20) {
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
                } catch (Exception unused) {
                }
            }
        }
    }

    private int readInternal(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65547, this, bArr, i, i2)) == null) {
            if (i2 == 0) {
                return 0;
            }
            long j = this.bytesToRead;
            if (j != -1) {
                long j2 = j - this.bytesRead;
                if (j2 == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j2);
            }
            int read = this.inputStream.read(bArr, i, i2);
            if (read == -1) {
                if (this.bytesToRead == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.bytesRead += read;
            TransferListener<? super DefaultHttpDataSource> transferListener = this.listener;
            if (transferListener != null) {
                transferListener.onBytesTransferred(this, read);
            }
            return read;
        }
        return invokeLII.intValue;
    }

    private void skipInternal() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.bytesSkipped == this.bytesToSkip) {
            return;
        }
        byte[] andSet = skipBufferReference.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j = this.bytesSkipped;
            long j2 = this.bytesToSkip;
            if (j != j2) {
                int read = this.inputStream.read(andSet, 0, (int) Math.min(j2 - j, andSet.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                }
                if (read != -1) {
                    this.bytesSkipped += read;
                    TransferListener<? super DefaultHttpDataSource> transferListener = this.listener;
                    if (transferListener != null) {
                        transferListener.onBytesTransferred(this, read);
                    }
                } else {
                    throw new EOFException();
                }
            } else {
                skipBufferReference.set(andSet);
                return;
            }
        }
    }

    public final long bytesRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bytesRead : invokeV.longValue;
    }

    public final long bytesRemaining() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.bytesToRead;
            return j == -1 ? j : j - this.bytesRead;
        }
        return invokeV.longValue;
    }

    public final long bytesSkipped() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bytesSkipped : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.requestProperties.clear();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Assertions.checkNotNull(str);
            this.requestProperties.remove(str);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public void close() throws HttpDataSource.HttpDataSourceException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                if (this.inputStream != null) {
                    maybeTerminateInputStream(this.connection, bytesRemaining());
                    try {
                        this.inputStream.close();
                    } catch (IOException e) {
                        throw new HttpDataSource.HttpDataSourceException(e, this.dataSpec, 3);
                    }
                }
            } finally {
                this.inputStream = null;
                closeConnectionQuietly();
                if (this.opened) {
                    this.opened = false;
                    TransferListener<? super DefaultHttpDataSource> transferListener = this.listener;
                    if (transferListener != null) {
                        transferListener.onTransferEnd(this);
                    }
                }
            }
        }
    }

    public final HttpURLConnection getConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.connection : (HttpURLConnection) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public Map<String, List<String>> getResponseHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            HttpURLConnection httpURLConnection = this.connection;
            if (httpURLConnection == null) {
                return null;
            }
            return httpURLConnection.getHeaderFields();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HttpURLConnection httpURLConnection = this.connection;
            if (httpURLConnection == null) {
                return null;
            }
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        return (Uri) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, dataSpec)) == null) {
            this.dataSpec = dataSpec;
            long j = 0;
            this.bytesRead = 0L;
            this.bytesSkipped = 0L;
            try {
                HttpURLConnection makeConnection = makeConnection(dataSpec);
                this.connection = makeConnection;
                try {
                    int responseCode = makeConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode <= 299) {
                        String contentType = this.connection.getContentType();
                        Predicate<String> predicate = this.contentTypePredicate;
                        if (predicate != null && !predicate.evaluate(contentType)) {
                            closeConnectionQuietly();
                            throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec);
                        }
                        if (responseCode == 200) {
                            long j2 = dataSpec.position;
                            if (j2 != 0) {
                                j = j2;
                            }
                        }
                        this.bytesToSkip = j;
                        if (!dataSpec.isFlagSet(1)) {
                            long j3 = dataSpec.length;
                            if (j3 != -1) {
                                this.bytesToRead = j3;
                            } else {
                                long contentLength = getContentLength(this.connection);
                                this.bytesToRead = contentLength != -1 ? contentLength - this.bytesToSkip : -1L;
                            }
                        } else {
                            this.bytesToRead = dataSpec.length;
                        }
                        try {
                            this.inputStream = this.connection.getInputStream();
                            this.opened = true;
                            TransferListener<? super DefaultHttpDataSource> transferListener = this.listener;
                            if (transferListener != null) {
                                transferListener.onTransferStart(this, dataSpec);
                            }
                            return this.bytesToRead;
                        } catch (IOException e) {
                            closeConnectionQuietly();
                            throw new HttpDataSource.HttpDataSourceException(e, dataSpec, 1);
                        }
                    }
                    Map<String, List<String>> headerFields = this.connection.getHeaderFields();
                    closeConnectionQuietly();
                    HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(responseCode, headerFields, dataSpec);
                    if (responseCode == 416) {
                        invalidResponseCodeException.initCause(new DataSourceException(0));
                    }
                    throw invalidResponseCodeException;
                } catch (IOException e2) {
                    closeConnectionQuietly();
                    throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.uri.toString(), e2, dataSpec, 1);
                }
            } catch (IOException e3) {
                throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.uri.toString(), e3, dataSpec, 1);
            }
        }
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048586, this, bArr, i, i2)) == null) {
            try {
                skipInternal();
                return readInternal(bArr, i, i2);
            } catch (IOException e) {
                throw new HttpDataSource.HttpDataSourceException(e, this.dataSpec, 2);
            }
        }
        return invokeLII.intValue;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            Assertions.checkNotNull(str);
            Assertions.checkNotNull(str2);
            this.requestProperties.set(str, str2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener<? super DefaultHttpDataSource> transferListener) {
        this(str, predicate, transferListener, 8000, 8000);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, predicate, transferListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Predicate) objArr2[1], (TransferListener) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener<? super DefaultHttpDataSource> transferListener, int i, int i2) {
        this(str, predicate, transferListener, i, i2, false, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, predicate, transferListener, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Predicate) objArr2[1], (TransferListener) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue(), (HttpDataSource.RequestProperties) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener<? super DefaultHttpDataSource> transferListener, int i, int i2, boolean z, HttpDataSource.RequestProperties requestProperties) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, predicate, transferListener, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), requestProperties};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.userAgent = Assertions.checkNotEmpty(str);
        this.contentTypePredicate = predicate;
        this.listener = transferListener;
        this.requestProperties = new HttpDataSource.RequestProperties();
        this.connectTimeoutMillis = i;
        this.readTimeoutMillis = i2;
        this.allowCrossProtocolRedirects = z;
        this.defaultRequestProperties = requestProperties;
    }

    private HttpURLConnection makeConnection(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{url, bArr, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(this.connectTimeoutMillis);
            httpURLConnection.setReadTimeout(this.readTimeoutMillis);
            HttpDataSource.RequestProperties requestProperties = this.defaultRequestProperties;
            if (requestProperties != null) {
                for (Map.Entry<String, String> entry : requestProperties.getSnapshot().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry<String, String> entry2 : this.requestProperties.getSnapshot().entrySet()) {
                httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
            }
            if (j != 0 || j2 != -1) {
                String str = "bytes=" + j + "-";
                if (j2 != -1) {
                    str = str + ((j + j2) - 1);
                }
                httpURLConnection.setRequestProperty("Range", str);
            }
            httpURLConnection.setRequestProperty("User-Agent", this.userAgent);
            if (!z) {
                httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
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
        return (HttpURLConnection) invokeCommon.objValue;
    }
}
