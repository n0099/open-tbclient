package d.b.c.g;

import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.nps.interfa.IPackageGetCallback;
import com.baidu.nps.interfa.IPackageGetter;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.pyramid.annotation.Service;
import java.util.List;
@Service
/* loaded from: classes.dex */
public class d implements IPackageGetter {
    @Override // com.baidu.nps.interfa.IPackageGetter
    public void downloadBundle(IBundleInfo iBundleInfo, String str, int i, IPackageDownloadCallback iPackageDownloadCallback) {
        c.d().f().i(iBundleInfo, str, i, iPackageDownloadCallback);
    }

    @Override // com.baidu.nps.interfa.IPackageGetter
    public void getBundleInfo(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback) {
        c.d().f().k(list, iPackageGetCallback);
    }
}
