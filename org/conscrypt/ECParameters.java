package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.conscrypt.NativeRef;
/* loaded from: classes8.dex */
public class ECParameters extends AlgorithmParametersSpi {
    private OpenSSLECGroupContext curve;

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof ECGenParameterSpec) {
            String name = ((ECGenParameterSpec) algorithmParameterSpec).getName();
            OpenSSLECGroupContext curveByName = OpenSSLECGroupContext.getCurveByName(name);
            if (curveByName == null) {
                throw new InvalidParameterSpecException("Unknown EC curve name: " + name);
            }
            this.curve = curveByName;
        } else if (algorithmParameterSpec instanceof ECParameterSpec) {
            ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
            try {
                OpenSSLECGroupContext openSSLECGroupContext = OpenSSLECGroupContext.getInstance(eCParameterSpec);
                if (openSSLECGroupContext == null) {
                    throw new InvalidParameterSpecException("Unknown EC curve: " + eCParameterSpec);
                }
                this.curve = openSSLECGroupContext;
            } catch (InvalidAlgorithmParameterException e) {
                throw new InvalidParameterSpecException(e.getMessage());
            }
        } else {
            throw new InvalidParameterSpecException("Only ECParameterSpec and ECGenParameterSpec are supported");
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(byte[] bArr) throws IOException {
        long EC_KEY_parse_curve_name = NativeCrypto.EC_KEY_parse_curve_name(bArr);
        if (EC_KEY_parse_curve_name == 0) {
            throw new IOException("Error reading ASN.1 encoding");
        }
        this.curve = new OpenSSLECGroupContext(new NativeRef.EC_GROUP(EC_KEY_parse_curve_name));
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unsupported format: " + str);
    }

    @Override // java.security.AlgorithmParametersSpi
    protected <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls == ECParameterSpec.class) {
            return this.curve.getECParameterSpec();
        }
        if (cls == ECGenParameterSpec.class) {
            return new ECGenParameterSpec(Platform.getCurveName(this.curve.getECParameterSpec()));
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    @Override // java.security.AlgorithmParametersSpi
    protected byte[] engineGetEncoded() throws IOException {
        return NativeCrypto.EC_KEY_marshal_curve_name(this.curve.getNativeRef());
    }

    @Override // java.security.AlgorithmParametersSpi
    protected byte[] engineGetEncoded(String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            return engineGetEncoded();
        }
        throw new IOException("Unsupported format: " + str);
    }

    @Override // java.security.AlgorithmParametersSpi
    protected String engineToString() {
        return "Conscrypt EC AlgorithmParameters";
    }
}
