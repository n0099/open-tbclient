package d.n.a.a.a.b.i.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
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
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f75104c;

    /* renamed from: d  reason: collision with root package name */
    public static a f75105d;

    /* renamed from: e  reason: collision with root package name */
    public static Object f75106e;

    /* renamed from: f  reason: collision with root package name */
    public static HandlerThread f75107f;

    /* renamed from: g  reason: collision with root package name */
    public static Handler f75108g;

    /* renamed from: h  reason: collision with root package name */
    public static String f75109h;

    /* renamed from: i  reason: collision with root package name */
    public static String f75110i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f75111a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f75112b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1427681444, "Ld/n/a/a/a/b/i/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1427681444, "Ld/n/a/a/a/b/i/a/b;");
                return;
            }
        }
        f75106e = new Object();
    }

    public b(Context context) {
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
        this.f75112b = false;
        this.f75111a = context;
        boolean equals = "1".equals(d("persist.sys.identifierid.supported", "0"));
        this.f75112b = equals;
        if (equals) {
            HandlerThread handlerThread = new HandlerThread("vivo_work");
            f75107f = handlerThread;
            handlerThread.start();
            f75108g = new c(this, f75107f.getLooper(), context);
        }
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f75104c == null) {
                synchronized (b.class) {
                    if (f75104c == null) {
                        f75104c = new b(context);
                    }
                }
            }
            return f75104c;
        }
        return (b) invokeL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Throwable unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        Cursor cursor;
        String str2;
        Uri parse;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(AdIconUtil.BAIDU_LOGO_ID, null, context, i2, str)) == null) {
            String str3 = null;
            try {
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            if (i2 == 0) {
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
            } else if (i2 == 1) {
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str;
            } else if (i2 != 2) {
                parse = null;
                query = context.getContentResolver().query(parse, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            str3 = query.getString(query.getColumnIndex("value"));
                        }
                    } catch (Throwable th2) {
                        cursor = query;
                        th = th2;
                        try {
                            d.n.a.a.c.b.b.c(th);
                            return str3;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return str3;
            } else {
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str;
            }
            parse = Uri.parse(str2);
            query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null) {
            }
            if (query != null) {
            }
            return str3;
        }
        return (String) invokeLIL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
        if (android.text.TextUtils.isEmpty(d.n.a.a.a.b.i.a.b.f75109h) == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            try {
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return;
            }
            synchronized (f75106e) {
                Message obtainMessage = f75108g.obtainMessage();
                obtainMessage.what = TTAdConstant.STYLE_SIZE_RADIO_2_3;
                Bundle bundle = new Bundle();
                bundle.putInt("type", i2);
                if (i2 == 1 || i2 == 2) {
                    bundle.putString("appid", str);
                }
                obtainMessage.setData(bundle);
                f75108g.sendMessage(obtainMessage);
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    f75106e.wait(2000L);
                } catch (InterruptedException unused) {
                }
                if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && !TextUtils.isEmpty(f75109h)) {
                            }
                        }
                        d.n.a.a.c.b.b.c(th);
                        return;
                    }
                    f75110i = f75109h;
                    f75109h = null;
                }
            }
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f75112b : invokeV.booleanValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f75112b) {
                String str = f75110i;
                if (str != null) {
                    return str;
                }
                e(0, null);
                if (f75105d == null) {
                    Context context = this.f75111a;
                    f75105d = new a(f75104c, 0, null);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f75105d);
                }
                return f75110i;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }
}
