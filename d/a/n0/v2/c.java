package d.a.n0.v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f66036e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66038g = true;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f66037f = new ArrayList();

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f66039a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f66040b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f66041c;

        /* renamed from: d  reason: collision with root package name */
        public View f66042d;

        public b(c cVar) {
        }
    }

    public c(Context context) {
        this.f66036e = context;
    }

    public void a(List<d> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f66037f.addAll(list);
        notifyDataSetChanged();
    }

    public final b b(View view) {
        b bVar = new b();
        bVar.f66039a = (TextView) view.findViewById(R.id.push_msg_title);
        bVar.f66040b = (TextView) view.findViewById(R.id.push_msg_content);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.push_msg_pic);
        bVar.f66041c = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        bVar.f66042d = view.findViewById(R.id.line);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        List<d> list = this.f66037f;
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return this.f66037f.get(i2);
    }

    public View d(d dVar, View view, ViewGroup viewGroup) {
        b b2;
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            b2 = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f66036e).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            b2 = b(view);
            view.setTag(b2);
        }
        if (dVar == null) {
            return view;
        }
        b2.f66039a.setText(dVar.f66046d);
        b2.f66040b.setText(dVar.f66047e);
        b2.f66041c.setDefaultResource(R.drawable.screen_notify_default_bg);
        b2.f66041c.R(dVar.f66048f, 10, 0, 0, false);
        return view;
    }

    public boolean e() {
        return this.f66038g;
    }

    public void f(boolean z) {
        this.f66038g = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f66037f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        return d(this.f66037f.get(i2), view, viewGroup);
    }
}
