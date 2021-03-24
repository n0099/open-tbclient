package d.b.i0.g1.a;

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
    public Context f54911e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.g1.b.a> f54912f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f54913g;

    public a(Context context) {
        this.f54911e = context;
    }

    public void a(List<d.b.i0.g1.b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f54912f = list;
        notifyDataSetChanged();
    }

    public void b(View.OnClickListener onClickListener) {
        this.f54913g = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.f54912f.size();
        int i = size % 3;
        int i2 = size / 3;
        return i == 0 ? i2 : i2 + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LabelItemView labelItemView;
        if (view == null) {
            labelItemView = new LabelItemView(this.f54911e);
        } else {
            labelItemView = (LabelItemView) view;
        }
        int i2 = i * 3;
        labelItemView.setData(this.f54912f.subList(i2, Math.min(this.f54912f.size(), i2 + 3)), i == getCount() - 1);
        labelItemView.setOnClickListener(this.f54913g);
        return labelItemView;
    }
}
