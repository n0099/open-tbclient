package d.b.j0.y1.g;

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
    public List<FaceData> f64486e;

    /* renamed from: f  reason: collision with root package name */
    public Context f64487f = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.b0.b f64488g = new d.b.i0.b0.b();

    /* renamed from: h  reason: collision with root package name */
    public int f64489h;
    public int i;
    public c j;

    /* loaded from: classes3.dex */
    public class a extends d.b.c.e.l.c<d.b.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f64490a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C1744d f64491b;

        public a(d dVar, ViewGroup viewGroup, C1744d c1744d) {
            this.f64490a = viewGroup;
            this.f64491b = c1744d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            View findViewWithTag;
            if (aVar == null || (findViewWithTag = this.f64490a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f64491b.f64493a);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.i0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f64492e;

        public b(d dVar, ViewGroup viewGroup) {
            this.f64492e = viewGroup;
        }

        @Override // d.b.i0.a0.b
        public void a(d.b.c.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f64492e.findViewWithTag(str);
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

    /* renamed from: d.b.j0.y1.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1744d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f64493a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f64494b;

        /* renamed from: d.b.j0.y1.g.d$d$a */
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

        /* renamed from: d.b.j0.y1.g.d$d$b */
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

        public C1744d() {
        }

        public final void b(View view) {
            this.f64493a = (TbImageView) view.findViewById(R.id.image);
            this.f64494b = (ImageView) view.findViewById(R.id.delete_icon);
            ViewGroup.LayoutParams layoutParams = this.f64493a.getLayoutParams();
            layoutParams.width = d.this.f64489h;
            layoutParams.height = d.this.f64489h;
            SkinManager.setImageResource(this.f64494b, R.drawable.icon_live_close_n);
            this.f64493a.setOnClickListener(new a());
            this.f64494b.setOnClickListener(new b());
        }
    }

    public d(List<FaceData> list) {
        this.f64486e = list;
        int k = l.k(this.f64487f);
        this.i = k;
        this.f64489h = (k - (l.g(this.f64487f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C1744d c1744d) {
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            int i = this.f64489h;
            imageFileInfo.addPageAction(d.b.i0.b0.g.d.g(i, i));
            d.b.c.j.d.a c2 = this.f64488g.c(imageFileInfo, false);
            c1744d.f64493a.setTag(imageFileInfo.toCachedKey(false));
            if (c2 != null) {
                c2.h(c1744d.f64493a);
                c1744d.f64493a.setTag(null);
            } else {
                this.f64488g.e(imageFileInfo, new b(this, viewGroup), false, false);
            }
            c1744d.f64494b.setVisibility(0);
        }
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C1744d c1744d) {
        if (emotionImageData != null) {
            Object k = d.b.c.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c1744d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            d.b.c.j.d.a aVar = (k == null || !(k instanceof d.b.c.j.d.a)) ? null : (d.b.c.j.d.a) k;
            if (aVar != null) {
                aVar.h(c1744d.f64493a);
                c1744d.f64493a.setTag(null);
            }
            c1744d.f64494b.setVisibility(0);
        }
    }

    public final void e(EmotionImageData emotionImageData, C1744d c1744d) {
        if (emotionImageData != null) {
            c1744d.f64493a.setTag(emotionImageData.getThumbUrl());
            c1744d.f64493a.W(emotionImageData.getThumbUrl(), 10, false);
            c1744d.f64494b.setVisibility(0);
        }
    }

    public void f(c cVar) {
        this.j = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FaceData> list = this.f64486e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<FaceData> list = this.f64486e;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f64486e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1744d c1744d;
        if (view == null) {
            c1744d = new C1744d();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
            c1744d.b(view2);
            view2.setTag(c1744d);
        } else {
            view2 = view;
            c1744d = (C1744d) view.getTag();
        }
        FaceData faceData = this.f64486e.get(i);
        if (faceData != null) {
            int i2 = faceData.type;
            if (i2 == 4) {
                SkinManager.setImageResource(c1744d.f64493a, R.drawable.emotion_icon_add_pic);
                c1744d.f64494b.setVisibility(8);
            } else if (i2 == 1) {
                c1744d.f64493a.setImageDrawable(null);
                d(faceData.emotionImageData, viewGroup, c1744d);
            } else if (i2 == 2) {
                c1744d.f64493a.setImageDrawable(null);
                e(faceData.emotionImageData, c1744d);
            } else {
                c1744d.f64493a.setImageDrawable(null);
                c(faceData.imageFileInfo, viewGroup, c1744d);
            }
            TbImageView tbImageView = c1744d.f64493a;
            tbImageView.setTag(tbImageView.getId(), faceData);
        }
        c1744d.f64494b.setTag(faceData);
        return view2;
    }
}
