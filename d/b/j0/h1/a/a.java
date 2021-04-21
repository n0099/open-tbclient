package d.b.j0.h1.a;

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
    public Context f56869e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.j0.h1.b.a> f56870f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f56871g;

    public a(Context context) {
        this.f56869e = context;
    }

    public void a(List<d.b.j0.h1.b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f56870f = list;
        notifyDataSetChanged();
    }

    public void b(View.OnClickListener onClickListener) {
        this.f56871g = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.f56870f.size();
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
            labelItemView = new LabelItemView(this.f56869e);
        } else {
            labelItemView = (LabelItemView) view;
        }
        int i2 = i * 3;
        labelItemView.setData(this.f56870f.subList(i2, Math.min(this.f56870f.size(), i2 + 3)), i == getCount() - 1);
        labelItemView.setOnClickListener(this.f56871g);
        return labelItemView;
    }
}
