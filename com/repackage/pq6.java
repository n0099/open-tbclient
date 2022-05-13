package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsSchoolRecommendItemView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class pq6 extends vw5<cd6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView t;
    public q27 u;
    public FrsSchoolRecommendItemView v;
    public List<r27> w;
    public View.OnClickListener x;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pq6 a;

        public a(pq6 pq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pq6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e() == null) {
                return;
            }
            this.a.e().a(view2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pq6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.x = new a(this);
        HListView hListView = new HListView(getContext());
        this.t = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.t.setFooterDividersEnabled(false);
        this.t.setSelector(R.drawable.obfuscated_res_0x7f080d24);
        this.v = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0347, (ViewGroup) null), tbPageContext, bdUniqueId);
        q27 q27Var = new q27(getContext(), R.layout.obfuscated_res_0x7f0d0347, this.v);
        this.u = q27Var;
        q27Var.d(this.x);
        this.t.setAdapter((ListAdapter) this.u);
        this.q.addView(this.t);
        this.p.setVisibility(8);
        this.j.setTextSize(0, mi.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f9));
    }

    @Override // com.repackage.vw5, com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            super.m(tbPageContext, i);
            if (this.t == null || this.u == null) {
                return;
            }
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
            this.u.b(i);
        }
    }

    public final boolean v(List<r27> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (!ListUtils.isEmpty(this.w) && ListUtils.getCount(this.w) == ListUtils.getCount(list)) {
                for (int i = 0; i < ListUtils.getCount(this.w); i++) {
                    r27 r27Var = (r27) ListUtils.getItem(this.w, i);
                    r27 r27Var2 = (r27) ListUtils.getItem(list, i);
                    if ((r27Var instanceof fe6) && (r27Var2 instanceof fe6) && !((fe6) r27Var).a.getUserId().equals(((fe6) r27Var2).a.getUserId())) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.vw5
    /* renamed from: w */
    public void u(cd6 cd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cd6Var) == null) {
            super.l(cd6Var);
            if (cd6Var == null || ListUtils.isEmpty(cd6Var.getDataList())) {
                return;
            }
            if (StringUtils.isNull(cd6Var.mGroupTitle)) {
                this.j.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f1093));
            } else {
                this.j.setText(cd6Var.mGroupTitle);
            }
            if (v(cd6Var.getDataList())) {
                List<r27> dataList = cd6Var.getDataList();
                this.w = dataList;
                this.u.c(dataList);
                this.u.notifyDataSetChanged();
            }
        }
    }
}
