package d.b.i0.x1.g;

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
import d.b.b.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<FaceData> f62380e;

    /* renamed from: f  reason: collision with root package name */
    public Context f62381f = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.b0.b f62382g = new d.b.h0.b0.b();

    /* renamed from: h  reason: collision with root package name */
    public int f62383h;
    public int i;
    public c j;

    /* loaded from: classes3.dex */
    public class a extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f62384a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C1662d f62385b;

        public a(d dVar, ViewGroup viewGroup, C1662d c1662d) {
            this.f62384a = viewGroup;
            this.f62385b = c1662d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            View findViewWithTag;
            if (aVar == null || (findViewWithTag = this.f62384a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f62385b.f62387a);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f62386e;

        public b(d dVar, ViewGroup viewGroup) {
            this.f62386e = viewGroup;
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.b.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f62386e.findViewWithTag(str);
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

    /* renamed from: d.b.i0.x1.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1662d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62387a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f62388b;

        /* renamed from: d.b.i0.x1.g.d$d$a */
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

        /* renamed from: d.b.i0.x1.g.d$d$b */
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

        public C1662d() {
        }

        public final void b(View view) {
            this.f62387a = (TbImageView) view.findViewById(R.id.image);
            this.f62388b = (ImageView) view.findViewById(R.id.delete_icon);
            ViewGroup.LayoutParams layoutParams = this.f62387a.getLayoutParams();
            layoutParams.width = d.this.f62383h;
            layoutParams.height = d.this.f62383h;
            SkinManager.setImageResource(this.f62388b, R.drawable.icon_live_close_n);
            this.f62387a.setOnClickListener(new a());
            this.f62388b.setOnClickListener(new b());
        }
    }

    public d(List<FaceData> list) {
        this.f62380e = list;
        int k = l.k(this.f62381f);
        this.i = k;
        this.f62383h = (k - (l.g(this.f62381f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C1662d c1662d) {
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            int i = this.f62383h;
            imageFileInfo.addPageAction(d.b.h0.b0.g.d.g(i, i));
            d.b.b.j.d.a c2 = this.f62382g.c(imageFileInfo, false);
            c1662d.f62387a.setTag(imageFileInfo.toCachedKey(false));
            if (c2 != null) {
                c2.h(c1662d.f62387a);
                c1662d.f62387a.setTag(null);
            } else {
                this.f62382g.e(imageFileInfo, new b(this, viewGroup), false, false);
            }
            c1662d.f62388b.setVisibility(0);
        }
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C1662d c1662d) {
        if (emotionImageData != null) {
            Object k = d.b.b.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c1662d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            d.b.b.j.d.a aVar = (k == null || !(k instanceof d.b.b.j.d.a)) ? null : (d.b.b.j.d.a) k;
            if (aVar != null) {
                aVar.h(c1662d.f62387a);
                c1662d.f62387a.setTag(null);
            }
            c1662d.f62388b.setVisibility(0);
        }
    }

    public final void e(EmotionImageData emotionImageData, C1662d c1662d) {
        if (emotionImageData != null) {
            c1662d.f62387a.setTag(emotionImageData.getThumbUrl());
            c1662d.f62387a.W(emotionImageData.getThumbUrl(), 10, false);
            c1662d.f62388b.setVisibility(0);
        }
    }

    public void f(c cVar) {
        this.j = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FaceData> list = this.f62380e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<FaceData> list = this.f62380e;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f62380e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1662d c1662d;
        if (view == null) {
            c1662d = new C1662d();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
            c1662d.b(view2);
            view2.setTag(c1662d);
        } else {
            view2 = view;
            c1662d = (C1662d) view.getTag();
        }
        FaceData faceData = this.f62380e.get(i);
        if (faceData != null) {
            int i2 = faceData.type;
            if (i2 == 4) {
                SkinManager.setImageResource(c1662d.f62387a, R.drawable.emotion_icon_add_pic);
                c1662d.f62388b.setVisibility(8);
            } else if (i2 == 1) {
                c1662d.f62387a.setImageDrawable(null);
                d(faceData.emotionImageData, viewGroup, c1662d);
            } else if (i2 == 2) {
                c1662d.f62387a.setImageDrawable(null);
                e(faceData.emotionImageData, c1662d);
            } else {
                c1662d.f62387a.setImageDrawable(null);
                c(faceData.imageFileInfo, viewGroup, c1662d);
            }
            TbImageView tbImageView = c1662d.f62387a;
            tbImageView.setTag(tbImageView.getId(), faceData);
        }
        c1662d.f62388b.setTag(faceData);
        return view2;
    }
}
