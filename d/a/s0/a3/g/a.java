package d.a.s0.a3.g;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
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
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.s.c.g0;
import d.a.r0.s.g.g;
import d.a.s0.h3.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f57291e;

    /* renamed from: f  reason: collision with root package name */
    public final View f57292f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f57293g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f57294h;

    /* renamed from: i  reason: collision with root package name */
    public ShareGridLayout f57295i;
    public final List<View> j;
    public View.OnClickListener k;
    public DialogInterface.OnDismissListener l;
    public AlertDialog m;
    public final SparseArray<ShareItem> n;
    public boolean o;
    public SparseArray<String> p;
    public SparseArray<g0> q;

    /* renamed from: d.a.s0.a3.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1302a implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57296e;

        public C1302a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57296e = aVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.f57296e.m == null || !this.f57296e.m.isShowing()) {
                    return null;
                }
                this.f57296e.f();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57297e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57297e = aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f57297e.l != null) {
                    this.f57297e.l.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View.OnClickListener f57298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f57299f;

        public c(a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57299f = aVar;
            this.f57298e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57299f.f();
                View.OnClickListener onClickListener = this.f57298e;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-212577742, "Ld/a/s0/a3/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-212577742, "Ld/a/s0/a3/g/a;");
                return;
            }
        }
        r = (int) ((l.k(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) * 0.2d);
        s = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds234);
        t = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        u = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
        v = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        w = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    }

    public a(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = new SparseArray<>(8);
        this.o = false;
        this.f57291e = context;
        this.j = new ArrayList();
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
        this.f57292f = inflate;
        this.f57294h = (TextView) inflate.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.f57294h.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.f57292f.findViewById(R.id.share_grid_layout);
        this.f57295i = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i5 = ShareGridLayout.j;
            marginLayoutParams.leftMargin = i5;
            marginLayoutParams.rightMargin = i5;
            this.f57295i.setLayoutParams(marginLayoutParams);
        }
        this.f57295i.setItemParams(r, s);
        TextView textView = (TextView) this.f57292f.findViewById(R.id.btnShareCancel);
        this.f57293g = textView;
        textView.setOnClickListener(this);
        if (!p(i2)) {
            n(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!q(i2)) {
            n(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!o(i2)) {
            n(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!r(i2)) {
            n(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (g.g()) {
            return;
        }
        this.f57295i.setVisibility(8);
    }

    public final void A(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, shareItem, i2) == null) || shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f12822b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2));
        } else if (!shareItem.f12823c && !shareItem.f12826f) {
            if (shareItem.f12824d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.f12821a) {
                z(i2, shareItem.C);
            } else if (shareItem.f12825e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q));
            } else if (shareItem.f12827g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                if (!k.isEmpty(shareItem.t) && shareItem.t.contains("worldcup")) {
                    param.param("obj_param1", 9);
                }
                TiebaStatic.log(param);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J));
        }
    }

    public void c(View view, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, onClickListener) == null) || i2 > this.j.size() || i2 < 0) {
            return;
        }
        this.j.add(i2, view);
        if (onClickListener != null) {
            view.setOnClickListener(new c(this, onClickListener));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                this.f57295i.addView(this.j.get(i2), new ViewGroup.LayoutParams(r, s));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void f() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (alertDialog = this.m) == null) {
            return;
        }
        this.o = false;
        Context context = this.f57291e;
        if (context instanceof Activity) {
            d.a.c.e.m.g.a(alertDialog, (Activity) context);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<View> list = this.j;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public final String i(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, shareItem)) == null) {
            String str = "【" + shareItem.r + "】 " + shareItem.s;
            shareItem.s = str;
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final Location j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (PermissionUtil.checkLocationForGoogle(this.f57291e)) {
                LocationManager locationManager = (LocationManager) this.f57291e.getSystemService("location");
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

    public final ShareItem k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ShareItem shareItem = this.n.get(i2);
            return shareItem == null ? this.n.get(1) : shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void l(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, onDismissListener) == null) || onDismissListener == null) {
            return;
        }
        this.l = onDismissListener;
    }

    public LinearLayout m(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f57291e);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i3));
            ImageView imageView = new ImageView(this.f57291e);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
            int i4 = t;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
            layoutParams.topMargin = u;
            layoutParams.bottomMargin = v;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.f57291e);
            textView.setTextSize(0, w);
            textView.setText(i2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageResource(i3);
            textView.setTextColor(this.f57291e.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            return linearLayout;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public final void n(AbsSvgType absSvgType, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048587, this, absSvgType, i2, i3) == null) || absSvgType == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.f57291e);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i3));
        ImageView imageView = new ImageView(this.f57291e);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
        }
        int i4 = t;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
        layoutParams.topMargin = u;
        layoutParams.bottomMargin = v;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f57291e);
        textView.setTextSize(0, w);
        textView.setText(i2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageDrawable(absSvgType.getDrawable());
        textView.setTextColor(this.f57291e.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.j.add(linearLayout);
    }

    public final boolean o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? (i2 & 8) > 0 : invokeI.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            int id = view.getId();
            int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
            if (this.n.size() == 0) {
                return;
            }
            if (view.getId() == R.id.btnShareCancel || !this.o) {
                this.o = true;
                g gVar = new g(this.f57291e, null);
                ShareItem k = k(1);
                if (id == R.id.btnShareCancel) {
                    w("share_cancel", new Object[0]);
                    f();
                    return;
                }
                if (intValue == 4) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    w("share_to_weixin", new Object[0]);
                    x(3);
                    ShareItem k2 = k(3);
                    A(k2, 4);
                    if (k2 != null) {
                        gVar.m(k2);
                    }
                } else if (intValue == 3) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    w("share_to_pyq", new Object[0]);
                    x(2);
                    ShareItem k3 = k(2);
                    A(k3, 3);
                    if (k3 != null) {
                        if (k3.f12822b) {
                            k3.s = "【" + k3.r + "】 " + k3.s;
                        }
                        gVar.n(k3);
                    }
                } else if (intValue == 5) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    } else if (z.b(this.f57291e, "com.tencent.mobileqq")) {
                        w("share_to_qzone", new Object[0]);
                        x(4);
                        ShareItem k4 = k(4);
                        A(k4, 5);
                        if (k4 != null) {
                            gVar.i(k4);
                        }
                    } else {
                        Context context = this.f57291e;
                        BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
                    }
                } else if (intValue == 6) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    w("share_to_qweibo", new Object[0]);
                    x(5);
                    ShareItem k5 = k(5);
                    A(k5, 6);
                    if (k5 != null) {
                        if (!k5.f12821a) {
                            k5.s = i(k5);
                        }
                        gVar.l(k5);
                    }
                } else if (intValue == 7) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    w("share_to_sweibo", new Object[0]);
                    x(6);
                    ShareItem k6 = k(6);
                    A(k6, 7);
                    if (k6 != null) {
                        if (!k6.f12821a) {
                            k6.s = i(k6);
                        }
                        gVar.k(k6);
                    }
                } else if (intValue == 8) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    w("share_to_renren", new Object[0]);
                    x(7);
                    ShareItem k7 = k(7);
                    A(k7, 8);
                    if (k7 != null) {
                        if (!k7.f12821a) {
                            k7.s = i(k7);
                        }
                        gVar.j(k7);
                    }
                } else if (intValue == 9) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    } else if (z.b(this.f57291e, "com.tencent.mobileqq")) {
                        w("share_to_qq_friend", new Object[0]);
                        x(8);
                        ShareItem k8 = k(8);
                        A(k8, 9);
                        if (k8 != null) {
                            gVar.h(k8);
                        }
                    } else {
                        Context context2 = this.f57291e;
                        BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
                    }
                } else if (intValue == 10) {
                    A(k, 10);
                    View.OnClickListener onClickListener = this.k;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    } else {
                        d.a.c.e.p.a.a(k.t);
                        l.M(this.f57291e.getApplicationContext(), this.f57291e.getResources().getString(R.string.copy_pb_url_success));
                    }
                    y(k);
                    if (k != null && k.f12821a) {
                        z(8, k.C);
                    }
                }
                f();
            }
        }
    }

    public final boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? (i2 & 1) > 0 : invokeI.booleanValue;
    }

    public final boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? (i2 & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? (i2 & 16) > 0 : invokeI.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new C1302a(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.k = onClickListener;
    }

    public void u(ShareItem shareItem, boolean z) {
        Location j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, shareItem, z) == null) {
            if (z && (j = j()) != null) {
                shareItem.B = j;
            }
            this.n.put(1, shareItem);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!j.z()) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (!g.g()) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
            } else {
                d();
                AlertDialog create = new AlertDialog.Builder(this.f57291e, R.style.DialogTheme).create();
                this.m = create;
                create.setCanceledOnTouchOutside(true);
                this.m.setOnDismissListener(new b(this));
                Context context = this.f57291e;
                if (context instanceof Activity) {
                    d.a.c.e.m.g.i(this.m, (Activity) context);
                }
                this.f57292f.setBackgroundResource(R.drawable.transmit_share_dialog_background);
                Window window = this.m.getWindow();
                window.addFlags(512);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.f57292f);
                e();
                s();
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void w(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.f57291e, str, PrefetchEvent.STATE_CLICK, 1, objArr);
        }
    }

    public final void x(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || i2 > 8 || i2 <= 0) {
            return;
        }
        this.o = true;
        SparseArray<g0> sparseArray = this.q;
        if (sparseArray != null) {
            g0 g0Var = sparseArray.get(i2);
            if (!StringUtils.isNull(g0Var.b()) && g0Var.a() != null && g0Var.a().size() > 0) {
                w(g0Var.b(), g0Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.p;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i2);
            if (k.isEmpty(str)) {
                return;
            }
            w(str, new Object[0]);
        }
    }

    public final void y(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 9);
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
            param.param("obj_locate", 7);
            TiebaStatic.log(param);
        }
    }

    public final void z(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i2, str) == null) {
            TiebaStatic.eventStat(this.f57291e, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }
}
