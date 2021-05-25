package d.a.n0.h1;

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
import com.baidu.tbadk.core.util.FullBrowseHelper;
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
import d.a.c.e.p.k;
import d.a.m0.r.s.a;
import d.a.m0.r.s.l;
import d.a.n0.e3.h0.q;
import d.a.n0.m3.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class j implements ImageViewerBottomLayout.c, ImageViewerBottomLayout.b {

    /* renamed from: a  reason: collision with root package name */
    public final ImageViewerActivity f55449a;

    /* renamed from: b  reason: collision with root package name */
    public MultiImageView f55450b;

    /* renamed from: c  reason: collision with root package name */
    public PermissionJudgePolicy f55451c;

    /* renamed from: d  reason: collision with root package name */
    public C1361j f55452d;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.m3.c f55454f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.s.j f55455g;

    /* renamed from: h  reason: collision with root package name */
    public l f55456h;
    public d.a.m0.r.s.h j;
    public d.a.m0.r.s.h k;
    public d.a.m0.r.s.h l;
    public d.a.m0.r.s.h m;
    public d.a.m0.r.s.h n;
    public d.a.m0.r.s.h o;
    public d.a.n0.h1.h p;

    /* renamed from: e  reason: collision with root package name */
    public String f55453e = null;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.m0.r.s.h> f55457i = null;
    public CustomMessageListener q = new a(2921403);
    public l.d r = new c();
    public l.d s = new d();
    public l.d t = new e();
    public l.d u = new f();
    public l.d v = new g();
    public l.d w = new h();
    public View.OnClickListener x = new i();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            q qVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof q) || j.this.f55449a.isFinishing() || (qVar = (q) customResponsedMessage.getData()) == null) {
                return;
            }
            qVar.f54038c = null;
            if (TextUtils.isEmpty(qVar.f54040e) || TextUtils.isEmpty(qVar.f54037b) || !qVar.f54037b.equals(j.this.f55453e)) {
                return;
            }
            j.this.f55450b.setCurrentImageQRInfo(qVar.f54040e);
            j.this.s(qVar.f54040e);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements l.c {
        public b() {
        }

        @Override // d.a.m0.r.s.l.c
        public void onClick() {
            j.this.u();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements l.d {
        public c() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            j.this.f55450b.m(j.this.f55449a.calCurrentIndex());
            j.this.u();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements l.d {
        public d() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            d.a.n0.h1.f.a(j.this.f55449a.getPageContext().getPageActivity(), j.this.f55450b.getCurrentImageUrl());
            j.this.u();
            j.this.r(1);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements l.d {
        public e() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            String currentImageUrl = j.this.f55450b.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else {
                Intent intent = new Intent(d.a.m0.a0.d.f48813a);
                intent.putExtra(d.a.m0.a0.d.f48814b, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.u();
            j.this.r(2);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements l.d {
        public f() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            Activity pageActivity = j.this.f55449a.getPageContext().getPageActivity();
            if (j.this.f55451c == null) {
                j.this.f55451c = new PermissionJudgePolicy();
            }
            j.this.f55451c.clearRequestPermissionList();
            j.this.f55451c.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (j.this.f55451c.startRequestPermission(pageActivity)) {
                return;
            }
            j.this.C();
            j.this.u();
            j.this.r(3);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements l.d {
        public g() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            j.this.y();
            j.this.u();
            j.this.r(4);
            j.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements l.d {

        /* loaded from: classes4.dex */
        public class a implements c.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f55466a;

            /* renamed from: d.a.n0.h1.j$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C1360a implements a.e {
                public C1360a() {
                }

                @Override // d.a.m0.r.s.a.e
                public void onClick(d.a.m0.r.s.a aVar) {
                    aVar.dismiss();
                    a aVar2 = a.this;
                    j.this.z(aVar2.f55466a);
                }
            }

            /* loaded from: classes4.dex */
            public class b implements a.e {
                public b(a aVar) {
                }

                @Override // d.a.m0.r.s.a.e
                public void onClick(d.a.m0.r.s.a aVar) {
                    aVar.dismiss();
                }
            }

            /* loaded from: classes4.dex */
            public class c implements a.e {
                public c(a aVar) {
                }

                @Override // d.a.m0.r.s.a.e
                public void onClick(d.a.m0.r.s.a aVar) {
                    aVar.dismiss();
                }
            }

            public a(String str) {
                this.f55466a = str;
            }

            @Override // d.a.n0.m3.c.a
            public void a() {
                d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(j.this.f55449a.getPageContext().getPageActivity());
                aVar.setTitle((String) null);
                aVar.setMessageShowCenter(true);
                aVar.setMessage(j.this.t(R.string.qr_url_risk_forbid));
                aVar.setPositiveButton(j.this.t(R.string.qr_url_risk_forbid_button), new c(this));
                aVar.setCancelable(false);
                aVar.setCanceledOnTouchOutside(false);
                aVar.create(j.this.f55449a.getPageContext()).show();
            }

            @Override // d.a.n0.m3.c.a
            public void b() {
                d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(j.this.f55449a.getPageContext().getPageActivity());
                aVar.setTitleShowCenter(true);
                aVar.setTitle(j.this.t(R.string.qr_url_jump_external_title));
                aVar.setMessageShowCenter(true);
                aVar.setMessage(j.this.t(R.string.qr_url_jump_external_message));
                aVar.setPositiveButton(j.this.t(R.string.confirm), new C1360a());
                aVar.setNegativeButton(j.this.t(R.string.cancel), new b(this));
                aVar.setCancelable(false);
                aVar.setCanceledOnTouchOutside(false);
                aVar.create(j.this.f55449a.getPageContext()).show();
            }

            @Override // d.a.n0.m3.c.a
            public void c() {
                j.this.z(this.f55466a);
            }

            @Override // d.a.n0.m3.c.a
            public void onError(String str) {
                d.a.c.e.p.l.M(j.this.f55449a.getPageContext().getPageActivity(), j.this.t(R.string.qr_scan_error));
            }
        }

        public h() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            String currentImageQRInfo = j.this.f55450b.getCurrentImageQRInfo();
            if (TextUtils.isEmpty(currentImageQRInfo) || "qr_none".equals(currentImageQRInfo)) {
                return;
            }
            if (!d.a.c.e.p.l.D()) {
                d.a.c.e.p.l.M(j.this.f55449a.getPageContext().getPageActivity(), j.this.t(R.string.network_not_available));
                return;
            }
            if (j.this.f55454f != null && !j.this.f55454f.isCancelled()) {
                j.this.f55454f.cancel();
            }
            j.this.f55454f = new d.a.n0.m3.c(currentImageQRInfo, new a(currentImageQRInfo));
            j.this.f55454f.setPriority(3);
            j.this.f55454f.execute(new String[0]);
            j.this.u();
            j.this.r(5);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlDragImageView currentUrlDragImageView;
            String str;
            if (j.this.f55450b == null || (currentUrlDragImageView = j.this.f55450b.getCurrentUrlDragImageView()) == null) {
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
                str2 = j.this.f55450b.getCurrentImageUrl();
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
                shareItem.W = 2;
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
                shareItem.A = bundle;
            }
            new Bundle().putInt("obj_locate", 13);
            new d.a.m0.s.g.g(j.this.f55449a, null).m(shareItem);
        }
    }

    /* renamed from: d.a.n0.h1.j$j  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1361j extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f55470a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f55471b;

        public C1361j(String str, byte[] bArr) {
            this.f55470a = str;
            this.f55471b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.f55452d = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            byte[] bArr;
            String nameMd5FromUrl;
            Map<String, ImageUrlData> assistUrls = j.this.f55449a.getAssistUrls();
            if (this.f55470a != null && assistUrls != null) {
                ImageUrlData imageUrlData = null;
                Iterator<Map.Entry<String, ImageUrlData>> it = assistUrls.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, ImageUrlData> next = it.next();
                    if (next != null && next.getKey() != null && next.getValue() != null && next.getKey().contains(this.f55470a)) {
                        imageUrlData = next.getValue();
                        break;
                    }
                }
                if (imageUrlData != null) {
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = FileHelper.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && FileHelper.copyImageFile(str, this.f55470a, j.this.f55449a.getPageContext().getPageActivity()) == 0) {
                        return j.this.f55449a.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            String str2 = this.f55470a;
            if (str2 != null && (bArr = this.f55471b) != null) {
                int saveImageFileByUser = FileHelper.saveImageFileByUser(str2, bArr, j.this.f55449a.getPageContext().getPageActivity());
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
            super.onPostExecute((C1361j) str);
            if (!d.a.m0.b.d.w() || j.this.t(R.string.save_fail).equals(str)) {
                j.this.f55449a.showToast(str);
            } else if (j.this.p != null) {
                j.this.p.g(j.this.f55450b, j.this.f55450b.getBottomHeight(), j.this.x);
            }
            j.this.f55452d = null;
        }
    }

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.f55449a = imageViewerActivity;
        imageViewerActivity.registerListener(this.q);
        this.p = new d.a.n0.h1.h(imageViewerActivity);
    }

    public void A() {
        C1361j c1361j = this.f55452d;
        if (c1361j != null) {
            c1361j.cancel();
            this.f55452d = null;
        }
        d.a.n0.m3.c cVar = this.f55454f;
        if (cVar != null) {
            cVar.cancel();
            this.f55454f = null;
        }
        d.a.n0.h1.h hVar = this.p;
        if (hVar != null) {
            hVar.f();
        }
    }

    public void B() {
        this.f55453e = null;
    }

    public final void C() {
        try {
            C1361j c1361j = new C1361j(this.f55450b.getCurrentImageUrl(), this.f55450b.getCurrentImageData());
            this.f55452d = c1361j;
            c1361j.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.f55449a.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception unused) {
        }
    }

    public void D() {
        this.f55457i.clear();
        String o = this.f55450b.o(this.f55449a.calCurrentIndex());
        if (o != null) {
            d.a.m0.r.s.h hVar = new d.a.m0.r.s.h(o, this.f55456h);
            this.j = hVar;
            hVar.m(this.r);
            this.f55457i.add(this.j);
        }
        d.a.m0.r.s.h hVar2 = new d.a.m0.r.s.h(t(R.string.save_to_local), this.f55456h);
        this.l = hVar2;
        hVar2.m(this.u);
        this.f55457i.add(this.l);
        ImageViewerActivity imageViewerActivity = this.f55449a;
        if (imageViewerActivity != null && !imageViewerActivity.isIsBJHThread()) {
            d.a.m0.r.s.h hVar3 = new d.a.m0.r.s.h(t(R.string.save_to_emotion), this.f55456h);
            this.m = hVar3;
            hVar3.m(this.t);
            this.f55457i.add(this.m);
        }
        d.a.m0.r.s.h hVar4 = new d.a.m0.r.s.h(t(R.string.identify_image), this.f55456h);
        this.k = hVar4;
        hVar4.m(this.s);
        this.f55457i.add(this.k);
        String currentImageQRInfo = this.f55450b.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            d.a.m0.r.s.h hVar5 = new d.a.m0.r.s.h(t(R.string.image_qr_code), this.f55456h);
            this.o = hVar5;
            hVar5.m(this.w);
            this.f55457i.add(this.o);
        }
        d.a.m0.r.s.h hVar6 = new d.a.m0.r.s.h(t(R.string.image_share), this.f55456h);
        this.n = hVar6;
        hVar6.m(this.v);
        this.f55457i.add(this.n);
        this.f55456h.m(new b());
        this.f55456h.k(this.f55457i);
    }

    public void E() {
        if (this.f55455g == null || this.f55449a.isFinishing()) {
            return;
        }
        this.f55455g.l();
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void a() {
        String currentImageUrl = this.f55450b.getCurrentImageUrl();
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
        } else if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f55449a.getPageContext(), null)) {
            return;
        } else {
            Intent intent = new Intent(d.a.m0.a0.d.f48813a);
            intent.putExtra(d.a.m0.a0.d.f48814b, currentImageUrl);
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
        r(2);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void onSave() {
        Activity pageActivity = this.f55449a.getPageContext().getPageActivity();
        if (this.f55451c == null) {
            this.f55451c = new PermissionJudgePolicy();
        }
        this.f55451c.clearRequestPermissionList();
        this.f55451c.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.f55451c.startRequestPermission(pageActivity)) {
            return;
        }
        C();
    }

    public final void q() {
    }

    public final void r(int i2) {
        TiebaStatic.log(new StatisticItem("c13270").param("uid", this.f55449a.getUserId()).param("obj_type", i2));
    }

    public void s(String str) {
        int i2;
        if (this.f55455g == null || this.f55449a.isFinishing() || !this.f55455g.isShowing() || TextUtils.isEmpty(str) || "qr_none".equals(str)) {
            return;
        }
        d.a.m0.r.s.h hVar = new d.a.m0.r.s.h(t(R.string.image_qr_code), this.f55456h);
        this.o = hVar;
        hVar.m(this.w);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 < this.f55457i.size()) {
                if (this.k != null && this.f55457i.get(i3) == this.k && (i2 = i3 + 1) <= this.f55457i.size()) {
                    this.f55457i.add(i2, this.o);
                    z = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (!z) {
            this.f55457i.add(this.o);
        }
        this.f55456h.k(this.f55457i);
    }

    public final String t(int i2) {
        return this.f55449a.getString(i2);
    }

    public void u() {
        d.a.m0.r.s.j jVar = this.f55455g;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f55455g.dismiss();
    }

    public void v(@Nullable MultiImageView multiImageView) {
        this.f55450b = multiImageView;
        if (this.f55455g == null) {
            this.f55456h = new l(this.f55449a);
        }
        if (this.f55457i == null) {
            this.f55457i = new ArrayList();
        }
        D();
        this.f55455g = new d.a.m0.r.s.j(this.f55449a.getPageContext(), this.f55456h);
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
            qVar.f54036a = 0;
            qVar.f54038c = imageBitmap;
            String currentImageUrl = this.f55450b.getCurrentImageUrl();
            if (!TextUtils.isEmpty(currentImageUrl)) {
                qVar.f54037b = String.valueOf(System.currentTimeMillis()) + TbMd5.getNameMd5FromUrl(currentImageUrl);
            } else {
                qVar.f54037b = String.valueOf(BdUniqueId.gen().getId());
            }
            this.f55453e = qVar.f54037b;
            this.f55449a.sendMessage(new CustomMessage(2921403, qVar));
        }
    }

    public void x() {
        l lVar = this.f55456h;
        if (lVar != null) {
            lVar.j();
        }
    }

    public void y() {
        UrlDragImageView currentUrlDragImageView;
        String str;
        MultiImageView multiImageView = this.f55450b;
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
            str2 = this.f55450b.getCurrentImageUrl();
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
            shareItem.W = 1;
            Bundle bundle = new Bundle();
            bundle.putString("path", "images");
            bundle.putString("name", str);
            bundle.putBoolean("formatData", true);
            bundle.putBoolean("isSubDir", true);
            bundle.putBoolean("isSdcard", false);
            bundle.putBoolean("isSavedCache", true);
            shareItem.A = bundle;
        }
        shareItem.j = true;
        shareItem.E = 23;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f55449a, shareItem, false);
        if (d.a.m0.b.d.v()) {
            shareDialogConfig.isImageViewerDialog = true;
            shareDialogConfig.originImgText = this.f55450b.o(this.f55449a.calCurrentIndex());
            ImageViewerActivity imageViewerActivity = this.f55449a;
            shareDialogConfig.showAddEmotion = (imageViewerActivity == null || imageViewerActivity.isIsBJHThread()) ? false : true;
            String currentImageQRInfo = this.f55450b.getCurrentImageQRInfo();
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
        this.f55449a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public final void z(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f55449a.getPageContext().getPageActivity(), null, str, false)));
    }
}
