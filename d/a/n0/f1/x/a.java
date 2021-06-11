package d.a.n0.f1.x;

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
    public ValidateActivity f58471e;

    /* renamed from: f  reason: collision with root package name */
    public List<ValidateItemData> f58472f = new ArrayList();

    public a(ValidateActivity validateActivity) {
        this.f58471e = validateActivity;
    }

    public void a() {
        this.f58471e = null;
    }

    public List<ValidateItemData> b() {
        return this.f58472f;
    }

    public void c(List<ValidateItemData> list) {
        if (list == null) {
            return;
        }
        this.f58472f.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ValidateItemData> list = this.f58472f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f58472f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar = view != null ? (b) view.getTag() : null;
        if (bVar == null) {
            bVar = new b(this.f58471e);
        }
        bVar.m(this.f58472f.get(i2));
        return bVar.e();
    }
}
