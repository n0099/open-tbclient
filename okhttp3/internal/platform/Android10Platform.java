package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
@SuppressLint({"NewApi"})
/* loaded from: classes9.dex */
public class Android10Platform extends AndroidPlatform {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Android10Platform(Class<?> cls) {
        super(cls, null, null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Class) objArr2[0], (OptionalMethod) objArr2[1], (OptionalMethod) objArr2[2], (OptionalMethod) objArr2[3], (OptionalMethod) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public static Platform buildIfSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!Platform.isAndroid()) {
                return null;
            }
            try {
                if (AndroidPlatform.getSdkInt() >= 29) {
                    return new Android10Platform(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
                }
            } catch (ClassNotFoundException unused) {
            }
            return null;
        }
        return (Platform) invokeV.objValue;
    }

    private void enableSessionTickets(SSLSocket sSLSocket) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, sSLSocket) == null) && SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Override // okhttp3.internal.platform.AndroidPlatform, okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sSLSocket)) == null) {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol != null && !applicationProtocol.isEmpty()) {
                return applicationProtocol;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // okhttp3.internal.platform.AndroidPlatform, okhttp3.internal.platform.Platform
    @SuppressLint({"NewApi"})
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sSLSocket, str, list) == null) {
            try {
                enableSessionTickets(sSLSocket);
                SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                sSLParameters.setApplicationProtocols((String[]) Platform.alpnProtocolNames(list).toArray(new String[0]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalArgumentException e) {
                throw new IOException("Android internal error", e);
            }
        }
    }
}
