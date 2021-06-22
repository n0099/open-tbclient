package d.a.c.g;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements IBundleInfo {

    /* renamed from: a  reason: collision with root package name */
    public PackageInfo f42787a;

    /* renamed from: b  reason: collision with root package name */
    public String f42788b;

    /* renamed from: c  reason: collision with root package name */
    public String f42789c;

    /* renamed from: d  reason: collision with root package name */
    public String f42790d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42791e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42792f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f42793g;

    /* renamed from: h  reason: collision with root package name */
    public int f42794h;

    /* renamed from: i  reason: collision with root package name */
    public int f42795i;
    public int j;
    public int k;
    public int l;

    public a(PackageInfo packageInfo) {
        this.f42787a = packageInfo;
        String str = packageInfo.extraServer;
        if (packageInfo.isAllowSilence()) {
            this.j = 1;
        }
        if (this.f42787a.isOnlyWifi()) {
            this.l = 1;
        }
        if (this.f42787a.isAllowSilenceUpdate()) {
            this.k = 1;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BdLog.e("LiveNPSPluginManager=" + str);
            JSONObject jSONObject = new JSONObject(str);
            this.f42788b = jSONObject.optString("description");
            this.f42789c = jSONObject.optString("icon_url");
            this.f42793g = jSONObject.optInt("force_update");
            this.f42794h = jSONObject.optInt("min_version");
            this.f42795i = jSONObject.optInt("abi");
        } catch (JSONException unused) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getAbi() {
        return this.f42795i;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getApkPath() {
        return this.f42787a.filePath;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDependence() {
        return this.f42790d;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDescription() {
        return this.f42788b;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDownloadUrl() {
        return this.f42787a.downloadUrl;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getExt() {
        return this.f42787a.extraServer;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getIconUrl() {
        return this.f42789c;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getMd5() {
        return this.f42787a.md5;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getMinVersion() {
        return this.f42794h;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getName() {
        return this.f42787a.name;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPackageName() {
        return this.f42787a.packageName;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getSignature() {
        return this.f42787a.sign;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilence() {
        return this.j;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilenceUpdate() {
        return this.k;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getSize() {
        int i2;
        try {
            i2 = Integer.parseInt(this.f42787a.size);
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        return i2;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getType() {
        return 0;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getUpdateV() {
        return this.f42787a.updateVersion;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getVersionCode() {
        return (int) this.f42787a.version;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getWifiOnly() {
        return this.l;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isBroken() {
        return false;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isForbidden() {
        return this.f42787a.disable == 1;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isNeedRemove() {
        return false;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isRemovable() {
        return this.f42792f;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isVisible() {
        return this.f42791e;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean needForceUpdate() {
        return this.f42793g == 1;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setAbi(int i2) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setApkPath(String str) {
        this.f42787a.filePath = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setBroken(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDependence(String str) {
        this.f42788b = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDescription(String str) {
        this.f42788b = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDownloadUrl(String str) {
        this.f42787a.downloadUrl = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setExt(String str) {
        this.f42787a.extraServer = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForbidden(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForceUpdate(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setIconUrl(String str) {
        this.f42789c = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMd5(String str) {
        this.f42787a.md5 = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMinVersion(int i2) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setName(String str) {
        this.f42787a.name = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setNeedRemove(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPackageName(String str) {
        this.f42787a.packageName = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setRemovable(boolean z) {
        this.f42792f = z;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSignature(String str) {
        this.f42787a.sign = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilence(int i2) {
        this.j = i2;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilenceUpdate(int i2) {
        this.k = i2;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSize(long j) {
        PackageInfo packageInfo = this.f42787a;
        packageInfo.size = j + "";
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setType(int i2) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setUpdateV(long j) {
        this.f42787a.updateVersion = j;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVersionCode(int i2) {
        this.f42787a.version = i2;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVisible(boolean z) {
        this.f42791e = z;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setWifiOnly(int i2) {
        this.l = i2;
    }
}
