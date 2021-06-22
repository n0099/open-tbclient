package d.a.n0.s.h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.CustomPushPremissionDialogView;
import com.baidu.tieba.R;
import com.baidu.tieba.service.AsInstallService;
import d.a.c.a.f;
import d.a.n0.r.s.a;
import java.util.Date;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.n0.s.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnClickListenerC1216a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f54464e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int[] f54465f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f54466g;

        public View$OnClickListenerC1216a(TbPageContext tbPageContext, int[] iArr, d.a.n0.r.s.a aVar) {
            this.f54464e = tbPageContext;
            this.f54465f = iArr;
            this.f54466g = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.c(this.f54464e);
            this.f54465f[0] = 1;
            this.f54466g.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f54467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f54468f;

        public b(int[] iArr, d.a.n0.r.s.a aVar) {
            this.f54467e = iArr;
            this.f54468f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f54467e[0] = 2;
            this.f54468f.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54469e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int[] f54470f;

        public c(int i2, int[] iArr) {
            this.f54469e = i2;
            this.f54470f = iArr;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            StatisticItem statisticItem = new StatisticItem("c13673");
            statisticItem.param("obj_source", this.f54469e);
            statisticItem.param("obj_type", this.f54470f[0]);
            TiebaStatic.log(statisticItem);
        }
    }

    public static d.a.n0.r.s.a a(TbPageContext<?> tbPageContext, int i2, int i3, int i4, int i5, a.e eVar, a.e eVar2) {
        return b(tbPageContext, i2 >= 0 ? TbadkCoreApplication.getInst().getContext().getString(i2) : null, TbadkCoreApplication.getInst().getContext().getString(i3), TbadkCoreApplication.getInst().getContext().getString(i4), TbadkCoreApplication.getInst().getContext().getString(i5), eVar, eVar2);
    }

    public static d.a.n0.r.s.a b(TbPageContext<?> tbPageContext, String str, String str2, String str3, String str4, a.e eVar, a.e eVar2) {
        if (tbPageContext == null) {
            return null;
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(tbPageContext.getPageActivity());
        aVar.setTitle(str);
        aVar.setMessage(str2);
        aVar.setPositiveButton(str3, eVar);
        aVar.setNegativeButton(str4, eVar2);
        aVar.create(tbPageContext);
        return aVar;
    }

    public static void c(f fVar) {
        try {
            if (DeviceInfoUtil.isHuaWei()) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, fVar.getPageActivity().getPackageName(), null));
                fVar.getPageActivity().startActivity(intent);
            } else {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent2.putExtra("android.provider.extra.APP_PACKAGE", fVar.getPageActivity().getPackageName());
                intent2.putExtra("android.provider.extra.CHANNEL_ID", fVar.getPageActivity().getApplicationInfo().uid);
                intent2.putExtra("app_package", fVar.getPageActivity().getPackageName());
                intent2.putExtra("app_uid", fVar.getPageActivity().getApplicationInfo().uid);
                fVar.getPageActivity().startActivity(intent2);
            }
        } catch (Exception unused) {
            Intent intent3 = new Intent();
            intent3.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, fVar.getPageActivity().getPackageName(), null));
            fVar.getPageActivity().startActivity(intent3);
        }
    }

    public static d.a.n0.r.s.a d(TbPageContext<?> tbPageContext, a.e eVar, a.e eVar2, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return null;
        }
        String format = String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.url_notify), str);
        String string = TbadkCoreApplication.getInst().getContext().getString(R.string.confirm_title);
        d.a.n0.r.s.a create = new d.a.n0.r.s.a(tbPageContext.getPageActivity()).setTitle(string).setMessage(format).setPositiveButton(TbadkCoreApplication.getInst().getContext().getString(R.string.alert_yes_button), eVar).setNegativeButton(TbadkCoreApplication.getInst().getContext().getString(R.string.cancel), eVar2).create(tbPageContext);
        create.show();
        return create;
    }

    public static boolean e(Context context, int i2) {
        boolean z = false;
        if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            return false;
        }
        Date date = new Date(d.a.n0.r.d0.b.j().l("push_permission_dialog_scene_cold_start_key", 0L));
        Date date2 = new Date(d.a.n0.r.d0.b.j().l("push_permission_dialog_scene_interaction_key", 0L));
        long currentTimeMillis = System.currentTimeMillis();
        Date date3 = new Date(currentTimeMillis);
        if (i2 == 0 && TimeHelper.getDayDifference(date3, date2) >= 7 && !TimeHelper.isSameDay(date3, date)) {
            z = true;
        }
        if (i2 == 1 && TimeHelper.getDayDifference(date3, date) >= 7 && !TimeHelper.isSameDay(date3, date2)) {
            z = true;
        }
        if (z) {
            if (i2 == 0) {
                d.a.n0.r.d0.b.j().w("push_permission_dialog_scene_interaction_key", currentTimeMillis);
            } else if (i2 == 1) {
                d.a.n0.r.d0.b.j().w("push_permission_dialog_scene_cold_start_key", currentTimeMillis);
            }
        }
        return z;
    }

    public static void f(TbPageContext<?> tbPageContext, boolean[] zArr, int i2) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || zArr == null || zArr.length != 2) {
            return;
        }
        g(tbPageContext, i2, 0L);
    }

    public static void g(TbPageContext<?> tbPageContext, int i2, long j) {
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(tbPageContext.getPageActivity());
        aVar.setCancelable(false);
        aVar.setPositiveButton((String) null, (a.e) null);
        aVar.setNegativeButton((String) null, (a.e) null);
        aVar.setContentViewSize(4);
        CustomPushPremissionDialogView customPushPremissionDialogView = new CustomPushPremissionDialogView(tbPageContext.getPageActivity());
        aVar.setContentView(customPushPremissionDialogView);
        int[] iArr = {-1};
        customPushPremissionDialogView.getPushPermissionDialogConfirmButton().setOnClickListener(new View$OnClickListenerC1216a(tbPageContext, iArr, aVar));
        customPushPremissionDialogView.getPushPermissionDialogCancelButton().setOnClickListener(new b(iArr, aVar));
        aVar.setOnDismissListener(new c(i2, iArr));
        if (j > 0) {
            aVar.create(tbPageContext).show(j);
        } else {
            aVar.create(tbPageContext).show();
        }
        StatisticItem statisticItem = new StatisticItem("c13674");
        statisticItem.param("obj_source", i2);
        TiebaStatic.log(statisticItem);
    }
}
