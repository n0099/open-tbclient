package d.a.j0.h1.a;

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
    public LabelSettingView f54782e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.h1.b.b f54783f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.j0.h1.b.a> f54784g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f54785h = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f54786e;

        public a(int i2) {
            this.f54786e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.j0.h1.b.a item = b.this.getItem(this.f54786e);
            if (item == null) {
                return;
            }
            item.f54791c = !item.f54791c;
            if (view instanceof TextView) {
                b.this.d((TextView) view, item);
            }
            if (item.f54791c) {
                b.this.f54785h.add(Integer.valueOf(item.f54789a));
            } else {
                b.this.f54785h.remove(Integer.valueOf(item.f54789a));
            }
            if (b.this.f54782e != null) {
                b.this.f54782e.d(ListUtils.getCount(b.this.f54785h) > 0);
            }
        }
    }

    /* renamed from: d.a.j0.h1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1280b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f54788a;

        public C1280b(b bVar) {
        }
    }

    public b(LabelSettingView labelSettingView) {
        this.f54782e = labelSettingView;
    }

    public final void d(TextView textView, d.a.j0.h1.b.a aVar) {
        Drawable drawable;
        if (aVar == null) {
            return;
        }
        String str = aVar.f54790b;
        if (!StringUtils.isNull(str) && aVar.f54790b.length() > 4) {
            str = aVar.f54790b.substring(0, 3) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        if (aVar.f54791c) {
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
    public d.a.j0.h1.b.a getItem(int i2) {
        return (d.a.j0.h1.b.a) ListUtils.getItem(this.f54784g, i2);
    }

    public List<Integer> f() {
        d.a.j0.h1.b.b bVar = this.f54783f;
        return bVar == null ? new ArrayList() : bVar.a();
    }

    public List<Integer> g() {
        return this.f54785h;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f54784g);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        d.a.j0.h1.b.a item = getItem(i2);
        if (item == null) {
            return 0L;
        }
        return item.f54789a;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1280b c1280b;
        if (view == null) {
            view = LayoutInflater.from(this.f54782e.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            c1280b = new C1280b(this);
            c1280b.f54788a = (TextView) view;
            view.setTag(c1280b);
        } else {
            c1280b = (C1280b) view.getTag();
        }
        c1280b.f54788a.setOnClickListener(new a(i2));
        d(c1280b.f54788a, getItem(i2));
        return view;
    }

    public void h(d.a.j0.h1.b.b bVar) {
        if (bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f54783f = bVar;
        this.f54784g = bVar.b();
        if (ListUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f54785h = new ArrayList(bVar.a());
    }
}
