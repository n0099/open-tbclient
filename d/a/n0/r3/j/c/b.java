package d.a.n0.r3.j.c;

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
    public List<d.a.n0.r3.j.e.a> f60060e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.r3.j.e.a f60061f;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60062a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60063b;

        public a(b bVar) {
        }
    }

    public List<d.a.n0.r3.j.e.a> a() {
        return this.f60060e;
    }

    public void b(d.a.n0.r3.j.e.a aVar) {
        if (aVar == null) {
            List<d.a.n0.r3.j.e.a> list = this.f60060e;
            if (list != null) {
                this.f60061f = list.get(0);
            }
        } else {
            this.f60061f = aVar;
        }
        notifyDataSetChanged();
    }

    public void c(List<d.a.n0.r3.j.e.a> list) {
        if (list != null) {
            this.f60060e = list;
            if (list.size() > 0) {
                this.f60061f = this.f60060e.get(0);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f60060e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (i2 < 0 || i2 >= this.f60060e.size()) {
            return null;
        }
        return this.f60060e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        d.a.n0.r3.j.e.a aVar2;
        if (view == null) {
            aVar = new a(this);
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_filter, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.iv_effect);
            aVar.f60062a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.f60062a.setDrawerType(1);
            aVar.f60062a.setDefaultBgResource(R.color.transparent);
            aVar.f60062a.setBorderWidth(l.g(viewGroup.getContext(), R.dimen.ds4));
            aVar.f60062a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f60062a.setConrers(15);
            TextView textView = (TextView) view2.findViewById(R.id.tv_name);
            aVar.f60063b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
            aVar.f60063b = (TextView) view2.findViewById(R.id.tv_name);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        if (i2 >= 0 && i2 < this.f60060e.size()) {
            d.a.n0.r3.j.e.a aVar3 = this.f60060e.get(i2);
            if (aVar3 != null) {
                aVar.f60062a.setTag(aVar3);
                aVar.f60062a.setOnClickListener(this);
                aVar.f60062a.V(String.valueOf(aVar3.f60114b), 24, false);
                aVar.f60063b.setText(aVar3.f60113a);
            }
            if (!TextUtils.isEmpty(aVar3.f60113a) && (aVar2 = this.f60061f) != null && TextUtils.equals(aVar3.f60113a, aVar2.f60113a)) {
                aVar.f60062a.setDrawBorder(true);
            } else {
                aVar.f60062a.setDrawBorder(false);
            }
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof d.a.n0.r3.j.e.a)) {
            this.f60061f = (d.a.n0.r3.j.e.a) view.getTag();
            notifyDataSetChanged();
        }
    }
}
