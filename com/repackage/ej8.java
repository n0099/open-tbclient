package com.repackage;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper$PayForm;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.BuyTBeanActivity;
import com.baidu.tieba.tbean.view.BuyTBeanGiftBagView;
import com.baidu.tieba.tbean.view.RoundRelativeLayout;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes5.dex */
public class ej8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public RelativeLayout D;
    public BubbleLayout E;
    public boolean F;
    public View.OnClickListener G;
    public View.OnClickListener H;
    public AdapterView.OnItemClickListener I;
    public BuyTBeanGiftBagView.b J;
    public Runnable K;
    public TextWatcher L;
    public BuyTBeanActivity a;
    public View b;
    public RoundRelativeLayout c;
    public NoScrollGridView d;
    public hj8 e;
    public TextView f;
    public TextView g;
    public EditText h;
    public TextView i;
    public kj8 j;
    public TextView k;
    public LinearLayout l;
    public TextView m;
    public boolean n;
    public TextView o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public SpannableString u;
    public ImageView v;
    public TextView w;
    public BuyTBeanGiftBagView x;
    public UserInfo y;
    public RelativeLayout z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej8 a;

        public a(ej8 ej8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h.requestFocus();
                li.M(this.a.a, this.a.h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej8 a;

        public b(ej8 ej8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej8 a;

        public c(ej8 ej8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej8Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            jj8 item;
            IconInfo iconInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.e.getItem(i)) == null || (iconInfo = item.b) == null) {
                return;
            }
            this.a.E(item.b.iconId, fj8.d(iconInfo.dubi.intValue()) * 1, 1, fj8.c(this.a.y, item.b.non_member_t.intValue(), item.a) * 1);
            StatisticItem statisticItem = new StatisticItem("c13147");
            statisticItem.param("obj_param1", item.b.iconId);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements BuyTBeanGiftBagView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej8 a;

        public d(ej8 ej8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej8Var;
        }

        @Override // com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.b
        public void a(ij8 ij8Var) {
            Custom custom;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ij8Var) == null) || ij8Var == null || (custom = ij8Var.a) == null) {
                return;
            }
            this.a.E(ij8Var.a.icon_id, fj8.d(custom.dubi.intValue()) * 1, 1, ij8Var.a.non_member_t.intValue() * 1);
            TiebaStatic.log("c13144");
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej8 a;

        public e(ej8 ej8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.E == null) {
                return;
            }
            this.a.E.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej8 a;

        public f(ej8 ej8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej8Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = this.a.h.getText().toString();
                if (StringUtils.isNull(obj)) {
                    if (this.a.n) {
                        this.a.k.setVisibility(8);
                        this.a.m.setText(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f14e9), this.a.j.c.vip_extra_percent));
                    }
                    this.a.o.setEnabled(false);
                    this.a.h.setHint(this.a.u);
                } else if (obj.startsWith("0")) {
                    if (this.a.n) {
                        this.a.k.setVisibility(8);
                        this.a.m.setText(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f14e9), this.a.j.c.vip_extra_percent));
                    }
                    this.a.h.setText("");
                } else {
                    this.a.o.setEnabled(true);
                    if (!StringUtils.isNull(obj) && obj.length() >= 7) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0354);
                        String substring = obj.substring(0, 6);
                        this.a.h.setText(substring);
                        this.a.h.setSelection(substring.length());
                        return;
                    }
                    long g = jg.g(obj, 0L);
                    if (g > 200000) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0354);
                    }
                    if (g <= 0) {
                        this.a.i.setText(R.string.obfuscated_res_0x7f0f14e7);
                        return;
                    }
                    this.a.h.setHint("");
                    long j = g * 1000;
                    this.a.i.setText(StringHelper.formatTosepara(j));
                    if (!this.a.n || this.a.j == null || this.a.j.c == null) {
                        return;
                    }
                    this.a.k.setVisibility(0);
                    this.a.k.setText(fj8.b((j * this.a.j.c.vip_extra_percent.intValue()) / 100));
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej8 a;

        public g(ej8 ej8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredHeight = this.a.b.getMeasuredHeight();
                int measuredHeight2 = this.a.p.getMeasuredHeight();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.p.getLayoutParams();
                if (layoutParams != null) {
                    this.a.C = measuredHeight - measuredHeight2;
                    layoutParams.topMargin = this.a.C;
                    this.a.p.setLayoutParams(layoutParams);
                }
                ej8 ej8Var = this.a;
                ej8Var.A = ej8Var.z.getHeight();
            }
        }
    }

    public ej8(BuyTBeanActivity buyTBeanActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buyTBeanActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = new a(this);
        this.H = new b(this);
        this.I = new c(this);
        this.J = new d(this);
        this.K = new e(this);
        this.L = new f(this);
        this.a = buyTBeanActivity;
        z();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            wq4 d2 = wq4.d(this.p);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.s, R.color.common_color_10191, 1, i);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
            if (i != 1 && i != 4) {
                this.c.setBgColorRes(R.color.CAM_X0201);
            } else {
                this.c.setBgColorRes(R.color.CAM_X0201_1);
            }
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor((TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090466), R.color.CAM_X0105, 1, i);
            hj8 hj8Var = this.e;
            if (hj8Var != null) {
                hj8Var.notifyDataSetChanged();
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            mg.a().removeCallbacks(this.K);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.F = true;
                if (this.B <= 0) {
                    this.B = (li.i(this.a) - this.b.getHeight()) - li.s(this.a);
                }
                int height = ((this.B + this.c.getHeight()) + this.D.getHeight()) - this.A;
                if (height > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
                    layoutParams.topMargin -= height;
                    this.p.setLayoutParams(layoutParams);
                    this.z.scrollTo(0, this.B - height);
                } else {
                    this.z.scrollTo(0, this.B);
                }
                EditText editText = this.h;
                editText.setSelection(editText.getText().length());
                TiebaStatic.log("c13145");
                return;
            }
            this.F = false;
            this.z.scrollTo(0, 0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams2.topMargin = this.C;
            this.p.setLayoutParams(layoutParams2);
            this.h.clearFocus();
        }
    }

    public final void E(String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048580, this, str, i, i2, i3) == null) || StringUtils.isNull(str) || i < 0 || i2 < 0 || i3 < 0) {
            return;
        }
        if (!ji.z()) {
            BuyTBeanActivity buyTBeanActivity = this.a;
            buyTBeanActivity.showToast(buyTBeanActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0c34));
            return;
        }
        gj8.a("c10296");
        PayConfig payConfig = new PayConfig(2, "0", str, String.valueOf(i), String.valueOf(i2), true, String.valueOf(i3), this.a.isPayDialog(), PageDialogHelper$PayForm.NOT_SET, this.a.getReferPage(), this.a.getClickZone());
        payConfig.setFromDecreaseGiftStepStrategy(this.a.isFromDecreaseGiftStepStrategy());
        p75.c().a(payConfig, this.a);
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.o.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(0, R.id.obfuscated_res_0x7f090475);
                layoutParams.addRule(15);
                layoutParams.rightMargin = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f);
                this.h.setLayoutParams(layoutParams);
                return;
            }
            this.o.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.addRule(11);
                layoutParams2.rightMargin = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c1);
            }
        }
    }

    public void G(List<jj8> list, kj8 kj8Var, List<ij8> list2, UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, list, kj8Var, list2, userInfo) == null) {
            if (userInfo != null) {
                this.y = userInfo;
            }
            if (!ListUtils.isEmpty(list)) {
                int i = ListUtils.getCount(list) == 6 ? 3 : 2;
                this.d.setNumColumns(i);
                this.e.b(i);
                this.e.c(list);
            }
            if (kj8Var != null) {
                this.j = kj8Var;
                Setting setting = kj8Var.c;
                if (setting != null && setting.vip_extra_switch.intValue() == 1 && this.j.c.vip_extra_percent.intValue() > 0) {
                    this.n = true;
                    this.l.setVisibility(0);
                    this.k.setVisibility(8);
                    this.m.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f14e9), this.j.c.vip_extra_percent));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.tbds208);
                        this.c.setLayoutParams(layoutParams);
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.width = this.a.getResources().getDimensionPixelSize(R.dimen.tbds203);
                        this.o.setLayoutParams(layoutParams2);
                    }
                } else {
                    this.l.setVisibility(8);
                    this.n = false;
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
                    if (layoutParams3 != null) {
                        layoutParams3.height = this.a.getResources().getDimensionPixelSize(R.dimen.tbds174);
                        this.c.setLayoutParams(layoutParams3);
                    }
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                    if (layoutParams4 != null) {
                        layoutParams4.width = this.a.getResources().getDimensionPixelSize(R.dimen.tbds176);
                        this.o.setLayoutParams(layoutParams4);
                    }
                }
                Custom custom = this.j.a;
                if (custom != null) {
                    Integer num = custom.duration;
                    this.w.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08a4, new Object[]{this.j.a.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
                }
            }
            if (!ListUtils.isEmpty(list2)) {
                this.x.d(list2);
            }
            this.p.post(new g(this));
        }
    }

    public void H(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            if (f2 > 0.0f) {
                EditText editText = this.h;
                StringBuilder sb = new StringBuilder();
                float f3 = f2 / 1000.0f;
                sb.append(f3);
                sb.append("");
                editText.setText(sb.toString());
                EditText editText2 = this.h;
                editText2.setSelection(editText2.getText().length());
                TextView textView = this.s;
                textView.setText((f3 * 1000.0f) + "");
                this.s.setVisibility(0);
                this.t.setVisibility(0);
                if (ys4.k().h("key_tbean_buy_bubble_show", false)) {
                    return;
                }
                BubbleLayout bubbleLayout = this.E;
                if (bubbleLayout != null) {
                    bubbleLayout.setVisibility(0);
                    ys4.k().u("key_tbean_buy_bubble_show", true);
                }
                mg.a().removeCallbacks(this.K);
                mg.a().postDelayed(this.K, 4000L);
                return;
            }
            this.h.setText("");
            this.E.setVisibility(8);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d6);
                this.p.setLayoutParams(layoutParams);
            }
            BuyTBeanActivity buyTBeanActivity = this.a;
            buyTBeanActivity.setNetRefreshViewTopMargin(buyTBeanActivity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d5));
            BuyTBeanActivity buyTBeanActivity2 = this.a;
            buyTBeanActivity2.showNetRefreshView(this.z, buyTBeanActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0c33));
        }
    }

    public void J() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (view2 = this.b) == null) {
            return;
        }
        view2.setVisibility(0);
    }

    public final void u() {
        kj8 kj8Var;
        UserInfo userInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int e2 = jg.e(this.h.getText().toString(), 0);
            int i = e2 * 1;
            if (i > 200000) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0354);
            } else if (i <= 0 || i <= 0 || (kj8Var = this.j) == null || (userInfo = kj8Var.b) == null || kj8Var.a == null) {
            } else {
                E(this.j.a.icon_id, i, e2, fj8.c(userInfo, i * 1000, kj8Var.c) * 1);
                TiebaStatic.log("c13141");
            }
        }
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.hideNetRefreshView(this.z);
        }
    }

    public void x() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (view2 = this.b) == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.h.clearFocus();
            li.x(this.a, this.h);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d016c, (ViewGroup) null);
            this.b = inflate;
            inflate.setFocusable(true);
            this.b.setOnClickListener(this.a);
            this.p = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090471);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090467);
            this.c = roundRelativeLayout;
            roundRelativeLayout.setRadius(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702e9));
            this.c.setOnClickListener(this.G);
            this.z = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090464);
            this.r = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090478);
            this.d = (NoScrollGridView) this.b.findViewById(R.id.obfuscated_res_0x7f09046c);
            hj8 hj8Var = new hj8(this.a.getPageContext());
            this.e = hj8Var;
            this.d.setAdapter((ListAdapter) hj8Var);
            this.d.setOnItemClickListener(this.I);
            this.D = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090461);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090462);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090460);
            this.f = textView;
            textView.setText(String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum));
            Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds46);
            normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.f.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.tbds12));
            this.f.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
            this.h = (EditText) this.b.findViewById(R.id.obfuscated_res_0x7f090465);
            this.u = new SpannableString(this.a.getString(R.string.obfuscated_res_0x7f0f0360));
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(this.a.getResources().getDimensionPixelSize(R.dimen.tbds42), false);
            SpannableString spannableString = this.u;
            spannableString.setSpan(absoluteSizeSpan, 0, spannableString.length(), 33);
            this.h.setHint(this.u);
            this.h.addTextChangedListener(this.L);
            TextView textView2 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090468);
            this.i = textView2;
            textView2.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070305));
            this.i.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
            this.l = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09046d);
            this.k = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09046f);
            Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
            int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
            normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
            this.k.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702e9));
            this.k.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
            this.m = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09046e);
            TextView textView3 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090475);
            this.o = textView3;
            textView3.setOnClickListener(this.H);
            TextView textView4 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090479);
            this.q = textView4;
            textView4.setOnClickListener(this.a);
            TextView textView5 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090469);
            this.s = textView5;
            textView5.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070305));
            this.s.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
            this.t = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09046a);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090463);
            this.v = imageView;
            imageView.setOnClickListener(this.a);
            this.w = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09047a);
            BuyTBeanGiftBagView buyTBeanGiftBagView = (BuyTBeanGiftBagView) this.b.findViewById(R.id.obfuscated_res_0x7f09046b);
            this.x = buyTBeanGiftBagView;
            buyTBeanGiftBagView.setClickListener(this.J);
            this.E = (BubbleLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090472);
            F(true);
        }
    }
}
