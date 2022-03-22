package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
/* loaded from: classes8.dex */
public abstract class ResponseBody implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Reader reader;

    /* loaded from: classes8.dex */
    public static final class BomAwareReader extends Reader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Charset charset;
        public boolean closed;
        public Reader delegate;
        public final BufferedSource source;

        public BomAwareReader(BufferedSource bufferedSource, Charset charset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bufferedSource, charset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.source = bufferedSource;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.closed = true;
                Reader reader = this.delegate;
                if (reader != null) {
                    reader.close();
                } else {
                    this.source.close();
                }
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cArr, i, i2)) == null) {
                if (!this.closed) {
                    Reader reader = this.delegate;
                    if (reader == null) {
                        InputStreamReader inputStreamReader = new InputStreamReader(this.source.inputStream(), Util.bomAwareCharset(this.source, this.charset));
                        this.delegate = inputStreamReader;
                        reader = inputStreamReader;
                    }
                    return reader.read(cArr, i, i2);
                }
                throw new IOException("Stream closed");
            }
            return invokeLII.intValue;
        }
    }

    public ResponseBody() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private Charset charset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            MediaType contentType = contentType();
            return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
        }
        return (Charset) invokeV.objValue;
    }

    public static ResponseBody create(@Nullable MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, mediaType, str)) == null) {
            Charset charset = Util.UTF_8;
            if (mediaType != null && (charset = mediaType.charset()) == null) {
                charset = Util.UTF_8;
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            }
            Buffer writeString = new Buffer().writeString(str, charset);
            return create(mediaType, writeString.size(), writeString);
        }
        return (ResponseBody) invokeLL.objValue;
    }

    public final InputStream byteStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? source().inputStream() : (InputStream) invokeV.objValue;
    }

    public final byte[] bytes() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long contentLength = contentLength();
            if (contentLength <= 2147483647L) {
                BufferedSource source = source();
                try {
                    byte[] readByteArray = source.readByteArray();
                    Util.closeQuietly(source);
                    if (contentLength == -1 || contentLength == readByteArray.length) {
                        return readByteArray;
                    }
                    throw new IOException("Content-Length (" + contentLength + ") and stream length (" + readByteArray.length + ") disagree");
                } catch (Throwable th) {
                    Util.closeQuietly(source);
                    throw th;
                }
            }
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        return (byte[]) invokeV.objValue;
    }

    public final Reader charStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Reader reader = this.reader;
            if (reader != null) {
                return reader;
            }
            BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
            this.reader = bomAwareReader;
            return bomAwareReader;
        }
        return (Reader) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Util.closeQuietly(source());
        }
    }

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BufferedSource source = source();
            try {
                return source.readString(Util.bomAwareCharset(source, charset()));
            } finally {
                Util.closeQuietly(source);
            }
        }
        return (String) invokeV.objValue;
    }

    public static ResponseBody create(@Nullable MediaType mediaType, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, mediaType, bArr)) == null) ? create(mediaType, bArr.length, new Buffer().write(bArr)) : (ResponseBody) invokeLL.objValue;
    }

    public static ResponseBody create(@Nullable MediaType mediaType, ByteString byteString) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaType, byteString)) == null) ? create(mediaType, byteString.size(), new Buffer().write(byteString)) : (ResponseBody) invokeLL.objValue;
    }

    public static ResponseBody create(@Nullable MediaType mediaType, long j, BufferedSource bufferedSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{mediaType, Long.valueOf(j), bufferedSource})) == null) {
            if (bufferedSource != null) {
                return new ResponseBody(mediaType, j, bufferedSource) { // from class: okhttp3.ResponseBody.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BufferedSource val$content;
                    public final /* synthetic */ long val$contentLength;
                    public final /* synthetic */ MediaType val$contentType;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {mediaType, Long.valueOf(j), bufferedSource};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$contentType = mediaType;
                        this.val$contentLength = j;
                        this.val$content = bufferedSource;
                    }

                    @Override // okhttp3.ResponseBody
                    public long contentLength() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$contentLength : invokeV.longValue;
                    }

                    @Override // okhttp3.ResponseBody
                    @Nullable
                    public MediaType contentType() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$contentType : (MediaType) invokeV.objValue;
                    }

                    @Override // okhttp3.ResponseBody
                    public BufferedSource source() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.val$content : (BufferedSource) invokeV.objValue;
                    }
                };
            }
            throw new NullPointerException("source == null");
        }
        return (ResponseBody) invokeCommon.objValue;
    }
}
