package d.a.n0.r3.i.c;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.n0.r3.i.e.a> f63749e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.r3.i.e.a f63750f;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f63751a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63752b;

        public a(b bVar) {
        }
    }

    public List<d.a.n0.r3.i.e.a> a() {
        return this.f63749e;
    }

    public void b(d.a.n0.r3.i.e.a aVar) {
        if (aVar == null) {
            List<d.a.n0.r3.i.e.a> list = this.f63749e;
            if (list != null) {
                this.f63750f = list.get(0);
            }
        } else {
            this.f63750f = aVar;
        }
        notifyDataSetChanged();
    }

    public void c(List<d.a.n0.r3.i.e.a> list) {
        if (list != null) {
            this.f63749e = list;
            if (list.size() > 0) {
                this.f63750f = this.f63749e.get(0);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f63749e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (i2 < 0 || i2 >= this.f63749e.size()) {
            return null;
        }
        return this.f63749e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        d.a.n0.r3.i.e.a aVar2;
        if (view == null) {
            aVar = new a(this);
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_filter, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.iv_effect);
            aVar.f63751a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.f63751a.setDrawerType(1);
            aVar.f63751a.setDefaultBgResource(R.color.transparent);
            aVar.f63751a.setBorderWidth(l.g(viewGroup.getContext(), R.dimen.ds4));
            aVar.f63751a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f63751a.setConrers(15);
            TextView textView = (TextView) view2.findViewById(R.id.tv_name);
            aVar.f63752b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
            aVar.f63752b = (TextView) view2.findViewById(R.id.tv_name);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        if (i2 >= 0 && i2 < this.f63749e.size()) {
            d.a.n0.r3.i.e.a aVar3 = this.f63749e.get(i2);
            if (aVar3 != null) {
                aVar.f63751a.setTag(aVar3);
                aVar.f63751a.setOnClickListener(this);
                aVar.f63751a.U(String.valueOf(aVar3.f63803b), 24, false);
                aVar.f63752b.setText(aVar3.f63802a);
            }
            if (!TextUtils.isEmpty(aVar3.f63802a) && (aVar2 = this.f63750f) != null && TextUtils.equals(aVar3.f63802a, aVar2.f63802a)) {
                aVar.f63751a.setDrawBorder(true);
            } else {
                aVar.f63751a.setDrawBorder(false);
            }
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof d.a.n0.r3.i.e.a)) {
            this.f63750f = (d.a.n0.r3.i.e.a) view.getTag();
            notifyDataSetChanged();
        }
    }
}
