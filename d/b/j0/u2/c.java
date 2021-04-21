package d.b.j0.u2;

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
/* loaded from: classes4.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f63221e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63223g = true;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f63222f = new ArrayList();

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f63224a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63225b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f63226c;

        /* renamed from: d  reason: collision with root package name */
        public View f63227d;

        public b(c cVar) {
        }
    }

    public c(Context context) {
        this.f63221e = context;
    }

    public void a(List<d> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f63222f.addAll(list);
        notifyDataSetChanged();
    }

    public final b b(View view) {
        b bVar = new b();
        bVar.f63224a = (TextView) view.findViewById(R.id.push_msg_title);
        bVar.f63225b = (TextView) view.findViewById(R.id.push_msg_content);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.push_msg_pic);
        bVar.f63226c = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        bVar.f63227d = view.findViewById(R.id.line);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i) {
        List<d> list = this.f63222f;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f63222f.get(i);
    }

    public View d(d dVar, View view, ViewGroup viewGroup) {
        b b2;
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            b2 = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f63221e).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            b2 = b(view);
            view.setTag(b2);
        }
        if (dVar == null) {
            return view;
        }
        b2.f63224a.setText(dVar.f63231d);
        b2.f63225b.setText(dVar.f63232e);
        b2.f63226c.setDefaultResource(R.drawable.screen_notify_default_bg);
        b2.f63226c.T(dVar.f63233f, 10, 0, 0, false);
        return view;
    }

    public boolean e() {
        return this.f63223g;
    }

    public void f(boolean z) {
        this.f63223g = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f63222f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return d(this.f63222f.get(i), view, viewGroup);
    }
}
