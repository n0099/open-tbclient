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
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes8.dex */
public final class HashingSink extends ForwardingSink {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final Mac mac;
    @Nullable
    public final MessageDigest messageDigest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, String str) {
        super(sink);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sink, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Sink) newInitContext.callArgs[0]);
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

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j) == null) {
            Util.checkOffsetAndCount(buffer.size, 0L, j);
            Segment segment = buffer.head;
            long j2 = 0;
            while (j2 < j) {
                int min = (int) Math.min(j - j2, segment.limit - segment.pos);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, segment.pos, min);
                } else {
                    this.mac.update(segment.data, segment.pos, min);
                }
                j2 += min;
                segment = segment.next;
            }
            super.write(buffer, j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, ByteString byteString, String str) {
        super(sink);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sink, byteString, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Sink) newInitContext.callArgs[0]);
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

    public static HashingSink hmacSha1(Sink sink, ByteString byteString) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, sink, byteString)) == null) {
            return new HashingSink(sink, byteString, "HmacSHA1");
        }
        return (HashingSink) invokeLL.objValue;
    }

    public static HashingSink hmacSha256(Sink sink, ByteString byteString) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, sink, byteString)) == null) {
            return new HashingSink(sink, byteString, "HmacSHA256");
        }
        return (HashingSink) invokeLL.objValue;
    }

    public static HashingSink hmacSha512(Sink sink, ByteString byteString) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, sink, byteString)) == null) {
            return new HashingSink(sink, byteString, "HmacSHA512");
        }
        return (HashingSink) invokeLL.objValue;
    }

    public static HashingSink md5(Sink sink) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, sink)) == null) {
            return new HashingSink(sink, "MD5");
        }
        return (HashingSink) invokeL.objValue;
    }

    public static HashingSink sha1(Sink sink) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, sink)) == null) {
            return new HashingSink(sink, "SHA-1");
        }
        return (HashingSink) invokeL.objValue;
    }

    public static HashingSink sha256(Sink sink) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, sink)) == null) {
            return new HashingSink(sink, "SHA-256");
        }
        return (HashingSink) invokeL.objValue;
    }

    public static HashingSink sha512(Sink sink) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, sink)) == null) {
            return new HashingSink(sink, "SHA-512");
        }
        return (HashingSink) invokeL.objValue;
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
