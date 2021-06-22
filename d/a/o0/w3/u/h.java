package d.a.o0.w3.u;

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
import d.a.n0.w.n;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public Context f66865f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.b0.b f66866g;

    /* renamed from: h  reason: collision with root package name */
    public n f66867h;

    /* renamed from: i  reason: collision with root package name */
    public f f66868i;
    public LayoutInflater j;
    public int l;

    /* renamed from: e  reason: collision with root package name */
    public List<ImageFileInfo> f66864e = new ArrayList();
    public boolean k = false;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f66868i != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 13));
                h.this.f66868i.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f66870e;

        public b(int i2) {
            this.f66870e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2 = this.f66870e;
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
                    l.I(h.this.f66865f, R.string.editor_mutiiamge_image_error);
                    return;
                }
                if (h.this.f66867h != null) {
                    h.this.f66867h.d(new d.a.n0.w.a(15, 0, Integer.valueOf(this.f66870e)));
                }
                if (h.this.f66868i != null) {
                    h.this.f66868i.c(this.f66870e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f66872e;

        public c(int i2) {
            this.f66872e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f66868i != null) {
                h.this.f66868i.a(this.f66872e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.n0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f66874e;

        public d(h hVar, ViewGroup viewGroup) {
            this.f66874e = viewGroup;
        }

        @Override // d.a.n0.a0.b
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f66874e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f66875a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f66876b;

        public e(h hVar, ViewGroup viewGroup, String str) {
            this.f66875a = viewGroup;
            this.f66876b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            TbImageView tbImageView = (TbImageView) this.f66875a.findViewWithTag(this.f66876b);
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

    public h(Context context, d.a.n0.b0.b bVar, n nVar, f fVar) {
        this.f66867h = nVar;
        this.f66865f = context;
        this.j = LayoutInflater.from(context);
        this.f66866g = bVar;
        this.f66868i = fVar;
    }

    public final String d(int i2) {
        return this.f66865f.getResources().getString(i2);
    }

    public final void e(ImageFileInfo imageFileInfo, View view, ViewGroup viewGroup, int i2, int i3) {
        if (imageFileInfo == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        ImageOperation g2 = d.a.n0.b0.g.d.g(i2, i3);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv);
        ((FrameLayout) view.findViewById(R.id.item_root)).setForeground(SkinManager.getDrawable(R.drawable.new_frame_add_photo_foreground_selector));
        if (imageFileInfo.getImageType() == 0) {
            d.a.c.k.d.a c2 = this.f66866g.c(imageFileInfo, true);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                tbImageView.invalidate();
            } else {
                this.f66866g.d(imageFileInfo, new d(this, viewGroup), true);
            }
            tbImageView.setTagStr(this.f66865f.getString(R.string.edit));
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
        this.f66864e.clear();
        if (count > 0) {
            this.f66864e.addAll(writeImagesInfo.getChosedFiles());
        }
        if (count >= this.l || !this.k) {
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("FLAG_ADD_ICON");
        this.f66864e.add(imageFileInfo);
    }

    public void g(boolean z) {
        this.k = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f66864e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f66864e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        AbsListView.LayoutParams layoutParams;
        ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.f66864e, i2);
        if (imageFileInfo == null) {
            return null;
        }
        if (view == null) {
            view = this.j.inflate(R.layout.new_frame_editor_muti_image_item, (ViewGroup) null);
        }
        int k = (l.k(this.f66865f) - ((l.g(this.f66865f, R.dimen.tbds44) * 2) + (l.g(this.f66865f, R.dimen.tbds10) * 2))) / 3;
        if (view.getLayoutParams() instanceof AbsListView.LayoutParams) {
            layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            layoutParams.width = k;
            layoutParams.height = k;
        } else {
            layoutParams = new AbsListView.LayoutParams(k, k);
        }
        view.setLayoutParams(layoutParams);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv);
        tbImageView.setTagTextSize(l.g(this.f66865f, R.dimen.T_X10));
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
                tbImageView.setTagColor(this.f66865f.getResources().getColor(R.color.CAM_X0101));
            } else {
                tbImageView.setTagColor(this.f66865f.getResources().getColor(R.color.CAM_X0101));
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
