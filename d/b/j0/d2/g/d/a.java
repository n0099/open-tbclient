package d.b.j0.d2.g.d;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.j0.d2.l.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.j0.d2.l.b.d> f54168e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f54169f;

    /* renamed from: g  reason: collision with root package name */
    public int f54170g;

    /* renamed from: h  reason: collision with root package name */
    public int f54171h;

    /* renamed from: d.b.j0.d2.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1223a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f54172a;
    }

    public a(Context context) {
        this.f54170g = 0;
        this.f54171h = 0;
        this.f54169f = context;
        this.f54170g = l.k(context) - (((int) context.getResources().getDimension(R.dimen.ds30)) * 2);
        this.f54171h = context.getResources().getDimensionPixelSize(R.dimen.ds32);
    }

    public final View a(int i, View view) {
        C1223a c1223a;
        if (view != null && (view.getTag() instanceof C1223a)) {
            c1223a = (C1223a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f54169f).inflate(R.layout.chosen_pb_image_item, (ViewGroup) null);
            c1223a = new C1223a();
            c1223a.f54172a = (TbImageView) view.findViewById(R.id.pb_chosen_list_image);
            view.setTag(c1223a);
        }
        d.b.j0.d2.l.b.d item = getItem(i);
        if (item instanceof d.b.j0.d2.l.b.e) {
            d.b.j0.d2.l.b.e eVar = (d.b.j0.d2.l.b.e) item;
            if (!StringUtils.isNull(eVar.i) && !"1".equals(eVar.i)) {
                c1223a.f54172a.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = c1223a.f54172a.getLayoutParams();
                int i2 = this.f54170g;
                int c2 = eVar.c(i2);
                if (layoutParams == null) {
                    layoutParams = new AbsListView.LayoutParams(i2, c2);
                } else {
                    layoutParams.height = c2;
                    layoutParams.width = i2;
                }
                c1223a.f54172a.setLayoutParams(layoutParams);
                c1223a.f54172a.W(eVar.d(), 17, false);
            } else {
                c1223a.f54172a.setVisibility(8);
            }
        }
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public d.b.j0.d2.l.b.d getItem(int i) {
        List<d.b.j0.d2.l.b.d> list = this.f54168e;
        if (list != null && list.size() > 0) {
            int size = this.f54168e.size();
            if (i >= 0 && i < size) {
                return this.f54168e.get(i);
            }
        }
        return null;
    }

    public final View c(int i, View view) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = new TextView(this.f54169f);
            textView.setTextSize(0, this.f54169f.getResources().getDimensionPixelSize(R.dimen.fontsize32));
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            int i2 = this.f54171h;
            textView.setPadding(i2, 0, i2, 0);
        }
        d.b.j0.d2.l.b.d item = getItem(i);
        if (item instanceof g) {
            g gVar = (g) item;
            textView.setText(gVar.b());
            int d2 = gVar.d();
            if (d2 == 1) {
                textView.setGravity(17);
            } else if (d2 != 2) {
                textView.setGravity(3);
            } else {
                textView.setGravity(5);
            }
            if (!StringUtils.isNull(gVar.e())) {
                if (!SkinManager.setViewTextColor(textView, gVar.e())) {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                }
            } else {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
            }
            if (gVar.f() > 0) {
                textView.setTextSize(0, gVar.f());
            }
        }
        return textView;
    }

    public void d(List<d.b.j0.d2.l.b.d> list) {
        this.f54168e.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f54168e.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.j0.d2.l.b.d> list = this.f54168e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        List<d.b.j0.d2.l.b.d> list = this.f54168e;
        if (list != null && list.size() > 0) {
            if (i >= 0 && i < this.f54168e.size()) {
                d.b.j0.d2.l.b.d dVar = this.f54168e.get(i);
                if (dVar == null) {
                    return super.getItemViewType(i);
                }
                if (dVar.getType() == 0) {
                    return 0;
                }
                if (dVar.getType() == 3) {
                    return 1;
                }
                return super.getItemViewType(i);
            }
            return super.getItemViewType(i);
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return c(i, view);
        }
        if (itemViewType == 1) {
            return a(i, view);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
