package com.repackage;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class dr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NEGFeedBackView a;
    public TbPageContext b;
    public ViewGroup c;
    public BdUniqueId d;
    public NEGFeedBackView.b e;

    /* loaded from: classes5.dex */
    public class a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(dr6 dr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, lp4 lp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, lp4Var) == null) || arrayList == null || lp4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", lp4Var.c()).param("tid", lp4Var.f()).param("nid", lp4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", lp4Var.l).param("weight", lp4Var.k).param("ab_tag", lp4Var.p).param("extra", lp4Var.m).param("card_type", lp4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, lp4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(lp4 lp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(lp4 lp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lp4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", lp4Var.c()).param("tid", lp4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public dr6(TbPageContext tbPageContext, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.b = tbPageContext;
        this.c = viewGroup;
    }

    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || this.b == null || this.c == null) {
            return;
        }
        int i = 0;
        boolean z = (threadData.getAuthor() == null || threadData.getAuthor().getUserId() == null || !threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (threadData.isSmartFrsThread() && threadData.getFeedBackReasonMap() != null && !z) {
            if (this.a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.b);
                this.a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.d);
                this.a.setId(R.id.obfuscated_res_0x7f091533);
                this.a.setDefaultReasonArray(new String[]{this.b.getString(R.string.obfuscated_res_0x7f0f02c1), "", ""});
                this.a.setEventCallback(this.e);
                this.a.m(this.c, oi.f(this.b.getPageActivity(), R.dimen.tbds120), 0);
                this.a.r();
            }
            if (this.a.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
            lp4 lp4Var = new lp4();
            lp4Var.o(threadData.getTid());
            lp4Var.k(threadData.getFid());
            lp4Var.n(threadData.getNid());
            lp4Var.j(threadData.getFeedBackReasonMap());
            lp4Var.g = threadData.feedBackExtraMap;
            this.a.setData(lp4Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.a.setVisibility(8);
            }
            i = oi.f(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
        }
        if (this.c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.rightMargin = i;
            this.c.setLayoutParams(layoutParams);
        }
        if (this.c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams2.rightMargin = i;
            this.c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NEGFeedBackView nEGFeedBackView = this.a;
            return nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nEGFeedBackView = this.a) == null) {
            return;
        }
        nEGFeedBackView.r();
    }

    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.d = bdUniqueId;
        }
    }
}
