package d.a.j0.v3.u;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.WriteMultiImgsActivity;
import com.baidu.tieba.write.write.model.StickerModel;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.i0.r.s.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class k implements d.a.j0.v3.u.l.a, MultiImagePagerAdapter.c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f62227a;

    /* renamed from: b  reason: collision with root package name */
    public j f62228b;

    /* renamed from: e  reason: collision with root package name */
    public ForumWriteData f62231e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.r.s.a f62232f;

    /* renamed from: g  reason: collision with root package name */
    public StickerModel f62233g;
    public PermissionJudgePolicy l;

    /* renamed from: c  reason: collision with root package name */
    public MultiImagePagerAdapter f62229c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f62230d = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f62234h = 0;

    /* renamed from: i  reason: collision with root package name */
    public WriteImagesInfo f62235i = null;
    public int j = TbadkCoreApplication.getInst().getSkinType();
    public HashMap<String, String> k = new HashMap<>();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null) {
                k.this.f62229c.j(Integer.parseInt(view.getTag().toString()), k.this.c());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.f62227a == null) {
                return;
            }
            Activity pageActivity = k.this.f62227a.getPageActivity();
            if (k.this.l == null) {
                k.this.l = new PermissionJudgePolicy();
            }
            k.this.l.clearRequestPermissionList();
            k.this.l.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (k.this.l.startRequestPermission(pageActivity)) {
                return;
            }
            k.this.f62229c.h(false);
            if (k.this.f62228b == null) {
                return;
            }
            if (k.this.f62235i == null || k.this.f62235i.getChosedFiles() == null || k.this.f62235i.getChosedFiles().size() <= 0 || !k.this.f62235i.isOriginalImg() || k.this.f62234h <= 0 || !k.this.o()) {
                k.this.f62228b.k(true, k.this.f62235i);
            } else {
                k.this.f62228b.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f62238e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f62239f;

        public c(int i2, boolean z) {
            this.f62238e = i2;
            this.f62239f = z;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            if (k.this.f62232f != null) {
                k.this.f62232f.dismiss();
            }
            MultiImagePagerAdapter multiImagePagerAdapter = k.this.f62229c;
            if (multiImagePagerAdapter != null) {
                multiImagePagerAdapter.j(this.f62238e, this.f62239f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            if (k.this.f62232f != null) {
                k.this.f62232f.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bitmap f62242e;

        public e(Bitmap bitmap) {
            this.f62242e = bitmap;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            if (k.this.f62232f != null) {
                k.this.f62232f.dismiss();
            }
            k.this.f62228b.i(this.f62242e);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            if (k.this.f62232f != null) {
                k.this.f62232f.dismiss();
            }
        }
    }

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.f62227a = tbPageContext;
        this.f62228b = jVar;
        x(bundle);
        y();
        A();
    }

    public void A() {
        if (this.f62227a == null) {
            return;
        }
        if (!d.a.c.e.p.j.z()) {
            if (this.f62227a.getContext() != null) {
                l.L(this.f62227a.getContext(), R.string.neterror);
                return;
            }
            return;
        }
        if (this.f62233g == null) {
            this.f62233g = new StickerModel(this.f62227a);
        }
        this.f62233g.LoadData();
        this.f62233g.t(this);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void a() {
        s();
        r(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void b(int i2, boolean z) {
        p(i2, z);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public boolean c() {
        StickerLayout stickerLayout;
        j jVar = this.f62228b;
        return (jVar == null || (stickerLayout = jVar.f62218f) == null || ListUtils.isEmpty(stickerLayout.getStickerViews())) ? false : true;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void d() {
    }

    @Override // d.a.j0.v3.u.l.a
    public void e(List<String> list) {
        j jVar = this.f62228b;
        if (jVar != null) {
            jVar.a(list);
        }
    }

    public void n() {
        this.f62234h++;
    }

    public final boolean o() {
        WriteImagesInfo writeImagesInfo = this.f62235i;
        if (writeImagesInfo != null && writeImagesInfo.isOriginalImg() && this.f62235i.getChosedFiles() != null && this.f62235i.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.f62235i.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.k.get(next.getFilePath()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void p(int i2, boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f62227a;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (this.f62232f == null) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f62227a.getPageActivity());
            this.f62232f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f62232f.setPositiveButton(R.string.alert_yes_button, new c(i2, z));
            this.f62232f.setNegativeButton(R.string.cancel, new d());
            this.f62232f.create(this.f62227a);
        }
        this.f62232f.show();
    }

    public boolean q(Bitmap bitmap) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        if (!this.f62229c.m() || (tbPageContext = this.f62227a) == null || tbPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.f62232f == null) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f62227a.getPageActivity());
            this.f62232f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f62232f.setPositiveButton(R.string.alert_yes_button, new e(bitmap));
            this.f62232f.setNegativeButton(R.string.cancel, new f());
            this.f62232f.create(this.f62227a);
        }
        this.f62232f.show();
        return true;
    }

    public void r(boolean z) {
        if (c()) {
            this.f62228b.f62217e.setmDisallowSlip(true);
        } else {
            this.f62228b.f62217e.setmDisallowSlip(false);
        }
    }

    public void s() {
        this.f62234h--;
    }

    public void t() {
        StickerModel stickerModel = this.f62233g;
        if (stickerModel != null) {
            stickerModel.destroy();
        }
    }

    public int u() {
        return this.f62230d;
    }

    public ForumWriteData v() {
        return this.f62231e;
    }

    public WriteImagesInfo w() {
        return this.f62235i;
    }

    public final void x(Bundle bundle) {
        String str;
        int i2;
        Intent intent;
        int intExtra;
        if (bundle != null) {
            str = bundle.getString(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_IMG_INFO);
            intExtra = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_CURRENT_INDEX);
            this.f62230d = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_ENTRANCE);
            this.f62231e = (ForumWriteData) bundle.getSerializable(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_INFO_DATA);
            this.j = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        } else {
            TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f62227a;
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || (intent = this.f62227a.getPageActivity().getIntent()) == null) {
                str = null;
                i2 = -1;
                if (str != null || i2 == -1) {
                }
                WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                this.f62235i = writeImagesInfo;
                writeImagesInfo.parseJson(str);
                z();
                j jVar = this.f62228b;
                if (jVar == null || jVar.f62217e == null) {
                    return;
                }
                MultiImagePagerAdapter multiImagePagerAdapter = new MultiImagePagerAdapter(this.f62227a.getOrignalPage(), this.f62228b.f62217e, this.f62235i.getChosedFiles(), i2, this, this.f62228b, this.f62235i.mIsFromIm);
                this.f62229c = multiImagePagerAdapter;
                this.f62228b.f62217e.setAdapter(multiImagePagerAdapter);
                int l = this.f62229c.l();
                this.f62228b.f62217e.setCurrentItem(l, true);
                if (l == 0) {
                    this.f62229c.onPageSelected(0);
                }
                this.f62228b.p(this.f62235i);
                return;
            }
            str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            intExtra = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.f62230d = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.f62231e = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.j = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        }
        i2 = intExtra;
        if (str != null) {
        }
    }

    public final void y() {
        j jVar = this.f62228b;
        if (jVar == null) {
            return;
        }
        d.a.j0.v3.t.c.b bVar = jVar.f62216d;
        if (bVar != null) {
            bVar.g(new a());
        }
        TextView textView = this.f62228b.f62219g;
        if (textView != null) {
            textView.setOnClickListener(new b());
        }
    }

    public final void z() {
        WriteImagesInfo writeImagesInfo = this.f62235i;
        if (writeImagesInfo == null || !writeImagesInfo.isOriginalImg() || this.f62235i.getChosedFiles() == null || this.f62235i.getChosedFiles().size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> it = this.f62235i.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize()) {
                this.k.put(next.getFilePath(), "1");
            }
        }
    }
}
