package d.b.j0.y1.g;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<ImageFileInfo> f64539e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedHashMap<String, ImageFileInfo> f64540f = new LinkedHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.b0.b f64541g;

    /* renamed from: h  reason: collision with root package name */
    public BaseFragmentActivity f64542h;
    public f i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;

    /* loaded from: classes3.dex */
    public class a implements d.b.i0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f64543e;

        public a(g gVar, ViewGroup viewGroup) {
            this.f64543e = viewGroup;
        }

        @Override // d.b.i0.a0.b
        public void a(d.b.c.j.d.a aVar, String str, boolean z) {
            HeadImageView headImageView = (HeadImageView) this.f64543e.findViewWithTag(str);
            if (headImageView == null || aVar == null) {
                return;
            }
            headImageView.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f64544a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f64545b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f64546c;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag(view.getId()) == null || !(view.getTag(view.getId()) instanceof ImageFileInfo)) {
                    return;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) view.getTag(view.getId());
                if (g.this.f64540f.containsKey(imageFileInfo.getFilePath())) {
                    g.this.f64540f.remove(imageFileInfo.getFilePath());
                    SkinManager.setBackgroundResource(b.this.f64546c, R.drawable.ic_post_image_selected_n);
                    if (g.this.i != null) {
                        g.this.i.onUnChoose();
                    }
                } else if (g.this.i != null) {
                    if (g.this.i.canChooseMore()) {
                        g.this.f64540f.put(imageFileInfo.getFilePath(), imageFileInfo);
                        SkinManager.setBackgroundResource(b.this.f64546c, R.drawable.ic_post_image_selected_s);
                        g.this.i.onChoose();
                        return;
                    }
                    Activity pageActivity = g.this.f64542h.getPageContext().getPageActivity();
                    if (!TextUtils.isEmpty(g.this.p)) {
                        BdToast.c(pageActivity, g.this.p).q();
                    } else {
                        BdToast.c(pageActivity, pageActivity.getText(R.string.face_group_add_pic_max)).q();
                    }
                }
            }
        }

        public b() {
        }

        public final void b(View view) {
            this.f64545b = (HeadImageView) view.findViewById(R.id.image);
            this.f64546c = (ImageView) view.findViewById(R.id.select_icon);
            view.setOnClickListener(new a());
        }
    }

    public g(BaseFragmentActivity baseFragmentActivity, List<ImageFileInfo> list) {
        this.f64542h = baseFragmentActivity;
        this.f64539e = list;
        this.j = (int) baseFragmentActivity.getResources().getDimension(R.dimen.ds220);
        int k = l.k(baseFragmentActivity.getPageContext().getPageActivity());
        this.k = k;
        this.l = (k - l.g(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds16)) / 3;
        int g2 = l.g(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds8) / 3;
        this.m = g2;
        this.n = (g2 * 2) + 1;
        this.f64541g = new d.b.i0.b0.b();
    }

    public void e(Map<String, ImageFileInfo> map) {
        this.f64540f.putAll(map);
    }

    public LinkedHashMap<String, ImageFileInfo> f() {
        return this.f64540f;
    }

    public d.b.i0.b0.b g() {
        return this.f64541g;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ImageFileInfo> list = this.f64539e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_album, (ViewGroup) null);
            bVar.b(view2);
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        bVar.f64544a = view2;
        int paddingTop = view2.getPaddingTop();
        int i2 = i % 3;
        if (i2 == 0) {
            bVar.f64544a.setPadding(0, paddingTop, this.n, 0);
        } else if (i2 == 1) {
            View view3 = bVar.f64544a;
            int i3 = this.m;
            view3.setPadding(i3, paddingTop, i3, 0);
        } else {
            bVar.f64544a.setPadding(this.n, paddingTop, 0, 0);
        }
        bVar.f64545b.getLayoutParams().height = this.l;
        bVar.f64545b.setTag(null);
        bVar.f64545b.setRadius(1);
        bVar.f64545b.setDefaultResource(R.drawable.img_default_100);
        bVar.f64545b.W(null, 12, false);
        bVar.f64545b.invalidate();
        ImageFileInfo imageFileInfo = this.f64539e.get(i);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            int i4 = this.j;
            imageFileInfo.addPageAction(d.b.i0.b0.g.d.g(i4, i4));
            d.b.c.j.d.a c2 = this.f64541g.c(imageFileInfo, false);
            bVar.f64545b.setTag(imageFileInfo.toCachedKey(false));
            if (c2 != null) {
                bVar.f64545b.invalidate();
            } else {
                this.f64541g.e(imageFileInfo, new a(this, viewGroup), false, this.o);
            }
            if (this.f64540f.containsKey(imageFileInfo.getFilePath())) {
                SkinManager.setBackgroundResource(bVar.f64546c, R.drawable.ic_post_image_selected_s);
            } else {
                SkinManager.setBackgroundResource(bVar.f64546c, R.drawable.ic_post_image_selected_n);
            }
            view2.setTag(view2.getId(), imageFileInfo);
        }
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: h */
    public ImageFileInfo getItem(int i) {
        List<ImageFileInfo> list = this.f64539e;
        if (list == null || i > list.size() - 1) {
            return null;
        }
        return this.f64539e.get(i);
    }

    public boolean i() {
        return this.o;
    }

    public void j(f fVar) {
        this.i = fVar;
    }

    public void k(String str) {
        this.p = str;
    }

    public void l(boolean z) {
        this.o = z;
    }
}
