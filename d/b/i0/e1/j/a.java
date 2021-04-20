package d.b.i0.e1.j;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public UpdatesActivity f55382e;

    /* renamed from: f  reason: collision with root package name */
    public List<UpdatesItemData> f55383f = new ArrayList();

    public a(UpdatesActivity updatesActivity) {
        this.f55382e = updatesActivity;
    }

    public void a() {
        this.f55382e = null;
    }

    public List<UpdatesItemData> b() {
        return this.f55383f;
    }

    public void c(List<UpdatesItemData> list) {
        if (list == null) {
            return;
        }
        this.f55383f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<UpdatesItemData> list = this.f55383f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f55383f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = view != null ? (b) view.getTag() : null;
        if (bVar == null) {
            bVar = new b(this.f55382e);
        }
        bVar.l(this.f55383f.get(i));
        return bVar.e();
    }
}
