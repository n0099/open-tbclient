package d.a.n0.g3.g;

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
import d.a.n0.g3.e.b;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55247a;

    /* renamed from: b  reason: collision with root package name */
    public int f55248b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f55249c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55250d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55251e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55252f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55253g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f55254h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55255i;
    public TextView j;

    public a(TbPageContext tbPageContext, int i2) {
        this.f55247a = tbPageContext;
        this.f55248b = i2;
        c();
    }

    public final void a() {
        int i2 = R.layout.grid_view_2_column_item_layout;
        if (this.f55248b == 3) {
            i2 = R.layout.grid_view_3_column_item_layout;
        }
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.f55247a.getPageActivity()).inflate(i2, (ViewGroup) null);
        this.f55249c = roundRelativeLayout;
        roundRelativeLayout.setRadius(this.f55247a.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View b() {
        return this.f55249c;
    }

    public final void c() {
        a();
        this.f55250d = (TextView) this.f55249c.findViewById(R.id.buy_tbean_t_dou_num);
        this.f55251e = (TextView) this.f55249c.findViewById(R.id.buy_tbean_yinji_time);
        this.f55252f = (TextView) this.f55249c.findViewById(R.id.buy_tbean_price);
        this.f55254h = (LinearLayout) this.f55249c.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.f55255i = (TextView) this.f55249c.findViewById(R.id.buy_tbean_member_privilege);
        this.j = (TextView) this.f55249c.findViewById(R.id.buy_tbean_member_prefix);
        this.f55253g = (TextView) this.f55249c.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        if (bVar == null || (iconInfo = bVar.f55242f) == null) {
            return;
        }
        this.f55250d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
        int dimensionPixelSize = this.f55247a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f55250d.setCompoundDrawablePadding(this.f55247a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f55250d.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
        this.f55252f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f55251e.setText(this.f55247a.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.f55241e;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.f55241e.vip_extra_percent.intValue() > 0) {
                this.f55255i.setText(d.a.n0.g3.b.a((bVar.f55242f.non_member_t.intValue() * bVar.f55241e.vip_extra_percent.intValue()) / 100));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.f55247a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f55255i.setCompoundDrawablePadding(this.f55247a.getResources().getDimensionPixelSize(R.dimen.ds6));
                this.f55255i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
                this.f55254h.setVisibility(0);
            } else {
                this.f55254h.setVisibility(8);
            }
        } else {
            this.f55254h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i2) {
        if (i2 != 1 && i2 != 4) {
            this.f55249c.setBgColorRes(R.color.CAM_X0201);
        } else {
            this.f55249c.setBgColorRes(R.color.CAM_X0201_1);
        }
        SkinManager.setViewTextColor(this.f55250d, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.f55252f, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.f55251e, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.f55255i, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.f55253g, R.color.CAM_X0105, 1, i2);
    }
}
