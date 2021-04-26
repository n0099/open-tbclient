package d.a.j0.y1.g;

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
import d.a.c.e.p.l;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<ImageFileInfo> f62817e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedHashMap<String, ImageFileInfo> f62818f = new LinkedHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.b0.b f62819g;

    /* renamed from: h  reason: collision with root package name */
    public BaseFragmentActivity f62820h;

    /* renamed from: i  reason: collision with root package name */
    public f f62821i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f62822e;

        public a(g gVar, ViewGroup viewGroup) {
            this.f62822e = viewGroup;
        }

        @Override // d.a.i0.a0.b
        public void a(d.a.c.j.d.a aVar, String str, boolean z) {
            HeadImageView headImageView = (HeadImageView) this.f62822e.findViewWithTag(str);
            if (headImageView == null || aVar == null) {
                return;
            }
            headImageView.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f62823a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f62824b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f62825c;

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
                if (g.this.f62818f.containsKey(imageFileInfo.getFilePath())) {
                    g.this.f62818f.remove(imageFileInfo.getFilePath());
                    SkinManager.setBackgroundResource(b.this.f62825c, R.drawable.ic_post_image_selected_n);
                    if (g.this.f62821i != null) {
                        g.this.f62821i.onUnChoose();
                    }
                } else if (g.this.f62821i != null) {
                    if (g.this.f62821i.canChooseMore()) {
                        g.this.f62818f.put(imageFileInfo.getFilePath(), imageFileInfo);
                        SkinManager.setBackgroundResource(b.this.f62825c, R.drawable.ic_post_image_selected_s);
                        g.this.f62821i.onChoose();
                        return;
                    }
                    Activity pageActivity = g.this.f62820h.getPageContext().getPageActivity();
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
            this.f62824b = (HeadImageView) view.findViewById(R.id.image);
            this.f62825c = (ImageView) view.findViewById(R.id.select_icon);
            view.setOnClickListener(new a());
        }
    }

    public g(BaseFragmentActivity baseFragmentActivity, List<ImageFileInfo> list) {
        this.f62820h = baseFragmentActivity;
        this.f62817e = list;
        this.j = (int) baseFragmentActivity.getResources().getDimension(R.dimen.ds220);
        int k = l.k(baseFragmentActivity.getPageContext().getPageActivity());
        this.k = k;
        this.l = (k - l.g(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds16)) / 3;
        int g2 = l.g(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds8) / 3;
        this.m = g2;
        this.n = (g2 * 2) + 1;
        this.f62819g = new d.a.i0.b0.b();
    }

    public void e(Map<String, ImageFileInfo> map) {
        this.f62818f.putAll(map);
    }

    public LinkedHashMap<String, ImageFileInfo> f() {
        return this.f62818f;
    }

    public d.a.i0.b0.b g() {
        return this.f62819g;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ImageFileInfo> list = this.f62817e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
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
        bVar.f62823a = view2;
        int paddingTop = view2.getPaddingTop();
        int i3 = i2 % 3;
        if (i3 == 0) {
            bVar.f62823a.setPadding(0, paddingTop, this.n, 0);
        } else if (i3 == 1) {
            View view3 = bVar.f62823a;
            int i4 = this.m;
            view3.setPadding(i4, paddingTop, i4, 0);
        } else {
            bVar.f62823a.setPadding(this.n, paddingTop, 0, 0);
        }
        bVar.f62824b.getLayoutParams().height = this.l;
        bVar.f62824b.setTag(null);
        bVar.f62824b.setRadius(1);
        bVar.f62824b.setDefaultResource(R.drawable.img_default_100);
        bVar.f62824b.V(null, 12, false);
        bVar.f62824b.invalidate();
        ImageFileInfo imageFileInfo = this.f62817e.get(i2);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            int i5 = this.j;
            imageFileInfo.addPageAction(d.a.i0.b0.g.d.g(i5, i5));
            d.a.c.j.d.a c2 = this.f62819g.c(imageFileInfo, false);
            bVar.f62824b.setTag(imageFileInfo.toCachedKey(false));
            if (c2 != null) {
                bVar.f62824b.invalidate();
            } else {
                this.f62819g.e(imageFileInfo, new a(this, viewGroup), false, this.o);
            }
            if (this.f62818f.containsKey(imageFileInfo.getFilePath())) {
                SkinManager.setBackgroundResource(bVar.f62825c, R.drawable.ic_post_image_selected_s);
            } else {
                SkinManager.setBackgroundResource(bVar.f62825c, R.drawable.ic_post_image_selected_n);
            }
            view2.setTag(view2.getId(), imageFileInfo);
        }
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: h */
    public ImageFileInfo getItem(int i2) {
        List<ImageFileInfo> list = this.f62817e;
        if (list == null || i2 > list.size() - 1) {
            return null;
        }
        return this.f62817e.get(i2);
    }

    public boolean i() {
        return this.o;
    }

    public void j(f fVar) {
        this.f62821i = fVar;
    }

    public void k(String str) {
        this.p = str;
    }

    public void l(boolean z) {
        this.o = z;
    }
}
