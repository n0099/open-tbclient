package com.repackage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e68 extends tw5<b58> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ClickableHeaderImageView m;
    public ClickableHeaderImageView n;
    public ClickableHeaderImageView o;
    public TextView p;
    public View q;
    public int r;
    public TbPageContext<?> s;
    public View.OnClickListener t;
    public boolean u;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e68 a;

        public a(e68 e68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e68Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (!this.a.u) {
                TiebaStatic.log(new StatisticItem("c11595"));
            }
            if (view2.getTag() instanceof UserData) {
                UserData userData = (UserData) view2.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.s.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e68(TbPageContext<?> tbPageContext) {
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
        this.r = 3;
        this.s = tbPageContext;
        View k = k();
        u();
        this.q = k.findViewById(R.id.obfuscated_res_0x7f0903cb);
        this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091430);
        this.i = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090764);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090e4f);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0902d0);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) k.findViewById(R.id.obfuscated_res_0x7f090d3a);
        this.m = clickableHeaderImageView;
        clickableHeaderImageView.setRadius(oi.f(this.s.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a));
        this.m.setAutoChangeStyle(true);
        this.m.setOnClickListener(this.t);
        ClickableHeaderImageView clickableHeaderImageView2 = (ClickableHeaderImageView) k.findViewById(R.id.obfuscated_res_0x7f090d3b);
        this.n = clickableHeaderImageView2;
        clickableHeaderImageView2.setRadius(oi.f(this.s.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a));
        this.n.setAutoChangeStyle(true);
        this.n.setOnClickListener(this.t);
        ClickableHeaderImageView clickableHeaderImageView3 = (ClickableHeaderImageView) k.findViewById(R.id.obfuscated_res_0x7f090d3c);
        this.o = clickableHeaderImageView3;
        clickableHeaderImageView3.setRadius(oi.f(this.s.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a));
        this.o.setAutoChangeStyle(true);
        this.o.setOnClickListener(this.t);
        this.p = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09091d);
    }

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06be : invokeV.intValue;
    }

    @Override // com.repackage.tw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.r != i) {
                SkinManager.setBackgroundResource(k(), R.drawable.home_thread_card_item_bg);
                SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0108);
            }
            this.r = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t = new a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: v */
    public void l(b58 b58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b58Var) == null) {
            if (b58Var == null) {
                if (k() != null) {
                    k().setVisibility(8);
                    return;
                }
                return;
            }
            if (k() != null) {
                k().setVisibility(0);
            }
            this.u = b58Var.a;
            this.i.setText(b58Var.d);
            this.j.setText(b58Var.c);
            this.i.setVisibility(b58Var.b ? 0 : 4);
            this.j.setVisibility(b58Var.b ? 0 : 4);
            if (b58Var.a) {
                this.k.setText(this.s.getString(R.string.obfuscated_res_0x7f0f0a99));
            } else {
                this.k.setText(StringHelper.getUserDescByGender(b58Var.e));
            }
            int count = ListUtils.getCount(b58Var.f);
            if (count > 3) {
                this.p.setVisibility(0);
                this.p.setText(String.format(this.s.getString(R.string.obfuscated_res_0x7f0f02a5), Integer.valueOf(count)));
            } else {
                this.p.setVisibility(8);
            }
            if (count >= 3) {
                this.o.setVisibility(0);
                this.o.setTag(b58Var.f.get(2));
                if (b58Var.f.get(2).getGodUserData() != null && b58Var.f.get(2).getGodUserData().getType() == 2) {
                    this.o.setIsGod(true);
                } else {
                    this.o.setIsGod(false);
                }
                this.o.K(b58Var.f.get(2).getPortrait(), 12, false);
            } else {
                this.o.setVisibility(8);
            }
            if (count >= 2) {
                this.n.setVisibility(0);
                this.n.setTag(b58Var.f.get(1));
                if (b58Var.f.get(1).getGodUserData() != null && b58Var.f.get(1).getGodUserData().getType() == 2) {
                    this.n.setIsGod(true);
                } else {
                    this.n.setIsGod(false);
                }
                this.n.K(b58Var.f.get(1).getPortrait(), 12, false);
            } else {
                this.n.setVisibility(8);
            }
            if (count >= 1) {
                this.m.setVisibility(0);
                this.m.setTag(b58Var.f.get(0));
                if (b58Var.f.get(0).getGodUserData() != null && b58Var.f.get(0).getGodUserData().getType() == 2) {
                    this.m.setIsGod(true);
                } else {
                    this.m.setIsGod(false);
                }
                this.m.K(b58Var.f.get(0).getPortrait(), 12, false);
            } else {
                this.m.setVisibility(8);
            }
            m(this.s, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
