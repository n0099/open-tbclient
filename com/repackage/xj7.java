package com.repackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.CardBoxMemberPayActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ck7;
import java.util.List;
/* loaded from: classes7.dex */
public class xj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardBoxMemberPayActivity a;
    public TbImageView b;
    public TextView c;
    public HeadImageView d;
    public TextView e;
    public TextView f;
    public LinearLayout g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public LinearLayout n;
    public View o;
    public List<ck7.d> p;
    public ck7.d q;
    public String r;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj7 a;

        public a(xj7 xj7Var, List<ck7.d> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xj7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null) {
                return;
            }
            for (int i = 0; i < this.a.g.getChildCount(); i++) {
                View childAt = this.a.g.getChildAt(i);
                if (childAt == null || childAt.getTag() == null) {
                    return;
                }
                ck7.d dVar = childAt.getTag() instanceof ck7.d ? (ck7.d) childAt.getTag() : null;
                if (dVar == null) {
                    return;
                }
                if (view2 == childAt) {
                    dVar.m = true;
                    this.a.q = dVar;
                    this.a.r = dVar.g;
                    SkinManager.setViewTextColor(childAt, (int) R.color.CAM_X0305);
                    SkinManager.setBackgroundResource(childAt, R.drawable.card_box_selected_bg);
                } else {
                    dVar.m = false;
                    SkinManager.setViewTextColor(childAt, (int) R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(childAt, R.drawable.card_box_normal_bg);
                }
            }
            this.a.p();
        }
    }

    public xj7(CardBoxMemberPayActivity cardBoxMemberPayActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cardBoxMemberPayActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = null;
        this.r = "";
        this.a = cardBoxMemberPayActivity;
        cardBoxMemberPayActivity.setContentView(R.layout.obfuscated_res_0x7f0d0180);
        this.m = this.a.findViewById(R.id.obfuscated_res_0x7f0904d6);
        LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0904d5);
        this.n = linearLayout;
        linearLayout.setOnClickListener(cardBoxMemberPayActivity);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f0908c7);
        this.o = findViewById;
        findViewById.setOnClickListener(cardBoxMemberPayActivity);
        this.b = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09202b);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09202c);
        this.d = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d2d);
        this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09229d);
        this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090787);
        this.g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09061b);
        this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09035e);
        this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090153);
        this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0907cc);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091603);
        this.k = textView;
        textView.setOnClickListener(cardBoxMemberPayActivity);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0904d4);
        this.l = textView2;
        textView2.setOnClickListener(cardBoxMemberPayActivity);
        this.h.getPaint().setFlags(16);
        this.d.setIsRound(true);
        this.d.setDrawBorder(false);
    }

    public ck7.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : (ck7.d) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public LinearLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : (LinearLayout) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TextView textView = this.c;
            if (textView != null) {
                return textView.getText().toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.m);
        }
    }

    public final void k(ck7 ck7Var) {
        ck7.b bVar;
        ck7.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ck7Var) == null) || ck7Var == null || (bVar = ck7Var.b) == null || (aVar = bVar.b) == null) {
            return;
        }
        this.p = aVar.a;
    }

    public final void l() {
        List<ck7.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (list = this.p) == null || list.size() <= 0) {
            return;
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            ck7.d dVar = this.p.get(i);
            if (dVar != null && dVar.m) {
                this.q = dVar;
                return;
            }
        }
    }

    public void m(ck7 ck7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, ck7Var) == null) || ck7Var == null) {
            return;
        }
        k(ck7Var);
        l();
        q(ck7Var);
        p();
        o();
    }

    public String n(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i)) == null) {
            if (str == null) {
                return "";
            }
            if (str.length() > i) {
                return str.substring(0, i - 1) + StringHelper.STRING_MORE;
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public final void o() {
        List<ck7.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (list = this.p) == null || list.size() <= 0) {
            return;
        }
        this.g.removeAllViews();
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            ck7.d dVar = this.p.get(i);
            if (dVar != null) {
                TextView textView = new TextView(this.a.getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                layoutParams.setMargins(0, 0, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be), 0);
                textView.setLayoutParams(layoutParams);
                textView.setText(n(dVar.b, 7));
                textView.setGravity(17);
                textView.setSingleLine(true);
                textView.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
                if (dVar.m) {
                    this.r = dVar.g;
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0312);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                } else {
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                }
                textView.setTag(dVar);
                textView.setOnClickListener(new a(this, this.p));
                this.g.addView(textView);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.q == null) {
            return;
        }
        TextView textView = this.i;
        textView.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f15e0) + (this.q.j / 100));
        if (!ni.isEmpty(this.q.d)) {
            TextView textView2 = this.h;
            textView2.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ce3) + this.q.d);
        }
        this.j.setText(this.q.f);
    }

    public final void q(ck7 ck7Var) {
        ck7.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, ck7Var) == null) || ck7Var == null) {
            return;
        }
        ck7.g gVar = ck7Var.a;
        if (gVar != null) {
            this.d.K(gVar.b, 12, false);
            this.e.setText(ck7Var.a.a);
            ck7.e eVar = ck7Var.a.c;
            if (eVar != null) {
                if (eVar.a > 0) {
                    this.k.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f88));
                }
                this.b.K(ck7Var.a.c.b, 21, false);
            }
        }
        ck7.b bVar = ck7Var.b;
        if (bVar == null || (aVar = bVar.b) == null) {
            return;
        }
        this.f.setText(aVar.d);
        this.c.setText(ck7Var.b.b.c);
    }
}
