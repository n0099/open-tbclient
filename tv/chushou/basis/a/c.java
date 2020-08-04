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
    private static c orc;
    private Context mContext;
    private final HashMap<String, d> ord = new HashMap<>();
    private String ore;

    private c(Context context) {
        this.ore = null;
        this.mContext = context.getApplicationContext();
        this.ore = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c gB(Context context) {
        if (orc == null) {
            synchronized (c.class) {
                if (orc == null) {
                    orc = new c(context);
                }
            }
        }
        return orc;
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
        d dVar = this.ord.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(TB(str), a(TC(str)), packageInfo);
            this.ord.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader TB(String str) {
        return new DexClassLoader(str, dZt(), this.ore, this.mContext.getClassLoader());
    }

    public String dZt() {
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
        return this.ord.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void TE(String str) {
        e.dZv().v(this.mContext, str, this.ore);
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
