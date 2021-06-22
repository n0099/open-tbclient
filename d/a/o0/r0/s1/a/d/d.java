package d.a.o0.r0.s1.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes4.dex */
public class d extends d.a.o0.r0.s1.a.e.a {

    /* renamed from: g  reason: collision with root package name */
    public LabelDataList f63445g;

    /* renamed from: h  reason: collision with root package name */
    public Context f63446h;

    /* renamed from: i  reason: collision with root package name */
    public int f63447i = 0;
    public final int j;

    public d(Context context) {
        this.f63446h = context;
        this.j = context.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // d.a.o0.r0.s1.a.e.a
    public int b() {
        return ListUtils.getCount(this.f63445g);
    }

    @Override // d.a.o0.r0.s1.a.e.a
    public Object c(int i2) {
        return ListUtils.getItem(this.f63445g, i2);
    }

    @Override // d.a.o0.r0.s1.a.e.a
    public int d() {
        return this.j;
    }

    @Override // d.a.o0.r0.s1.a.e.a
    public long e(int i2) {
        return i2;
    }

    @Override // d.a.o0.r0.s1.a.e.a
    public View g(int i2, View view, ViewGroup viewGroup) {
        TextView m;
        if (view instanceof TextView) {
            m = (TextView) view;
        } else {
            m = m();
        }
        d.a.o0.r0.s1.a.a.a aVar = (d.a.o0.r0.s1.a.a.a) ListUtils.getItem(this.f63445g, i2);
        if (aVar != null) {
            m.setText(aVar.f63413b);
        }
        l(m, this.f63447i == i2);
        return m;
    }

    @Override // d.a.o0.r0.s1.a.e.a
    public void j(int i2) {
        this.f63447i = i2;
        this.f63445g.setSelectedIndex(i2);
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
        TextView textView = new TextView(this.f63446h);
        textView.setTextSize(0, this.f63446h.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(d());
        return textView;
    }

    public void n(LabelDataList labelDataList) {
        this.f63445g = labelDataList;
        notifyDataSetChanged();
    }
}
