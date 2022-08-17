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
public class cs6 extends cz5<hf6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView t;
    public l47 u;
    public FrsSchoolRecommendItemView v;
    public List<m47> w;
    public View.OnClickListener x;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs6 a;

        public a(cs6 cs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cs6Var;
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
    public cs6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.t.setSelector(R.drawable.obfuscated_res_0x7f080cc3);
        this.v = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0342, (ViewGroup) null), tbPageContext, bdUniqueId);
        l47 l47Var = new l47(getContext(), R.layout.obfuscated_res_0x7f0d0342, this.v);
        this.u = l47Var;
        l47Var.d(this.x);
        this.t.setAdapter((ListAdapter) this.u);
        this.q.addView(this.t);
        this.p.setVisibility(8);
        this.j.setTextSize(0, qi.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f9));
    }

    @Override // com.repackage.cz5, com.repackage.bz5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            super.j(tbPageContext, i);
            if (this.t == null || this.u == null) {
                return;
            }
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
            this.u.b(i);
        }
    }

    public final boolean u(List<m47> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (!ListUtils.isEmpty(this.w) && ListUtils.getCount(this.w) == ListUtils.getCount(list)) {
                for (int i = 0; i < ListUtils.getCount(this.w); i++) {
                    m47 m47Var = (m47) ListUtils.getItem(this.w, i);
                    m47 m47Var2 = (m47) ListUtils.getItem(list, i);
                    if ((m47Var instanceof lg6) && (m47Var2 instanceof lg6) && !((lg6) m47Var).a.getUserId().equals(((lg6) m47Var2).a.getUserId())) {
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
    @Override // com.repackage.cz5
    /* renamed from: v */
    public void t(hf6 hf6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hf6Var) == null) {
            super.i(hf6Var);
            if (hf6Var == null || ListUtils.isEmpty(hf6Var.getDataList())) {
                return;
            }
            if (StringUtils.isNull(hf6Var.mGroupTitle)) {
                this.j.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f109b));
            } else {
                this.j.setText(hf6Var.mGroupTitle);
            }
            if (u(hf6Var.getDataList())) {
                List<m47> dataList = hf6Var.getDataList();
                this.w = dataList;
                this.u.c(dataList);
                this.u.notifyDataSetChanged();
            }
        }
    }
}
