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
    private static c qbB;
    private Context mContext;
    private final HashMap<String, d> qbC = new HashMap<>();
    private String qbD;

    private c(Context context) {
        this.qbD = null;
        this.mContext = context.getApplicationContext();
        this.qbD = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c hA(Context context) {
        if (qbB == null) {
            synchronized (c.class) {
                if (qbB == null) {
                    qbB = new c(context);
                }
            }
        }
        return qbB;
    }

    public d bs(String str, boolean z) {
        PackageInfo packageArchiveInfo;
        d dVar = null;
        if (!TextUtils.isEmpty(str) && aw(new File(str)) && (packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5)) != null) {
            dVar = b(packageArchiveInfo, str);
            if (z) {
                ZL(str);
            }
        }
        return dVar;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.qbC.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(ZI(str), a(ZJ(str)), packageInfo);
            this.qbC.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader ZI(String str) {
        return new DexClassLoader(str, eDn(), this.qbD, this.mContext.getClassLoader());
    }

    public String eDn() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager ZJ(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d ZK(String str) {
        return this.qbC.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void ZL(String str) {
        e.eDp().C(this.mContext, str, this.qbD);
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
