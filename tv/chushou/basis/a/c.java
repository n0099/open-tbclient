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
    private static c qmz;
    private Context mContext;
    private final HashMap<String, d> qmA = new HashMap<>();
    private String qmB;

    private c(Context context) {
        this.qmB = null;
        this.mContext = context.getApplicationContext();
        this.qmB = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c hy(Context context) {
        if (qmz == null) {
            synchronized (c.class) {
                if (qmz == null) {
                    qmz = new c(context);
                }
            }
        }
        return qmz;
    }

    public d bu(String str, boolean z) {
        PackageInfo packageArchiveInfo;
        d dVar = null;
        if (!TextUtils.isEmpty(str) && aw(new File(str)) && (packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5)) != null) {
            dVar = b(packageArchiveInfo, str);
            if (z) {
                aaa(str);
            }
        }
        return dVar;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.qmA.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(ZX(str), a(ZY(str)), packageInfo);
            this.qmA.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader ZX(String str) {
        return new DexClassLoader(str, eHd(), this.qmB, this.mContext.getClassLoader());
    }

    public String eHd() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager ZY(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d ZZ(String str) {
        return this.qmA.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void aaa(String str) {
        e.eHf().C(this.mContext, str, this.qmB);
    }

    private boolean aw(File file) {
        File filesDir = this.mContext.getFilesDir();
        for (File parentFile = file.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            if (parentFile.equals(filesDir)) {
                return true;
            }
        }
        return false;
    }
}
