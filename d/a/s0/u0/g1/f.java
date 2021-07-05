package d.a.s0.u0.g1;

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
import d.a.s0.h3.i;
import d.a.s0.h3.m;
import d.a.s0.u0.n2.h;
import java.util.Date;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66018a;

    /* renamed from: b  reason: collision with root package name */
    public View f66019b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f66020c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66021d;

    /* renamed from: e  reason: collision with root package name */
    public RoundLinearLayout f66022e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.r0.r.s.a f66023f;

    /* renamed from: g  reason: collision with root package name */
    public i f66024g;

    /* renamed from: h  reason: collision with root package name */
    public ForumData f66025h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f66026i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f66027e;

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
            this.f66027e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f66027e.f66021d) {
                    if (this.f66027e.f66023f == null || !this.f66027e.f66023f.isShowing()) {
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                    this.f66027e.f66023f.dismiss();
                } else if (view != this.f66027e.f66020c || this.f66027e.f66024g == null || StringUtils.isNull(this.f66027e.f66024g.l())) {
                } else {
                    h.b(this.f66027e.f66018a, this.f66027e.f66024g.f(), this.f66027e.f66024g.l());
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", this.f66027e.f66024g.b());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    this.f66027e.f66023f.dismiss();
                    StatisticItem statisticItem = new StatisticItem("common_click");
                    statisticItem.param("page_type", "a006");
                    statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
                    int i2 = 11;
                    if (this.f66027e.f66024g.k() != 1) {
                        if (this.f66027e.f66024g.k() == 2) {
                            i2 = 12;
                        } else if (this.f66027e.f66024g.k() == 3) {
                            i2 = 13;
                        }
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
                    statisticItem.param("obj_id", this.f66027e.f66024g.b());
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
                    statisticItem.param("obj_locate", 3);
                    if (this.f66027e.f66025h != null) {
                        statisticItem.param("fid", this.f66027e.f66025h.getId());
                        statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f66027e.f66025h.getFirst_class());
                        statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f66027e.f66025h.getSecond_class());
                    }
                    if (this.f66027e.f66024g.k() == 1) {
                        statisticItem.param("tid", this.f66027e.f66024g.h());
                        statisticItem.param("thread_type", this.f66027e.f66024g.i());
                    }
                    TiebaStatic.log(statisticItem);
                    d.a.s0.u0.l2.a.a(this.f66027e.f66024g.g());
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
        this.f66026i = new a(this);
        this.f66018a = tbPageContext;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f66018a.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
            this.f66019b = inflate;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) inflate.findViewById(R.id.round_layout);
            this.f66022e = roundLinearLayout;
            roundLinearLayout.setRoundCount(8);
            TbImageView tbImageView = (TbImageView) this.f66019b.findViewById(R.id.frs_ad_img);
            this.f66020c = tbImageView;
            tbImageView.setOnClickListener(this.f66026i);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f66020c.getLayoutParams();
            int k = l.k(this.f66018a.getPageActivity()) - (this.f66018a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            layoutParams.width = k;
            layoutParams.height = (int) (k * 1.3306452f);
            this.f66020c.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.f66019b.findViewById(R.id.frs_ad_close);
            this.f66021d = textView;
            textView.setOnClickListener(this.f66026i);
            i iVar = this.f66024g;
            if (iVar != null) {
                this.f66020c.M(iVar.d(), 10, false);
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
            this.f66025h = mVar.getForum();
            this.f66024g = mVar.getBusinessPromot();
            String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
            long l = d.a.r0.r.d0.b.j().l(str, 0L);
            if (l < 0 || !TimeHelper.isSameDay(new Date(l), new Date(System.currentTimeMillis()))) {
                d.a.r0.r.d0.b.j().w(str, System.currentTimeMillis());
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
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f66018a.getPageActivity());
            this.f66023f = aVar;
            aVar.setCancelable(true);
            this.f66023f.setCanceledOnTouchOutside(true);
            this.f66023f.create(this.f66018a).show();
            View decorView = this.f66023f.getWindow().getDecorView();
            WindowManager.LayoutParams attributes = this.f66023f.getWindow().getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 17;
                this.f66023f.getWindow().setAttributes(attributes);
            }
            if (decorView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) decorView;
                viewGroup.removeAllViews();
                viewGroup.addView(this.f66019b);
            }
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 11;
            if (this.f66024g.k() != 1) {
                if (this.f66024g.k() == 2) {
                    i2 = 12;
                } else if (this.f66024g.k() == 3) {
                    i2 = 13;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f66024g.b());
            ForumData forumData = this.f66025h;
            if (forumData != null) {
                statisticItem.param("fid", forumData.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f66025h.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f66025h.getSecond_class());
            }
            if (this.f66024g.k() == 1) {
                statisticItem.param("tid", this.f66024g.h());
                statisticItem.param("thread_type", this.f66024g.i());
            }
            TiebaStatic.log(statisticItem);
            d.a.s0.u0.l2.a.b(this.f66024g.g());
        }
    }
}
