package d.b.c.e.m;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import java.io.InputStream;
/* loaded from: classes.dex */
public class c extends Resources {

    /* renamed from: c  reason: collision with root package name */
    public static final ColorStateList f42367c = ColorStateList.valueOf(-16777216);

    /* renamed from: a  reason: collision with root package name */
    public Resources f42368a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42369b;

    public c(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f42368a = resources;
        this.f42369b = false;
    }

    public final void a(String str, int i) {
        String str2;
        try {
            str2 = this.f42368a.getResourceEntryName(i);
        } catch (Exception unused) {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            BdStatisticsManager.getInstance().error("resources", str, null, -9115, null, "resid", Integer.valueOf(i), "resname", str2);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                return this.f42368a.getColor(i);
            } catch (OutOfMemoryError e2) {
                if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42369b)) {
                    throw e2;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            } catch (RuntimeException e3) {
                if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42369b)) {
                    throw e3;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        a("color", i);
        return 0;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                return this.f42368a.getColorStateList(i);
            } catch (OutOfMemoryError e2) {
                if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42369b)) {
                    throw e2;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            } catch (RuntimeException e3) {
                if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42369b)) {
                    throw e3;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        a("colorstatelist", i);
        return f42367c;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                return this.f42368a.getDrawable(i);
            } catch (OutOfMemoryError e2) {
                if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42369b)) {
                    throw e2;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            } catch (RuntimeException e3) {
                if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42369b)) {
                    throw e3;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        a("drawable", i);
        return null;
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                return this.f42368a.getString(i);
            } catch (OutOfMemoryError e2) {
                if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42369b)) {
                    throw e2;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            } catch (RuntimeException e3) {
                if (i2 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42369b)) {
                    throw e3;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        a("string", i);
        return "";
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        return this.f42368a.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f42368a.openRawResource(i, typedValue);
    }
}
