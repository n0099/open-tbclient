package d.a.o0.v.e.d;

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
public class c extends d.a.c.k.e.b {

    /* renamed from: f  reason: collision with root package name */
    public Context f65775f;

    /* renamed from: g  reason: collision with root package name */
    public View f65776g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f65777h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f65778i;
    public View j;
    public View k;
    public View.OnClickListener l;

    public c(Context context) {
        this.f65775f = context;
    }

    @Override // d.a.c.k.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.f65775f).inflate(R.layout.ala_frs_game_more_live_layout, (ViewGroup) null);
        this.f65776g = inflate;
        this.f65778i = (TextView) inflate.findViewById(R.id.ala_game_frs_more_live_tip);
        this.f65777h = (ImageView) this.f65776g.findViewById(R.id.ala_game_frs_more_live_icon);
        this.j = this.f65776g.findViewById(R.id.ala_game_frs_more_live_top_line);
        this.k = this.f65776g.findViewById(R.id.ala_game_frs_more_live_bottom_line);
        d(TbadkCoreApplication.getInst().getSkinType());
        return this.f65776g;
    }

    @Override // d.a.c.k.e.b
    public void c() {
        View view;
        View.OnClickListener onClickListener = this.l;
        if (onClickListener == null || (view = this.f65776g) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void d(int i2) {
        View view = this.f65776g;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        TextView textView = this.f65778i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0304);
        }
        ImageView imageView = this.f65777h;
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
