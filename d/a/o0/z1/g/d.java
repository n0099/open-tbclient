package d.a.o0.z1.g;

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
/* loaded from: classes5.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<FaceData> f67493e;

    /* renamed from: f  reason: collision with root package name */
    public Context f67494f = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.b0.b f67495g = new d.a.n0.b0.b();

    /* renamed from: h  reason: collision with root package name */
    public int f67496h;

    /* renamed from: i  reason: collision with root package name */
    public int f67497i;
    public c j;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f67498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C1823d f67499b;

        public a(d dVar, ViewGroup viewGroup, C1823d c1823d) {
            this.f67498a = viewGroup;
            this.f67499b = c1823d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            View findViewWithTag;
            if (aVar == null || (findViewWithTag = this.f67498a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f67499b.f67501a);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.n0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f67500e;

        public b(d dVar, ViewGroup viewGroup) {
            this.f67500e = viewGroup;
        }

        @Override // d.a.n0.a0.b
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f67500e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            aVar.h(tbImageView);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onAdd();

        void onDel(FaceData faceData);
    }

    /* renamed from: d.a.o0.z1.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1823d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f67501a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f67502b;

        /* renamed from: d.a.o0.z1.g.d$d$a */
        /* loaded from: classes5.dex */
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

        /* renamed from: d.a.o0.z1.g.d$d$b */
        /* loaded from: classes5.dex */
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

        public C1823d() {
        }

        public final void b(View view) {
            this.f67501a = (TbImageView) view.findViewById(R.id.image);
            this.f67502b = (ImageView) view.findViewById(R.id.delete_icon);
            ViewGroup.LayoutParams layoutParams = this.f67501a.getLayoutParams();
            layoutParams.width = d.this.f67496h;
            layoutParams.height = d.this.f67496h;
            SkinManager.setImageResource(this.f67502b, R.drawable.icon_live_close_n);
            this.f67501a.setOnClickListener(new a());
            this.f67502b.setOnClickListener(new b());
        }
    }

    public d(List<FaceData> list) {
        this.f67493e = list;
        int k = l.k(this.f67494f);
        this.f67497i = k;
        this.f67496h = (k - (l.g(this.f67494f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C1823d c1823d) {
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            int i2 = this.f67496h;
            imageFileInfo.addPageAction(d.a.n0.b0.g.d.g(i2, i2));
            d.a.c.k.d.a c2 = this.f67495g.c(imageFileInfo, false);
            c1823d.f67501a.setTag(imageFileInfo.toCachedKey(false));
            if (c2 != null) {
                c2.h(c1823d.f67501a);
                c1823d.f67501a.setTag(null);
            } else {
                this.f67495g.e(imageFileInfo, new b(this, viewGroup), false, false);
            }
            c1823d.f67502b.setVisibility(0);
        }
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C1823d c1823d) {
        if (emotionImageData != null) {
            Object k = d.a.c.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c1823d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            d.a.c.k.d.a aVar = (k == null || !(k instanceof d.a.c.k.d.a)) ? null : (d.a.c.k.d.a) k;
            if (aVar != null) {
                aVar.h(c1823d.f67501a);
                c1823d.f67501a.setTag(null);
            }
            c1823d.f67502b.setVisibility(0);
        }
    }

    public final void e(EmotionImageData emotionImageData, C1823d c1823d) {
        if (emotionImageData != null) {
            c1823d.f67501a.setTag(emotionImageData.getThumbUrl());
            c1823d.f67501a.U(emotionImageData.getThumbUrl(), 10, false);
            c1823d.f67502b.setVisibility(0);
        }
    }

    public void f(c cVar) {
        this.j = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FaceData> list = this.f67493e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<FaceData> list = this.f67493e;
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return this.f67493e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1823d c1823d;
        if (view == null) {
            c1823d = new C1823d();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
            c1823d.b(view2);
            view2.setTag(c1823d);
        } else {
            view2 = view;
            c1823d = (C1823d) view.getTag();
        }
        FaceData faceData = this.f67493e.get(i2);
        if (faceData != null) {
            int i3 = faceData.type;
            if (i3 == 4) {
                SkinManager.setImageResource(c1823d.f67501a, R.drawable.emotion_icon_add_pic);
                c1823d.f67502b.setVisibility(8);
            } else if (i3 == 1) {
                c1823d.f67501a.setImageDrawable(null);
                d(faceData.emotionImageData, viewGroup, c1823d);
            } else if (i3 == 2) {
                c1823d.f67501a.setImageDrawable(null);
                e(faceData.emotionImageData, c1823d);
            } else {
                c1823d.f67501a.setImageDrawable(null);
                c(faceData.imageFileInfo, viewGroup, c1823d);
            }
            TbImageView tbImageView = c1823d.f67501a;
            tbImageView.setTag(tbImageView.getId(), faceData);
        }
        c1823d.f67502b.setTag(faceData);
        return view2;
    }
}
