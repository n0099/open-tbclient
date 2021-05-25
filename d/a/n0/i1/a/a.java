package d.a.n0.i1.a;

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
    public Context f55674e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.n0.i1.b.a> f55675f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f55676g;

    public a(Context context) {
        this.f55674e = context;
    }

    public void a(List<d.a.n0.i1.b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f55675f = list;
        notifyDataSetChanged();
    }

    public void b(View.OnClickListener onClickListener) {
        this.f55676g = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.f55675f.size();
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
            labelItemView = new LabelItemView(this.f55674e);
        } else {
            labelItemView = (LabelItemView) view;
        }
        int i3 = i2 * 3;
        labelItemView.setData(this.f55675f.subList(i3, Math.min(this.f55675f.size(), i3 + 3)), i2 == getCount() - 1);
        labelItemView.setOnClickListener(this.f55676g);
        return labelItemView;
    }
}
