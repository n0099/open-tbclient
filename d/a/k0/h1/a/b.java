package d.a.k0.h1.a;

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
    public LabelSettingView f55489e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.h1.b.b f55490f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.k0.h1.b.a> f55491g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f55492h = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f55493e;

        public a(int i2) {
            this.f55493e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.k0.h1.b.a item = b.this.getItem(this.f55493e);
            if (item == null) {
                return;
            }
            item.f55498c = !item.f55498c;
            if (view instanceof TextView) {
                b.this.d((TextView) view, item);
            }
            if (item.f55498c) {
                b.this.f55492h.add(Integer.valueOf(item.f55496a));
            } else {
                b.this.f55492h.remove(Integer.valueOf(item.f55496a));
            }
            if (b.this.f55489e != null) {
                b.this.f55489e.d(ListUtils.getCount(b.this.f55492h) > 0);
            }
        }
    }

    /* renamed from: d.a.k0.h1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1352b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f55495a;

        public C1352b(b bVar) {
        }
    }

    public b(LabelSettingView labelSettingView) {
        this.f55489e = labelSettingView;
    }

    public final void d(TextView textView, d.a.k0.h1.b.a aVar) {
        Drawable drawable;
        if (aVar == null) {
            return;
        }
        String str = aVar.f55497b;
        if (!StringUtils.isNull(str) && aVar.f55497b.length() > 4) {
            str = aVar.f55497b.substring(0, 3) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        if (aVar.f55498c) {
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
    public d.a.k0.h1.b.a getItem(int i2) {
        return (d.a.k0.h1.b.a) ListUtils.getItem(this.f55491g, i2);
    }

    public List<Integer> f() {
        d.a.k0.h1.b.b bVar = this.f55490f;
        return bVar == null ? new ArrayList() : bVar.a();
    }

    public List<Integer> g() {
        return this.f55492h;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f55491g);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        d.a.k0.h1.b.a item = getItem(i2);
        if (item == null) {
            return 0L;
        }
        return item.f55496a;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1352b c1352b;
        if (view == null) {
            view = LayoutInflater.from(this.f55489e.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            c1352b = new C1352b(this);
            c1352b.f55495a = (TextView) view;
            view.setTag(c1352b);
        } else {
            c1352b = (C1352b) view.getTag();
        }
        c1352b.f55495a.setOnClickListener(new a(i2));
        d(c1352b.f55495a, getItem(i2));
        return view;
    }

    public void h(d.a.k0.h1.b.b bVar) {
        if (bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f55490f = bVar;
        this.f55491g = bVar.b();
        if (ListUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f55492h = new ArrayList(bVar.a());
    }
}
