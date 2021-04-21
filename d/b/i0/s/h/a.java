package d.b.i0.s.h;

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
import d.b.c.a.f;
import d.b.i0.r.s.a;
import java.util.Date;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.b.i0.s.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnClickListenerC1134a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52124e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int[] f52125f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f52126g;

        public View$OnClickListenerC1134a(TbPageContext tbPageContext, int[] iArr, d.b.i0.r.s.a aVar) {
            this.f52124e = tbPageContext;
            this.f52125f = iArr;
            this.f52126g = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.c(this.f52124e);
            this.f52125f[0] = 1;
            this.f52126g.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f52127e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f52128f;

        public b(int[] iArr, d.b.i0.r.s.a aVar) {
            this.f52127e = iArr;
            this.f52128f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f52127e[0] = 2;
            this.f52128f.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52129e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int[] f52130f;

        public c(int i, int[] iArr) {
            this.f52129e = i;
            this.f52130f = iArr;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            StatisticItem statisticItem = new StatisticItem("c13673");
            statisticItem.param("obj_source", this.f52129e);
            statisticItem.param("obj_type", this.f52130f[0]);
            TiebaStatic.log(statisticItem);
        }
    }

    public static d.b.i0.r.s.a a(TbPageContext<?> tbPageContext, int i, int i2, int i3, int i4, a.e eVar, a.e eVar2) {
        return b(tbPageContext, i >= 0 ? TbadkCoreApplication.getInst().getContext().getString(i) : null, TbadkCoreApplication.getInst().getContext().getString(i2), TbadkCoreApplication.getInst().getContext().getString(i3), TbadkCoreApplication.getInst().getContext().getString(i4), eVar, eVar2);
    }

    public static d.b.i0.r.s.a b(TbPageContext<?> tbPageContext, String str, String str2, String str3, String str4, a.e eVar, a.e eVar2) {
        if (tbPageContext == null) {
            return null;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(tbPageContext.getPageActivity());
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
                intent.setData(Uri.fromParts("package", fVar.getPageActivity().getPackageName(), null));
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
            intent3.setData(Uri.fromParts("package", fVar.getPageActivity().getPackageName(), null));
            fVar.getPageActivity().startActivity(intent3);
        }
    }

    public static d.b.i0.r.s.a d(TbPageContext<?> tbPageContext, a.e eVar, a.e eVar2, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return null;
        }
        String format = String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.url_notify), str);
        String string = TbadkCoreApplication.getInst().getContext().getString(R.string.confirm_title);
        d.b.i0.r.s.a create = new d.b.i0.r.s.a(tbPageContext.getPageActivity()).setTitle(string).setMessage(format).setPositiveButton(TbadkCoreApplication.getInst().getContext().getString(R.string.alert_yes_button), eVar).setNegativeButton(TbadkCoreApplication.getInst().getContext().getString(R.string.cancel), eVar2).create(tbPageContext);
        create.show();
        return create;
    }

    public static boolean e(Context context, int i) {
        boolean z = false;
        if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            return false;
        }
        Date date = new Date(d.b.i0.r.d0.b.j().l("push_permission_dialog_scene_cold_start_key", 0L));
        Date date2 = new Date(d.b.i0.r.d0.b.j().l("push_permission_dialog_scene_interaction_key", 0L));
        long currentTimeMillis = System.currentTimeMillis();
        Date date3 = new Date(currentTimeMillis);
        if (i == 0 && TimeHelper.getDayDifference(date3, date2) >= 7 && !TimeHelper.isSameDay(date3, date)) {
            z = true;
        }
        if (i == 1 && TimeHelper.getDayDifference(date3, date) >= 7 && !TimeHelper.isSameDay(date3, date2)) {
            z = true;
        }
        if (z) {
            if (i == 0) {
                d.b.i0.r.d0.b.j().w("push_permission_dialog_scene_interaction_key", currentTimeMillis);
            } else if (i == 1) {
                d.b.i0.r.d0.b.j().w("push_permission_dialog_scene_cold_start_key", currentTimeMillis);
            }
        }
        return z;
    }

    public static void f(TbPageContext<?> tbPageContext, boolean[] zArr, int i) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || zArr == null || zArr.length != 2) {
            return;
        }
        g(tbPageContext, i, 0L);
    }

    public static void g(TbPageContext<?> tbPageContext, int i, long j) {
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(tbPageContext.getPageActivity());
        aVar.setCancelable(false);
        aVar.setPositiveButton((String) null, (a.e) null);
        aVar.setNegativeButton((String) null, (a.e) null);
        aVar.setContentViewSize(4);
        CustomPushPremissionDialogView customPushPremissionDialogView = new CustomPushPremissionDialogView(tbPageContext.getPageActivity());
        aVar.setContentView(customPushPremissionDialogView);
        int[] iArr = {-1};
        customPushPremissionDialogView.getPushPermissionDialogConfirmButton().setOnClickListener(new View$OnClickListenerC1134a(tbPageContext, iArr, aVar));
        customPushPremissionDialogView.getPushPermissionDialogCancelButton().setOnClickListener(new b(iArr, aVar));
        aVar.setOnDismissListener(new c(i, iArr));
        if (j > 0) {
            aVar.create(tbPageContext).show(j);
        } else {
            aVar.create(tbPageContext).show();
        }
        StatisticItem statisticItem = new StatisticItem("c13674");
        statisticItem.param("obj_source", i);
        TiebaStatic.log(statisticItem);
    }
}
