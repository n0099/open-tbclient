package d.b.i0.u3.v;

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
    public List<String> f61778e;

    /* renamed from: f  reason: collision with root package name */
    public e f61779f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbImageView tbImageView = (TbImageView) view;
            if (f.this.f61779f == null || tbImageView == null || tbImageView.getBdImage() == null || tbImageView.getBdImage().p() == null) {
                return;
            }
            f.this.f61779f.a(tbImageView.getBdImage().p(), false);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbImageView tbImageView = (TbImageView) view;
            if (f.this.f61779f == null || tbImageView == null || tbImageView.getBdImage() == null || tbImageView.getBdImage().p() == null) {
                return;
            }
            f.this.f61779f.a(tbImageView.getBdImage().p(), true);
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61782a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61783b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public String getItem(int i) {
        return (String) ListUtils.getItem(this.f61778e, i);
    }

    public void c(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f61778e = list;
    }

    public void d(e eVar) {
        this.f61779f = eVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f61778e)) {
            return 0;
        }
        double size = this.f61778e.size();
        Double.isNaN(size);
        return (int) Math.ceil(size / 2.0d);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pic_sticker_item, (ViewGroup) null);
            cVar = new c();
            cVar.f61782a = (TbImageView) view.findViewById(R.id.top_sticker);
            cVar.f61783b = (TbImageView) view.findViewById(R.id.bottom_sticker);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.f61782a.setGifIconSupport(false);
        cVar.f61783b.setGifIconSupport(false);
        int i2 = i * 2;
        cVar.f61782a.W(this.f61778e.get(i2), 10, true);
        cVar.f61782a.setOnClickListener(new a());
        cVar.f61783b.W(this.f61778e.get(i2 + 1), 10, true);
        cVar.f61783b.setOnClickListener(new b());
        return view;
    }
}
