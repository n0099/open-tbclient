package d.a.n0.b1;

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
    public Context f52726e;

    /* renamed from: f  reason: collision with root package name */
    public int f52727f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f52728g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f52729h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<String> f52730i = new ArrayList();

    /* renamed from: d.a.n0.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1162a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f52731a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52732b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f52733c;

        public C1162a(a aVar, View view) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f52731a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f52732b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f52733c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f52734a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52735b;

        public b(a aVar, View view) {
            this.f52734a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f52735b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    public a(Context context) {
        this.f52726e = context;
    }

    public void a(C1162a c1162a) {
        if (c1162a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1162a.f52732b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1162a.f52733c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f52734a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f52735b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        this.f52729h.clear();
        this.f52730i.clear();
        if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            this.f52729h.addAll(list);
            this.f52730i.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        this.f52728g.clear();
        if (!ListUtils.isEmpty(list)) {
            this.f52728g.addAll(list);
        }
        c(list2, list3);
    }

    public void e(int i2) {
        this.f52727f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f52729h)) {
            return 0;
        }
        return this.f52729h.size();
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
        int i3 = this.f52727f;
        if (i3 == 0) {
            view = LayoutInflater.from(this.f52726e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
            b bVar = new b(this, view);
            if (!ListUtils.isEmpty(this.f52729h) && this.f52729h.size() > i2 && !TextUtils.isEmpty(this.f52729h.get(i2))) {
                bVar.f52734a.setText(this.f52729h.get(i2));
                bVar.f52734a.setVisibility(0);
            } else {
                bVar.f52734a.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.f52730i) && this.f52730i.size() > i2 && !TextUtils.isEmpty(this.f52730i.get(i2))) {
                bVar.f52735b.setText(this.f52730i.get(i2));
                bVar.f52735b.setVisibility(0);
            } else {
                bVar.f52735b.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            b(bVar);
        } else if (i3 == 1) {
            view = LayoutInflater.from(this.f52726e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C1162a c1162a = new C1162a(this, view);
            if (!ListUtils.isEmpty(this.f52728g) && this.f52728g.size() > i2 && !TextUtils.isEmpty(this.f52728g.get(i2))) {
                c1162a.f52731a.setDefaultResource(R.drawable.transparent_bg);
                c1162a.f52731a.U(this.f52728g.get(i2), 10, false);
            }
            if (!ListUtils.isEmpty(this.f52729h) && this.f52729h.size() > i2 && !TextUtils.isEmpty(this.f52729h.get(i2))) {
                c1162a.f52732b.setText(this.f52729h.get(i2));
                c1162a.f52732b.setVisibility(0);
            } else {
                c1162a.f52732b.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.f52730i) && this.f52730i.size() > i2 && !TextUtils.isEmpty(this.f52730i.get(i2))) {
                c1162a.f52733c.setText(this.f52730i.get(i2));
                c1162a.f52733c.setVisibility(0);
            } else {
                c1162a.f52733c.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c1162a);
        }
        return view;
    }
}
