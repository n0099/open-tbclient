package d.a.c.g.f;

import android.content.res.Resources;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.nps.interfa.IResourcesFetcher;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
@Singleton
@Service
/* loaded from: classes.dex */
public class c implements IResourcesFetcher {
    @Override // com.baidu.nps.interfa.IResourcesFetcher
    public Resources getBaseContextResources() {
        return BdBaseApplication.getInst().getResources();
    }

    @Override // com.baidu.nps.interfa.IResourcesFetcher
    public Resources getGlobalResources() {
        return BdBaseApplication.getInst().getResources();
    }

    @Override // com.baidu.nps.interfa.IResourcesFetcher
    public Resources[] getWrapperResources() {
        return new Resources[]{BdBaseApplication.getInst().getResources()};
    }
}
