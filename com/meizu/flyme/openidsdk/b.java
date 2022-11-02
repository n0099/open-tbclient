package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    @Keep
    public static volatile b e;
    @Keep
    public static boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public OpenId a;
    @Keep
    public OpenId b;
    @Keep
    public OpenId c;
    @Keep
    public OpenId d;
    @Keep
    public SupportInfo g;
    @Keep
    public BroadcastReceiver h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1824161460, "Lcom/meizu/flyme/openidsdk/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1824161460, "Lcom/meizu/flyme/openidsdk/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new OpenId("udid");
        this.b = new OpenId("oaid");
        this.d = new OpenId("vaid");
        this.c = new OpenId("aaid");
        this.g = new SupportInfo();
    }

    @Keep
    public static native ValueData a(Cursor cursor);

    @Keep
    public static final native b a();

    @Keep
    public static native String a(PackageManager packageManager, String str);

    @Keep
    public static native void a(String str);

    @Keep
    public static native void a(boolean z);

    @Keep
    public static native boolean a(Context context);

    @Keep
    private native String b(Context context, OpenId openId);

    @Keep
    public static native String b(PackageManager packageManager, String str);

    @Keep
    private native synchronized void b(Context context);

    @Keep
    public final native String a(Context context, OpenId openId);

    @Keep
    public final native boolean a(Context context, boolean z);
}
