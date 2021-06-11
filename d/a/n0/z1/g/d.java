package d.a.n0.z1.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<FaceData> f67368e;

    /* renamed from: f  reason: collision with root package name */
    public Context f67369f = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.b0.b f67370g = new d.a.m0.b0.b();

    /* renamed from: h  reason: collision with root package name */
    public int f67371h;

    /* renamed from: i  reason: collision with root package name */
    public int f67372i;
    public c j;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f67373a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C1819d f67374b;

        public a(d dVar, ViewGroup viewGroup, C1819d c1819d) {
            this.f67373a = viewGroup;
            this.f67374b = c1819d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            View findViewWithTag;
            if (aVar == null || (findViewWithTag = this.f67373a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f67374b.f67376a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.m0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f67375e;

        public b(d dVar, ViewGroup viewGroup) {
            this.f67375e = viewGroup;
        }

        @Override // d.a.m0.a0.b
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f67375e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            aVar.h(tbImageView);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onAdd();

        void onDel(FaceData faceData);
    }

    /* renamed from: d.a.n0.z1.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1819d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f67376a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f67377b;

        /* renamed from: d.a.n0.z1.g.d$d$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.j == null || view.getTag(view.getId()) == null || !(view.getTag(view.getId()) instanceof FaceData) || ((FaceData) view.getTag(view.getId())).type != 4) {
                    return;
                }
                d.this.j.onAdd();
            }
        }

        /* renamed from: d.a.n0.z1.g.d$d$b */
        /* loaded from: classes4.dex */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.j == null || view.getTag() == null || !(view.getTag() instanceof FaceData)) {
                    return;
                }
                d.this.j.onDel((FaceData) view.getTag());
            }
        }

        public C1819d() {
        }

        public final void b(View view) {
            this.f67376a = (TbImageView) view.findViewById(R.id.image);
            this.f67377b = (ImageView) view.findViewById(R.id.delete_icon);
            ViewGroup.LayoutParams layoutParams = this.f67376a.getLayoutParams();
            layoutParams.width = d.this.f67371h;
            layoutParams.height = d.this.f67371h;
            SkinManager.setImageResource(this.f67377b, R.drawable.icon_live_close_n);
            this.f67376a.setOnClickListener(new a());
            this.f67377b.setOnClickListener(new b());
        }
    }

    public d(List<FaceData> list) {
        this.f67368e = list;
        int k = l.k(this.f67369f);
        this.f67372i = k;
        this.f67371h = (k - (l.g(this.f67369f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C1819d c1819d) {
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            int i2 = this.f67371h;
            imageFileInfo.addPageAction(d.a.m0.b0.g.d.g(i2, i2));
            d.a.c.k.d.a c2 = this.f67370g.c(imageFileInfo, false);
            c1819d.f67376a.setTag(imageFileInfo.toCachedKey(false));
            if (c2 != null) {
                c2.h(c1819d.f67376a);
                c1819d.f67376a.setTag(null);
            } else {
                this.f67370g.e(imageFileInfo, new b(this, viewGroup), false, false);
            }
            c1819d.f67377b.setVisibility(0);
        }
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C1819d c1819d) {
        if (emotionImageData != null) {
            Object k = d.a.c.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c1819d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            d.a.c.k.d.a aVar = (k == null || !(k instanceof d.a.c.k.d.a)) ? null : (d.a.c.k.d.a) k;
            if (aVar != null) {
                aVar.h(c1819d.f67376a);
                c1819d.f67376a.setTag(null);
            }
            c1819d.f67377b.setVisibility(0);
        }
    }

    public final void e(EmotionImageData emotionImageData, C1819d c1819d) {
        if (emotionImageData != null) {
            c1819d.f67376a.setTag(emotionImageData.getThumbUrl());
            c1819d.f67376a.U(emotionImageData.getThumbUrl(), 10, false);
            c1819d.f67377b.setVisibility(0);
        }
    }

    public void f(c cVar) {
        this.j = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FaceData> list = this.f67368e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<FaceData> list = this.f67368e;
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return this.f67368e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1819d c1819d;
        if (view == null) {
            c1819d = new C1819d();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
            c1819d.b(view2);
            view2.setTag(c1819d);
        } else {
            view2 = view;
            c1819d = (C1819d) view.getTag();
        }
        FaceData faceData = this.f67368e.get(i2);
        if (faceData != null) {
            int i3 = faceData.type;
            if (i3 == 4) {
                SkinManager.setImageResource(c1819d.f67376a, R.drawable.emotion_icon_add_pic);
                c1819d.f67377b.setVisibility(8);
            } else if (i3 == 1) {
                c1819d.f67376a.setImageDrawable(null);
                d(faceData.emotionImageData, viewGroup, c1819d);
            } else if (i3 == 2) {
                c1819d.f67376a.setImageDrawable(null);
                e(faceData.emotionImageData, c1819d);
            } else {
                c1819d.f67376a.setImageDrawable(null);
                c(faceData.imageFileInfo, viewGroup, c1819d);
            }
            TbImageView tbImageView = c1819d.f67376a;
            tbImageView.setTag(tbImageView.getId(), faceData);
        }
        c1819d.f67377b.setTag(faceData);
        return view2;
    }
}
