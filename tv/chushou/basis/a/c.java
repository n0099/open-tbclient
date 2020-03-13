package tv.chushou.basis.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c {
    private static c nUQ;
    private Context mContext;
    private final HashMap<String, d> nUR = new HashMap<>();
    private String nUS;
    private String nUT;

    private c(Context context) {
        this.nUS = null;
        this.mContext = context.getApplicationContext();
        this.nUS = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c ha(Context context) {
        if (nUQ == null) {
            synchronized (c.class) {
                if (nUQ == null) {
                    nUQ = new c(context);
                }
            }
        }
        return nUQ;
    }

    public d aV(String str, boolean z) {
        PackageInfo packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5);
        if (packageArchiveInfo == null) {
            return null;
        }
        d b = b(packageArchiveInfo, str);
        if (z) {
            SH(str);
            return b;
        }
        return b;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.nUR.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(SE(str), a(SF(str)), packageInfo);
            this.nUR.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader SE(String str) {
        this.nUT = dPH();
        return new DexClassLoader(str, this.nUT, this.nUS, this.mContext.getClassLoader());
    }

    public String dPH() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager SF(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d SG(String str) {
        return this.nUR.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void SH(String str) {
        e.dPJ().x(this.mContext, str, this.nUS);
    }
}
