package d.a.q0.u0.r2;

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
import d.a.d.e.p.l;
import d.a.q0.u0.x;
import d.a.q0.u0.z0;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends d.a.q0.a0.c<x> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<d.a.q0.f1.b.c> A;
    public View.OnClickListener B;
    public HListView x;
    public d.a.q0.f1.b.b y;
    public FrsSchoolRecommendItemView z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64427e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64427e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64427e.h() == null) {
                return;
            }
            this.f64427e.h().a(view, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = new a(this);
        HListView hListView = new HListView(b());
        this.x = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.x.setFooterDividersEnabled(false);
        this.x.setSelector(R.drawable.list_selector_transparent);
        this.z = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        d.a.q0.f1.b.b bVar = new d.a.q0.f1.b.b(b(), R.layout.frs_school_recommend_user, this.z);
        this.y = bVar;
        bVar.d(this.B);
        this.x.setAdapter((ListAdapter) this.y);
        this.u.addView(this.x);
        this.t.setVisibility(8);
        this.n.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // d.a.q0.a0.c, d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            super.m(tbPageContext, i2);
            if (this.x == null || this.y == null) {
                return;
            }
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            this.y.b(i2);
        }
    }

    public final boolean w(List<d.a.q0.f1.b.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (!ListUtils.isEmpty(this.A) && ListUtils.getCount(this.A) == ListUtils.getCount(list)) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.A); i2++) {
                    d.a.q0.f1.b.c cVar = (d.a.q0.f1.b.c) ListUtils.getItem(this.A, i2);
                    d.a.q0.f1.b.c cVar2 = (d.a.q0.f1.b.c) ListUtils.getItem(list, i2);
                    if ((cVar instanceof z0) && (cVar2 instanceof z0) && !((z0) cVar).f64665a.getUserId().equals(((z0) cVar2).f64665a.getUserId())) {
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
    @Override // d.a.q0.a0.b
    /* renamed from: x */
    public void l(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xVar) == null) {
            super.t(xVar);
            if (xVar == null || ListUtils.isEmpty(xVar.getDataList())) {
                return;
            }
            if (StringUtils.isNull(xVar.mGroupTitle)) {
                this.n.setText(b().getResources().getString(R.string.school_recommend));
            } else {
                this.n.setText(xVar.mGroupTitle);
            }
            if (w(xVar.getDataList())) {
                List<d.a.q0.f1.b.c> dataList = xVar.getDataList();
                this.A = dataList;
                this.y.c(dataList);
                this.y.notifyDataSetChanged();
            }
        }
    }
}
