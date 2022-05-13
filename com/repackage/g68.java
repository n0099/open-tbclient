package com.repackage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g68 extends uw5<e58> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public View j;
    public View k;
    public TextView l;
    public HTypeListView m;
    public c48 n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e58 a;
        public final /* synthetic */ g68 b;

        public a(g68 g68Var, e58 e58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g68Var, e58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g68Var;
            this.a = e58Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.t(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g68(TbPageContext tbPageContext) {
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
        this.i = tbPageContext;
        View k = k();
        this.j = k;
        this.k = k.findViewById(R.id.obfuscated_res_0x7f090809);
        this.l = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f090cb2);
        HTypeListView hTypeListView = (HTypeListView) this.j.findViewById(R.id.obfuscated_res_0x7f090c9e);
        this.m = hTypeListView;
        this.n = new c48(this.i, hTypeListView);
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0193 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    public final void t(e58 e58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, e58Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                this.i.showToast(R.string.obfuscated_res_0x7f0f07a7);
            } else if (ViewHelper.checkUpIsLogin(this.i.getPageActivity())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.i.getPageActivity(), e58Var.c, e58Var.d, e58Var.e, e58Var.f)));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: u */
    public void l(e58 e58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, e58Var) == null) {
            if (e58Var != null && e58Var.isValid()) {
                a aVar = new a(this, e58Var);
                this.n.a(aVar);
                this.j.setOnClickListener(aVar);
                this.n.b(aVar);
                this.m.setData(v(e58Var.g));
                if (e58Var.a) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f07ab);
                } else if (e58Var.b) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f07aa);
                } else {
                    this.l.setText(R.string.obfuscated_res_0x7f0f07a9);
                }
                m(this.i, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.j.setVisibility(8);
        }
    }

    public final List<ro> v(List<ro> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= 0) {
                return list;
            }
            List<ro> arrayList = new ArrayList<>(list);
            int f = mi.f(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a);
            int f2 = mi.f(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
            if (count > 7) {
                arrayList = arrayList.subList(0, 7);
                f58 f58Var = new f58();
                f58Var.b = f;
                f58Var.a = f;
                ListUtils.add(arrayList, f58Var);
            }
            v08 v08Var = new v08(f2, f);
            ListUtils.add(arrayList, 0, v08Var);
            ListUtils.add(arrayList, v08Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
