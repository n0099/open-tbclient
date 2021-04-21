package d.b.j0.p0.b;

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
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59293a;

    /* renamed from: b  reason: collision with root package name */
    public final View f59294b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f59295c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f59296d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f59297e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f59298f;

    /* renamed from: g  reason: collision with root package name */
    public final BdTypeListView f59299g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f59300h;
    public int i = 3;

    public c(TbPageContext tbPageContext) {
        this.f59293a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.f59294b = inflate;
        this.f59295c = (RelativeLayout) inflate.findViewById(R.id.search_area_root);
        this.f59300h = (ImageView) this.f59294b.findViewById(R.id.search_bar_icon);
        this.f59296d = (EditText) this.f59294b.findViewById(R.id.home_et_search);
        this.f59297e = (ImageView) this.f59294b.findViewById(R.id.home_bt_search_del);
        this.f59296d.setHint(R.string.search_bar_you_want_post_to_share);
        TextView textView = (TextView) this.f59294b.findViewById(R.id.home_bt_search_cancel_s);
        this.f59298f = textView;
        textView.setText(tbPageContext.getString(R.string.cancel));
        this.f59299g = (BdTypeListView) this.f59294b.findViewById(R.id.search_bar_list);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f59295c.getLayoutParams();
        layoutParams.height = l.g(this.f59293a.getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.f59293a.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = g2;
        layoutParams.leftMargin = g2;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.f59295c.setLayoutParams(layoutParams);
    }

    public void b(int i) {
        if (this.i == i) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59300h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f59298f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59297e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i == 2) {
            this.f59296d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f59296d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.f59296d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.i = i;
    }
}
