package d.a.j0.p3;

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
    public KeyguardManager f57412a;

    /* renamed from: b  reason: collision with root package name */
    public PowerManager f57413b;

    /* renamed from: c  reason: collision with root package name */
    public PowerManager.WakeLock f57414c;

    /* renamed from: d  reason: collision with root package name */
    public KeyguardManager.KeyguardLock f57415d;

    /* renamed from: e  reason: collision with root package name */
    public Context f57416e;

    public b() {
        try {
            Application app = TbadkCoreApplication.getInst().getApp();
            this.f57416e = app;
            PowerManager powerManager = (PowerManager) app.getSystemService("power");
            this.f57413b = powerManager;
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(268435462, "ScreenLockNotify");
            this.f57414c = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            KeyguardManager keyguardManager = (KeyguardManager) this.f57416e.getSystemService("keyguard");
            this.f57412a = keyguardManager;
            this.f57415d = keyguardManager.newKeyguardLock("ScreenLockUtils");
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
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.f57412a, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f57413b.isScreenOn();
    }

    public void d() {
        try {
            this.f57415d.reenableKeyguard();
            if (this.f57414c != null) {
                this.f57414c.release();
                this.f57414c = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void e() {
        try {
            if (this.f57414c == null) {
                PowerManager.WakeLock newWakeLock = this.f57413b.newWakeLock(268435462, "ScreenLockNotify");
                this.f57414c = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
            if (this.f57414c != null) {
                this.f57414c.acquire(10000L);
                this.f57415d.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
