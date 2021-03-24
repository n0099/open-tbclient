package d.b.i0.t2;

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
    public Context f61110e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61112g = true;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f61111f = new ArrayList();

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61113a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61114b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f61115c;

        /* renamed from: d  reason: collision with root package name */
        public View f61116d;

        public b(c cVar) {
        }
    }

    public c(Context context) {
        this.f61110e = context;
    }

    public void a(List<d> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f61111f.addAll(list);
        notifyDataSetChanged();
    }

    public final b b(View view) {
        b bVar = new b();
        bVar.f61113a = (TextView) view.findViewById(R.id.push_msg_title);
        bVar.f61114b = (TextView) view.findViewById(R.id.push_msg_content);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.push_msg_pic);
        bVar.f61115c = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        bVar.f61116d = view.findViewById(R.id.line);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i) {
        List<d> list = this.f61111f;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f61111f.get(i);
    }

    public View d(d dVar, View view, ViewGroup viewGroup) {
        b b2;
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            b2 = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f61110e).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            b2 = b(view);
            view.setTag(b2);
        }
        if (dVar == null) {
            return view;
        }
        b2.f61113a.setText(dVar.f61120d);
        b2.f61114b.setText(dVar.f61121e);
        b2.f61115c.setDefaultResource(R.drawable.screen_notify_default_bg);
        b2.f61115c.T(dVar.f61122f, 10, 0, 0, false);
        return view;
    }

    public boolean e() {
        return this.f61112g;
    }

    public void f(boolean z) {
        this.f61112g = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f61111f;
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
        return d(this.f61111f.get(i), view, viewGroup);
    }
}
