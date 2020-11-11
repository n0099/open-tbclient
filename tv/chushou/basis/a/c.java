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
    private static c qkW;
    private Context mContext;
    private final HashMap<String, d> qkX = new HashMap<>();
    private String qkY;

    private c(Context context) {
        this.qkY = null;
        this.mContext = context.getApplicationContext();
        this.qkY = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c hA(Context context) {
        if (qkW == null) {
            synchronized (c.class) {
                if (qkW == null) {
                    qkW = new c(context);
                }
            }
        }
        return qkW;
    }

    public d bu(String str, boolean z) {
        PackageInfo packageArchiveInfo;
        d dVar = null;
        if (!TextUtils.isEmpty(str) && aw(new File(str)) && (packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5)) != null) {
            dVar = b(packageArchiveInfo, str);
            if (z) {
                aap(str);
            }
        }
        return dVar;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.qkX.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(aam(str), a(aan(str)), packageInfo);
            this.qkX.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader aam(String str) {
        return new DexClassLoader(str, eHc(), this.qkY, this.mContext.getClassLoader());
    }

    public String eHc() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager aan(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d aao(String str) {
        return this.qkX.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void aap(String str) {
        e.eHe().C(this.mContext, str, this.qkY);
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
