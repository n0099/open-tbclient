package d.b.h0.b1;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f49808e;

    /* renamed from: f  reason: collision with root package name */
    public int f49809f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f49810g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f49811h = new ArrayList();
    public List<String> i = new ArrayList();

    /* renamed from: d.b.h0.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1047a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f49812a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49813b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f49814c;

        public C1047a(a aVar, View view) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f49812a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f49813b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f49814c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f49815a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49816b;

        public b(a aVar, View view) {
            this.f49815a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f49816b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    public a(Context context) {
        this.f49808e = context;
    }

    public void a(C1047a c1047a) {
        if (c1047a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1047a.f49813b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1047a.f49814c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f49815a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f49816b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        this.f49811h.clear();
        this.i.clear();
        if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            this.f49811h.addAll(list);
            this.i.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        this.f49810g.clear();
        if (!ListUtils.isEmpty(list)) {
            this.f49810g.addAll(list);
        }
        c(list2, list3);
    }

    public void e(int i) {
        this.f49809f = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f49811h)) {
            return 0;
        }
        return this.f49811h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = this.f49809f;
        if (i2 == 0) {
            view = LayoutInflater.from(this.f49808e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
            b bVar = new b(this, view);
            if (!ListUtils.isEmpty(this.f49811h) && this.f49811h.size() > i && !TextUtils.isEmpty(this.f49811h.get(i))) {
                bVar.f49815a.setText(this.f49811h.get(i));
                bVar.f49815a.setVisibility(0);
            } else {
                bVar.f49815a.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.i) && this.i.size() > i && !TextUtils.isEmpty(this.i.get(i))) {
                bVar.f49816b.setText(this.i.get(i));
                bVar.f49816b.setVisibility(0);
            } else {
                bVar.f49816b.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            b(bVar);
        } else if (i2 == 1) {
            view = LayoutInflater.from(this.f49808e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C1047a c1047a = new C1047a(this, view);
            if (!ListUtils.isEmpty(this.f49810g) && this.f49810g.size() > i && !TextUtils.isEmpty(this.f49810g.get(i))) {
                c1047a.f49812a.setDefaultResource(R.drawable.transparent_bg);
                c1047a.f49812a.W(this.f49810g.get(i), 10, false);
            }
            if (!ListUtils.isEmpty(this.f49811h) && this.f49811h.size() > i && !TextUtils.isEmpty(this.f49811h.get(i))) {
                c1047a.f49813b.setText(this.f49811h.get(i));
                c1047a.f49813b.setVisibility(0);
            } else {
                c1047a.f49813b.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.i) && this.i.size() > i && !TextUtils.isEmpty(this.i.get(i))) {
                c1047a.f49814c.setText(this.i.get(i));
                c1047a.f49814c.setVisibility(0);
            } else {
                c1047a.f49814c.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c1047a);
        }
        return view;
    }
}
