package tv.chushou.basis.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class c {
    private static c oUS;
    private Context mContext;
    private final HashMap<String, d> oUT = new HashMap<>();
    private String oUU;

    private c(Context context) {
        this.oUU = null;
        this.mContext = context.getApplicationContext();
        this.oUU = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c gZ(Context context) {
        if (oUS == null) {
            synchronized (c.class) {
                if (oUS == null) {
                    oUS = new c(context);
                }
            }
        }
        return oUS;
    }

    public d bi(String str, boolean z) {
        PackageInfo packageArchiveInfo;
        d dVar = null;
        if (!TextUtils.isEmpty(str) && as(new File(str)) && (packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5)) != null) {
            dVar = b(packageArchiveInfo, str);
            if (z) {
                Xk(str);
            }
        }
        return dVar;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.oUT.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(Xh(str), a(Xi(str)), packageInfo);
            this.oUT.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader Xh(String str) {
        return new DexClassLoader(str, epE(), this.oUU, this.mContext.getClassLoader());
    }

    public String epE() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager Xi(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d Xj(String str) {
        return this.oUT.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void Xk(String str) {
        e.epG().v(this.mContext, str, this.oUU);
    }

    private boolean as(File file) {
        File filesDir = this.mContext.getFilesDir();
        for (File parentFile = file.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            if (parentFile.equals(filesDir)) {
                return true;
            }
        }
        return false;
    }
}
