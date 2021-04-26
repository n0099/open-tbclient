package d.a.j0.e1.j;

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
    public UpdatesActivity f53661e;

    /* renamed from: f  reason: collision with root package name */
    public List<UpdatesItemData> f53662f = new ArrayList();

    public a(UpdatesActivity updatesActivity) {
        this.f53661e = updatesActivity;
    }

    public void a() {
        this.f53661e = null;
    }

    public List<UpdatesItemData> b() {
        return this.f53662f;
    }

    public void c(List<UpdatesItemData> list) {
        if (list == null) {
            return;
        }
        this.f53662f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<UpdatesItemData> list = this.f53662f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f53662f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar = view != null ? (b) view.getTag() : null;
        if (bVar == null) {
            bVar = new b(this.f53661e);
        }
        bVar.l(this.f53662f.get(i2));
        return bVar.e();
    }
}
