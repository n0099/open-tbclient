package d.a.c.g.g;

import android.content.pm.Signature;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.nps.interfa.ISignatureVerifier;
import com.baidu.pyramid.annotation.Service;
@Service
/* loaded from: classes.dex */
public class b implements ISignatureVerifier {
    @Override // com.baidu.nps.interfa.ISignatureVerifier
    public boolean checkSignature(String str, Signature[] signatureArr) {
        if (BdLog.isDebugMode()) {
            return true;
        }
        String c2 = a.c(signatureArr);
        BdLog.e("new signature: " + c2);
        return "YvigAa51R7YgCp8eDveR1g==".equals(c2);
    }
}
