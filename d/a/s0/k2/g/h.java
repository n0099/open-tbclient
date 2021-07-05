package d.a.s0.k2.g;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.h3.h0.m;
import d.a.s0.k2.e.i;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class h extends d.a.s0.a0.b<i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f62686e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62686e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f62686e.v.getNewGodData() != null && this.f62686e.v.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new StatisticItem("c13690").param("uid", this.f62686e.v.getUserId()).param("obj_locate", "1"));
                HashMap hashMap = new HashMap();
                hashMap.put("from", "6");
                hashMap.put("field_id", this.f62686e.v.getNewGodData().getFieldId());
                hashMap.put("animated", Boolean.FALSE);
                hashMap.put(OpenFlutter.EXTRA_TRANSPARANT, Boolean.TRUE);
                hashMap.put("swipeback", Boolean.FALSE);
                hashMap.put("present", Boolean.TRUE);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(this.f62686e.f57032f.getPageActivity(), "GodDialog", hashMap)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 3;
        View l = l();
        this.o = (PersonHeadPendantView) l.findViewById(R.id.person_header);
        this.p = l.findViewById(R.id.person_header_shadow);
        this.o.setBorderWidth(l.g(b(), R.dimen.tbds8));
        this.o.setHasPendantStyle();
        this.o.getHeadView().setIsRound(true);
        this.o.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.o.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.o.getHeadView().setPlaceHolder(2);
        this.n = (RelativeLayout) l.findViewById(R.id.person_header_container);
        this.q = (TbImageView) l.findViewById(R.id.member_icon);
        this.r = (TextView) l.findViewById(R.id.person_name);
        this.s = (TextView) l.findViewById(R.id.person_desc);
        this.t = (ImageView) l.findViewById(R.id.arrow_icon);
        this.u = (PersonCenterGuideView) l.findViewById(R.id.person_center_guide_view);
        l.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.u.setOnClickListener(this);
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.person_center_header_info_layout : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        this.u.j();
        SkinManager.setBackgroundColor(l(), R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0107);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.t, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        this.o.setBorderColor(R.color.CAM_X0402);
        TBSelector.makeShadowDrawable().setShape(2).setShadowSide(ShadowDrawable.ALL).setShadowLayer(R.color.CAM_X0807, 0, 0, l.g(b(), R.dimen.tbds12)).into(this.p);
        t();
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view == null) {
            return;
        }
        if (view == this.q) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 2));
            if (ViewHelper.checkUpIsLogin(this.f57032f.getPageActivity())) {
                UrlManager.getInstance().dealOneLink(this.f57032f, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        PersonCenterGuideView personCenterGuideView = this.u;
        if (view == personCenterGuideView) {
            personCenterGuideView.h();
        }
        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 1));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f57032f.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            x();
            w();
            v();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: u */
    public void m(i iVar) {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) || iVar == null || (userData = iVar.f62650e) == null) {
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
        this.o.getBigVIconView().setOnClickListener(new a(this));
        this.r.setText(this.v.getName_show());
        this.s.setText(b().getString(R.string.person_center_default_introduce));
        t();
        n(this.f57032f, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = R.drawable.icon_mask_boy16_svg;
            UserData userData = this.v;
            if (userData != null && userData.getSex() == 2) {
                i2 = R.drawable.icon_mask_girl16_svg;
            }
            this.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getMaskDrawable(i2, null), (Drawable) null);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            UserData userData = this.v;
            if (userData != null && (userData.getIsMem() > 0 || this.v.isBigV())) {
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            UserData userData = this.v;
            if (userData == null) {
                this.q.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
                return;
            }
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (this.v.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.q.M(userVipInfo.getVipIconUrl(), 10, false);
            } else {
                this.q.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
            }
        }
    }
}
