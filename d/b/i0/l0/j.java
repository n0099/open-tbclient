package d.b.i0.l0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class j extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f56539e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f56540f;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f56541a;

        public b(j jVar) {
        }
    }

    public j(Context context, ArrayList<String> arrayList) {
        this.f56539e = context;
        this.f56540f = arrayList;
    }

    public void a(ArrayList<String> arrayList) {
        this.f56540f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<String> arrayList = this.f56540f;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<String> arrayList = this.f56540f;
        if (arrayList == null || arrayList.size() <= 0 || i < 0 || i >= this.f56540f.size()) {
            return null;
        }
        return this.f56540f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int k = (d.b.b.e.p.l.k(this.f56539e) - d.b.b.e.p.l.g(this.f56539e, R.dimen.ds22)) / 4;
        if (view == null) {
            b bVar = new b();
            View inflate = LayoutInflater.from(this.f56539e).inflate(R.layout.face_package_item_image, (ViewGroup) null);
            bVar.f56541a = (TbImageView) inflate.findViewById(R.id.image);
            inflate.setTag(bVar);
            inflate.setLayoutParams(new AbsListView.LayoutParams(k, k));
            view = inflate;
        }
        b bVar2 = (b) view.getTag();
        String obj = getItem(i).toString();
        SkinManager.setBackgroundResource(bVar2.f56541a, R.drawable.btn_choose_face_selector);
        bVar2.f56541a.T(obj, 10, k, k, false);
        if (i == getCount() - 1) {
            viewGroup.invalidate();
        }
        return view;
    }
}
