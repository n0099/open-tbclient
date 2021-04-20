package d.b.i0.f1.a.b.b;

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
    public final PersonalTalkSettingActivity f55737a;

    /* renamed from: b  reason: collision with root package name */
    public final NavigationBar f55738b;

    /* renamed from: c  reason: collision with root package name */
    public final View f55739c;

    /* renamed from: d  reason: collision with root package name */
    public final HeadImageView f55740d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f55741e;

    /* renamed from: f  reason: collision with root package name */
    public final UserIconBox f55742f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f55743g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f55744h;
    public TbSettingTextTipView i;
    public TbSettingTextTipView j;
    public RelativeLayout k;
    public LinearLayout l;
    public PersonaltalkSettingViewBlackManView m;
    public PersonalTalkSettingViewSettingView n;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.f55737a = personalTalkSettingActivity;
        personalTalkSettingActivity.setContentView(R.layout.p2ptalk_setting_activity);
        View findViewById = this.f55737a.findViewById(R.id.person_talk_setting_parent);
        this.f55739c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f55738b = navigationBar;
        navigationBar.setTitleText(this.f55737a.getPageContext().getString(R.string.talk_detail));
        this.f55738b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m = (PersonaltalkSettingViewBlackManView) this.f55737a.findViewById(R.id.black_status_view);
        this.n = (PersonalTalkSettingViewSettingView) this.f55737a.findViewById(R.id.setting_detail_view);
        this.l = (LinearLayout) this.f55737a.findViewById(R.id.user_info_lin);
        this.f55744h = (TbSettingTextTipView) this.f55737a.findViewById(R.id.st_delete_talk_history);
        this.i = (TbSettingTextTipView) this.f55737a.findViewById(R.id.st_report);
        this.j = (TbSettingTextTipView) this.f55737a.findViewById(R.id.add_to_black);
        this.k = (RelativeLayout) this.f55737a.findViewById(R.id.remove_from_black_man);
        this.f55744h.setOnClickListener(this.f55737a);
        this.i.setOnClickListener(this.f55737a);
        this.j.setOnClickListener(this.f55737a);
        this.k.setOnClickListener(this.f55737a);
        this.l.setOnClickListener(this.f55737a);
        HeadImageView headImageView = (HeadImageView) this.f55737a.findViewById(R.id.photo);
        this.f55740d = headImageView;
        headImageView.setIsRound(true);
        this.f55741e = (TextView) this.f55737a.findViewById(R.id.name);
        this.f55742f = (UserIconBox) this.f55737a.findViewById(R.id.user_icon_box);
        this.f55743g = (TextView) this.f55737a.findViewById(R.id.user_desc);
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
        this.f55740d.setImageResource(0);
        this.f55740d.W(str, 12, false);
    }

    public void d(int i) {
        this.f55737a.getLayoutMode().j(this.f55739c);
        this.f55738b.onChangeSkinType(this.f55737a.getPageContext(), i);
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
        this.f55741e.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
        if (dataRes.sex.intValue() == 1) {
            this.f55741e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
        } else if (dataRes.sex.intValue() == 2) {
            if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.f55741e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.f55741e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
        } else {
            i = 9;
            this.f55743g.setText(dataRes.intro);
            if (this.f55742f == null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.f55742f.g(linkedList, i, this.f55737a.getResources().getDimensionPixelSize(R.dimen.ds28), this.f55737a.getResources().getDimensionPixelSize(R.dimen.ds28), this.f55737a.getResources().getDimensionPixelSize(R.dimen.ds4));
                return;
            }
            return;
        }
        i = 8;
        this.f55743g.setText(dataRes.intro);
        if (this.f55742f == null) {
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
