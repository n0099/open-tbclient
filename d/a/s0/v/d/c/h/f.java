package d.a.s0.v.d.c.h;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class f implements d.a.s0.v.d.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public static final float t;
    public static final int u;
    public static final int v;
    public static final float[] w;
    public static final float[] x;
    public static final float[] y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67658a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f67659b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f67660c;

    /* renamed from: d  reason: collision with root package name */
    public View f67661d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f67662e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f67663f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f67664g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f67665h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f67666i;
    public TbImageView j;
    public TbImageView k;
    public d.a.s0.v.d.a.a l;
    public SdkLiveInfoData m;
    public String n;
    public int o;
    public int p;
    public int q;
    public View.OnClickListener r;

    /* loaded from: classes9.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f67667a;

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
            this.f67667a = fVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                f fVar = this.f67667a;
                this.f67667a.j.setLayoutParams(new RelativeLayout.LayoutParams(fVar.i(fVar.j.getLoadedHeight(), this.f67667a.j.getLoadedWidth()), f.s));
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f67668a;

        public b(f fVar) {
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
            this.f67668a = fVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                f fVar = this.f67668a;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(fVar.i(fVar.k.getLoadedHeight(), this.f67668a.k.getLoadedWidth()), f.s);
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.f67668a.f67660c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                this.f67668a.k.setLayoutParams(layoutParams);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f67669e;

        public c(f fVar) {
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
            this.f67669e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean d2 = d.a.s0.v.d.c.c.d(this.f67669e.m);
                String str4 = TiebaStatic.YYValues.YY_LIVE;
                if (d2) {
                    if (this.f67669e.l.f67429f) {
                        str3 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + this.f67669e.p;
                    } else {
                        str3 = YYLiveUtil.SOURCE_HOME_LIVE_TAB_CARD_ + this.f67669e.p;
                    }
                    d.a.s0.v.d.c.c.j(this.f67669e.f67660c, this.f67669e.m, str3);
                    if (!d.a.s0.v.d.c.c.d(this.f67669e.m) || this.f67669e.l == null) {
                        return;
                    }
                    if (this.f67669e.l.f67429f) {
                        this.f67669e.k();
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13557");
                    statisticItem.param("obj_locate", this.f67669e.l.f67432i);
                    statisticItem.param("obj_param1", this.f67669e.m.liveId);
                    if (this.f67669e.m.liveInfo != null) {
                        int a2 = d.a.s0.v.d.c.c.a(this.f67669e.m.liveInfo);
                        if (this.f67669e.m.liveInfo.yyExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem, d.a.s0.v.d.c.c.k(this.f67669e.m.liveInfo.yyExt));
                        } else {
                            str4 = "";
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str4);
                    }
                    statisticItem.param("nid", this.f67669e.m.nid);
                    statisticItem.param(TiebaStatic.Params.LOGID, this.f67669e.m.logid);
                    TiebaStatic.log(statisticItem);
                } else if (d.a.s0.v.d.c.c.c(this.f67669e.m)) {
                    if (103 == this.f67669e.p) {
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                        statisticItem2.param("obj_locate", 3);
                        statisticItem2.param("obj_param1", this.f67669e.m.liveId);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        TiebaStatic.log(statisticItem2);
                        str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
                    } else {
                        str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    d.a.s0.v.d.c.c.f(this.f67669e.f67660c, this.f67669e.m, str2);
                } else {
                    d.a.s0.v.d.c.c.h(this.f67669e.f67660c.getPageActivity(), this.f67669e.m);
                    if (this.f67669e.l == null || this.f67669e.m == null) {
                        return;
                    }
                    if (this.f67669e.l.f67429f) {
                        StatisticItem statisticItem3 = new StatisticItem("c13611");
                        statisticItem3.param("obj_param1", this.f67669e.m.liveId);
                        statisticItem3.param("fid", this.f67669e.l.f67430g);
                        statisticItem3.param("fname", this.f67669e.l.f67431h);
                        statisticItem3.param("obj_locate", this.f67669e.l.f67432i);
                        if (this.f67669e.m != null && this.f67669e.m.uiTransParam != null) {
                            statisticItem3.param("ab_tag", this.f67669e.m.uiTransParam.abTag);
                            statisticItem3.param(TiebaStatic.Params.STAR_ID, this.f67669e.m.uiTransParam.starId);
                            statisticItem3.param("extra", this.f67669e.m.uiTransParam.extra);
                            statisticItem3.param("source_from", this.f67669e.m.uiTransParam.sourceFrom);
                        }
                        TiebaStatic.log(statisticItem3);
                        this.f67669e.k();
                        return;
                    }
                    StatisticItem statisticItem4 = new StatisticItem("c13557");
                    if (101 == this.f67669e.p) {
                        str = "推荐";
                    } else if (102 == this.f67669e.p) {
                        str = "颜值";
                    } else {
                        str = 103 == this.f67669e.p ? "交友" : "";
                    }
                    if (this.f67669e.m.liveInfo != null) {
                        int a3 = d.a.s0.v.d.c.c.a(this.f67669e.m.liveInfo);
                        if (this.f67669e.m.liveInfo.yyExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem4, d.a.s0.v.d.c.c.k(this.f67669e.m.liveInfo.yyExt));
                        } else {
                            str4 = "";
                        }
                        statisticItem4.param(TiebaStatic.Params.OBJ_PARAM2, a3);
                        statisticItem4.param(TiebaStatic.Params.OBJ_PARAM3, str4);
                    }
                    statisticItem4.param("obj_param1", this.f67669e.m.liveId);
                    statisticItem4.param(TiebaStatic.Params.ENTRY_NAME, str);
                    statisticItem4.param("nid", this.f67669e.m.nid);
                    statisticItem4.param(TiebaStatic.Params.LOGID, this.f67669e.m.logid);
                    TiebaStatic.log(statisticItem4);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2144314073, "Ld/a/s0/v/d/c/h/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2144314073, "Ld/a/s0/v/d/c/h/f;");
                return;
            }
        }
        s = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        t = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        u = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        v = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        float f2 = t;
        w = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f2, f2, f2, f2};
        x = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2, f2};
        y = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f2, f2, 0.0f, 0.0f};
    }

    public f(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67658a = 3;
        this.f67659b = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = 0;
        this.r = new c(this);
        this.f67660c = tbPageContext;
        this.p = i2;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.f67661d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f67662e = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.f67662e.setDrawBorder(true);
        this.f67662e.setPlaceHolder(2);
        this.f67662e.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f67663f = (EMTextView) this.f67661d.findViewById(R.id.tvLiveCount);
        this.f67664g = (TextView) this.f67661d.findViewById(R.id.tvUserName);
        this.f67666i = (LinearLayout) this.f67661d.findViewById(R.id.tvInfoWrapper);
        this.j = (TbImageView) this.f67661d.findViewById(R.id.live_label);
        this.k = (TbImageView) this.f67661d.findViewById(R.id.live_status_label);
        this.f67665h = (EMTextView) this.f67661d.findViewById(R.id.tvLocation);
        this.f67661d.setOnClickListener(this.r);
        this.q = ((l.k(TbadkCoreApplication.getInst()) - u) - (v * 2)) / 2;
    }

    @Override // d.a.s0.v.d.c.b
    public void a(d.a.s0.v.d.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            l(aVar, -1);
        }
    }

    @Override // d.a.s0.v.d.c.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67661d : (View) invokeV.objValue;
    }

    public final int i(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) ? (int) (s * (i3 / i2)) : invokeII.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.f67660c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
            layoutParams.bottomMargin = this.f67660c.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
            this.f67665h.setGravity(16);
            this.f67665h.setLayoutParams(layoutParams);
        }
    }

    public final void k() {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
            SdkLiveInfoData sdkLiveInfoData = this.m;
            if (sdkLiveInfoData != null) {
                statisticItem.param("tid", sdkLiveInfoData.tid);
                statisticItem.param("fid", this.l.f67430g);
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 6);
            SdkLiveInfoData sdkLiveInfoData2 = this.m;
            if (sdkLiveInfoData2 != null && (alaLiveInfo = sdkLiveInfoData2.liveInfo) != null) {
                int a2 = d.a.s0.v.d.c.c.a(alaLiveInfo);
                SdkLiveInfoData.YYExt yYExt = this.m.liveInfo.yyExt;
                if (yYExt != null) {
                    TiebaStaticHelper.addYYParam(statisticItem, d.a.s0.v.d.c.c.k(yYExt));
                    str = TiebaStatic.YYValues.YY_LIVE;
                } else {
                    str = "";
                }
                statisticItem.param("obj_param1", a2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void l(d.a.s0.v.d.a.a aVar, int i2) {
        String str;
        SdkLiveInfoData.UiTransParam uiTransParam;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, aVar, i2) == null) {
            int k = l.k(this.f67661d.getContext());
            if (k != this.o) {
                ViewGroup.LayoutParams layoutParams = this.f67661d.getLayoutParams();
                if (layoutParams == null) {
                    int i3 = this.q;
                    layoutParams = new ViewGroup.LayoutParams(i3, i3);
                } else {
                    int i4 = this.q;
                    layoutParams.width = i4;
                    layoutParams.height = i4;
                }
                this.f67661d.setLayoutParams(layoutParams);
                this.o = k;
            }
            if (aVar != null && aVar.f67428e != null) {
                getView().setVisibility(0);
                this.l = aVar;
                this.m = aVar.f67428e;
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f67659b);
                String str3 = this.m.liveInfo.cover;
                this.n = str3;
                this.f67662e.setTag(str3);
                if (aVar.j) {
                    this.f67662e.setConrers(5);
                    gradientDrawable.setCornerRadii(x);
                    this.f67662e.setPlaceHolder(2);
                } else if (aVar.k) {
                    this.f67662e.setConrers(10);
                    gradientDrawable.setCornerRadii(y);
                    this.f67662e.setPlaceHolder(2);
                } else if (aVar.l) {
                    this.f67662e.setConrers(15);
                    gradientDrawable.setCornerRadii(w);
                    this.f67662e.setPlaceHolder(2);
                }
                this.f67662e.setRadius((int) t);
                TbImageView tbImageView = this.f67662e;
                String str4 = this.m.liveInfo.cover;
                int i5 = this.q;
                tbImageView.L(str4, 10, i5, i5, false, false);
                this.f67666i.setBackgroundDrawable(gradientDrawable);
                long j = this.m.liveInfo.audienceCount;
                if (j <= 0) {
                    this.f67663f.setVisibility(8);
                    if (this.f67665h.getVisibility() == 0) {
                        m();
                    }
                } else {
                    String numberUniformFormatExtraWithRound = StringHelper.numberUniformFormatExtraWithRound(j);
                    this.f67663f.setVisibility(0);
                    this.f67663f.setText(numberUniformFormatExtraWithRound);
                    j();
                }
                if (103 == this.p) {
                    if (!StringUtils.isNull(this.m.title)) {
                        this.f67664g.setText(this.m.title);
                    }
                } else if (!StringUtils.isNull(this.m.liveAuthor.nameShow)) {
                    this.f67664g.setText(this.m.liveAuthor.nameShow);
                }
                if (!StringUtils.isNull(this.m.labelUrl)) {
                    this.j.setVisibility(0);
                    this.j.M(this.m.labelUrl, 10, false);
                    this.j.setEvent(new a(this));
                } else {
                    this.j.setVisibility(8);
                }
                if (!StringUtils.isNull(this.m.modeUrl)) {
                    this.k.setVisibility(0);
                    this.k.M(this.m.modeUrl, 10, false);
                    this.k.setEvent(new b(this));
                } else {
                    this.k.setVisibility(8);
                }
                if (!StringUtils.isNull(this.m.location)) {
                    this.f67665h.setVisibility(0);
                    if (this.m.location.length() <= 5) {
                        str2 = this.m.location;
                    } else {
                        str2 = this.m.location.substring(0, 5) + StringHelper.STRING_MORE;
                    }
                    this.f67665h.setText(str2);
                } else {
                    this.f67665h.setVisibility(8);
                }
                if (this.m != null) {
                    if (i2 == 2) {
                        StatisticItem param = new StatisticItem("c12899").param("tid", this.m.tid);
                        TiebaStaticHelper.addYYParam(param);
                        TiebaStatic.log(param);
                    } else if (i2 == 1) {
                        StatisticItem param2 = new StatisticItem("c12903").param("tid", this.m.tid);
                        TiebaStaticHelper.addYYParam(param2);
                        TiebaStatic.log(param2);
                    }
                }
                onChangeSkinType(this.f67660c, TbadkCoreApplication.getInst().getSkinType());
                boolean z = aVar.f67429f;
                String str5 = TiebaStatic.YYValues.YY_LIVE;
                if (z) {
                    StatisticItem statisticItem = new StatisticItem("c13610");
                    SdkLiveInfoData sdkLiveInfoData = this.m;
                    statisticItem.param("obj_param1", sdkLiveInfoData != null ? sdkLiveInfoData.liveId : "");
                    statisticItem.param("fid", aVar.f67430g);
                    statisticItem.param("fname", aVar.f67431h);
                    statisticItem.param("obj_locate", aVar.f67432i);
                    SdkLiveInfoData sdkLiveInfoData2 = this.m;
                    if (sdkLiveInfoData2 != null && (uiTransParam = sdkLiveInfoData2.uiTransParam) != null) {
                        statisticItem.param("ab_tag", uiTransParam.abTag);
                        statisticItem.param(TiebaStatic.Params.STAR_ID, this.m.uiTransParam.starId);
                        statisticItem.param("extra", this.m.uiTransParam.extra);
                        statisticItem.param("source_from", this.m.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                    SdkLiveInfoData sdkLiveInfoData3 = this.m;
                    if (sdkLiveInfoData3 != null) {
                        statisticItem2.param("tid", sdkLiveInfoData3.tid);
                        statisticItem2.param("fid", aVar.f67430g);
                    }
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 6);
                    SdkLiveInfoData.AlaLiveInfo alaLiveInfo = this.m.liveInfo;
                    if (alaLiveInfo != null) {
                        int a2 = d.a.s0.v.d.c.c.a(alaLiveInfo);
                        SdkLiveInfoData.YYExt yYExt = this.m.liveInfo.yyExt;
                        if (yYExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem2, d.a.s0.v.d.c.c.k(yYExt));
                        } else {
                            str5 = "";
                        }
                        statisticItem2.param("obj_param1", a2);
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str5);
                    }
                    TiebaStatic.log(statisticItem2);
                    return;
                }
                StatisticItem statisticItem3 = new StatisticItem("c13544");
                int i6 = this.p;
                if (101 == i6) {
                    str = "推荐";
                } else if (102 == i6) {
                    str = "颜值";
                } else if (103 == i6) {
                    if (d.a.s0.v.d.c.c.c(this.m)) {
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                        statisticItem4.param("obj_locate", 3);
                        statisticItem4.param("obj_param1", this.m.liveId);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        TiebaStatic.log(statisticItem4);
                    }
                    str = "交友";
                } else {
                    str = "";
                }
                SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = this.m.liveInfo;
                if (alaLiveInfo2 != null) {
                    int a3 = d.a.s0.v.d.c.c.a(alaLiveInfo2);
                    SdkLiveInfoData.YYExt yYExt2 = this.m.liveInfo.yyExt;
                    if (yYExt2 != null) {
                        TiebaStaticHelper.addYYParam(statisticItem3, d.a.s0.v.d.c.c.k(yYExt2));
                    } else {
                        str5 = "";
                    }
                    statisticItem3.param(TiebaStatic.Params.OBJ_PARAM2, a3);
                    statisticItem3.param(TiebaStatic.Params.OBJ_PARAM3, str5);
                }
                SdkLiveInfoData sdkLiveInfoData4 = this.m;
                statisticItem3.param("obj_param1", sdkLiveInfoData4 != null ? sdkLiveInfoData4.liveId : "");
                statisticItem3.param(TiebaStatic.Params.ENTRY_NAME, str);
                statisticItem3.param("nid", this.m.nid);
                statisticItem3.param(TiebaStatic.Params.LOGID, this.m.logid);
                TiebaStatic.log(statisticItem3);
                return;
            }
            getView().setVisibility(4);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.f67660c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
            layoutParams.bottomMargin = 0;
            this.f67665h.setGravity(16);
            this.f67665h.setLayoutParams(layoutParams);
        }
    }

    @Override // d.a.s0.v.d.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) || this.f67658a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f67663f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f67664g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f67665h, R.color.CAM_X0101);
        this.f67658a = i2;
    }
}
