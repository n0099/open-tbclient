package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
/* loaded from: classes9.dex */
public final class CertificatePinner {
    public static /* synthetic */ Interceptable $ic;
    public static final CertificatePinner DEFAULT;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final CertificateChainCleaner certificateChainCleaner;
    public final Set<Pin> pins;

    /* loaded from: classes9.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<Pin> pins;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pins = new ArrayList();
        }

        public CertificatePinner build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new CertificatePinner(new LinkedHashSet(this.pins), null);
            }
            return (CertificatePinner) invokeV.objValue;
        }

        public Builder add(String str, String... strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, strArr)) == null) {
                if (str != null) {
                    for (String str2 : strArr) {
                        this.pins.add(new Pin(str, str2));
                    }
                    return this;
                }
                throw new NullPointerException("pattern == null");
            }
            return (Builder) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class Pin {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String WILDCARD = "*.";
        public transient /* synthetic */ FieldHolder $fh;
        public final String canonicalHostname;
        public final ByteString hash;
        public final String hashAlgorithm;
        public final String pattern;

        public Pin(String str, String str2) {
            String host;
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
            this.pattern = str;
            if (str.startsWith(WILDCARD)) {
                host = HttpUrl.get("http://" + str.substring(2)).host();
            } else {
                host = HttpUrl.get("http://" + str).host();
            }
            this.canonicalHostname = host;
            if (str2.startsWith("sha1/")) {
                this.hashAlgorithm = "sha1/";
                this.hash = ByteString.decodeBase64(str2.substring(5));
            } else if (str2.startsWith("sha256/")) {
                this.hashAlgorithm = "sha256/";
                this.hash = ByteString.decodeBase64(str2.substring(7));
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            if (this.hash != null) {
                return;
            }
            throw new IllegalArgumentException("pins must be base64: " + str2);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof Pin) {
                    Pin pin = (Pin) obj;
                    if (this.pattern.equals(pin.pattern) && this.hashAlgorithm.equals(pin.hashAlgorithm) && this.hash.equals(pin.hash)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return ((((527 + this.pattern.hashCode()) * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.hashAlgorithm + this.hash.base64();
            }
            return (String) invokeV.objValue;
        }

        public boolean matches(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (this.pattern.startsWith(WILDCARD)) {
                    int indexOf = str.indexOf(46);
                    if ((str.length() - indexOf) - 1 == this.canonicalHostname.length()) {
                        String str2 = this.canonicalHostname;
                        if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                            return true;
                        }
                    }
                    return false;
                }
                return str.equals(this.canonicalHostname);
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1136468650, "Lokhttp3/CertificatePinner;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1136468650, "Lokhttp3/CertificatePinner;");
                return;
            }
        }
        DEFAULT = new Builder().build();
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
            if (certificateChainCleaner != null) {
                i = certificateChainCleaner.hashCode();
            } else {
                i = 0;
            }
            return (i * 31) + this.pins.hashCode();
        }
        return invokeV.intValue;
    }

    public CertificatePinner(Set<Pin> set, @Nullable CertificateChainCleaner certificateChainCleaner) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {set, certificateChainCleaner};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static String pin(Certificate certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, certificate)) == null) {
            if (certificate instanceof X509Certificate) {
                return "sha256/" + sha256((X509Certificate) certificate).base64();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return (String) invokeL.objValue;
    }

    public List<Pin> findMatchingPins(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            List<Pin> emptyList = Collections.emptyList();
            for (Pin pin : this.pins) {
                if (pin.matches(str)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(pin);
                }
            }
            return emptyList;
        }
        return (List) invokeL.objValue;
    }

    public static ByteString sha1(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x509Certificate)) == null) {
            return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
        }
        return (ByteString) invokeL.objValue;
    }

    public static ByteString sha256(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, x509Certificate)) == null) {
            return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
        }
        return (ByteString) invokeL.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CertificatePinner) {
                CertificatePinner certificatePinner = (CertificatePinner) obj;
                if (Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) && this.pins.equals(certificatePinner.pins)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public CertificatePinner withCertificateChainCleaner(@Nullable CertificateChainCleaner certificateChainCleaner) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, certificateChainCleaner)) == null) {
            if (Util.equal(this.certificateChainCleaner, certificateChainCleaner)) {
                return this;
            }
            return new CertificatePinner(this.pins, certificateChainCleaner);
        }
        return (CertificatePinner) invokeL.objValue;
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            List<Pin> findMatchingPins = findMatchingPins(str);
            if (findMatchingPins.isEmpty()) {
                return;
            }
            CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
            if (certificateChainCleaner != null) {
                list = certificateChainCleaner.clean(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = findMatchingPins.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    Pin pin = findMatchingPins.get(i2);
                    if (pin.hashAlgorithm.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = sha256(x509Certificate);
                        }
                        if (pin.hash.equals(byteString)) {
                            return;
                        }
                    } else if (pin.hashAlgorithm.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = sha1(x509Certificate);
                        }
                        if (pin.hash.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.hashAlgorithm);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(pin(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = findMatchingPins.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sb.append("\n    ");
                sb.append(findMatchingPins.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, certificateArr) == null) {
            check(str, Arrays.asList(certificateArr));
        }
    }
}
