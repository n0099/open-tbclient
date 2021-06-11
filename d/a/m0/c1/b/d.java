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
    public static boolean f52915a;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f52916a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f52917b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            this.f52916a = alertDialog;
            this.f52917b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                this.f52916a.dismiss();
                BdTopToast bdTopToast = new BdTopToast(this.f52917b, 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f52917b.getString(R.string.youngster_close_title));
                bdTopToast.j((ViewGroup) this.f52917b.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f52918a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f52919b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            this.f52918a = alertDialog;
            this.f52919b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                this.f52918a.dismiss();
                BdTopToast bdTopToast = new BdTopToast(this.f52919b, 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f52919b.getString(R.string.youngster_close_title));
                bdTopToast.j((ViewGroup) this.f52919b.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f52920e;

        public c(AlertDialog alertDialog) {
            this.f52920e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f52920e.dismiss();
        }
    }

    /* renamed from: d.a.m0.c1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class DialogInterface$OnDismissListenerC1175d implements DialogInterface.OnDismissListener {
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            d.f52915a = false;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f52921e;

        public e(Activity activity) {
            this.f52921e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainTabActivityConfig.toExitApp(this.f52921e);
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f52922e;

        public f(Activity activity) {
            this.f52922e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f52922e);
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(6);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f52923e;

        public g(Activity activity) {
            this.f52923e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f52923e);
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
            if (this.f52923e.getComponentName().getClassName().contains("MainTabActivity")) {
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
        public final /* synthetic */ AlertDialog f52924a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f52925b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            this.f52924a = alertDialog;
            this.f52925b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                this.f52924a.dismiss();
                BdTopToast bdTopToast = new BdTopToast(this.f52925b, 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f52925b.getString(R.string.youngster_close_title));
                bdTopToast.j((ViewGroup) this.f52925b.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f52926a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f52927b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            this.f52926a = alertDialog;
            this.f52927b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            int intValue = data instanceof Integer ? ((Integer) data).intValue() : 0;
            if (intValue != 6) {
                if (intValue == 7) {
                    this.f52926a.dismiss();
                    return;
                }
                return;
            }
            this.f52926a.dismiss();
            BdTopToast bdTopToast = new BdTopToast(this.f52927b, 2000);
            bdTopToast.i(true);
            bdTopToast.h(this.f52927b.getString(R.string.youngster_dialog_close_time_success_message));
            bdTopToast.j((ViewGroup) this.f52927b.findViewById(16908290));
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f52928a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f52929b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            this.f52928a = alertDialog;
            this.f52929b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                this.f52928a.dismiss();
                BdTopToast bdTopToast = new BdTopToast(this.f52929b, 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f52929b.getString(R.string.youngster_close_title));
                bdTopToast.j((ViewGroup) this.f52929b.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class k implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f52930e;

        public k(Activity activity) {
            this.f52930e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainTabActivityConfig.toExitApp(this.f52930e);
        }
    }

    /* loaded from: classes3.dex */
    public static class l implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f52931e;

        public l(Activity activity) {
            this.f52931e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f52931e);
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
            if (this.f52931e.getComponentName().getClassName().contains("MainTabActivity")) {
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
            if (f52915a) {
                if (d.a.m0.c1.b.e.f52932a) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921561, 7));
                    return e();
                }
                return true;
            } else if (d.a.m0.c1.b.e.f52932a) {
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
                oVar.j(new DialogInterface$OnDismissListenerC1175d());
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
                f52915a = true;
                return true;
            }
        }
        return true;
    }
}
