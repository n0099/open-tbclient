package d.a.n0.i1.a;

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
    public LabelSettingView f55677e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.i1.b.b f55678f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.n0.i1.b.a> f55679g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f55680h = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f55681e;

        public a(int i2) {
            this.f55681e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.i1.b.a item = b.this.getItem(this.f55681e);
            if (item == null) {
                return;
            }
            item.f55686c = !item.f55686c;
            if (view instanceof TextView) {
                b.this.d((TextView) view, item);
            }
            if (item.f55686c) {
                b.this.f55680h.add(Integer.valueOf(item.f55684a));
            } else {
                b.this.f55680h.remove(Integer.valueOf(item.f55684a));
            }
            if (b.this.f55677e != null) {
                b.this.f55677e.d(ListUtils.getCount(b.this.f55680h) > 0);
            }
        }
    }

    /* renamed from: d.a.n0.i1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1370b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f55683a;

        public C1370b(b bVar) {
        }
    }

    public b(LabelSettingView labelSettingView) {
        this.f55677e = labelSettingView;
    }

    public final void d(TextView textView, d.a.n0.i1.b.a aVar) {
        Drawable drawable;
        if (aVar == null) {
            return;
        }
        String str = aVar.f55685b;
        if (!StringUtils.isNull(str) && aVar.f55685b.length() > 4) {
            str = aVar.f55685b.substring(0, 3) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        if (aVar.f55686c) {
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
    public d.a.n0.i1.b.a getItem(int i2) {
        return (d.a.n0.i1.b.a) ListUtils.getItem(this.f55679g, i2);
    }

    public List<Integer> f() {
        d.a.n0.i1.b.b bVar = this.f55678f;
        return bVar == null ? new ArrayList() : bVar.a();
    }

    public List<Integer> g() {
        return this.f55680h;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f55679g);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        d.a.n0.i1.b.a item = getItem(i2);
        if (item == null) {
            return 0L;
        }
        return item.f55684a;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1370b c1370b;
        if (view == null) {
            view = LayoutInflater.from(this.f55677e.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            c1370b = new C1370b(this);
            c1370b.f55683a = (TextView) view;
            view.setTag(c1370b);
        } else {
            c1370b = (C1370b) view.getTag();
        }
        c1370b.f55683a.setOnClickListener(new a(i2));
        d(c1370b.f55683a, getItem(i2));
        return view;
    }

    public void h(d.a.n0.i1.b.b bVar) {
        if (bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f55678f = bVar;
        this.f55679g = bVar.b();
        if (ListUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f55680h = new ArrayList(bVar.a());
    }
}
