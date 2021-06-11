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
    public TbPageContext f58936a;

    /* renamed from: b  reason: collision with root package name */
    public int f58937b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f58938c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58939d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58940e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58941f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58942g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f58943h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f58944i;
    public TextView j;

    public a(TbPageContext tbPageContext, int i2) {
        this.f58936a = tbPageContext;
        this.f58937b = i2;
        c();
    }

    public final void a() {
        int i2 = R.layout.grid_view_2_column_item_layout;
        if (this.f58937b == 3) {
            i2 = R.layout.grid_view_3_column_item_layout;
        }
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.f58936a.getPageActivity()).inflate(i2, (ViewGroup) null);
        this.f58938c = roundRelativeLayout;
        roundRelativeLayout.setRadius(this.f58936a.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View b() {
        return this.f58938c;
    }

    public final void c() {
        a();
        this.f58939d = (TextView) this.f58938c.findViewById(R.id.buy_tbean_t_dou_num);
        this.f58940e = (TextView) this.f58938c.findViewById(R.id.buy_tbean_yinji_time);
        this.f58941f = (TextView) this.f58938c.findViewById(R.id.buy_tbean_price);
        this.f58943h = (LinearLayout) this.f58938c.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.f58944i = (TextView) this.f58938c.findViewById(R.id.buy_tbean_member_privilege);
        this.j = (TextView) this.f58938c.findViewById(R.id.buy_tbean_member_prefix);
        this.f58942g = (TextView) this.f58938c.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        if (bVar == null || (iconInfo = bVar.f58931f) == null) {
            return;
        }
        this.f58939d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
        int dimensionPixelSize = this.f58936a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f58939d.setCompoundDrawablePadding(this.f58936a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f58939d.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
        this.f58941f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f58940e.setText(this.f58936a.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.f58930e;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.f58930e.vip_extra_percent.intValue() > 0) {
                this.f58944i.setText(d.a.n0.g3.b.a((bVar.f58931f.non_member_t.intValue() * bVar.f58930e.vip_extra_percent.intValue()) / 100));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.f58936a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f58944i.setCompoundDrawablePadding(this.f58936a.getResources().getDimensionPixelSize(R.dimen.ds6));
                this.f58944i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
                this.f58943h.setVisibility(0);
            } else {
                this.f58943h.setVisibility(8);
            }
        } else {
            this.f58943h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i2) {
        if (i2 != 1 && i2 != 4) {
            this.f58938c.setBgColorRes(R.color.CAM_X0201);
        } else {
            this.f58938c.setBgColorRes(R.color.CAM_X0201_1);
        }
        SkinManager.setViewTextColor(this.f58939d, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.f58941f, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.f58940e, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.f58944i, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i2);
        SkinManager.setViewTextColor(this.f58942g, R.color.CAM_X0105, 1, i2);
    }
}
