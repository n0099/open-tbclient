package d.b.i0.b1;

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
    public Context f50537e;

    /* renamed from: f  reason: collision with root package name */
    public int f50538f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f50539g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f50540h = new ArrayList();
    public List<String> i = new ArrayList();

    /* renamed from: d.b.i0.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1081a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f50541a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50542b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f50543c;

        public C1081a(a aVar, View view) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f50541a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f50542b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f50543c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f50544a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50545b;

        public b(a aVar, View view) {
            this.f50544a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f50545b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    public a(Context context) {
        this.f50537e = context;
    }

    public void a(C1081a c1081a) {
        if (c1081a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1081a.f50542b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1081a.f50543c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f50544a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f50545b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        this.f50540h.clear();
        this.i.clear();
        if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            this.f50540h.addAll(list);
            this.i.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        this.f50539g.clear();
        if (!ListUtils.isEmpty(list)) {
            this.f50539g.addAll(list);
        }
        c(list2, list3);
    }

    public void e(int i) {
        this.f50538f = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f50540h)) {
            return 0;
        }
        return this.f50540h.size();
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
        int i2 = this.f50538f;
        if (i2 == 0) {
            view = LayoutInflater.from(this.f50537e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
            b bVar = new b(this, view);
            if (!ListUtils.isEmpty(this.f50540h) && this.f50540h.size() > i && !TextUtils.isEmpty(this.f50540h.get(i))) {
                bVar.f50544a.setText(this.f50540h.get(i));
                bVar.f50544a.setVisibility(0);
            } else {
                bVar.f50544a.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.i) && this.i.size() > i && !TextUtils.isEmpty(this.i.get(i))) {
                bVar.f50545b.setText(this.i.get(i));
                bVar.f50545b.setVisibility(0);
            } else {
                bVar.f50545b.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            b(bVar);
        } else if (i2 == 1) {
            view = LayoutInflater.from(this.f50537e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C1081a c1081a = new C1081a(this, view);
            if (!ListUtils.isEmpty(this.f50539g) && this.f50539g.size() > i && !TextUtils.isEmpty(this.f50539g.get(i))) {
                c1081a.f50541a.setDefaultResource(R.drawable.transparent_bg);
                c1081a.f50541a.W(this.f50539g.get(i), 10, false);
            }
            if (!ListUtils.isEmpty(this.f50540h) && this.f50540h.size() > i && !TextUtils.isEmpty(this.f50540h.get(i))) {
                c1081a.f50542b.setText(this.f50540h.get(i));
                c1081a.f50542b.setVisibility(0);
            } else {
                c1081a.f50542b.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.i) && this.i.size() > i && !TextUtils.isEmpty(this.i.get(i))) {
                c1081a.f50543c.setText(this.i.get(i));
                c1081a.f50543c.setVisibility(0);
            } else {
                c1081a.f50543c.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c1081a);
        }
        return view;
    }
}
