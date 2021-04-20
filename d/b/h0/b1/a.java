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
    public Context f50201e;

    /* renamed from: f  reason: collision with root package name */
    public int f50202f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f50203g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f50204h = new ArrayList();
    public List<String> i = new ArrayList();

    /* renamed from: d.b.h0.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1059a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f50205a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50206b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f50207c;

        public C1059a(a aVar, View view) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f50205a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f50206b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f50207c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f50208a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50209b;

        public b(a aVar, View view) {
            this.f50208a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f50209b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    public a(Context context) {
        this.f50201e = context;
    }

    public void a(C1059a c1059a) {
        if (c1059a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1059a.f50206b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1059a.f50207c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f50208a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f50209b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        this.f50204h.clear();
        this.i.clear();
        if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            this.f50204h.addAll(list);
            this.i.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        this.f50203g.clear();
        if (!ListUtils.isEmpty(list)) {
            this.f50203g.addAll(list);
        }
        c(list2, list3);
    }

    public void e(int i) {
        this.f50202f = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f50204h)) {
            return 0;
        }
        return this.f50204h.size();
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
        int i2 = this.f50202f;
        if (i2 == 0) {
            view = LayoutInflater.from(this.f50201e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
            b bVar = new b(this, view);
            if (!ListUtils.isEmpty(this.f50204h) && this.f50204h.size() > i && !TextUtils.isEmpty(this.f50204h.get(i))) {
                bVar.f50208a.setText(this.f50204h.get(i));
                bVar.f50208a.setVisibility(0);
            } else {
                bVar.f50208a.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.i) && this.i.size() > i && !TextUtils.isEmpty(this.i.get(i))) {
                bVar.f50209b.setText(this.i.get(i));
                bVar.f50209b.setVisibility(0);
            } else {
                bVar.f50209b.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            b(bVar);
        } else if (i2 == 1) {
            view = LayoutInflater.from(this.f50201e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C1059a c1059a = new C1059a(this, view);
            if (!ListUtils.isEmpty(this.f50203g) && this.f50203g.size() > i && !TextUtils.isEmpty(this.f50203g.get(i))) {
                c1059a.f50205a.setDefaultResource(R.drawable.transparent_bg);
                c1059a.f50205a.W(this.f50203g.get(i), 10, false);
            }
            if (!ListUtils.isEmpty(this.f50204h) && this.f50204h.size() > i && !TextUtils.isEmpty(this.f50204h.get(i))) {
                c1059a.f50206b.setText(this.f50204h.get(i));
                c1059a.f50206b.setVisibility(0);
            } else {
                c1059a.f50206b.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.i) && this.i.size() > i && !TextUtils.isEmpty(this.i.get(i))) {
                c1059a.f50207c.setText(this.i.get(i));
                c1059a.f50207c.setVisibility(0);
            } else {
                c1059a.f50207c.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c1059a);
        }
        return view;
    }
}
