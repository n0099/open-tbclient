package d.b.i0.o3;

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
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public KeyguardManager f57307a;

    /* renamed from: b  reason: collision with root package name */
    public PowerManager f57308b;

    /* renamed from: c  reason: collision with root package name */
    public PowerManager.WakeLock f57309c;

    /* renamed from: d  reason: collision with root package name */
    public KeyguardManager.KeyguardLock f57310d;

    /* renamed from: e  reason: collision with root package name */
    public Context f57311e;

    public b() {
        try {
            Application app = TbadkCoreApplication.getInst().getApp();
            this.f57311e = app;
            PowerManager powerManager = (PowerManager) app.getSystemService("power");
            this.f57308b = powerManager;
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(268435462, "ScreenLockNotify");
            this.f57309c = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            KeyguardManager keyguardManager = (KeyguardManager) this.f57311e.getSystemService("keyguard");
            this.f57307a = keyguardManager;
            this.f57310d = keyguardManager.newKeyguardLock("ScreenLockUtils");
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
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.f57307a, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f57308b.isScreenOn();
    }

    public void d() {
        try {
            this.f57310d.reenableKeyguard();
            if (this.f57309c != null) {
                this.f57309c.release();
                this.f57309c = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void e() {
        try {
            if (this.f57309c == null) {
                PowerManager.WakeLock newWakeLock = this.f57308b.newWakeLock(268435462, "ScreenLockNotify");
                this.f57309c = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
            if (this.f57309c != null) {
                this.f57309c.acquire(10000L);
                this.f57310d.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
