package d.b.i0.p0.b;

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
    public TbPageContext f58872a;

    /* renamed from: b  reason: collision with root package name */
    public final View f58873b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f58874c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f58875d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f58876e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f58877f;

    /* renamed from: g  reason: collision with root package name */
    public final BdTypeListView f58878g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f58879h;
    public int i = 3;

    public c(TbPageContext tbPageContext) {
        this.f58872a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.f58873b = inflate;
        this.f58874c = (RelativeLayout) inflate.findViewById(R.id.search_area_root);
        this.f58879h = (ImageView) this.f58873b.findViewById(R.id.search_bar_icon);
        this.f58875d = (EditText) this.f58873b.findViewById(R.id.home_et_search);
        this.f58876e = (ImageView) this.f58873b.findViewById(R.id.home_bt_search_del);
        this.f58875d.setHint(R.string.search_bar_you_want_post_to_share);
        TextView textView = (TextView) this.f58873b.findViewById(R.id.home_bt_search_cancel_s);
        this.f58877f = textView;
        textView.setText(tbPageContext.getString(R.string.cancel));
        this.f58878g = (BdTypeListView) this.f58873b.findViewById(R.id.search_bar_list);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f58874c.getLayoutParams();
        layoutParams.height = l.g(this.f58872a.getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.f58872a.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = g2;
        layoutParams.leftMargin = g2;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.f58874c.setLayoutParams(layoutParams);
    }

    public void b(int i) {
        if (this.i == i) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58879h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f58877f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58876e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i == 2) {
            this.f58875d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f58875d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.f58875d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.i = i;
    }
}
