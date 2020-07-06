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
    private static c oir;
    private Context mContext;
    private final HashMap<String, d> ois = new HashMap<>();
    private String oit;

    private c(Context context) {
        this.oit = null;
        this.mContext = context.getApplicationContext();
        this.oit = this.mContext.getDir("pluginlib", 0).getAbsolutePath();
    }

    public static c gt(Context context) {
        if (oir == null) {
            synchronized (c.class) {
                if (oir == null) {
                    oir = new c(context);
                }
            }
        }
        return oir;
    }

    public d bg(String str, boolean z) {
        PackageInfo packageArchiveInfo;
        d dVar = null;
        if (!TextUtils.isEmpty(str) && ao(new File(str)) && (packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 5)) != null) {
            dVar = b(packageArchiveInfo, str);
            if (z) {
                ST(str);
            }
        }
        return dVar;
    }

    private d b(PackageInfo packageInfo, String str) {
        d dVar = this.ois.get(packageInfo.packageName);
        if (dVar == null) {
            d dVar2 = new d(SQ(str), a(SR(str)), packageInfo);
            this.ois.put(packageInfo.packageName, dVar2);
            return dVar2;
        }
        return dVar;
    }

    private DexClassLoader SQ(String str) {
        return new DexClassLoader(str, dVW(), this.oit, this.mContext.getClassLoader());
    }

    public String dVW() {
        return this.mContext.getDir("dex", 0).getAbsolutePath();
    }

    private AssetManager SR(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public d SS(String str) {
        return this.ois.get(str);
    }

    private Resources a(AssetManager assetManager) {
        Resources resources = this.mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private void ST(String str) {
        e.dVY().w(this.mContext, str, this.oit);
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
