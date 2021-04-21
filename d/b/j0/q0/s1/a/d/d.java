package d.b.j0.q0.s1.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes4.dex */
public class d extends d.b.j0.q0.s1.a.e.a {

    /* renamed from: g  reason: collision with root package name */
    public LabelDataList f60640g;

    /* renamed from: h  reason: collision with root package name */
    public Context f60641h;
    public int i = 0;
    public final int j;

    public d(Context context) {
        this.f60641h = context;
        this.j = context.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // d.b.j0.q0.s1.a.e.a
    public int b() {
        return ListUtils.getCount(this.f60640g);
    }

    @Override // d.b.j0.q0.s1.a.e.a
    public Object c(int i) {
        return ListUtils.getItem(this.f60640g, i);
    }

    @Override // d.b.j0.q0.s1.a.e.a
    public int d() {
        return this.j;
    }

    @Override // d.b.j0.q0.s1.a.e.a
    public long e(int i) {
        return i;
    }

    @Override // d.b.j0.q0.s1.a.e.a
    public View g(int i, View view, ViewGroup viewGroup) {
        TextView m;
        if (view instanceof TextView) {
            m = (TextView) view;
        } else {
            m = m();
        }
        d.b.j0.q0.s1.a.a.a aVar = (d.b.j0.q0.s1.a.a.a) ListUtils.getItem(this.f60640g, i);
        if (aVar != null) {
            m.setText(aVar.f60609b);
        }
        l(m, this.i == i);
        return m;
    }

    @Override // d.b.j0.q0.s1.a.e.a
    public void j(int i) {
        this.i = i;
        this.f60640g.setSelectedIndex(i);
        notifyDataSetChanged();
    }

    public void l(TextView textView, boolean z) {
        if (z) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        SkinManager.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    public final TextView m() {
        TextView textView = new TextView(this.f60641h);
        textView.setTextSize(0, this.f60641h.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(d());
        return textView;
    }

    public void n(LabelDataList labelDataList) {
        this.f60640g = labelDataList;
        notifyDataSetChanged();
    }
}
