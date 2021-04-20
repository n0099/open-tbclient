package d.b.i0.h1.a;

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
    public LabelSettingView f56451e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.h1.b.b f56452f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.i0.h1.b.a> f56453g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f56454h = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f56455e;

        public a(int i) {
            this.f56455e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.h1.b.a item = b.this.getItem(this.f56455e);
            if (item == null) {
                return;
            }
            item.f56460c = !item.f56460c;
            if (view instanceof TextView) {
                b.this.d((TextView) view, item);
            }
            if (item.f56460c) {
                b.this.f56454h.add(Integer.valueOf(item.f56458a));
            } else {
                b.this.f56454h.remove(Integer.valueOf(item.f56458a));
            }
            if (b.this.f56451e != null) {
                b.this.f56451e.d(ListUtils.getCount(b.this.f56454h) > 0);
            }
        }
    }

    /* renamed from: d.b.i0.h1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1318b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56457a;

        public C1318b(b bVar) {
        }
    }

    public b(LabelSettingView labelSettingView) {
        this.f56451e = labelSettingView;
    }

    public final void d(TextView textView, d.b.i0.h1.b.a aVar) {
        Drawable drawable;
        if (aVar == null) {
            return;
        }
        String str = aVar.f56459b;
        if (!StringUtils.isNull(str) && aVar.f56459b.length() > 4) {
            str = aVar.f56459b.substring(0, 3) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        if (aVar.f56460c) {
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
    public d.b.i0.h1.b.a getItem(int i) {
        return (d.b.i0.h1.b.a) ListUtils.getItem(this.f56453g, i);
    }

    public List<Integer> f() {
        d.b.i0.h1.b.b bVar = this.f56452f;
        return bVar == null ? new ArrayList() : bVar.a();
    }

    public List<Integer> g() {
        return this.f56454h;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f56453g);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        d.b.i0.h1.b.a item = getItem(i);
        if (item == null) {
            return 0L;
        }
        return item.f56458a;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1318b c1318b;
        if (view == null) {
            view = LayoutInflater.from(this.f56451e.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            c1318b = new C1318b(this);
            c1318b.f56457a = (TextView) view;
            view.setTag(c1318b);
        } else {
            c1318b = (C1318b) view.getTag();
        }
        c1318b.f56457a.setOnClickListener(new a(i));
        d(c1318b.f56457a, getItem(i));
        return view;
    }

    public void h(d.b.i0.h1.b.b bVar) {
        if (bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f56452f = bVar;
        this.f56453g = bVar.b();
        if (ListUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f56454h = new ArrayList(bVar.a());
    }
}
