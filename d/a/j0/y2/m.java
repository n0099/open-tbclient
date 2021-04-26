package d.a.j0.y2;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.logsystem.util.ILokiOverlayContext;
import com.baidu.tbadk.TbConfig;
@Singleton
@Service
/* loaded from: classes5.dex */
public class m implements ILokiOverlayContext {
    @Override // com.baidu.searchbox.logsystem.util.ILokiOverlayContext
    public String getAppVersion() {
        return TbConfig.getVersion();
    }
}
