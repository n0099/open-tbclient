package tv.chushou.basis.a;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import dalvik.system.DexClassLoader;
/* loaded from: classes4.dex */
public class d {
    public AssetManager assetManager;
    public String nTO = dOq();
    public DexClassLoader nTP;
    public PackageInfo packageInfo;
    public String packageName;
    public Resources resources;

    public d(DexClassLoader dexClassLoader, Resources resources, PackageInfo packageInfo) {
        this.packageName = packageInfo.packageName;
        this.nTP = dexClassLoader;
        this.assetManager = resources.getAssets();
        this.resources = resources;
        this.packageInfo = packageInfo;
    }

    private final String dOq() {
        return (this.packageInfo.activities == null || this.packageInfo.activities.length <= 0) ? "" : this.packageInfo.activities[0].name;
    }
}
