package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.PeerConnection;
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static native RtcCertificatePem nativeGenerateCertificate(PeerConnection.KeyType keyType, long j);

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

    public static RtcCertificatePem generateCertificate(PeerConnection.KeyType keyType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, keyType)) == null) ? nativeGenerateCertificate(keyType, DEFAULT_EXPIRY) : (RtcCertificatePem) invokeL.objValue;
    }

    public static RtcCertificatePem generateCertificate(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? nativeGenerateCertificate(PeerConnection.KeyType.ECDSA, j) : (RtcCertificatePem) invokeJ.objValue;
    }

    public static RtcCertificatePem generateCertificate(PeerConnection.KeyType keyType, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, keyType, j)) == null) ? nativeGenerateCertificate(keyType, j) : (RtcCertificatePem) invokeLJ.objValue;
    }
}
