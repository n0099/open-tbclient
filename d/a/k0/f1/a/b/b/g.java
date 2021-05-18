package d.a.k0.f1.a.b.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingViewSettingView;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonaltalkSettingViewBlackManView;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final PersonalTalkSettingActivity f54741a;

    /* renamed from: b  reason: collision with root package name */
    public final NavigationBar f54742b;

    /* renamed from: c  reason: collision with root package name */
    public final View f54743c;

    /* renamed from: d  reason: collision with root package name */
    public final HeadImageView f54744d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f54745e;

    /* renamed from: f  reason: collision with root package name */
    public final UserIconBox f54746f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f54747g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f54748h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f54749i;
    public TbSettingTextTipView j;
    public RelativeLayout k;
    public LinearLayout l;
    public PersonaltalkSettingViewBlackManView m;
    public PersonalTalkSettingViewSettingView n;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.f54741a = personalTalkSettingActivity;
        personalTalkSettingActivity.setContentView(R.layout.p2ptalk_setting_activity);
        View findViewById = this.f54741a.findViewById(R.id.person_talk_setting_parent);
        this.f54743c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f54742b = navigationBar;
        navigationBar.setTitleText(this.f54741a.getPageContext().getString(R.string.talk_detail));
        this.f54742b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m = (PersonaltalkSettingViewBlackManView) this.f54741a.findViewById(R.id.black_status_view);
        this.n = (PersonalTalkSettingViewSettingView) this.f54741a.findViewById(R.id.setting_detail_view);
        this.l = (LinearLayout) this.f54741a.findViewById(R.id.user_info_lin);
        this.f54748h = (TbSettingTextTipView) this.f54741a.findViewById(R.id.st_delete_talk_history);
        this.f54749i = (TbSettingTextTipView) this.f54741a.findViewById(R.id.st_report);
        this.j = (TbSettingTextTipView) this.f54741a.findViewById(R.id.add_to_black);
        this.k = (RelativeLayout) this.f54741a.findViewById(R.id.remove_from_black_man);
        this.f54748h.setOnClickListener(this.f54741a);
        this.f54749i.setOnClickListener(this.f54741a);
        this.j.setOnClickListener(this.f54741a);
        this.k.setOnClickListener(this.f54741a);
        this.l.setOnClickListener(this.f54741a);
        HeadImageView headImageView = (HeadImageView) this.f54741a.findViewById(R.id.photo);
        this.f54744d = headImageView;
        headImageView.setIsRound(true);
        this.f54745e = (TextView) this.f54741a.findViewById(R.id.name);
        this.f54746f = (UserIconBox) this.f54741a.findViewById(R.id.user_icon_box);
        this.f54747g = (TextView) this.f54741a.findViewById(R.id.user_desc);
    }

    public void a(boolean z, int i2) {
        if (z) {
            this.m.setSex(i2);
            this.m.setVisibility(0);
            this.n.setVisibility(8);
            return;
        }
        this.n.setVisibility(0);
        this.m.setVisibility(8);
    }

    public void b(boolean z) {
        this.n.a(z);
    }

    public void c(f fVar) {
        String str;
        if (fVar == null || fVar.j() == null || (str = fVar.j().portrait) == null || str.length() <= 0) {
            return;
        }
        this.f54744d.setImageResource(0);
        this.f54744d.V(str, 12, false);
    }

    public void d(int i2) {
        this.f54741a.getLayoutMode().j(this.f54743c);
        this.f54742b.onChangeSkinType(this.f54741a.getPageContext(), i2);
    }

    public void e(BdSwitchView.b bVar) {
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView = this.n;
        if (personalTalkSettingViewSettingView != null) {
            personalTalkSettingViewSettingView.setSwitchStateChangeListener(bVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(DataRes dataRes) {
        int i2;
        if (dataRes == null) {
            return;
        }
        this.f54745e.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
        if (dataRes.sex.intValue() == 1) {
            this.f54745e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
        } else if (dataRes.sex.intValue() == 2) {
            if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.f54745e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.f54745e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
        } else {
            i2 = 9;
            this.f54747g.setText(dataRes.intro);
            if (this.f54746f == null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.f54746f.g(linkedList, i2, this.f54741a.getResources().getDimensionPixelSize(R.dimen.ds28), this.f54741a.getResources().getDimensionPixelSize(R.dimen.ds28), this.f54741a.getResources().getDimensionPixelSize(R.dimen.ds4));
                return;
            }
            return;
        }
        i2 = 8;
        this.f54747g.setText(dataRes.intro);
        if (this.f54746f == null) {
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            a(fVar.l(), fVar.j().sex.intValue());
            b(fVar.m());
            f(fVar.j());
            c(fVar);
        }
    }
}
