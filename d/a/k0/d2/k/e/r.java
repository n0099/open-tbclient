package d.a.k0.d2.k.e;

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
    public Context f53155e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.b0.b f53156f = new d.a.j0.b0.b();

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<ImageFileInfo> f53157g = null;

    /* renamed from: h  reason: collision with root package name */
    public int f53158h;

    /* renamed from: i  reason: collision with root package name */
    public int f53159i;
    public c j;

    /* loaded from: classes5.dex */
    public class a implements d.a.j0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f53160e;

        public a(r rVar, ViewGroup viewGroup) {
            this.f53160e = viewGroup;
        }

        @Override // d.a.j0.a0.b
        public void a(d.a.c.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f53160e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f53161a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53162b;

        public b(r rVar, ViewGroup viewGroup, String str) {
            this.f53161a = viewGroup;
            this.f53162b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            TbImageView tbImageView = (TbImageView) this.f53161a.findViewWithTag(this.f53162b);
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
        public TbImageView f53163a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f53164b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f53165c;
    }

    public r(Context context) {
        this.f53155e = null;
        this.f53155e = context;
        int k = d.a.c.e.p.l.k(context);
        this.f53159i = k;
        this.f53158h = ((k - (d.a.c.e.p.l.g(this.f53155e, R.dimen.tbds44) * 2)) - (d.a.c.e.p.l.g(this.f53155e, R.dimen.tbds10) * 2)) / 3;
    }

    public final void a(ImageFileInfo imageFileInfo, d dVar, ViewGroup viewGroup) {
        if (imageFileInfo == null) {
            return;
        }
        int i2 = this.f53158h;
        ImageOperation g2 = d.a.j0.b0.g.d.g(i2, i2);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        if (imageFileInfo.getImageType() == 0) {
            d.a.c.j.d.a c2 = this.f53156f.c(imageFileInfo, true);
            dVar.f53163a.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                dVar.f53163a.invalidate();
            } else {
                this.f53156f.d(imageFileInfo, new a(this, viewGroup), true);
            }
            dVar.f53163a.setTagStr(this.f53155e.getString(R.string.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!d.a.c.e.p.k.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g3 = d.a.c.e.l.d.h().g(filePath, 20);
                dVar.f53163a.setTag(g3);
                d.a.c.e.l.d.h().k(filePath, 20, new b(this, viewGroup, g3), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            dVar.f53163a.setTagStr("");
        }
    }

    public void b(c cVar) {
        this.j = cVar;
    }

    public void c(LinkedList<ImageFileInfo> linkedList) {
        this.f53157g = linkedList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        LinkedList<ImageFileInfo> linkedList = this.f53157g;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        LinkedList<ImageFileInfo> linkedList = this.f53157g;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() - 1 >= i2) {
            return this.f53157g.get(i2);
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
            dVar.f53163a = (TbImageView) view2.findViewById(R.id.iv_photo_live);
            dVar.f53164b = (LinearLayout) view2.findViewById(R.id.layout_del);
            dVar.f53165c = (ImageView) view2.findViewById(R.id.delete_photo_live);
            dVar.f53163a.setOnClickListener(this);
            dVar.f53163a.setTagTextSize(d.a.c.e.p.l.g(this.f53155e, R.dimen.tbds30));
            dVar.f53163a.setDrawBorder(true);
            dVar.f53163a.setDrawCorner(false);
            dVar.f53163a.setRadius(0);
            dVar.f53164b.setOnClickListener(this);
            dVar.f53163a.setGifIconSupport(true);
            dVar.f53163a.setLongIconSupport(true);
            SkinManager.setBackgroundResource(dVar.f53165c, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = dVar.f53163a.getLayoutParams();
            int i3 = this.f53158h;
            layoutParams.width = i3;
            layoutParams.height = i3;
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        LinkedList<ImageFileInfo> linkedList = this.f53157g;
        if (linkedList != null && linkedList.size() - 1 >= i2) {
            a(this.f53157g.get(i2), dVar, viewGroup);
            TbImageView tbImageView = dVar.f53163a;
            tbImageView.setTag(tbImageView.getId(), Integer.valueOf(i2));
            dVar.f53164b.setTag(Integer.valueOf(i2));
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
