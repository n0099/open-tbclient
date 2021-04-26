package d.a.j0.d2.g.d;

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
import d.a.j0.d2.l.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.j0.d2.l.b.d> f51945e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f51946f;

    /* renamed from: g  reason: collision with root package name */
    public int f51947g;

    /* renamed from: h  reason: collision with root package name */
    public int f51948h;

    /* renamed from: d.a.j0.d2.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1162a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f51949a;
    }

    public a(Context context) {
        this.f51947g = 0;
        this.f51948h = 0;
        this.f51946f = context;
        this.f51947g = l.k(context) - (((int) context.getResources().getDimension(R.dimen.ds30)) * 2);
        this.f51948h = context.getResources().getDimensionPixelSize(R.dimen.ds32);
    }

    public final View a(int i2, View view) {
        C1162a c1162a;
        if (view != null && (view.getTag() instanceof C1162a)) {
            c1162a = (C1162a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f51946f).inflate(R.layout.chosen_pb_image_item, (ViewGroup) null);
            c1162a = new C1162a();
            c1162a.f51949a = (TbImageView) view.findViewById(R.id.pb_chosen_list_image);
            view.setTag(c1162a);
        }
        d.a.j0.d2.l.b.d item = getItem(i2);
        if (item instanceof d.a.j0.d2.l.b.e) {
            d.a.j0.d2.l.b.e eVar = (d.a.j0.d2.l.b.e) item;
            if (!StringUtils.isNull(eVar.f52757i) && !"1".equals(eVar.f52757i)) {
                c1162a.f51949a.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = c1162a.f51949a.getLayoutParams();
                int i3 = this.f51947g;
                int c2 = eVar.c(i3);
                if (layoutParams == null) {
                    layoutParams = new AbsListView.LayoutParams(i3, c2);
                } else {
                    layoutParams.height = c2;
                    layoutParams.width = i3;
                }
                c1162a.f51949a.setLayoutParams(layoutParams);
                c1162a.f51949a.V(eVar.d(), 17, false);
            } else {
                c1162a.f51949a.setVisibility(8);
            }
        }
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public d.a.j0.d2.l.b.d getItem(int i2) {
        List<d.a.j0.d2.l.b.d> list = this.f51945e;
        if (list != null && list.size() > 0) {
            int size = this.f51945e.size();
            if (i2 >= 0 && i2 < size) {
                return this.f51945e.get(i2);
            }
        }
        return null;
    }

    public final View c(int i2, View view) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = new TextView(this.f51946f);
            textView.setTextSize(0, this.f51946f.getResources().getDimensionPixelSize(R.dimen.fontsize32));
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            int i3 = this.f51948h;
            textView.setPadding(i3, 0, i3, 0);
        }
        d.a.j0.d2.l.b.d item = getItem(i2);
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

    public void d(List<d.a.j0.d2.l.b.d> list) {
        this.f51945e.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f51945e.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.j0.d2.l.b.d> list = this.f51945e;
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
        List<d.a.j0.d2.l.b.d> list = this.f51945e;
        if (list != null && list.size() > 0) {
            if (i2 >= 0 && i2 < this.f51945e.size()) {
                d.a.j0.d2.l.b.d dVar = this.f51945e.get(i2);
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
