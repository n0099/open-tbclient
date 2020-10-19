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
    private static c pkm;
    private Context mContext;
    private final HashMap<String, d> pkn = new HashMap<>();
    private String pko;

    private c(Context context) {
        this.pko = null;
        this.mContext = context.getApplicationContext();
        this.pko = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c hg(Context context) {
        if (pkm == null) {
            synchronized (c.class) {
                if (pkm == null) {
                    pkm = new c(context);
                }
            }
        }
        return pkm;
    }

    public d bm(String str, boolean z) {
        PackageInfo packageArchiveInfo;
        d dVar = null;
        if (!TextUtils.isEmpty(str) && av(new File(str)) && (packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5)) != null) {
            dVar = b(packageArchiveInfo, str);
            if (z) {
                XY(str);
            }
        }
        return dVar;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.pkn.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(XV(str), a(XW(str)), packageInfo);
            this.pkn.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader XV(String str) {
        return new DexClassLoader(str, etp(), this.pko, this.mContext.getClassLoader());
    }

    public String etp() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager XW(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d XX(String str) {
        return this.pkn.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void XY(String str) {
        e.etr().y(this.mContext, str, this.pko);
    }

    private boolean av(File file) {
        File filesDir = this.mContext.getFilesDir();
        for (File parentFile = file.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            if (parentFile.equals(filesDir)) {
                return true;
            }
        }
        return false;
    }
}
