package d.b.c.g;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements IBundleInfo {

    /* renamed from: a  reason: collision with root package name */
    public PackageInfo f42904a;

    /* renamed from: b  reason: collision with root package name */
    public String f42905b;

    /* renamed from: c  reason: collision with root package name */
    public String f42906c;

    /* renamed from: d  reason: collision with root package name */
    public String f42907d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42908e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42909f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f42910g;

    /* renamed from: h  reason: collision with root package name */
    public int f42911h;
    public int i;

    public a(PackageInfo packageInfo) {
        this.f42904a = packageInfo;
        String str = packageInfo.extraServer;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BdLog.e("LiveNPSPluginManager=" + str);
            JSONObject jSONObject = new JSONObject(str);
            this.f42905b = jSONObject.optString("description");
            this.f42906c = jSONObject.optString("icon_url");
            this.f42910g = jSONObject.optInt("force_update");
            this.f42911h = jSONObject.optInt("min_version");
            this.i = jSONObject.optInt("abi");
        } catch (JSONException unused) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getAbi() {
        return this.i;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getApkPath() {
        return this.f42904a.filePath;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDependence() {
        return this.f42907d;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDescription() {
        return this.f42905b;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDownloadUrl() {
        return this.f42904a.downloadUrl;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getExt() {
        return this.f42904a.extraServer;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getIconUrl() {
        return this.f42906c;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getMd5() {
        return this.f42904a.md5;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getMinVersion() {
        return this.f42911h;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getName() {
        return this.f42904a.name;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPackageName() {
        return this.f42904a.packageName;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getSignature() {
        return this.f42904a.sign;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getSize() {
        int i;
        try {
            i = Integer.parseInt(this.f42904a.size);
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getType() {
        return 0;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getUpdateV() {
        return this.f42904a.updateVersion;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getVersionCode() {
        return (int) this.f42904a.version;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isBroken() {
        return false;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isForbidden() {
        return this.f42904a.disable == 1;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isNeedRemove() {
        return false;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isRemovable() {
        return this.f42909f;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isVisible() {
        return this.f42908e;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean needForceUpdate() {
        return this.f42910g == 1;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setAbi(int i) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setApkPath(String str) {
        this.f42904a.filePath = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setBroken(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDependence(String str) {
        this.f42905b = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDescription(String str) {
        this.f42905b = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDownloadUrl(String str) {
        this.f42904a.downloadUrl = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setExt(String str) {
        this.f42904a.extraServer = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForbidden(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForceUpdate(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setIconUrl(String str) {
        this.f42906c = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMd5(String str) {
        this.f42904a.md5 = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMinVersion(int i) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setName(String str) {
        this.f42904a.name = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setNeedRemove(boolean z) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPackageName(String str) {
        this.f42904a.packageName = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setRemovable(boolean z) {
        this.f42909f = z;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSignature(String str) {
        this.f42904a.sign = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSize(long j) {
        PackageInfo packageInfo = this.f42904a;
        packageInfo.size = j + "";
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setType(int i) {
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setUpdateV(long j) {
        this.f42904a.updateVersion = j;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVersionCode(int i) {
        this.f42904a.version = i;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVisible(boolean z) {
        this.f42908e = z;
    }
}
