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
    public List<d.b.i0.p3.j.e.a> f58953e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.p3.j.e.a f58954f;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f58955a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58956b;

        public a(b bVar) {
        }
    }

    public List<d.b.i0.p3.j.e.a> a() {
        return this.f58953e;
    }

    public void b(d.b.i0.p3.j.e.a aVar) {
        if (aVar == null) {
            List<d.b.i0.p3.j.e.a> list = this.f58953e;
            if (list != null) {
                this.f58954f = list.get(0);
            }
        } else {
            this.f58954f = aVar;
        }
        notifyDataSetChanged();
    }

    public void c(List<d.b.i0.p3.j.e.a> list) {
        if (list != null) {
            this.f58953e = list;
            if (list.size() > 0) {
                this.f58954f = this.f58953e.get(0);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f58953e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.f58953e.size()) {
            return null;
        }
        return this.f58953e.get(i);
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
            aVar.f58955a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.f58955a.setDrawerType(1);
            aVar.f58955a.setDefaultBgResource(R.color.transparent);
            aVar.f58955a.setBorderWidth(l.g(viewGroup.getContext(), R.dimen.ds4));
            aVar.f58955a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f58955a.setConrers(15);
            TextView textView = (TextView) view2.findViewById(R.id.tv_name);
            aVar.f58956b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
            aVar.f58956b = (TextView) view2.findViewById(R.id.tv_name);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.f58953e.size()) {
            d.b.i0.p3.j.e.a aVar3 = this.f58953e.get(i);
            if (aVar3 != null) {
                aVar.f58955a.setTag(aVar3);
                aVar.f58955a.setOnClickListener(this);
                aVar.f58955a.W(String.valueOf(aVar3.f59003b), 24, false);
                aVar.f58956b.setText(aVar3.f59002a);
            }
            if (!TextUtils.isEmpty(aVar3.f59002a) && (aVar2 = this.f58954f) != null && TextUtils.equals(aVar3.f59002a, aVar2.f59002a)) {
                aVar.f58955a.setDrawBorder(true);
            } else {
                aVar.f58955a.setDrawBorder(false);
            }
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof d.b.i0.p3.j.e.a)) {
            this.f58954f = (d.b.i0.p3.j.e.a) view.getTag();
            notifyDataSetChanged();
        }
    }
}
