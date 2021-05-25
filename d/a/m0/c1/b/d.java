package d.a.m0.c1.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AlertDialog;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import d.a.m0.r.s.o;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49241a;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f49242a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f49243b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            this.f49242a = alertDialog;
            this.f49243b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                this.f49242a.dismiss();
                BdTopToast bdTopToast = new BdTopToast(this.f49243b, 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f49243b.getString(R.string.youngster_close_title));
                bdTopToast.j((ViewGroup) this.f49243b.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f49244a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f49245b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            this.f49244a = alertDialog;
            this.f49245b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                this.f49244a.dismiss();
                BdTopToast bdTopToast = new BdTopToast(this.f49245b, 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f49245b.getString(R.string.youngster_close_title));
                bdTopToast.j((ViewGroup) this.f49245b.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f49246e;

        public c(AlertDialog alertDialog) {
            this.f49246e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f49246e.dismiss();
        }
    }

    /* renamed from: d.a.m0.c1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class DialogInterface$OnDismissListenerC1119d implements DialogInterface.OnDismissListener {
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            d.f49241a = false;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f49247e;

        public e(Activity activity) {
            this.f49247e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainTabActivityConfig.toExitApp(this.f49247e);
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f49248e;

        public f(Activity activity) {
            this.f49248e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f49248e);
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(6);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f49249e;

        public g(Activity activity) {
            this.f49249e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f49249e);
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
            if (this.f49249e.getComponentName().getClassName().contains("MainTabActivity")) {
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(3);
            } else {
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f49250a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f49251b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            this.f49250a = alertDialog;
            this.f49251b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                this.f49250a.dismiss();
                BdTopToast bdTopToast = new BdTopToast(this.f49251b, 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f49251b.getString(R.string.youngster_close_title));
                bdTopToast.j((ViewGroup) this.f49251b.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f49252a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f49253b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            this.f49252a = alertDialog;
            this.f49253b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            int intValue = data instanceof Integer ? ((Integer) data).intValue() : 0;
            if (intValue != 6) {
                if (intValue == 7) {
                    this.f49252a.dismiss();
                    return;
                }
                return;
            }
            this.f49252a.dismiss();
            BdTopToast bdTopToast = new BdTopToast(this.f49253b, 2000);
            bdTopToast.i(true);
            bdTopToast.h(this.f49253b.getString(R.string.youngster_dialog_close_time_success_message));
            bdTopToast.j((ViewGroup) this.f49253b.findViewById(16908290));
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f49254a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f49255b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            this.f49254a = alertDialog;
            this.f49255b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                this.f49254a.dismiss();
                BdTopToast bdTopToast = new BdTopToast(this.f49255b, 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f49255b.getString(R.string.youngster_close_title));
                bdTopToast.j((ViewGroup) this.f49255b.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class k implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f49256e;

        public k(Activity activity) {
            this.f49256e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainTabActivityConfig.toExitApp(this.f49256e);
        }
    }

    /* loaded from: classes3.dex */
    public static class l implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f49257e;

        public l(Activity activity) {
            this.f49257e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f49257e);
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
            if (this.f49257e.getComponentName().getClassName().contains("MainTabActivity")) {
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(3);
            } else {
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
        }
    }

    public static void a() {
        d.a.m0.r.d0.b.j().w("key_youngster_use_time_dialog_show_time", System.currentTimeMillis());
    }

    public static void b() {
        d.a.m0.r.d0.b.j().w("key_youngster_use_time_dialog_show_time", 0L);
    }

    public static boolean c() {
        long l2 = d.a.m0.r.d0.b.j().l("key_youngster_use_time_dialog_show_time", 0L);
        return l2 > System.currentTimeMillis() || System.currentTimeMillis() - l2 <= 600000;
    }

    public static boolean d(Activity activity, DialogInterface.OnDismissListener onDismissListener) {
        if (d.a.m0.c1.b.e.d()) {
            if (activity == null || activity.isDestroyed() || d.a.m0.r.d0.b.j().g("key_youngster_mode_open_showed", false)) {
                return false;
            }
            RelativeLayout relativeLayout = new RelativeLayout(activity);
            ImageView imageView = new ImageView(activity);
            WebPManager.setMaskDrawable(imageView, R.drawable.pic_mask_younger_guide_copylink, null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            relativeLayout.addView(imageView, layoutParams);
            TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.know, TBAlertConfig.OperateBtnStyle.MAIN);
            o oVar = new o(activity);
            oVar.l(R.string.youngster_open_title);
            oVar.i(R.string.youngster_dialog_First_open_message);
            oVar.g(relativeLayout);
            oVar.k(aVar);
            oVar.f(false);
            oVar.j(onDismissListener);
            aVar.a(new c(oVar.n()));
            d.a.m0.r.d0.b.j().t("key_youngster_mode_open_showed", true);
            return true;
        }
        return true;
    }

    public static boolean e() {
        if (d.a.m0.c1.b.e.d()) {
            Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
            if (currentActivity == null || currentActivity.isDestroyed() || currentActivity.getComponentName().getClassName().contains("YoungsterPasswordActivity") || currentActivity.getRequestedOrientation() == 0) {
                return false;
            }
            RelativeLayout relativeLayout = new RelativeLayout(currentActivity);
            View view = new View(currentActivity);
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(view);
            d2.l(1);
            d2.m(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds103));
            layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds100), 0, 0);
            relativeLayout.addView(view, layoutParams);
            ImageView imageView = new ImageView(currentActivity);
            WebPManager.setMaskDrawable(imageView, R.drawable.pic_mask_qingshaonian_time, null);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            relativeLayout.addView(imageView, layoutParams2);
            o oVar = new o(currentActivity);
            oVar.l(R.string.youngster_open_title);
            oVar.i(R.string.youngster_dialog_close_night_message);
            oVar.h(relativeLayout);
            oVar.k(new TBAlertConfig.a(R.string.youngster_dialog_close_quit_message, TBAlertConfig.OperateBtnStyle.MAIN, new k(currentActivity)), new TBAlertConfig.a(R.string.youngster_settings_close_title, TBAlertConfig.OperateBtnStyle.MAIN, new l(currentActivity)));
            oVar.f(false);
            AlertDialog n = oVar.n();
            a aVar = new a(2921484, n, currentActivity);
            b bVar = new b(2921486, n, currentActivity);
            if (currentActivity instanceof BaseActivity) {
                BdUniqueId uniqueId = ((BaseActivity) currentActivity).getUniqueId();
                aVar.setTag(uniqueId);
                bVar.setTag(uniqueId);
            } else if (currentActivity instanceof BaseFragmentActivity) {
                BdUniqueId uniqueId2 = ((BaseFragmentActivity) currentActivity).getUniqueId();
                aVar.setTag(uniqueId2);
                bVar.setTag(uniqueId2);
            }
            MessageManager.getInstance().registerListener(aVar);
            MessageManager.getInstance().registerListener(bVar);
            return true;
        }
        return true;
    }

    public static boolean f() {
        if (d.a.m0.c1.b.e.d()) {
            if (f49241a) {
                if (d.a.m0.c1.b.e.f49258a) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921561, 7));
                    return e();
                }
                return true;
            } else if (d.a.m0.c1.b.e.f49258a) {
                return e();
            } else {
                Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                if (currentActivity == null || currentActivity.isDestroyed() || currentActivity.getComponentName().getClassName().contains("YoungsterPasswordActivity") || currentActivity.getRequestedOrientation() == 0) {
                    return false;
                }
                RelativeLayout relativeLayout = new RelativeLayout(currentActivity);
                View view = new View(currentActivity);
                d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(view);
                d2.l(1);
                d2.m(R.string.J_X06);
                d2.f(R.color.CAM_X0205);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds103));
                layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds100), 0, 0);
                relativeLayout.addView(view, layoutParams);
                ImageView imageView = new ImageView(currentActivity);
                WebPManager.setMaskDrawable(imageView, R.drawable.pic_mask_qingshaonian_time, null);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(14);
                relativeLayout.addView(imageView, layoutParams2);
                o oVar = new o(currentActivity);
                oVar.l(R.string.youngster_open_title);
                oVar.i(R.string.youngster_dialog_close_time_message);
                oVar.h(relativeLayout);
                oVar.k(new TBAlertConfig.a(R.string.youngster_dialog_close_quit_message, TBAlertConfig.OperateBtnStyle.MAIN, new e(currentActivity)), new TBAlertConfig.a(R.string.youngster_settings_input_password_time, TBAlertConfig.OperateBtnStyle.MAIN, new f(currentActivity)), new TBAlertConfig.a(R.string.youngster_settings_close_title, TBAlertConfig.OperateBtnStyle.MAIN, new g(currentActivity)));
                oVar.f(false);
                oVar.j(new DialogInterface$OnDismissListenerC1119d());
                AlertDialog n = oVar.n();
                h hVar = new h(2921484, n, currentActivity);
                i iVar = new i(2921561, n, currentActivity);
                j jVar = new j(2921486, n, currentActivity);
                if (currentActivity instanceof BaseActivity) {
                    BdUniqueId uniqueId = ((BaseActivity) currentActivity).getUniqueId();
                    iVar.setTag(uniqueId);
                    hVar.setTag(uniqueId);
                    jVar.setTag(uniqueId);
                } else if (currentActivity instanceof BaseFragmentActivity) {
                    BdUniqueId uniqueId2 = ((BaseFragmentActivity) currentActivity).getUniqueId();
                    iVar.setTag(uniqueId2);
                    hVar.setTag(uniqueId2);
                    jVar.setTag(uniqueId2);
                }
                MessageManager.getInstance().registerListener(hVar);
                MessageManager.getInstance().registerListener(iVar);
                MessageManager.getInstance().registerListener(jVar);
                a();
                f49241a = true;
                return true;
            }
        }
        return true;
    }
}
