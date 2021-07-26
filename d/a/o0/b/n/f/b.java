package d.a.o0.b.n.f;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.z1.b.b.h;
import d.a.o0.b.g;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49510a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f49511b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1032b f49512e;

        public a(InterfaceC1032b interfaceC1032b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1032b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49512e = interfaceC1032b;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            InterfaceC1032b interfaceC1032b;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (interfaceC1032b = this.f49512e) == null) {
                return;
            }
            interfaceC1032b.onResult(i2 == -1);
        }
    }

    /* renamed from: d.a.o0.b.n.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1032b {
        void onResult(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(544202105, "Ld/a/o0/b/n/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(544202105, "Ld/a/o0/b/n/f/b;");
                return;
            }
        }
        f49510a = k.f46335a;
        f49511b = new String[]{"BLA-AL00", "R7Plus"};
    }

    public static DialogInterface.OnClickListener a(InterfaceC1032b interfaceC1032b) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, interfaceC1032b)) == null) ? new a(interfaceC1032b) : (DialogInterface.OnClickListener) invokeL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return NotificationManagerCompat.from(context).areNotificationsEnabled();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            String packageName = context.getPackageName();
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, packageName, null));
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(intent);
        }
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            if (!Arrays.asList(f49511b).contains(Build.MODEL)) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                } else if (i2 >= 21) {
                    intent.putExtra("app_package", context.getPackageName());
                    intent.putExtra("app_uid", context.getApplicationInfo().uid);
                }
                try {
                    context.startActivity(intent);
                    return;
                } catch (Exception e2) {
                    if (f49510a) {
                        Log.e("GuideHelper", "openNotificationSettingPages() Exception:" + e2);
                    }
                    c(context);
                    return;
                }
            }
            c(context);
        }
    }

    public static void e(Context context, InterfaceC1032b interfaceC1032b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, interfaceC1032b) == null) {
            if (!(context instanceof Activity)) {
                if (f49510a) {
                    throw new IllegalArgumentException("context must be activity.");
                }
            } else if (interfaceC1032b == null) {
            } else {
                DialogInterface.OnClickListener a2 = a(interfaceC1032b);
                h.a aVar = new h.a(context);
                aVar.n(new d.a.o0.a.w2.h.a());
                h c2 = aVar.c();
                aVar.U(g.swan_app_guide_notify_title);
                aVar.x(context.getString(g.swan_app_guide_notify_msg));
                aVar.y();
                aVar.J(d.a.o0.a.c1.a.H().a());
                aVar.O(g.swan_app_guide_positive_btn, a2);
                aVar.B(g.swan_app_guide_negative_btn, a2);
                aVar.a();
                c2.setCancelable(false);
                c2.show();
            }
        }
    }
}
