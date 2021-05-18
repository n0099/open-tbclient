package d.a.k0.l0;

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
    public Context f57074e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f57075f;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f57076a;

        public b(j jVar) {
        }
    }

    public j(Context context, ArrayList<String> arrayList) {
        this.f57074e = context;
        this.f57075f = arrayList;
    }

    public void a(ArrayList<String> arrayList) {
        this.f57075f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<String> arrayList = this.f57075f;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<String> arrayList = this.f57075f;
        if (arrayList == null || arrayList.size() <= 0 || i2 < 0 || i2 >= this.f57075f.size()) {
            return null;
        }
        return this.f57075f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int k = (d.a.c.e.p.l.k(this.f57074e) - d.a.c.e.p.l.g(this.f57074e, R.dimen.ds22)) / 4;
        if (view == null) {
            b bVar = new b();
            View inflate = LayoutInflater.from(this.f57074e).inflate(R.layout.face_package_item_image, (ViewGroup) null);
            bVar.f57076a = (TbImageView) inflate.findViewById(R.id.image);
            inflate.setTag(bVar);
            inflate.setLayoutParams(new AbsListView.LayoutParams(k, k));
            view = inflate;
        }
        b bVar2 = (b) view.getTag();
        String obj = getItem(i2).toString();
        SkinManager.setBackgroundResource(bVar2.f57076a, R.drawable.btn_choose_face_selector);
        bVar2.f57076a.R(obj, 10, k, k, false);
        if (i2 == getCount() - 1) {
            viewGroup.invalidate();
        }
        return view;
    }
}
