package d.b.i0.e1.a.b.b;

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
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final PersonalTalkSettingActivity f54296a;

    /* renamed from: b  reason: collision with root package name */
    public final NavigationBar f54297b;

    /* renamed from: c  reason: collision with root package name */
    public final View f54298c;

    /* renamed from: d  reason: collision with root package name */
    public final HeadImageView f54299d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f54300e;

    /* renamed from: f  reason: collision with root package name */
    public final UserIconBox f54301f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f54302g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f54303h;
    public TbSettingTextTipView i;
    public TbSettingTextTipView j;
    public RelativeLayout k;
    public LinearLayout l;
    public PersonaltalkSettingViewBlackManView m;
    public PersonalTalkSettingViewSettingView n;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.f54296a = personalTalkSettingActivity;
        personalTalkSettingActivity.setContentView(R.layout.p2ptalk_setting_activity);
        View findViewById = this.f54296a.findViewById(R.id.person_talk_setting_parent);
        this.f54298c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f54297b = navigationBar;
        navigationBar.setTitleText(this.f54296a.getPageContext().getString(R.string.talk_detail));
        this.f54297b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m = (PersonaltalkSettingViewBlackManView) this.f54296a.findViewById(R.id.black_status_view);
        this.n = (PersonalTalkSettingViewSettingView) this.f54296a.findViewById(R.id.setting_detail_view);
        this.l = (LinearLayout) this.f54296a.findViewById(R.id.user_info_lin);
        this.f54303h = (TbSettingTextTipView) this.f54296a.findViewById(R.id.st_delete_talk_history);
        this.i = (TbSettingTextTipView) this.f54296a.findViewById(R.id.st_report);
        this.j = (TbSettingTextTipView) this.f54296a.findViewById(R.id.add_to_black);
        this.k = (RelativeLayout) this.f54296a.findViewById(R.id.remove_from_black_man);
        this.f54303h.setOnClickListener(this.f54296a);
        this.i.setOnClickListener(this.f54296a);
        this.j.setOnClickListener(this.f54296a);
        this.k.setOnClickListener(this.f54296a);
        this.l.setOnClickListener(this.f54296a);
        HeadImageView headImageView = (HeadImageView) this.f54296a.findViewById(R.id.photo);
        this.f54299d = headImageView;
        headImageView.setIsRound(true);
        this.f54300e = (TextView) this.f54296a.findViewById(R.id.name);
        this.f54301f = (UserIconBox) this.f54296a.findViewById(R.id.user_icon_box);
        this.f54302g = (TextView) this.f54296a.findViewById(R.id.user_desc);
    }

    public void a(boolean z, int i) {
        if (z) {
            this.m.setSex(i);
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
        this.f54299d.setImageResource(0);
        this.f54299d.W(str, 12, false);
    }

    public void d(int i) {
        this.f54296a.getLayoutMode().j(this.f54298c);
        this.f54297b.onChangeSkinType(this.f54296a.getPageContext(), i);
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
        int i;
        if (dataRes == null) {
            return;
        }
        this.f54300e.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
        if (dataRes.sex.intValue() == 1) {
            this.f54300e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
        } else if (dataRes.sex.intValue() == 2) {
            if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.f54300e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.f54300e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
        } else {
            i = 9;
            this.f54302g.setText(dataRes.intro);
            if (this.f54301f == null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.f54301f.g(linkedList, i, this.f54296a.getResources().getDimensionPixelSize(R.dimen.ds28), this.f54296a.getResources().getDimensionPixelSize(R.dimen.ds28), this.f54296a.getResources().getDimensionPixelSize(R.dimen.ds4));
                return;
            }
            return;
        }
        i = 8;
        this.f54302g.setText(dataRes.intro);
        if (this.f54301f == null) {
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
