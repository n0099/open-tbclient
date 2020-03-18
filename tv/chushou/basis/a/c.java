package tv.chushou.basis.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c {
    private static c nWD;
    private Context mContext;
    private final HashMap<String, d> nWE = new HashMap<>();
    private String nWF;
    private String nWG;

    private c(Context context) {
        this.nWF = null;
        this.mContext = context.getApplicationContext();
        this.nWF = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c gZ(Context context) {
        if (nWD == null) {
            synchronized (c.class) {
                if (nWD == null) {
                    nWD = new c(context);
                }
            }
        }
        return nWD;
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
        d dVar = this.nWE.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(SD(str), a(SE(str)), packageInfo);
            this.nWE.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader SD(String str) {
        this.nWG = dQh();
        return new DexClassLoader(str, this.nWG, this.nWF, this.mContext.getClassLoader());
    }

    public String dQh() {
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
        return this.nWE.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void SG(String str) {
        e.dQj().x(this.mContext, str, this.nWF);
    }
}
