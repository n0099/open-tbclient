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
    public Context f49807e;

    /* renamed from: f  reason: collision with root package name */
    public int f49808f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f49809g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f49810h = new ArrayList();
    public List<String> i = new ArrayList();

    /* renamed from: d.b.h0.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1046a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f49811a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49812b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f49813c;

        public C1046a(a aVar, View view) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f49811a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f49812b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f49813c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f49814a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49815b;

        public b(a aVar, View view) {
            this.f49814a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f49815b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    public a(Context context) {
        this.f49807e = context;
    }

    public void a(C1046a c1046a) {
        if (c1046a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1046a.f49812b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1046a.f49813c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f49814a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f49815b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        this.f49810h.clear();
        this.i.clear();
        if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            this.f49810h.addAll(list);
            this.i.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        this.f49809g.clear();
        if (!ListUtils.isEmpty(list)) {
            this.f49809g.addAll(list);
        }
        c(list2, list3);
    }

    public void e(int i) {
        this.f49808f = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f49810h)) {
            return 0;
        }
        return this.f49810h.size();
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
        int i2 = this.f49808f;
        if (i2 == 0) {
            view = LayoutInflater.from(this.f49807e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
            b bVar = new b(this, view);
            if (!ListUtils.isEmpty(this.f49810h) && this.f49810h.size() > i && !TextUtils.isEmpty(this.f49810h.get(i))) {
                bVar.f49814a.setText(this.f49810h.get(i));
                bVar.f49814a.setVisibility(0);
            } else {
                bVar.f49814a.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.i) && this.i.size() > i && !TextUtils.isEmpty(this.i.get(i))) {
                bVar.f49815b.setText(this.i.get(i));
                bVar.f49815b.setVisibility(0);
            } else {
                bVar.f49815b.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            b(bVar);
        } else if (i2 == 1) {
            view = LayoutInflater.from(this.f49807e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C1046a c1046a = new C1046a(this, view);
            if (!ListUtils.isEmpty(this.f49809g) && this.f49809g.size() > i && !TextUtils.isEmpty(this.f49809g.get(i))) {
                c1046a.f49811a.setDefaultResource(R.drawable.transparent_bg);
                c1046a.f49811a.W(this.f49809g.get(i), 10, false);
            }
            if (!ListUtils.isEmpty(this.f49810h) && this.f49810h.size() > i && !TextUtils.isEmpty(this.f49810h.get(i))) {
                c1046a.f49812b.setText(this.f49810h.get(i));
                c1046a.f49812b.setVisibility(0);
            } else {
                c1046a.f49812b.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.i) && this.i.size() > i && !TextUtils.isEmpty(this.i.get(i))) {
                c1046a.f49813c.setText(this.i.get(i));
                c1046a.f49813c.setVisibility(0);
            } else {
                c1046a.f49813c.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c1046a);
        }
        return view;
    }
}
