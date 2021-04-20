package d.b.i0.e1.x;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ValidateActivity f55596e;

    /* renamed from: f  reason: collision with root package name */
    public List<ValidateItemData> f55597f = new ArrayList();

    public a(ValidateActivity validateActivity) {
        this.f55596e = validateActivity;
    }

    public void a() {
        this.f55596e = null;
    }

    public List<ValidateItemData> b() {
        return this.f55597f;
    }

    public void c(List<ValidateItemData> list) {
        if (list == null) {
            return;
        }
        this.f55597f.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ValidateItemData> list = this.f55597f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f55597f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = view != null ? (b) view.getTag() : null;
        if (bVar == null) {
            bVar = new b(this.f55596e);
        }
        bVar.m(this.f55597f.get(i));
        return bVar.e();
    }
}
