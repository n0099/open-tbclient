package d.b.i0.f1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StorageFile;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.image.ImageViewerActivity;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.b.e.p.k;
import d.b.h0.r.s.a;
import d.b.h0.r.s.l;
import d.b.i0.c3.h0.q;
import d.b.i0.k3.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class j implements ImageViewerBottomLayout.c, ImageViewerBottomLayout.b {

    /* renamed from: a  reason: collision with root package name */
    public final ImageViewerActivity f54688a;

    /* renamed from: b  reason: collision with root package name */
    public MultiImageView f54689b;

    /* renamed from: c  reason: collision with root package name */
    public PermissionJudgePolicy f54690c;

    /* renamed from: d  reason: collision with root package name */
    public C1247j f54691d;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.k3.c f54693f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.s.j f54694g;

    /* renamed from: h  reason: collision with root package name */
    public l f54695h;
    public d.b.h0.r.s.h j;
    public d.b.h0.r.s.h k;
    public d.b.h0.r.s.h l;
    public d.b.h0.r.s.h m;
    public d.b.h0.r.s.h n;
    public d.b.h0.r.s.h o;
    public d.b.i0.f1.h p;

    /* renamed from: e  reason: collision with root package name */
    public String f54692e = null;
    public List<d.b.h0.r.s.h> i = null;
    public CustomMessageListener q = new a(2921403);
    public l.d r = new c();
    public l.d s = new d();
    public l.d t = new e();
    public l.d u = new f();
    public l.d v = new g();
    public l.d w = new h();
    public View.OnClickListener x = new i();

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            q qVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof q) || j.this.f54688a.isFinishing() || (qVar = (q) customResponsedMessage.getData()) == null) {
                return;
            }
            qVar.f53416c = null;
            if (TextUtils.isEmpty(qVar.f53418e) || TextUtils.isEmpty(qVar.f53415b) || !qVar.f53415b.equals(j.this.f54692e)) {
                return;
            }
            j.this.f54689b.setCurrentImageQRInfo(qVar.f53418e);
            j.this.s(qVar.f53418e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements l.c {
        public b() {
        }

        @Override // d.b.h0.r.s.l.c
        public void onClick() {
            j.this.u();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements l.d {
        public c() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            j.this.f54689b.m(j.this.f54688a.calCurrentIndex());
            j.this.u();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements l.d {
        public d() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            d.b.i0.f1.f.a(j.this.f54688a.getPageContext().getPageActivity(), j.this.f54689b.getCurrentImageUrl());
            j.this.u();
            j.this.r(1);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements l.d {
        public e() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            String currentImageUrl = j.this.f54689b.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else {
                Intent intent = new Intent(d.b.h0.a0.d.f49680a);
                intent.putExtra(d.b.h0.a0.d.f49681b, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.u();
            j.this.r(2);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements l.d {
        public f() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            Activity pageActivity = j.this.f54688a.getPageContext().getPageActivity();
            if (j.this.f54690c == null) {
                j.this.f54690c = new PermissionJudgePolicy();
            }
            j.this.f54690c.clearRequestPermissionList();
            j.this.f54690c.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (j.this.f54690c.startRequestPermission(pageActivity)) {
                return;
            }
            j.this.C();
            j.this.u();
            j.this.r(3);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements l.d {
        public g() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            j.this.y();
            j.this.u();
            j.this.r(4);
            j.this.q();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements l.d {

        /* loaded from: classes3.dex */
        public class a implements c.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f54704a;

            /* renamed from: d.b.i0.f1.j$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C1246a implements a.e {
                public C1246a() {
                }

                @Override // d.b.h0.r.s.a.e
                public void onClick(d.b.h0.r.s.a aVar) {
                    aVar.dismiss();
                    a aVar2 = a.this;
                    j.this.z(aVar2.f54704a);
                }
            }

            /* loaded from: classes3.dex */
            public class b implements a.e {
                public b(a aVar) {
                }

                @Override // d.b.h0.r.s.a.e
                public void onClick(d.b.h0.r.s.a aVar) {
                    aVar.dismiss();
                }
            }

            /* loaded from: classes3.dex */
            public class c implements a.e {
                public c(a aVar) {
                }

                @Override // d.b.h0.r.s.a.e
                public void onClick(d.b.h0.r.s.a aVar) {
                    aVar.dismiss();
                }
            }

            public a(String str) {
                this.f54704a = str;
            }

            @Override // d.b.i0.k3.c.a
            public void a() {
                d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(j.this.f54688a.getPageContext().getPageActivity());
                aVar.setTitle((String) null);
                aVar.setMessageShowCenter(true);
                aVar.setMessage(j.this.t(R.string.qr_url_risk_forbid));
                aVar.setPositiveButton(j.this.t(R.string.qr_url_risk_forbid_button), new c(this));
                aVar.setCancelable(false);
                aVar.setCanceledOnTouchOutside(false);
                aVar.create(j.this.f54688a.getPageContext()).show();
            }

            @Override // d.b.i0.k3.c.a
            public void b() {
                d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(j.this.f54688a.getPageContext().getPageActivity());
                aVar.setTitleShowCenter(true);
                aVar.setTitle(j.this.t(R.string.qr_url_jump_external_title));
                aVar.setMessageShowCenter(true);
                aVar.setMessage(j.this.t(R.string.qr_url_jump_external_message));
                aVar.setPositiveButton(j.this.t(R.string.confirm), new C1246a());
                aVar.setNegativeButton(j.this.t(R.string.cancel), new b(this));
                aVar.setCancelable(false);
                aVar.setCanceledOnTouchOutside(false);
                aVar.create(j.this.f54688a.getPageContext()).show();
            }

            @Override // d.b.i0.k3.c.a
            public void c() {
                j.this.z(this.f54704a);
            }

            @Override // d.b.i0.k3.c.a
            public void onError(String str) {
                d.b.b.e.p.l.L(j.this.f54688a.getPageContext().getPageActivity(), j.this.t(R.string.qr_scan_error));
            }
        }

        public h() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            String currentImageQRInfo = j.this.f54689b.getCurrentImageQRInfo();
            if (TextUtils.isEmpty(currentImageQRInfo) || "qr_none".equals(currentImageQRInfo)) {
                return;
            }
            if (!d.b.b.e.p.l.C()) {
                d.b.b.e.p.l.L(j.this.f54688a.getPageContext().getPageActivity(), j.this.t(R.string.network_not_available));
                return;
            }
            if (j.this.f54693f != null && !j.this.f54693f.isCancelled()) {
                j.this.f54693f.cancel();
            }
            j.this.f54693f = new d.b.i0.k3.c(currentImageQRInfo, new a(currentImageQRInfo));
            j.this.f54693f.setPriority(3);
            j.this.f54693f.execute(new String[0]);
            j.this.u();
            j.this.r(5);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlDragImageView currentUrlDragImageView;
            String str;
            if (j.this.f54689b == null || (currentUrlDragImageView = j.this.f54689b.getCurrentUrlDragImageView()) == null) {
                return;
            }
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str2 = "";
            if (imageUrlData != null) {
                str2 = imageUrlData.imageUrl;
                str = BigImageLoaderProc.getNameMd5FromUrl(str2);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = j.this.f54689b.getCurrentImageUrl();
                str = TbMd5.getNameMd5FromUrl(str2);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.t = "http://tieba.baidu.com/p/" + j + "?fr=share";
                }
            }
            if (!k.isEmpty(str2)) {
                shareItem.v = Uri.parse(str2);
                shareItem.V = 2;
                shareItem.r = j.this.t(R.string.save_to_emotion);
                shareItem.s = j.this.t(R.string.save_to_emotion);
                shareItem.w = str2;
                Bundle bundle = new Bundle();
                bundle.putString("path", "images");
                bundle.putString("name", str);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.z = bundle;
            }
            new Bundle().putInt("obj_locate", 13);
            new d.b.h0.s.g.g(j.this.f54688a, null).m(shareItem);
        }
    }

    /* renamed from: d.b.i0.f1.j$j  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1247j extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f54708a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f54709b;

        public C1247j(String str, byte[] bArr) {
            this.f54708a = str;
            this.f54709b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.f54691d = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            byte[] bArr;
            String nameMd5FromUrl;
            Map<String, ImageUrlData> assistUrls = j.this.f54688a.getAssistUrls();
            if (this.f54708a != null && assistUrls != null) {
                ImageUrlData imageUrlData = null;
                Iterator<Map.Entry<String, ImageUrlData>> it = assistUrls.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, ImageUrlData> next = it.next();
                    if (next != null && next.getKey() != null && next.getValue() != null && next.getKey().contains(this.f54708a)) {
                        imageUrlData = next.getValue();
                        break;
                    }
                }
                if (imageUrlData != null) {
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = FileHelper.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && FileHelper.copyImageFile(str, this.f54708a, j.this.f54688a.getPageContext().getPageActivity()) == 0) {
                        return j.this.f54688a.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            String str2 = this.f54708a;
            if (str2 != null && (bArr = this.f54709b) != null) {
                int saveImageFileByUser = FileHelper.saveImageFileByUser(str2, bArr, j.this.f54688a.getPageContext().getPageActivity());
                if (saveImageFileByUser == -2) {
                    return FileHelper.getSdErrorString();
                }
                if (saveImageFileByUser == 0) {
                    return j.this.t(R.string.save_image_to_album);
                }
            }
            return j.this.t(R.string.save_fail);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((C1247j) str);
            if (!d.b.h0.b.d.v() || j.this.t(R.string.save_fail).equals(str)) {
                j.this.f54688a.showToast(str);
            } else if (j.this.p != null) {
                j.this.p.g(j.this.f54689b, j.this.f54689b.getBottomHeight(), j.this.x);
            }
            j.this.f54691d = null;
        }
    }

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.f54688a = imageViewerActivity;
        imageViewerActivity.registerListener(this.q);
        this.p = new d.b.i0.f1.h(imageViewerActivity);
    }

    public void A() {
        C1247j c1247j = this.f54691d;
        if (c1247j != null) {
            c1247j.cancel();
            this.f54691d = null;
        }
        d.b.i0.k3.c cVar = this.f54693f;
        if (cVar != null) {
            cVar.cancel();
            this.f54693f = null;
        }
        d.b.i0.f1.h hVar = this.p;
        if (hVar != null) {
            hVar.f();
        }
    }

    public void B() {
        this.f54692e = null;
    }

    public final void C() {
        try {
            C1247j c1247j = new C1247j(this.f54689b.getCurrentImageUrl(), this.f54689b.getCurrentImageData());
            this.f54691d = c1247j;
            c1247j.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.f54688a.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception unused) {
        }
    }

    public void D() {
        this.i.clear();
        String o = this.f54689b.o(this.f54688a.calCurrentIndex());
        if (o != null) {
            d.b.h0.r.s.h hVar = new d.b.h0.r.s.h(o, this.f54695h);
            this.j = hVar;
            hVar.m(this.r);
            this.i.add(this.j);
        }
        d.b.h0.r.s.h hVar2 = new d.b.h0.r.s.h(t(R.string.save_to_local), this.f54695h);
        this.l = hVar2;
        hVar2.m(this.u);
        this.i.add(this.l);
        ImageViewerActivity imageViewerActivity = this.f54688a;
        if (imageViewerActivity != null && !imageViewerActivity.isIsBJHThread()) {
            d.b.h0.r.s.h hVar3 = new d.b.h0.r.s.h(t(R.string.save_to_emotion), this.f54695h);
            this.m = hVar3;
            hVar3.m(this.t);
            this.i.add(this.m);
        }
        d.b.h0.r.s.h hVar4 = new d.b.h0.r.s.h(t(R.string.identify_image), this.f54695h);
        this.k = hVar4;
        hVar4.m(this.s);
        this.i.add(this.k);
        String currentImageQRInfo = this.f54689b.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            d.b.h0.r.s.h hVar5 = new d.b.h0.r.s.h(t(R.string.image_qr_code), this.f54695h);
            this.o = hVar5;
            hVar5.m(this.w);
            this.i.add(this.o);
        }
        d.b.h0.r.s.h hVar6 = new d.b.h0.r.s.h(t(R.string.image_share), this.f54695h);
        this.n = hVar6;
        hVar6.m(this.v);
        this.i.add(this.n);
        this.f54695h.m(new b());
        this.f54695h.k(this.i);
    }

    public void E() {
        if (this.f54694g == null || this.f54688a.isFinishing()) {
            return;
        }
        this.f54694g.l();
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void a() {
        String currentImageUrl = this.f54689b.getCurrentImageUrl();
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
        } else {
            Intent intent = new Intent(d.b.h0.a0.d.f49680a);
            intent.putExtra(d.b.h0.a0.d.f49681b, currentImageUrl);
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
        r(2);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void onSave() {
        Activity pageActivity = this.f54688a.getPageContext().getPageActivity();
        if (this.f54690c == null) {
            this.f54690c = new PermissionJudgePolicy();
        }
        this.f54690c.clearRequestPermissionList();
        this.f54690c.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.f54690c.startRequestPermission(pageActivity)) {
            return;
        }
        C();
    }

    public final void q() {
    }

    public final void r(int i2) {
        TiebaStatic.log(new StatisticItem("c13270").param("uid", this.f54688a.getUserId()).param("obj_type", i2));
    }

    public void s(String str) {
        int i2;
        if (this.f54694g == null || this.f54688a.isFinishing() || !this.f54694g.isShowing() || TextUtils.isEmpty(str) || "qr_none".equals(str)) {
            return;
        }
        d.b.h0.r.s.h hVar = new d.b.h0.r.s.h(t(R.string.image_qr_code), this.f54695h);
        this.o = hVar;
        hVar.m(this.w);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 < this.i.size()) {
                if (this.k != null && this.i.get(i3) == this.k && (i2 = i3 + 1) <= this.i.size()) {
                    this.i.add(i2, this.o);
                    z = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (!z) {
            this.i.add(this.o);
        }
        this.f54695h.k(this.i);
    }

    public final String t(int i2) {
        return this.f54688a.getString(i2);
    }

    public void u() {
        d.b.h0.r.s.j jVar = this.f54694g;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f54694g.dismiss();
    }

    public void v(@Nullable MultiImageView multiImageView) {
        this.f54689b = multiImageView;
        if (this.f54694g == null) {
            this.f54695h = new l(this.f54688a);
        }
        if (this.i == null) {
            this.i = new ArrayList();
        }
        D();
        this.f54694g = new d.b.h0.r.s.j(this.f54688a.getPageContext(), this.f54695h);
    }

    public void w(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData != null && !TextUtils.isEmpty(imageUrlData.qrInfo)) || (imageBitmap = dragImageView.getImageBitmap()) == null || imageBitmap.isRecycled()) {
                return;
            }
            q qVar = new q();
            qVar.f53414a = 0;
            qVar.f53416c = imageBitmap;
            String currentImageUrl = this.f54689b.getCurrentImageUrl();
            if (!TextUtils.isEmpty(currentImageUrl)) {
                qVar.f53415b = String.valueOf(System.currentTimeMillis()) + TbMd5.getNameMd5FromUrl(currentImageUrl);
            } else {
                qVar.f53415b = String.valueOf(BdUniqueId.gen().getId());
            }
            this.f54692e = qVar.f53415b;
            this.f54688a.sendMessage(new CustomMessage(2921403, qVar));
        }
    }

    public void x() {
        l lVar = this.f54695h;
        if (lVar != null) {
            lVar.j();
        }
    }

    public void y() {
        UrlDragImageView currentUrlDragImageView;
        String str;
        MultiImageView multiImageView = this.f54689b;
        if (multiImageView == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
            return;
        }
        ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
        String str2 = "";
        if (imageUrlData != null) {
            str2 = imageUrlData.imageUrl;
            str = BigImageLoaderProc.getNameMd5FromUrl(str2);
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f54689b.getCurrentImageUrl();
            str = TbMd5.getNameMd5FromUrl(str2);
        }
        ShareItem shareItem = new ShareItem();
        if (imageUrlData != null) {
            long j = imageUrlData.threadId;
            if (j > 0) {
                shareItem.t = "http://tieba.baidu.com/p/" + j + "?fr=share";
            }
        }
        boolean z = false;
        if (!k.isEmpty(str2)) {
            shareItem.v = Uri.parse(str2);
            shareItem.V = 1;
            Bundle bundle = new Bundle();
            bundle.putString("path", "images");
            bundle.putString("name", str);
            bundle.putBoolean("formatData", true);
            bundle.putBoolean("isSubDir", true);
            bundle.putBoolean("isSdcard", false);
            bundle.putBoolean("isSavedCache", true);
            shareItem.z = bundle;
        }
        shareItem.j = true;
        shareItem.D = 23;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f54688a, shareItem, false);
        if (d.b.h0.b.d.u()) {
            shareDialogConfig.isImageViewerDialog = true;
            shareDialogConfig.originImgText = this.f54689b.o(this.f54688a.calCurrentIndex());
            ImageViewerActivity imageViewerActivity = this.f54688a;
            shareDialogConfig.showAddEmotion = (imageViewerActivity == null || imageViewerActivity.isIsBJHThread()) ? false : true;
            String currentImageQRInfo = this.f54689b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                z = true;
            }
            shareDialogConfig.showQRCode = z;
            shareDialogConfig.dialogSaveToDiskListener = this.u;
            shareDialogConfig.dialogAddToExpressionListener = this.t;
            shareDialogConfig.dialogDownloadOriginListener = this.r;
            shareDialogConfig.dialogRecognizePicListener = this.s;
            shareDialogConfig.qrCodeClickListener = this.w;
            shareDialogConfig.onWeChatEmotionShareListener = this.x;
        }
        this.f54688a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public final void z(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f54688a.getPageContext().getPageActivity(), null, str, false)));
    }
}
