package tv.chushou.basis.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c {
    private static c nMA;
    private Context mContext;
    private final HashMap<String, d> nMB = new HashMap<>();
    private String nMC;

    private c(Context context) {
        this.nMC = null;
        this.mContext = context.getApplicationContext();
        this.nMC = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c gs(Context context) {
        if (nMA == null) {
            synchronized (c.class) {
                if (nMA == null) {
                    nMA = new c(context);
                }
            }
        }
        return nMA;
    }

    public d be(String str, boolean z) {
        PackageInfo packageArchiveInfo;
        d dVar = null;
        if (!TextUtils.isEmpty(str) && an(new File(str)) && (packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5)) != null) {
            dVar = b(packageArchiveInfo, str);
            if (z) {
                Sg(str);
            }
        }
        return dVar;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.nMB.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(Sd(str), a(Se(str)), packageInfo);
            this.nMB.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader Sd(String str) {
        return new DexClassLoader(str, dRm(), this.nMC, this.mContext.getClassLoader());
    }

    public String dRm() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager Se(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d Sf(String str) {
        return this.nMB.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void Sg(String str) {
        e.dRo().w(this.mContext, str, this.nMC);
    }

    private boolean an(File file) {
        File filesDir = this.mContext.getFilesDir();
        for (File parentFile = file.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            if (parentFile.equals(filesDir)) {
                return true;
            }
        }
        return false;
    }
}
