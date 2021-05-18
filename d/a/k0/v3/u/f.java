package d.a.k0.v3.u;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class f extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<String> f62906e;

    /* renamed from: f  reason: collision with root package name */
    public e f62907f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbImageView tbImageView = (TbImageView) view;
            if (f.this.f62907f == null || tbImageView == null || tbImageView.getBdImage() == null || tbImageView.getBdImage().p() == null) {
                return;
            }
            f.this.f62907f.a(tbImageView.getBdImage().p(), false);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbImageView tbImageView = (TbImageView) view;
            if (f.this.f62907f == null || tbImageView == null || tbImageView.getBdImage() == null || tbImageView.getBdImage().p() == null) {
                return;
            }
            f.this.f62907f.a(tbImageView.getBdImage().p(), true);
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62910a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62911b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public String getItem(int i2) {
        return (String) ListUtils.getItem(this.f62906e, i2);
    }

    public void c(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f62906e = list;
    }

    public void d(e eVar) {
        this.f62907f = eVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f62906e)) {
            return 0;
        }
        return (int) Math.ceil(this.f62906e.size() / 2.0d);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pic_sticker_item, (ViewGroup) null);
            cVar = new c();
            cVar.f62910a = (TbImageView) view.findViewById(R.id.top_sticker);
            cVar.f62911b = (TbImageView) view.findViewById(R.id.bottom_sticker);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.f62910a.setGifIconSupport(false);
        cVar.f62911b.setGifIconSupport(false);
        int i3 = i2 * 2;
        cVar.f62910a.V(this.f62906e.get(i3), 10, true);
        cVar.f62910a.setOnClickListener(new a());
        cVar.f62911b.V(this.f62906e.get(i3 + 1), 10, true);
        cVar.f62911b.setOnClickListener(new b());
        return view;
    }
}
