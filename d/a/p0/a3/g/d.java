package d.a.p0.a3.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.s.a;
import d.a.o0.s.c.f0;
import d.a.o0.s.c.g0;
import d.a.o0.z0.q;
import d.a.p0.h3.z;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes7.dex */
public class d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int B;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f54045e;

    /* renamed from: f  reason: collision with root package name */
    public final View f54046f;

    /* renamed from: g  reason: collision with root package name */
    public final View f54047g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f54048h;

    /* renamed from: i  reason: collision with root package name */
    public ShareGridLayout f54049i;
    public final EMTextView j;
    public final List<View> k;
    public View.OnClickListener l;
    public DialogInterface.OnDismissListener m;
    public DialogInterface.OnCancelListener n;
    public AlertDialog o;
    public float p;
    public PermissionJudgePolicy q;
    public final SparseArray<ShareItem> r;
    public boolean s;
    public SparseArray<String> t;
    public SparseArray<g0> u;
    public boolean v;
    public int w;
    public boolean x;
    public CustomMessageListener y;
    public int z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f54050a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f54050a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f54050a.k();
                this.f54050a.f54049i.removeAllViews();
                this.f54050a.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f54051e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54051e = dVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.f54051e.o == null || !this.f54051e.o.isShowing()) {
                    return null;
                }
                this.f54051e.m();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f54052e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54052e = dVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f54052e.m != null) {
                    this.f54052e.m.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* renamed from: d.a.p0.a3.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class DialogInterface$OnCancelListenerC1257d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f54053e;

        public DialogInterface$OnCancelListenerC1257d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54053e = dVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.f54053e.n == null) {
                return;
            }
            this.f54053e.n.onCancel(dialogInterface);
        }
    }

    /* loaded from: classes7.dex */
    public class e extends q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f54054a;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54054a = dVar;
        }

        @Override // d.a.o0.z0.q.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                l.M(this.f54054a.f54045e, "保存失败！");
            }
        }

        @Override // d.a.o0.z0.q.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                l.M(this.f54054a.f54045e, "保存成功！");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f54055e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f54056f;

        public f(d dVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54056f = dVar;
            this.f54055e = shareItem;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                d.a.c.e.p.a.a(this.f54055e.s);
                l.L(this.f54056f.f54045e.getApplicationContext(), R.string.copy_success);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View.OnClickListener f54057e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f54058f;

        public h(d dVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54058f = dVar;
            this.f54057e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54058f.m();
                View.OnClickListener onClickListener = this.f54057e;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(376962866, "Ld/a/p0/a3/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(376962866, "Ld/a/p0/a3/g/d;");
                return;
            }
        }
        A = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        B = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    public d(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = 0.33f;
        this.r = new SparseArray<>(8);
        this.s = false;
        this.v = true;
        this.w = 1;
        this.x = true;
        this.y = new a(this, 2001304);
        this.z = 0;
        this.z = i2;
        this.f54045e = context;
        this.k = new ArrayList();
        View p = p();
        this.f54046f = p;
        this.f54047g = p.findViewById(R.id.share_dialog_main_view);
        this.f54048h = (TextView) this.f54046f.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.f54048h.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.f54046f.findViewById(R.id.share_grid_layout);
        this.f54049i = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i5 = ShareGridLayout.j;
            marginLayoutParams.leftMargin = i5;
            marginLayoutParams.rightMargin = i5;
            this.f54049i.setLayoutParams(marginLayoutParams);
        }
        this.f54049i.setItemParams(A, B);
        EMTextView eMTextView = (EMTextView) this.f54046f.findViewById(R.id.btnShareCancel);
        this.j = eMTextView;
        eMTextView.setOnClickListener(this);
    }

    public final boolean A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (i2 & 32) > 0 : invokeI.booleanValue;
    }

    public void B(ShareDialogConfig.From from) {
        f0 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !k.isEmpty(sharePanelConfData.b())) {
            this.f54048h.setText(sharePanelConfData.b());
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new b(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void G(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.l = onClickListener;
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.v = z;
        }
    }

    public void J(SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sparseArray) == null) {
            this.t = sparseArray;
        }
    }

    public void K(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onCancelListener) == null) {
            this.n = onCancelListener;
        }
    }

    public void L(ShareItem shareItem, boolean z) {
        Location q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareItem, z) == null) {
            if (z && (q = q()) != null) {
                shareItem.B = q;
            }
            this.r.put(1, shareItem);
            if (StringUtils.isNull(shareItem.n)) {
                return;
            }
            this.f54048h.setText(shareItem.n);
        }
    }

    public void M(int i2, ShareItem shareItem, boolean z) {
        Location q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), shareItem, Boolean.valueOf(z)}) == null) {
            if (z && (q = q()) != null) {
                shareItem.B = q;
            }
            this.r.put(i2, shareItem);
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.w = i2;
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.x = z;
        }
    }

    public void P(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, window) == null) {
            window.setLayout(-1, -2);
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.w == 2 && l() : invokeV.booleanValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!j.z()) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (!d.a.o0.s.g.g.g()) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
            } else {
                j();
                AlertDialog create = new AlertDialog.Builder(this.f54045e, R.style.DialogTheme).create();
                this.o = create;
                create.setCanceledOnTouchOutside(true);
                this.o.setOnDismissListener(new c(this));
                this.o.setOnCancelListener(new DialogInterface$OnCancelListenerC1257d(this));
                Context context = this.f54045e;
                if (context instanceof Activity) {
                    d.a.c.e.m.g.i(this.o, (Activity) context);
                }
                d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.f54047g);
                d2.n(R.string.J_X14);
                d2.f(R.color.CAM_X0204);
                Window window = this.o.getWindow();
                if (window == null) {
                    return;
                }
                if (this.x) {
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.share_dialog_style);
                } else {
                    window.setWindowAnimations(R.style.normal_dialog_style);
                }
                window.setGravity(80);
                P(window);
                window.setContentView(this.f54046f);
                window.setDimAmount(this.p);
                k();
                F();
                d.a.c.a.j.a(this.f54045e).registerListener(this.y);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ArrayList arrayList = new ArrayList(this.k);
            this.k.clear();
            if (!x(this.z)) {
                h(R.string.share_weixin, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
            }
            if (!y(this.z)) {
                h(R.string.share_weixin_timeline, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
            }
            if (!v(this.z)) {
                h(R.string.share_qq_friends, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
            }
            if (!w(this.z)) {
                h(R.string.share_qzone, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
            }
            if (!z(this.z)) {
                h(R.string.share_sina_weibo, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
            }
            if (A(this.z)) {
                g(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
            }
            if (arrayList.size() > 0) {
                this.k.addAll(arrayList);
            }
            if (this.v) {
                g(R.string.share_copy, R.drawable.icon_pure_share_copy40);
            }
        }
    }

    public final void T(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, shareItem) == null) || shareItem == null || TextUtils.isEmpty(shareItem.s) || TextUtils.isEmpty(shareItem.r)) {
            return;
        }
        Context context = this.f54045e;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(activity);
            aVar.setTitle(shareItem.r);
            aVar.setMessage(shareItem.s);
            aVar.setAutoNight(false);
            aVar.setCancelable(true);
            aVar.setTitleShowCenter(true);
            aVar.setPositiveButton(R.string.share_copy, new f(this, shareItem));
            aVar.setNegativeButton(R.string.share_cancel, new g(this)).create(d.a.c.a.j.a(activity));
            aVar.show();
        }
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.f54045e, str, PrefetchEvent.STATE_CLICK, 1, objArr);
        }
    }

    public final void X(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 > 8 || i2 <= 0) {
            return;
        }
        this.s = true;
        SparseArray<g0> sparseArray = this.u;
        if (sparseArray != null) {
            g0 g0Var = sparseArray.get(i2);
            if (!StringUtils.isNull(g0Var.b()) && g0Var.a() != null && g0Var.a().size() > 0) {
                W(g0Var.b(), g0Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.t;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i2);
            if (k.isEmpty(str)) {
                return;
            }
            W(str, new Object[0]);
        }
    }

    public final void Y(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i2 = shareItem.F;
            if (i2 != 0) {
                param.param("obj_param1", i2);
                int i3 = shareItem.F;
                if (i3 == 2) {
                    param.param("fid", shareItem.J);
                } else if (i3 == 3) {
                    int i4 = shareItem.M;
                    if (i4 != 0) {
                        param.param("obj_type", i4);
                    }
                    param.param("tid", shareItem.K).param("fid", shareItem.J);
                }
            }
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    public final void Z(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i2, str) == null) {
            TiebaStatic.eventStat(this.f54045e, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void a0(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048598, this, shareItem, i2) == null) || shareItem == null) {
            return;
        }
        if (shareItem.q == null) {
            if (shareItem.j) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2).param("obj_source", shareItem.E));
            }
        } else if (shareItem.f12839b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        } else if (!shareItem.f12840c && !shareItem.f12843f) {
            if (shareItem.f12841d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.f12838a) {
                Z(i2, shareItem.C);
            } else if (shareItem.f12842e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
            } else if (shareItem.f12844g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.E);
                if (!k.isEmpty(shareItem.t)) {
                    if (shareItem.t.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    param.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
                }
                TiebaStatic.log(param);
            } else if (shareItem.f12846i) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_TOPIC_DETAIL).param("obj_locate", i2 == 3 ? "1" : i2 == 4 ? "2" : i2 == 9 ? "4" : i2 == 5 ? "3" : i2 == 7 ? "5" : "6").param("topic_id", shareItem.q));
            } else if (shareItem.k) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("tid", shareItem.q);
                statisticItem.param("post_id", shareItem.V);
                statisticItem.param("obj_source", 18);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G);
                TiebaStatic.log(statisticItem);
            } else if (shareItem.l) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_GAME_DETIAL);
                statisticItem2.param("obj_type", i2);
                statisticItem2.param("obj_name", shareItem.r);
                TiebaStatic.log(statisticItem2);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        }
    }

    public void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f54045e);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            List<View> list = this.k;
            shareDialogItemView.a();
            list.add(shareDialogItemView);
        }
    }

    public void h(int i2, AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048600, this, i2, absSvgType) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f54045e);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        List<View> list = this.k;
        shareDialogItemView.a();
        list.add(shareDialogItemView);
    }

    public void i(View view, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048601, this, view, i2, onClickListener) == null) || i2 > this.k.size() || i2 < 0) {
            return;
        }
        this.k.add(i2, view);
        if (onClickListener != null) {
            view.setOnClickListener(new h(this, onClickListener));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || U()) {
            return;
        }
        S();
        if (!d.a.o0.s.g.g.g()) {
            this.f54049i.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            this.f54049i.addView(this.k.get(i2), new ViewGroup.LayoutParams(A, B));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.f54047g);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f54048h, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColorSelector(this.j, R.color.CAM_X0107);
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.f54045e instanceof Activity) {
                if (this.q == null) {
                    this.q = new PermissionJudgePolicy();
                }
                this.q.clearRequestPermissionList();
                this.q.appendRequestPermission((Activity) this.f54045e, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                return this.q.startRequestPermission((Activity) this.f54045e);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (alertDialog = this.o) == null) {
            return;
        }
        this.s = false;
        if (this.f54045e instanceof Activity) {
            DialogInterface.OnDismissListener onDismissListener = this.m;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(alertDialog);
            }
            d.a.c.e.m.g.a(this.o, (Activity) this.f54045e);
            MessageManager.getInstance().unRegisterListener(this.y);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            List<View> list = this.k;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public final String o(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, shareItem)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(shareItem.r)) {
                sb.append("【");
                sb.append(shareItem.r);
                sb.append("】 ");
            }
            if (!TextUtils.isEmpty(shareItem.r)) {
                sb.append(shareItem.s);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, view) == null) {
            int id = view.getId();
            int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
            if (id != R.id.btnShareCancel && intValue != R.drawable.icon_pure_share_copy40 && Q()) {
                this.s = false;
                return;
            }
            if (intValue != R.drawable.icon_pure_share_download40) {
                m();
            }
            if (this.r.size() == 0) {
                return;
            }
            if (id == R.id.btnShareCancel || !this.s) {
                this.s = true;
                ShareItem r = r(1);
                d.a.o0.s.g.g gVar = new d.a.o0.s.g.g(this.f54045e, null);
                if (r != null && r.g0) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_AI_APP_SHARE_CLICK).param("obj_id", r.h0).param("obj_type", r.i0).param("obj_source", r.j0));
                }
                if (id == R.id.btnShareCancel) {
                    W("share_cancel", new Object[0]);
                    if (r != null && r.f12844g) {
                        a0(r, 16);
                    }
                    DialogInterface.OnCancelListener onCancelListener = this.n;
                    if (onCancelListener != null) {
                        onCancelListener.onCancel(this.o);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
                if (intValue == R.drawable.icon_mask_share_wechat40_svg) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    W("share_to_weixin", new Object[0]);
                    X(3);
                    ShareItem r2 = r(3);
                    a0(r2, 4);
                    if (r2 != null) {
                        if (u(r2) && r2.a() != null && r2.a().contains(3)) {
                            d.a.o0.s.g.a.e(r2, this.f54045e, 3, this.n);
                        } else if (r2.d0 == 1) {
                            T(r2);
                        } else {
                            gVar.m(r2);
                        }
                    }
                    statisticItem.param("obj_type", 2);
                } else if (intValue == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    W("share_to_pyq", new Object[0]);
                    X(2);
                    ShareItem r3 = r(2);
                    a0(r3, 3);
                    if (r3 != null) {
                        if (u(r3) && r3.a() != null && r3.a().contains(2)) {
                            d.a.o0.s.g.a.e(r3, this.f54045e, 2, this.n);
                        } else if (r3.d0 == 1) {
                            T(r3);
                        } else {
                            if (r3.f12839b) {
                                r3.s = "【" + r3.r + "】 " + r3.s;
                            }
                            gVar.n(r3);
                        }
                    }
                    statisticItem.param("obj_type", 3);
                } else if (intValue == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (z.b(this.f54045e, "com.tencent.mobileqq")) {
                        W("share_to_qzone", new Object[0]);
                        X(4);
                        ShareItem r4 = r(4);
                        a0(r4, 5);
                        if (r4 != null) {
                            if (u(r4) && r4.a() != null && r4.a().contains(4)) {
                                d.a.o0.s.g.a.e(r4, this.f54045e, 4, this.n);
                            } else {
                                gVar.i(r4);
                            }
                        }
                    } else {
                        Context context = this.f54045e;
                        BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
                    }
                    statisticItem.param("obj_type", 5);
                } else if (intValue == R.drawable.icon_qq_weibo) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    W("share_to_qweibo", new Object[0]);
                    X(5);
                    ShareItem r5 = r(5);
                    if (r5 != null) {
                        if (!r5.f12838a) {
                            r5.s = o(r5);
                        }
                        gVar.l(r5);
                    }
                } else if (intValue == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    W("share_to_sweibo", new Object[0]);
                    X(6);
                    ShareItem r6 = r(6);
                    a0(r6, 7);
                    if (r6 != null) {
                        if (!r6.f12838a) {
                            r6.s = o(r6);
                        }
                        if (u(r6) && r6.a() != null && r6.a().contains(4)) {
                            d.a.o0.s.g.a.e(r6, this.f54045e, 6, this.n);
                        } else {
                            gVar.k(r6);
                        }
                    }
                    statisticItem.param("obj_type", 6);
                } else if (intValue == R.drawable.icon_renren) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    W("share_to_renren", new Object[0]);
                    X(7);
                    ShareItem r7 = r(7);
                    if (r7 != null) {
                        if (!r7.f12838a) {
                            r7.s = o(r7);
                        }
                        gVar.j(r7);
                    }
                } else if (intValue == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (z.b(this.f54045e, "com.tencent.mobileqq")) {
                        W("share_to_qq_friend", new Object[0]);
                        X(8);
                        ShareItem r8 = r(8);
                        a0(r8, 9);
                        if (r8 != null) {
                            if (u(r8) && r8.a() != null && r8.a().contains(4)) {
                                d.a.o0.s.g.a.e(r8, this.f54045e, 8, this.n);
                            } else {
                                gVar.h(r8);
                            }
                        }
                    } else {
                        Context context2 = this.f54045e;
                        BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
                    }
                    statisticItem.param("obj_type", 4);
                } else if (intValue == R.drawable.icon_pure_share_download40) {
                    if (this.q == null) {
                        this.q = new PermissionJudgePolicy();
                    }
                    this.q.clearRequestPermissionList();
                    this.q.appendRequestPermission((Activity) this.f54045e, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (this.q.startRequestPermission((Activity) this.f54045e)) {
                        this.s = false;
                        return;
                    }
                    m();
                    a0(r, 17);
                    if (FileHelper.isLocalFile(r.v)) {
                        if (FileHelper.copyImageFile(FileHelper.getImageRealPathFromUri(this.f54045e, r.v), UUID.randomUUID().toString().replace("-", "").toLowerCase(), this.f54045e) == 0) {
                            l.M(this.f54045e, "保存成功！");
                        } else {
                            l.M(this.f54045e, "保存失败！");
                        }
                    } else {
                        String uri = r.v.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity == null) {
                            return;
                        }
                        new q(currentActivity, uri, new e(this)).execute(new String[0]);
                    }
                    statisticItem.param("obj_type", 1);
                } else if (intValue == R.drawable.icon_pure_share_copy40) {
                    a0(r, 10);
                    View.OnClickListener onClickListener = this.l;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    } else {
                        d.a.c.e.p.a.a(r.t);
                        l.M(this.f54045e.getApplicationContext(), this.f54045e.getResources().getString(R.string.copy_pb_url_success));
                    }
                    Y(r);
                    if (r != null && r.f12838a) {
                        Z(8, r.C);
                    }
                }
                statisticItem.param("obj_source", 6);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final Location q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (PermissionUtil.checkLocationForGoogle(this.f54045e)) {
                LocationManager locationManager = (LocationManager) this.f54045e.getSystemService("location");
                Criteria criteria = new Criteria();
                criteria.setAccuracy(1);
                criteria.setAltitudeRequired(false);
                criteria.setBearingRequired(false);
                criteria.setCostAllowed(true);
                criteria.setPowerRequirement(1);
                try {
                    return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (Location) invokeV.objValue;
    }

    public ShareItem r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            ShareItem shareItem = this.r.get(i2);
            return shareItem == null ? this.r.get(1) : shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void s(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, onDismissListener) == null) || onDismissListener == null) {
            return;
        }
        this.m = onDismissListener;
    }

    public LinearLayout t(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048613, this, i2, i3)) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f54045e);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.a();
            return shareDialogItemView;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public final boolean u(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, shareItem)) == null) ? (TextUtils.isEmpty(shareItem.m0) || TextUtils.isEmpty(shareItem.n0)) ? false : true : invokeL.booleanValue;
    }

    public final boolean v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) ? (i2 & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) ? (i2 & 4) > 0 : invokeI.booleanValue;
    }

    public final boolean x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) ? (i2 & 1) > 0 : invokeI.booleanValue;
    }

    public final boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) ? (i2 & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) ? (i2 & 16) > 0 : invokeI.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        this(context, false, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
