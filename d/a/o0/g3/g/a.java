package d.a.o0.g3.g;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.view.RoundRelativeLayout;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import d.a.o0.g3.e.b;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59061a;

    /* renamed from: b  reason: collision with root package name */
    public int f59062b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f59063c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59064d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59065e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59066f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59067g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f59068h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f59069i;
    public TextView j;

    public a(TbPageContext tbPageContext, int i2) {
        this.f59061a = tbPageContext;
        this.f59062b = i2;
        c();
    }

    public final void a() {
        int i2 = R.layout.grid_view_2_column_item_layout;
        if (this.f59062b == 3) {
            i2 = R.layout.grid_view_3_column_item_layout;
        }
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.f59061a.getPageActivity()).inflate(i2, (ViewGroup) null);
        this.f59063c = roundRelativeLayout;
        roundRelativeLayout.setRadius(this.f59061a.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View b() {
        return this.f59063c;
    }

    public final void c() {
        a();
        this.f59064d = (TextView) this.f59063c.findViewById(R.id.buy_tbean_t_dou_num);
        this.f59065e = (TextView) this.f59063c.findViewById(R.id.buy_tbean_yinji_time);
        this.f59066f = (TextView) this.f59063c.findViewById(R.id.buy_tbean_price);
        this.f59068h = (LinearLayout) this.f59063c.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.f59069i = (TextView) this.f59063c.findViewById(R.id.buy_tbean_member_privilege);
        this.j = (TextView) this.f59063c.findViewById(R.id.buy_tbean_member_prefix);
        this.f59067g = (TextView) this.f59063c.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        if (bVar == null || (iconInfo = bVar.f59056f) == null) {
            return;
        }
        this.f59064d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
        int dimensionPixelSize = this.f59061a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f59064d.setCompoundDrawablePadding(this.f59061a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f59064d.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
        this.f59066f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f59065e.setText(this.f59061a.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.f59055e;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.f59055e.vip_extra_percent.intValue() > 0) {
                this.f59069i.setText(d.a.o0.g3.b.a((bVar.f59056f.non_member_t.intValue() * bVar.f59055e.vip_extra_percent.intValue()) / 100));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.f59061a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f59069i.setCompoundDrawablePadding(this.f59061a.getResources().getDimensionPixelSize(R.dimen.ds6));
                this.f59069i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
                this.f59068h.setVisibility(0);
            } else {
                this.f59068h.setVisibility(8);
            }
        } else {
            this.f59068h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i2) {
        if (i2 != 1 && i2 != 4) {
            this.f59063c.setBgColorRes(R.color.CAM_X0201);
        } else {
            this.f59063c.setBgColorRes(R.color.CAM_X0201_1);
        }
        SkinManager.setViewTextColor(this.f59064d, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.f59066f, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.f59065e, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.f59069i, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.f59067g, R.color.CAM_X0105, 1, i2);
    }
}
