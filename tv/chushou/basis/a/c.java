package tv.chushou.basis.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c {
    private static c nqs;
    private Context mContext;
    private final HashMap<String, d> nqt = new HashMap<>();
    private String nqu;
    private String nqv;

    private c(Context context) {
        this.nqu = null;
        this.mContext = context.getApplicationContext();
        this.nqu = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c fR(Context context) {
        if (nqs == null) {
            synchronized (c.class) {
                if (nqs == null) {
                    nqs = new c(context);
                }
            }
        }
        return nqs;
    }

    public d aR(String str, boolean z) {
        PackageInfo packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5);
        if (packageArchiveInfo == null) {
            return null;
        }
        d b = b(packageArchiveInfo, str);
        if (z) {
            PZ(str);
            return b;
        }
        return b;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.nqt.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(PW(str), a(PX(str)), packageInfo);
            this.nqt.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader PW(String str) {
        this.nqv = dJd();
        return new DexClassLoader(str, this.nqv, this.nqu, this.mContext.getClassLoader());
    }

    public String dJd() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager PX(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d PY(String str) {
        return this.nqt.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void PZ(String str) {
        e.dJf().x(this.mContext, str, this.nqu);
    }
}
