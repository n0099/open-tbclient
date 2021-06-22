package d.a.o0.e2.g.d;

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
import d.a.c.e.p.l;
import d.a.o0.e2.l.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.o0.e2.l.b.d> f56663e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f56664f;

    /* renamed from: g  reason: collision with root package name */
    public int f56665g;

    /* renamed from: h  reason: collision with root package name */
    public int f56666h;

    /* renamed from: d.a.o0.e2.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1312a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f56667a;
    }

    public a(Context context) {
        this.f56665g = 0;
        this.f56666h = 0;
        this.f56664f = context;
        this.f56665g = l.k(context) - (((int) context.getResources().getDimension(R.dimen.ds30)) * 2);
        this.f56666h = context.getResources().getDimensionPixelSize(R.dimen.ds32);
    }

    public final View a(int i2, View view) {
        C1312a c1312a;
        if (view != null && (view.getTag() instanceof C1312a)) {
            c1312a = (C1312a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f56664f).inflate(R.layout.chosen_pb_image_item, (ViewGroup) null);
            c1312a = new C1312a();
            c1312a.f56667a = (TbImageView) view.findViewById(R.id.pb_chosen_list_image);
            view.setTag(c1312a);
        }
        d.a.o0.e2.l.b.d item = getItem(i2);
        if (item instanceof d.a.o0.e2.l.b.e) {
            d.a.o0.e2.l.b.e eVar = (d.a.o0.e2.l.b.e) item;
            if (!StringUtils.isNull(eVar.f57484i) && !"1".equals(eVar.f57484i)) {
                c1312a.f56667a.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = c1312a.f56667a.getLayoutParams();
                int i3 = this.f56665g;
                int c2 = eVar.c(i3);
                if (layoutParams == null) {
                    layoutParams = new AbsListView.LayoutParams(i3, c2);
                } else {
                    layoutParams.height = c2;
                    layoutParams.width = i3;
                }
                c1312a.f56667a.setLayoutParams(layoutParams);
                c1312a.f56667a.U(eVar.d(), 17, false);
            } else {
                c1312a.f56667a.setVisibility(8);
            }
        }
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public d.a.o0.e2.l.b.d getItem(int i2) {
        List<d.a.o0.e2.l.b.d> list = this.f56663e;
        if (list != null && list.size() > 0) {
            int size = this.f56663e.size();
            if (i2 >= 0 && i2 < size) {
                return this.f56663e.get(i2);
            }
        }
        return null;
    }

    public final View c(int i2, View view) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = new TextView(this.f56664f);
            textView.setTextSize(0, this.f56664f.getResources().getDimensionPixelSize(R.dimen.fontsize32));
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            int i3 = this.f56666h;
            textView.setPadding(i3, 0, i3, 0);
        }
        d.a.o0.e2.l.b.d item = getItem(i2);
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

    public void d(List<d.a.o0.e2.l.b.d> list) {
        this.f56663e.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f56663e.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.o0.e2.l.b.d> list = this.f56663e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        List<d.a.o0.e2.l.b.d> list = this.f56663e;
        if (list != null && list.size() > 0) {
            if (i2 >= 0 && i2 < this.f56663e.size()) {
                d.a.o0.e2.l.b.d dVar = this.f56663e.get(i2);
                if (dVar == null) {
                    return super.getItemViewType(i2);
                }
                if (dVar.getType() == 0) {
                    return 0;
                }
                if (dVar.getType() == 3) {
                    return 1;
                }
                return super.getItemViewType(i2);
            }
            return super.getItemViewType(i2);
        }
        return super.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 0) {
            return c(i2, view);
        }
        if (itemViewType == 1) {
            return a(i2, view);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
