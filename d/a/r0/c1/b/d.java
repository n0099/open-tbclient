package d.a.r0.c1.b;

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
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import d.a.r0.r.s.o;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f55158a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f55159a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f55160b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), alertDialog, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55159a = alertDialog;
            this.f55160b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f55159a.dismiss();
                    BdTopToast bdTopToast = new BdTopToast(this.f55160b, 2000);
                    bdTopToast.i(true);
                    bdTopToast.h(this.f55160b.getString(R.string.youngster_close_title));
                    bdTopToast.j((ViewGroup) this.f55160b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f55161a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f55162b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), alertDialog, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55161a = alertDialog;
            this.f55162b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f55161a.dismiss();
                    BdTopToast bdTopToast = new BdTopToast(this.f55162b, 2000);
                    bdTopToast.i(true);
                    bdTopToast.h(this.f55162b.getString(R.string.youngster_close_title));
                    bdTopToast.j((ViewGroup) this.f55162b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f55163e;

        public c(AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55163e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55163e.dismiss();
            }
        }
    }

    /* renamed from: d.a.r0.c1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class DialogInterface$OnDismissListenerC1238d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DialogInterface$OnDismissListenerC1238d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                d.f55158a = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f55164e;

        public e(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55164e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MainTabActivityConfig.toExitApp(this.f55164e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f55165e;

        public f(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55165e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f55165e);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(6);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f55166e;

        public g(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55166e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f55166e);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                if (this.f55166e.getComponentName().getClassName().contains("MainTabActivity")) {
                    youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(3);
                } else {
                    youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f55167a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f55168b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), alertDialog, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55167a = alertDialog;
            this.f55168b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f55167a.dismiss();
                    BdTopToast bdTopToast = new BdTopToast(this.f55168b, 2000);
                    bdTopToast.i(true);
                    bdTopToast.h(this.f55168b.getString(R.string.youngster_close_title));
                    bdTopToast.j((ViewGroup) this.f55168b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f55169a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f55170b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), alertDialog, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55169a = alertDialog;
            this.f55170b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                int intValue = data instanceof Integer ? ((Integer) data).intValue() : 0;
                if (intValue != 6) {
                    if (intValue == 7) {
                        this.f55169a.dismiss();
                        return;
                    }
                    return;
                }
                this.f55169a.dismiss();
                BdTopToast bdTopToast = new BdTopToast(this.f55170b, 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f55170b.getString(R.string.youngster_dialog_close_time_success_message));
                bdTopToast.j((ViewGroup) this.f55170b.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f55171a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f55172b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), alertDialog, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55171a = alertDialog;
            this.f55172b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f55171a.dismiss();
                    BdTopToast bdTopToast = new BdTopToast(this.f55172b, 2000);
                    bdTopToast.i(true);
                    bdTopToast.h(this.f55172b.getString(R.string.youngster_close_title));
                    bdTopToast.j((ViewGroup) this.f55172b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f55173e;

        public k(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55173e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MainTabActivityConfig.toExitApp(this.f55173e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f55174e;

        public l(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55174e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f55174e);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                if (this.f55174e.getComponentName().getClassName().contains("MainTabActivity")) {
                    youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(3);
                } else {
                    youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            d.a.r0.r.d0.b.j().w("key_youngster_use_time_dialog_show_time", System.currentTimeMillis());
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            d.a.r0.r.d0.b.j().w("key_youngster_use_time_dialog_show_time", 0L);
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long l2 = d.a.r0.r.d0.b.j().l("key_youngster_use_time_dialog_show_time", 0L);
            return l2 > System.currentTimeMillis() || System.currentTimeMillis() - l2 <= TTAdConstant.AD_MAX_EVENT_TIME;
        }
        return invokeV.booleanValue;
    }

    public static boolean d(Activity activity, DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, activity, onDismissListener)) == null) {
            if (d.a.r0.c1.b.e.d()) {
                if (activity == null || activity.isDestroyed() || d.a.r0.r.d0.b.j().g("key_youngster_mode_open_showed", false)) {
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
                oVar.p(R.string.youngster_open_title);
                oVar.j(R.string.youngster_dialog_First_open_message);
                oVar.h(relativeLayout);
                oVar.o(aVar);
                oVar.g(false);
                oVar.n(onDismissListener);
                aVar.a(new c(oVar.r()));
                d.a.r0.r.d0.b.j().t("key_youngster_mode_open_showed", true);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (d.a.r0.c1.b.e.d()) {
                Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                if (currentActivity == null || currentActivity.isDestroyed() || currentActivity.getComponentName().getClassName().contains("YoungsterPasswordActivity") || currentActivity.getRequestedOrientation() == 0) {
                    return false;
                }
                RelativeLayout relativeLayout = new RelativeLayout(currentActivity);
                View view = new View(currentActivity);
                d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(view);
                d2.m(1);
                d2.n(R.string.J_X06);
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
                oVar.p(R.string.youngster_open_title);
                oVar.j(R.string.youngster_dialog_close_night_message);
                oVar.i(relativeLayout);
                oVar.o(new TBAlertConfig.a(R.string.youngster_dialog_close_quit_message, TBAlertConfig.OperateBtnStyle.MAIN, new k(currentActivity)), new TBAlertConfig.a(R.string.youngster_settings_close_title, TBAlertConfig.OperateBtnStyle.MAIN, new l(currentActivity)));
                oVar.g(false);
                AlertDialog r = oVar.r();
                a aVar = new a(2921484, r, currentActivity);
                b bVar = new b(2921486, r, currentActivity);
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
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (d.a.r0.c1.b.e.d()) {
                if (f55158a) {
                    if (d.a.r0.c1.b.e.f55175a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921561, 7));
                        return e();
                    }
                    return true;
                } else if (d.a.r0.c1.b.e.f55175a) {
                    return e();
                } else {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity == null || currentActivity.isDestroyed() || currentActivity.getComponentName().getClassName().contains("YoungsterPasswordActivity") || currentActivity.getRequestedOrientation() == 0) {
                        return false;
                    }
                    RelativeLayout relativeLayout = new RelativeLayout(currentActivity);
                    View view = new View(currentActivity);
                    d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(view);
                    d2.m(1);
                    d2.n(R.string.J_X06);
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
                    oVar.p(R.string.youngster_open_title);
                    oVar.j(R.string.youngster_dialog_close_time_message);
                    oVar.i(relativeLayout);
                    oVar.o(new TBAlertConfig.a(R.string.youngster_dialog_close_quit_message, TBAlertConfig.OperateBtnStyle.MAIN, new e(currentActivity)), new TBAlertConfig.a(R.string.youngster_settings_input_password_time, TBAlertConfig.OperateBtnStyle.MAIN, new f(currentActivity)), new TBAlertConfig.a(R.string.youngster_settings_close_title, TBAlertConfig.OperateBtnStyle.MAIN, new g(currentActivity)));
                    oVar.g(false);
                    oVar.n(new DialogInterface$OnDismissListenerC1238d());
                    AlertDialog r = oVar.r();
                    h hVar = new h(2921484, r, currentActivity);
                    i iVar = new i(2921561, r, currentActivity);
                    j jVar = new j(2921486, r, currentActivity);
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
                    f55158a = true;
                    return true;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
