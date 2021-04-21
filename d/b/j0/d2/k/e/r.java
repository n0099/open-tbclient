package d.b.j0.d2.k.e;

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
/* loaded from: classes3.dex */
public class r extends BaseAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f54647e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.b0.b f54648f = new d.b.i0.b0.b();

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<ImageFileInfo> f54649g = null;

    /* renamed from: h  reason: collision with root package name */
    public int f54650h;
    public int i;
    public c j;

    /* loaded from: classes3.dex */
    public class a implements d.b.i0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f54651e;

        public a(r rVar, ViewGroup viewGroup) {
            this.f54651e = viewGroup;
        }

        @Override // d.b.i0.a0.b
        public void a(d.b.c.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f54651e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.c.e.l.c<d.b.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f54652a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f54653b;

        public b(r rVar, ViewGroup viewGroup, String str) {
            this.f54652a = viewGroup;
            this.f54653b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            TbImageView tbImageView = (TbImageView) this.f54652a.findViewWithTag(this.f54653b);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onClickImage(int i);

        void onDeleteImage(int i);
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f54654a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f54655b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f54656c;
    }

    public r(Context context) {
        this.f54647e = null;
        this.f54647e = context;
        int k = d.b.c.e.p.l.k(context);
        this.i = k;
        this.f54650h = ((k - (d.b.c.e.p.l.g(this.f54647e, R.dimen.tbds44) * 2)) - (d.b.c.e.p.l.g(this.f54647e, R.dimen.tbds10) * 2)) / 3;
    }

    public final void a(ImageFileInfo imageFileInfo, d dVar, ViewGroup viewGroup) {
        if (imageFileInfo == null) {
            return;
        }
        int i = this.f54650h;
        ImageOperation g2 = d.b.i0.b0.g.d.g(i, i);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        if (imageFileInfo.getImageType() == 0) {
            d.b.c.j.d.a c2 = this.f54648f.c(imageFileInfo, true);
            dVar.f54654a.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                dVar.f54654a.invalidate();
            } else {
                this.f54648f.d(imageFileInfo, new a(this, viewGroup), true);
            }
            dVar.f54654a.setTagStr(this.f54647e.getString(R.string.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!d.b.c.e.p.k.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g3 = d.b.c.e.l.d.h().g(filePath, 20);
                dVar.f54654a.setTag(g3);
                d.b.c.e.l.d.h().k(filePath, 20, new b(this, viewGroup, g3), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            dVar.f54654a.setTagStr("");
        }
    }

    public void b(c cVar) {
        this.j = cVar;
    }

    public void c(LinkedList<ImageFileInfo> linkedList) {
        this.f54649g = linkedList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        LinkedList<ImageFileInfo> linkedList = this.f54649g;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        LinkedList<ImageFileInfo> linkedList = this.f54649g;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() - 1 >= i) {
            return this.f54649g.get(i);
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
            dVar.f54654a = (TbImageView) view2.findViewById(R.id.iv_photo_live);
            dVar.f54655b = (LinearLayout) view2.findViewById(R.id.layout_del);
            dVar.f54656c = (ImageView) view2.findViewById(R.id.delete_photo_live);
            dVar.f54654a.setOnClickListener(this);
            dVar.f54654a.setTagTextSize(d.b.c.e.p.l.g(this.f54647e, R.dimen.tbds30));
            dVar.f54654a.setDrawBorder(true);
            dVar.f54654a.setDrawCorner(false);
            dVar.f54654a.setRadius(0);
            dVar.f54655b.setOnClickListener(this);
            dVar.f54654a.setGifIconSupport(true);
            dVar.f54654a.setLongIconSupport(true);
            SkinManager.setBackgroundResource(dVar.f54656c, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = dVar.f54654a.getLayoutParams();
            int i2 = this.f54650h;
            layoutParams.width = i2;
            layoutParams.height = i2;
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        LinkedList<ImageFileInfo> linkedList = this.f54649g;
        if (linkedList != null && linkedList.size() - 1 >= i) {
            a(this.f54649g.get(i), dVar, viewGroup);
            TbImageView tbImageView = dVar.f54654a;
            tbImageView.setTag(tbImageView.getId(), Integer.valueOf(i));
            dVar.f54655b.setTag(Integer.valueOf(i));
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
