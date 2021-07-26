package d.a.q0.l0.i;

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
import d.a.d.e.p.l;
import d.a.q0.l0.i.c.c;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60272a;

    /* renamed from: b  reason: collision with root package name */
    public View f60273b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f60274c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60275d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60276e;

    /* renamed from: f  reason: collision with root package name */
    public String f60277f;

    /* renamed from: g  reason: collision with root package name */
    public int f60278g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f60279h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60280e;

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
            this.f60280e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (TextUtils.isEmpty(this.f60280e.f60277f)) {
                    this.f60280e.f60272a.showToast(R.string.load_error_retry);
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f60280e.f60272a, new String[]{this.f60280e.f60277f});
                if (this.f60280e.f60278g == 0) {
                    return;
                }
                if (this.f60280e.f60278g != 2) {
                    if (this.f60280e.f60278g == 1) {
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
        this.f60279h = new a(this);
        this.f60272a = tbPageContext;
        this.f60273b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f60274c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.f60275d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f60276e = textView;
        textView.setTextSize(0, l.g(this.f60272a.getPageActivity(), R.dimen.tbfontsize46));
        this.f60275d.setOnClickListener(this.f60279h);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f60274c.f(i2);
            SkinManager.setBackgroundColor(this.f60274c.itemView, R.color.CAM_X0207);
            SkinManager.setViewTextColor(this.f60275d, R.color.CAM_X0302);
        }
    }

    public void e(c cVar) {
        d.a.q0.l0.i.c.b bVar;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (bVar = cVar.f60297c) != null && (metaData = bVar.f60292f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
                this.f60273b.setVisibility(0);
                this.f60274c.c(cVar.f60297c);
                this.f60274c.e();
                this.f60277f = cVar.f60299e;
                return;
            }
            this.f60273b.setVisibility(8);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f60278g = i2;
        }
    }
}
