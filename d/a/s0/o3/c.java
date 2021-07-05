package d.a.s0.o3;

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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.j;
import d.a.c.e.m.g;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.s.c.f0;
/* loaded from: classes9.dex */
public class c implements View.OnClickListener, d.a.s0.o3.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f64339e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f64340f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f64341g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.o3.b f64342h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f64343i;
    public View j;
    public AlertDialog k;
    public DialogInterface.OnDismissListener l;
    public boolean m;
    public ShareDialogConfig n;
    public float o;
    public CustomMessageListener p;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64344a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f64344a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f64344a.h();
                c cVar = this.f64344a;
                cVar.m(cVar.n);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f64345e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64345e = cVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f64345e.l != null) {
                    this.f64345e.l.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (this.f64345e.f64342h != null) {
                    this.f64345e.f64342h.k();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* renamed from: d.a.s0.o3.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1625c implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f64346e;

        public C1625c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64346e = cVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.f64346e.k == null || !this.f64346e.k.isShowing()) {
                    return null;
                }
                this.f64346e.i();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-630866730, "Ld/a/s0/o3/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-630866730, "Ld/a/s0/o3/c;");
                return;
            }
        }
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds130);
        q = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
        r = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
        s = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        t = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        u = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X08);
        v = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X06);
        w = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = 0.33f;
        this.p = new a(this, 2001304);
        this.f64339e = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f64340f = linearLayout;
        linearLayout.setOrientation(1);
        EMTextView eMTextView = new EMTextView(context);
        this.f64341g = eMTextView;
        eMTextView.setTextSize(0, u);
        EMTextView eMTextView2 = this.f64341g;
        int i4 = q;
        eMTextView2.setPadding(i4, r, i4, s);
        this.f64341g.setGravity(1);
        this.f64341g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f64340f.addView(this.f64341g);
        this.f64342h = new d.a.s0.o3.b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i5 = ShareGridLayout.j;
        layoutParams.leftMargin = i5;
        layoutParams.rightMargin = i5;
        this.f64340f.addView(this.f64342h.d(), layoutParams);
        EMTextView eMTextView3 = new EMTextView(context);
        this.f64343i = eMTextView3;
        eMTextView3.setGravity(1);
        this.f64343i.setTextSize(0, v);
        this.f64343i.setText(R.string.cancel);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = w;
        this.f64343i.setLayoutParams(layoutParams2);
        EMTextView eMTextView4 = this.f64343i;
        int i6 = t;
        eMTextView4.setPadding(0, i6, 0, i6);
        this.f64343i.setOnClickListener(this);
        this.f64340f.addView(this.f64343i);
        this.j = new View(context);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.bottom_enter_anim_place_holder_height)));
        this.f64340f.addView(this.j);
        this.f64342h.l(this);
    }

    @Override // d.a.s0.o3.a
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            i();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.f64340f);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f64341g, R.color.CAM_X0109);
            SkinManager.setViewTextColorSelector(this.f64343i, R.color.CAM_X0107);
        }
    }

    public void i() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alertDialog = this.k) == null) {
            return;
        }
        Context context = this.f64339e;
        if (context instanceof Activity) {
            g.a(alertDialog, (Activity) context);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public void j(ShareDialogConfig.From from) {
        f0 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !k.isEmpty(sharePanelConfData.b())) {
            this.f64341g.setText(sharePanelConfData.b());
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new C1625c(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void l(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onDismissListener) == null) {
            this.l = onDismissListener;
        }
    }

    public void m(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, shareDialogConfig) == null) {
            if (!TextUtils.isEmpty(shareDialogConfig.shareItem.D)) {
                ShareItem shareItem = shareDialogConfig.shareItem;
                shareItem.s = shareItem.D;
            }
            if (!shareDialogConfig.shareItem.a0) {
                this.f64341g.setText(R.string.transmit_share_no_outer);
            } else {
                String sharePanelText = TbSingleton.getInstance().getSharePanelText();
                if (!TextUtils.isEmpty(sharePanelText)) {
                    this.f64341g.setText(sharePanelText);
                } else {
                    this.f64341g.setText(R.string.transmit_share_not_add_experience);
                }
            }
            this.f64342h.m(shareDialogConfig, this.m);
            this.n = shareDialogConfig;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.m = z;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            AlertDialog create = new AlertDialog.Builder(this.f64339e, R.style.DialogTheme).create();
            this.k = create;
            create.setCanceledOnTouchOutside(true);
            this.k.setOnDismissListener(new b(this));
            Context context = this.f64339e;
            if (context instanceof Activity) {
                g.i(this.k, (Activity) context);
            }
            d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.f64340f);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            Window window = this.k.getWindow();
            if (window == null) {
                return;
            }
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.f64340f);
            window.setDimAmount(this.o);
            k();
            j.a(this.f64339e).registerListener(this.p);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view) == null) && view == this.f64343i) {
            p("share_cancel", new Object[0]);
            i();
        }
    }

    public final void p(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.f64339e, str, PrefetchEvent.STATE_CLICK, 1, objArr);
        }
    }
}
