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
public class h56 extends n65<z26, b36> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext f;
    public final LinearLayout g;
    public RecyclerView h;
    public EMTextView i;
    public ImageView j;
    public ClassFitionForumItemAdapter k;
    public List<y26> l;
    public boolean m;

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h56 a;

        public a(h56 h56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h56Var;
        }

        @Override // com.repackage.h56.b
        public void a(List<y26> list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i == list.size() - 1) {
                    h56 h56Var = this.a;
                    h56Var.m = !h56Var.m;
                    this.a.k.update(this.a.o());
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(this.a.f.getString(R.string.obfuscated_res_0x7f0f06b3), list.get(i).b());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921678, hashMap));
                TiebaStatic.log(new StatisticItem("c14583").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", i + 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(List<y26> list, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h56(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, m56 m56Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, m56Var, enterForumModel};
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
        this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090487);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091a1b);
        this.h = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.h.setLayoutManager(new GridLayoutManager(getContext(), 5));
        ClassFitionForumItemAdapter classFitionForumItemAdapter = new ClassFitionForumItemAdapter(tbPageContext, null);
        this.k = classFitionForumItemAdapter;
        this.h.setAdapter(classFitionForumItemAdapter);
        this.k.f(new a(this));
    }

    public final List<y26> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.l);
            if (this.m) {
                if (this.l.size() >= 14) {
                    List<y26> subList = arrayList.subList(0, 14);
                    subList.add(new y26(this.f.getString(R.string.obfuscated_res_0x7f0f0634), R.drawable.obfuscated_res_0x7f0807c7));
                    return subList;
                }
                return arrayList;
            } else if (this.l.size() >= 9) {
                List<y26> subList2 = arrayList.subList(0, 9);
                subList2.add(new y26(this.f.getString(R.string.obfuscated_res_0x7f0f0adf), R.drawable.obfuscated_res_0x7f08081c));
                return subList2;
            } else {
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.xf8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            wq4 d = wq4.d(this.g);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            wq4 d2 = wq4.d(this.i);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X07);
            d2.v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.r65
    /* renamed from: p */
    public void f(z26 z26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, z26Var) == null) {
            super.f(z26Var);
            this.l = z26Var.k();
            this.k.update(o());
            this.i.setText(z26Var.getTitle());
            onChangeSkinType(b(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
