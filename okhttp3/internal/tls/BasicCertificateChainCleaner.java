package okhttp3.internal.tls;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
/* loaded from: classes3.dex */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SIGNERS = 9;
    public transient /* synthetic */ FieldHolder $fh;
    public final TrustRootIndex trustRootIndex;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {trustRootIndex};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.trustRootIndex = trustRootIndex;
    }

    private boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, x509Certificate, x509Certificate2)) == null) {
            if (x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return true;
                } catch (GeneralSecurityException unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public List<Certificate> clean(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, str)) == null) {
            ArrayDeque arrayDeque = new ArrayDeque(list);
            ArrayList arrayList = new ArrayList();
            arrayList.add(arrayDeque.removeFirst());
            boolean z = false;
            for (int i2 = 0; i2 < 9; i2++) {
                X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
                X509Certificate findByIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate);
                if (findByIssuerAndSignature != null) {
                    if (arrayList.size() > 1 || !x509Certificate.equals(findByIssuerAndSignature)) {
                        arrayList.add(findByIssuerAndSignature);
                    }
                    if (verifySignature(findByIssuerAndSignature, findByIssuerAndSignature)) {
                        return arrayList;
                    }
                    z = true;
                } else {
                    Iterator it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        X509Certificate x509Certificate2 = (X509Certificate) it.next();
                        if (verifySignature(x509Certificate, x509Certificate2)) {
                            it.remove();
                            arrayList.add(x509Certificate2);
                        }
                    }
                    if (z) {
                        return arrayList;
                    }
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
            }
            throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
        }
        return (List) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof BasicCertificateChainCleaner) && ((BasicCertificateChainCleaner) obj).trustRootIndex.equals(this.trustRootIndex);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.trustRootIndex.hashCode() : invokeV.intValue;
    }
}
