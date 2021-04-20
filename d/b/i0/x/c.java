package d.b.i0.x;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import d.b.i0.x.e0.a;
/* loaded from: classes4.dex */
public abstract class c<T extends d.b.i0.x.e0.a> extends b<T> {
    public RelativeLayout m;
    public TextView n;
    public TextView o;
    public TextView p;
    public View q;
    public View r;
    public View s;
    public ImageView t;
    public LinearLayout u;
    public View v;
    public View w;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.u = null;
        v(m());
    }

    @Override // d.b.i0.x.b
    public final int h() {
        return R.layout.card_group;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f63755e != i) {
            u();
        }
        this.f63755e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.p == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (StringUtils.isNull(str)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(l(), new String[]{str});
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void u() {
        if (f() != null && f().equals(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME)) {
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1);
            this.t.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.t, R.drawable.icon_arrow_tab);
        }
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0304, 1);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
        SkinManager.setBackgroundColor(m(), R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.v, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0204);
    }

    public final void v(View view) {
        this.m = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.n = (TextView) view.findViewById(R.id.item_group_title);
        this.o = (TextView) view.findViewById(R.id.item_right_tv);
        this.p = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.q = view.findViewById(R.id.divider_line_top);
        this.r = view.findViewById(R.id.divider_line_middle);
        this.s = view.findViewById(R.id.divider_line_bottom);
        this.u = (LinearLayout) view.findViewById(R.id.card_container);
        this.v = view.findViewById(R.id.divider_card);
        this.w = view.findViewById(R.id.divider_card_top);
        this.t = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    public void w(T t) {
        if (t == null) {
            m().setVisibility(8);
            return;
        }
        this.n.setText(t.mGroupTitle);
        int i = t.mRightIconResId;
        if (i > 0) {
            this.o.setBackgroundResource(i);
        }
        if (t.showTopDivider) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.p.setVisibility(0);
            this.s.setVisibility(0);
            this.r.setVisibility(0);
            this.p.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (StringUtils.isNull(str)) {
                return;
            }
            this.p.setTag(str);
            this.p.setOnClickListener(this);
            return;
        }
        this.p.setVisibility(8);
        this.s.setVisibility(8);
        this.r.setVisibility(8);
    }

    public void x(boolean z) {
        View view = this.v;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void y(int i) {
        View view = this.q;
        if (view != null && view.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
            layoutParams.height = i;
            this.q.setLayoutParams(layoutParams);
        }
        View view2 = this.r;
        if (view2 != null && view2.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.r.getLayoutParams();
            layoutParams2.height = i;
            this.r.setLayoutParams(layoutParams2);
        }
        View view3 = this.s;
        if (view3 == null || view3.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = this.s.getLayoutParams();
        layoutParams3.height = i;
        this.s.setLayoutParams(layoutParams3);
    }
}
