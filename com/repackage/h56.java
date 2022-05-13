package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.RankListViewController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public RankListViewController.RankListViewHolder c;
    public TextView d;
    public TextView e;
    public String f;
    public int g;
    public View.OnClickListener h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (TextUtils.isEmpty(this.a.f)) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0a2f);
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{this.a.f});
                if (this.a.g == 0) {
                    return;
                }
                if (this.a.g != 2) {
                    if (this.a.g == 1) {
                        StatisticItem statisticItem = new StatisticItem("c13669");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13658");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("obj_locate", 2);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    public h56(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.a = tbPageContext;
        this.b = view2;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view2.findViewById(R.id.obfuscated_res_0x7f092317));
        this.c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c87);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a01);
        this.e = textView;
        textView.setTextSize(0, mi.f(this.a.getPageActivity(), R.dimen.tbfontsize46));
        this.d.setOnClickListener(this.h);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.c.f(i);
            SkinManager.setBackgroundColor(this.c.itemView, R.color.CAM_X0207);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
        }
    }

    public void e(k56 k56Var) {
        j56 j56Var;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k56Var) == null) {
            if (k56Var != null && (j56Var = k56Var.c) != null && (metaData = j56Var.f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
                this.b.setVisibility(0);
                this.c.c(k56Var.c);
                this.c.e();
                this.f = k56Var.e;
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.g = i;
        }
    }
}
