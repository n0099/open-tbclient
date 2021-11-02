package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
import org.webrtc.PeerConnection;
/* loaded from: classes3.dex */
public final class PeerConnectionDependencies {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PeerConnection.Observer observer;
    public final SSLCertificateVerifier sslCertificateVerifier;

    /* renamed from: org.webrtc.PeerConnectionDependencies$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PeerConnection.Observer observer;
        public SSLCertificateVerifier sslCertificateVerifier;

        public /* synthetic */ Builder(PeerConnection.Observer observer, AnonymousClass1 anonymousClass1) {
            this(observer);
        }

        public PeerConnectionDependencies createPeerConnectionDependencies() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new PeerConnectionDependencies(this.observer, this.sslCertificateVerifier, null) : (PeerConnectionDependencies) invokeV.objValue;
        }

        public Builder setSSLCertificateVerifier(SSLCertificateVerifier sSLCertificateVerifier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sSLCertificateVerifier)) == null) {
                this.sslCertificateVerifier = sSLCertificateVerifier;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder(PeerConnection.Observer observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.observer = observer;
        }
    }

    public /* synthetic */ PeerConnectionDependencies(PeerConnection.Observer observer, SSLCertificateVerifier sSLCertificateVerifier, AnonymousClass1 anonymousClass1) {
        this(observer, sSLCertificateVerifier);
    }

    public static Builder builder(PeerConnection.Observer observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, observer)) == null) ? new Builder(observer, null) : (Builder) invokeL.objValue;
    }

    public PeerConnection.Observer getObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.observer : (PeerConnection.Observer) invokeV.objValue;
    }

    @Nullable
    public SSLCertificateVerifier getSSLCertificateVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.sslCertificateVerifier : (SSLCertificateVerifier) invokeV.objValue;
    }

    public PeerConnectionDependencies(PeerConnection.Observer observer, SSLCertificateVerifier sSLCertificateVerifier) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observer, sSLCertificateVerifier};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.observer = observer;
        this.sslCertificateVerifier = sSLCertificateVerifier;
    }
}
