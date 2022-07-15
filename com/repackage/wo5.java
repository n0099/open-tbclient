package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
/* loaded from: classes7.dex */
public class wo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Context b;
    public View c;
    public LinearLayout d;
    public LinearLayout e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public LinearLayout i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public View m;
    public LinearLayout n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public View r;
    public View s;
    public List<FunctionListInfo> t;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunctionListInfo a;
        public final /* synthetic */ wo5 b;

        public a(wo5 wo5Var, FunctionListInfo functionListInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo5Var, functionListInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wo5Var;
            this.a = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.k(1, this.a.url);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wo5 a;

        public b(wo5 wo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wo5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.b);
                    return;
                }
                wo5 wo5Var = this.a;
                wo5Var.n("prefer_key_history", wo5Var.m);
                this.a.b.startActivity(new Intent(this.a.b, AlaRecentHistoryActivity.class));
                TiebaStatic.log("c12648");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunctionListInfo a;
        public final /* synthetic */ wo5 b;

        public c(wo5 wo5Var, FunctionListInfo functionListInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo5Var, functionListInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wo5Var;
            this.a = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.k(3, this.a.url);
                wo5 wo5Var = this.b;
                wo5Var.n("prefer_key_activity", wo5Var.r);
            }
        }
    }

    public wo5(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = tbPageContext.getPageActivity();
        j();
    }

    public void f(List<FunctionListInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.t = list;
            for (FunctionListInfo functionListInfo : list) {
                if (functionListInfo != null) {
                    int intValue = functionListInfo.id.intValue();
                    if (intValue == 1) {
                        this.e.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.g.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.h.setVisibility(0);
                            this.h.setText(functionListInfo.describe);
                        }
                        this.e.setOnClickListener(new a(this, functionListInfo));
                    } else if (intValue == 2) {
                        this.i.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.k.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.l.setVisibility(0);
                            this.l.setText(functionListInfo.describe);
                        }
                        i(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.m);
                        this.i.setOnClickListener(new b(this));
                    } else if (intValue == 3) {
                        this.n.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.p.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.q.setVisibility(0);
                            this.q.setText(functionListInfo.describe);
                        }
                        i(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.r);
                        this.n.setOnClickListener(new c(this, functionListInfo));
                    }
                }
            }
            TiebaStatic.log("c12647");
        }
    }

    public final long g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? xt4.k().m(str, 0L) : invokeL.longValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public final void i(int i, long j, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), view2}) == null) {
            if (g(i != 2 ? i != 3 ? null : "prefer_key_activity" : "prefer_key_history") < j) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d07a6, (ViewGroup) null);
            this.c = inflate;
            this.d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091dff);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091e05);
            this.e = linearLayout;
            linearLayout.setVisibility(8);
            this.f = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091e07);
            this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091e08);
            this.h = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091e06);
            LinearLayout linearLayout2 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091e00);
            this.i = linearLayout2;
            linearLayout2.setVisibility(8);
            this.j = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091e02);
            this.k = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091e04);
            this.l = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091e01);
            this.m = this.c.findViewById(R.id.obfuscated_res_0x7f091e03);
            LinearLayout linearLayout3 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091df9);
            this.n = linearLayout3;
            linearLayout3.setVisibility(8);
            this.o = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091dfb);
            this.p = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091dfd);
            this.q = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091dfa);
            this.r = this.c.findViewById(R.id.obfuscated_res_0x7f091dfc);
            this.s = this.c.findViewById(R.id.obfuscated_res_0x7f091dfe);
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void k(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            TiebaStatic.log(new StatisticItem("c12215"));
            rl4.o(this.b, str);
            if (3 == i) {
                TiebaStatic.log("c12649");
            } else if (1 == i) {
                TiebaStatic.log("c12215");
            }
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setBackgroundResource(this.d, R.color.CAM_X0201);
        SkinManager.setImageResource(this.f, R.drawable.live_portal_rank);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0109);
        SkinManager.setImageResource(this.j, R.drawable.live_import_history);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setImageResource(this.o, R.drawable.live_import_activity);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public final void n(String str, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, view2) == null) {
            xt4.k().x(str, System.currentTimeMillis() / 1000);
            view2.setVisibility(8);
        }
    }
}
