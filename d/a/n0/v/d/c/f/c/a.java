package d.a.n0.v.d.c.f.c;

import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.service.AsInstallService;
/* loaded from: classes4.dex */
public class a {
    public static boolean a(TbPageContext tbPageContext) {
        return NotificationManagerCompat.from(tbPageContext.getPageActivity()).areNotificationsEnabled();
    }

    public static void b(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", tbPageContext.getPageActivity().getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", tbPageContext.getPageActivity().getApplicationInfo().uid);
            intent.putExtra("app_package", tbPageContext.getPageActivity().getPackageName());
            intent.putExtra("app_uid", tbPageContext.getPageActivity().getApplicationInfo().uid);
            tbPageContext.getPageActivity().startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            Intent intent2 = new Intent();
            intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, tbPageContext.getPageActivity().getPackageName(), null));
            tbPageContext.getPageActivity().startActivity(intent2);
        }
    }
}
