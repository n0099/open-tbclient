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

    public static native RtcCertificatePem nativeGenerateCertificate(PeerConnection.KeyType keyType, long j);

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
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return nativeGenerateCertificate(PeerConnection.KeyType.ECDSA, DEFAULT_EXPIRY);
        }
        return (RtcCertificatePem) invokeV.objValue;
    }

    public String getCertificate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.certificate;
        }
        return (String) invokeV.objValue;
    }

    public String getPrivateKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.privateKey;
        }
        return (String) invokeV.objValue;
    }

    public static RtcCertificatePem generateCertificate(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            return nativeGenerateCertificate(PeerConnection.KeyType.ECDSA, j);
        }
        return (RtcCertificatePem) invokeJ.objValue;
    }

    public static RtcCertificatePem generateCertificate(PeerConnection.KeyType keyType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, keyType)) == null) {
            return nativeGenerateCertificate(keyType, DEFAULT_EXPIRY);
        }
        return (RtcCertificatePem) invokeL.objValue;
    }

    public static RtcCertificatePem generateCertificate(PeerConnection.KeyType keyType, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, keyType, j)) == null) {
            return nativeGenerateCertificate(keyType, j);
        }
        return (RtcCertificatePem) invokeLJ.objValue;
    }
}
