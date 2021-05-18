package d.a.k0.h1.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.interestlabel.view.LabelItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f55486e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.k0.h1.b.a> f55487f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f55488g;

    public a(Context context) {
        this.f55486e = context;
    }

    public void a(List<d.a.k0.h1.b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f55487f = list;
        notifyDataSetChanged();
    }

    public void b(View.OnClickListener onClickListener) {
        this.f55488g = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.f55487f.size();
        int i2 = size % 3;
        int i3 = size / 3;
        return i2 == 0 ? i3 : i3 + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        LabelItemView labelItemView;
        if (view == null) {
            labelItemView = new LabelItemView(this.f55486e);
        } else {
            labelItemView = (LabelItemView) view;
        }
        int i3 = i2 * 3;
        labelItemView.setData(this.f55487f.subList(i3, Math.min(this.f55487f.size(), i3 + 3)), i2 == getCount() - 1);
        labelItemView.setOnClickListener(this.f55488g);
        return labelItemView;
    }
}
