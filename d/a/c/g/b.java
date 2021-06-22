package d.a.c.g;

import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DownloadCallback;
import java.util.List;
/* loaded from: classes.dex */
public class b implements DownloadCallback {

    /* renamed from: a  reason: collision with root package name */
    public IPackageDownloadCallback f42796a;

    public b(IPackageDownloadCallback iPackageDownloadCallback) {
        this.f42796a = iPackageDownloadCallback;
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onBulkDownloaded(List<PackageInfo> list, List<PackageInfo> list2, List<PackageInfo> list3) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadCancel(PackageInfo packageInfo) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
        this.f42796a.onPackageDownloadFail(packageInfo.packageName, errorInfo.code, errorInfo.errorMsg);
        d.a.c.g.h.b.b(packageInfo.packageName, 1, packageInfo.version);
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadPause(PackageInfo packageInfo) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadProgress(PackageInfo packageInfo, long j, long j2) {
        this.f42796a.onProgress(j, j2);
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadResume(PackageInfo packageInfo, long j, long j2) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadStart(PackageInfo packageInfo) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
        this.f42796a.onPackageDownloadSuccess(packageInfo.packageName, packageInfo.filePath);
        d.a.c.g.h.b.b(packageInfo.packageName, 0, packageInfo.version);
    }
}
