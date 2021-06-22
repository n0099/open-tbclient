package d.a.o0.z2;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityNeedContext;
@Singleton
@Service
/* loaded from: classes5.dex */
public class k implements ILokiIdentityNeedContext {
    @Override // com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityNeedContext
    public String getAppName() {
        return "tieba";
    }
}
