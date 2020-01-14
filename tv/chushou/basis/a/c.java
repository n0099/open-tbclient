package tv.chushou.basis.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c {
    private static c nTP;
    private Context mContext;
    private final HashMap<String, d> nTQ = new HashMap<>();
    private String nTR;
    private String nTS;

    private c(Context context) {
        this.nTR = null;
        this.mContext = context.getApplicationContext();
        this.nTR = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c hb(Context context) {
        if (nTP == null) {
            synchronized (c.class) {
                if (nTP == null) {
                    nTP = new c(context);
                }
            }
        }
        return nTP;
    }

    public d aV(String str, boolean z) {
        PackageInfo packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5);
        if (packageArchiveInfo == null) {
            return null;
        }
        d b = b(packageArchiveInfo, str);
        if (z) {
            Sv(str);
            return b;
        }
        return b;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.nTQ.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(Ss(str), a(St(str)), packageInfo);
            this.nTQ.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader Ss(String str) {
        this.nTS = dOr();
        return new DexClassLoader(str, this.nTS, this.nTR, this.mContext.getClassLoader());
    }

    public String dOr() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager St(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d Su(String str) {
        return this.nTQ.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void Sv(String str) {
        e.dOt().y(this.mContext, str, this.nTR);
    }
}
