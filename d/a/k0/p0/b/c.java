package d.a.k0.p0.b;

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
    public TbPageContext f58068a;

    /* renamed from: b  reason: collision with root package name */
    public final View f58069b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f58070c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f58071d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f58072e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f58073f;

    /* renamed from: g  reason: collision with root package name */
    public final BdTypeListView f58074g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f58075h;

    /* renamed from: i  reason: collision with root package name */
    public int f58076i = 3;

    public c(TbPageContext tbPageContext) {
        this.f58068a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.f58069b = inflate;
        this.f58070c = (RelativeLayout) inflate.findViewById(R.id.search_area_root);
        this.f58075h = (ImageView) this.f58069b.findViewById(R.id.search_bar_icon);
        this.f58071d = (EditText) this.f58069b.findViewById(R.id.home_et_search);
        this.f58072e = (ImageView) this.f58069b.findViewById(R.id.home_bt_search_del);
        this.f58071d.setHint(R.string.search_bar_you_want_post_to_share);
        TextView textView = (TextView) this.f58069b.findViewById(R.id.home_bt_search_cancel_s);
        this.f58073f = textView;
        textView.setText(tbPageContext.getString(R.string.cancel));
        this.f58074g = (BdTypeListView) this.f58069b.findViewById(R.id.search_bar_list);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f58070c.getLayoutParams();
        layoutParams.height = l.g(this.f58068a.getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.f58068a.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = g2;
        layoutParams.leftMargin = g2;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.f58070c.setLayoutParams(layoutParams);
    }

    public void b(int i2) {
        if (this.f58076i == i2) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58075h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f58073f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58072e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i2 == 2) {
            this.f58071d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f58071d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.f58071d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.f58076i = i2;
    }
}
