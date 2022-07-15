package com.repackage;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<an> c;
    public String d;
    public String e;
    public jy5 f;

    /* loaded from: classes7.dex */
    public class a extends jy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zj6 b;

        public a(zj6 zj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zj6Var;
        }

        @Override // com.repackage.jy5
        public void a(View view2, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) {
                super.a(view2, baseCardInfo);
                this.b.b();
            }
        }
    }

    public zj6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.a = tbPageContext;
        this.b = bdTypeListView;
        this.d = str;
        this.e = str2;
        this.c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ak6 ak6Var = new ak6(this.a, this.d, this.e);
            ak6Var.e0(this.f);
            this.c.add(ak6Var);
            bk6 bk6Var = new bk6(this.a, this.d);
            bk6Var.e0(this.f);
            this.c.add(bk6Var);
            this.c.add(new ek6(this.a, this.d));
            this.c.add(new dk6(this.a, this.d));
            List<an> list = this.c;
            TbPageContext tbPageContext = this.a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, f36.b, tbPageContext.getUniqueId(), this.d));
            ck6 ck6Var = new ck6(this.a, this.d);
            ck6Var.c0(this.f);
            this.c.add(ck6Var);
            List<an> list2 = this.c;
            TbPageContext tbPageContext2 = this.a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, a36.b, tbPageContext2.getUniqueId(), this.d));
            List<an> list3 = this.c;
            TbPageContext tbPageContext3 = this.a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, d36.b, tbPageContext3.getUniqueId(), this.d));
            TbPageContext tbPageContext4 = this.a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, od6.e, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.p0();
            frsUserRecommendAdapter.o0(this.d);
            this.c.add(frsUserRecommendAdapter);
            this.b.a(this.c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.b.getAdapter2() instanceof en)) {
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<nn> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
