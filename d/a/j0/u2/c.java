package d.a.j0.u2;

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
    public Context f61440e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61442g = true;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f61441f = new ArrayList();

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61443a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61444b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f61445c;

        /* renamed from: d  reason: collision with root package name */
        public View f61446d;

        public b(c cVar) {
        }
    }

    public c(Context context) {
        this.f61440e = context;
    }

    public void a(List<d> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f61441f.addAll(list);
        notifyDataSetChanged();
    }

    public final b b(View view) {
        b bVar = new b();
        bVar.f61443a = (TextView) view.findViewById(R.id.push_msg_title);
        bVar.f61444b = (TextView) view.findViewById(R.id.push_msg_content);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.push_msg_pic);
        bVar.f61445c = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        bVar.f61446d = view.findViewById(R.id.line);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        List<d> list = this.f61441f;
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return this.f61441f.get(i2);
    }

    public View d(d dVar, View view, ViewGroup viewGroup) {
        b b2;
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            b2 = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f61440e).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            b2 = b(view);
            view.setTag(b2);
        }
        if (dVar == null) {
            return view;
        }
        b2.f61443a.setText(dVar.f61450d);
        b2.f61444b.setText(dVar.f61451e);
        b2.f61445c.setDefaultResource(R.drawable.screen_notify_default_bg);
        b2.f61445c.R(dVar.f61452f, 10, 0, 0, false);
        return view;
    }

    public boolean e() {
        return this.f61442g;
    }

    public void f(boolean z) {
        this.f61442g = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f61441f;
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
        return d(this.f61441f.get(i2), view, viewGroup);
    }
}
