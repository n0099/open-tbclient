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
    public Context f52619e;

    /* renamed from: f  reason: collision with root package name */
    public int f52620f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f52621g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f52622h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<String> f52623i = new ArrayList();

    /* renamed from: d.a.m0.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1159a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f52624a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52625b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f52626c;

        public C1159a(a aVar, View view) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f52624a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f52625b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f52626c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f52627a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52628b;

        public b(a aVar, View view) {
            this.f52627a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f52628b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    public a(Context context) {
        this.f52619e = context;
    }

    public void a(C1159a c1159a) {
        if (c1159a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1159a.f52625b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1159a.f52626c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f52627a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f52628b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        this.f52622h.clear();
        this.f52623i.clear();
        if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            this.f52622h.addAll(list);
            this.f52623i.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        this.f52621g.clear();
        if (!ListUtils.isEmpty(list)) {
            this.f52621g.addAll(list);
        }
        c(list2, list3);
    }

    public void e(int i2) {
        this.f52620f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f52622h)) {
            return 0;
        }
        return this.f52622h.size();
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
        int i3 = this.f52620f;
        if (i3 == 0) {
            view = LayoutInflater.from(this.f52619e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
            b bVar = new b(this, view);
            if (!ListUtils.isEmpty(this.f52622h) && this.f52622h.size() > i2 && !TextUtils.isEmpty(this.f52622h.get(i2))) {
                bVar.f52627a.setText(this.f52622h.get(i2));
                bVar.f52627a.setVisibility(0);
            } else {
                bVar.f52627a.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.f52623i) && this.f52623i.size() > i2 && !TextUtils.isEmpty(this.f52623i.get(i2))) {
                bVar.f52628b.setText(this.f52623i.get(i2));
                bVar.f52628b.setVisibility(0);
            } else {
                bVar.f52628b.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            b(bVar);
        } else if (i3 == 1) {
            view = LayoutInflater.from(this.f52619e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C1159a c1159a = new C1159a(this, view);
            if (!ListUtils.isEmpty(this.f52621g) && this.f52621g.size() > i2 && !TextUtils.isEmpty(this.f52621g.get(i2))) {
                c1159a.f52624a.setDefaultResource(R.drawable.transparent_bg);
                c1159a.f52624a.U(this.f52621g.get(i2), 10, false);
            }
            if (!ListUtils.isEmpty(this.f52622h) && this.f52622h.size() > i2 && !TextUtils.isEmpty(this.f52622h.get(i2))) {
                c1159a.f52625b.setText(this.f52622h.get(i2));
                c1159a.f52625b.setVisibility(0);
            } else {
                c1159a.f52625b.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.f52623i) && this.f52623i.size() > i2 && !TextUtils.isEmpty(this.f52623i.get(i2))) {
                c1159a.f52626c.setText(this.f52623i.get(i2));
                c1159a.f52626c.setVisibility(0);
            } else {
                c1159a.f52626c.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c1159a);
        }
        return view;
    }
}
