package d.a.n0.q3;

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
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public KeyguardManager f62041a;

    /* renamed from: b  reason: collision with root package name */
    public PowerManager f62042b;

    /* renamed from: c  reason: collision with root package name */
    public PowerManager.WakeLock f62043c;

    /* renamed from: d  reason: collision with root package name */
    public KeyguardManager.KeyguardLock f62044d;

    /* renamed from: e  reason: collision with root package name */
    public Context f62045e;

    public b() {
        try {
            Application app = TbadkCoreApplication.getInst().getApp();
            this.f62045e = app;
            PowerManager powerManager = (PowerManager) app.getSystemService("power");
            this.f62042b = powerManager;
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(268435462, "ScreenLockNotify");
            this.f62043c = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            KeyguardManager keyguardManager = (KeyguardManager) this.f62045e.getSystemService("keyguard");
            this.f62041a = keyguardManager;
            this.f62044d = keyguardManager.newKeyguardLock("ScreenLockUtils");
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
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.f62041a, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f62042b.isScreenOn();
    }

    public void d() {
        try {
            this.f62044d.reenableKeyguard();
            if (this.f62043c != null) {
                this.f62043c.release();
                this.f62043c = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void e() {
        try {
            if (this.f62043c == null) {
                PowerManager.WakeLock newWakeLock = this.f62042b.newWakeLock(268435462, "ScreenLockNotify");
                this.f62043c = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
            if (this.f62043c != null) {
                this.f62043c.acquire(10000L);
                this.f62044d.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
