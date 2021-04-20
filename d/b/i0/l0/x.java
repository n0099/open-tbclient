package d.b.i0.l0;

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
    public List<d.b.h0.e.a> f58066e;

    /* renamed from: f  reason: collision with root package name */
    public String f58067f;

    /* renamed from: g  reason: collision with root package name */
    public Context f58068g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.b0.b f58069h = new d.b.h0.b0.b();
    public int i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements d.b.h0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f58070e;

        public a(x xVar, ViewGroup viewGroup) {
            this.f58070e = viewGroup;
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.c.j.d.a aVar, String str, boolean z) {
            HeadImageView headImageView = (HeadImageView) this.f58070e.findViewWithTag(str);
            if (headImageView == null || aVar == null) {
                return;
            }
            headImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f58071a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58072b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f58073c;

        public b(x xVar) {
        }

        public /* synthetic */ b(x xVar, a aVar) {
            this(xVar);
        }
    }

    public x(Context context) {
        this.f58068g = context;
        this.j = (int) this.f58068g.getResources().getDimension(R.dimen.ds120);
        this.i = d.b.c.e.p.l.k(this.f58068g) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.h0.e.a getItem(int i) {
        List<d.b.h0.e.a> list = this.f58066e;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.f58066e.get(i);
    }

    public void b(List<d.b.h0.e.a> list, String str) {
        this.f58066e = list;
        this.f58067f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.h0.e.a> list = this.f58066e;
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
            view = LayoutInflater.from(this.f58068g).inflate(R.layout.collect_album_list_item, viewGroup, false);
            bVar = new b(this, null);
            bVar.f58071a = (HeadImageView) view.findViewById(R.id.item_head);
            bVar.f58072b = (TextView) view.findViewById(R.id.item_name);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_arrow);
            bVar.f58073c = imageView;
            SkinManager.setImageResource(imageView, R.drawable.icon_site_ok);
            view.setTag(bVar);
        }
        bVar.f58071a.setTag(null);
        bVar.f58071a.setDefaultResource(R.drawable.pic_image_h_not);
        bVar.f58071a.W(null, 12, false);
        bVar.f58071a.invalidate();
        d.b.h0.e.a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.g())) {
                item.g();
                String s = d.b.c.e.p.l.s(bVar.f58072b.getPaint(), item.g(), this.i);
                bVar.f58072b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                bVar.f58072b.setText("");
            }
            String b2 = item.b();
            if (!TextUtils.isEmpty(b2) && b2.equals(this.f58067f)) {
                bVar.f58073c.setVisibility(0);
            } else {
                bVar.f58073c.setVisibility(8);
            }
            ImageFileInfo e2 = item.e();
            if (e2 != null) {
                e2.clearPageActions();
                int i2 = this.j;
                e2.addPageAction(d.b.h0.b0.g.d.g(i2, i2));
                d.b.c.j.d.a c2 = this.f58069h.c(e2, false);
                bVar.f58071a.setTag(e2.toCachedKey(false));
                if (c2 != null) {
                    bVar.f58071a.invalidate();
                } else {
                    this.f58069h.e(e2, new a(this, viewGroup), false, false);
                }
            }
        } else {
            bVar.f58072b.setText("");
        }
        return view;
    }
}
