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
/* loaded from: classes6.dex */
public class m76 extends a75<m46, o46> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext g;
    public final LinearLayout h;
    public RecyclerView i;
    public EMTextView j;
    public ImageView k;
    public ClassFitionForumItemAdapter l;
    public List<l46> m;
    public boolean n;

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m76 a;

        public a(m76 m76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m76Var;
        }

        @Override // com.repackage.m76.b
        public void a(List<l46> list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i == list.size() - 1) {
                    m76 m76Var = this.a;
                    m76Var.n = !m76Var.n;
                    this.a.l.update(this.a.r());
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(this.a.g.getString(R.string.obfuscated_res_0x7f0f06a3), list.get(i).b());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921678, hashMap));
                TiebaStatic.log(new StatisticItem("c14583").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", i + 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(List<l46> list, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m76(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, r76 r76Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, r76Var, enterForumModel};
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
        this.j = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092013);
        this.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902b0);
        this.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090491);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091a18);
        this.i = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.i.setLayoutManager(new GridLayoutManager(getContext(), 5));
        ClassFitionForumItemAdapter classFitionForumItemAdapter = new ClassFitionForumItemAdapter(tbPageContext, null);
        this.l = classFitionForumItemAdapter;
        this.i.setAdapter(classFitionForumItemAdapter);
        this.l.f(new a(this));
    }

    @Override // com.repackage.zj8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i)) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            vr4 d = vr4.d(this.h);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            vr4 d2 = vr4.d(this.j);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X07);
            d2.v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final List<l46> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.m);
            if (this.n) {
                if (this.m.size() >= 14) {
                    List<l46> subList = arrayList.subList(0, 14);
                    subList.add(new l46(this.g.getString(R.string.obfuscated_res_0x7f0f0627), R.drawable.obfuscated_res_0x7f0807dc));
                    return subList;
                }
                return arrayList;
            } else if (this.m.size() >= 9) {
                List<l46> subList2 = arrayList.subList(0, 9);
                subList2.add(new l46(this.g.getString(R.string.obfuscated_res_0x7f0f0acb), R.drawable.obfuscated_res_0x7f08082c));
                return subList2;
            } else {
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e75
    /* renamed from: s */
    public void i(m46 m46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, m46Var) == null) {
            super.i(m46Var);
            this.m = m46Var.k();
            this.l.update(r());
            this.j.setText(m46Var.getTitle());
            onChangeSkinType(d(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
