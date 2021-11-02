package okhttp3.internal.tls;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes3.dex */
public final class BasicTrustRootIndex implements TrustRootIndex {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    public BasicTrustRootIndex(X509Certificate... x509CertificateArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x509CertificateArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.subjectToCaCerts = new LinkedHashMap();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> set = this.subjectToCaCerts.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet<>(1);
                this.subjectToCaCerts.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof BasicTrustRootIndex) && ((BasicTrustRootIndex) obj).subjectToCaCerts.equals(this.subjectToCaCerts);
        }
        return invokeL.booleanValue;
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509Certificate)) == null) {
            Set<X509Certificate> set = this.subjectToCaCerts.get(x509Certificate.getIssuerX500Principal());
            if (set == null) {
                return null;
            }
            for (X509Certificate x509Certificate2 : set) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (X509Certificate) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.subjectToCaCerts.hashCode() : invokeV.intValue;
    }
}
