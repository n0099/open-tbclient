package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.PeerConnection;
/* loaded from: classes2.dex */
public class RtcCertificatePem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_EXPIRY = 2592000;
    public transient /* synthetic */ FieldHolder $fh;
    public final String certificate;
    public final String privateKey;

    @CalledByNative
    public RtcCertificatePem(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.privateKey = str;
        this.certificate = str2;
    }

    public static RtcCertificatePem generateCertificate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? nativeGenerateCertificate(PeerConnection.KeyType.ECDSA, DEFAULT_EXPIRY) : (RtcCertificatePem) invokeV.objValue;
    }

    public static RtcCertificatePem generateCertificate(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) ? nativeGenerateCertificate(PeerConnection.KeyType.ECDSA, j2) : (RtcCertificatePem) invokeJ.objValue;
    }

    public static RtcCertificatePem generateCertificate(PeerConnection.KeyType keyType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, keyType)) == null) ? nativeGenerateCertificate(keyType, DEFAULT_EXPIRY) : (RtcCertificatePem) invokeL.objValue;
    }

    public static RtcCertificatePem generateCertificate(PeerConnection.KeyType keyType, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, keyType, j2)) == null) ? nativeGenerateCertificate(keyType, j2) : (RtcCertificatePem) invokeLJ.objValue;
    }

    public static native RtcCertificatePem nativeGenerateCertificate(PeerConnection.KeyType keyType, long j2);

    @CalledByNative
    public String getCertificate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.certificate : (String) invokeV.objValue;
    }

    @CalledByNative
    public String getPrivateKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.privateKey : (String) invokeV.objValue;
    }
}
