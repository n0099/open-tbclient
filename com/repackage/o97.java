package com.repackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingViewSettingView;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonaltalkSettingViewBlackManView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes6.dex */
public class o97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PersonalTalkSettingActivity a;
    public final NavigationBar b;
    public final View c;
    public final HeadImageView d;
    public final TextView e;
    public final UserIconBox f;
    public final TextView g;
    public TbSettingTextTipView h;
    public TbSettingTextTipView i;
    public TbSettingTextTipView j;
    public RelativeLayout k;
    public LinearLayout l;
    public PersonaltalkSettingViewBlackManView m;
    public PersonalTalkSettingViewSettingView n;

    public o97(PersonalTalkSettingActivity personalTalkSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalTalkSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = personalTalkSettingActivity;
        personalTalkSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d064f);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f0917f9);
        this.c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.obfuscated_res_0x7f0923ac);
        this.b = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1345));
        this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m = (PersonaltalkSettingViewBlackManView) this.a.findViewById(R.id.obfuscated_res_0x7f09038f);
        this.n = (PersonalTalkSettingViewSettingView) this.a.findViewById(R.id.obfuscated_res_0x7f091c93);
        this.l = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092295);
        this.h = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091d7c);
        this.i = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091d7d);
        this.j = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090125);
        this.k = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091a30);
        this.h.setOnClickListener(this.a);
        this.i.setOnClickListener(this.a);
        this.j.setOnClickListener(this.a);
        this.k.setOnClickListener(this.a);
        this.l.setOnClickListener(this.a);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091824);
        this.d = headImageView;
        headImageView.setIsRound(true);
        this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0914e5);
        this.f = (UserIconBox) this.a.findViewById(R.id.obfuscated_res_0x7f09228e);
        this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092284);
    }

    public void a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                this.m.setSex(i);
                this.m.setVisibility(0);
                this.n.setVisibility(8);
                return;
            }
            this.n.setVisibility(0);
            this.m.setVisibility(8);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.n.a(z);
        }
    }

    public void c(n97 n97Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n97Var) == null) || n97Var == null || n97Var.j() == null || (str = n97Var.j().portrait) == null || str.length() <= 0) {
            return;
        }
        this.d.setImageResource(0);
        this.d.K(str, 12, false);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a.getLayoutMode().j(this.c);
            this.b.onChangeSkinType(this.a.getPageContext(), i);
        }
    }

    public void e(BdSwitchView.b bVar) {
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || (personalTalkSettingViewSettingView = this.n) == null) {
            return;
        }
        personalTalkSettingViewSettingView.setSwitchStateChangeListener(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(DataRes dataRes) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.e.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
        if (dataRes.sex.intValue() == 1) {
            this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
        } else if (dataRes.sex.intValue() == 2) {
            if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
        } else {
            i = 9;
            this.g.setText(dataRes.intro);
            if (this.f == null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.f.g(linkedList, i, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                return;
            }
            return;
        }
        i = 8;
        this.g.setText(dataRes.intro);
        if (this.f == null) {
        }
    }

    public void g(n97 n97Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, n97Var) == null) || n97Var == null) {
            return;
        }
        a(n97Var.l(), n97Var.j().sex.intValue());
        b(n97Var.m());
        f(n97Var.j());
        c(n97Var);
    }
}
