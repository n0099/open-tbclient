package d.a.c.e.m;

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
    public static final ColorStateList f42475c = ColorStateList.valueOf(-16777216);

    /* renamed from: a  reason: collision with root package name */
    public Resources f42476a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42477b;

    public c(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f42476a = resources;
        this.f42477b = false;
    }

    public final void a(String str, int i2) {
        String str2;
        try {
            str2 = this.f42476a.getResourceEntryName(i2);
        } catch (Exception unused) {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            BdStatisticsManager.getInstance().error("resources", str, null, -9115, null, "resid", Integer.valueOf(i2), "resname", str2);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) throws Resources.NotFoundException {
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                return this.f42476a.getColor(i2);
            } catch (OutOfMemoryError e2) {
                if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42477b)) {
                    throw e2;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            } catch (RuntimeException e3) {
                if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42477b)) {
                    throw e3;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        a("color", i2);
        return 0;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2) throws Resources.NotFoundException {
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                return this.f42476a.getColorStateList(i2);
            } catch (OutOfMemoryError e2) {
                if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42477b)) {
                    throw e2;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            } catch (RuntimeException e3) {
                if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42477b)) {
                    throw e3;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        a("colorstatelist", i2);
        return f42475c;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                return this.f42476a.getDrawable(i2);
            } catch (OutOfMemoryError e2) {
                if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42477b)) {
                    throw e2;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            } catch (RuntimeException e3) {
                if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42477b)) {
                    throw e3;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        a("drawable", i2);
        return null;
    }

    @Override // android.content.res.Resources
    public String getString(int i2) throws Resources.NotFoundException {
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                return this.f42476a.getString(i2);
            } catch (OutOfMemoryError e2) {
                if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42477b)) {
                    throw e2;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            } catch (RuntimeException e3) {
                if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f42477b)) {
                    throw e3;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        a("string", i2);
        return "";
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2) throws Resources.NotFoundException {
        return this.f42476a.openRawResource(i2);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f42476a.openRawResource(i2, typedValue);
    }
}
