package d.a.n0.q0.b;

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
    public TbPageContext f61955a;

    /* renamed from: b  reason: collision with root package name */
    public final View f61956b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f61957c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f61958d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f61959e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f61960f;

    /* renamed from: g  reason: collision with root package name */
    public final BdTypeListView f61961g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f61962h;

    /* renamed from: i  reason: collision with root package name */
    public int f61963i = 3;

    public c(TbPageContext tbPageContext) {
        this.f61955a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.f61956b = inflate;
        this.f61957c = (RelativeLayout) inflate.findViewById(R.id.search_area_root);
        this.f61962h = (ImageView) this.f61956b.findViewById(R.id.search_bar_icon);
        this.f61958d = (EditText) this.f61956b.findViewById(R.id.home_et_search);
        this.f61959e = (ImageView) this.f61956b.findViewById(R.id.home_bt_search_del);
        this.f61958d.setHint(R.string.search_bar_you_want_post_to_share);
        TextView textView = (TextView) this.f61956b.findViewById(R.id.home_bt_search_cancel_s);
        this.f61960f = textView;
        textView.setText(tbPageContext.getString(R.string.cancel));
        this.f61961g = (BdTypeListView) this.f61956b.findViewById(R.id.search_bar_list);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61957c.getLayoutParams();
        layoutParams.height = l.g(this.f61955a.getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.f61955a.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = g2;
        layoutParams.leftMargin = g2;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.f61957c.setLayoutParams(layoutParams);
    }

    public void b(int i2) {
        if (this.f61963i == i2) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f61962h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f61960f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f61959e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i2 == 2) {
            this.f61958d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f61958d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.f61958d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.f61963i = i2;
    }
}
