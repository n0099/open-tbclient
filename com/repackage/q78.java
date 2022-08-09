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
/* loaded from: classes7.dex */
public class q78 extends bz5<m68> {
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
    public m68 r;
    public LikeModel s;
    public boolean t;
    public CustomMessageListener u;
    public CustomMessageListener v;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(q78 q78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q78Var, Integer.valueOf(i)};
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
            this.a = q78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.t) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof an8) {
                an8 an8Var = (an8) data;
                if (an8Var.a == this.a.r.f) {
                    if (an8Var.b) {
                        this.a.r.i = true;
                        this.a.q.setVisibility(0);
                        this.a.y(true);
                        qi.N(this.a.c, R.string.obfuscated_res_0x7f0f02ba);
                    } else if (StringUtils.isNull(an8Var.c)) {
                        qi.N(this.a.c, R.string.obfuscated_res_0x7f0f02b4);
                    } else {
                        qi.O(this.a.c, an8Var.c);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(q78 q78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q78Var, Integer.valueOf(i)};
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
            this.a = q78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.t) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof an8) {
                an8 an8Var = (an8) data;
                if (an8Var.a == this.a.r.f) {
                    if (an8Var.b) {
                        this.a.r.i = false;
                        this.a.q.setVisibility(0);
                        q78 q78Var = this.a;
                        q78Var.y(q78Var.r.i);
                        qi.N(this.a.c, R.string.obfuscated_res_0x7f0f14ba);
                        return;
                    }
                    qi.N(this.a.c, R.string.obfuscated_res_0x7f0f14b9);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q78(TbPageContext tbPageContext) {
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
        v(h());
    }

    @Override // com.repackage.bz5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01ad : invokeV.intValue;
    }

    @Override // com.repackage.bz5
    public void j(TbPageContext tbPageContext, int i) {
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
                m68 m68Var = this.r;
                if (m68Var != null) {
                    y(m68Var.i);
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
                } else if (pi.isForumName(this.r.h)) {
                    m68 m68Var = this.r;
                    if (m68Var.i) {
                        return;
                    }
                    this.s.Q(m68Var.h, String.valueOf(m68Var.f));
                }
            }
        }
    }

    public final void v(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090565);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090561);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090563);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090569);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090562);
            this.n = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090567);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090564);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090568);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090566);
            this.i.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.b.registerListener(this.u);
            this.b.registerListener(this.v);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bz5
    /* renamed from: w */
    public void i(m68 m68Var) {
        Context context;
        int i;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, m68Var) == null) {
            if (m68Var == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            this.r = m68Var;
            this.t = m68Var.a;
            this.j.setVisibility(m68Var.c ? 0 : 4);
            this.k.setVisibility(m68Var.c ? 0 : 4);
            this.j.setText(m68Var.e);
            this.k.setText(m68Var.d);
            TextView textView = this.l;
            if (m68Var.a) {
                string = this.c.getString(R.string.obfuscated_res_0x7f0f0aa9);
            } else {
                if (m68Var.b == 2) {
                    context = this.c;
                    i = R.string.obfuscated_res_0x7f0f1170;
                } else {
                    context = this.c;
                    i = R.string.obfuscated_res_0x7f0f083d;
                }
                string = context.getString(i);
            }
            textView.setText(string);
            this.n.K(m68Var.g, 10, false);
            String str = m68Var.h;
            if (if5.b(str) > 10) {
                str = if5.k(str, 0, 10) + StringHelper.STRING_MORE;
            }
            this.o.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0e5e), str));
            String numFormatOverWanNa = StringHelper.numFormatOverWanNa(m68Var.j);
            this.p.setText(m68Var.a ? String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0e5d), numFormatOverWanNa, StringHelper.numFormatOverWanNa(m68Var.k)) : String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0e5c), numFormatOverWanNa));
            if (!m68Var.i && !m68Var.a) {
                this.q.setVisibility(0);
                y(m68Var.i);
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public void x(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, likeModel) == null) {
            this.s = likeModel;
        }
    }

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.q.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0fbc));
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0110);
                SkinManager.setBackgroundResource(this.q, R.color.transparent);
                this.q.setClickable(false);
                return;
            }
            this.q.setText(this.c.getString(R.string.obfuscated_res_0x7f0f063b));
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundResource(this.q, R.drawable.obfuscated_res_0x7f080f8f);
            this.q.setClickable(true);
        }
    }
}
