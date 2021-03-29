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
    public KeyguardManager f57308a;

    /* renamed from: b  reason: collision with root package name */
    public PowerManager f57309b;

    /* renamed from: c  reason: collision with root package name */
    public PowerManager.WakeLock f57310c;

    /* renamed from: d  reason: collision with root package name */
    public KeyguardManager.KeyguardLock f57311d;

    /* renamed from: e  reason: collision with root package name */
    public Context f57312e;

    public b() {
        try {
            Application app = TbadkCoreApplication.getInst().getApp();
            this.f57312e = app;
            PowerManager powerManager = (PowerManager) app.getSystemService("power");
            this.f57309b = powerManager;
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(268435462, "ScreenLockNotify");
            this.f57310c = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            KeyguardManager keyguardManager = (KeyguardManager) this.f57312e.getSystemService("keyguard");
            this.f57308a = keyguardManager;
            this.f57311d = keyguardManager.newKeyguardLock("ScreenLockUtils");
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
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.f57308a, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f57309b.isScreenOn();
    }

    public void d() {
        try {
            this.f57311d.reenableKeyguard();
            if (this.f57310c != null) {
                this.f57310c.release();
                this.f57310c = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void e() {
        try {
            if (this.f57310c == null) {
                PowerManager.WakeLock newWakeLock = this.f57309b.newWakeLock(268435462, "ScreenLockNotify");
                this.f57310c = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
            if (this.f57310c != null) {
                this.f57310c.acquire(10000L);
                this.f57311d.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
