package d.a.p0.m2.i.d;

import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.personPolymeric.tab.view.AlignTextView;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.q.h2;
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public UserData B;
    public d.a.p0.m2.e.a C;
    public boolean D;
    public NoDataView E;
    public String F;
    public View.OnClickListener G;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60353a;

    /* renamed from: b  reason: collision with root package name */
    public View f60354b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60355c;

    /* renamed from: d  reason: collision with root package name */
    public AlignTextView f60356d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60357e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60358f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60359g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60360h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f60361i;
    public TextView j;
    public AlignTextView k;
    public AlignTextView l;
    public TextView m;
    public ImageView n;
    public RelativeLayout o;
    public RelativeLayout p;
    public TextView q;
    public ImageView r;
    public TextView s;
    public View t;
    public ImageView u;
    public TextView v;
    public RoundRelativeLayout w;
    public TextView x;
    public TextView y;
    public ImageView z;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60362e;

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
            this.f60362e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f60362e.m.getLayout()) == null) {
                return;
            }
            int lineCount = layout.getLineCount();
            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                this.f60362e.o.setOnClickListener(null);
                this.f60362e.n.setVisibility(8);
                return;
            }
            this.f60362e.o.setOnClickListener(this.f60362e.G);
            this.f60362e.n.setVisibility(0);
        }
    }

    /* renamed from: d.a.p0.m2.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1548b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60363e;

        public View$OnClickListenerC1548b(b bVar) {
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
            this.f60363e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f60363e.o || view == this.f60363e.n) {
                    if (this.f60363e.D) {
                        this.f60363e.q();
                    } else {
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.f60363e.f60353a.getPageActivity(), this.f60363e.B.getIntro());
                    }
                } else if (view == this.f60363e.q) {
                    this.f60363e.q();
                } else if (view == this.f60363e.r) {
                    this.f60363e.q();
                } else if (view == this.f60363e.w) {
                    if (StringUtils.isNull(this.f60363e.F)) {
                        BdToast.c(this.f60363e.f60353a.getPageActivity(), this.f60363e.f60353a.getPageActivity().getText(R.string.god_get_error)).q();
                    } else {
                        HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f60363e.f60353a.getPageActivity());
                        hotUserRankActivityConfig.setCategory(this.f60363e.F);
                        hotUserRankActivityConfig.setIsGod(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    }
                    TiebaStatic.log(new StatisticItem("c13899").param("uid", this.f60363e.B.getUserId()));
                }
            }
        }
    }

    public b(TbPageContext tbPageContext, boolean z) {
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
        this.G = new View$OnClickListenerC1548b(this);
        this.f60353a = tbPageContext;
        this.D = z;
        p();
    }

    public void m(d.a.p0.m2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.C = aVar;
        this.B = aVar.j();
        this.f60354b.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.f60354b.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RecyclerView.LayoutParams(-1, -2);
        } else {
            layoutParams.width = -1;
        }
        this.f60354b.setLayoutParams(layoutParams);
        if (this.B.getAlaUserData() != null && this.B.getAlaUserData().ala_id > 0) {
            this.f60361i.setVisibility(0);
            this.f60360h.setVisibility(0);
            this.f60360h.setText(String.valueOf(this.B.getAlaUserData().ala_id));
        } else {
            this.f60361i.setVisibility(8);
            this.f60360h.setVisibility(8);
        }
        String tb_age = this.B.getTb_age();
        if (k.isEmpty(tb_age)) {
            tb_age = "0";
        }
        this.j.setText(this.f60353a.getResources().getString(R.string.person_forum_age_suffix, tb_age));
        h2 birthdayInfo = this.B.getBirthdayInfo();
        if (birthdayInfo != null && !k.isEmpty(birthdayInfo.f52688b)) {
            if (birthdayInfo.f52689c < 0) {
                birthdayInfo.f52689c = 0;
            }
            if (birthdayInfo.f52690d == 2) {
                this.f60357e.setVisibility(0);
                this.f60357e.setText(this.f60353a.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.f52689c)));
            } else {
                this.f60357e.setVisibility(8);
            }
            this.f60355c.setVisibility(0);
            this.f60355c.setText(birthdayInfo.f52688b);
            this.f60358f.setVisibility(0);
        } else {
            this.f60358f.setVisibility(8);
            this.f60355c.setVisibility(8);
            this.f60357e.setVisibility(8);
        }
        if (this.D) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
        String intro = this.B.getIntro();
        BaijiahaoInfo baijiahaoInfo = this.B.getBaijiahaoInfo();
        if (baijiahaoInfo != null && !k.isEmpty(baijiahaoInfo.auth_desc)) {
            if (!k.isEmpty(intro)) {
                SpannableString spannableString = new SpannableString(intro);
                spannableString.setSpan(new LeadingMarginSpan.Standard(this.j.getLeft(), 0), 0, spannableString.length(), 18);
                this.m.setText(spannableString);
                e.a().post(new a(this));
                this.p.setVisibility(8);
                this.t.setVisibility(0);
            } else {
                this.o.setVisibility(8);
                if (this.D) {
                    this.p.setVisibility(0);
                    this.r.setVisibility(8);
                    this.t.setVisibility(8);
                } else {
                    this.p.setVisibility(8);
                    this.t.setVisibility(0);
                }
            }
        } else if (k.isEmpty(intro)) {
            this.o.setVisibility(8);
            if (this.D) {
                this.p.setVisibility(0);
                this.r.setVisibility(8);
                this.t.setVisibility(8);
            } else {
                this.p.setVisibility(8);
                this.t.setVisibility(0);
            }
        } else {
            this.p.setVisibility(8);
            this.o.setVisibility(8);
            this.t.setVisibility(0);
        }
        if (aVar.E != null) {
            this.w.setVisibility(0);
            String str = aVar.E.module_name;
            this.F = str;
            if (TextUtils.isEmpty(str)) {
                this.F = "";
            }
            this.x.setText(String.format(this.f60353a.getString(R.string.god_entry_title), this.F));
            if (aVar.E.is_in_rank.booleanValue()) {
                Integer num = aVar.E.today_rank;
                if (num != null && num.intValue() > 0 && aVar.E.today_rank.intValue() <= 500) {
                    this.y.setText(String.format(this.f60353a.getString(R.string.god_entry_rank), aVar.E.today_rank));
                } else {
                    this.y.setText(this.f60353a.getString(R.string.god_entry_no_rank));
                }
            } else {
                this.y.setText(this.f60353a.getString(R.string.god_entry_no_rank));
            }
            TiebaStatic.log(new StatisticItem("c13898").param("uid", this.B.getUserId()));
            return;
        }
        this.w.setVisibility(8);
    }

    public void n(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!z2 && z) {
                this.E.setVisibility(0);
            } else {
                this.E.setVisibility(8);
            }
        }
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60354b : (View) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.f60353a.getPageActivity()).inflate(R.layout.person_information_header, (ViewGroup) null);
            this.f60354b = inflate;
            inflate.setVisibility(8);
            this.s = (TextView) this.f60354b.findViewById(R.id.person_information_title);
            this.f60355c = (TextView) this.f60354b.findViewById(R.id.person_information_constellation);
            AlignTextView alignTextView = (AlignTextView) this.f60354b.findViewById(R.id.person_information_constellation_label);
            this.f60356d = alignTextView;
            alignTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.f60357e = (TextView) this.f60354b.findViewById(R.id.person_information_age);
            this.f60358f = (LinearLayout) this.f60354b.findViewById(R.id.person_information_constellation_layout);
            this.t = this.f60354b.findViewById(R.id.space_view);
            this.f60359g = (TextView) this.f60354b.findViewById(R.id.person_information_ala_id_label);
            this.f60360h = (TextView) this.f60354b.findViewById(R.id.person_information_ala_id);
            this.f60361i = (LinearLayout) this.f60354b.findViewById(R.id.person_information_ala_id_layout);
            AlignTextView alignTextView2 = (AlignTextView) this.f60354b.findViewById(R.id.person_information_forum_age_label);
            this.k = alignTextView2;
            alignTextView2.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.j = (TextView) this.f60354b.findViewById(R.id.person_information_forum_age);
            AlignTextView alignTextView3 = (AlignTextView) this.f60354b.findViewById(R.id.person_information_intro_label);
            this.l = alignTextView3;
            alignTextView3.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.m = (TextView) this.f60354b.findViewById(R.id.person_information_intro);
            ImageView imageView = (ImageView) this.f60354b.findViewById(R.id.person_information_more_icon);
            this.n = imageView;
            imageView.setOnClickListener(this.G);
            RelativeLayout relativeLayout = (RelativeLayout) this.f60354b.findViewById(R.id.person_information_intro_layout);
            this.o = relativeLayout;
            relativeLayout.setOnClickListener(this.G);
            this.p = (RelativeLayout) this.f60354b.findViewById(R.id.person_information_perfect);
            TextView textView = (TextView) this.f60354b.findViewById(R.id.person_information_perfect_btn);
            this.q = textView;
            textView.setOnClickListener(this.G);
            this.u = (ImageView) this.f60354b.findViewById(R.id.person_information_perfect_image);
            this.v = (TextView) this.f60354b.findViewById(R.id.person_information_perfect_tip);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.f60354b.findViewById(R.id.god_container);
            this.w = roundRelativeLayout;
            roundRelativeLayout.setOnClickListener(this.G);
            this.A = (ImageView) this.f60354b.findViewById(R.id.god_arrow);
            this.z = (ImageView) this.f60354b.findViewById(R.id.god_icon);
            this.y = (TextView) this.f60354b.findViewById(R.id.god_rank);
            this.x = (TextView) this.f60354b.findViewById(R.id.god_title);
            ImageView imageView2 = (ImageView) this.f60354b.findViewById(R.id.person_information_edit_icon);
            this.r = imageView2;
            imageView2.setOnClickListener(this.G);
            int measureText = (int) this.f60359g.getPaint().measureText(this.f60353a.getString(R.string.person_ala_id));
            ViewGroup.LayoutParams layoutParams = this.f60356d.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = measureText;
                this.f60356d.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.k.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = measureText;
                this.k.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.l.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = measureText;
                this.l.setLayoutParams(layoutParams3);
            }
            NoDataView a2 = NoDataViewFactory.a(this.f60353a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.e.d(null, this.f60353a.getResources().getString(R.string.no_data_common_txt)), null);
            this.E = a2;
            View view = this.f60354b;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(a2);
            }
            r(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        UserData userData = this.B;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.B.getUserName());
            personChangeData.setSex(this.B.getSex());
            personChangeData.setIntro(this.B.getIntro());
            personChangeData.setNameShow(this.B.getName_show());
            personChangeData.setMem(this.B.getIsMem());
            personChangeData.setForumAge(this.B.getTb_age());
            personChangeData.setCanModifyAvatar(this.B.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.B.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.B.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.B.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.C.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.B.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.B.getBirthdayInfo().f52689c);
                personChangeData.setBirthdayTime(this.B.getBirthdayInfo().f52687a);
                personChangeData.setBirthdayShowStatus(this.B.getBirthdayInfo().f52690d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f60353a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f60356d, R.color.CAM_X0108, 1, i2);
            SkinManager.setViewTextColor(this.f60355c, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f60357e, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f60359g, R.color.CAM_X0108, 1, i2);
            SkinManager.setViewTextColor(this.f60360h, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0108, 1, i2);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0108, 1, i2);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0105, 1, i2);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0206);
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0311);
            SkinManager.setViewTextColor(this.y, R.color.CAM_X0311);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.z, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.A, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
            NoDataView noDataView = this.E;
            if (noDataView != null) {
                noDataView.f(this.f60353a, i2);
            }
        }
    }
}
