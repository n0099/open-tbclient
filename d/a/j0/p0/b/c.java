package d.a.j0.p0.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57326a;

    /* renamed from: b  reason: collision with root package name */
    public final View f57327b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f57328c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f57329d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f57330e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f57331f;

    /* renamed from: g  reason: collision with root package name */
    public final BdTypeListView f57332g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f57333h;

    /* renamed from: i  reason: collision with root package name */
    public int f57334i = 3;

    public c(TbPageContext tbPageContext) {
        this.f57326a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.f57327b = inflate;
        this.f57328c = (RelativeLayout) inflate.findViewById(R.id.search_area_root);
        this.f57333h = (ImageView) this.f57327b.findViewById(R.id.search_bar_icon);
        this.f57329d = (EditText) this.f57327b.findViewById(R.id.home_et_search);
        this.f57330e = (ImageView) this.f57327b.findViewById(R.id.home_bt_search_del);
        this.f57329d.setHint(R.string.search_bar_you_want_post_to_share);
        TextView textView = (TextView) this.f57327b.findViewById(R.id.home_bt_search_cancel_s);
        this.f57331f = textView;
        textView.setText(tbPageContext.getString(R.string.cancel));
        this.f57332g = (BdTypeListView) this.f57327b.findViewById(R.id.search_bar_list);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f57328c.getLayoutParams();
        layoutParams.height = l.g(this.f57326a.getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.f57326a.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = g2;
        layoutParams.leftMargin = g2;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.f57328c.setLayoutParams(layoutParams);
    }

    public void b(int i2) {
        if (this.f57334i == i2) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57333h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f57331f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57330e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i2 == 2) {
            this.f57329d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f57329d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.f57329d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.f57334i = i2;
    }
}
