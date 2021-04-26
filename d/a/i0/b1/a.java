package d.a.i0.b1;

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
    public Context f48092e;

    /* renamed from: f  reason: collision with root package name */
    public int f48093f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f48094g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f48095h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<String> f48096i = new ArrayList();

    /* renamed from: d.a.i0.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1020a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f48097a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f48098b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f48099c;

        public C1020a(a aVar, View view) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f48097a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f48098b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f48099c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f48100a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f48101b;

        public b(a aVar, View view) {
            this.f48100a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f48101b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    public a(Context context) {
        this.f48092e = context;
    }

    public void a(C1020a c1020a) {
        if (c1020a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1020a.f48098b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1020a.f48099c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f48100a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f48101b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        this.f48095h.clear();
        this.f48096i.clear();
        if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            this.f48095h.addAll(list);
            this.f48096i.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        this.f48094g.clear();
        if (!ListUtils.isEmpty(list)) {
            this.f48094g.addAll(list);
        }
        c(list2, list3);
    }

    public void e(int i2) {
        this.f48093f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f48095h)) {
            return 0;
        }
        return this.f48095h.size();
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
        int i3 = this.f48093f;
        if (i3 == 0) {
            view = LayoutInflater.from(this.f48092e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
            b bVar = new b(this, view);
            if (!ListUtils.isEmpty(this.f48095h) && this.f48095h.size() > i2 && !TextUtils.isEmpty(this.f48095h.get(i2))) {
                bVar.f48100a.setText(this.f48095h.get(i2));
                bVar.f48100a.setVisibility(0);
            } else {
                bVar.f48100a.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.f48096i) && this.f48096i.size() > i2 && !TextUtils.isEmpty(this.f48096i.get(i2))) {
                bVar.f48101b.setText(this.f48096i.get(i2));
                bVar.f48101b.setVisibility(0);
            } else {
                bVar.f48101b.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            b(bVar);
        } else if (i3 == 1) {
            view = LayoutInflater.from(this.f48092e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C1020a c1020a = new C1020a(this, view);
            if (!ListUtils.isEmpty(this.f48094g) && this.f48094g.size() > i2 && !TextUtils.isEmpty(this.f48094g.get(i2))) {
                c1020a.f48097a.setDefaultResource(R.drawable.transparent_bg);
                c1020a.f48097a.V(this.f48094g.get(i2), 10, false);
            }
            if (!ListUtils.isEmpty(this.f48095h) && this.f48095h.size() > i2 && !TextUtils.isEmpty(this.f48095h.get(i2))) {
                c1020a.f48098b.setText(this.f48095h.get(i2));
                c1020a.f48098b.setVisibility(0);
            } else {
                c1020a.f48098b.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.f48096i) && this.f48096i.size() > i2 && !TextUtils.isEmpty(this.f48096i.get(i2))) {
                c1020a.f48099c.setText(this.f48096i.get(i2));
                c1020a.f48099c.setVisibility(0);
            } else {
                c1020a.f48099c.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c1020a);
        }
        return view;
    }
}
