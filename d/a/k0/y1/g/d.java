package d.a.k0.y1.g;

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
    public List<FaceData> f63486e;

    /* renamed from: f  reason: collision with root package name */
    public Context f63487f = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.b0.b f63488g = new d.a.j0.b0.b();

    /* renamed from: h  reason: collision with root package name */
    public int f63489h;

    /* renamed from: i  reason: collision with root package name */
    public int f63490i;
    public c j;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f63491a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C1746d f63492b;

        public a(d dVar, ViewGroup viewGroup, C1746d c1746d) {
            this.f63491a = viewGroup;
            this.f63492b = c1746d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            View findViewWithTag;
            if (aVar == null || (findViewWithTag = this.f63491a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f63492b.f63494a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.j0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f63493e;

        public b(d dVar, ViewGroup viewGroup) {
            this.f63493e = viewGroup;
        }

        @Override // d.a.j0.a0.b
        public void a(d.a.c.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f63493e.findViewWithTag(str);
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

    /* renamed from: d.a.k0.y1.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1746d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f63494a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f63495b;

        /* renamed from: d.a.k0.y1.g.d$d$a */
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

        /* renamed from: d.a.k0.y1.g.d$d$b */
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

        public C1746d() {
        }

        public final void b(View view) {
            this.f63494a = (TbImageView) view.findViewById(R.id.image);
            this.f63495b = (ImageView) view.findViewById(R.id.delete_icon);
            ViewGroup.LayoutParams layoutParams = this.f63494a.getLayoutParams();
            layoutParams.width = d.this.f63489h;
            layoutParams.height = d.this.f63489h;
            SkinManager.setImageResource(this.f63495b, R.drawable.icon_live_close_n);
            this.f63494a.setOnClickListener(new a());
            this.f63495b.setOnClickListener(new b());
        }
    }

    public d(List<FaceData> list) {
        this.f63486e = list;
        int k = l.k(this.f63487f);
        this.f63490i = k;
        this.f63489h = (k - (l.g(this.f63487f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C1746d c1746d) {
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            int i2 = this.f63489h;
            imageFileInfo.addPageAction(d.a.j0.b0.g.d.g(i2, i2));
            d.a.c.j.d.a c2 = this.f63488g.c(imageFileInfo, false);
            c1746d.f63494a.setTag(imageFileInfo.toCachedKey(false));
            if (c2 != null) {
                c2.h(c1746d.f63494a);
                c1746d.f63494a.setTag(null);
            } else {
                this.f63488g.e(imageFileInfo, new b(this, viewGroup), false, false);
            }
            c1746d.f63495b.setVisibility(0);
        }
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C1746d c1746d) {
        if (emotionImageData != null) {
            Object k = d.a.c.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c1746d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            d.a.c.j.d.a aVar = (k == null || !(k instanceof d.a.c.j.d.a)) ? null : (d.a.c.j.d.a) k;
            if (aVar != null) {
                aVar.h(c1746d.f63494a);
                c1746d.f63494a.setTag(null);
            }
            c1746d.f63495b.setVisibility(0);
        }
    }

    public final void e(EmotionImageData emotionImageData, C1746d c1746d) {
        if (emotionImageData != null) {
            c1746d.f63494a.setTag(emotionImageData.getThumbUrl());
            c1746d.f63494a.V(emotionImageData.getThumbUrl(), 10, false);
            c1746d.f63495b.setVisibility(0);
        }
    }

    public void f(c cVar) {
        this.j = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FaceData> list = this.f63486e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<FaceData> list = this.f63486e;
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return this.f63486e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1746d c1746d;
        if (view == null) {
            c1746d = new C1746d();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
            c1746d.b(view2);
            view2.setTag(c1746d);
        } else {
            view2 = view;
            c1746d = (C1746d) view.getTag();
        }
        FaceData faceData = this.f63486e.get(i2);
        if (faceData != null) {
            int i3 = faceData.type;
            if (i3 == 4) {
                SkinManager.setImageResource(c1746d.f63494a, R.drawable.emotion_icon_add_pic);
                c1746d.f63495b.setVisibility(8);
            } else if (i3 == 1) {
                c1746d.f63494a.setImageDrawable(null);
                d(faceData.emotionImageData, viewGroup, c1746d);
            } else if (i3 == 2) {
                c1746d.f63494a.setImageDrawable(null);
                e(faceData.emotionImageData, c1746d);
            } else {
                c1746d.f63494a.setImageDrawable(null);
                c(faceData.imageFileInfo, viewGroup, c1746d);
            }
            TbImageView tbImageView = c1746d.f63494a;
            tbImageView.setTag(tbImageView.getId(), faceData);
        }
        c1746d.f63495b.setTag(faceData);
        return view2;
    }
}
