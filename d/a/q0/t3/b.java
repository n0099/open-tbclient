package d.a.q0.t3;

import android.app.Application;
import android.app.KeyguardManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KeyguardManager f63039a;

    /* renamed from: b  reason: collision with root package name */
    public PowerManager f63040b;

    /* renamed from: c  reason: collision with root package name */
    public PowerManager.WakeLock f63041c;

    /* renamed from: d  reason: collision with root package name */
    public KeyguardManager.KeyguardLock f63042d;

    /* renamed from: e  reason: collision with root package name */
    public Context f63043e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            Application app = TbadkCoreApplication.getInst().getApp();
            this.f63043e = app;
            PowerManager powerManager = (PowerManager) app.getSystemService("power");
            this.f63040b = powerManager;
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(268435462, "ScreenLockNotify");
            this.f63041c = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            KeyguardManager keyguardManager = (KeyguardManager) this.f63043e.getSystemService("keyguard");
            this.f63039a = keyguardManager;
            this.f63042d = keyguardManager.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Drawable a() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65537, null)) != null) {
            return (Drawable) invokeV.objValue;
        }
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
                } catch (Throwable unused) {
                    return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, min, min2));
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                return null;
            }
        } catch (Exception unused2) {
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.f63039a, new Object[0])).booleanValue();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63040b.isScreenOn() : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.f63042d.reenableKeyguard();
                if (this.f63041c != null) {
                    this.f63041c.release();
                    this.f63041c = null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.f63041c == null) {
                    PowerManager.WakeLock newWakeLock = this.f63040b.newWakeLock(268435462, "ScreenLockNotify");
                    this.f63041c = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
                if (this.f63041c != null) {
                    this.f63041c.acquire(10000L);
                    this.f63042d.disableKeyguard();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
