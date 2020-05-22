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
    private static c nLq;
    private Context mContext;
    private final HashMap<String, d> nLr = new HashMap<>();
    private String nLs;

    private c(Context context) {
        this.nLs = null;
        this.mContext = context.getApplicationContext();
        this.nLs = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c gs(Context context) {
        if (nLq == null) {
            synchronized (c.class) {
                if (nLq == null) {
                    nLq = new c(context);
                }
            }
        }
        return nLq;
    }

    public d be(String str, boolean z) {
        PackageInfo packageArchiveInfo;
        d dVar = null;
        if (!TextUtils.isEmpty(str) && an(new File(str)) && (packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5)) != null) {
            dVar = b(packageArchiveInfo, str);
            if (z) {
                Sf(str);
            }
        }
        return dVar;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.nLr.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(Sc(str), a(Sd(str)), packageInfo);
            this.nLr.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader Sc(String str) {
        return new DexClassLoader(str, dQY(), this.nLs, this.mContext.getClassLoader());
    }

    public String dQY() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager Sd(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d Se(String str) {
        return this.nLr.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void Sf(String str) {
        e.dRa().w(this.mContext, str, this.nLs);
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
