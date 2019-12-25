package org.conscrypt;

import java.lang.reflect.Method;
import javax.net.ssl.SSLParameters;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class Java9PlatformUtil {
    private static final Method SSL_PARAMETERS_GET_APPLICATION_PROTOCOLS_METHOD;
    private static final Method SSL_PARAMETERS_SET_APPLICATION_PROTOCOLS_METHOD;

    static {
        Method method;
        Method method2 = null;
        try {
            method = SSLParameters.class.getMethod("getApplicationProtocols", new Class[0]);
            method2 = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
        } catch (NoSuchMethodException e) {
            method = null;
        }
        SSL_PARAMETERS_GET_APPLICATION_PROTOCOLS_METHOD = method;
        SSL_PARAMETERS_SET_APPLICATION_PROTOCOLS_METHOD = method2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) {
        Java8PlatformUtil.setSSLParameters(sSLParameters, sSLParametersImpl, abstractConscryptSocket);
        sSLParametersImpl.setApplicationProtocols(getApplicationProtocols(sSLParameters));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) {
        Java8PlatformUtil.getSSLParameters(sSLParameters, sSLParametersImpl, abstractConscryptSocket);
        setApplicationProtocols(sSLParameters, sSLParametersImpl.getApplicationProtocols());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        Java8PlatformUtil.setSSLParameters(sSLParameters, sSLParametersImpl, conscryptEngine);
        sSLParametersImpl.setApplicationProtocols(getApplicationProtocols(sSLParameters));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        Java8PlatformUtil.getSSLParameters(sSLParameters, sSLParametersImpl, conscryptEngine);
        setApplicationProtocols(sSLParameters, sSLParametersImpl.getApplicationProtocols());
    }

    private static String[] getApplicationProtocols(SSLParameters sSLParameters) {
        if (SSL_PARAMETERS_GET_APPLICATION_PROTOCOLS_METHOD != null) {
            try {
                return (String[]) SSL_PARAMETERS_GET_APPLICATION_PROTOCOLS_METHOD.invoke(sSLParameters, new Object[0]);
            } catch (ReflectiveOperationException e) {
            }
        }
        return EmptyArray.STRING;
    }

    private static void setApplicationProtocols(SSLParameters sSLParameters, String[] strArr) {
        if (SSL_PARAMETERS_SET_APPLICATION_PROTOCOLS_METHOD != null) {
            try {
                SSL_PARAMETERS_SET_APPLICATION_PROTOCOLS_METHOD.invoke(sSLParameters, strArr);
            } catch (ReflectiveOperationException e) {
            }
        }
    }

    private Java9PlatformUtil() {
    }
}
