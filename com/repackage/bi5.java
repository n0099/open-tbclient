package com.repackage;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.th5;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public ai5 B;
    public UserData C;
    public boolean D;
    public boolean E;
    public int F;
    public ClickableSpan G;
    public boolean H;
    public CompoundButton.OnCheckedChangeListener I;
    public PopupWindow.OnDismissListener J;
    public CustomMessageListener K;
    public Context a;
    public TbPageContext b;
    public lp4 c;
    public SparseArray<String> d;
    public List<th5.b> e;
    public int f;
    public int g;
    public int h;
    public NEGFeedBackView.b i;
    public PopupWindow j;
    public View k;
    public th5 l;
    public boolean m;
    public int n;
    public PopupWindow o;
    public ViewGroup p;
    public EMTextView q;
    public EMTextView r;
    public EMTextView s;
    public EMTextView t;
    public EMTextView u;
    public LinearLayout v;
    public String w;
    public g x;
    public h y;
    public xt4 z;

    /* loaded from: classes5.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi5 a;

        public a(bi5 bi5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bi5Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.a.i != null) {
                    this.a.i.b(this.a.c, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof th5.b) {
                    th5.b bVar = (th5.b) compoundButton.getTag();
                    if (z) {
                        if (this.a.e.contains(bVar)) {
                            return;
                        }
                        this.a.e.add(bVar);
                        if (!this.a.D || this.a.r == null) {
                            return;
                        }
                        this.a.r.setClickable(true);
                        vr4.d(this.a.r).v(R.color.CAM_X0302);
                        return;
                    }
                    this.a.e.remove(bVar);
                    if (!this.a.D || this.a.r == null) {
                        return;
                    }
                    this.a.r.setClickable(false);
                    this.a.r.setTextColor(gj8.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi5 a;

        public b(bi5 bi5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bi5Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.j == null) {
                return;
            }
            this.a.j.dismiss();
            this.a.j = null;
            MessageManager.getInstance().unRegisterListener(this.a.K);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bi5 bi5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi5Var, Integer.valueOf(i)};
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
            this.a = bi5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.t();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi5 a;

        public d(bi5 bi5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bi5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.j != null) {
                    this.a.j.dismiss();
                    this.a.j = null;
                }
                if (this.a.o != null) {
                    this.a.o.dismiss();
                    this.a.o = null;
                }
                if (this.a.H) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CANCEL_CLICK).param("obj_source", this.a.w));
                }
                if (this.a.x != null) {
                    this.a.x.onClick();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi5 a;

        public e(bi5 bi5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bi5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                JSONObject w = this.a.w();
                if (this.a.w == "3" || this.a.w == "4" || this.a.w == "1") {
                    this.a.v();
                } else if (w != null) {
                    this.a.H();
                    CustomMessage customMessage = new CustomMessage(2016489, this.a.b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, w);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi5 a;

        public f(bi5 bi5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bi5Var;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.a.a, this.a.B.b(), this.a.B.c(), this.a.B.a(), this.a.B.g(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                if (this.a.j != null) {
                    this.a.j.dismiss();
                    this.a.j = null;
                }
                if (this.a.o != null) {
                    this.a.o.dismiss();
                    this.a.o = null;
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void onClick();
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a(JSONArray jSONArray);
    }

    public bi5(TbPageContext tbPageContext, View view2, ai5 ai5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, ai5Var, userData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = new ArrayList();
        this.i = null;
        this.o = null;
        this.z = null;
        this.A = 3;
        this.D = true;
        this.E = false;
        this.I = new a(this);
        this.J = new b(this);
        this.K = new c(this, 2001304);
        this.a = tbPageContext.getPageActivity();
        this.b = tbPageContext;
        this.k = view2;
        this.B = ai5Var;
        this.C = userData;
        A();
        z();
    }

    public final void A() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ai5 ai5Var = this.B;
            if (ai5Var != null) {
                if (ai5Var.e() == 1) {
                    this.D = false;
                } else {
                    this.D = true;
                }
                if (this.B.d() == 1) {
                    this.E = false;
                } else {
                    this.E = true;
                }
            }
            if (!this.E || (userData = this.C) == null) {
                return;
            }
            this.F = userData.getIs_manager();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m && this.e.size() != 0) {
            this.e.clear();
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.H = z;
        }
    }

    public void D(lp4 lp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, lp4Var) == null) || lp4Var == null) {
            return;
        }
        this.c = lp4Var;
        SparseArray<String> b2 = lp4Var.b();
        this.d = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.d.size() - 1; size >= 8; size--) {
                this.d.removeAt(size);
            }
        }
        this.l.j(lp4Var);
    }

    public void E(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
            this.l.k(strArr);
        }
    }

    public void F(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.y = hVar;
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.a == null) {
            return;
        }
        this.w = str;
        View x = x();
        if (x != null && x.getParent() != null) {
            ((ViewGroup) x.getParent()).removeView(x);
        }
        if (x == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
        gradientDrawable.setCornerRadius(oi.f(this.a, R.dimen.tbds31));
        x.setBackgroundDrawable(gradientDrawable);
        t();
        this.f = y();
        PopupWindow popupWindow = new PopupWindow(x, this.g, this.f);
        this.o = popupWindow;
        popupWindow.setFocusable(true);
        this.o.setTouchable(true);
        this.o.setOnDismissListener(this.J);
        B();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0892, (ViewGroup) null), -1, -1);
        this.j = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.j.showAtLocation(this.k, 0, 0, 0);
        this.o.showAtLocation(this.k, 17, 0, 0);
        NEGFeedBackView.b bVar = this.i;
        if (bVar != null) {
            bVar.c(this.c);
        }
        this.m = true;
        MessageManager.getInstance().registerListener(this.K);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.z == null) {
                this.z = new xt4(this.b);
            }
            this.z.i(R.string.obfuscated_res_0x7f0f0a2e);
            this.z.h(true);
        }
    }

    public final void t() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.A) {
            return;
        }
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColorSelector(this.q, R.color.CAM_X0105);
        if (this.D) {
            this.r.setTextColor(gj8.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.r.setClickable(false);
        } else {
            vr4.d(this.r).v(R.color.CAM_X0302);
        }
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1);
        this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
        gradientDrawable.setCornerRadius(oi.f(this.a, R.dimen.tbds31));
        this.p.setBackgroundDrawable(gradientDrawable);
        this.A = skinType;
    }

    public void u() {
        xt4 xt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (xt4Var = this.z) == null) {
            return;
        }
        xt4Var.h(false);
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            PopupWindow popupWindow = this.o;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.o = null;
            }
            PopupWindow popupWindow2 = this.j;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.j = null;
            }
        }
    }

    public final JSONObject w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.c == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            if (!ListUtils.isEmpty(this.e)) {
                int i2 = 0;
                while (i < this.e.size()) {
                    th5.b bVar = this.e.get(i);
                    if (bVar != null) {
                        jSONArray.put(String.valueOf(bVar.b));
                        i2 = bVar.a + 1;
                    }
                    i++;
                }
                i = i2;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.w).param("obj_type", i));
            if (this.H) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_REASON_CLICK).param("obj_source", this.w).param("obj_type", i));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CONFIRM_CLICK).param("obj_source", this.w).param("obj_type", i));
            }
            h hVar = this.y;
            if (hVar != null) {
                hVar.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.c.g());
                jSONObject.put("type", this.c.a());
                jSONObject.put("forum_id", this.c.c());
                jSONObject.put("is_frs_masks", this.c.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return null;
            }
            if (this.p == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d084e, (ViewGroup) null);
                this.p = viewGroup;
                EMTextView eMTextView = (EMTextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092242);
                this.s = eMTextView;
                if (this.H) {
                    eMTextView.setText(R.string.obfuscated_res_0x7f0f115c);
                } else {
                    eMTextView.setText(R.string.obfuscated_res_0x7f0f04a2);
                }
                vr4 d2 = vr4.d(this.s);
                d2.A(R.string.F_X02);
                d2.v(R.color.CAM_X0105);
                EMTextView eMTextView2 = (EMTextView) this.p.findViewById(R.id.obfuscated_res_0x7f09223d);
                this.t = eMTextView2;
                vr4.d(eMTextView2).z(R.dimen.T_X08);
                EMTextView eMTextView3 = (EMTextView) this.p.findViewById(R.id.obfuscated_res_0x7f09223b);
                this.q = eMTextView3;
                eMTextView3.setOnClickListener(new d(this));
                EMTextView eMTextView4 = (EMTextView) this.p.findViewById(R.id.obfuscated_res_0x7f09223c);
                this.r = eMTextView4;
                if (this.H) {
                    eMTextView4.setText(R.string.obfuscated_res_0x7f0f1159);
                } else {
                    eMTextView4.setText(R.string.obfuscated_res_0x7f0f0495);
                }
                this.r.setOnClickListener(new e(this));
            }
            this.v = (LinearLayout) this.p.findViewById(R.id.obfuscated_res_0x7f09223f);
            View g2 = this.l.g();
            if (g2 != null && g2.getParent() == null) {
                int f2 = oi.f(this.a, R.dimen.M_W_X009);
                g2.setPadding(f2, 0, f2, 0);
                this.v.addView(g2);
            }
            EMTextView eMTextView5 = (EMTextView) this.p.findViewById(R.id.obfuscated_res_0x7f092241);
            this.u = eMTextView5;
            eMTextView5.setHighlightColor(SelectorHelper.getResources().getColor(17170445));
            if (this.E) {
                this.u.setVisibility(0);
                if (1 == this.F) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) this.a.getString(R.string.obfuscated_res_0x7f0f10f3));
                    f fVar = new f(this);
                    this.G = fVar;
                    spannableStringBuilder.setSpan(fVar, 13, 17, 18);
                    this.u.setText(spannableStringBuilder);
                    this.u.setMovementMethod(LinkMovementMethod.getInstance());
                } else {
                    this.u.setText(this.a.getString(R.string.obfuscated_res_0x7f0f10f2));
                }
            } else {
                this.u.setVisibility(8);
            }
            this.u.setClickable(false);
            this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
            t();
            return this.p;
        }
        return (View) invokeV.objValue;
    }

    public final int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ViewGroup viewGroup = this.p;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.p.getMeasuredHeight();
            this.h = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.n = oi.f(this.a, R.dimen.M_W_X009);
            this.g = oi.k(this.a) - (this.n * 2);
            th5 th5Var = new th5(this.b);
            this.l = th5Var;
            th5Var.o(this.I);
            this.l.n(true);
            if (this.E) {
                this.l.l(5);
            }
        }
    }
}
