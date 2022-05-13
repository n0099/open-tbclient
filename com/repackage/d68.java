package com.repackage;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d68 extends uw5<z48> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public BarImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public z48 r;
    public LikeModel s;
    public boolean t;
    public CustomMessageListener u;
    public CustomMessageListener v;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d68 d68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d68Var, Integer.valueOf(i)};
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
            this.a = d68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.t) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof zl8) {
                zl8 zl8Var = (zl8) data;
                if (zl8Var.a == this.a.r.f) {
                    if (zl8Var.b) {
                        this.a.r.i = true;
                        this.a.q.setVisibility(0);
                        this.a.z(true);
                        mi.M(this.a.c, R.string.obfuscated_res_0x7f0f02b1);
                    } else if (StringUtils.isNull(zl8Var.c)) {
                        mi.M(this.a.c, R.string.obfuscated_res_0x7f0f02ab);
                    } else {
                        mi.N(this.a.c, zl8Var.c);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d68 d68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d68Var, Integer.valueOf(i)};
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
            this.a = d68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.t) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof zl8) {
                zl8 zl8Var = (zl8) data;
                if (zl8Var.a == this.a.r.f) {
                    if (zl8Var.b) {
                        this.a.r.i = false;
                        this.a.q.setVisibility(0);
                        d68 d68Var = this.a;
                        d68Var.z(d68Var.r.i);
                        mi.M(this.a.c, R.string.obfuscated_res_0x7f0f14b2);
                        return;
                    }
                    mi.M(this.a.c, R.string.obfuscated_res_0x7f0f14b1);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d68(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new a(this, 2001437);
        this.v = new b(this, 2001438);
        w(k());
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b2 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.drawable.item_person_header_attention_bg_selector);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0108, 1);
                z48 z48Var = this.r;
                if (z48Var != null) {
                    z(z48Var.i);
                }
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (this.i == view2) {
                if (!this.t) {
                    TiebaStatic.log(new StatisticItem("c11595"));
                }
                this.b.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c).createNormalCfg(this.r.h, "")));
            } else if (this.q == view2) {
                TiebaStatic.log(new StatisticItem("c11596"));
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ViewHelper.skipToLoginActivity(this.c);
                } else if (li.isForumName(this.r.h)) {
                    z48 z48Var = this.r;
                    if (z48Var.i) {
                        return;
                    }
                    this.s.P(z48Var.h, String.valueOf(z48Var.f));
                }
            }
        }
    }

    public final void w(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f09056f);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09056b);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09056d);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090573);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09056c);
            this.n = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090571);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09056e);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090572);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090570);
            this.i.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.b.registerListener(this.u);
            this.b.registerListener(this.v);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: x */
    public void l(z48 z48Var) {
        Context context;
        int i;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, z48Var) == null) {
            if (z48Var == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            this.r = z48Var;
            this.t = z48Var.a;
            this.j.setVisibility(z48Var.c ? 0 : 4);
            this.k.setVisibility(z48Var.c ? 0 : 4);
            this.j.setText(z48Var.e);
            this.k.setText(z48Var.d);
            TextView textView = this.l;
            if (z48Var.a) {
                string = this.c.getString(R.string.obfuscated_res_0x7f0f0aa0);
            } else {
                if (z48Var.b == 2) {
                    context = this.c;
                    i = R.string.obfuscated_res_0x7f0f1173;
                } else {
                    context = this.c;
                    i = R.string.obfuscated_res_0x7f0f0821;
                }
                string = context.getString(i);
            }
            textView.setText(string);
            this.n.K(z48Var.g, 10, false);
            String str = z48Var.h;
            if (xd5.b(str) > 10) {
                str = xd5.k(str, 0, 10) + StringHelper.STRING_MORE;
            }
            this.o.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0e46), str));
            String numFormatOverWanNa = StringHelper.numFormatOverWanNa(z48Var.j);
            this.p.setText(z48Var.a ? String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0e45), numFormatOverWanNa, StringHelper.numFormatOverWanNa(z48Var.k)) : String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0e44), numFormatOverWanNa));
            if (!z48Var.i && !z48Var.a) {
                this.q.setVisibility(0);
                z(z48Var.i);
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public void y(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, likeModel) == null) {
            this.s = likeModel;
        }
    }

    public final void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.q.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0f87));
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0110);
                SkinManager.setBackgroundResource(this.q, R.color.transparent);
                this.q.setClickable(false);
                return;
            }
            this.q.setText(this.c.getString(R.string.obfuscated_res_0x7f0f062c));
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundResource(this.q, R.drawable.obfuscated_res_0x7f080fa2);
            this.q.setClickable(true);
        }
    }
}
