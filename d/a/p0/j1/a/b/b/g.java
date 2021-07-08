package d.a.p0.j1.a.b.b;

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
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final PersonalTalkSettingActivity f58876a;

    /* renamed from: b  reason: collision with root package name */
    public final NavigationBar f58877b;

    /* renamed from: c  reason: collision with root package name */
    public final View f58878c;

    /* renamed from: d  reason: collision with root package name */
    public final HeadImageView f58879d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f58880e;

    /* renamed from: f  reason: collision with root package name */
    public final UserIconBox f58881f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f58882g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f58883h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f58884i;
    public TbSettingTextTipView j;
    public RelativeLayout k;
    public LinearLayout l;
    public PersonaltalkSettingViewBlackManView m;
    public PersonalTalkSettingViewSettingView n;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalTalkSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58876a = personalTalkSettingActivity;
        personalTalkSettingActivity.setContentView(R.layout.p2ptalk_setting_activity);
        View findViewById = this.f58876a.findViewById(R.id.person_talk_setting_parent);
        this.f58878c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f58877b = navigationBar;
        navigationBar.setTitleText(this.f58876a.getPageContext().getString(R.string.talk_detail));
        this.f58877b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m = (PersonaltalkSettingViewBlackManView) this.f58876a.findViewById(R.id.black_status_view);
        this.n = (PersonalTalkSettingViewSettingView) this.f58876a.findViewById(R.id.setting_detail_view);
        this.l = (LinearLayout) this.f58876a.findViewById(R.id.user_info_lin);
        this.f58883h = (TbSettingTextTipView) this.f58876a.findViewById(R.id.st_delete_talk_history);
        this.f58884i = (TbSettingTextTipView) this.f58876a.findViewById(R.id.st_report);
        this.j = (TbSettingTextTipView) this.f58876a.findViewById(R.id.add_to_black);
        this.k = (RelativeLayout) this.f58876a.findViewById(R.id.remove_from_black_man);
        this.f58883h.setOnClickListener(this.f58876a);
        this.f58884i.setOnClickListener(this.f58876a);
        this.j.setOnClickListener(this.f58876a);
        this.k.setOnClickListener(this.f58876a);
        this.l.setOnClickListener(this.f58876a);
        HeadImageView headImageView = (HeadImageView) this.f58876a.findViewById(R.id.photo);
        this.f58879d = headImageView;
        headImageView.setIsRound(true);
        this.f58880e = (TextView) this.f58876a.findViewById(R.id.name);
        this.f58881f = (UserIconBox) this.f58876a.findViewById(R.id.user_icon_box);
        this.f58882g = (TextView) this.f58876a.findViewById(R.id.user_desc);
    }

    public void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (z) {
                this.m.setSex(i2);
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

    public void c(f fVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || fVar == null || fVar.j() == null || (str = fVar.j().portrait) == null || str.length() <= 0) {
            return;
        }
        this.f58879d.setImageResource(0);
        this.f58879d.M(str, 12, false);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f58876a.getLayoutMode().j(this.f58878c);
            this.f58877b.onChangeSkinType(this.f58876a.getPageContext(), i2);
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

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(DataRes dataRes) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f58880e.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
        if (dataRes.sex.intValue() == 1) {
            this.f58880e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
        } else if (dataRes.sex.intValue() == 2) {
            if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.f58880e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.f58880e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
        } else {
            i2 = 9;
            this.f58882g.setText(dataRes.intro);
            if (this.f58881f == null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.f58881f.g(linkedList, i2, this.f58876a.getResources().getDimensionPixelSize(R.dimen.ds28), this.f58876a.getResources().getDimensionPixelSize(R.dimen.ds28), this.f58876a.getResources().getDimensionPixelSize(R.dimen.ds4));
                return;
            }
            return;
        }
        i2 = 8;
        this.f58882g.setText(dataRes.intro);
        if (this.f58881f == null) {
        }
    }

    public void g(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) || fVar == null) {
            return;
        }
        a(fVar.l(), fVar.j().sex.intValue());
        b(fVar.m());
        f(fVar.j());
        c(fVar);
    }
}
