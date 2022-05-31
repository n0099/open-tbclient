package com.repackage;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes6.dex */
public class i08 extends nv5<sz7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public RelativeLayout n;
    public PersonHeadPendantView o;
    public RelativeLayout p;
    public TbImageView q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public PersonCenterGuideView u;
    public UserData v;
    public int w;
    public int x;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i08 a;

        public a(i08 i08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i08Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.v.getNewGodData() != null && this.a.v.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new StatisticItem("c13690").param("uid", this.a.v.getUserId()).param("obj_locate", "1"));
                HashMap hashMap = new HashMap();
                hashMap.put("from", "6");
                hashMap.put("field_id", this.a.v.getNewGodData().getFieldId());
                hashMap.put("animated", Boolean.FALSE);
                hashMap.put("transparent", Boolean.TRUE);
                hashMap.put("swipeback", Boolean.FALSE);
                hashMap.put("present", Boolean.TRUE);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.b.getPageActivity(), "GodInvitePage", hashMap)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i08 a;

        public b(i08 i08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i08Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.r.getWidth() <= 0) {
                return;
            }
            int x = (((((int) this.a.r.getX()) + this.a.r.getWidth()) + (this.a.v.isNickNameInVerifying ? this.a.w + this.a.s.getWidth() : 0)) + this.a.x) - this.a.p.getWidth();
            if (x > 0) {
                int width = this.a.r.getWidth() - x;
                ViewGroup.LayoutParams layoutParams = this.a.r.getLayoutParams();
                layoutParams.width = width;
                this.a.r.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i08(TbPageContext<?> tbPageContext) {
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
        PersonHeadPendantView personHeadPendantView = (PersonHeadPendantView) k.findViewById(R.id.obfuscated_res_0x7f0917bd);
        this.o = personHeadPendantView;
        personHeadPendantView.setHasPendantStyle();
        this.o.getHeadView().setIsRound(true);
        this.o.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.o.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.o.getHeadView().setPlaceHolder(2);
        this.n = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f0917c6);
        this.p = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f091806);
        this.q = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f0913a5);
        this.r = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0917fa);
        this.s = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091552);
        this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09095e);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090961);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090691);
        this.m = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090692);
        this.t = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f0902a2);
        this.u = (PersonCenterGuideView) k.findViewById(R.id.obfuscated_res_0x7f09175c);
        k.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.w = li.f(getContext(), R.dimen.M_W_X002);
        this.x = li.f(getContext(), R.dimen.tbds62);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            UserData userData = this.v;
            this.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getMaskDrawable((userData == null || userData.getSex() != 2) ? R.drawable.icon_mask_boy16_svg : R.drawable.icon_mask_girl16_svg, null), (Drawable) null);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            UserData userData = this.v;
            if (userData != null && (userData.getIsMem() > 0 || this.v.isBigV())) {
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1);
            }
            wq4 d = wq4.d(this.s);
            d.v(R.color.CAM_X0108);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0203);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            UserData userData = this.v;
            if (userData == null) {
                this.q.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
                return;
            }
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (this.v.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.q.K(userVipInfo.getVipIconUrl(), 10, false);
            } else {
                this.q.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
            }
        }
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0697 : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) || this.i == i) {
            return;
        }
        this.u.j();
        SkinManager.setBackgroundColor(k(), R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.t, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        y();
        this.i = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view2) == null) || view2 == null) {
            return;
        }
        if (view2 == this.q) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 2));
            if (ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
                UrlManager.getInstance().dealOneLink(this.b, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        PersonCenterGuideView personCenterGuideView = this.u;
        if (view2 == personCenterGuideView) {
            personCenterGuideView.h();
        }
        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 1));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(jg.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            C();
            B();
            A();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nv5
    /* renamed from: z */
    public void l(sz7 sz7Var) {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sz7Var) == null) || sz7Var == null || (userData = sz7Var.a) == null) {
            return;
        }
        this.v = userData;
        this.j.setText(Integer.toString(userData.getFansNum()));
        this.l.setText(Integer.toString(sz7Var.a.getConcernNum()));
        this.o.n(this.v);
        this.o.j(this.v, 3);
        if (this.v.getNewGodData() != null && this.v.getNewGodData().hasNewGodInvited()) {
            TiebaStatic.log(new StatisticItem("c13690").param("uid", this.v.getUserId()).param("obj_locate", "0"));
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.o.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
            this.o.setBigVDimenSize(R.dimen.tbds57);
            this.o.h(true);
        } else if (this.v.getNewGodData() != null && this.v.getNewGodData().isNewGod()) {
            this.o.setBigVDimenSize(R.dimen.tbds57);
        }
        this.o.getBigVIconView().setOnClickListener(new a(this));
        UserData userData2 = this.v;
        if (userData2.isNickNameInVerifying) {
            this.r.setText(userData2.nickNameInVerifying);
            this.s.setVisibility(0);
        } else {
            this.r.setText(userData2.getName_show());
            this.s.setVisibility(4);
        }
        this.r.post(new b(this));
        y();
        m(this.b, TbadkCoreApplication.getInst().getSkinType());
    }
}
