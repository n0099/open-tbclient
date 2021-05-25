package d.a.l0.b.n.f;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tieba.service.AsInstallService;
import d.a.l0.a.k;
import d.a.l0.a.z1.b.b.h;
import d.a.l0.b.g;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46380a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f46381b = {"BLA-AL00", "R7Plus"};

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0955b f46382e;

        public a(InterfaceC0955b interfaceC0955b) {
            this.f46382e = interfaceC0955b;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            InterfaceC0955b interfaceC0955b = this.f46382e;
            if (interfaceC0955b != null) {
                interfaceC0955b.onResult(i2 == -1);
            }
        }
    }

    /* renamed from: d.a.l0.b.n.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0955b {
        void onResult(boolean z);
    }

    public static DialogInterface.OnClickListener a(InterfaceC0955b interfaceC0955b) {
        return new a(interfaceC0955b);
    }

    public static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        return true;
    }

    public static void c(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, packageName, null));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public static void d(Context context) {
        if (!Arrays.asList(f46381b).contains(Build.MODEL)) {
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
                if (f46380a) {
                    Log.e("GuideHelper", "openNotificationSettingPages() Exception:" + e2);
                }
                c(context);
                return;
            }
        }
        c(context);
    }

    public static void e(Context context, InterfaceC0955b interfaceC0955b) {
        if (!(context instanceof Activity)) {
            if (f46380a) {
                throw new IllegalArgumentException("context must be activity.");
            }
        } else if (interfaceC0955b == null) {
        } else {
            DialogInterface.OnClickListener a2 = a(interfaceC0955b);
            h.a aVar = new h.a(context);
            aVar.n(new d.a.l0.a.w2.h.a());
            h c2 = aVar.c();
            aVar.U(g.swan_app_guide_notify_title);
            aVar.x(context.getString(g.swan_app_guide_notify_msg));
            aVar.y();
            aVar.J(d.a.l0.a.c1.a.H().a());
            aVar.O(g.swan_app_guide_positive_btn, a2);
            aVar.B(g.swan_app_guide_negative_btn, a2);
            aVar.a();
            c2.setCancelable(false);
            c2.show();
        }
    }
}
