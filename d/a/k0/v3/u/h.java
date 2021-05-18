package d.a.k0.v3.u;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.w.n;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public Context f62916f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.b0.b f62917g;

    /* renamed from: h  reason: collision with root package name */
    public n f62918h;

    /* renamed from: i  reason: collision with root package name */
    public f f62919i;
    public LayoutInflater j;
    public int l;

    /* renamed from: e  reason: collision with root package name */
    public List<ImageFileInfo> f62915e = new ArrayList();
    public boolean k = false;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f62919i != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 13));
                h.this.f62919i.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f62921e;

        public b(int i2) {
            this.f62921e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2 = this.f62921e;
            if (i2 >= 0) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) h.this.getItem(i2);
                if (imageFileInfo.isFromMoreForum) {
                    return;
                }
                boolean z = true;
                if (imageFileInfo == null || (imageFileInfo.getImageType() != 1 && !new File(imageFileInfo.getFilePath()).exists())) {
                    z = false;
                }
                if (!z) {
                    l.I(h.this.f62916f, R.string.editor_mutiiamge_image_error);
                    return;
                }
                if (h.this.f62918h != null) {
                    h.this.f62918h.d(new d.a.j0.w.a(15, 0, Integer.valueOf(this.f62921e)));
                }
                if (h.this.f62919i != null) {
                    h.this.f62919i.c(this.f62921e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f62923e;

        public c(int i2) {
            this.f62923e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f62919i != null) {
                h.this.f62919i.a(this.f62923e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.j0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f62925e;

        public d(h hVar, ViewGroup viewGroup) {
            this.f62925e = viewGroup;
        }

        @Override // d.a.j0.a0.b
        public void a(d.a.c.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f62925e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f62926a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f62927b;

        public e(h hVar, ViewGroup viewGroup, String str) {
            this.f62926a = viewGroup;
            this.f62927b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            TbImageView tbImageView = (TbImageView) this.f62926a.findViewWithTag(this.f62927b);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(int i2);

        void b();

        void c(int i2);
    }

    public h(Context context, d.a.j0.b0.b bVar, n nVar, f fVar) {
        this.f62918h = nVar;
        this.f62916f = context;
        this.j = LayoutInflater.from(context);
        this.f62917g = bVar;
        this.f62919i = fVar;
    }

    public final String d(int i2) {
        return this.f62916f.getResources().getString(i2);
    }

    public final void e(ImageFileInfo imageFileInfo, View view, ViewGroup viewGroup, int i2, int i3) {
        if (imageFileInfo == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        ImageOperation g2 = d.a.j0.b0.g.d.g(i2, i3);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv);
        ((FrameLayout) view.findViewById(R.id.item_root)).setForeground(SkinManager.getDrawable(R.drawable.new_frame_add_photo_foreground_selector));
        if (imageFileInfo.getImageType() == 0) {
            d.a.c.j.d.a c2 = this.f62917g.c(imageFileInfo, true);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                tbImageView.invalidate();
            } else {
                this.f62917g.d(imageFileInfo, new d(this, viewGroup), true);
            }
            tbImageView.setTagStr(this.f62916f.getString(R.string.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!d.a.c.e.p.k.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g3 = d.a.c.e.l.d.h().g(filePath, 20);
                tbImageView.setTag(g3);
                d.a.c.e.l.d.h().k(filePath, 20, new e(this, viewGroup, g3), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            tbImageView.setTagStr("");
        }
    }

    public void f(WriteImagesInfo writeImagesInfo) {
        if (writeImagesInfo == null) {
            return;
        }
        this.l = writeImagesInfo.getMaxImagesAllowed();
        int count = ListUtils.getCount(writeImagesInfo.getChosedFiles());
        this.f62915e.clear();
        if (count > 0) {
            this.f62915e.addAll(writeImagesInfo.getChosedFiles());
        }
        if (count >= this.l || !this.k) {
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("FLAG_ADD_ICON");
        this.f62915e.add(imageFileInfo);
    }

    public void g(boolean z) {
        this.k = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f62915e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f62915e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        AbsListView.LayoutParams layoutParams;
        ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.f62915e, i2);
        if (imageFileInfo == null) {
            return null;
        }
        if (view == null) {
            view = this.j.inflate(R.layout.new_frame_editor_muti_image_item, (ViewGroup) null);
        }
        int k = (l.k(this.f62916f) - ((l.g(this.f62916f, R.dimen.tbds44) * 2) + (l.g(this.f62916f, R.dimen.tbds10) * 2))) / 3;
        if (view.getLayoutParams() instanceof AbsListView.LayoutParams) {
            layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            layoutParams.width = k;
            layoutParams.height = k;
        } else {
            layoutParams = new AbsListView.LayoutParams(k, k);
        }
        view.setLayoutParams(layoutParams);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv);
        tbImageView.setTagTextSize(l.g(this.f62916f, R.dimen.T_X10));
        tbImageView.setDrawBorder(true);
        tbImageView.setDrawCorner(true);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setConrers(15);
        tbImageView.setRadiusById(R.string.J_X05);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.delete_info);
        ((ImageView) view.findViewById(R.id.delete)).setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.item_root);
        if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
            tbImageView.setVisibility(8);
            linearLayout.setVisibility(8);
            view.setBackgroundDrawable(WebPManager.getMaskDrawable(R.drawable.icon_pure_post_add, WebPManager.ResourceStateType.NORMAL_PRESS));
            view.invalidate();
            frameLayout.setForeground(null);
            view.setOnClickListener(new a());
        } else {
            tbImageView.setVisibility(0);
            linearLayout.setVisibility(0);
            view.setBackgroundResource(0);
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(imageFileInfo.isLong());
            tbImageView.setTagStr(d(R.string.edit));
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                tbImageView.setTagColor(this.f62916f.getResources().getColor(R.color.CAM_X0101));
            } else {
                tbImageView.setTagColor(this.f62916f.getResources().getColor(R.color.CAM_X0101));
            }
            e(imageFileInfo, view, viewGroup, k, k);
            if (imageFileInfo.isFromMoreForum) {
                linearLayout.setVisibility(8);
                tbImageView.setTagStr("");
            }
            view.setOnClickListener(new b(i2));
            linearLayout.setOnClickListener(new c(i2));
        }
        return view;
    }
}
