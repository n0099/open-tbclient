package d.a.x.g.a;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import d.a.x.i.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f64859a = new b();

    public static b i() {
        return f64859a;
    }

    public void a(Bundle bundle) {
        ContextHolder.getApplicationContext().getContentResolver().call(j.b(), BundleOpProvider.METHOD_BUNDLE_CLEAR, (String) null, bundle);
    }

    public Bundle b() {
        return ContextHolder.getApplicationContext().getContentResolver().call(j.b(), BundleOpProvider.METHOD_BUNDLE_DOWNLOAD_ALL, (String) null, (Bundle) null);
    }

    public Bundle c(BundleInfo bundleInfo) {
        Uri b2 = j.b();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
        return ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_DOWNLOAD_BACKGROUND, (String) null, bundle);
    }

    public Bundle d(BundleInfo bundleInfo) {
        Uri b2 = j.b();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
        return ContextHolder.getApplicationContext().getContentResolver().call(b2, "download", (String) null, bundle);
    }

    public Bundle e() {
        return ContextHolder.getApplicationContext().getContentResolver().call(j.b(), BundleOpProvider.METHOD_BUNDLE_FETCH, (String) null, (Bundle) null);
    }

    public Map<String, BundleInfoGroup> f(long j) {
        Cursor query = ContextHolder.getApplicationContext().getContentResolver().query(j.b(), null, "", null, null);
        Map<String, BundleInfoGroup> t = t(BundleInfo.toBundleInfoList(query), j);
        try {
            query.close();
        } catch (Exception unused) {
        }
        return t;
    }

    public List<BundleInfo> g(String str) {
        Cursor query = ContextHolder.getApplicationContext().getContentResolver().query(j.b(), null, "pkg_name = ? ", new String[]{str}, null);
        List<BundleInfo> bundleInfoList = BundleInfo.toBundleInfoList(query);
        try {
            query.close();
        } catch (Exception unused) {
        }
        return bundleInfoList;
    }

    public BundleInfoGroup h(String str, long j) {
        Cursor query = ContextHolder.getApplicationContext().getContentResolver().query(j.b(), null, "pkg_name = ? ", new String[]{str}, null);
        BundleInfoGroup s = s(BundleInfo.toBundleInfoList(query), j);
        try {
            query.close();
        } catch (Exception unused) {
        }
        return s;
    }

    public Bundle j() {
        return ContextHolder.getApplicationContext().getContentResolver().call(j.b(), BundleOpProvider.METHOD_BUNDLE_PRE_INFO, (String) null, (Bundle) null);
    }

    public Bundle k(BundleInfo bundleInfo) {
        Uri b2 = j.b();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
        return ContextHolder.getApplicationContext().getContentResolver().call(b2, "install", (String) null, bundle);
    }

    public Bundle l(BundleInfo bundleInfo) {
        Uri b2 = j.b();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
        return ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_INSTALL_ONLY, (String) null, bundle);
    }

    public Bundle m(BundleInfo bundleInfo) {
        Uri b2 = j.b();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
        return ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_LOCAL_INSTALL, (String) null, bundle);
    }

    public Bundle n(BundleInfo bundleInfo) {
        Uri b2 = j.b();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
        return ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_PRE_INSTALL_SINGLE, (String) null, bundle);
    }

    public Bundle o() {
        return ContextHolder.getApplicationContext().getContentResolver().call(j.b(), BundleOpProvider.METHOD_BUNDLE_PRE_INSTALL_ALL, (String) null, (Bundle) null);
    }

    public boolean p(String str) {
        Uri b2 = j.b();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.TAG.PARAM_PKG_NAME, str);
        Bundle call = ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_CHECK, (String) null, bundle);
        return call != null && call.getInt(Constant.TAG.PARAM_PKG_STUS, -1) == 47;
    }

    public void q(String str) {
        Uri b2 = j.b();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.TAG.PARAM_PKG_NAME, str);
        ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_RECORD, (String) null, bundle);
    }

    public void r(boolean z, ContentObserver contentObserver) {
        ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(j.b(), z, contentObserver);
    }

    public final BundleInfoGroup s(List<BundleInfo> list, long j) {
        BundleInfoGroup bundleInfoGroup = new BundleInfoGroup(j);
        for (BundleInfo bundleInfo : list) {
            bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
        }
        return bundleInfoGroup;
    }

    public final Map<String, BundleInfoGroup> t(List<BundleInfo> list, long j) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return null;
        }
        for (BundleInfo bundleInfo : list) {
            BundleInfoGroup bundleInfoGroup = (BundleInfoGroup) hashMap.get(bundleInfo.getPackageName());
            if (bundleInfoGroup == null) {
                bundleInfoGroup = new BundleInfoGroup(j);
                hashMap.put(bundleInfo.getPackageName(), bundleInfoGroup);
            }
            bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
        }
        return hashMap;
    }
}
