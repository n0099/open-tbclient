package d.b.i0.y1.g;

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
import d.b.c.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<FaceData> f64065e;

    /* renamed from: f  reason: collision with root package name */
    public Context f64066f = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.b0.b f64067g = new d.b.h0.b0.b();

    /* renamed from: h  reason: collision with root package name */
    public int f64068h;
    public int i;
    public c j;

    /* loaded from: classes3.dex */
    public class a extends d.b.c.e.l.c<d.b.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f64069a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C1721d f64070b;

        public a(d dVar, ViewGroup viewGroup, C1721d c1721d) {
            this.f64069a = viewGroup;
            this.f64070b = c1721d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            View findViewWithTag;
            if (aVar == null || (findViewWithTag = this.f64069a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f64070b.f64072a);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f64071e;

        public b(d dVar, ViewGroup viewGroup) {
            this.f64071e = viewGroup;
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.c.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f64071e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            aVar.h(tbImageView);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onAdd();

        void onDel(FaceData faceData);
    }

    /* renamed from: d.b.i0.y1.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1721d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f64072a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f64073b;

        /* renamed from: d.b.i0.y1.g.d$d$a */
        /* loaded from: classes3.dex */
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

        /* renamed from: d.b.i0.y1.g.d$d$b */
        /* loaded from: classes3.dex */
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

        public C1721d() {
        }

        public final void b(View view) {
            this.f64072a = (TbImageView) view.findViewById(R.id.image);
            this.f64073b = (ImageView) view.findViewById(R.id.delete_icon);
            ViewGroup.LayoutParams layoutParams = this.f64072a.getLayoutParams();
            layoutParams.width = d.this.f64068h;
            layoutParams.height = d.this.f64068h;
            SkinManager.setImageResource(this.f64073b, R.drawable.icon_live_close_n);
            this.f64072a.setOnClickListener(new a());
            this.f64073b.setOnClickListener(new b());
        }
    }

    public d(List<FaceData> list) {
        this.f64065e = list;
        int k = l.k(this.f64066f);
        this.i = k;
        this.f64068h = (k - (l.g(this.f64066f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C1721d c1721d) {
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            int i = this.f64068h;
            imageFileInfo.addPageAction(d.b.h0.b0.g.d.g(i, i));
            d.b.c.j.d.a c2 = this.f64067g.c(imageFileInfo, false);
            c1721d.f64072a.setTag(imageFileInfo.toCachedKey(false));
            if (c2 != null) {
                c2.h(c1721d.f64072a);
                c1721d.f64072a.setTag(null);
            } else {
                this.f64067g.e(imageFileInfo, new b(this, viewGroup), false, false);
            }
            c1721d.f64073b.setVisibility(0);
        }
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C1721d c1721d) {
        if (emotionImageData != null) {
            Object k = d.b.c.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c1721d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            d.b.c.j.d.a aVar = (k == null || !(k instanceof d.b.c.j.d.a)) ? null : (d.b.c.j.d.a) k;
            if (aVar != null) {
                aVar.h(c1721d.f64072a);
                c1721d.f64072a.setTag(null);
            }
            c1721d.f64073b.setVisibility(0);
        }
    }

    public final void e(EmotionImageData emotionImageData, C1721d c1721d) {
        if (emotionImageData != null) {
            c1721d.f64072a.setTag(emotionImageData.getThumbUrl());
            c1721d.f64072a.W(emotionImageData.getThumbUrl(), 10, false);
            c1721d.f64073b.setVisibility(0);
        }
    }

    public void f(c cVar) {
        this.j = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FaceData> list = this.f64065e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<FaceData> list = this.f64065e;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f64065e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1721d c1721d;
        if (view == null) {
            c1721d = new C1721d();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
            c1721d.b(view2);
            view2.setTag(c1721d);
        } else {
            view2 = view;
            c1721d = (C1721d) view.getTag();
        }
        FaceData faceData = this.f64065e.get(i);
        if (faceData != null) {
            int i2 = faceData.type;
            if (i2 == 4) {
                SkinManager.setImageResource(c1721d.f64072a, R.drawable.emotion_icon_add_pic);
                c1721d.f64073b.setVisibility(8);
            } else if (i2 == 1) {
                c1721d.f64072a.setImageDrawable(null);
                d(faceData.emotionImageData, viewGroup, c1721d);
            } else if (i2 == 2) {
                c1721d.f64072a.setImageDrawable(null);
                e(faceData.emotionImageData, c1721d);
            } else {
                c1721d.f64072a.setImageDrawable(null);
                c(faceData.imageFileInfo, viewGroup, c1721d);
            }
            TbImageView tbImageView = c1721d.f64072a;
            tbImageView.setTag(tbImageView.getId(), faceData);
        }
        c1721d.f64073b.setTag(faceData);
        return view2;
    }
}
