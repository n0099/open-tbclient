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
/* loaded from: classes4.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<FaceData> f62379e;

    /* renamed from: f  reason: collision with root package name */
    public Context f62380f = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.b0.b f62381g = new d.b.h0.b0.b();

    /* renamed from: h  reason: collision with root package name */
    public int f62382h;
    public int i;
    public c j;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f62383a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C1661d f62384b;

        public a(d dVar, ViewGroup viewGroup, C1661d c1661d) {
            this.f62383a = viewGroup;
            this.f62384b = c1661d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            View findViewWithTag;
            if (aVar == null || (findViewWithTag = this.f62383a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f62384b.f62386a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.h0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f62385e;

        public b(d dVar, ViewGroup viewGroup) {
            this.f62385e = viewGroup;
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.b.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f62385e.findViewWithTag(str);
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

    /* renamed from: d.b.i0.x1.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1661d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62386a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f62387b;

        /* renamed from: d.b.i0.x1.g.d$d$a */
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

        /* renamed from: d.b.i0.x1.g.d$d$b */
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

        public C1661d() {
        }

        public final void b(View view) {
            this.f62386a = (TbImageView) view.findViewById(R.id.image);
            this.f62387b = (ImageView) view.findViewById(R.id.delete_icon);
            ViewGroup.LayoutParams layoutParams = this.f62386a.getLayoutParams();
            layoutParams.width = d.this.f62382h;
            layoutParams.height = d.this.f62382h;
            SkinManager.setImageResource(this.f62387b, R.drawable.icon_live_close_n);
            this.f62386a.setOnClickListener(new a());
            this.f62387b.setOnClickListener(new b());
        }
    }

    public d(List<FaceData> list) {
        this.f62379e = list;
        int k = l.k(this.f62380f);
        this.i = k;
        this.f62382h = (k - (l.g(this.f62380f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C1661d c1661d) {
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            int i = this.f62382h;
            imageFileInfo.addPageAction(d.b.h0.b0.g.d.g(i, i));
            d.b.b.j.d.a c2 = this.f62381g.c(imageFileInfo, false);
            c1661d.f62386a.setTag(imageFileInfo.toCachedKey(false));
            if (c2 != null) {
                c2.h(c1661d.f62386a);
                c1661d.f62386a.setTag(null);
            } else {
                this.f62381g.e(imageFileInfo, new b(this, viewGroup), false, false);
            }
            c1661d.f62387b.setVisibility(0);
        }
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C1661d c1661d) {
        if (emotionImageData != null) {
            Object k = d.b.b.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c1661d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            d.b.b.j.d.a aVar = (k == null || !(k instanceof d.b.b.j.d.a)) ? null : (d.b.b.j.d.a) k;
            if (aVar != null) {
                aVar.h(c1661d.f62386a);
                c1661d.f62386a.setTag(null);
            }
            c1661d.f62387b.setVisibility(0);
        }
    }

    public final void e(EmotionImageData emotionImageData, C1661d c1661d) {
        if (emotionImageData != null) {
            c1661d.f62386a.setTag(emotionImageData.getThumbUrl());
            c1661d.f62386a.W(emotionImageData.getThumbUrl(), 10, false);
            c1661d.f62387b.setVisibility(0);
        }
    }

    public void f(c cVar) {
        this.j = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FaceData> list = this.f62379e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<FaceData> list = this.f62379e;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f62379e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1661d c1661d;
        if (view == null) {
            c1661d = new C1661d();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
            c1661d.b(view2);
            view2.setTag(c1661d);
        } else {
            view2 = view;
            c1661d = (C1661d) view.getTag();
        }
        FaceData faceData = this.f62379e.get(i);
        if (faceData != null) {
            int i2 = faceData.type;
            if (i2 == 4) {
                SkinManager.setImageResource(c1661d.f62386a, R.drawable.emotion_icon_add_pic);
                c1661d.f62387b.setVisibility(8);
            } else if (i2 == 1) {
                c1661d.f62386a.setImageDrawable(null);
                d(faceData.emotionImageData, viewGroup, c1661d);
            } else if (i2 == 2) {
                c1661d.f62386a.setImageDrawable(null);
                e(faceData.emotionImageData, c1661d);
            } else {
                c1661d.f62386a.setImageDrawable(null);
                c(faceData.imageFileInfo, viewGroup, c1661d);
            }
            TbImageView tbImageView = c1661d.f62386a;
            tbImageView.setTag(tbImageView.getId(), faceData);
        }
        c1661d.f62387b.setTag(faceData);
        return view2;
    }
}
