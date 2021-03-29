package d.b.i0.g1.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.interestlabel.view.LabelItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f54912e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.g1.b.a> f54913f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f54914g;

    public a(Context context) {
        this.f54912e = context;
    }

    public void a(List<d.b.i0.g1.b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f54913f = list;
        notifyDataSetChanged();
    }

    public void b(View.OnClickListener onClickListener) {
        this.f54914g = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.f54913f.size();
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
            labelItemView = new LabelItemView(this.f54912e);
        } else {
            labelItemView = (LabelItemView) view;
        }
        int i2 = i * 3;
        labelItemView.setData(this.f54913f.subList(i2, Math.min(this.f54913f.size(), i2 + 3)), i == getCount() - 1);
        labelItemView.setOnClickListener(this.f54914g);
        return labelItemView;
    }
}
