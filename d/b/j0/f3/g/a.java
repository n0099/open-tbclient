package d.b.j0.f3.g;

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
import d.b.j0.f3.e.b;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56463a;

    /* renamed from: b  reason: collision with root package name */
    public int f56464b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f56465c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56466d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56467e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56468f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56469g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f56470h;
    public TextView i;
    public TextView j;

    public a(TbPageContext tbPageContext, int i) {
        this.f56463a = tbPageContext;
        this.f56464b = i;
        c();
    }

    public final void a() {
        int i = R.layout.grid_view_2_column_item_layout;
        if (this.f56464b == 3) {
            i = R.layout.grid_view_3_column_item_layout;
        }
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.f56463a.getPageActivity()).inflate(i, (ViewGroup) null);
        this.f56465c = roundRelativeLayout;
        roundRelativeLayout.setRadius(this.f56463a.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View b() {
        return this.f56465c;
    }

    public final void c() {
        a();
        this.f56466d = (TextView) this.f56465c.findViewById(R.id.buy_tbean_t_dou_num);
        this.f56467e = (TextView) this.f56465c.findViewById(R.id.buy_tbean_yinji_time);
        this.f56468f = (TextView) this.f56465c.findViewById(R.id.buy_tbean_price);
        this.f56470h = (LinearLayout) this.f56465c.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.i = (TextView) this.f56465c.findViewById(R.id.buy_tbean_member_privilege);
        this.j = (TextView) this.f56465c.findViewById(R.id.buy_tbean_member_prefix);
        this.f56469g = (TextView) this.f56465c.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        if (bVar == null || (iconInfo = bVar.f56458f) == null) {
            return;
        }
        this.f56466d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable drawable = this.f56463a.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize = this.f56463a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f56466d.setCompoundDrawablePadding(this.f56463a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f56466d.setCompoundDrawables(drawable, null, null, null);
        this.f56468f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f56467e.setText(this.f56463a.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.f56457e;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.f56457e.vip_extra_percent.intValue() > 0) {
                this.i.setText(d.b.j0.f3.b.a((bVar.f56458f.non_member_t.intValue() * bVar.f56457e.vip_extra_percent.intValue()) / 100));
                Drawable drawable2 = this.f56463a.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                int dimensionPixelSize2 = this.f56463a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.i.setCompoundDrawablePadding(this.f56463a.getResources().getDimensionPixelSize(R.dimen.ds6));
                this.i.setCompoundDrawables(drawable2, null, null, null);
                this.f56470h.setVisibility(0);
            } else {
                this.f56470h.setVisibility(8);
            }
        } else {
            this.f56470h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i) {
        if (i != 1 && i != 4) {
            this.f56465c.setBgColorRes(R.color.CAM_X0201);
        } else {
            this.f56465c.setBgColorRes(R.color.CAM_X0201_1);
        }
        SkinManager.setViewTextColor(this.f56466d, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.f56468f, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.f56467e, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.f56469g, R.color.CAM_X0105, 1, i);
    }
}
