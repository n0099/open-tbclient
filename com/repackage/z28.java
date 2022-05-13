package com.repackage;

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
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.view.PersonHeadPendantView;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.PersonCenterGuideView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class z28 extends uw5<j28> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public RelativeLayout n;
    public PersonHeadPendantView o;
    public TbImageView p;
    public TextView q;
    public ImageView r;
    public PersonCenterGuideView s;
    public UserData t;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z28 a;

        public a(z28 z28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.t.getNewGodData() != null && this.a.t.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new StatisticItem("c13690").param("uid", this.a.t.getUserId()).param("obj_locate", "1"));
                HashMap hashMap = new HashMap();
                hashMap.put("from", "6");
                hashMap.put("field_id", this.a.t.getNewGodData().getFieldId());
                hashMap.put("animated", Boolean.FALSE);
                hashMap.put("transparent", Boolean.TRUE);
                hashMap.put("swipeback", Boolean.FALSE);
                hashMap.put("present", Boolean.TRUE);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.b.getPageActivity(), "GodInvitePage", hashMap)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z28(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        View k = k();
        PersonHeadPendantView personHeadPendantView = (PersonHeadPendantView) k.findViewById(R.id.obfuscated_res_0x7f091808);
        this.o = personHeadPendantView;
        personHeadPendantView.setHasPendantStyle();
        this.o.getHeadView().setIsRound(true);
        this.o.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.o.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.o.getHeadView().setPlaceHolder(2);
        this.n = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f091811);
        this.p = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f0913e5);
        this.q = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091845);
        this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090974);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090977);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0906ae);
        this.m = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0906af);
        this.r = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f0902a5);
        this.s = (PersonCenterGuideView) k.findViewById(R.id.obfuscated_res_0x7f0917a7);
        k.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.s.setOnClickListener(this);
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06a2 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.i == i) {
            return;
        }
        this.s.j();
        SkinManager.setBackgroundColor(k(), R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        t();
        this.i = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || view2 == null) {
            return;
        }
        if (view2 == this.p) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 2));
            if (ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
                UrlManager.getInstance().dealOneLink(this.b, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        PersonCenterGuideView personCenterGuideView = this.s;
        if (view2 == personCenterGuideView) {
            personCenterGuideView.h();
        }
        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 1));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(kg.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
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
    @Override // com.repackage.uw5
    /* renamed from: u */
    public void l(j28 j28Var) {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, j28Var) == null) || j28Var == null || (userData = j28Var.a) == null) {
            return;
        }
        this.t = userData;
        this.j.setText(Integer.toString(userData.getFansNum()));
        this.l.setText(Integer.toString(j28Var.a.getConcernNum()));
        this.o.n(this.t);
        this.o.j(this.t, 3);
        if (this.t.getNewGodData() != null && this.t.getNewGodData().hasNewGodInvited()) {
            TiebaStatic.log(new StatisticItem("c13690").param("uid", this.t.getUserId()).param("obj_locate", "0"));
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.o.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
            this.o.setBigVDimenSize(R.dimen.tbds57);
            this.o.h(true);
        } else if (this.t.getNewGodData() != null && this.t.getNewGodData().isNewGod()) {
            this.o.setBigVDimenSize(R.dimen.tbds57);
        }
        this.o.getBigVIconView().setOnClickListener(new a(this));
        this.q.setText(this.t.getName_show());
        t();
        m(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            UserData userData = this.t;
            this.q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getMaskDrawable((userData == null || userData.getSex() != 2) ? R.drawable.icon_mask_boy16_svg : R.drawable.icon_mask_girl16_svg, null), (Drawable) null);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            UserData userData = this.t;
            if (userData != null && (userData.getIsMem() > 0 || this.t.isBigV())) {
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0105, 1);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            UserData userData = this.t;
            if (userData == null) {
                this.p.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
                return;
            }
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (this.t.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.p.K(userVipInfo.getVipIconUrl(), 10, false);
            } else {
                this.p.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
            }
        }
    }
}
