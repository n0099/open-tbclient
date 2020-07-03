package tv.chushou.basis.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c {
    private static c oio;
    private Context mContext;
    private final HashMap<String, d> oip = new HashMap<>();
    private String oiq;

    private c(Context context) {
        this.oiq = null;
        this.mContext = context.getApplicationContext();
        this.oiq = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c gt(Context context) {
        if (oio == null) {
            synchronized (c.class) {
                if (oio == null) {
                    oio = new c(context);
                }
            }
        }
        return oio;
    }

    public d bg(String str, boolean z) {
        PackageInfo packageArchiveInfo;
        d dVar = null;
        if (!TextUtils.isEmpty(str) && ao(new File(str)) && (packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5)) != null) {
            dVar = b(packageArchiveInfo, str);
            if (z) {
                SS(str);
            }
        }
        return dVar;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.oip.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(SP(str), a(SQ(str)), packageInfo);
            this.oip.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader SP(String str) {
        return new DexClassLoader(str, dVS(), this.oiq, this.mContext.getClassLoader());
    }

    public String dVS() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager SQ(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d SR(String str) {
        return this.oip.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void SS(String str) {
        e.dVU().w(this.mContext, str, this.oiq);
    }

    private boolean ao(File file) {
        File filesDir = this.mContext.getFilesDir();
        for (File parentFile = file.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            if (parentFile.equals(filesDir)) {
                return true;
            }
        }
        return false;
    }
}
