package d.b.j0.h1.a;

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
    public LabelSettingView f56872e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.h1.b.b f56873f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.j0.h1.b.a> f56874g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f56875h = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f56876e;

        public a(int i) {
            this.f56876e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.j0.h1.b.a item = b.this.getItem(this.f56876e);
            if (item == null) {
                return;
            }
            item.f56881c = !item.f56881c;
            if (view instanceof TextView) {
                b.this.d((TextView) view, item);
            }
            if (item.f56881c) {
                b.this.f56875h.add(Integer.valueOf(item.f56879a));
            } else {
                b.this.f56875h.remove(Integer.valueOf(item.f56879a));
            }
            if (b.this.f56872e != null) {
                b.this.f56872e.d(ListUtils.getCount(b.this.f56875h) > 0);
            }
        }
    }

    /* renamed from: d.b.j0.h1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1341b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56878a;

        public C1341b(b bVar) {
        }
    }

    public b(LabelSettingView labelSettingView) {
        this.f56872e = labelSettingView;
    }

    public final void d(TextView textView, d.b.j0.h1.b.a aVar) {
        Drawable drawable;
        if (aVar == null) {
            return;
        }
        String str = aVar.f56880b;
        if (!StringUtils.isNull(str) && aVar.f56880b.length() > 4) {
            str = aVar.f56880b.substring(0, 3) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        if (aVar.f56881c) {
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
    public d.b.j0.h1.b.a getItem(int i) {
        return (d.b.j0.h1.b.a) ListUtils.getItem(this.f56874g, i);
    }

    public List<Integer> f() {
        d.b.j0.h1.b.b bVar = this.f56873f;
        return bVar == null ? new ArrayList() : bVar.a();
    }

    public List<Integer> g() {
        return this.f56875h;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f56874g);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        d.b.j0.h1.b.a item = getItem(i);
        if (item == null) {
            return 0L;
        }
        return item.f56879a;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1341b c1341b;
        if (view == null) {
            view = LayoutInflater.from(this.f56872e.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            c1341b = new C1341b(this);
            c1341b.f56878a = (TextView) view;
            view.setTag(c1341b);
        } else {
            c1341b = (C1341b) view.getTag();
        }
        c1341b.f56878a.setOnClickListener(new a(i));
        d(c1341b.f56878a, getItem(i));
        return view;
    }

    public void h(d.b.j0.h1.b.b bVar) {
        if (bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f56873f = bVar;
        this.f56874g = bVar.b();
        if (ListUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f56875h = new ArrayList(bVar.a());
    }
}
