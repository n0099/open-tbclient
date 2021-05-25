package d.a.m0.b1;

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
    public Context f48945e;

    /* renamed from: f  reason: collision with root package name */
    public int f48946f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f48947g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f48948h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<String> f48949i = new ArrayList();

    /* renamed from: d.a.m0.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1103a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f48950a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f48951b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f48952c;

        public C1103a(a aVar, View view) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f48950a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f48951b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f48952c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f48953a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f48954b;

        public b(a aVar, View view) {
            this.f48953a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f48954b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    public a(Context context) {
        this.f48945e = context;
    }

    public void a(C1103a c1103a) {
        if (c1103a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1103a.f48951b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1103a.f48952c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f48953a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f48954b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        this.f48948h.clear();
        this.f48949i.clear();
        if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            this.f48948h.addAll(list);
            this.f48949i.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        this.f48947g.clear();
        if (!ListUtils.isEmpty(list)) {
            this.f48947g.addAll(list);
        }
        c(list2, list3);
    }

    public void e(int i2) {
        this.f48946f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f48948h)) {
            return 0;
        }
        return this.f48948h.size();
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
        int i3 = this.f48946f;
        if (i3 == 0) {
            view = LayoutInflater.from(this.f48945e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
            b bVar = new b(this, view);
            if (!ListUtils.isEmpty(this.f48948h) && this.f48948h.size() > i2 && !TextUtils.isEmpty(this.f48948h.get(i2))) {
                bVar.f48953a.setText(this.f48948h.get(i2));
                bVar.f48953a.setVisibility(0);
            } else {
                bVar.f48953a.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.f48949i) && this.f48949i.size() > i2 && !TextUtils.isEmpty(this.f48949i.get(i2))) {
                bVar.f48954b.setText(this.f48949i.get(i2));
                bVar.f48954b.setVisibility(0);
            } else {
                bVar.f48954b.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            b(bVar);
        } else if (i3 == 1) {
            view = LayoutInflater.from(this.f48945e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C1103a c1103a = new C1103a(this, view);
            if (!ListUtils.isEmpty(this.f48947g) && this.f48947g.size() > i2 && !TextUtils.isEmpty(this.f48947g.get(i2))) {
                c1103a.f48950a.setDefaultResource(R.drawable.transparent_bg);
                c1103a.f48950a.V(this.f48947g.get(i2), 10, false);
            }
            if (!ListUtils.isEmpty(this.f48948h) && this.f48948h.size() > i2 && !TextUtils.isEmpty(this.f48948h.get(i2))) {
                c1103a.f48951b.setText(this.f48948h.get(i2));
                c1103a.f48951b.setVisibility(0);
            } else {
                c1103a.f48951b.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.f48949i) && this.f48949i.size() > i2 && !TextUtils.isEmpty(this.f48949i.get(i2))) {
                c1103a.f48952c.setText(this.f48949i.get(i2));
                c1103a.f48952c.setVisibility(0);
            } else {
                c1103a.f48952c.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c1103a);
        }
        return view;
    }
}
