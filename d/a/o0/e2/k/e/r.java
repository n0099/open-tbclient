package d.a.o0.e2.k.e;

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
    public Context f57225e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.b0.b f57226f = new d.a.n0.b0.b();

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<ImageFileInfo> f57227g = null;

    /* renamed from: h  reason: collision with root package name */
    public int f57228h;

    /* renamed from: i  reason: collision with root package name */
    public int f57229i;
    public c j;

    /* loaded from: classes5.dex */
    public class a implements d.a.n0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f57230e;

        public a(r rVar, ViewGroup viewGroup) {
            this.f57230e = viewGroup;
        }

        @Override // d.a.n0.a0.b
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f57230e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f57231a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f57232b;

        public b(r rVar, ViewGroup viewGroup, String str) {
            this.f57231a = viewGroup;
            this.f57232b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            TbImageView tbImageView = (TbImageView) this.f57231a.findViewWithTag(this.f57232b);
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
        public TbImageView f57233a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f57234b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f57235c;
    }

    public r(Context context) {
        this.f57225e = null;
        this.f57225e = context;
        int k = d.a.c.e.p.l.k(context);
        this.f57229i = k;
        this.f57228h = ((k - (d.a.c.e.p.l.g(this.f57225e, R.dimen.tbds44) * 2)) - (d.a.c.e.p.l.g(this.f57225e, R.dimen.tbds10) * 2)) / 3;
    }

    public final void a(ImageFileInfo imageFileInfo, d dVar, ViewGroup viewGroup) {
        if (imageFileInfo == null) {
            return;
        }
        int i2 = this.f57228h;
        ImageOperation g2 = d.a.n0.b0.g.d.g(i2, i2);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        if (imageFileInfo.getImageType() == 0) {
            d.a.c.k.d.a c2 = this.f57226f.c(imageFileInfo, true);
            dVar.f57233a.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                dVar.f57233a.invalidate();
            } else {
                this.f57226f.d(imageFileInfo, new a(this, viewGroup), true);
            }
            dVar.f57233a.setTagStr(this.f57225e.getString(R.string.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!d.a.c.e.p.k.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g3 = d.a.c.e.l.d.h().g(filePath, 20);
                dVar.f57233a.setTag(g3);
                d.a.c.e.l.d.h().k(filePath, 20, new b(this, viewGroup, g3), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            dVar.f57233a.setTagStr("");
        }
    }

    public void b(c cVar) {
        this.j = cVar;
    }

    public void c(LinkedList<ImageFileInfo> linkedList) {
        this.f57227g = linkedList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        LinkedList<ImageFileInfo> linkedList = this.f57227g;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        LinkedList<ImageFileInfo> linkedList = this.f57227g;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() - 1 >= i2) {
            return this.f57227g.get(i2);
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
            dVar.f57233a = (TbImageView) view2.findViewById(R.id.iv_photo_live);
            dVar.f57234b = (LinearLayout) view2.findViewById(R.id.layout_del);
            dVar.f57235c = (ImageView) view2.findViewById(R.id.delete_photo_live);
            dVar.f57233a.setOnClickListener(this);
            dVar.f57233a.setTagTextSize(d.a.c.e.p.l.g(this.f57225e, R.dimen.tbds30));
            dVar.f57233a.setDrawBorder(true);
            dVar.f57233a.setDrawCorner(false);
            dVar.f57233a.setRadius(0);
            dVar.f57234b.setOnClickListener(this);
            dVar.f57233a.setGifIconSupport(true);
            dVar.f57233a.setLongIconSupport(true);
            SkinManager.setBackgroundResource(dVar.f57235c, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = dVar.f57233a.getLayoutParams();
            int i3 = this.f57228h;
            layoutParams.width = i3;
            layoutParams.height = i3;
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        LinkedList<ImageFileInfo> linkedList = this.f57227g;
        if (linkedList != null && linkedList.size() - 1 >= i2) {
            a(this.f57227g.get(i2), dVar, viewGroup);
            TbImageView tbImageView = dVar.f57233a;
            tbImageView.setTag(tbImageView.getId(), Integer.valueOf(i2));
            dVar.f57234b.setTag(Integer.valueOf(i2));
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
