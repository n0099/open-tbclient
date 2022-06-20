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
public class h66 extends c75<z36, b46> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext f;
    public final LinearLayout g;
    public RecyclerView h;
    public EMTextView i;
    public ImageView j;
    public ClassFitionForumItemAdapter k;
    public List<y36> l;
    public boolean m;

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h66 a;

        public a(h66 h66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h66Var;
        }

        @Override // com.repackage.h66.b
        public void a(List<y36> list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i == list.size() - 1) {
                    h66 h66Var = this.a;
                    h66Var.m = !h66Var.m;
                    this.a.k.update(this.a.o());
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(this.a.f.getString(R.string.obfuscated_res_0x7f0f06a7), list.get(i).b());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921678, hashMap));
                TiebaStatic.log(new StatisticItem("c14583").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", i + 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(List<y36> list, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h66(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, m66 m66Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, m66Var, enterForumModel};
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
        this.m = false;
        this.f = tbPageContext;
        this.i = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092017);
        this.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902a3);
        this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090467);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091a12);
        this.h = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.h.setLayoutManager(new GridLayoutManager(getContext(), 5));
        ClassFitionForumItemAdapter classFitionForumItemAdapter = new ClassFitionForumItemAdapter(tbPageContext, null);
        this.k = classFitionForumItemAdapter;
        this.h.setAdapter(classFitionForumItemAdapter);
        this.k.f(new a(this));
    }

    public final List<y36> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.l);
            if (this.m) {
                if (this.l.size() >= 14) {
                    List<y36> subList = arrayList.subList(0, 14);
                    subList.add(new y36(this.f.getString(R.string.obfuscated_res_0x7f0f0628), R.drawable.obfuscated_res_0x7f0807c3));
                    return subList;
                }
                return arrayList;
            } else if (this.l.size() >= 9) {
                List<y36> subList2 = arrayList.subList(0, 9);
                subList2.add(new y36(this.f.getString(R.string.obfuscated_res_0x7f0f0ae3), R.drawable.obfuscated_res_0x7f080801));
                return subList2;
            } else {
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.qg8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            fr4 d = fr4.d(this.g);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            fr4 d2 = fr4.d(this.i);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X07);
            d2.v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.f75
    /* renamed from: p */
    public void f(z36 z36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, z36Var) == null) {
            super.f(z36Var);
            this.l = z36Var.j();
            this.k.update(o());
            this.i.setText(z36Var.getTitle());
            onChangeSkinType(b(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
