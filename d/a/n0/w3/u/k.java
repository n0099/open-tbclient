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
    public TbPageContext<WriteMultiImgsActivity> f66775a;

    /* renamed from: b  reason: collision with root package name */
    public j f66776b;

    /* renamed from: e  reason: collision with root package name */
    public ForumWriteData f66779e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.r.s.a f66780f;

    /* renamed from: g  reason: collision with root package name */
    public StickerModel f66781g;
    public PermissionJudgePolicy l;

    /* renamed from: c  reason: collision with root package name */
    public MultiImagePagerAdapter f66777c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f66778d = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f66782h = 0;

    /* renamed from: i  reason: collision with root package name */
    public WriteImagesInfo f66783i = null;
    public int j = TbadkCoreApplication.getInst().getSkinType();
    public HashMap<String, String> k = new HashMap<>();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null) {
                k.this.f66777c.j(Integer.parseInt(view.getTag().toString()), k.this.c());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.f66775a == null) {
                return;
            }
            Activity pageActivity = k.this.f66775a.getPageActivity();
            if (k.this.l == null) {
                k.this.l = new PermissionJudgePolicy();
            }
            k.this.l.clearRequestPermissionList();
            k.this.l.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (k.this.l.startRequestPermission(pageActivity)) {
                return;
            }
            k.this.f66777c.g(false);
            if (k.this.f66776b == null) {
                return;
            }
            if (k.this.f66783i == null || k.this.f66783i.getChosedFiles() == null || k.this.f66783i.getChosedFiles().size() <= 0 || !k.this.f66783i.isOriginalImg() || k.this.f66782h <= 0 || !k.this.o()) {
                k.this.f66776b.k(true, k.this.f66783i);
            } else {
                k.this.f66776b.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f66786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f66787f;

        public c(int i2, boolean z) {
            this.f66786e = i2;
            this.f66787f = z;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (k.this.f66780f != null) {
                k.this.f66780f.dismiss();
            }
            MultiImagePagerAdapter multiImagePagerAdapter = k.this.f66777c;
            if (multiImagePagerAdapter != null) {
                multiImagePagerAdapter.j(this.f66786e, this.f66787f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (k.this.f66780f != null) {
                k.this.f66780f.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bitmap f66790e;

        public e(Bitmap bitmap) {
            this.f66790e = bitmap;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (k.this.f66780f != null) {
                k.this.f66780f.dismiss();
            }
            k.this.f66776b.i(this.f66790e);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (k.this.f66780f != null) {
                k.this.f66780f.dismiss();
            }
        }
    }

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.f66775a = tbPageContext;
        this.f66776b = jVar;
        x(bundle);
        y();
        A();
    }

    public void A() {
        if (this.f66775a == null) {
            return;
        }
        if (!d.a.c.e.p.j.z()) {
            if (this.f66775a.getContext() != null) {
                l.L(this.f66775a.getContext(), R.string.neterror);
                return;
            }
            return;
        }
        if (this.f66781g == null) {
            this.f66781g = new StickerModel(this.f66775a);
        }
        this.f66781g.LoadData();
        this.f66781g.x(this);
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
        j jVar = this.f66776b;
        return (jVar == null || (stickerLayout = jVar.f66766f) == null || ListUtils.isEmpty(stickerLayout.getStickerViews())) ? false : true;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void d() {
    }

    @Override // d.a.n0.w3.u.l.a
    public void e(List<String> list) {
        j jVar = this.f66776b;
        if (jVar != null) {
            jVar.a(list);
        }
    }

    public void n() {
        this.f66782h++;
    }

    public final boolean o() {
        WriteImagesInfo writeImagesInfo = this.f66783i;
        if (writeImagesInfo != null && writeImagesInfo.isOriginalImg() && this.f66783i.getChosedFiles() != null && this.f66783i.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.f66783i.getChosedFiles().iterator();
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
        TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f66775a;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (this.f66780f == null) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f66775a.getPageActivity());
            this.f66780f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f66780f.setPositiveButton(R.string.alert_yes_button, new c(i2, z));
            this.f66780f.setNegativeButton(R.string.cancel, new d());
            this.f66780f.create(this.f66775a);
        }
        this.f66780f.show();
    }

    public boolean q(Bitmap bitmap) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        if (!this.f66777c.m() || (tbPageContext = this.f66775a) == null || tbPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.f66780f == null) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f66775a.getPageActivity());
            this.f66780f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f66780f.setPositiveButton(R.string.alert_yes_button, new e(bitmap));
            this.f66780f.setNegativeButton(R.string.cancel, new f());
            this.f66780f.create(this.f66775a);
        }
        this.f66780f.show();
        return true;
    }

    public void r(boolean z) {
        if (c()) {
            this.f66776b.f66765e.setmDisallowSlip(true);
        } else {
            this.f66776b.f66765e.setmDisallowSlip(false);
        }
    }

    public void s() {
        this.f66782h--;
    }

    public void t() {
        StickerModel stickerModel = this.f66781g;
        if (stickerModel != null) {
            stickerModel.destroy();
        }
    }

    public int u() {
        return this.f66778d;
    }

    public ForumWriteData v() {
        return this.f66779e;
    }

    public WriteImagesInfo w() {
        return this.f66783i;
    }

    public final void x(Bundle bundle) {
        String str;
        int i2;
        Intent intent;
        int intExtra;
        if (bundle != null) {
            str = bundle.getString(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_IMG_INFO);
            intExtra = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_CURRENT_INDEX);
            this.f66778d = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_ENTRANCE);
            this.f66779e = (ForumWriteData) bundle.getSerializable(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_INFO_DATA);
            this.j = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        } else {
            TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f66775a;
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || (intent = this.f66775a.getPageActivity().getIntent()) == null) {
                str = null;
                i2 = -1;
                if (str != null || i2 == -1) {
                }
                WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                this.f66783i = writeImagesInfo;
                writeImagesInfo.parseJson(str);
                z();
                j jVar = this.f66776b;
                if (jVar == null || jVar.f66765e == null) {
                    return;
                }
                MultiImagePagerAdapter multiImagePagerAdapter = new MultiImagePagerAdapter(this.f66775a.getOrignalPage(), this.f66776b.f66765e, this.f66783i.getChosedFiles(), i2, this, this.f66776b, this.f66783i.mIsFromIm);
                this.f66777c = multiImagePagerAdapter;
                this.f66776b.f66765e.setAdapter(multiImagePagerAdapter);
                int l = this.f66777c.l();
                this.f66776b.f66765e.setCurrentItem(l, true);
                if (l == 0) {
                    this.f66777c.onPageSelected(0);
                }
                this.f66776b.p(this.f66783i);
                return;
            }
            str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            intExtra = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.f66778d = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.f66779e = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.j = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        }
        i2 = intExtra;
        if (str != null) {
        }
    }

    public final void y() {
        j jVar = this.f66776b;
        if (jVar == null) {
            return;
        }
        d.a.n0.w3.t.c.b bVar = jVar.f66764d;
        if (bVar != null) {
            bVar.g(new a());
        }
        TextView textView = this.f66776b.f66767g;
        if (textView != null) {
            textView.setOnClickListener(new b());
        }
    }

    public final void z() {
        WriteImagesInfo writeImagesInfo = this.f66783i;
        if (writeImagesInfo == null || !writeImagesInfo.isOriginalImg() || this.f66783i.getChosedFiles() == null || this.f66783i.getChosedFiles().size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> it = this.f66783i.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize()) {
                this.k.put(next.getFilePath(), "1");
            }
        }
    }
}
