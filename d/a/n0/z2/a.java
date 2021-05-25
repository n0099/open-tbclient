package d.a.n0.z2;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.aperf.param.IAperfOverlayContext;
import com.baidu.tbadk.TbConfig;
@Singleton
@Service
/* loaded from: classes5.dex */
public class a implements IAperfOverlayContext {
    @Override // com.baidu.searchbox.aperf.param.IAperfOverlayContext
    public String getAppVersion() {
        return TbConfig.getVersion();
    }
}
