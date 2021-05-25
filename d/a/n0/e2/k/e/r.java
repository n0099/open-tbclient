package d.a.n0.e2.k.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class r extends BaseAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f53411e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.b0.b f53412f = new d.a.m0.b0.b();

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<ImageFileInfo> f53413g = null;

    /* renamed from: h  reason: collision with root package name */
    public int f53414h;

    /* renamed from: i  reason: collision with root package name */
    public int f53415i;
    public c j;

    /* loaded from: classes5.dex */
    public class a implements d.a.m0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f53416e;

        public a(r rVar, ViewGroup viewGroup) {
            this.f53416e = viewGroup;
        }

        @Override // d.a.m0.a0.b
        public void a(d.a.c.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f53416e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f53417a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53418b;

        public b(r rVar, ViewGroup viewGroup, String str) {
            this.f53417a = viewGroup;
            this.f53418b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            TbImageView tbImageView = (TbImageView) this.f53417a.findViewWithTag(this.f53418b);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onClickImage(int i2);

        void onDeleteImage(int i2);
    }

    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f53419a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f53420b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f53421c;
    }

    public r(Context context) {
        this.f53411e = null;
        this.f53411e = context;
        int k = d.a.c.e.p.l.k(context);
        this.f53415i = k;
        this.f53414h = ((k - (d.a.c.e.p.l.g(this.f53411e, R.dimen.tbds44) * 2)) - (d.a.c.e.p.l.g(this.f53411e, R.dimen.tbds10) * 2)) / 3;
    }

    public final void a(ImageFileInfo imageFileInfo, d dVar, ViewGroup viewGroup) {
        if (imageFileInfo == null) {
            return;
        }
        int i2 = this.f53414h;
        ImageOperation g2 = d.a.m0.b0.g.d.g(i2, i2);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        if (imageFileInfo.getImageType() == 0) {
            d.a.c.j.d.a c2 = this.f53412f.c(imageFileInfo, true);
            dVar.f53419a.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                dVar.f53419a.invalidate();
            } else {
                this.f53412f.d(imageFileInfo, new a(this, viewGroup), true);
            }
            dVar.f53419a.setTagStr(this.f53411e.getString(R.string.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!d.a.c.e.p.k.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g3 = d.a.c.e.l.d.h().g(filePath, 20);
                dVar.f53419a.setTag(g3);
                d.a.c.e.l.d.h().k(filePath, 20, new b(this, viewGroup, g3), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            dVar.f53419a.setTagStr("");
        }
    }

    public void b(c cVar) {
        this.j = cVar;
    }

    public void c(LinkedList<ImageFileInfo> linkedList) {
        this.f53413g = linkedList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        LinkedList<ImageFileInfo> linkedList = this.f53413g;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        LinkedList<ImageFileInfo> linkedList = this.f53413g;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() - 1 >= i2) {
            return this.f53413g.get(i2);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        d dVar;
        if (view == null) {
            dVar = new d();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            dVar.f53419a = (TbImageView) view2.findViewById(R.id.iv_photo_live);
            dVar.f53420b = (LinearLayout) view2.findViewById(R.id.layout_del);
            dVar.f53421c = (ImageView) view2.findViewById(R.id.delete_photo_live);
            dVar.f53419a.setOnClickListener(this);
            dVar.f53419a.setTagTextSize(d.a.c.e.p.l.g(this.f53411e, R.dimen.tbds30));
            dVar.f53419a.setDrawBorder(true);
            dVar.f53419a.setDrawCorner(false);
            dVar.f53419a.setRadius(0);
            dVar.f53420b.setOnClickListener(this);
            dVar.f53419a.setGifIconSupport(true);
            dVar.f53419a.setLongIconSupport(true);
            SkinManager.setBackgroundResource(dVar.f53421c, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = dVar.f53419a.getLayoutParams();
            int i3 = this.f53414h;
            layoutParams.width = i3;
            layoutParams.height = i3;
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        LinkedList<ImageFileInfo> linkedList = this.f53413g;
        if (linkedList != null && linkedList.size() - 1 >= i2) {
            a(this.f53413g.get(i2), dVar, viewGroup);
            TbImageView tbImageView = dVar.f53419a;
            tbImageView.setTag(tbImageView.getId(), Integer.valueOf(i2));
            dVar.f53420b.setTag(Integer.valueOf(i2));
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar;
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            c cVar2 = this.j;
            if (cVar2 != null) {
                cVar2.onDeleteImage(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && (cVar = this.j) != null) {
            cVar.onClickImage(((Integer) view.getTag(view.getId())).intValue());
        }
    }
}
