package d.b.j0.e1.x;

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
    public ValidateActivity f56017e;

    /* renamed from: f  reason: collision with root package name */
    public List<ValidateItemData> f56018f = new ArrayList();

    public a(ValidateActivity validateActivity) {
        this.f56017e = validateActivity;
    }

    public void a() {
        this.f56017e = null;
    }

    public List<ValidateItemData> b() {
        return this.f56018f;
    }

    public void c(List<ValidateItemData> list) {
        if (list == null) {
            return;
        }
        this.f56018f.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ValidateItemData> list = this.f56018f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f56018f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = view != null ? (b) view.getTag() : null;
        if (bVar == null) {
            bVar = new b(this.f56017e);
        }
        bVar.m(this.f56018f.get(i));
        return bVar.e();
    }
}
