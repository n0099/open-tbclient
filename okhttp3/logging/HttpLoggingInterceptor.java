package okhttp3.logging;

import com.android.internal.http.multipart.Part;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Platform;
import okhttp3.internal.http.HttpEngine;
import okio.Buffer;
import okio.BufferedSource;
/* loaded from: classes9.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final Charset UTF8;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Level level;
    public final Logger logger;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Level {
        public static final /* synthetic */ Level[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Level BASIC;
        public static final Level BODY;
        public static final Level HEADERS;
        public static final Level NONE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(767722865, "Lokhttp3/logging/HttpLoggingInterceptor$Level;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(767722865, "Lokhttp3/logging/HttpLoggingInterceptor$Level;");
                    return;
                }
            }
            NONE = new Level("NONE", 0);
            BASIC = new Level("BASIC", 1);
            HEADERS = new Level("HEADERS", 2);
            Level level = new Level("BODY", 3);
            BODY = level;
            $VALUES = new Level[]{NONE, BASIC, HEADERS, level};
        }

        public Level(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Level valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Level) Enum.valueOf(Level.class, str) : (Level) invokeL.objValue;
        }

        public static Level[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Level[]) $VALUES.clone() : (Level[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: okhttp3.logging.HttpLoggingInterceptor.Logger.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public void log(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    Platform.get().log(str);
                }
            }
        };

        void log(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(722427825, "Lokhttp3/logging/HttpLoggingInterceptor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(722427825, "Lokhttp3/logging/HttpLoggingInterceptor;");
                return;
            }
        }
        UTF8 = Charset.forName("UTF-8");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Logger) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private boolean bodyEncoded(Headers headers) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, headers)) == null) {
            String str = headers.get("Content-Encoding");
            return (str == null || str.equalsIgnoreCase("identity")) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public Level getLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.level : (Level) invokeV.objValue;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Headers headers;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain)) == null) {
            Level level = this.level;
            Request request = chain.request();
            if (level == Level.NONE) {
                return chain.proceed(request);
            }
            boolean z = level == Level.BODY;
            boolean z2 = z || level == Level.HEADERS;
            RequestBody body = request.body();
            boolean z3 = body != null;
            Connection connection = chain.connection();
            String str = "--> " + request.method() + ' ' + request.url() + ' ' + (connection != null ? connection.protocol() : Protocol.HTTP_1_1);
            if (!z2 && z3) {
                str = str + " (" + body.contentLength() + "-byte body)";
            }
            this.logger.log(str);
            if (z2) {
                if (z3) {
                    if (body.contentType() != null) {
                        this.logger.log(Part.CONTENT_TYPE + body.contentType());
                    }
                    if (body.contentLength() != -1) {
                        this.logger.log("Content-Length: " + body.contentLength());
                    }
                }
                Headers headers2 = request.headers();
                int size = headers2.size();
                int i3 = 0;
                while (i3 < size) {
                    String name = headers2.name(i3);
                    if ("Content-Type".equalsIgnoreCase(name) || "Content-Length".equalsIgnoreCase(name)) {
                        i2 = size;
                    } else {
                        i2 = size;
                        this.logger.log(name + ": " + headers2.value(i3));
                    }
                    i3++;
                    size = i2;
                }
                if (z && z3) {
                    if (bodyEncoded(request.headers())) {
                        this.logger.log("--> END " + request.method() + " (encoded body omitted)");
                    } else {
                        Buffer buffer = new Buffer();
                        body.writeTo(buffer);
                        Charset charset = UTF8;
                        MediaType contentType = body.contentType();
                        if (contentType != null) {
                            charset = contentType.charset(UTF8);
                        }
                        this.logger.log("");
                        this.logger.log(buffer.readString(charset));
                        this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                    }
                } else {
                    this.logger.log("--> END " + request.method());
                }
            }
            long nanoTime = System.nanoTime();
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            String str2 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("<-- ");
            sb.append(proceed.code());
            sb.append(' ');
            sb.append(proceed.message());
            sb.append(' ');
            sb.append(proceed.request().url());
            sb.append(" (");
            sb.append(millis);
            sb.append("ms");
            sb.append(z2 ? "" : StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + " body");
            sb.append(')');
            logger.log(sb.toString());
            if (z2) {
                int size2 = proceed.headers().size();
                for (int i4 = 0; i4 < size2; i4++) {
                    this.logger.log(headers.name(i4) + ": " + headers.value(i4));
                }
                if (z && HttpEngine.hasBody(proceed)) {
                    if (bodyEncoded(proceed.headers())) {
                        this.logger.log("<-- END HTTP (encoded body omitted)");
                    } else {
                        BufferedSource source = body2.source();
                        source.request(Long.MAX_VALUE);
                        Buffer buffer2 = source.buffer();
                        Charset charset2 = UTF8;
                        MediaType contentType2 = body2.contentType();
                        if (contentType2 != null) {
                            try {
                                charset2 = contentType2.charset(UTF8);
                            } catch (UnsupportedCharsetException unused) {
                                this.logger.log("");
                                this.logger.log("Couldn't decode the response body; charset is likely malformed.");
                                this.logger.log("<-- END HTTP");
                                return proceed;
                            }
                        }
                        if (contentLength != 0) {
                            this.logger.log("");
                            this.logger.log(buffer2.clone().readString(charset2));
                        }
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    }
                } else {
                    this.logger.log("<-- END HTTP");
                }
            }
            return proceed;
        }
        return (Response) invokeL.objValue;
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, level)) == null) {
            if (level != null) {
                this.level = level;
                return this;
            }
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        return (HttpLoggingInterceptor) invokeL.objValue;
    }

    public HttpLoggingInterceptor(Logger logger) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {logger};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.level = Level.NONE;
        this.logger = logger;
    }
}
