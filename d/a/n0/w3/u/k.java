package d.a.n0.w3.u;

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
import d.a.m0.r.s.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class k implements d.a.n0.w3.u.l.a, MultiImagePagerAdapter.c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f63060a;

    /* renamed from: b  reason: collision with root package name */
    public j f63061b;

    /* renamed from: e  reason: collision with root package name */
    public ForumWriteData f63064e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.r.s.a f63065f;

    /* renamed from: g  reason: collision with root package name */
    public StickerModel f63066g;
    public PermissionJudgePolicy l;

    /* renamed from: c  reason: collision with root package name */
    public MultiImagePagerAdapter f63062c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f63063d = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f63067h = 0;

    /* renamed from: i  reason: collision with root package name */
    public WriteImagesInfo f63068i = null;
    public int j = TbadkCoreApplication.getInst().getSkinType();
    public HashMap<String, String> k = new HashMap<>();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null) {
                k.this.f63062c.j(Integer.parseInt(view.getTag().toString()), k.this.c());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.f63060a == null) {
                return;
            }
            Activity pageActivity = k.this.f63060a.getPageActivity();
            if (k.this.l == null) {
                k.this.l = new PermissionJudgePolicy();
            }
            k.this.l.clearRequestPermissionList();
            k.this.l.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (k.this.l.startRequestPermission(pageActivity)) {
                return;
            }
            k.this.f63062c.h(false);
            if (k.this.f63061b == null) {
                return;
            }
            if (k.this.f63068i == null || k.this.f63068i.getChosedFiles() == null || k.this.f63068i.getChosedFiles().size() <= 0 || !k.this.f63068i.isOriginalImg() || k.this.f63067h <= 0 || !k.this.o()) {
                k.this.f63061b.k(true, k.this.f63068i);
            } else {
                k.this.f63061b.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f63071e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f63072f;

        public c(int i2, boolean z) {
            this.f63071e = i2;
            this.f63072f = z;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (k.this.f63065f != null) {
                k.this.f63065f.dismiss();
            }
            MultiImagePagerAdapter multiImagePagerAdapter = k.this.f63062c;
            if (multiImagePagerAdapter != null) {
                multiImagePagerAdapter.j(this.f63071e, this.f63072f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (k.this.f63065f != null) {
                k.this.f63065f.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bitmap f63075e;

        public e(Bitmap bitmap) {
            this.f63075e = bitmap;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (k.this.f63065f != null) {
                k.this.f63065f.dismiss();
            }
            k.this.f63061b.i(this.f63075e);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (k.this.f63065f != null) {
                k.this.f63065f.dismiss();
            }
        }
    }

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.f63060a = tbPageContext;
        this.f63061b = jVar;
        x(bundle);
        y();
        A();
    }

    public void A() {
        if (this.f63060a == null) {
            return;
        }
        if (!d.a.c.e.p.j.z()) {
            if (this.f63060a.getContext() != null) {
                l.L(this.f63060a.getContext(), R.string.neterror);
                return;
            }
            return;
        }
        if (this.f63066g == null) {
            this.f63066g = new StickerModel(this.f63060a);
        }
        this.f63066g.LoadData();
        this.f63066g.t(this);
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
        j jVar = this.f63061b;
        return (jVar == null || (stickerLayout = jVar.f63051f) == null || ListUtils.isEmpty(stickerLayout.getStickerViews())) ? false : true;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void d() {
    }

    @Override // d.a.n0.w3.u.l.a
    public void e(List<String> list) {
        j jVar = this.f63061b;
        if (jVar != null) {
            jVar.a(list);
        }
    }

    public void n() {
        this.f63067h++;
    }

    public final boolean o() {
        WriteImagesInfo writeImagesInfo = this.f63068i;
        if (writeImagesInfo != null && writeImagesInfo.isOriginalImg() && this.f63068i.getChosedFiles() != null && this.f63068i.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.f63068i.getChosedFiles().iterator();
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
        TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f63060a;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (this.f63065f == null) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f63060a.getPageActivity());
            this.f63065f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f63065f.setPositiveButton(R.string.alert_yes_button, new c(i2, z));
            this.f63065f.setNegativeButton(R.string.cancel, new d());
            this.f63065f.create(this.f63060a);
        }
        this.f63065f.show();
    }

    public boolean q(Bitmap bitmap) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        if (!this.f63062c.m() || (tbPageContext = this.f63060a) == null || tbPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.f63065f == null) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f63060a.getPageActivity());
            this.f63065f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f63065f.setPositiveButton(R.string.alert_yes_button, new e(bitmap));
            this.f63065f.setNegativeButton(R.string.cancel, new f());
            this.f63065f.create(this.f63060a);
        }
        this.f63065f.show();
        return true;
    }

    public void r(boolean z) {
        if (c()) {
            this.f63061b.f63050e.setmDisallowSlip(true);
        } else {
            this.f63061b.f63050e.setmDisallowSlip(false);
        }
    }

    public void s() {
        this.f63067h--;
    }

    public void t() {
        StickerModel stickerModel = this.f63066g;
        if (stickerModel != null) {
            stickerModel.destroy();
        }
    }

    public int u() {
        return this.f63063d;
    }

    public ForumWriteData v() {
        return this.f63064e;
    }

    public WriteImagesInfo w() {
        return this.f63068i;
    }

    public final void x(Bundle bundle) {
        String str;
        int i2;
        Intent intent;
        int intExtra;
        if (bundle != null) {
            str = bundle.getString(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_IMG_INFO);
            intExtra = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_CURRENT_INDEX);
            this.f63063d = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_ENTRANCE);
            this.f63064e = (ForumWriteData) bundle.getSerializable(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_INFO_DATA);
            this.j = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        } else {
            TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f63060a;
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || (intent = this.f63060a.getPageActivity().getIntent()) == null) {
                str = null;
                i2 = -1;
                if (str != null || i2 == -1) {
                }
                WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                this.f63068i = writeImagesInfo;
                writeImagesInfo.parseJson(str);
                z();
                j jVar = this.f63061b;
                if (jVar == null || jVar.f63050e == null) {
                    return;
                }
                MultiImagePagerAdapter multiImagePagerAdapter = new MultiImagePagerAdapter(this.f63060a.getOrignalPage(), this.f63061b.f63050e, this.f63068i.getChosedFiles(), i2, this, this.f63061b, this.f63068i.mIsFromIm);
                this.f63062c = multiImagePagerAdapter;
                this.f63061b.f63050e.setAdapter(multiImagePagerAdapter);
                int l = this.f63062c.l();
                this.f63061b.f63050e.setCurrentItem(l, true);
                if (l == 0) {
                    this.f63062c.onPageSelected(0);
                }
                this.f63061b.p(this.f63068i);
                return;
            }
            str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            intExtra = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.f63063d = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.f63064e = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.j = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        }
        i2 = intExtra;
        if (str != null) {
        }
    }

    public final void y() {
        j jVar = this.f63061b;
        if (jVar == null) {
            return;
        }
        d.a.n0.w3.t.c.b bVar = jVar.f63049d;
        if (bVar != null) {
            bVar.g(new a());
        }
        TextView textView = this.f63061b.f63052g;
        if (textView != null) {
            textView.setOnClickListener(new b());
        }
    }

    public final void z() {
        WriteImagesInfo writeImagesInfo = this.f63068i;
        if (writeImagesInfo == null || !writeImagesInfo.isOriginalImg() || this.f63068i.getChosedFiles() == null || this.f63068i.getChosedFiles().size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> it = this.f63068i.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize()) {
                this.k.put(next.getFilePath(), "1");
            }
        }
    }
}
