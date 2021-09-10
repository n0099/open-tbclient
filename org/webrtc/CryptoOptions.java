package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class CryptoOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SFrame sframe;
    public final Srtp srtp;

    /* renamed from: org.webrtc.CryptoOptions$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean enableAes128Sha1_32CryptoCipher;
        public boolean enableEncryptedRtpHeaderExtensions;
        public boolean enableGcmCryptoSuites;
        public boolean requireFrameEncryption;

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public CryptoOptions createCryptoOptions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new CryptoOptions(this.enableGcmCryptoSuites, this.enableAes128Sha1_32CryptoCipher, this.enableEncryptedRtpHeaderExtensions, this.requireFrameEncryption, null) : (CryptoOptions) invokeV.objValue;
        }

        public Builder setEnableAes128Sha1_32CryptoCipher(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.enableAes128Sha1_32CryptoCipher = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableEncryptedRtpHeaderExtensions(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.enableEncryptedRtpHeaderExtensions = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableGcmCryptoSuites(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.enableGcmCryptoSuites = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setRequireFrameEncryption(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.requireFrameEncryption = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder() {
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
    }

    /* loaded from: classes2.dex */
    public final class SFrame {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean requireFrameEncryption;
        public final /* synthetic */ CryptoOptions this$0;

        public /* synthetic */ SFrame(CryptoOptions cryptoOptions, boolean z, AnonymousClass1 anonymousClass1) {
            this(cryptoOptions, z);
        }

        @CalledByNative("SFrame")
        public boolean getRequireFrameEncryption() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.requireFrameEncryption : invokeV.booleanValue;
        }

        public SFrame(CryptoOptions cryptoOptions, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cryptoOptions, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cryptoOptions;
            this.requireFrameEncryption = z;
        }
    }

    /* loaded from: classes2.dex */
    public final class Srtp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean enableAes128Sha1_32CryptoCipher;
        public final boolean enableEncryptedRtpHeaderExtensions;
        public final boolean enableGcmCryptoSuites;
        public final /* synthetic */ CryptoOptions this$0;

        public /* synthetic */ Srtp(CryptoOptions cryptoOptions, boolean z, boolean z2, boolean z3, AnonymousClass1 anonymousClass1) {
            this(cryptoOptions, z, z2, z3);
        }

        @CalledByNative("Srtp")
        public boolean getEnableAes128Sha1_32CryptoCipher() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.enableAes128Sha1_32CryptoCipher : invokeV.booleanValue;
        }

        @CalledByNative("Srtp")
        public boolean getEnableEncryptedRtpHeaderExtensions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.enableEncryptedRtpHeaderExtensions : invokeV.booleanValue;
        }

        @CalledByNative("Srtp")
        public boolean getEnableGcmCryptoSuites() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.enableGcmCryptoSuites : invokeV.booleanValue;
        }

        public Srtp(CryptoOptions cryptoOptions, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cryptoOptions, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cryptoOptions;
            this.enableGcmCryptoSuites = z;
            this.enableAes128Sha1_32CryptoCipher = z2;
            this.enableEncryptedRtpHeaderExtensions = z3;
        }
    }

    public /* synthetic */ CryptoOptions(boolean z, boolean z2, boolean z3, boolean z4, AnonymousClass1 anonymousClass1) {
        this(z, z2, z3, z4);
    }

    public static Builder builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder(null) : (Builder) invokeV.objValue;
    }

    @CalledByNative
    public SFrame getSFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.sframe : (SFrame) invokeV.objValue;
    }

    @CalledByNative
    public Srtp getSrtp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.srtp : (Srtp) invokeV.objValue;
    }

    public CryptoOptions(boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.srtp = new Srtp(this, z, z2, z3, null);
        this.sframe = new SFrame(this, z4, null);
    }
}
