package d.a.p0.u0.g1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.p0.h3.i;
import d.a.p0.h3.m;
import d.a.p0.u0.n2.h;
import java.util.Date;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62799a;

    /* renamed from: b  reason: collision with root package name */
    public View f62800b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f62801c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62802d;

    /* renamed from: e  reason: collision with root package name */
    public RoundLinearLayout f62803e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.r.s.a f62804f;

    /* renamed from: g  reason: collision with root package name */
    public i f62805g;

    /* renamed from: h  reason: collision with root package name */
    public ForumData f62806h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f62807i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f62808e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62808e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f62808e.f62802d) {
                    if (this.f62808e.f62804f == null || !this.f62808e.f62804f.isShowing()) {
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                    this.f62808e.f62804f.dismiss();
                } else if (view != this.f62808e.f62801c || this.f62808e.f62805g == null || StringUtils.isNull(this.f62808e.f62805g.l())) {
                } else {
                    h.b(this.f62808e.f62799a, this.f62808e.f62805g.f(), this.f62808e.f62805g.l());
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", this.f62808e.f62805g.b());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    this.f62808e.f62804f.dismiss();
                    StatisticItem statisticItem = new StatisticItem("common_click");
                    statisticItem.param("page_type", "a006");
                    statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
                    int i2 = 11;
                    if (this.f62808e.f62805g.k() != 1) {
                        if (this.f62808e.f62805g.k() == 2) {
                            i2 = 12;
                        } else if (this.f62808e.f62805g.k() == 3) {
                            i2 = 13;
                        }
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
                    statisticItem.param("obj_id", this.f62808e.f62805g.b());
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
                    statisticItem.param("obj_locate", 3);
                    if (this.f62808e.f62806h != null) {
                        statisticItem.param("fid", this.f62808e.f62806h.getId());
                        statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f62808e.f62806h.getFirst_class());
                        statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f62808e.f62806h.getSecond_class());
                    }
                    if (this.f62808e.f62805g.k() == 1) {
                        statisticItem.param("tid", this.f62808e.f62805g.h());
                        statisticItem.param("thread_type", this.f62808e.f62805g.i());
                    }
                    TiebaStatic.log(statisticItem);
                    d.a.p0.u0.l2.a.a(this.f62808e.f62805g.g());
                }
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62807i = new a(this);
        this.f62799a = tbPageContext;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f62799a.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
            this.f62800b = inflate;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) inflate.findViewById(R.id.round_layout);
            this.f62803e = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.f62800b.findViewById(R.id.frs_ad_img);
            this.f62801c = tbImageView;
            tbImageView.setOnClickListener(this.f62807i);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62801c.getLayoutParams();
            int k = l.k(this.f62799a.getPageActivity()) - (this.f62799a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3306452f);
            this.f62801c.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f62800b.findViewById(R.id.frs_ad_close);
            this.f62802d = textView;
            textView.setOnClickListener(this.f62807i);
            i iVar = this.f62805g;
            if (iVar != null) {
                this.f62801c.M(iVar.d(), 10, false);
            }
        }
    }

    public boolean h(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar)) == null) {
            if (mVar == null || mVar.getForum() == null || mVar.getBusinessPromot() == null) {
                return false;
            }
            this.f62806h = mVar.getForum();
            this.f62805g = mVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
            long l = d.a.o0.r.d0.b.j().l(str, 0L);
            if (l < 0 || !TimeHelper.isSameDay(new Date(l), new Date(System.currentTimeMillis()))) {
                d.a.o0.r.d0.b.j().w(str, System.currentTimeMillis());
                i();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g();
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f62799a.getPageActivity());
            this.f62804f = aVar;
            aVar.setCancelable(true);
            this.f62804f.setCanceledOnTouchOutside(true);
            this.f62804f.create(this.f62799a).show();
            View decorView = this.f62804f.getWindow().getDecorView();
            WindowManager.LayoutParams attributes = this.f62804f.getWindow().getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 17;
                this.f62804f.getWindow().setAttributes(attributes);
            }
            if (decorView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) decorView;
                viewGroup.removeAllViews();
                viewGroup.addView(this.f62800b);
            }
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 11;
            if (this.f62805g.k() != 1) {
                if (this.f62805g.k() == 2) {
                    i2 = 12;
                } else if (this.f62805g.k() == 3) {
                    i2 = 13;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f62805g.b());
            ForumData forumData = this.f62806h;
            if (forumData != null) {
                statisticItem.param("fid", forumData.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f62806h.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f62806h.getSecond_class());
            }
            if (this.f62805g.k() == 1) {
                statisticItem.param("tid", this.f62805g.h());
                statisticItem.param("thread_type", this.f62805g.i());
            }
            TiebaStatic.log(statisticItem);
            d.a.p0.u0.l2.a.b(this.f62805g.g());
        }
    }
}
