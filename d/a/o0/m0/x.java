package d.a.o0.m0;

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
    public List<d.a.n0.e.a> f61203e;

    /* renamed from: f  reason: collision with root package name */
    public String f61204f;

    /* renamed from: g  reason: collision with root package name */
    public Context f61205g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.b0.b f61206h = new d.a.n0.b0.b();

    /* renamed from: i  reason: collision with root package name */
    public int f61207i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements d.a.n0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f61208e;

        public a(x xVar, ViewGroup viewGroup) {
            this.f61208e = viewGroup;
        }

        @Override // d.a.n0.a0.b
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            HeadImageView headImageView = (HeadImageView) this.f61208e.findViewWithTag(str);
            if (headImageView == null || aVar == null) {
                return;
            }
            headImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f61209a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61210b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f61211c;

        public b(x xVar) {
        }

        public /* synthetic */ b(x xVar, a aVar) {
            this(xVar);
        }
    }

    public x(Context context) {
        this.f61205g = context;
        this.j = (int) this.f61205g.getResources().getDimension(R.dimen.ds120);
        this.f61207i = d.a.c.e.p.l.k(this.f61205g) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.n0.e.a getItem(int i2) {
        List<d.a.n0.e.a> list = this.f61203e;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return this.f61203e.get(i2);
    }

    public void b(List<d.a.n0.e.a> list, String str) {
        this.f61203e = list;
        this.f61204f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.n0.e.a> list = this.f61203e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f61205g).inflate(R.layout.collect_album_list_item, viewGroup, false);
            bVar = new b(this, null);
            bVar.f61209a = (HeadImageView) view.findViewById(R.id.item_head);
            bVar.f61210b = (TextView) view.findViewById(R.id.item_name);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_arrow);
            bVar.f61211c = imageView;
            SkinManager.setImageResource(imageView, R.drawable.icon_site_ok);
            view.setTag(bVar);
        }
        bVar.f61209a.setTag(null);
        bVar.f61209a.setDefaultResource(R.drawable.pic_image_h_not);
        bVar.f61209a.U(null, 12, false);
        bVar.f61209a.invalidate();
        d.a.n0.e.a item = getItem(i2);
        if (item != null) {
            if (!TextUtils.isEmpty(item.g())) {
                item.g();
                String s = d.a.c.e.p.l.s(bVar.f61210b.getPaint(), item.g(), this.f61207i);
                bVar.f61210b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                bVar.f61210b.setText("");
            }
            String b2 = item.b();
            if (!TextUtils.isEmpty(b2) && b2.equals(this.f61204f)) {
                bVar.f61211c.setVisibility(0);
            } else {
                bVar.f61211c.setVisibility(8);
            }
            ImageFileInfo e2 = item.e();
            if (e2 != null) {
                e2.clearPageActions();
                int i3 = this.j;
                e2.addPageAction(d.a.n0.b0.g.d.g(i3, i3));
                d.a.c.k.d.a c2 = this.f61206h.c(e2, false);
                bVar.f61209a.setTag(e2.toCachedKey(false));
                if (c2 != null) {
                    bVar.f61209a.invalidate();
                } else {
                    this.f61206h.e(e2, new a(this, viewGroup), false, false);
                }
            }
        } else {
            bVar.f61210b.setText("");
        }
        return view;
    }
}
