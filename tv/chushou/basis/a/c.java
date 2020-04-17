package tv.chushou.basis.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c {
    private static c nqp;
    private Context mContext;
    private final HashMap<String, d> nqq = new HashMap<>();
    private String nqr;
    private String nqs;

    private c(Context context) {
        this.nqr = null;
        this.mContext = context.getApplicationContext();
        this.nqr = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c ge(Context context) {
        if (nqp == null) {
            synchronized (c.class) {
                if (nqp == null) {
                    nqp = new c(context);
                }
            }
        }
        return nqp;
    }

    public d aR(String str, boolean z) {
        PackageInfo packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5);
        if (packageArchiveInfo == null) {
            return null;
        }
        d b = b(packageArchiveInfo, str);
        if (z) {
            PW(str);
            return b;
        }
        return b;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.nqq.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(PT(str), a(PU(str)), packageInfo);
            this.nqq.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader PT(String str) {
        this.nqs = dJh();
        return new DexClassLoader(str, this.nqs, this.nqr, this.mContext.getClassLoader());
    }

    public String dJh() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager PU(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d PV(String str) {
        return this.nqq.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void PW(String str) {
        e.dJj().v(this.mContext, str, this.nqr);
    }
}
