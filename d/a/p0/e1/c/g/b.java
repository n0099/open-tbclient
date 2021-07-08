package d.a.p0.e1.c.g;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.p0.e1.c.f.d;
import d.a.p0.h3.f0;
/* loaded from: classes7.dex */
public class b extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public d f55220h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55221i;
    public LikeModel j;
    public f0 k;
    public C1329b l;
    public d.a.o0.r.f0.n.b m;
    public d.a.o0.r.f0.n.b n;
    public TbPageContext<?> o;
    public byte p;
    public TextView q;
    public BarImageView[] r;
    public TextView[] s;
    public TextView[] t;
    public TextView[] u;
    public TextView[] v;
    public TextView[] w;
    public FollowUserButton[] x;
    public final int[] y;
    public final int[] z;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.p0.e1.c.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1329b extends e implements f0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a f55222a;

        /* renamed from: b  reason: collision with root package name */
        public FollowUserButton f55223b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f55224c;

        public C1329b(b bVar) {
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
            this.f55224c = bVar;
        }

        @Override // d.a.p0.h3.f0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.f55224c.f55221i = false;
            }
        }

        @Override // d.a.p0.h3.f0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.f55224c.f55221i = false;
                this.f55224c.o(this.f55223b, false);
                this.f55222a.o(false);
            }
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.f55224c.f55221i = false;
                if (this.f55224c.j.getErrorCode() == 22) {
                    l.M(this.f55224c.o.getPageActivity(), this.f55224c.o.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f55224c.j.getErrorCode() != 0) {
                        l.M(this.f55224c.o.getPageActivity(), this.f55224c.j.getErrorString());
                        return;
                    }
                    this.f55224c.o(this.f55223b, true);
                    this.f55222a.o(true);
                }
            }
        }

        public void d(FollowUserButton followUserButton, d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, followUserButton, aVar) == null) {
                this.f55222a = aVar;
                this.f55223b = followUserButton;
            }
        }

        public /* synthetic */ C1329b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view, TbPageContext<?> tbPageContext, byte b2) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext, Byte.valueOf(b2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55221i = false;
        this.m = new d.a.o0.r.f0.n.b();
        this.n = new d.a.o0.r.f0.n.b();
        this.r = new BarImageView[3];
        this.s = new TextView[3];
        this.t = new TextView[3];
        this.u = new TextView[3];
        this.v = new TextView[3];
        this.w = new TextView[3];
        this.x = new FollowUserButton[3];
        this.y = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.z = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.o = tbPageContext;
        this.p = b2;
        k(view);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void c(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) && (nVar instanceof d)) {
            d dVar = (d) nVar;
            this.f55220h = dVar;
            this.q.setText(dVar.f55210e);
            for (int i2 = 0; i2 < 3; i2++) {
                this.r[i2].M(this.f55220h.f55213h[i2].c(), 10, false);
                this.t[i2].setText(this.f55220h.f55213h[i2].d());
                this.w[i2].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.f55220h.f55213h[i2].e())}));
                this.v[i2].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.f55220h.f55213h[i2].b())}));
                this.x[i2].setTag(Integer.valueOf(i2));
                o(this.x[i2], this.f55220h.f55213h[i2].n());
                this.s[i2].setVisibility(this.f55220h.f55211f ? 0 : 8);
                ((LinearLayout.LayoutParams) this.t[i2].getLayoutParams()).leftMargin = l.g(this.o.getPageActivity(), this.f55220h.f55211f ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.f55220h.f55213h[i2].l()) && d.a.o0.b.d.P()) {
                    this.u[i2].setText(this.f55220h.f55213h[i2].l());
                } else if (!StringUtils.isNull(this.f55220h.f55213h[i2].i()) && d.a.o0.b.d.O()) {
                    this.u[i2].setText(this.f55220h.f55213h[i2].i());
                } else {
                    this.u[i2].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    public final void h(d.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, followUserButton) == null) || this.f55221i) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.o.getPageActivity(), this.o.getString(R.string.neterror));
        } else if (aVar == null || StringUtils.isNull(aVar.d()) || aVar.h() <= 0 || !ViewHelper.checkUpIsLogin(this.o.getPageActivity())) {
        } else {
            if (this.l == null) {
                this.l = new C1329b(this, null);
            }
            if (this.j == null) {
                LikeModel likeModel = new LikeModel(this.o);
                this.j = likeModel;
                likeModel.setLoadDataCallBack(this.l);
            }
            this.l.d(followUserButton, aVar);
            if (k.isForumName(aVar.d())) {
                this.f55221i = true;
                this.j.I();
                this.j.L(aVar.d(), String.valueOf(aVar.h()));
            }
        }
    }

    public final void i(d.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, followUserButton) == null) || this.f55221i) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.o.getPageActivity(), this.o.getString(R.string.neterror));
        } else if (aVar == null || StringUtils.isNull(aVar.d()) || aVar.h() <= 0 || !ViewHelper.checkUpIsLogin(this.o.getPageActivity())) {
        } else {
            if (this.l == null) {
                this.l = new C1329b(this, null);
            }
            if (this.k == null) {
                f0 f0Var = new f0();
                this.k = f0Var;
                f0Var.b(this.l);
            }
            this.l.d(followUserButton, aVar);
            this.f55221i = true;
            this.k.c(aVar.d(), aVar.h());
        }
    }

    public d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55220h : (d) invokeV.objValue;
    }

    public final void k(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.q = (TextView) view.findViewById(R.id.recommend_bar_item_title);
            this.m.r(R.color.CAM_X0109);
            this.m.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.n.q(R.color.CAM_X0304);
            this.n.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.n.f(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            int i2 = 0;
            while (i2 < 3) {
                View findViewById = view.findViewById(this.y[i2]);
                findViewById.setTag(Integer.valueOf(i2));
                findViewById.setOnClickListener(this);
                this.r[i2] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
                this.s[i2] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
                this.t[i2] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
                this.u[i2] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
                this.v[i2] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
                this.w[i2] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
                this.x[i2] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
                this.x[i2].setOnClickListener(this);
                int i3 = i2 + 1;
                this.s[i2].setText(String.valueOf(i3));
                this.r[i2].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.r[i2].setShowInnerBorder(true);
                this.r[i2].setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.r[i2].setShowOval(true);
                this.r[i2].setPlaceHolder(2);
                this.r[i2].setShowOuterBorder(false);
                this.r[i2].setStrokeColorResId(R.color.CAM_X0401);
                i2 = i3;
            }
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f12778e == i2) {
            return;
        }
        this.f12778e = i2;
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0108);
        for (int i3 = 0; i3 < 3; i3++) {
            if (this.s[i3].getVisibility() == 0) {
                SkinManager.setViewTextColor(this.s[i3], R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().defaultColor(this.z[i3]).cornerRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8)).into(this.s[i3]);
            }
            this.x[i3].r(i2);
            SkinManager.setViewTextColor(this.t[i3], R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u[i3], R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.v[i3], R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.w[i3], R.color.CAM_X0109);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.q.setVisibility(z ? 0 : 8);
        }
    }

    public void n(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f55220h == null) {
            return;
        }
        if (z) {
            o(this.x[i2], true);
            this.f55220h.f55213h[i2].o(true);
            return;
        }
        o(this.x[i2], false);
        this.f55220h.f55213h[i2].o(false);
    }

    public final void o(FollowUserButton followUserButton, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, followUserButton, z) == null) || followUserButton == null) {
            return;
        }
        followUserButton.setConfig(z ? this.m : this.n);
        followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
        followUserButton.r(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || this.f55220h == null || view == null) {
            return;
        }
        int id = view.getId();
        int intValue = ((Integer) view.getTag()).intValue();
        d.a aVar = this.f55220h.f55213h[intValue];
        if (view instanceof TBSpecificationBtn) {
            if (aVar.n()) {
                i(aVar, this.x[intValue]);
                return;
            }
            h(aVar, this.x[intValue]);
            StatisticItem param = new StatisticItem("c13644").param("fid", aVar.h()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.p);
            if (!StringUtils.isNull(this.f55220h.f55210e)) {
                param = param.param("obj_name", this.f55220h.f55210e);
            }
            TiebaStatic.log(param);
        } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
            FrsActivityConfig callFrom = new FrsActivityConfig(this.o.getPageActivity()).createNormalCfg(aVar.d(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
            if (d.a.o0.b.d.O()) {
                Intent intent = callFrom.getIntent();
                if (aVar.j() != 0 && intent != null) {
                    intent.putExtra("transition_type", 0);
                    intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.j());
                }
            }
            this.o.sendMessage(new CustomMessage(2003000, callFrom));
            StatisticItem param2 = new StatisticItem("c13988").param("fid", aVar.h()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.p);
            if (!StringUtils.isNull(this.f55220h.f55210e)) {
                param2 = param2.param("obj_name", this.f55220h.f55210e);
            }
            TiebaStatic.log(param2);
        }
    }
}
