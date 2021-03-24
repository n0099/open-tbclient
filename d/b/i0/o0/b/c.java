package d.b.i0.o0.b;

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
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57225a;

    /* renamed from: b  reason: collision with root package name */
    public final View f57226b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f57227c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f57228d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f57229e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f57230f;

    /* renamed from: g  reason: collision with root package name */
    public final BdTypeListView f57231g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f57232h;
    public int i = 3;

    public c(TbPageContext tbPageContext) {
        this.f57225a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.f57226b = inflate;
        this.f57227c = (RelativeLayout) inflate.findViewById(R.id.search_area_root);
        this.f57232h = (ImageView) this.f57226b.findViewById(R.id.search_bar_icon);
        this.f57228d = (EditText) this.f57226b.findViewById(R.id.home_et_search);
        this.f57229e = (ImageView) this.f57226b.findViewById(R.id.home_bt_search_del);
        this.f57228d.setHint(R.string.search_bar_you_want_post_to_share);
        TextView textView = (TextView) this.f57226b.findViewById(R.id.home_bt_search_cancel_s);
        this.f57230f = textView;
        textView.setText(tbPageContext.getString(R.string.cancel));
        this.f57231g = (BdTypeListView) this.f57226b.findViewById(R.id.search_bar_list);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f57227c.getLayoutParams();
        layoutParams.height = l.g(this.f57225a.getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.f57225a.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = g2;
        layoutParams.leftMargin = g2;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.f57227c.setLayoutParams(layoutParams);
    }

    public void b(int i) {
        if (this.i == i) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57232h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f57230f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57229e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i == 2) {
            this.f57228d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f57228d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.f57228d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.i = i;
    }
}
