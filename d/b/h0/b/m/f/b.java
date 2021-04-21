package d.b.h0.b.m.f;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import com.alibaba.fastjson.asm.Label;
import d.b.h0.a.k;
import d.b.h0.a.q1.b.b.g;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48139a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f48140b = {"BLA-AL00", "R7Plus"};

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0944b f48141e;

        public a(InterfaceC0944b interfaceC0944b) {
            this.f48141e = interfaceC0944b;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            InterfaceC0944b interfaceC0944b = this.f48141e;
            if (interfaceC0944b != null) {
                interfaceC0944b.onResult(i == -1);
            }
        }
    }

    /* renamed from: d.b.h0.b.m.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0944b {
        void onResult(boolean z);
    }

    public static DialogInterface.OnClickListener a(InterfaceC0944b interfaceC0944b) {
        return new a(interfaceC0944b);
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
        intent.setData(Uri.fromParts("package", packageName, null));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public static void d(Context context) {
        if (!Arrays.asList(f48140b).contains(Build.MODEL)) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            } else if (i >= 21) {
                intent.putExtra("app_package", context.getPackageName());
                intent.putExtra("app_uid", context.getApplicationInfo().uid);
            }
            try {
                context.startActivity(intent);
                return;
            } catch (Exception e2) {
                if (f48139a) {
                    Log.e("GuideHelper", "openNotificationSettingPages() Exception:" + e2);
                }
                c(context);
                return;
            }
        }
        c(context);
    }

    public static void e(Context context, InterfaceC0944b interfaceC0944b) {
        if (!(context instanceof Activity)) {
            if (f48139a) {
                throw new IllegalArgumentException("context must be activity.");
            }
        } else if (interfaceC0944b == null) {
        } else {
            DialogInterface.OnClickListener a2 = a(interfaceC0944b);
            g.a aVar = new g.a(context);
            aVar.n(new d.b.h0.a.j2.g.a());
            g c2 = aVar.c();
            aVar.U(d.b.h0.b.g.swan_app_guide_notify_title);
            aVar.y(context.getString(d.b.h0.b.g.swan_app_guide_notify_msg));
            aVar.z();
            aVar.K(d.b.h0.a.w0.a.z().a());
            aVar.O(d.b.h0.b.g.swan_app_guide_positive_btn, a2);
            aVar.C(d.b.h0.b.g.swan_app_guide_negative_btn, a2);
            aVar.a();
            c2.setCancelable(false);
            c2.show();
        }
    }
}
