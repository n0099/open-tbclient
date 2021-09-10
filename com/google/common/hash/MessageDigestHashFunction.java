package com.google.common.hash;

import c.i.d.a.n;
import c.i.d.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* loaded from: classes10.dex */
public final class MessageDigestHashFunction extends c.i.d.d.b implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bytes;
    public final MessageDigest prototype;
    public final boolean supportsClone;
    public final String toString;

    /* loaded from: classes10.dex */
    public static final class SerializedForm implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final String algorithmName;
        public final int bytes;
        public final String toString;

        public /* synthetic */ SerializedForm(String str, int i2, String str2, a aVar) {
            this(str, i2, str2);
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString) : invokeV.objValue;
        }

        public SerializedForm(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.algorithmName = str;
            this.bytes = i2;
            this.toString = str2;
        }
    }

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static final class b extends c.i.d.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final MessageDigest f70804b;

        /* renamed from: c  reason: collision with root package name */
        public final int f70805c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f70806d;

        public /* synthetic */ b(MessageDigest messageDigest, int i2, a aVar) {
            this(messageDigest, i2);
        }

        @Override // c.i.d.d.f
        public HashCode e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                q();
                this.f70806d = true;
                if (this.f70805c == this.f70804b.getDigestLength()) {
                    return HashCode.fromBytesNoCopy(this.f70804b.digest());
                }
                return HashCode.fromBytesNoCopy(Arrays.copyOf(this.f70804b.digest(), this.f70805c));
            }
            return (HashCode) invokeV.objValue;
        }

        @Override // c.i.d.d.a
        public void m(byte b2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2) == null) {
                q();
                this.f70804b.update(b2);
            }
        }

        @Override // c.i.d.d.a
        public void n(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
                q();
                this.f70804b.update(byteBuffer);
            }
        }

        @Override // c.i.d.d.a
        public void p(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
                q();
                this.f70804b.update(bArr, i2, i3);
            }
        }

        public final void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                n.x(!this.f70806d, "Cannot re-use a Hasher after calling hash() on it");
            }
        }

        public b(MessageDigest messageDigest, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageDigest, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70804b = messageDigest;
            this.f70805c = i2;
        }
    }

    public MessageDigestHashFunction(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        this.bytes = messageDigest.getDigestLength();
        n.p(str2);
        this.toString = str2;
        this.supportsClone = supportsClone(this.prototype);
    }

    public static MessageDigest getMessageDigest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException e2) {
                throw new AssertionError(e2);
            }
        }
        return (MessageDigest) invokeL.objValue;
    }

    public static boolean supportsClone(MessageDigest messageDigest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, messageDigest)) == null) {
            try {
                messageDigest.clone();
                return true;
            } catch (CloneNotSupportedException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public int bits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bytes * 8 : invokeV.intValue;
    }

    @Override // c.i.d.d.e
    public f newHasher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.supportsClone) {
                try {
                    return new b((MessageDigest) this.prototype.clone(), this.bytes, null);
                } catch (CloneNotSupportedException unused) {
                }
            }
            return new b(getMessageDigest(this.prototype.getAlgorithm()), this.bytes, null);
        }
        return (f) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.toString : (String) invokeV.objValue;
    }

    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null) : invokeV.objValue;
    }

    public MessageDigestHashFunction(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(str2);
        this.toString = str2;
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        int digestLength = messageDigest.getDigestLength();
        n.g(i2 >= 4 && i2 <= digestLength, "bytes (%s) must be >= 4 and < %s", i2, digestLength);
        this.bytes = i2;
        this.supportsClone = supportsClone(this.prototype);
    }
}
