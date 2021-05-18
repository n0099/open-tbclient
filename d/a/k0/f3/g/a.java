package d.a.k0.f3.g;

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
import d.a.k0.f3.e.b;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55059a;

    /* renamed from: b  reason: collision with root package name */
    public int f55060b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f55061c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55062d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55063e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55064f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55065g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f55066h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55067i;
    public TextView j;

    public a(TbPageContext tbPageContext, int i2) {
        this.f55059a = tbPageContext;
        this.f55060b = i2;
        c();
    }

    public final void a() {
        int i2 = R.layout.grid_view_2_column_item_layout;
        if (this.f55060b == 3) {
            i2 = R.layout.grid_view_3_column_item_layout;
        }
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.f55059a.getPageActivity()).inflate(i2, (ViewGroup) null);
        this.f55061c = roundRelativeLayout;
        roundRelativeLayout.setRadius(this.f55059a.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View b() {
        return this.f55061c;
    }

    public final void c() {
        a();
        this.f55062d = (TextView) this.f55061c.findViewById(R.id.buy_tbean_t_dou_num);
        this.f55063e = (TextView) this.f55061c.findViewById(R.id.buy_tbean_yinji_time);
        this.f55064f = (TextView) this.f55061c.findViewById(R.id.buy_tbean_price);
        this.f55066h = (LinearLayout) this.f55061c.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.f55067i = (TextView) this.f55061c.findViewById(R.id.buy_tbean_member_privilege);
        this.j = (TextView) this.f55061c.findViewById(R.id.buy_tbean_member_prefix);
        this.f55065g = (TextView) this.f55061c.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        if (bVar == null || (iconInfo = bVar.f55054f) == null) {
            return;
        }
        this.f55062d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
        int dimensionPixelSize = this.f55059a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f55062d.setCompoundDrawablePadding(this.f55059a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f55062d.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
        this.f55064f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f55063e.setText(this.f55059a.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.f55053e;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.f55053e.vip_extra_percent.intValue() > 0) {
                this.f55067i.setText(d.a.k0.f3.b.a((bVar.f55054f.non_member_t.intValue() * bVar.f55053e.vip_extra_percent.intValue()) / 100));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.f55059a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f55067i.setCompoundDrawablePadding(this.f55059a.getResources().getDimensionPixelSize(R.dimen.ds6));
                this.f55067i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
                this.f55066h.setVisibility(0);
            } else {
                this.f55066h.setVisibility(8);
            }
        } else {
            this.f55066h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i2) {
        if (i2 != 1 && i2 != 4) {
            this.f55061c.setBgColorRes(R.color.CAM_X0201);
        } else {
            this.f55061c.setBgColorRes(R.color.CAM_X0201_1);
        }
        SkinManager.setViewTextColor(this.f55062d, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.f55064f, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.f55063e, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.f55067i, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.f55065g, R.color.CAM_X0105, 1, i2);
    }
}
