package d.b.c.i;

import com.baidu.adp.ApsConstants;
import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.nps.interfa.IPackageGetCallback;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import d.b.c.e.p.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static boolean f43060e = false;

    /* renamed from: a  reason: collision with root package name */
    public IPackageGetCallback f43061a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ResultData f43062b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ErrorInfo f43063c;

    /* renamed from: d  reason: collision with root package name */
    public RequestParams.Channel f43064d;

    /* renamed from: d.b.c.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0586a implements PackageCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPackageGetCallback f43065a;

        public C0586a(IPackageGetCallback iPackageGetCallback) {
            this.f43065a = iPackageGetCallback;
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onDegradeData(DegradeData degradeData) {
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onFetchError(ErrorInfo errorInfo) {
            a.this.n(errorInfo, this.f43065a);
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            a.this.o(resultData, this.f43065a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements PackageCallback {
        public b() {
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onDegradeData(DegradeData degradeData) {
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onFetchError(ErrorInfo errorInfo) {
            synchronized (a.this) {
                a.this.f43063c = errorInfo;
                a.this.p();
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            synchronized (a.this) {
                boolean unused = a.f43060e = true;
                a.this.f43062b = resultData;
                a.this.p();
            }
        }
    }

    public static boolean m() {
        return f43060e;
    }

    public final List<IBundleInfo> g(List<PackageInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (PackageInfo packageInfo : list) {
            arrayList.add(new d.b.c.g.a(packageInfo));
        }
        return arrayList;
    }

    public final PackageInfo h(IBundleInfo iBundleInfo) {
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.channelId = ApsConstants.TYPE_ANDROID_PLUGIN;
        packageInfo.packageName = iBundleInfo.getPackageName();
        packageInfo.md5 = iBundleInfo.getMd5();
        packageInfo.downloadUrl = iBundleInfo.getDownloadUrl();
        packageInfo.isSilence = 1;
        return packageInfo;
    }

    public void i(IBundleInfo iBundleInfo, String str, int i, IPackageDownloadCallback iPackageDownloadCallback) {
        PackageInfo h2 = h(iBundleInfo);
        h2.filePath = str;
        DownloadOptions downloadOptions = new DownloadOptions();
        downloadOptions.saveToDb = false;
        if (i == 49) {
            if (j.H()) {
                PmsManager.getInstance().download(h2, downloadOptions, new d.b.c.g.b(iPackageDownloadCallback));
                return;
            } else {
                iPackageDownloadCallback.onPackageDownloadFail(h2.packageName, -1, "no wifi");
                return;
            }
        }
        PmsManager.getInstance().download(h2, downloadOptions, new d.b.c.g.b(iPackageDownloadCallback));
    }

    public final void j(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback) {
        RequestParams requestParams = new RequestParams();
        requestParams.setRunType(ApsConstants.RUN_TYPE_ANDROID_PLUGIN);
        RequestParams.Channel channel = new RequestParams.Channel();
        channel.setChannelId(ApsConstants.TYPE_ANDROID_PLUGIN);
        ArrayList arrayList = new ArrayList();
        for (IBundleInfo iBundleInfo : list) {
            arrayList.add(iBundleInfo.getPackageName());
        }
        channel.setPackageNames(arrayList);
        channel.setCallback(new C0586a(iPackageGetCallback));
        requestParams.addChannel(channel);
        PmsManager.getInstance().execute(requestParams);
    }

    public void k(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback) {
        if (list == null || list.isEmpty()) {
            synchronized (this) {
                this.f43061a = iPackageGetCallback;
                p();
            }
            return;
        }
        j(list, iPackageGetCallback);
    }

    public RequestParams.Channel l() {
        RequestParams.Channel channel = this.f43064d;
        if (channel != null) {
            return channel;
        }
        RequestParams.Channel channel2 = new RequestParams.Channel();
        this.f43064d = channel2;
        channel2.setFetchAllPackages(true);
        this.f43064d.setChannelId(ApsConstants.TYPE_ANDROID_PLUGIN);
        this.f43064d.setCallback(new b());
        return this.f43064d;
    }

    public final void n(ErrorInfo errorInfo, IPackageGetCallback iPackageGetCallback) {
        iPackageGetCallback.onBundleInfoGetFail(errorInfo.code, errorInfo.errorMsg);
    }

    public final void o(ResultData resultData, IPackageGetCallback iPackageGetCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(resultData.addList);
        arrayList.addAll(resultData.updateList);
        iPackageGetCallback.onBundleInfoGetSuccess(g(arrayList));
    }

    public final void p() {
        if (this.f43061a == null) {
            return;
        }
        if (this.f43063c != null) {
            n(this.f43063c, this.f43061a);
            this.f43061a = null;
            this.f43063c = null;
        } else if (this.f43062b != null) {
            o(this.f43062b, this.f43061a);
            this.f43061a = null;
            this.f43062b = null;
        }
    }
}
