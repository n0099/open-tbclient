package d.a.j0.f3.g;

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
import d.a.j0.f3.e.b;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54352a;

    /* renamed from: b  reason: collision with root package name */
    public int f54353b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f54354c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54355d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54356e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54357f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54358g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f54359h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54360i;
    public TextView j;

    public a(TbPageContext tbPageContext, int i2) {
        this.f54352a = tbPageContext;
        this.f54353b = i2;
        c();
    }

    public final void a() {
        int i2 = R.layout.grid_view_2_column_item_layout;
        if (this.f54353b == 3) {
            i2 = R.layout.grid_view_3_column_item_layout;
        }
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.f54352a.getPageActivity()).inflate(i2, (ViewGroup) null);
        this.f54354c = roundRelativeLayout;
        roundRelativeLayout.setRadius(this.f54352a.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View b() {
        return this.f54354c;
    }

    public final void c() {
        a();
        this.f54355d = (TextView) this.f54354c.findViewById(R.id.buy_tbean_t_dou_num);
        this.f54356e = (TextView) this.f54354c.findViewById(R.id.buy_tbean_yinji_time);
        this.f54357f = (TextView) this.f54354c.findViewById(R.id.buy_tbean_price);
        this.f54359h = (LinearLayout) this.f54354c.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.f54360i = (TextView) this.f54354c.findViewById(R.id.buy_tbean_member_privilege);
        this.j = (TextView) this.f54354c.findViewById(R.id.buy_tbean_member_prefix);
        this.f54358g = (TextView) this.f54354c.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        if (bVar == null || (iconInfo = bVar.f54347f) == null) {
            return;
        }
        this.f54355d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
        int dimensionPixelSize = this.f54352a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f54355d.setCompoundDrawablePadding(this.f54352a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f54355d.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
        this.f54357f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f54356e.setText(this.f54352a.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.f54346e;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.f54346e.vip_extra_percent.intValue() > 0) {
                this.f54360i.setText(d.a.j0.f3.b.a((bVar.f54347f.non_member_t.intValue() * bVar.f54346e.vip_extra_percent.intValue()) / 100));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.f54352a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f54360i.setCompoundDrawablePadding(this.f54352a.getResources().getDimensionPixelSize(R.dimen.ds6));
                this.f54360i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
                this.f54359h.setVisibility(0);
            } else {
                this.f54359h.setVisibility(8);
            }
        } else {
            this.f54359h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i2) {
        if (i2 != 1 && i2 != 4) {
            this.f54354c.setBgColorRes(R.color.CAM_X0201);
        } else {
            this.f54354c.setBgColorRes(R.color.CAM_X0201_1);
        }
        SkinManager.setViewTextColor(this.f54355d, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.f54357f, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.f54356e, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.f54360i, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.f54358g, R.color.CAM_X0105, 1, i2);
    }
}
