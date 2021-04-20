package d.b.i0.p3;

import android.app.Application;
import android.app.KeyguardManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public KeyguardManager f58954a;

    /* renamed from: b  reason: collision with root package name */
    public PowerManager f58955b;

    /* renamed from: c  reason: collision with root package name */
    public PowerManager.WakeLock f58956c;

    /* renamed from: d  reason: collision with root package name */
    public KeyguardManager.KeyguardLock f58957d;

    /* renamed from: e  reason: collision with root package name */
    public Context f58958e;

    public b() {
        try {
            Application app = TbadkCoreApplication.getInst().getApp();
            this.f58958e = app;
            PowerManager powerManager = (PowerManager) app.getSystemService("power");
            this.f58955b = powerManager;
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(268435462, "ScreenLockNotify");
            this.f58956c = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            KeyguardManager keyguardManager = (KeyguardManager) this.f58958e.getSystemService("keyguard");
            this.f58954a = keyguardManager;
            this.f58957d = keyguardManager.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Drawable a() {
        Bitmap bitmap;
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        try {
            Drawable drawable = WallpaperManager.getInstance(inst).getDrawable();
            if (drawable == null || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
                return null;
            }
            int min = Math.min(l.k(inst), bitmap.getWidth());
            int min2 = Math.min(l.i(inst), bitmap.getHeight());
            try {
                try {
                    return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, min, min2));
                } catch (Throwable th) {
                    BdLog.e(th.getMessage());
                    return null;
                }
            } catch (Throwable unused) {
                return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, min, min2));
            }
        } catch (Exception unused2) {
        }
    }

    public boolean b() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.f58954a, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f58955b.isScreenOn();
    }

    public void d() {
        try {
            this.f58957d.reenableKeyguard();
            if (this.f58956c != null) {
                this.f58956c.release();
                this.f58956c = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void e() {
        try {
            if (this.f58956c == null) {
                PowerManager.WakeLock newWakeLock = this.f58955b.newWakeLock(268435462, "ScreenLockNotify");
                this.f58956c = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
            if (this.f58956c != null) {
                this.f58956c.acquire(10000L);
                this.f58957d.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
