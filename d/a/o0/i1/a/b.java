package d.a.o0.i1.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public LabelSettingView f59491e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.i1.b.b f59492f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.o0.i1.b.a> f59493g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f59494h = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f59495e;

        public a(int i2) {
            this.f59495e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.o0.i1.b.a item = b.this.getItem(this.f59495e);
            if (item == null) {
                return;
            }
            item.f59500c = !item.f59500c;
            if (view instanceof TextView) {
                b.this.d((TextView) view, item);
            }
            if (item.f59500c) {
                b.this.f59494h.add(Integer.valueOf(item.f59498a));
            } else {
                b.this.f59494h.remove(Integer.valueOf(item.f59498a));
            }
            if (b.this.f59491e != null) {
                b.this.f59491e.d(ListUtils.getCount(b.this.f59494h) > 0);
            }
        }
    }

    /* renamed from: d.a.o0.i1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1430b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59497a;

        public C1430b(b bVar) {
        }
    }

    public b(LabelSettingView labelSettingView) {
        this.f59491e = labelSettingView;
    }

    public final void d(TextView textView, d.a.o0.i1.b.a aVar) {
        Drawable drawable;
        if (aVar == null) {
            return;
        }
        String str = aVar.f59499b;
        if (!StringUtils.isNull(str) && aVar.f59499b.length() > 4) {
            str = aVar.f59499b.substring(0, 3) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        if (aVar.f59500c) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
            drawable = SkinManager.getDrawable(R.drawable.icon_lable_confirm_s);
        } else {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            drawable = SkinManager.getDrawable(R.drawable.icon_lable_confirm_n);
        }
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public d.a.o0.i1.b.a getItem(int i2) {
        return (d.a.o0.i1.b.a) ListUtils.getItem(this.f59493g, i2);
    }

    public List<Integer> f() {
        d.a.o0.i1.b.b bVar = this.f59492f;
        return bVar == null ? new ArrayList() : bVar.a();
    }

    public List<Integer> g() {
        return this.f59494h;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f59493g);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        d.a.o0.i1.b.a item = getItem(i2);
        if (item == null) {
            return 0L;
        }
        return item.f59498a;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1430b c1430b;
        if (view == null) {
            view = LayoutInflater.from(this.f59491e.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            c1430b = new C1430b(this);
            c1430b.f59497a = (TextView) view;
            view.setTag(c1430b);
        } else {
            c1430b = (C1430b) view.getTag();
        }
        c1430b.f59497a.setOnClickListener(new a(i2));
        d(c1430b.f59497a, getItem(i2));
        return view;
    }

    public void h(d.a.o0.i1.b.b bVar) {
        if (bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f59492f = bVar;
        this.f59493g = bVar.b();
        if (ListUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f59494h = new ArrayList(bVar.a());
    }
}
