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
    private static c ora;
    private Context mContext;
    private final HashMap<String, d> orb = new HashMap<>();
    private String orc;

    private c(Context context) {
        this.orc = null;
        this.mContext = context.getApplicationContext();
        this.orc = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c gB(Context context) {
        if (ora == null) {
            synchronized (c.class) {
                if (ora == null) {
                    ora = new c(context);
                }
            }
        }
        return ora;
    }

    public d bd(String str, boolean z) {
        PackageInfo packageArchiveInfo;
        d dVar = null;
        if (!TextUtils.isEmpty(str) && ar(new File(str)) && (packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5)) != null) {
            dVar = b(packageArchiveInfo, str);
            if (z) {
                TE(str);
            }
        }
        return dVar;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.orb.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(TB(str), a(TC(str)), packageInfo);
            this.orb.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader TB(String str) {
        return new DexClassLoader(str, dZs(), this.orc, this.mContext.getClassLoader());
    }

    public String dZs() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager TC(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d TD(String str) {
        return this.orb.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void TE(String str) {
        e.dZu().v(this.mContext, str, this.orc);
    }

    private boolean ar(File file) {
        File filesDir = this.mContext.getFilesDir();
        for (File parentFile = file.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            if (parentFile.equals(filesDir)) {
                return true;
            }
        }
        return false;
    }
}
