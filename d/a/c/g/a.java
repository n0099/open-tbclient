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
    public PackageInfo f40122a;

    /* renamed from: b  reason: collision with root package name */
    public String f40123b;

    /* renamed from: c  reason: collision with root package name */
    public String f40124c;

    /* renamed from: d  reason: collision with root package name */
    public String f40125d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40126e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40127f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f40128g;

    /* renamed from: h  reason: collision with root package name */
    public int f40129h;

    /* renamed from: i  reason: collision with root package name */
    public int f40130i;
    public int j;
    public int k;
    public int l;

    public a(PackageInfo packageInfo) {
        this.f40122a = packageInfo;
        String str = packageInfo.extraServer;
        if (packageInfo.isAllowSilence()) {
            this.j = 1;
        }
        if (this.f40122a.isOnlyWifi()) {
            this.l = 1;
        }
        if (this.f40122a.isAllowSilenceUpdate()) {
            this.k = 1;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BdLog.e("LiveNPSPluginManager=" + str);
            JSONObject jSONObject = new JSONObject(str);
            this.f40123b = jSONObject.optString("description");
            this.f40124c = jSONObject.optString("icon_url");
            this.f40128g = jSONObject.optInt("force_update");
            this.f40129h = jSONObject.optInt("min_version");
            this.f40130i = jSONObject.optInt("abi");
        } catch (JSONException unused) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getAbi() {
        return this.f40130i;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getApkPath() {
        return this.f40122a.filePath;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDependence() {
        return this.f40125d;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDescription() {
        return this.f40123b;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDownloadUrl() {
        return this.f40122a.downloadUrl;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getExt() {
        return this.f40122a.extraServer;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getIconUrl() {
        return this.f40124c;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getMd5() {
        return this.f40122a.md5;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getMinVersion() {
        return this.f40129h;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getName() {
        return this.f40122a.name;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPackageName() {
        return this.f40122a.packageName;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getSignature() {
        return this.f40122a.sign;
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
            i2 = Integer.parseInt(this.f40122a.size);
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
        return this.f40122a.updateVersion;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getVersionCode() {
        return (int) this.f40122a.version;
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
        return this.f40122a.disable == 1;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isNeedRemove() {
        return false;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isRemovable() {
        return this.f40127f;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isVisible() {
        return this.f40126e;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean needForceUpdate() {
        return this.f40128g == 1;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setAbi(int i2) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setApkPath(String str) {
        this.f40122a.filePath = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setBroken(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDependence(String str) {
        this.f40123b = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDescription(String str) {
        this.f40123b = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDownloadUrl(String str) {
        this.f40122a.downloadUrl = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setExt(String str) {
        this.f40122a.extraServer = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForbidden(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForceUpdate(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setIconUrl(String str) {
        this.f40124c = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMd5(String str) {
        this.f40122a.md5 = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMinVersion(int i2) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setName(String str) {
        this.f40122a.name = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setNeedRemove(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPackageName(String str) {
        this.f40122a.packageName = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setRemovable(boolean z) {
        this.f40127f = z;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSignature(String str) {
        this.f40122a.sign = str;
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
        PackageInfo packageInfo = this.f40122a;
        packageInfo.size = j + "";
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setType(int i2) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setUpdateV(long j) {
        this.f40122a.updateVersion = j;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVersionCode(int i2) {
        this.f40122a.version = i2;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVisible(boolean z) {
        this.f40126e = z;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setWifiOnly(int i2) {
        this.l = i2;
    }
}
