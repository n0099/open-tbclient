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
    public static final boolean f50054a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f50055b = {"BLA-AL00", "R7Plus"};

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1011b f50056e;

        public a(InterfaceC1011b interfaceC1011b) {
            this.f50056e = interfaceC1011b;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            InterfaceC1011b interfaceC1011b = this.f50056e;
            if (interfaceC1011b != null) {
                interfaceC1011b.onResult(i2 == -1);
            }
        }
    }

    /* renamed from: d.a.l0.b.n.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1011b {
        void onResult(boolean z);
    }

    public static DialogInterface.OnClickListener a(InterfaceC1011b interfaceC1011b) {
        return new a(interfaceC1011b);
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
        if (!Arrays.asList(f50055b).contains(Build.MODEL)) {
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
                if (f50054a) {
                    Log.e("GuideHelper", "openNotificationSettingPages() Exception:" + e2);
                }
                c(context);
                return;
            }
        }
        c(context);
    }

    public static void e(Context context, InterfaceC1011b interfaceC1011b) {
        if (!(context instanceof Activity)) {
            if (f50054a) {
                throw new IllegalArgumentException("context must be activity.");
            }
        } else if (interfaceC1011b == null) {
        } else {
            DialogInterface.OnClickListener a2 = a(interfaceC1011b);
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
