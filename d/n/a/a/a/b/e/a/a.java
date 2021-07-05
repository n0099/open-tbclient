package d.n.a.a.a.b.e.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f75071c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f75072d;

    /* renamed from: e  reason: collision with root package name */
    public static HandlerThread f75073e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f75074f;

    /* renamed from: g  reason: collision with root package name */
    public static String f75075g;

    /* renamed from: h  reason: collision with root package name */
    public static String f75076h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f75077a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f75078b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1542198079, "Ld/n/a/a/a/b/e/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1542198079, "Ld/n/a/a/a/b/e/a/a;");
                return;
            }
        }
        f75072d = new Object();
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f75078b = false;
        this.f75077a = context;
        HandlerThread handlerThread = new HandlerThread("meizu_work");
        f75073e = handlerThread;
        handlerThread.start();
        f75074f = new b(this, f75073e.getLooper(), context);
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f75071c == null) {
                synchronized (a.class) {
                    if (f75071c == null) {
                        f75071c = new a(context);
                    }
                }
            }
            return f75071c;
        }
        return (a) invokeL.objValue;
    }

    public static String f(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) != null) {
            return (String) invokeLL.objValue;
        }
        Cursor cursor = null;
        r0 = null;
        r0 = null;
        String str3 = null;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        str3 = query.getString(query.getColumnIndex("value"));
                        d.n.a.a.c.b.b.e("getIdFromContentProvider meizu " + str3 + " " + str);
                    }
                } catch (Throwable th) {
                    th = th;
                    String str4 = str3;
                    cursor = query;
                    str2 = str4;
                    try {
                        d.n.a.a.c.b.b.c(th);
                        return str2;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (query != null) {
                query.close();
                return str3;
            }
            return str3;
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? h() : invokeV.booleanValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (h()) {
                String str = f75076h;
                if (str != null) {
                    return str;
                }
                try {
                    synchronized (f75072d) {
                        Message obtainMessage = f75074f.obtainMessage();
                        obtainMessage.what = TTAdConstant.STYLE_SIZE_RADIO_2_3;
                        Bundle bundle = new Bundle();
                        bundle.putInt("type", 0);
                        bundle.putString("appid", "oaid");
                        obtainMessage.setData(bundle);
                        f75074f.sendMessage(obtainMessage);
                        long uptimeMillis = SystemClock.uptimeMillis();
                        try {
                            f75072d.wait(2000L);
                        } catch (InterruptedException unused) {
                        }
                        if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                            f75076h = f75075g;
                            f75075g = null;
                        }
                    }
                } catch (Throwable th) {
                    d.n.a.a.c.b.b.c(th);
                }
                return f75076h;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
        if (r0 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
        return r10.f75078b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
            return invokeV.booleanValue;
        }
        Cursor cursor = null;
        try {
            if (this.f75078b) {
                return this.f75078b;
            }
            PackageManager packageManager = this.f75077a.getPackageManager();
            if (packageManager == null) {
                this.f75078b = false;
            }
            if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                d.n.a.a.c.b.b.e("resolveContentProvider meizu");
                cursor = this.f75077a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursor == null) {
                    this.f75078b = false;
                }
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    String string = cursor.getString(columnIndex);
                    d.n.a.a.c.b.b.e("resolveContentProvider meizu " + string);
                    this.f75078b = "0".equals(string);
                }
            } else {
                this.f75078b = false;
            }
        } catch (Throwable th) {
            try {
                d.n.a.a.c.b.b.c(th);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }
}
