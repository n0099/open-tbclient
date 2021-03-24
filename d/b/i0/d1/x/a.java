package d.b.i0.d1.x;

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
    public ValidateActivity f54073e;

    /* renamed from: f  reason: collision with root package name */
    public List<ValidateItemData> f54074f = new ArrayList();

    public a(ValidateActivity validateActivity) {
        this.f54073e = validateActivity;
    }

    public void a() {
        this.f54073e = null;
    }

    public List<ValidateItemData> b() {
        return this.f54074f;
    }

    public void c(List<ValidateItemData> list) {
        if (list == null) {
            return;
        }
        this.f54074f.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ValidateItemData> list = this.f54074f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f54074f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = view != null ? (b) view.getTag() : null;
        if (bVar == null) {
            bVar = new b(this.f54073e);
        }
        bVar.m(this.f54074f.get(i));
        return bVar.e();
    }
}
