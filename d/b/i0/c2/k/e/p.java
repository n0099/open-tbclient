package d.b.i0.c2.k.e;

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
/* loaded from: classes4.dex */
public class p extends BaseAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f52740e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.b0.b f52741f = new d.b.h0.b0.b();

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<ImageFileInfo> f52742g = null;

    /* renamed from: h  reason: collision with root package name */
    public int f52743h;
    public int i;
    public c j;

    /* loaded from: classes4.dex */
    public class a implements d.b.h0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f52744e;

        public a(p pVar, ViewGroup viewGroup) {
            this.f52744e = viewGroup;
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.b.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f52744e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f52745a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f52746b;

        public b(p pVar, ViewGroup viewGroup, String str) {
            this.f52745a = viewGroup;
            this.f52746b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            TbImageView tbImageView = (TbImageView) this.f52745a.findViewWithTag(this.f52746b);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onClickImage(int i);

        void onDeleteImage(int i);
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f52747a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f52748b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f52749c;
    }

    public p(Context context) {
        this.f52740e = null;
        this.f52740e = context;
        int k = d.b.b.e.p.l.k(context);
        this.i = k;
        this.f52743h = ((k - (d.b.b.e.p.l.g(this.f52740e, R.dimen.tbds44) * 2)) - (d.b.b.e.p.l.g(this.f52740e, R.dimen.tbds10) * 2)) / 3;
    }

    public final void a(ImageFileInfo imageFileInfo, d dVar, ViewGroup viewGroup) {
        if (imageFileInfo == null) {
            return;
        }
        int i = this.f52743h;
        ImageOperation g2 = d.b.h0.b0.g.d.g(i, i);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        if (imageFileInfo.getImageType() == 0) {
            d.b.b.j.d.a c2 = this.f52741f.c(imageFileInfo, true);
            dVar.f52747a.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                dVar.f52747a.invalidate();
            } else {
                this.f52741f.d(imageFileInfo, new a(this, viewGroup), true);
            }
            dVar.f52747a.setTagStr(this.f52740e.getString(R.string.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!d.b.b.e.p.k.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g3 = d.b.b.e.l.d.h().g(filePath, 20);
                dVar.f52747a.setTag(g3);
                d.b.b.e.l.d.h().k(filePath, 20, new b(this, viewGroup, g3), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            dVar.f52747a.setTagStr("");
        }
    }

    public void b(c cVar) {
        this.j = cVar;
    }

    public void c(LinkedList<ImageFileInfo> linkedList) {
        this.f52742g = linkedList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        LinkedList<ImageFileInfo> linkedList = this.f52742g;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        LinkedList<ImageFileInfo> linkedList = this.f52742g;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() - 1 >= i) {
            return this.f52742g.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        d dVar;
        if (view == null) {
            dVar = new d();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            dVar.f52747a = (TbImageView) view2.findViewById(R.id.iv_photo_live);
            dVar.f52748b = (LinearLayout) view2.findViewById(R.id.layout_del);
            dVar.f52749c = (ImageView) view2.findViewById(R.id.delete_photo_live);
            dVar.f52747a.setOnClickListener(this);
            dVar.f52747a.setTagTextSize(d.b.b.e.p.l.g(this.f52740e, R.dimen.tbds30));
            dVar.f52747a.setDrawBorder(true);
            dVar.f52747a.setDrawCorner(false);
            dVar.f52747a.setRadius(0);
            dVar.f52748b.setOnClickListener(this);
            dVar.f52747a.setGifIconSupport(true);
            dVar.f52747a.setLongIconSupport(true);
            SkinManager.setBackgroundResource(dVar.f52749c, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = dVar.f52747a.getLayoutParams();
            int i2 = this.f52743h;
            layoutParams.width = i2;
            layoutParams.height = i2;
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        LinkedList<ImageFileInfo> linkedList = this.f52742g;
        if (linkedList != null && linkedList.size() - 1 >= i) {
            a(this.f52742g.get(i), dVar, viewGroup);
            TbImageView tbImageView = dVar.f52747a;
            tbImageView.setTag(tbImageView.getId(), Integer.valueOf(i));
            dVar.f52748b.setTag(Integer.valueOf(i));
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
