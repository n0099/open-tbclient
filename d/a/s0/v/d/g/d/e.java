package d.a.s0.v.d.g.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.z0.j0;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67852a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f67853b;

    /* renamed from: c  reason: collision with root package name */
    public c f67854c;

    /* renamed from: d  reason: collision with root package name */
    public View f67855d;

    /* renamed from: e  reason: collision with root package name */
    public int f67856e;

    /* renamed from: f  reason: collision with root package name */
    public String f67857f;

    /* renamed from: g  reason: collision with root package name */
    public b2 f67858g;

    /* renamed from: h  reason: collision with root package name */
    public f f67859h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67860i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f67861e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67861e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f67861e.f67858g == null || this.f67861e.f67858g.g1() == null || this.f67861e.f67859h == null) {
                        return;
                    }
                    this.f67861e.f67859h.a(this.f67861e.f67856e, this.f67861e.f67857f, this.f67861e.f67858g);
                    return;
                }
                l.J(this.f67861e.f67853b.getPageActivity(), this.f67861e.f67853b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f67862e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67862e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f67862e.f67858g == null || this.f67862e.f67858g.H() == null || StringUtils.isNull(this.f67862e.f67858g.H().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(this.f67862e.f67858g.H().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f67862e.f67853b.getPageActivity()).createNormalConfig(f2, f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), this.f67862e.f67858g.H().isBigV())));
        }
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f67863a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f67864b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f67865c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f67866d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f67867e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f67868f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f67869g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f67870h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f67871i;

        public c(e eVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67863a = view;
            this.f67864b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f67865c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f67866d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f67867e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f67868f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f67869g = (TextView) view.findViewById(R.id.tvUserName);
            this.f67870h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f67871i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f67864b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f67864b.setDrawerType(0);
            this.f67868f.setIsRound(true);
            this.f67868f.setDrawBorder(true);
            this.f67868f.setBorderColor(eVar.f67853b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f67868f.setBorderWidth(eVar.f67853b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f67868f.setIsGod(false);
            this.f67868f.setIsBigV(false);
            this.f67868f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f67867e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f67867e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67852a = 3;
        this.j = new a(this);
        this.k = new b(this);
        this.f67853b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f67855d = inflate;
        this.f67854c = new c(this, inflate);
        this.f67860i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67855d : (View) invokeV.objValue;
    }

    public void h(d.a.s0.v.d.a.c cVar) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (b2Var = cVar.f67436h) != null && b2Var.g1() != null) {
                g().setVisibility(0);
                this.f67858g = cVar.f67436h;
                this.f67856e = cVar.f67433e;
                this.f67857f = !TextUtils.isEmpty(cVar.f67435g) ? cVar.f67435g : cVar.f67434f;
                this.f67854c.f67864b.setDrawerType(0);
                this.f67854c.f67864b.setBorderSurroundContent(true);
                this.f67854c.f67864b.setDrawBorder(true);
                this.f67854c.f67864b.M(this.f67858g.g1().cover, 10, false);
                this.f67854c.f67866d.setText(this.f67853b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f67858g.g1().audience_count)));
                this.f67854c.f67868f.setData(this.f67858g, false);
                this.f67854c.f67870h.setText(this.f67858g.getTitle());
                if (this.f67858g.H() != null) {
                    String name_show = this.f67858g.H().getName_show();
                    if (j0.d(name_show) > 10) {
                        name_show = j0.m(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.f67854c.f67869g.setText(name_show);
                }
                String str = this.f67858g.g1().label_name;
                if (this.f67860i && !StringUtils.isNull(str)) {
                    this.f67854c.f67865c.setText(str);
                    this.f67854c.f67865c.setVisibility(0);
                } else {
                    this.f67854c.f67865c.setVisibility(8);
                }
                if (cVar.f67437i) {
                    this.f67854c.f67871i.setText(this.f67853b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f67858g.g1().distance / 1000.0d))));
                    this.f67854c.f67871i.setVisibility(0);
                } else {
                    this.f67854c.f67871i.setVisibility(8);
                }
                this.f67854c.f67869g.setOnClickListener(this.k);
                i(this.f67853b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f67852a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f67854c.f67867e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f67854c.f67866d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f67854c.f67869g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f67854c.f67870h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f67854c.f67871i, R.color.CAM_X0109);
        this.f67852a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f67859h = fVar;
        }
    }
}
