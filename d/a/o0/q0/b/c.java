package d.a.o0.q0.b;

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
    public TbPageContext f62080a;

    /* renamed from: b  reason: collision with root package name */
    public final View f62081b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f62082c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f62083d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f62084e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f62085f;

    /* renamed from: g  reason: collision with root package name */
    public final BdTypeListView f62086g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f62087h;

    /* renamed from: i  reason: collision with root package name */
    public int f62088i = 3;

    public c(TbPageContext tbPageContext) {
        this.f62080a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.f62081b = inflate;
        this.f62082c = (RelativeLayout) inflate.findViewById(R.id.search_area_root);
        this.f62087h = (ImageView) this.f62081b.findViewById(R.id.search_bar_icon);
        this.f62083d = (EditText) this.f62081b.findViewById(R.id.home_et_search);
        this.f62084e = (ImageView) this.f62081b.findViewById(R.id.home_bt_search_del);
        this.f62083d.setHint(R.string.search_bar_you_want_post_to_share);
        TextView textView = (TextView) this.f62081b.findViewById(R.id.home_bt_search_cancel_s);
        this.f62085f = textView;
        textView.setText(tbPageContext.getString(R.string.cancel));
        this.f62086g = (BdTypeListView) this.f62081b.findViewById(R.id.search_bar_list);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62082c.getLayoutParams();
        layoutParams.height = l.g(this.f62080a.getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.f62080a.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = g2;
        layoutParams.leftMargin = g2;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.f62082c.setLayoutParams(layoutParams);
    }

    public void b(int i2) {
        if (this.f62088i == i2) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62087h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f62085f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62084e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i2 == 2) {
            this.f62083d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f62083d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.f62083d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.f62088i = i2;
    }
}
