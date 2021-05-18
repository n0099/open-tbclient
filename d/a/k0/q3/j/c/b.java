package d.a.k0.q3.j.c;

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
    public List<d.a.k0.q3.j.e.a> f59919e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.q3.j.e.a f59920f;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f59921a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59922b;

        public a(b bVar) {
        }
    }

    public List<d.a.k0.q3.j.e.a> a() {
        return this.f59919e;
    }

    public void b(d.a.k0.q3.j.e.a aVar) {
        if (aVar == null) {
            List<d.a.k0.q3.j.e.a> list = this.f59919e;
            if (list != null) {
                this.f59920f = list.get(0);
            }
        } else {
            this.f59920f = aVar;
        }
        notifyDataSetChanged();
    }

    public void c(List<d.a.k0.q3.j.e.a> list) {
        if (list != null) {
            this.f59919e = list;
            if (list.size() > 0) {
                this.f59920f = this.f59919e.get(0);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f59919e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (i2 < 0 || i2 >= this.f59919e.size()) {
            return null;
        }
        return this.f59919e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        d.a.k0.q3.j.e.a aVar2;
        if (view == null) {
            aVar = new a(this);
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_filter, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.iv_effect);
            aVar.f59921a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.f59921a.setDrawerType(1);
            aVar.f59921a.setDefaultBgResource(R.color.transparent);
            aVar.f59921a.setBorderWidth(l.g(viewGroup.getContext(), R.dimen.ds4));
            aVar.f59921a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f59921a.setConrers(15);
            TextView textView = (TextView) view2.findViewById(R.id.tv_name);
            aVar.f59922b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
            aVar.f59922b = (TextView) view2.findViewById(R.id.tv_name);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        if (i2 >= 0 && i2 < this.f59919e.size()) {
            d.a.k0.q3.j.e.a aVar3 = this.f59919e.get(i2);
            if (aVar3 != null) {
                aVar.f59921a.setTag(aVar3);
                aVar.f59921a.setOnClickListener(this);
                aVar.f59921a.V(String.valueOf(aVar3.f59973b), 24, false);
                aVar.f59922b.setText(aVar3.f59972a);
            }
            if (!TextUtils.isEmpty(aVar3.f59972a) && (aVar2 = this.f59920f) != null && TextUtils.equals(aVar3.f59972a, aVar2.f59972a)) {
                aVar.f59921a.setDrawBorder(true);
            } else {
                aVar.f59921a.setDrawBorder(false);
            }
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof d.a.k0.q3.j.e.a)) {
            this.f59920f = (d.a.k0.q3.j.e.a) view.getTag();
            notifyDataSetChanged();
        }
    }
}
