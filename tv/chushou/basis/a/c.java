package tv.chushou.basis.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c {
    private static c nUD;
    private Context mContext;
    private final HashMap<String, d> nUE = new HashMap<>();
    private String nUF;
    private String nUG;

    private c(Context context) {
        this.nUF = null;
        this.mContext = context.getApplicationContext();
        this.nUF = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c ha(Context context) {
        if (nUD == null) {
            synchronized (c.class) {
                if (nUD == null) {
                    nUD = new c(context);
                }
            }
        }
        return nUD;
    }

    public d aV(String str, boolean z) {
        PackageInfo packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5);
        if (packageArchiveInfo == null) {
            return null;
        }
        d b = b(packageArchiveInfo, str);
        if (z) {
            SG(str);
            return b;
        }
        return b;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.nUE.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(SD(str), a(SE(str)), packageInfo);
            this.nUE.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader SD(String str) {
        this.nUG = dPE();
        return new DexClassLoader(str, this.nUG, this.nUF, this.mContext.getClassLoader());
    }

    public String dPE() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager SE(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d SF(String str) {
        return this.nUE.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void SG(String str) {
        e.dPG().x(this.mContext, str, this.nUF);
    }
}
