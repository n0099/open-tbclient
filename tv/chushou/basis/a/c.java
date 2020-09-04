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
    private static c oLo;
    private Context mContext;
    private final HashMap<String, d> oLp = new HashMap<>();
    private String oLq;

    private c(Context context) {
        this.oLq = null;
        this.mContext = context.getApplicationContext();
        this.oLq = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c gT(Context context) {
        if (oLo == null) {
            synchronized (c.class) {
                if (oLo == null) {
                    oLo = new c(context);
                }
            }
        }
        return oLo;
    }

    public d bh(String str, boolean z) {
        PackageInfo packageArchiveInfo;
        d dVar = null;
        if (!TextUtils.isEmpty(str) && as(new File(str)) && (packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5)) != null) {
            dVar = b(packageArchiveInfo, str);
            if (z) {
                WI(str);
            }
        }
        return dVar;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.oLp.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(WF(str), a(WG(str)), packageInfo);
            this.oLp.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader WF(String str) {
        return new DexClassLoader(str, elG(), this.oLq, this.mContext.getClassLoader());
    }

    public String elG() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager WG(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d WH(String str) {
        return this.oLp.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void WI(String str) {
        e.elI().v(this.mContext, str, this.oLq);
    }

    private boolean as(File file) {
        File filesDir = this.mContext.getFilesDir();
        for (File parentFile = file.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            if (parentFile.equals(filesDir)) {
                return true;
            }
        }
        return false;
    }
}
