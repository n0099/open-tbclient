package d.a.j0.b1;

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
    public Context f48920e;

    /* renamed from: f  reason: collision with root package name */
    public int f48921f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f48922g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f48923h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<String> f48924i = new ArrayList();

    /* renamed from: d.a.j0.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1096a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f48925a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f48926b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f48927c;

        public C1096a(a aVar, View view) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f48925a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f48926b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f48927c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f48928a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f48929b;

        public b(a aVar, View view) {
            this.f48928a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f48929b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    public a(Context context) {
        this.f48920e = context;
    }

    public void a(C1096a c1096a) {
        if (c1096a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1096a.f48926b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1096a.f48927c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f48928a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f48929b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        this.f48923h.clear();
        this.f48924i.clear();
        if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            this.f48923h.addAll(list);
            this.f48924i.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        this.f48922g.clear();
        if (!ListUtils.isEmpty(list)) {
            this.f48922g.addAll(list);
        }
        c(list2, list3);
    }

    public void e(int i2) {
        this.f48921f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f48923h)) {
            return 0;
        }
        return this.f48923h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return super.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int i3 = this.f48921f;
        if (i3 == 0) {
            view = LayoutInflater.from(this.f48920e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
            b bVar = new b(this, view);
            if (!ListUtils.isEmpty(this.f48923h) && this.f48923h.size() > i2 && !TextUtils.isEmpty(this.f48923h.get(i2))) {
                bVar.f48928a.setText(this.f48923h.get(i2));
                bVar.f48928a.setVisibility(0);
            } else {
                bVar.f48928a.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.f48924i) && this.f48924i.size() > i2 && !TextUtils.isEmpty(this.f48924i.get(i2))) {
                bVar.f48929b.setText(this.f48924i.get(i2));
                bVar.f48929b.setVisibility(0);
            } else {
                bVar.f48929b.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            b(bVar);
        } else if (i3 == 1) {
            view = LayoutInflater.from(this.f48920e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C1096a c1096a = new C1096a(this, view);
            if (!ListUtils.isEmpty(this.f48922g) && this.f48922g.size() > i2 && !TextUtils.isEmpty(this.f48922g.get(i2))) {
                c1096a.f48925a.setDefaultResource(R.drawable.transparent_bg);
                c1096a.f48925a.V(this.f48922g.get(i2), 10, false);
            }
            if (!ListUtils.isEmpty(this.f48923h) && this.f48923h.size() > i2 && !TextUtils.isEmpty(this.f48923h.get(i2))) {
                c1096a.f48926b.setText(this.f48923h.get(i2));
                c1096a.f48926b.setVisibility(0);
            } else {
                c1096a.f48926b.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.f48924i) && this.f48924i.size() > i2 && !TextUtils.isEmpty(this.f48924i.get(i2))) {
                c1096a.f48927c.setText(this.f48924i.get(i2));
                c1096a.f48927c.setVisibility(0);
            } else {
                c1096a.f48927c.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c1096a);
        }
        return view;
    }
}
