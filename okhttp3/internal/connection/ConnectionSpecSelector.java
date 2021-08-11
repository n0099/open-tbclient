package okhttp3.internal.connection;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;
/* loaded from: classes2.dex */
public final class ConnectionSpecSelector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ConnectionSpec> connectionSpecs;
    public boolean isFallback;
    public boolean isFallbackPossible;
    public int nextModeIndex;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nextModeIndex = 0;
        this.connectionSpecs = list;
    }

    private boolean isFallbackPossible(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, sSLSocket)) == null) {
            for (int i2 = this.nextModeIndex; i2 < this.connectionSpecs.size(); i2++) {
                if (this.connectionSpecs.get(i2).isCompatible(sSLSocket)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        InterceptResult invokeL;
        ConnectionSpec connectionSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sSLSocket)) == null) {
            int i2 = this.nextModeIndex;
            int size = this.connectionSpecs.size();
            while (true) {
                if (i2 >= size) {
                    connectionSpec = null;
                    break;
                }
                connectionSpec = this.connectionSpecs.get(i2);
                if (connectionSpec.isCompatible(sSLSocket)) {
                    this.nextModeIndex = i2 + 1;
                    break;
                }
                i2++;
            }
            if (connectionSpec != null) {
                this.isFallbackPossible = isFallbackPossible(sSLSocket);
                Internal.instance.apply(connectionSpec, sSLSocket, this.isFallback);
                return connectionSpec;
            }
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.isFallback + ", modes=" + this.connectionSpecs + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        return (ConnectionSpec) invokeL.objValue;
    }

    public boolean connectionFailed(IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException)) == null) {
            this.isFallback = true;
            if (!this.isFallbackPossible || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
                return false;
            }
            boolean z = iOException instanceof SSLHandshakeException;
            if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
                return false;
            }
            return z || (iOException instanceof SSLProtocolException);
        }
        return invokeL.booleanValue;
    }
}
