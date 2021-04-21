package d.b.j0.l0;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class x extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.i0.e.a> f58487e;

    /* renamed from: f  reason: collision with root package name */
    public String f58488f;

    /* renamed from: g  reason: collision with root package name */
    public Context f58489g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.b0.b f58490h = new d.b.i0.b0.b();
    public int i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f58491e;

        public a(x xVar, ViewGroup viewGroup) {
            this.f58491e = viewGroup;
        }

        @Override // d.b.i0.a0.b
        public void a(d.b.c.j.d.a aVar, String str, boolean z) {
            HeadImageView headImageView = (HeadImageView) this.f58491e.findViewWithTag(str);
            if (headImageView == null || aVar == null) {
                return;
            }
            headImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f58492a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58493b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f58494c;

        public b(x xVar) {
        }

        public /* synthetic */ b(x xVar, a aVar) {
            this(xVar);
        }
    }

    public x(Context context) {
        this.f58489g = context;
        this.j = (int) this.f58489g.getResources().getDimension(R.dimen.ds120);
        this.i = d.b.c.e.p.l.k(this.f58489g) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.i0.e.a getItem(int i) {
        List<d.b.i0.e.a> list = this.f58487e;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.f58487e.get(i);
    }

    public void b(List<d.b.i0.e.a> list, String str) {
        this.f58487e = list;
        this.f58488f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.e.a> list = this.f58487e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f58489g).inflate(R.layout.collect_album_list_item, viewGroup, false);
            bVar = new b(this, null);
            bVar.f58492a = (HeadImageView) view.findViewById(R.id.item_head);
            bVar.f58493b = (TextView) view.findViewById(R.id.item_name);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_arrow);
            bVar.f58494c = imageView;
            SkinManager.setImageResource(imageView, R.drawable.icon_site_ok);
            view.setTag(bVar);
        }
        bVar.f58492a.setTag(null);
        bVar.f58492a.setDefaultResource(R.drawable.pic_image_h_not);
        bVar.f58492a.W(null, 12, false);
        bVar.f58492a.invalidate();
        d.b.i0.e.a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.g())) {
                item.g();
                String s = d.b.c.e.p.l.s(bVar.f58493b.getPaint(), item.g(), this.i);
                bVar.f58493b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                bVar.f58493b.setText("");
            }
            String b2 = item.b();
            if (!TextUtils.isEmpty(b2) && b2.equals(this.f58488f)) {
                bVar.f58494c.setVisibility(0);
            } else {
                bVar.f58494c.setVisibility(8);
            }
            ImageFileInfo e2 = item.e();
            if (e2 != null) {
                e2.clearPageActions();
                int i2 = this.j;
                e2.addPageAction(d.b.i0.b0.g.d.g(i2, i2));
                d.b.c.j.d.a c2 = this.f58490h.c(e2, false);
                bVar.f58492a.setTag(e2.toCachedKey(false));
                if (c2 != null) {
                    bVar.f58492a.invalidate();
                } else {
                    this.f58490h.e(e2, new a(this, viewGroup), false, false);
                }
            }
        } else {
            bVar.f58493b.setText("");
        }
        return view;
    }
}
