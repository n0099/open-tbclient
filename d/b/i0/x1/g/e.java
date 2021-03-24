package d.b.i0.x1.g;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.img.GetEmotionInfosModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.tieba.newfaceshop.facemake.UploadFaceGroupModel;
import d.b.i0.l0.u;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static volatile e f62391e;

    /* renamed from: a  reason: collision with root package name */
    public Handler f62392a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<d.b.h0.b0.f> f62393b = new LinkedBlockingQueue(4);

    /* renamed from: c  reason: collision with root package name */
    public boolean f62394c;

    /* renamed from: d  reason: collision with root package name */
    public FaceGroupDraft f62395d;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public List<FaceData> f62396e = new CopyOnWriteArrayList();

        /* renamed from: f  reason: collision with root package name */
        public List<String> f62397f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Integer> f62398g = new HashMap();

        /* renamed from: h  reason: collision with root package name */
        public List<FaceData> f62399h = new CopyOnWriteArrayList();
        public final /* synthetic */ List i;
        public final /* synthetic */ l j;
        public final /* synthetic */ String k;
        public final /* synthetic */ int l;

        /* renamed from: d.b.i0.x1.g.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1662a implements m {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.i0.x1.g.a f62400a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FaceData f62401b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f62402c;

            public C1662a(d.b.i0.x1.g.a aVar, FaceData faceData, AtomicInteger atomicInteger) {
                this.f62400a = aVar;
                this.f62401b = faceData;
                this.f62402c = atomicInteger;
            }

            @Override // d.b.i0.x1.g.e.m
            public void a(ImageUploadResult imageUploadResult) {
                if (this.f62400a.a()) {
                    if (imageUploadResult != null && imageUploadResult.error_code == 0) {
                        this.f62401b.pid = String.valueOf(imageUploadResult.picId);
                        FaceData faceData = this.f62401b;
                        ImageUploadResult.PicDetailedInfo picDetailedInfo = imageUploadResult.picInfo.bigPic;
                        faceData.width = picDetailedInfo.width;
                        faceData.height = picDetailedInfo.height;
                        a.this.f62396e.add(faceData);
                        if (this.f62402c.decrementAndGet() == 0) {
                            a.this.b();
                        }
                    } else if (this.f62400a.a()) {
                        this.f62400a.b(false);
                        a aVar = a.this;
                        e.this.t(aVar.j, "failed to upload image");
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {

            /* renamed from: d.b.i0.x1.g.e$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C1663a implements GetEmotionInfosModel.b {
                public C1663a() {
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onFail(int i, String str) {
                    a aVar = a.this;
                    e.this.t(aVar.j, "get pid fail");
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onSuccess(List<d.b.h0.b0.c> list) {
                    for (d.b.h0.b0.c cVar : list) {
                        if (cVar != null) {
                            FaceData faceData = new FaceData();
                            faceData.type = 2;
                            faceData.index = a.this.f62398g.get(cVar.f49779g).intValue();
                            faceData.pid = cVar.f49773a;
                            faceData.width = cVar.f49774b;
                            faceData.height = cVar.f49775c;
                            EmotionImageData emotionImageData = new EmotionImageData();
                            emotionImageData.setPicId(cVar.f49773a);
                            emotionImageData.setThumbUrl(cVar.f49777e);
                            emotionImageData.setPicUrl(cVar.f49776d);
                            emotionImageData.setWidth(cVar.f49774b);
                            emotionImageData.setHeight(cVar.f49775c);
                            faceData.emotionImageData = emotionImageData;
                            a.this.f62396e.add(faceData);
                        }
                    }
                    UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                    a aVar = a.this;
                    uploadFaceGroupModel.u(aVar.k, aVar.f62396e, aVar.j, aVar.l);
                }
            }

            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f62397f.size() > 0) {
                    new GetEmotionInfosModel().u(a.this.f62397f, new C1663a());
                    return;
                }
                UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                a aVar = a.this;
                uploadFaceGroupModel.u(aVar.k, aVar.f62396e, aVar.j, aVar.l);
            }
        }

        public a(List list, l lVar, String str, int i) {
            this.i = list;
            this.j = lVar;
            this.k = str;
            this.l = i;
        }

        public final void b() {
            new Handler(Looper.getMainLooper()).post(new b());
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData;
            for (int i = 0; i < this.i.size(); i++) {
                FaceData faceData = (FaceData) this.i.get(i);
                faceData.index = i;
                int i2 = faceData.type;
                if (i2 == 2) {
                    EmotionImageData emotionImageData2 = faceData.emotionImageData;
                    if (emotionImageData2 != null) {
                        if (!TextUtils.isEmpty(emotionImageData2.getPicId())) {
                            faceData.pid = emotionImageData2.getPicId();
                            faceData.width = emotionImageData2.getWidth();
                            faceData.height = emotionImageData2.getHeight();
                            this.f62396e.add(faceData);
                        } else {
                            this.f62397f.add(faceData.emotionImageData.getPicUrl());
                            this.f62398g.put(faceData.emotionImageData.getPicUrl(), Integer.valueOf(faceData.index));
                        }
                    }
                } else if (i2 == 3) {
                    this.f62399h.add(faceData);
                } else if (i2 == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                    faceData.pid = emotionImageData.getPicId();
                    faceData.width = emotionImageData.getWidth();
                    faceData.height = emotionImageData.getHeight();
                    this.f62396e.add(faceData);
                }
            }
            if (this.f62399h.size() > 0) {
                AtomicInteger atomicInteger = new AtomicInteger(this.f62399h.size());
                d.b.i0.x1.g.a aVar = new d.b.i0.x1.g.a(Boolean.TRUE);
                for (int i3 = 0; i3 < Math.min(this.f62399h.size(), 4); i3++) {
                    e.this.f62393b.offer(new d.b.h0.b0.f("face group"));
                }
                for (int i4 = 0; i4 < this.f62399h.size() && aVar.a(); i4++) {
                    FaceData faceData2 = this.f62399h.get(i4);
                    e.this.B(faceData2.imageFileInfo, new C1662a(aVar, faceData2, atomicInteger));
                }
                return;
            }
            b();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageFileInfo f62406e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f62407f;

        public b(ImageFileInfo imageFileInfo, m mVar) {
            this.f62406e = imageFileInfo;
            this.f62407f = mVar;
        }

        public final void a(m mVar, ImageUploadResult imageUploadResult) {
            if (mVar != null) {
                mVar.a(imageUploadResult);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String filePath = this.f62406e.getFilePath();
                if (this.f62406e.isGif()) {
                    d.b.h0.b0.f fVar = (d.b.h0.b0.f) e.this.f62393b.poll(10L, TimeUnit.SECONDS);
                    if (fVar != null) {
                        a(this.f62407f, fVar.k(filePath, true, false));
                        e.this.v(fVar);
                        return;
                    }
                    a(this.f62407f, null);
                    return;
                }
                Bitmap b2 = d.b.i0.x1.g.b.b(this.f62406e);
                if (b2 == null) {
                    this.f62407f.a(null);
                    return;
                }
                String y = e.y("face_" + Math.abs(filePath.hashCode()), b2, 60);
                b2.recycle();
                if (!TextUtils.isEmpty(y)) {
                    d.b.h0.b0.f fVar2 = (d.b.h0.b0.f) e.this.f62393b.poll(10L, TimeUnit.SECONDS);
                    if (fVar2 != null) {
                        ImageUploadResult k = fVar2.k(y, false, false);
                        FileHelper.deleteFile(new File(y));
                        a(this.f62407f, k);
                        e.this.v(fVar2);
                        return;
                    }
                    a(this.f62407f, null);
                    return;
                }
                a(this.f62407f, null);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.x1.g.a f62409a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f62410b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f62411c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.x1.f.a f62412d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62413e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f62414f;

        public c(d.b.i0.x1.g.a aVar, List list, List list2, d.b.i0.x1.f.a aVar2, String str, k kVar) {
            this.f62409a = aVar;
            this.f62410b = list;
            this.f62411c = list2;
            this.f62412d = aVar2;
            this.f62413e = str;
            this.f62414f = kVar;
        }

        @Override // d.b.i0.x1.g.e.j
        public void a(d.b.i0.x1.f.b bVar) {
            if (this.f62409a.a()) {
                this.f62410b.add(bVar);
                if (this.f62410b.size() == this.f62411c.size()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f62410b);
                    Collections.sort(arrayList);
                    this.f62412d.f62371e = arrayList;
                    if (e.this.j(this.f62413e + ((d.b.i0.x1.f.b) arrayList.get(0)).f62375h, this.f62413e)) {
                        e.this.o(this.f62412d, this.f62414f);
                    } else {
                        onFail("face group:fail to create panel");
                    }
                }
            }
        }

        @Override // d.b.i0.x1.g.e.j
        public void onFail(String str) {
            if (this.f62409a.a()) {
                this.f62409a.b(false);
                e.this.s(this.f62414f, false);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f62416e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f62417f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f62418g;

        public d(e eVar, FaceData faceData, String str, j jVar) {
            this.f62416e = faceData;
            this.f62417f = str;
            this.f62418g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap resizeBitmap;
            ImageFileInfo imageFileInfo = this.f62416e.imageFileInfo;
            String filePath = imageFileInfo.getFilePath();
            String substring = filePath.substring(filePath.lastIndexOf("/") + 1);
            if (TextUtils.isEmpty(substring)) {
                substring = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis() + ".jpg";
            }
            String str = "t_" + substring;
            if (FileHelper.copyFile(filePath, this.f62417f + substring)) {
                Bitmap b2 = d.b.i0.x1.g.b.b(imageFileInfo);
                if (b2 == null) {
                    this.f62418g.onFail("face group: fail to get origin bitmap when install album emotion");
                    return;
                }
                if (!imageFileInfo.isGif() && (resizeBitmap = BitmapHelper.resizeBitmap(b2, 240, 240, false)) != null) {
                    d.b.i0.x1.b.e(this.f62417f, substring, resizeBitmap, 100);
                    if (resizeBitmap != b2) {
                        resizeBitmap.recycle();
                    }
                }
                Bitmap resizeBitmap2 = BitmapHelper.resizeBitmap(b2, 150, 150, false);
                if (resizeBitmap2 == null) {
                    this.f62418g.onFail("face group: fail to create small file when install album emotion");
                    return;
                }
                d.b.i0.x1.b.e(this.f62417f, str, resizeBitmap2, 100);
                if (resizeBitmap2 != b2) {
                    resizeBitmap2.recycle();
                }
                b2.recycle();
                d.b.i0.x1.f.b bVar = new d.b.i0.x1.f.b();
                FaceData faceData = this.f62416e;
                bVar.f62372e = faceData.index;
                bVar.f62373f = faceData.pid;
                bVar.f62374g = substring;
                bVar.f62375h = str;
                bVar.j = faceData.width;
                bVar.i = faceData.height;
                this.f62418g.a(bVar);
                return;
            }
            this.f62418g.onFail("face group: fail to copy file when install album emotion");
        }
    }

    /* renamed from: d.b.i0.x1.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1664e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f62419e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f62420f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f62421g;

        public RunnableC1664e(e eVar, FaceData faceData, String str, j jVar) {
            this.f62419e = faceData;
            this.f62420f = str;
            this.f62421g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData = this.f62419e.emotionImageData;
            String str = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis();
            String str2 = "t_" + str;
            String o = u.o(this.f62419e.pid, true);
            String o2 = u.o(this.f62419e.pid, false);
            if (!FileHelper.copyFile(o, this.f62420f + str)) {
                this.f62421g.onFail("face group: fail to copy big file when install collect emotion");
                return;
            }
            if (!FileHelper.copyFile(o2, this.f62420f + str2)) {
                this.f62421g.onFail("face group: fail to copy small file when install collect emotion");
                return;
            }
            d.b.i0.x1.f.b bVar = new d.b.i0.x1.f.b();
            FaceData faceData = this.f62419e;
            bVar.f62372e = faceData.index;
            bVar.f62373f = faceData.pid;
            bVar.f62374g = str;
            bVar.f62375h = str2;
            bVar.j = faceData.width;
            bVar.i = faceData.height;
            this.f62421g.a(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f62422e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f62423f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f62424g;

        public f(FaceData faceData, j jVar, String str) {
            this.f62422e = faceData;
            this.f62423f = jVar;
            this.f62424g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData = this.f62422e.emotionImageData;
            String substring = emotionImageData.getPicUrl().substring(emotionImageData.getPicUrl().lastIndexOf(IStringUtil.WINDOWS_FOLDER_SEPARATOR) + 1);
            String str = "t_" + substring;
            WebClient webClient = new WebClient();
            byte[] downloadImageBytes = webClient.downloadImageBytes(emotionImageData.getPicUrl(), false);
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                e.this.x(this.f62424g, substring, downloadImageBytes);
                byte[] downloadImageBytes2 = webClient.downloadImageBytes(emotionImageData.getThumbUrl(), false);
                if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                    e.this.x(this.f62424g, str, downloadImageBytes2);
                    d.b.i0.x1.f.b bVar = new d.b.i0.x1.f.b();
                    FaceData faceData = this.f62422e;
                    bVar.f62372e = faceData.index;
                    bVar.f62373f = faceData.pid;
                    bVar.f62374g = substring;
                    bVar.f62375h = str;
                    bVar.j = faceData.width;
                    bVar.i = faceData.height;
                    this.f62423f.a(bVar);
                    return;
                }
                this.f62423f.onFail("face group: fail to download small file when install search emotion");
                return;
            }
            this.f62423f.onFail("face group: fail to download big file when install search emotion");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f62426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f62427f;

        public g(e eVar, k kVar, boolean z) {
            this.f62426e = kVar;
            this.f62427f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = this.f62426e;
            if (kVar != null) {
                if (this.f62427f) {
                    kVar.onSuccess();
                } else {
                    kVar.onFail();
                }
            }
            if (this.f62427f) {
                d.b.i0.x1.d.m().w();
                MessageManager.getInstance().runTask(2004603, (Class) null);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("upload_result", new Boolean(true));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, hashMap));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f62428e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f62429f;

        public h(l lVar, String str) {
            this.f62428e = lVar;
            this.f62429f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = this.f62428e;
            if (lVar != null) {
                lVar.onFail(this.f62429f);
            }
            if (this.f62429f != null) {
                BdLog.e("face group:" + this.f62429f);
            }
            e.this.u(false, null);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f62431e;

        public i(e eVar, HashMap hashMap) {
            this.f62431e = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, this.f62431e));
        }
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(d.b.i0.x1.f.b bVar);

        void onFail(String str);
    }

    /* loaded from: classes4.dex */
    public interface k {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes4.dex */
    public interface l {
        void a(String str, List<FaceData> list);

        void onFail(String str);
    }

    /* loaded from: classes4.dex */
    public interface m {
        void a(ImageUploadResult imageUploadResult);
    }

    public static e l() {
        if (f62391e == null) {
            synchronized (e.class) {
                if (f62391e == null) {
                    f62391e = new e();
                }
            }
        }
        return f62391e;
    }

    public static String y(String str, Bitmap bitmap, int i2) {
        if (bitmap == null) {
            return null;
        }
        File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
        if (cacheDir.exists() && !cacheDir.isDirectory()) {
            cacheDir.delete();
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        File file = new File(cacheDir, str);
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getAbsolutePath();
            }
            return null;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, d.b.b.e.p.k.join("FileHelper", ".", "saveFileToSDOrMemory", " ", file.getAbsolutePath()));
            return null;
        }
    }

    public void A(String str, List<FaceData> list, l lVar, int i2) {
        this.f62394c = true;
        w(str, list, i2);
        if (TextUtils.isEmpty(str)) {
            t(lVar, "name empty");
        } else if (list == null) {
            t(lVar, "list empty");
        } else {
            z(list);
            d.b.i0.x1.a.b().a(new a(list, lVar, str, i2));
        }
    }

    public final void B(ImageFileInfo imageFileInfo, m mVar) {
        d.b.i0.x1.a.b().a(new b(imageFileInfo, mVar));
    }

    public void i() {
        this.f62395d = null;
        d.b.i0.x1.g.c.a();
    }

    public final boolean j(String str, String str2) {
        Bitmap a2 = d.b.i0.x1.g.b.a(str);
        if (a2 == null) {
            BdLog.e("cover bitmap null");
            return false;
        } else if (TextUtils.isEmpty(d.b.i0.x1.b.e(str2, "panel.png", a2, 60))) {
            BdLog.e("fail to save Panel");
            return false;
        } else if (TextUtils.isEmpty(d.b.i0.x1.b.e(str2, "panel_momo.png", a2, 60))) {
            BdLog.e("fail to save PanelMomo");
            return false;
        } else {
            return true;
        }
    }

    public FaceGroupDraft k() {
        if (this.f62395d == null) {
            this.f62395d = d.b.i0.x1.g.c.b();
        }
        return this.f62395d;
    }

    public final void m(FaceData faceData, String str, j jVar) {
        d.b.i0.x1.a.b().a(new d(this, faceData, str, jVar));
    }

    public final void n(FaceData faceData, String str, j jVar) {
        d.b.i0.x1.a.b().a(new RunnableC1664e(this, faceData, str, jVar));
    }

    public final void o(d.b.i0.x1.f.a aVar, k kVar) {
        int f2 = d.b.i0.l0.a.c().f(aVar);
        if (f2 == 0) {
            BdLog.e("no valid emotion");
            s(kVar, false);
            return;
        }
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.setGroupId(aVar.f62367a);
        emotionGroupData.setEmotionsCount(f2);
        emotionGroupData.setHeight(aVar.f62371e.get(0).i);
        emotionGroupData.setWidth(aVar.f62371e.get(0).j);
        emotionGroupData.setDownloadTime(System.currentTimeMillis());
        emotionGroupData.setGroupName(aVar.f62368b);
        emotionGroupData.setStatus(1);
        d.b.i0.l0.g.k().e(emotionGroupData);
        d.b.i0.l0.g.k().f(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
        s(kVar, true);
    }

    public void p(String str, List<FaceData> list, k kVar) {
        String str2 = d.b.i0.x1.c.f62338c + str + "/";
        new File(str2).mkdirs();
        d.b.i0.x1.f.a aVar = new d.b.i0.x1.f.a();
        TbadkCoreApplication.getCurrentAccount();
        TbadkCoreApplication.getCurrentAccountName();
        aVar.f62367a = str;
        String.valueOf(System.currentTimeMillis());
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        d.b.i0.x1.g.a aVar2 = new d.b.i0.x1.g.a(Boolean.TRUE);
        c cVar = new c(aVar2, copyOnWriteArrayList, list, aVar, str2, kVar);
        for (FaceData faceData : list) {
            if (!aVar2.a()) {
                return;
            }
            int i2 = faceData.type;
            if (i2 == 3) {
                m(faceData, str2, cVar);
            } else if (i2 == 1) {
                n(faceData, str2, cVar);
            } else if (i2 == 2) {
                q(faceData, str2, cVar);
            } else {
                cVar.onFail("facegroup:un support type in list");
                return;
            }
        }
    }

    public final void q(FaceData faceData, String str, j jVar) {
        d.b.i0.x1.a.b().a(new f(faceData, jVar, str));
    }

    public boolean r() {
        return this.f62394c;
    }

    public final void s(k kVar, boolean z) {
        this.f62392a.post(new g(this, kVar, z));
    }

    public final void t(l lVar, String str) {
        this.f62392a.post(new h(lVar, str));
    }

    public void u(boolean z, String str) {
        if (this.f62394c) {
            this.f62394c = false;
        }
        if (z) {
            i();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("upload_result", new Boolean(false));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("upload_msg", str);
            FaceGroupDraft faceGroupDraft = this.f62395d;
            if (faceGroupDraft != null) {
                faceGroupDraft.setFailMsg(str);
            }
        }
        d.b.i0.x1.g.c.c(this.f62395d);
        this.f62392a.postDelayed(new i(this, hashMap), 1000L);
    }

    public final void v(d.b.h0.b0.f fVar) {
        this.f62393b.offer(fVar);
    }

    public void w(String str, List<FaceData> list, int i2) {
        FaceGroupDraft faceGroupDraft = new FaceGroupDraft();
        this.f62395d = faceGroupDraft;
        faceGroupDraft.setName(str);
        this.f62395d.setList(list);
        this.f62395d.setForumId(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String x(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File file = new File(str + str2);
        String parent = file.getParent();
        if (!StringUtils.isNull(parent)) {
            File file2 = new File(parent);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    fileOutputStream3.write(bArr, 0, bArr.length);
                    fileOutputStream3.flush();
                    fileOutputStream3.close();
                    return file.getPath();
                } catch (IOException e2) {
                    fileOutputStream = fileOutputStream3;
                    e = e2;
                    try {
                        BdLog.e(e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th3) {
                                BdLog.e(th3.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream2 = fileOutputStream3;
                    if (fileOutputStream2 != null) {
                    }
                    throw th;
                }
            }
            return null;
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final void z(List<FaceData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (FaceData faceData : list) {
            if (faceData != null) {
                int i5 = faceData.type;
                if (i5 == 1) {
                    i3++;
                } else if (i5 == 2) {
                    i2++;
                } else if (i5 == 3) {
                    i4++;
                }
            }
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
        statisticItem.param("obj_source", 3);
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
        statisticItem2.param("obj_source", 2);
        statisticItem2.param("obj_type", i3);
        TiebaStatic.log(statisticItem2);
        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
        statisticItem3.param("obj_source", 1);
        statisticItem3.param("obj_type", i4);
        TiebaStatic.log(statisticItem3);
    }
}
