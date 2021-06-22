package d.a.m0.e.o.a.d;

import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.IMPushUploadConstants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.swan.facade.requred.openstat.imupload.log.model.Bimlog$LogRequest;
import com.baidu.swan.facade.requred.openstat.imupload.log.model.Bimlog$LogResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f50344b;

    /* renamed from: a  reason: collision with root package name */
    public OkHttpClient f50345a = c();

    /* loaded from: classes3.dex */
    public class a implements Interceptor {

        /* renamed from: d.a.m0.e.o.a.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1027a extends RequestBody {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RequestBody f50346a;

            public C1027a(a aVar, RequestBody requestBody) {
                this.f50346a = requestBody;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return this.f50346a.contentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(@NonNull BufferedSink bufferedSink) {
                BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                try {
                    this.f50346a.writeTo(buffer);
                    buffer.close();
                } catch (IOException unused) {
                }
            }
        }

        public a(b bVar) {
        }

        public final RequestBody a(RequestBody requestBody) {
            return new C1027a(this, requestBody);
        }

        @Override // okhttp3.Interceptor
        public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            if (request.body() != null && request.header("Content-Encoding") == null) {
                return chain.proceed(request.newBuilder().header("Content-Encoding", AsyncHttpClient.ENCODING_GZIP).method(request.method(), a(request.body())).build());
            }
            return chain.proceed(request);
        }
    }

    public static b d() {
        if (f50344b == null) {
            f50344b = new b();
        }
        return f50344b;
    }

    @NonNull
    public final RequestBody a(@NonNull byte[] bArr, @NonNull String str) {
        return RequestBody.create(MediaType.parse("application/proto"), b(bArr, str));
    }

    @NonNull
    public final byte[] b(@NonNull byte[] bArr, String str) {
        Bimlog$LogRequest.AuthInfo.b newBuilder = Bimlog$LogRequest.AuthInfo.newBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        newBuilder.u(str);
        Bimlog$LogRequest.AuthInfo build = newBuilder.build();
        long currentTimeMillis = System.currentTimeMillis();
        Bimlog$LogRequest.b newBuilder2 = Bimlog$LogRequest.newBuilder();
        newBuilder2.A(1L);
        newBuilder2.y("smart_app");
        newBuilder2.v(build);
        newBuilder2.x(currentTimeMillis);
        newBuilder2.z(d.a.m0.e.o.a.d.a.b("smart_app", currentTimeMillis));
        newBuilder2.w(ByteString.copyFrom(bArr));
        return newBuilder2.build().toByteArray();
    }

    @NonNull
    public final OkHttpClient c() {
        return new OkHttpClient.Builder().protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)).pingInterval(1000L, TimeUnit.MILLISECONDS).addInterceptor(new a(this)).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectionPool(new ConnectionPool()).build();
    }

    @NonNull
    public final Request e(@NonNull Map<String, String> map, @NonNull byte[] bArr, String str, String str2) {
        ArrayMap arrayMap = new ArrayMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayMap.put("ls-" + entry.getKey(), h(entry.getValue()));
        }
        arrayMap.put(IMPushUploadConstants.BIM_LOG_ID, h(str2));
        return new Request.Builder().addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE).addHeader("Content-Type", "application/proto").headers(Headers.of(arrayMap)).url("https://pimlog.baidu.com/LogService/Log").post(a(bArr, str)).build();
    }

    @NonNull
    public final String[] f(@NonNull byte[] bArr) {
        try {
            Bimlog$LogResponse parseFrom = Bimlog$LogResponse.parseFrom(bArr);
            if (this.f50345a.pingIntervalMillis() != parseFrom.getPingIntervalMs()) {
                this.f50345a.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS);
                this.f50345a = this.f50345a.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS).build();
            }
            return new String[]{String.valueOf(parseFrom.getErrorCode()), parseFrom.getErrorMsg()};
        } catch (InvalidProtocolBufferException unused) {
            return new String[]{String.valueOf(-1), "parseResponse exception"};
        }
    }

    public void g(@NonNull Map<String, String> map, @NonNull byte[] bArr, String str, c cVar) {
        if (cVar == null) {
            return;
        }
        Request e2 = e(map, bArr, str, "" + ((int) ((Math.random() * 100000.0d) + 10000.0d)));
        if (this.f50345a == null) {
            this.f50345a = c();
        }
        try {
            Response execute = this.f50345a.newCall(e2).execute();
            try {
                if (execute.body() != null) {
                    String[] f2 = f(execute.body().bytes());
                    cVar.f50347a = Integer.valueOf(f2[0]).intValue();
                    cVar.f50348b = f2[1];
                }
            } catch (IOException unused) {
            }
        } catch (IOException e3) {
            String str2 = "Request error :" + e3.toString();
            if (e3 instanceof SocketException) {
                str2 = "Request SocketException :" + e3.toString();
            }
            cVar.f50347a = -1;
            cVar.f50348b = str2;
        }
    }

    public final String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
