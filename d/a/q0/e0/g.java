package d.a.q0.e0;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55597a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.t.e.a f55598b;

    /* renamed from: c  reason: collision with root package name */
    public b2 f55599c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f55600d;

    /* renamed from: e  reason: collision with root package name */
    public PopupWindow f55601e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f55602f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55603g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f55604h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.s.f0.n.b f55605i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public View q;
    public int r;
    public PopupWindow.OnDismissListener s;
    public View.OnClickListener t;

    /* loaded from: classes8.dex */
    public class a implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f55606e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55606e = gVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55606e.f55601e == null) {
                return;
            }
            this.f55606e.f55601e.dismiss();
            this.f55606e.f55601e = null;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f55607e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55607e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.A()) {
                    this.f55607e.f55597a.showToast(R.string.network_ungeilivable);
                }
                if (ViewHelper.checkUpIsLogin(this.f55607e.f55597a.getPageActivity())) {
                    if (this.f55607e.f55599c == null) {
                        return;
                    }
                    this.f55607e.f55598b.m(false, this.f55607e.f55599c.H().getPortrait(), this.f55607e.f55599c.H().getUserId(), this.f55607e.f55599c.H().isGod(), "0", this.f55607e.f55597a.getUniqueId(), null, "0");
                    TiebaStatic.log(new StatisticItem("c13571"));
                }
                if (this.f55607e.f55601e == null || this.f55607e.f55600d == null) {
                    return;
                }
                this.f55607e.f55601e.dismiss();
                this.f55607e.f55600d.dismiss();
                this.f55607e.f55600d = null;
                this.f55607e.f55601e = null;
            }
        }
    }

    public g(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = 3;
        this.s = new a(this);
        this.t = new b(this);
        this.f55597a = tbPageContext;
        this.f55598b = new d.a.p0.t.e.a(tbPageContext);
        this.q = view;
        m();
    }

    public void h(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
            this.f55599c = b2Var;
        }
    }

    public final boolean i(Context context, View view, int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) {
            if (context == null || view == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int height = view.getHeight();
            int i6 = l.i(context);
            int k = l.k(context);
            boolean z = ((i6 - iArr2[1]) - height) - i4 < i2;
            iArr[0] = k - i3;
            if (z) {
                iArr[1] = (iArr2[1] - i2) - i5;
                iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            } else {
                iArr[1] = iArr2[1] + height + i5;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final void j() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.r) {
            return;
        }
        SkinManager.setViewTextColor(this.f55603g, R.color.CAM_X0105, 1);
        this.r = skinType;
    }

    public final View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f55597a.getContext() == null) {
                return null;
            }
            if (this.f55602f == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f55597a.getContext()).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.f55602f = viewGroup;
                TextView textView = (TextView) viewGroup.findViewById(R.id.head_text);
                this.f55603g = textView;
                textView.setText(this.f55597a.getString(R.string.confirm_unlike));
                SkinManager.setViewTextColor(this.f55603g, R.color.CAM_X0105, 1);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f55602f.findViewById(R.id.uninterested_btn);
                this.f55604h = tBSpecificationBtn;
                tBSpecificationBtn.setText(this.f55597a.getString(R.string.confirm_unlike_confirm));
                this.f55604h.setTextSize(R.dimen.T_X08);
                this.f55604h.setOnClickListener(this.t);
                d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
                this.f55605i = bVar;
                bVar.q(R.color.CAM_X0304);
                this.f55604h.setConfig(this.f55605i);
                ViewGroup viewGroup2 = this.f55602f;
                int i2 = this.j;
                viewGroup2.setPadding(i2, 0, i2, 0);
            }
            j();
            return this.f55602f;
        }
        return (View) invokeV.objValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ViewGroup viewGroup = this.f55602f;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f55602f.getMeasuredHeight();
            this.o = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j = l.g(this.f55597a.getContext(), R.dimen.M_W_X005);
            this.k = l.g(this.f55597a.getContext(), R.dimen.M_W_X004);
            this.l = l.g(this.f55597a.getContext(), R.dimen.tbds14);
            this.p = l.g(this.f55597a.getContext(), R.dimen.tbds160);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f55597a.getContext() == null) {
            return;
        }
        View k = k();
        this.n = l.k(this.f55597a.getContext()) - (this.k * 2);
        this.m = l();
        int[] iArr = new int[2];
        boolean i2 = i(this.f55597a.getContext(), this.q, this.m, this.n, this.p, this.l, iArr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(l.g(this.f55597a.getContext(), R.dimen.tbds31));
        k.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(k, this.n, l());
        this.f55600d = popupWindow;
        popupWindow.setFocusable(true);
        this.f55600d.setTouchable(true);
        this.f55600d.setOnDismissListener(this.s);
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f55597a.getPageActivity()).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.f55601e = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.f55601e.showAtLocation(this.q, 0, 0, 0);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.f55600d.setBackgroundDrawable(new ColorDrawable(0));
        if (i2) {
            this.f55600d.setAnimationStyle(R.style.scale_rb2lt_anim);
        } else {
            this.f55600d.setAnimationStyle(R.style.scale_rt2lb_anim);
        }
        this.f55600d.showAtLocation(this.q, 0, iArr[0] - this.k, iArr[1]);
    }
}
