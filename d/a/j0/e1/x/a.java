package d.a.j0.e1.x;

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
    public ValidateActivity f53885e;

    /* renamed from: f  reason: collision with root package name */
    public List<ValidateItemData> f53886f = new ArrayList();

    public a(ValidateActivity validateActivity) {
        this.f53885e = validateActivity;
    }

    public void a() {
        this.f53885e = null;
    }

    public List<ValidateItemData> b() {
        return this.f53886f;
    }

    public void c(List<ValidateItemData> list) {
        if (list == null) {
            return;
        }
        this.f53886f.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ValidateItemData> list = this.f53886f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f53886f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar = view != null ? (b) view.getTag() : null;
        if (bVar == null) {
            bVar = new b(this.f53885e);
        }
        bVar.m(this.f53886f.get(i2));
        return bVar.e();
    }
}
