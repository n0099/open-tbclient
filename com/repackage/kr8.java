package com.repackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.widgets.WrapperLinearLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kr8 implements View.OnClickListener, hr8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public LinearLayout b;
    public EMTextView c;
    public jr8 d;
    public EMTextView e;
    public View f;
    public AlertDialog g;
    public DialogInterface.OnDismissListener h;
    public boolean i;
    public ShareDialogConfig j;
    public float k;
    public boolean l;
    public CustomMessageListener m;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kr8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kr8 kr8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kr8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.g();
                if (this.a.j.getFrom().equals(ShareDialogConfig.From.PersonPolymeric)) {
                    this.a.l = false;
                } else {
                    this.a.l = true;
                }
                kr8 kr8Var = this.a;
                kr8Var.l(kr8Var.j, this.a.l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kr8 a;

        public b(kr8 kr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kr8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.h != null) {
                    this.a.h.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (this.a.d != null) {
                    this.a.d.y();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kr8 a;

        public c(kr8 kr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kr8Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.g == null || !this.a.g.isShowing()) {
                    return null;
                }
                this.a.h();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755549152, "Lcom/repackage/kr8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755549152, "Lcom/repackage/kr8;");
                return;
            }
        }
        qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds130);
        n = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
        o = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
        p = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        q = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        r = qi.f(TbadkCoreApplication.getInst(), R.dimen.T_X08);
        s = qi.f(TbadkCoreApplication.getInst(), R.dimen.T_X06);
        t = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    }

    public kr8(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 0.33f;
        this.m = new a(this, 2001304);
        this.a = context;
        WrapperLinearLayout wrapperLinearLayout = new WrapperLinearLayout(context);
        this.b = wrapperLinearLayout;
        wrapperLinearLayout.setOrientation(1);
        EMTextView eMTextView = new EMTextView(context);
        this.c = eMTextView;
        eMTextView.setTextSize(0, r);
        EMTextView eMTextView2 = this.c;
        int i3 = n;
        eMTextView2.setPadding(i3, o, i3, p);
        this.c.setGravity(1);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.b.addView(this.c);
        this.d = new jr8(context);
        this.b.addView(this.d.n(z), new LinearLayout.LayoutParams(-1, -2));
        EMTextView eMTextView3 = new EMTextView(context);
        this.e = eMTextView3;
        eMTextView3.setGravity(1);
        this.e.setTextSize(0, s);
        this.e.setText(R.string.obfuscated_res_0x7f0f0370);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = t;
        this.e.setLayoutParams(layoutParams);
        EMTextView eMTextView4 = this.e;
        int i4 = q;
        eMTextView4.setPadding(0, i4, 0, i4);
        this.e.setOnClickListener(this);
        this.b.addView(this.e);
        this.f = new View(context);
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, qi.f(TbadkCoreApplication.getInst(), R.dimen.bottom_enter_anim_place_holder_height)));
        this.b.addView(this.f);
        this.d.B(this);
    }

    @Override // com.repackage.hr8
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            if (view2 == null) {
                h();
            } else if (!(view2.getTag() instanceof Integer)) {
                h();
            } else if (((Integer) view2.getTag()).intValue() == 25) {
            } else {
                h();
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ms4 d = ms4.d(this.b);
            d.n(R.string.J_X14);
            d.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColorSelector(this.e, R.color.CAM_X0107);
        }
    }

    public void h() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alertDialog = this.g) == null) {
            return;
        }
        Context context = this.a;
        if (context instanceof Activity) {
            tg.a(alertDialog, (Activity) context);
            MessageManager.getInstance().unRegisterListener(this.m);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public void i(ShareDialogConfig.From from) {
        wy4 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !pi.isEmpty(sharePanelConfData.b())) {
            this.c.setText(sharePanelConfData.b());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new c(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void k(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onDismissListener) == null) {
            this.h = onDismissListener;
        }
    }

    public void l(ShareDialogConfig shareDialogConfig, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, shareDialogConfig, z) == null) {
            if (!TextUtils.isEmpty(shareDialogConfig.shareItem.G)) {
                ShareItem shareItem = shareDialogConfig.shareItem;
                shareItem.v = shareItem.G;
            }
            ShareItem shareItem2 = shareDialogConfig.shareItem;
            if (!shareItem2.k0) {
                if (shareItem2.l0) {
                    this.c.setText(R.string.obfuscated_res_0x7f0f144c);
                } else {
                    this.c.setText(R.string.obfuscated_res_0x7f0f144d);
                }
            } else {
                String sharePanelText = TbSingleton.getInstance().getSharePanelText();
                if (!TextUtils.isEmpty(sharePanelText)) {
                    this.c.setText(sharePanelText);
                } else {
                    this.c.setText(R.string.obfuscated_res_0x7f0f144e);
                }
            }
            if (shareDialogConfig.isShowNovelMask()) {
                this.c.setVisibility(4);
            }
            this.d.C(shareDialogConfig, this.i, z);
            this.j = shareDialogConfig;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g();
            AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f100107).create();
            this.g = create;
            create.setCanceledOnTouchOutside(true);
            this.g.setOnDismissListener(new b(this));
            Context context = this.a;
            if (context instanceof Activity) {
                tg.i(this.g, (Activity) context);
            }
            ms4 d = ms4.d(this.b);
            d.n(R.string.J_X14);
            d.f(R.color.CAM_X0212);
            Window window = this.g.getWindow();
            if (window == null) {
                return;
            }
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = qi.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f6);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.b);
            window.setDimAmount(this.k);
            j();
            h9.a(this.a).registerListener(this.m);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        }
    }

    public final void o(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && view2 == this.e) {
            o("share_cancel", new Object[0]);
            h();
        }
    }
}
