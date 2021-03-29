package d.b.i0.p3.j.c;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.i0.p3.j.e.a> f58954e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.p3.j.e.a f58955f;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f58956a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58957b;

        public a(b bVar) {
        }
    }

    public List<d.b.i0.p3.j.e.a> a() {
        return this.f58954e;
    }

    public void b(d.b.i0.p3.j.e.a aVar) {
        if (aVar == null) {
            List<d.b.i0.p3.j.e.a> list = this.f58954e;
            if (list != null) {
                this.f58955f = list.get(0);
            }
        } else {
            this.f58955f = aVar;
        }
        notifyDataSetChanged();
    }

    public void c(List<d.b.i0.p3.j.e.a> list) {
        if (list != null) {
            this.f58954e = list;
            if (list.size() > 0) {
                this.f58955f = this.f58954e.get(0);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f58954e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.f58954e.size()) {
            return null;
        }
        return this.f58954e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        d.b.i0.p3.j.e.a aVar2;
        if (view == null) {
            aVar = new a(this);
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_filter, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.iv_effect);
            aVar.f58956a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.f58956a.setDrawerType(1);
            aVar.f58956a.setDefaultBgResource(R.color.transparent);
            aVar.f58956a.setBorderWidth(l.g(viewGroup.getContext(), R.dimen.ds4));
            aVar.f58956a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f58956a.setConrers(15);
            TextView textView = (TextView) view2.findViewById(R.id.tv_name);
            aVar.f58957b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
            aVar.f58957b = (TextView) view2.findViewById(R.id.tv_name);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.f58954e.size()) {
            d.b.i0.p3.j.e.a aVar3 = this.f58954e.get(i);
            if (aVar3 != null) {
                aVar.f58956a.setTag(aVar3);
                aVar.f58956a.setOnClickListener(this);
                aVar.f58956a.W(String.valueOf(aVar3.f59004b), 24, false);
                aVar.f58957b.setText(aVar3.f59003a);
            }
            if (!TextUtils.isEmpty(aVar3.f59003a) && (aVar2 = this.f58955f) != null && TextUtils.equals(aVar3.f59003a, aVar2.f59003a)) {
                aVar.f58956a.setDrawBorder(true);
            } else {
                aVar.f58956a.setDrawBorder(false);
            }
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof d.b.i0.p3.j.e.a)) {
            this.f58955f = (d.b.i0.p3.j.e.a) view.getTag();
            notifyDataSetChanged();
        }
    }
}
