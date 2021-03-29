package d.b.i0.d1.j;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public UpdatesActivity f53860e;

    /* renamed from: f  reason: collision with root package name */
    public List<UpdatesItemData> f53861f = new ArrayList();

    public a(UpdatesActivity updatesActivity) {
        this.f53860e = updatesActivity;
    }

    public void a() {
        this.f53860e = null;
    }

    public List<UpdatesItemData> b() {
        return this.f53861f;
    }

    public void c(List<UpdatesItemData> list) {
        if (list == null) {
            return;
        }
        this.f53861f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<UpdatesItemData> list = this.f53861f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f53861f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = view != null ? (b) view.getTag() : null;
        if (bVar == null) {
            bVar = new b(this.f53860e);
        }
        bVar.l(this.f53861f.get(i));
        return bVar.e();
    }
}
