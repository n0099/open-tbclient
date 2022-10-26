package okio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes8.dex */
public final class HashingSource extends ForwardingSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Mac mac;
    public final MessageDigest messageDigest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, String str) {
        super(source);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {source, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Source) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.messageDigest = MessageDigest.getInstance(str);
            this.mac = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
            long read = super.read(buffer, j);
            if (read != -1) {
                long j2 = buffer.size;
                long j3 = j2 - read;
                Segment segment = buffer.head;
                while (j2 > j3) {
                    segment = segment.prev;
                    j2 -= segment.limit - segment.pos;
                }
                while (j2 < buffer.size) {
                    int i = (int) ((segment.pos + j3) - j2);
                    MessageDigest messageDigest = this.messageDigest;
                    if (messageDigest != null) {
                        messageDigest.update(segment.data, i, segment.limit - i);
                    } else {
                        this.mac.update(segment.data, i, segment.limit - i);
                    }
                    j3 = (segment.limit - segment.pos) + j2;
                    segment = segment.next;
                    j2 = j3;
                }
            }
            return read;
        }
        return invokeLJ.longValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, ByteString byteString, String str) {
        super(source);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {source, byteString, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Source) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            Mac mac = Mac.getInstance(str);
            this.mac = mac;
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.messageDigest = null;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSource hmacSha1(Source source, ByteString byteString) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, source, byteString)) == null) {
            return new HashingSource(source, byteString, "HmacSHA1");
        }
        return (HashingSource) invokeLL.objValue;
    }

    public static HashingSource hmacSha256(Source source, ByteString byteString) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, source, byteString)) == null) {
            return new HashingSource(source, byteString, "HmacSHA256");
        }
        return (HashingSource) invokeLL.objValue;
    }

    public static HashingSource md5(Source source) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, source)) == null) {
            return new HashingSource(source, "MD5");
        }
        return (HashingSource) invokeL.objValue;
    }

    public static HashingSource sha1(Source source) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, source)) == null) {
            return new HashingSource(source, "SHA-1");
        }
        return (HashingSource) invokeL.objValue;
    }

    public static HashingSource sha256(Source source) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, source)) == null) {
            return new HashingSource(source, "SHA-256");
        }
        return (HashingSource) invokeL.objValue;
    }

    public ByteString hash() {
        InterceptResult invokeV;
        byte[] doFinal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                doFinal = messageDigest.digest();
            } else {
                doFinal = this.mac.doFinal();
            }
            return ByteString.of(doFinal);
        }
        return (ByteString) invokeV.objValue;
    }
}
