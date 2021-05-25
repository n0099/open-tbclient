package d.a.n0.v.e.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.b {

    /* renamed from: f  reason: collision with root package name */
    public Context f61935f;

    /* renamed from: g  reason: collision with root package name */
    public View f61936g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f61937h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f61938i;
    public View j;
    public View k;
    public View.OnClickListener l;

    public c(Context context) {
        this.f61935f = context;
    }

    @Override // d.a.c.j.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f61935f).inflate(R.layout.ala_frs_game_more_live_layout, (ViewGroup) null);
        this.f61936g = inflate;
        this.f61938i = (TextView) inflate.findViewById(R.id.ala_game_frs_more_live_tip);
        this.f61937h = (ImageView) this.f61936g.findViewById(R.id.ala_game_frs_more_live_icon);
        this.j = this.f61936g.findViewById(R.id.ala_game_frs_more_live_top_line);
        this.k = this.f61936g.findViewById(R.id.ala_game_frs_more_live_bottom_line);
        d(TbadkCoreApplication.getInst().getSkinType());
        return this.f61936g;
    }

    @Override // d.a.c.j.e.b
    public void c() {
        View view;
        View.OnClickListener onClickListener = this.l;
        if (onClickListener == null || (view = this.f61936g) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void d(int i2) {
        View view = this.f61936g;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        TextView textView = this.f61938i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0304);
        }
        ImageView imageView = this.f61937h;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.icon_inf_arrowblue_n);
        }
        View view2 = this.j;
        if (view2 != null) {
            SkinManager.setBackgroundResource(view2, R.color.CAM_X0204);
        }
        View view3 = this.k;
        if (view3 != null) {
            SkinManager.setBackgroundResource(view3, R.color.CAM_X0204);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }
}
