package d.b.i0.q3.j.c;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.i0.q3.j.e.a> f60622e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.q3.j.e.a f60623f;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60624a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60625b;

        public a(b bVar) {
        }
    }

    public List<d.b.i0.q3.j.e.a> a() {
        return this.f60622e;
    }

    public void b(d.b.i0.q3.j.e.a aVar) {
        if (aVar == null) {
            List<d.b.i0.q3.j.e.a> list = this.f60622e;
            if (list != null) {
                this.f60623f = list.get(0);
            }
        } else {
            this.f60623f = aVar;
        }
        notifyDataSetChanged();
    }

    public void c(List<d.b.i0.q3.j.e.a> list) {
        if (list != null) {
            this.f60622e = list;
            if (list.size() > 0) {
                this.f60623f = this.f60622e.get(0);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f60622e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.f60622e.size()) {
            return null;
        }
        return this.f60622e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        d.b.i0.q3.j.e.a aVar2;
        if (view == null) {
            aVar = new a(this);
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_filter, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.iv_effect);
            aVar.f60624a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.f60624a.setDrawerType(1);
            aVar.f60624a.setDefaultBgResource(R.color.transparent);
            aVar.f60624a.setBorderWidth(l.g(viewGroup.getContext(), R.dimen.ds4));
            aVar.f60624a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f60624a.setConrers(15);
            TextView textView = (TextView) view2.findViewById(R.id.tv_name);
            aVar.f60625b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
            aVar.f60625b = (TextView) view2.findViewById(R.id.tv_name);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.f60622e.size()) {
            d.b.i0.q3.j.e.a aVar3 = this.f60622e.get(i);
            if (aVar3 != null) {
                aVar.f60624a.setTag(aVar3);
                aVar.f60624a.setOnClickListener(this);
                aVar.f60624a.W(String.valueOf(aVar3.f60672b), 24, false);
                aVar.f60625b.setText(aVar3.f60671a);
            }
            if (!TextUtils.isEmpty(aVar3.f60671a) && (aVar2 = this.f60623f) != null && TextUtils.equals(aVar3.f60671a, aVar2.f60671a)) {
                aVar.f60624a.setDrawBorder(true);
            } else {
                aVar.f60624a.setDrawBorder(false);
            }
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof d.b.i0.q3.j.e.a)) {
            this.f60623f = (d.b.i0.q3.j.e.a) view.getTag();
            notifyDataSetChanged();
        }
    }
}
