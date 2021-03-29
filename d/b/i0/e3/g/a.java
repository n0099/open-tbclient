package d.b.i0.e3.g;

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
import d.b.i0.e3.e.b;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54601a;

    /* renamed from: b  reason: collision with root package name */
    public int f54602b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f54603c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54604d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54605e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54606f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54607g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f54608h;
    public TextView i;
    public TextView j;

    public a(TbPageContext tbPageContext, int i) {
        this.f54601a = tbPageContext;
        this.f54602b = i;
        c();
    }

    public final void a() {
        int i = R.layout.grid_view_2_column_item_layout;
        if (this.f54602b == 3) {
            i = R.layout.grid_view_3_column_item_layout;
        }
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.f54601a.getPageActivity()).inflate(i, (ViewGroup) null);
        this.f54603c = roundRelativeLayout;
        roundRelativeLayout.setRadius(this.f54601a.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View b() {
        return this.f54603c;
    }

    public final void c() {
        a();
        this.f54604d = (TextView) this.f54603c.findViewById(R.id.buy_tbean_t_dou_num);
        this.f54605e = (TextView) this.f54603c.findViewById(R.id.buy_tbean_yinji_time);
        this.f54606f = (TextView) this.f54603c.findViewById(R.id.buy_tbean_price);
        this.f54608h = (LinearLayout) this.f54603c.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.i = (TextView) this.f54603c.findViewById(R.id.buy_tbean_member_privilege);
        this.j = (TextView) this.f54603c.findViewById(R.id.buy_tbean_member_prefix);
        this.f54607g = (TextView) this.f54603c.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        if (bVar == null || (iconInfo = bVar.f54596f) == null) {
            return;
        }
        this.f54604d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable drawable = this.f54601a.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize = this.f54601a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f54604d.setCompoundDrawablePadding(this.f54601a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f54604d.setCompoundDrawables(drawable, null, null, null);
        this.f54606f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f54605e.setText(this.f54601a.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.f54595e;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.f54595e.vip_extra_percent.intValue() > 0) {
                this.i.setText(d.b.i0.e3.b.a((bVar.f54596f.non_member_t.intValue() * bVar.f54595e.vip_extra_percent.intValue()) / 100));
                Drawable drawable2 = this.f54601a.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                int dimensionPixelSize2 = this.f54601a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.i.setCompoundDrawablePadding(this.f54601a.getResources().getDimensionPixelSize(R.dimen.ds6));
                this.i.setCompoundDrawables(drawable2, null, null, null);
                this.f54608h.setVisibility(0);
            } else {
                this.f54608h.setVisibility(8);
            }
        } else {
            this.f54608h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i) {
        if (i != 1 && i != 4) {
            this.f54603c.setBgColorRes(R.color.CAM_X0201);
        } else {
            this.f54603c.setBgColorRes(R.color.CAM_X0201_1);
        }
        SkinManager.setViewTextColor(this.f54604d, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.f54606f, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.f54605e, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.f54607g, R.color.CAM_X0105, 1, i);
    }
}
