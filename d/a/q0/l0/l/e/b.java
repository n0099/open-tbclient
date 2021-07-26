package d.a.q0.l0.l.e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.l0.l.d.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f60424a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f60425b;

    /* renamed from: c  reason: collision with root package name */
    public View f60426c;

    /* renamed from: d  reason: collision with root package name */
    public RoundRelativeLayout f60427d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f60428e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f60429f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f60430g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f60431h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f60432i;
    public TextView j;
    public ImageView k;
    public HotUserRankImageOverlayView l;
    public ImageView m;
    public int n;
    public String o;
    public String p;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60433e;

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
            this.f60433e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f60433e.f60425b.getPageActivity());
                hotUserRankActivityConfig.setCategory(this.f60433e.o);
                this.f60433e.f60425b.sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13655");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f60433e.p);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public b(TbPageContext<?> tbPageContext) {
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
        this.f60424a = 3;
        this.f60425b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.f60426c = inflate;
        this.f60427d = (RoundRelativeLayout) inflate.findViewById(R.id.view_container);
        this.f60428e = (ImageView) this.f60426c.findViewById(R.id.ic_red_background);
        this.f60429f = (ImageView) this.f60426c.findViewById(R.id.ic_red_pic);
        this.f60430g = (TbImageView) this.f60426c.findViewById(R.id.rank_icon);
        this.f60431h = (ImageView) this.f60426c.findViewById(R.id.rank_icon_default);
        this.f60432i = (TextView) this.f60426c.findViewById(R.id.forum_text);
        this.j = (TextView) this.f60426c.findViewById(R.id.no_1_user);
        this.l = (HotUserRankImageOverlayView) this.f60426c.findViewById(R.id.image_overlay_view);
        this.k = (ImageView) this.f60426c.findViewById(R.id.iv_crown);
        this.m = (ImageView) this.f60426c.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.l.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.CAM_X0501, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.l.setStrokeStyle(1);
        this.l.setLoadImageType(12);
        this.l.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.f60427d.setOnClickListener(new a(this));
        int g2 = l.g(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.n = g2;
        this.f60427d.setRoundLayoutRadius(new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60426c : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f60424a == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.f60424a = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.f60427d, R.color.CAM_X0206);
        if (this.f60431h.getVisibility() == 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f60431h, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f60428e, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setImageResource(this.f60429f, R.drawable.pic_list_redword);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.f60432i, R.color.CAM_X0311);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0311);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mask_first24, null);
        this.l.d();
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null) {
            return;
        }
        String str = cVar.f60405b;
        this.o = str;
        if (TextUtils.isEmpty(str)) {
            this.o = "";
        }
        TextView textView = this.f60432i;
        textView.setText(this.o + "榜");
        List<ShortUserInfo> list = cVar.f60404a;
        if (list != null && list.size() > 0) {
            TextView textView2 = this.j;
            textView2.setText("NO.1 " + cVar.f60404a.get(0).user_name);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (ShortUserInfo shortUserInfo : cVar.f60404a) {
                if (i2 > 2) {
                    break;
                }
                i2++;
                arrayList.add(shortUserInfo.portrait);
            }
            this.l.setData(arrayList);
            if (!TextUtils.isEmpty(cVar.f60406c)) {
                this.f60430g.setVisibility(0);
                this.f60431h.setVisibility(8);
                this.f60430g.M(cVar.f60406c, 12, false);
            } else {
                this.f60431h.setVisibility(0);
                this.f60430g.setVisibility(8);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f60431h, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
        e();
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.p = str;
        }
    }
}
