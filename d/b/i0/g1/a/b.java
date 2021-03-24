package d.b.i0.g1.a;

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
    public LabelSettingView f54914e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.g1.b.b f54915f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.i0.g1.b.a> f54916g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f54917h = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f54918e;

        public a(int i) {
            this.f54918e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.g1.b.a item = b.this.getItem(this.f54918e);
            if (item == null) {
                return;
            }
            item.f54923c = !item.f54923c;
            if (view instanceof TextView) {
                b.this.d((TextView) view, item);
            }
            if (item.f54923c) {
                b.this.f54917h.add(Integer.valueOf(item.f54921a));
            } else {
                b.this.f54917h.remove(Integer.valueOf(item.f54921a));
            }
            if (b.this.f54914e != null) {
                b.this.f54914e.d(ListUtils.getCount(b.this.f54917h) > 0);
            }
        }
    }

    /* renamed from: d.b.i0.g1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1256b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f54920a;

        public C1256b(b bVar) {
        }
    }

    public b(LabelSettingView labelSettingView) {
        this.f54914e = labelSettingView;
    }

    public final void d(TextView textView, d.b.i0.g1.b.a aVar) {
        Drawable drawable;
        if (aVar == null) {
            return;
        }
        String str = aVar.f54922b;
        if (!StringUtils.isNull(str) && aVar.f54922b.length() > 4) {
            str = aVar.f54922b.substring(0, 3) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        if (aVar.f54923c) {
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
    public d.b.i0.g1.b.a getItem(int i) {
        return (d.b.i0.g1.b.a) ListUtils.getItem(this.f54916g, i);
    }

    public List<Integer> f() {
        d.b.i0.g1.b.b bVar = this.f54915f;
        return bVar == null ? new ArrayList() : bVar.a();
    }

    public List<Integer> g() {
        return this.f54917h;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f54916g);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        d.b.i0.g1.b.a item = getItem(i);
        if (item == null) {
            return 0L;
        }
        return item.f54921a;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1256b c1256b;
        if (view == null) {
            view = LayoutInflater.from(this.f54914e.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            c1256b = new C1256b(this);
            c1256b.f54920a = (TextView) view;
            view.setTag(c1256b);
        } else {
            c1256b = (C1256b) view.getTag();
        }
        c1256b.f54920a.setOnClickListener(new a(i));
        d(c1256b.f54920a, getItem(i));
        return view;
    }

    public void h(d.b.i0.g1.b.b bVar) {
        if (bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f54915f = bVar;
        this.f54916g = bVar.b();
        if (ListUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f54917h = new ArrayList(bVar.a());
    }
}
