package com.repackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m28 extends rw5<a28> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public LinearLayout q;
    public LinearLayout r;
    public LinearLayout s;
    public LinearLayout t;
    public View u;
    public View v;
    public LinearLayout w;
    public UserData x;
    public int y;
    public int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m28(TbPageContext<?> tbPageContext) {
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
        this.y = 3;
        this.z = 0;
        View k = k();
        this.w = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0911c6);
        this.u = k.findViewById(R.id.obfuscated_res_0x7f092097);
        this.v = k.findViewById(R.id.obfuscated_res_0x7f0903cc);
        this.i = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09097a);
        this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09097d);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0906b3);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0906b4);
        this.m = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0902c5);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0902c6);
        this.o = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091fa6);
        this.p = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091fb8);
        this.q = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090975);
        this.r = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0906b2);
        this.s = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0902c4);
        this.t = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091f75);
        this.u.setVisibility(8);
        this.v.setVisibility(8);
    }

    @Override // com.repackage.rw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06ab : invokeV.intValue;
    }

    @Override // com.repackage.rw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.y == i) {
            return;
        }
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.v, R.color.CAM_X0204);
        int f = oi.f(getContext(), R.dimen.tbds16);
        TBSelector.makeShadowDrawable().setShape(1).setShadowSide(4096).setBgColor(R.color.CAM_X0205).setShapeRadius(0).setShadowLayer(R.color.cp_shadow_a, 0.2f, 0, oi.f(getContext(), R.dimen.tbds5), f).into(k());
        this.y = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || view2 == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f090975) {
            if (this.x == null) {
                return;
            }
            PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.b.getPageActivity(), false, this.x.getUserId(), this.x.getSex()).updateBjhUser(this.x.isBaijiahaoUser())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f0906b2) {
            if (this.x == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 5));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.b.getPageActivity(), true, this.x.getUserId(), this.x.getSex()).updateBjhUser(this.x.isBaijiahaoUser()).updateFollowNum(this.z, this.x.getPortrait())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f0902c4) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 7));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.b.getPageActivity(), this.x.getLike_bars(), this.x.getUserId(), this.x.getSex())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f75) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 8));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.b.getPageActivity(), this.x.getUserId(), this.x.getSex(), this.x.getPortrait())));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.rw5
    /* renamed from: s */
    public void l(a28 a28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, a28Var) == null) {
            this.x = a28Var.f;
            this.z = a28Var.b;
            this.i.setText(StringHelper.numFormatOverWanNa(a28Var.a));
            this.k.setText(Integer.toString(a28Var.b));
            this.m.setText(Integer.toString(a28Var.c));
            this.o.setText(StringHelper.longNumFormatOver9999wan(a28Var.d));
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.t.setOnClickListener(this);
            m(j(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
