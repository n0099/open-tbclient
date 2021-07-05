package d.a.s0.l0.i;

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
import d.a.c.e.p.l;
import d.a.s0.l0.i.c.c;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62895a;

    /* renamed from: b  reason: collision with root package name */
    public View f62896b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f62897c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62898d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62899e;

    /* renamed from: f  reason: collision with root package name */
    public String f62900f;

    /* renamed from: g  reason: collision with root package name */
    public int f62901g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f62902h;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62903e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62903e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (TextUtils.isEmpty(this.f62903e.f62900f)) {
                    this.f62903e.f62895a.showToast(R.string.load_error_retry);
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f62903e.f62895a, new String[]{this.f62903e.f62900f});
                if (this.f62903e.f62901g == 0) {
                    return;
                }
                if (this.f62903e.f62901g != 2) {
                    if (this.f62903e.f62901g == 1) {
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

    public b(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62902h = new a(this);
        this.f62895a = tbPageContext;
        this.f62896b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f62897c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.f62898d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f62899e = textView;
        textView.setTextSize(0, l.g(this.f62895a.getPageActivity(), R.dimen.tbfontsize46));
        this.f62898d.setOnClickListener(this.f62902h);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f62897c.f(i2);
            SkinManager.setBackgroundColor(this.f62897c.itemView, R.color.CAM_X0207);
            SkinManager.setViewTextColor(this.f62898d, R.color.CAM_X0302);
        }
    }

    public void e(c cVar) {
        d.a.s0.l0.i.c.b bVar;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (bVar = cVar.f62920c) != null && (metaData = bVar.f62915f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
                this.f62896b.setVisibility(0);
                this.f62897c.c(cVar.f62920c);
                this.f62897c.e();
                this.f62900f = cVar.f62922e;
                return;
            }
            this.f62896b.setVisibility(8);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f62901g = i2;
        }
    }
}
