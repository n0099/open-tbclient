package d.b.i0.u3.v;

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
import d.b.b.e.p.l;
import d.b.h0.r.s.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class k implements d.b.i0.u3.v.l.a, MultiImagePagerAdapter.c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f61822a;

    /* renamed from: b  reason: collision with root package name */
    public j f61823b;

    /* renamed from: e  reason: collision with root package name */
    public ForumWriteData f61826e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.r.s.a f61827f;

    /* renamed from: g  reason: collision with root package name */
    public StickerModel f61828g;
    public PermissionJudgePolicy l;

    /* renamed from: c  reason: collision with root package name */
    public MultiImagePagerAdapter f61824c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f61825d = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f61829h = 0;
    public WriteImagesInfo i = null;
    public int j = TbadkCoreApplication.getInst().getSkinType();
    public HashMap<String, String> k = new HashMap<>();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null) {
                k.this.f61824c.j(Integer.parseInt(view.getTag().toString()), k.this.b());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.f61822a == null) {
                return;
            }
            Activity pageActivity = k.this.f61822a.getPageActivity();
            if (k.this.l == null) {
                k.this.l = new PermissionJudgePolicy();
            }
            k.this.l.clearRequestPermissionList();
            k.this.l.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (k.this.l.startRequestPermission(pageActivity)) {
                return;
            }
            k.this.f61824c.g(false);
            if (k.this.f61823b == null) {
                return;
            }
            if (k.this.i == null || k.this.i.getChosedFiles() == null || k.this.i.getChosedFiles().size() <= 0 || !k.this.i.isOriginalImg() || k.this.f61829h <= 0 || !k.this.o()) {
                k.this.f61823b.k(true, k.this.i);
            } else {
                k.this.f61823b.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f61832e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f61833f;

        public c(int i, boolean z) {
            this.f61832e = i;
            this.f61833f = z;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (k.this.f61827f != null) {
                k.this.f61827f.dismiss();
            }
            MultiImagePagerAdapter multiImagePagerAdapter = k.this.f61824c;
            if (multiImagePagerAdapter != null) {
                multiImagePagerAdapter.j(this.f61832e, this.f61833f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (k.this.f61827f != null) {
                k.this.f61827f.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bitmap f61836e;

        public e(Bitmap bitmap) {
            this.f61836e = bitmap;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (k.this.f61827f != null) {
                k.this.f61827f.dismiss();
            }
            k.this.f61823b.i(this.f61836e);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (k.this.f61827f != null) {
                k.this.f61827f.dismiss();
            }
        }
    }

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.f61822a = tbPageContext;
        this.f61823b = jVar;
        x(bundle);
        y();
        A();
    }

    public void A() {
        if (this.f61822a == null) {
            return;
        }
        if (!d.b.b.e.p.j.z()) {
            if (this.f61822a.getContext() != null) {
                l.K(this.f61822a.getContext(), R.string.neterror);
                return;
            }
            return;
        }
        if (this.f61828g == null) {
            this.f61828g = new StickerModel(this.f61822a);
        }
        this.f61828g.LoadData();
        this.f61828g.t(this);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void a() {
        s();
        r(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public boolean b() {
        StickerLayout stickerLayout;
        j jVar = this.f61823b;
        return (jVar == null || (stickerLayout = jVar.f61814f) == null || ListUtils.isEmpty(stickerLayout.getStickerViews())) ? false : true;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void c() {
    }

    @Override // d.b.i0.u3.v.l.a
    public void d(List<String> list) {
        j jVar = this.f61823b;
        if (jVar != null) {
            jVar.a(list);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void e(int i, boolean z) {
        p(i, z);
    }

    public void n() {
        this.f61829h++;
    }

    public final boolean o() {
        WriteImagesInfo writeImagesInfo = this.i;
        if (writeImagesInfo != null && writeImagesInfo.isOriginalImg() && this.i.getChosedFiles() != null && this.i.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.i.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.k.get(next.getFilePath()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void p(int i, boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f61822a;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (this.f61827f == null) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f61822a.getPageActivity());
            this.f61827f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f61827f.setPositiveButton(R.string.alert_yes_button, new c(i, z));
            this.f61827f.setNegativeButton(R.string.cancel, new d());
            this.f61827f.create(this.f61822a);
        }
        this.f61827f.show();
    }

    public boolean q(Bitmap bitmap) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        if (!this.f61824c.m() || (tbPageContext = this.f61822a) == null || tbPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.f61827f == null) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f61822a.getPageActivity());
            this.f61827f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f61827f.setPositiveButton(R.string.alert_yes_button, new e(bitmap));
            this.f61827f.setNegativeButton(R.string.cancel, new f());
            this.f61827f.create(this.f61822a);
        }
        this.f61827f.show();
        return true;
    }

    public void r(boolean z) {
        if (b()) {
            this.f61823b.f61813e.setmDisallowSlip(true);
        } else {
            this.f61823b.f61813e.setmDisallowSlip(false);
        }
    }

    public void s() {
        this.f61829h--;
    }

    public void t() {
        StickerModel stickerModel = this.f61828g;
        if (stickerModel != null) {
            stickerModel.destroy();
        }
    }

    public int u() {
        return this.f61825d;
    }

    public ForumWriteData v() {
        return this.f61826e;
    }

    public WriteImagesInfo w() {
        return this.i;
    }

    public final void x(Bundle bundle) {
        String str;
        int i;
        Intent intent;
        int intExtra;
        if (bundle != null) {
            str = bundle.getString(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_IMG_INFO);
            intExtra = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_CURRENT_INDEX);
            this.f61825d = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_ENTRANCE);
            this.f61826e = (ForumWriteData) bundle.getSerializable(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_INFO_DATA);
            this.j = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        } else {
            TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f61822a;
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || (intent = this.f61822a.getPageActivity().getIntent()) == null) {
                str = null;
                i = -1;
                if (str != null || i == -1) {
                }
                WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                this.i = writeImagesInfo;
                writeImagesInfo.parseJson(str);
                z();
                j jVar = this.f61823b;
                if (jVar == null || jVar.f61813e == null) {
                    return;
                }
                MultiImagePagerAdapter multiImagePagerAdapter = new MultiImagePagerAdapter(this.f61822a.getOrignalPage(), this.f61823b.f61813e, this.i.getChosedFiles(), i, this, this.f61823b, this.i.mIsFromIm);
                this.f61824c = multiImagePagerAdapter;
                this.f61823b.f61813e.setAdapter(multiImagePagerAdapter);
                int l = this.f61824c.l();
                this.f61823b.f61813e.setCurrentItem(l, true);
                if (l == 0) {
                    this.f61824c.onPageSelected(0);
                }
                this.f61823b.p(this.i);
                return;
            }
            str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            intExtra = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.f61825d = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.f61826e = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.j = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        }
        i = intExtra;
        if (str != null) {
        }
    }

    public final void y() {
        j jVar = this.f61823b;
        if (jVar == null) {
            return;
        }
        d.b.i0.u3.u.c.b bVar = jVar.f61812d;
        if (bVar != null) {
            bVar.g(new a());
        }
        TextView textView = this.f61823b.f61815g;
        if (textView != null) {
            textView.setOnClickListener(new b());
        }
    }

    public final void z() {
        WriteImagesInfo writeImagesInfo = this.i;
        if (writeImagesInfo == null || !writeImagesInfo.isOriginalImg() || this.i.getChosedFiles() == null || this.i.getChosedFiles().size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> it = this.i.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize()) {
                this.k.put(next.getFilePath(), "1");
            }
        }
    }
}
