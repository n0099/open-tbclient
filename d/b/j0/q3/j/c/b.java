package d.b.j0.q3.j.c;

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
    public List<d.b.j0.q3.j.e.a> f61043e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.q3.j.e.a f61044f;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61045a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61046b;

        public a(b bVar) {
        }
    }

    public List<d.b.j0.q3.j.e.a> a() {
        return this.f61043e;
    }

    public void b(d.b.j0.q3.j.e.a aVar) {
        if (aVar == null) {
            List<d.b.j0.q3.j.e.a> list = this.f61043e;
            if (list != null) {
                this.f61044f = list.get(0);
            }
        } else {
            this.f61044f = aVar;
        }
        notifyDataSetChanged();
    }

    public void c(List<d.b.j0.q3.j.e.a> list) {
        if (list != null) {
            this.f61043e = list;
            if (list.size() > 0) {
                this.f61044f = this.f61043e.get(0);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f61043e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.f61043e.size()) {
            return null;
        }
        return this.f61043e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        d.b.j0.q3.j.e.a aVar2;
        if (view == null) {
            aVar = new a(this);
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_filter, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.iv_effect);
            aVar.f61045a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.f61045a.setDrawerType(1);
            aVar.f61045a.setDefaultBgResource(R.color.transparent);
            aVar.f61045a.setBorderWidth(l.g(viewGroup.getContext(), R.dimen.ds4));
            aVar.f61045a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f61045a.setConrers(15);
            TextView textView = (TextView) view2.findViewById(R.id.tv_name);
            aVar.f61046b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
            aVar.f61046b = (TextView) view2.findViewById(R.id.tv_name);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.f61043e.size()) {
            d.b.j0.q3.j.e.a aVar3 = this.f61043e.get(i);
            if (aVar3 != null) {
                aVar.f61045a.setTag(aVar3);
                aVar.f61045a.setOnClickListener(this);
                aVar.f61045a.W(String.valueOf(aVar3.f61093b), 24, false);
                aVar.f61046b.setText(aVar3.f61092a);
            }
            if (!TextUtils.isEmpty(aVar3.f61092a) && (aVar2 = this.f61044f) != null && TextUtils.equals(aVar3.f61092a, aVar2.f61092a)) {
                aVar.f61045a.setDrawBorder(true);
            } else {
                aVar.f61045a.setDrawBorder(false);
            }
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof d.b.j0.q3.j.e.a)) {
            this.f61044f = (d.b.j0.q3.j.e.a) view.getTag();
            notifyDataSetChanged();
        }
    }
}
