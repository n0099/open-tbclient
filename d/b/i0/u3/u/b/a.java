package d.b.i0.u3.u.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import d.b.b.e.p.l;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f61730e;
    public BaseActivity j;
    public GridView l;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.b0.b f61731f = new d.b.h0.b0.b();

    /* renamed from: g  reason: collision with root package name */
    public EditorTools f61732g = null;

    /* renamed from: h  reason: collision with root package name */
    public int f61733h = 13;
    public int i = 6;
    public LinkedList<ImageFileInfo> k = null;
    public e m = new C1621a();

    /* renamed from: d.b.i0.u3.u.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1621a implements e {
        public C1621a() {
        }

        @Override // d.b.i0.u3.u.b.a.e
        public void a(int i) {
            if (a.this.k == null) {
                return;
            }
            if (a.this.k.size() - 1 >= i) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) a.this.k.remove(i);
                if (imageFileInfo.isTempFile()) {
                    d.b.b.e.a.d.g().a(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            int size = a.this.k.size();
            if (a.this.f61732g != null) {
                a.this.f61732g.A(new d.b.h0.w.a(a.this.f61733h, -1, null));
                if (size > 0) {
                    a.this.f61732g.A(new d.b.h0.w.a(2, 10, String.valueOf(size)));
                } else {
                    a.this.f61732g.A(new d.b.h0.w.a(2, 10, null));
                }
                if (a.this.k.size() == 1 && size == 0) {
                    a.this.f61732g.A(new d.b.h0.w.a(1, 2, null));
                }
            }
            a.this.k();
            ((WriteActivity) a.this.j).updateChoseFile(a.this.k);
            a.this.h();
            a.this.notifyDataSetChanged();
            a.this.l.invalidateViews();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b.h0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f61735e;

        public b(a aVar, ViewGroup viewGroup) {
            this.f61735e = viewGroup;
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.b.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            ViewGroup viewGroup = this.f61735e;
            if (viewGroup == null || (tbImageView = (TbImageView) viewGroup.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f61736e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f61737f;

        public c(ViewGroup viewGroup, boolean z) {
            this.f61736e = viewGroup;
            this.f61737f = z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0081, code lost:
            if (r3.length() != 0) goto L18;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            int indexOfChild = this.f61736e.indexOfChild(view);
            if (indexOfChild >= 0) {
                boolean z = true;
                if (this.f61737f && (a.this.j instanceof WriteActivity)) {
                    if (a.this.k != null && a.this.k.size() > 0) {
                        a.this.k.remove(a.this.k.size() - 1);
                    }
                    ((WriteActivity) a.this.j).updateChoseFile(a.this.k);
                    ((WriteActivity) a.this.j).openImageActivity(null);
                    return;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) a.this.getItem(indexOfChild);
                if (imageFileInfo != null) {
                    File file = new File(imageFileInfo.getFilePath());
                    if (file.exists()) {
                    }
                }
                z = false;
                if (!z) {
                    l.H(a.this.f61730e, R.string.editor_mutiiamge_image_error);
                } else if (a.this.f61732g != null) {
                    if (a.this.j()) {
                        a.this.k();
                    }
                    ((WriteActivity) a.this.j).updateChoseFile(a.this.k);
                    a.this.f61732g.A(new d.b.h0.w.a(15, 0, Integer.valueOf(indexOfChild)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f61739e;

        public d(int i) {
            this.f61739e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.m != null) {
                a.this.m.a(this.f61739e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i);
    }

    public a(BaseActivity baseActivity, WriteImagesInfo writeImagesInfo, GridView gridView) {
        this.f61730e = null;
        this.j = null;
        this.l = null;
        this.j = baseActivity;
        this.f61730e = baseActivity.getActivity();
        this.l = gridView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        LinkedList<ImageFileInfo> linkedList = this.k;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        LinkedList<ImageFileInfo> linkedList = this.k;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() - 1 >= i) {
            return this.k.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        d.b.h0.b0.b bVar;
        boolean z = false;
        View inflate = LayoutInflater.from(this.f61730e).inflate(R.layout.photo_live_grid_item, viewGroup, false);
        LinkedList<ImageFileInfo> linkedList = this.k;
        d.b.b.j.d.a aVar = null;
        ImageFileInfo imageFileInfo = (linkedList == null || linkedList.size() - 1 < i) ? null : this.k.get(i);
        View findViewById = inflate.findViewById(R.id.item_root_photo_live);
        FrameLayout frameLayout = (FrameLayout) findViewById.findViewById(R.id.shadow_container_photo_live);
        TbImageView tbImageView = (TbImageView) findViewById.findViewById(R.id.iv_photo_live);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.delete_photo_live);
        String filePath = imageFileInfo != null ? imageFileInfo.getFilePath() : "";
        LinkedList<ImageFileInfo> linkedList2 = this.k;
        if (linkedList2 != null && i == linkedList2.size() - 1 && filePath.startsWith("android.resource://")) {
            z = true;
        }
        if (z) {
            imageView.setVisibility(8);
            SkinManager.setImageResource(tbImageView, R.drawable.btn_addpic_n);
        } else {
            SkinManager.setImageResource(imageView, R.drawable.icon_live_close_n);
        }
        frameLayout.setForeground(SkinManager.getDrawable(R.drawable.bg_add_photo_foregroundselector));
        int dimensionPixelSize = this.f61730e.getResources().getDimensionPixelSize(R.dimen.ds206);
        ImageOperation g2 = d.b.h0.b0.g.d.g(dimensionPixelSize, dimensionPixelSize);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(g2);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
        }
        b bVar2 = new b(this, viewGroup);
        if (imageFileInfo != null && (bVar = this.f61731f) != null) {
            aVar = bVar.d(imageFileInfo, bVar2, true);
        }
        if (aVar != null) {
            tbImageView.invalidate();
        }
        inflate.setOnClickListener(new c(viewGroup, z));
        imageView.setOnClickListener(new d(i));
        return inflate;
    }

    public void h() {
        LinkedList<ImageFileInfo> linkedList = this.k;
        if (linkedList != null && linkedList.size() != 0) {
            if (this.k.size() >= this.i) {
                return;
            }
            if (this.k.size() > 0) {
                LinkedList<ImageFileInfo> linkedList2 = this.k;
                if (linkedList2.get(linkedList2.size() - 1).getFilePath().startsWith("android.resource://")) {
                    return;
                }
            }
            i();
            return;
        }
        i();
    }

    public final void i() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("android.resource://" + this.f61730e.getPackageName() + "/" + R.drawable.btn_addpic_n);
        imageFileInfo.setTempFile(true);
        if (this.k == null) {
            this.k = new LinkedList<>();
        }
        this.k.add(imageFileInfo);
        notifyDataSetChanged();
    }

    public boolean j() {
        LinkedList<ImageFileInfo> linkedList = this.k;
        if (linkedList != null && linkedList.size() != 0) {
            LinkedList<ImageFileInfo> linkedList2 = this.k;
            if (linkedList2.get(linkedList2.size() - 1).getFilePath().startsWith("android.resource://")) {
                return true;
            }
        }
        return false;
    }

    public void k() {
        LinkedList<ImageFileInfo> linkedList = this.k;
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        int size = this.k.size() - 1;
        if (this.k.get(size).getFilePath().startsWith("android.resource://")) {
            this.k.remove(size);
        }
    }

    public void l(WriteImagesInfo writeImagesInfo) {
        if (writeImagesInfo == null) {
            writeImagesInfo = new WriteImagesInfo();
        }
        if (this.k == null) {
            this.k = new LinkedList<>();
        }
        this.k.clear();
        if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.size() > 0) {
            this.k.addAll(writeImagesInfo.getChosedFiles());
        }
        h();
        notifyDataSetInvalidated();
    }

    public void m(EditorTools editorTools) {
        this.f61732g = editorTools;
    }

    public void n(int i) {
        this.i = i;
    }
}
