package d.a.n0.h2.g;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.personCenter.view.PersonHeadPendantView;
import com.baidu.tieba.view.PersonCenterGuideView;
import d.a.c.e.p.l;
import d.a.n0.e3.h0.m;
import d.a.n0.h2.e.i;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class h extends d.a.n0.z.b<i> {
    public int m;
    public RelativeLayout n;
    public PersonHeadPendantView o;
    public View p;
    public TbImageView q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public PersonCenterGuideView u;
    public UserData v;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.v.getNewGodData() == null || !h.this.v.getNewGodData().hasNewGodInvited()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13690").param("uid", h.this.v.getUserId()).param("obj_locate", "1"));
            HashMap hashMap = new HashMap();
            hashMap.put("from", "6");
            hashMap.put("field_id", h.this.v.getNewGodData().getFieldId());
            hashMap.put("animated", Boolean.FALSE);
            hashMap.put(OpenFlutter.EXTRA_TRANSPARANT, Boolean.TRUE);
            hashMap.put("swipeback", Boolean.FALSE);
            hashMap.put("present", Boolean.TRUE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(h.this.f67159f.getPageActivity(), "GodDialog", hashMap)));
        }
    }

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
        View m = m();
        this.o = (PersonHeadPendantView) m.findViewById(R.id.person_header);
        this.p = m.findViewById(R.id.person_header_shadow);
        this.o.setBorderWidth(l.g(b(), R.dimen.tbds8));
        this.o.setHasPendantStyle();
        this.o.getHeadView().setIsRound(true);
        this.o.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.o.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.o.getHeadView().setPlaceHolder(2);
        this.n = (RelativeLayout) m.findViewById(R.id.person_header_container);
        this.q = (TbImageView) m.findViewById(R.id.member_icon);
        this.r = (TextView) m.findViewById(R.id.person_name);
        this.s = (TextView) m.findViewById(R.id.person_desc);
        this.t = (ImageView) m.findViewById(R.id.arrow_icon);
        this.u = (PersonCenterGuideView) m.findViewById(R.id.person_center_guide_view);
        m.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.u.setOnClickListener(this);
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.person_center_header_info_layout;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.m != i2) {
            this.u.j();
            SkinManager.setBackgroundColor(m(), R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0107);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.t, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.o.setBorderColor(R.color.CAM_X0402);
            TBSelector.makeShadowDrawable().setShape(2).setShadowSide(ShadowDrawable.ALL).setShadowLayer(R.color.CAM_X0807, 0, 0, l.g(b(), R.dimen.tbds12)).into(this.p);
            u();
            this.m = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (view == this.q) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 2));
            if (ViewHelper.checkUpIsLogin(this.f67159f.getPageActivity())) {
                UrlManager.getInstance().dealOneLink(this.f67159f, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        PersonCenterGuideView personCenterGuideView = this.u;
        if (view == personCenterGuideView) {
            personCenterGuideView.h();
        }
        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 1));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f67159f.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
    }

    public final void u() {
        y();
        x();
        w();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: v */
    public void n(i iVar) {
        UserData userData;
        if (iVar == null || (userData = iVar.f59251e) == null) {
            return;
        }
        this.v = userData;
        this.o.m(userData);
        this.o.i(this.v, 3);
        if (this.v.getNewGodData() != null && this.v.getNewGodData().hasNewGodInvited()) {
            TiebaStatic.log(new StatisticItem("c13690").param("uid", this.v.getUserId()).param("obj_locate", "0"));
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.o.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
            this.o.setBigVDimenSize(R.dimen.tbds57);
            this.o.g(true);
        } else if (this.v.getNewGodData() != null && this.v.getNewGodData().isNewGod()) {
            this.o.setBigVDimenSize(R.dimen.tbds57);
        }
        this.o.getBigVIconView().setOnClickListener(new a());
        this.r.setText(this.v.getName_show());
        this.s.setText(b().getString(R.string.person_center_default_introduce));
        u();
        o(this.f67159f, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void w() {
        int i2 = R.drawable.icon_mask_boy16_svg;
        UserData userData = this.v;
        if (userData != null && userData.getSex() == 2) {
            i2 = R.drawable.icon_mask_girl16_svg;
        }
        this.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getMaskDrawable(i2, null), (Drawable) null);
    }

    public final void x() {
        UserData userData = this.v;
        if (userData != null && (userData.getIsMem() > 0 || this.v.isBigV())) {
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0301, 1);
        } else {
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1);
        }
    }

    public final void y() {
        UserData userData = this.v;
        if (userData == null) {
            this.q.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = userData.getUserVipInfo();
        if (this.v.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.q.U(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.q.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
        }
    }
}
