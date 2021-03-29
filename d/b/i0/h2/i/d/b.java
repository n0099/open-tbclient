package d.b.i0.h2.i.d;

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
import d.b.b.e.m.e;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.q.g2;
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes5.dex */
public class b {
    public ImageView A;
    public UserData B;
    public d.b.i0.h2.e.a C;
    public boolean D;
    public NoDataView E;
    public String F;
    public View.OnClickListener G = new View$OnClickListenerC1275b();

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55380a;

    /* renamed from: b  reason: collision with root package name */
    public View f55381b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55382c;

    /* renamed from: d  reason: collision with root package name */
    public AlignTextView f55383d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55384e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f55385f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55386g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55387h;
    public LinearLayout i;
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

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Layout layout = b.this.m.getLayout();
            if (layout != null) {
                int lineCount = layout.getLineCount();
                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                    b.this.o.setOnClickListener(null);
                    b.this.n.setVisibility(8);
                    return;
                }
                b.this.o.setOnClickListener(b.this.G);
                b.this.n.setVisibility(0);
            }
        }
    }

    /* renamed from: d.b.i0.h2.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1275b implements View.OnClickListener {
        public View$OnClickListenerC1275b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.o || view == b.this.n) {
                if (b.this.D) {
                    b.this.q();
                } else {
                    PersonIntroductionActivity.startPersonIntroductionActivity(b.this.f55380a.getPageActivity(), b.this.B.getIntro());
                }
            } else if (view == b.this.q) {
                b.this.q();
            } else if (view == b.this.r) {
                b.this.q();
            } else if (view == b.this.w) {
                if (StringUtils.isNull(b.this.F)) {
                    BdToast.c(b.this.f55380a.getPageActivity(), b.this.f55380a.getPageActivity().getText(R.string.god_get_error)).q();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.f55380a.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.F);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new StatisticItem("c13899").param("uid", b.this.B.getUserId()));
            }
        }
    }

    public b(TbPageContext tbPageContext, boolean z) {
        this.f55380a = tbPageContext;
        this.D = z;
        p();
    }

    public void m(d.b.i0.h2.e.a aVar) {
        if (aVar == null || aVar.j() == null) {
            return;
        }
        this.C = aVar;
        this.B = aVar.j();
        this.f55381b.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.f55381b.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RecyclerView.LayoutParams(-1, -2);
        } else {
            layoutParams.width = -1;
        }
        this.f55381b.setLayoutParams(layoutParams);
        if (this.B.getAlaUserData() != null && this.B.getAlaUserData().ala_id > 0) {
            this.i.setVisibility(0);
            this.f55387h.setVisibility(0);
            this.f55387h.setText(String.valueOf(this.B.getAlaUserData().ala_id));
        } else {
            this.i.setVisibility(8);
            this.f55387h.setVisibility(8);
        }
        String tb_age = this.B.getTb_age();
        if (k.isEmpty(tb_age)) {
            tb_age = "0";
        }
        this.j.setText(this.f55380a.getResources().getString(R.string.person_forum_age_suffix, tb_age));
        g2 birthdayInfo = this.B.getBirthdayInfo();
        if (birthdayInfo != null && !k.isEmpty(birthdayInfo.f50801b)) {
            if (birthdayInfo.f50802c < 0) {
                birthdayInfo.f50802c = 0;
            }
            if (birthdayInfo.f50803d == 2) {
                this.f55384e.setVisibility(0);
                this.f55384e.setText(this.f55380a.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.f50802c)));
            } else {
                this.f55384e.setVisibility(8);
            }
            this.f55382c.setVisibility(0);
            this.f55382c.setText(birthdayInfo.f50801b);
            this.f55385f.setVisibility(0);
        } else {
            this.f55385f.setVisibility(8);
            this.f55382c.setVisibility(8);
            this.f55384e.setVisibility(8);
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
                e.a().post(new a());
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
            this.x.setText(String.format(this.f55380a.getString(R.string.god_entry_title), this.F));
            if (aVar.E.is_in_rank.booleanValue()) {
                Integer num = aVar.E.today_rank;
                if (num != null && num.intValue() > 0 && aVar.E.today_rank.intValue() <= 500) {
                    this.y.setText(String.format(this.f55380a.getString(R.string.god_entry_rank), aVar.E.today_rank));
                } else {
                    this.y.setText(this.f55380a.getString(R.string.god_entry_no_rank));
                }
            } else {
                this.y.setText(this.f55380a.getString(R.string.god_entry_no_rank));
            }
            TiebaStatic.log(new StatisticItem("c13898").param("uid", this.B.getUserId()));
            return;
        }
        this.w.setVisibility(8);
    }

    public void n(boolean z, boolean z2) {
        if (!z2 && z) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
    }

    public View o() {
        return this.f55381b;
    }

    public final void p() {
        View inflate = LayoutInflater.from(this.f55380a.getPageActivity()).inflate(R.layout.person_information_header, (ViewGroup) null);
        this.f55381b = inflate;
        inflate.setVisibility(8);
        this.s = (TextView) this.f55381b.findViewById(R.id.person_information_title);
        this.f55382c = (TextView) this.f55381b.findViewById(R.id.person_information_constellation);
        AlignTextView alignTextView = (AlignTextView) this.f55381b.findViewById(R.id.person_information_constellation_label);
        this.f55383d = alignTextView;
        alignTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
        this.f55384e = (TextView) this.f55381b.findViewById(R.id.person_information_age);
        this.f55385f = (LinearLayout) this.f55381b.findViewById(R.id.person_information_constellation_layout);
        this.t = this.f55381b.findViewById(R.id.space_view);
        this.f55386g = (TextView) this.f55381b.findViewById(R.id.person_information_ala_id_label);
        this.f55387h = (TextView) this.f55381b.findViewById(R.id.person_information_ala_id);
        this.i = (LinearLayout) this.f55381b.findViewById(R.id.person_information_ala_id_layout);
        AlignTextView alignTextView2 = (AlignTextView) this.f55381b.findViewById(R.id.person_information_forum_age_label);
        this.k = alignTextView2;
        alignTextView2.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
        this.j = (TextView) this.f55381b.findViewById(R.id.person_information_forum_age);
        AlignTextView alignTextView3 = (AlignTextView) this.f55381b.findViewById(R.id.person_information_intro_label);
        this.l = alignTextView3;
        alignTextView3.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
        this.m = (TextView) this.f55381b.findViewById(R.id.person_information_intro);
        ImageView imageView = (ImageView) this.f55381b.findViewById(R.id.person_information_more_icon);
        this.n = imageView;
        imageView.setOnClickListener(this.G);
        RelativeLayout relativeLayout = (RelativeLayout) this.f55381b.findViewById(R.id.person_information_intro_layout);
        this.o = relativeLayout;
        relativeLayout.setOnClickListener(this.G);
        this.p = (RelativeLayout) this.f55381b.findViewById(R.id.person_information_perfect);
        TextView textView = (TextView) this.f55381b.findViewById(R.id.person_information_perfect_btn);
        this.q = textView;
        textView.setOnClickListener(this.G);
        this.u = (ImageView) this.f55381b.findViewById(R.id.person_information_perfect_image);
        this.v = (TextView) this.f55381b.findViewById(R.id.person_information_perfect_tip);
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.f55381b.findViewById(R.id.god_container);
        this.w = roundRelativeLayout;
        roundRelativeLayout.setOnClickListener(this.G);
        this.A = (ImageView) this.f55381b.findViewById(R.id.god_arrow);
        this.z = (ImageView) this.f55381b.findViewById(R.id.god_icon);
        this.y = (TextView) this.f55381b.findViewById(R.id.god_rank);
        this.x = (TextView) this.f55381b.findViewById(R.id.god_title);
        ImageView imageView2 = (ImageView) this.f55381b.findViewById(R.id.person_information_edit_icon);
        this.r = imageView2;
        imageView2.setOnClickListener(this.G);
        int measureText = (int) this.f55386g.getPaint().measureText(this.f55380a.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.f55383d.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.f55383d.setLayoutParams(layoutParams);
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
        NoDataView a2 = NoDataViewFactory.a(this.f55380a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.e.d(null, this.f55380a.getResources().getString(R.string.no_data_common_txt)), null);
        this.E = a2;
        View view = this.f55381b;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).addView(a2);
        }
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void q() {
        if (TbadkCoreApplication.getCurrentAccountInfo() == null) {
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
            AlaUserInfoData alaUserInfoData = this.B.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.C.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.B.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.B.getBirthdayInfo().f50802c);
                personChangeData.setBirthdayTime(this.B.getBirthdayInfo().f50800a);
                personChangeData.setBirthdayShowStatus(this.B.getBirthdayInfo().f50803d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f55380a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void r(int i) {
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.f55383d, R.color.CAM_X0108, 1, i);
        SkinManager.setViewTextColor(this.f55382c, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.f55384e, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.f55386g, R.color.CAM_X0108, 1, i);
        SkinManager.setViewTextColor(this.f55387h, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0108, 1, i);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0108, 1, i);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0105, 1, i);
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0206);
        SkinManager.setViewTextColor(this.x, R.color.CAM_X0311);
        SkinManager.setViewTextColor(this.y, R.color.CAM_X0311);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.z, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.A, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        NoDataView noDataView = this.E;
        if (noDataView != null) {
            noDataView.f(this.f55380a, i);
        }
    }
}
