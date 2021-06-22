package d.a.o0.v2;

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
    public Context f66161e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66163g = true;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f66162f = new ArrayList();

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f66164a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f66165b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f66166c;

        /* renamed from: d  reason: collision with root package name */
        public View f66167d;

        public b(c cVar) {
        }
    }

    public c(Context context) {
        this.f66161e = context;
    }

    public void a(List<d> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f66162f.addAll(list);
        notifyDataSetChanged();
    }

    public final b b(View view) {
        b bVar = new b();
        bVar.f66164a = (TextView) view.findViewById(R.id.push_msg_title);
        bVar.f66165b = (TextView) view.findViewById(R.id.push_msg_content);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.push_msg_pic);
        bVar.f66166c = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        bVar.f66167d = view.findViewById(R.id.line);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        List<d> list = this.f66162f;
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return this.f66162f.get(i2);
    }

    public View d(d dVar, View view, ViewGroup viewGroup) {
        b b2;
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            b2 = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f66161e).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            b2 = b(view);
            view.setTag(b2);
        }
        if (dVar == null) {
            return view;
        }
        b2.f66164a.setText(dVar.f66171d);
        b2.f66165b.setText(dVar.f66172e);
        b2.f66166c.setDefaultResource(R.drawable.screen_notify_default_bg);
        b2.f66166c.R(dVar.f66173f, 10, 0, 0, false);
        return view;
    }

    public boolean e() {
        return this.f66163g;
    }

    public void f(boolean z) {
        this.f66163g = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f66162f;
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
        return d(this.f66162f.get(i2), view, viewGroup);
    }
}
