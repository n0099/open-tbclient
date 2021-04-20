package d.b.i0.f3.g;

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
import d.b.i0.f3.e.b;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56042a;

    /* renamed from: b  reason: collision with root package name */
    public int f56043b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f56044c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56045d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56046e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56047f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56048g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f56049h;
    public TextView i;
    public TextView j;

    public a(TbPageContext tbPageContext, int i) {
        this.f56042a = tbPageContext;
        this.f56043b = i;
        c();
    }

    public final void a() {
        int i = R.layout.grid_view_2_column_item_layout;
        if (this.f56043b == 3) {
            i = R.layout.grid_view_3_column_item_layout;
        }
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.f56042a.getPageActivity()).inflate(i, (ViewGroup) null);
        this.f56044c = roundRelativeLayout;
        roundRelativeLayout.setRadius(this.f56042a.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View b() {
        return this.f56044c;
    }

    public final void c() {
        a();
        this.f56045d = (TextView) this.f56044c.findViewById(R.id.buy_tbean_t_dou_num);
        this.f56046e = (TextView) this.f56044c.findViewById(R.id.buy_tbean_yinji_time);
        this.f56047f = (TextView) this.f56044c.findViewById(R.id.buy_tbean_price);
        this.f56049h = (LinearLayout) this.f56044c.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.i = (TextView) this.f56044c.findViewById(R.id.buy_tbean_member_privilege);
        this.j = (TextView) this.f56044c.findViewById(R.id.buy_tbean_member_prefix);
        this.f56048g = (TextView) this.f56044c.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        if (bVar == null || (iconInfo = bVar.f56037f) == null) {
            return;
        }
        this.f56045d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable drawable = this.f56042a.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize = this.f56042a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f56045d.setCompoundDrawablePadding(this.f56042a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f56045d.setCompoundDrawables(drawable, null, null, null);
        this.f56047f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f56046e.setText(this.f56042a.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.f56036e;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.f56036e.vip_extra_percent.intValue() > 0) {
                this.i.setText(d.b.i0.f3.b.a((bVar.f56037f.non_member_t.intValue() * bVar.f56036e.vip_extra_percent.intValue()) / 100));
                Drawable drawable2 = this.f56042a.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                int dimensionPixelSize2 = this.f56042a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.i.setCompoundDrawablePadding(this.f56042a.getResources().getDimensionPixelSize(R.dimen.ds6));
                this.i.setCompoundDrawables(drawable2, null, null, null);
                this.f56049h.setVisibility(0);
            } else {
                this.f56049h.setVisibility(8);
            }
        } else {
            this.f56049h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i) {
        if (i != 1 && i != 4) {
            this.f56044c.setBgColorRes(R.color.CAM_X0201);
        } else {
            this.f56044c.setBgColorRes(R.color.CAM_X0201_1);
        }
        SkinManager.setViewTextColor(this.f56045d, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.f56047f, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.f56046e, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.f56048g, R.color.CAM_X0105, 1, i);
    }
}
