package d.b.i0.t.e.d;

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
public class c extends d.b.b.j.e.b {

    /* renamed from: f  reason: collision with root package name */
    public Context f60743f;

    /* renamed from: g  reason: collision with root package name */
    public View f60744g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f60745h;
    public TextView i;
    public View j;
    public View k;
    public View.OnClickListener l;

    public c(Context context) {
        this.f60743f = context;
    }

    @Override // d.b.b.j.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f60743f).inflate(R.layout.ala_frs_game_more_live_layout, (ViewGroup) null);
        this.f60744g = inflate;
        this.i = (TextView) inflate.findViewById(R.id.ala_game_frs_more_live_tip);
        this.f60745h = (ImageView) this.f60744g.findViewById(R.id.ala_game_frs_more_live_icon);
        this.j = this.f60744g.findViewById(R.id.ala_game_frs_more_live_top_line);
        this.k = this.f60744g.findViewById(R.id.ala_game_frs_more_live_bottom_line);
        d(TbadkCoreApplication.getInst().getSkinType());
        return this.f60744g;
    }

    @Override // d.b.b.j.e.b
    public void c() {
        View view;
        View.OnClickListener onClickListener = this.l;
        if (onClickListener == null || (view = this.f60744g) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void d(int i) {
        View view = this.f60744g;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        TextView textView = this.i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0304);
        }
        ImageView imageView = this.f60745h;
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
