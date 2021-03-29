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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public LabelSettingView f54915e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.g1.b.b f54916f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.i0.g1.b.a> f54917g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f54918h = new ArrayList();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f54919e;

        public a(int i) {
            this.f54919e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.g1.b.a item = b.this.getItem(this.f54919e);
            if (item == null) {
                return;
            }
            item.f54924c = !item.f54924c;
            if (view instanceof TextView) {
                b.this.d((TextView) view, item);
            }
            if (item.f54924c) {
                b.this.f54918h.add(Integer.valueOf(item.f54922a));
            } else {
                b.this.f54918h.remove(Integer.valueOf(item.f54922a));
            }
            if (b.this.f54915e != null) {
                b.this.f54915e.d(ListUtils.getCount(b.this.f54918h) > 0);
            }
        }
    }

    /* renamed from: d.b.i0.g1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1257b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f54921a;

        public C1257b(b bVar) {
        }
    }

    public b(LabelSettingView labelSettingView) {
        this.f54915e = labelSettingView;
    }

    public final void d(TextView textView, d.b.i0.g1.b.a aVar) {
        Drawable drawable;
        if (aVar == null) {
            return;
        }
        String str = aVar.f54923b;
        if (!StringUtils.isNull(str) && aVar.f54923b.length() > 4) {
            str = aVar.f54923b.substring(0, 3) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        if (aVar.f54924c) {
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
        return (d.b.i0.g1.b.a) ListUtils.getItem(this.f54917g, i);
    }

    public List<Integer> f() {
        d.b.i0.g1.b.b bVar = this.f54916f;
        return bVar == null ? new ArrayList() : bVar.a();
    }

    public List<Integer> g() {
        return this.f54918h;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f54917g);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        d.b.i0.g1.b.a item = getItem(i);
        if (item == null) {
            return 0L;
        }
        return item.f54922a;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1257b c1257b;
        if (view == null) {
            view = LayoutInflater.from(this.f54915e.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            c1257b = new C1257b(this);
            c1257b.f54921a = (TextView) view;
            view.setTag(c1257b);
        } else {
            c1257b = (C1257b) view.getTag();
        }
        c1257b.f54921a.setOnClickListener(new a(i));
        d(c1257b.f54921a, getItem(i));
        return view;
    }

    public void h(d.b.i0.g1.b.b bVar) {
        if (bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f54916f = bVar;
        this.f54917g = bVar.b();
        if (ListUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f54918h = new ArrayList(bVar.a());
    }
}
