package com.repackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.adapter.ClassFitionForumItemAdapter;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class v66 extends q75<n46, p46> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext g;
    public final LinearLayout h;
    public RecyclerView i;
    public EMTextView j;
    public ImageView k;
    public ClassFitionForumItemAdapter l;
    public List<m46> m;
    public boolean n;

    /* loaded from: classes7.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v66 a;

        public a(v66 v66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v66Var;
        }

        @Override // com.repackage.v66.b
        public void a(List<m46> list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i == list.size() - 1) {
                    v66 v66Var = this.a;
                    v66Var.n = !v66Var.n;
                    this.a.l.update(this.a.r());
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(this.a.g.getString(R.string.obfuscated_res_0x7f0f06ac), list.get(i).b());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921678, hashMap));
                TiebaStatic.log(new StatisticItem("c14583").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", i + 1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(List<m46> list, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v66(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, a76 a76Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, a76Var, enterForumModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = false;
        this.g = tbPageContext;
        this.j = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092071);
        this.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902a6);
        this.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09048c);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091a6a);
        this.i = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.i.setLayoutManager(new GridLayoutManager(getContext(), 5));
        ClassFitionForumItemAdapter classFitionForumItemAdapter = new ClassFitionForumItemAdapter(tbPageContext, null);
        this.l = classFitionForumItemAdapter;
        this.i.setAdapter(classFitionForumItemAdapter);
        this.l.f(new a(this));
    }

    @Override // com.repackage.wi8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i)) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            gs4 d = gs4.d(this.h);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            gs4 d2 = gs4.d(this.j);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X07);
            d2.v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final List<m46> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.m);
            if (this.n) {
                if (this.m.size() >= 14) {
                    List<m46> subList = arrayList.subList(0, 14);
                    subList.add(new m46(this.g.getString(R.string.obfuscated_res_0x7f0f062d), R.drawable.obfuscated_res_0x7f0807c7));
                    return subList;
                }
                return arrayList;
            } else if (this.m.size() >= 9) {
                List<m46> subList2 = arrayList.subList(0, 9);
                subList2.add(new m46(this.g.getString(R.string.obfuscated_res_0x7f0f0ad9), R.drawable.obfuscated_res_0x7f08081c));
                return subList2;
            } else {
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u75
    /* renamed from: s */
    public void i(n46 n46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, n46Var) == null) {
            super.i(n46Var);
            this.m = n46Var.k();
            this.l.update(r());
            this.j.setText(n46Var.getTitle());
            onChangeSkinType(d(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
