package d.a.j0.y1.g;

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
import d.a.j0.l0.u;
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
/* loaded from: classes3.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static volatile e f62775e;

    /* renamed from: a  reason: collision with root package name */
    public Handler f62776a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<d.a.i0.b0.f> f62777b = new LinkedBlockingQueue(4);

    /* renamed from: c  reason: collision with root package name */
    public boolean f62778c;

    /* renamed from: d  reason: collision with root package name */
    public FaceGroupDraft f62779d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public List<FaceData> f62780e = new CopyOnWriteArrayList();

        /* renamed from: f  reason: collision with root package name */
        public List<String> f62781f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Integer> f62782g = new HashMap();

        /* renamed from: h  reason: collision with root package name */
        public List<FaceData> f62783h = new CopyOnWriteArrayList();

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f62784i;
        public final /* synthetic */ l j;
        public final /* synthetic */ String k;
        public final /* synthetic */ int l;

        /* renamed from: d.a.j0.y1.g.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1682a implements m {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.j0.y1.g.a f62785a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FaceData f62786b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f62787c;

            public C1682a(d.a.j0.y1.g.a aVar, FaceData faceData, AtomicInteger atomicInteger) {
                this.f62785a = aVar;
                this.f62786b = faceData;
                this.f62787c = atomicInteger;
            }

            @Override // d.a.j0.y1.g.e.m
            public void a(ImageUploadResult imageUploadResult) {
                if (this.f62785a.a()) {
                    if (imageUploadResult != null && imageUploadResult.error_code == 0) {
                        this.f62786b.pid = String.valueOf(imageUploadResult.picId);
                        FaceData faceData = this.f62786b;
                        ImageUploadResult.PicDetailedInfo picDetailedInfo = imageUploadResult.picInfo.bigPic;
                        faceData.width = picDetailedInfo.width;
                        faceData.height = picDetailedInfo.height;
                        a.this.f62780e.add(faceData);
                        if (this.f62787c.decrementAndGet() == 0) {
                            a.this.b();
                        }
                    } else if (this.f62785a.a()) {
                        this.f62785a.b(false);
                        a aVar = a.this;
                        e.this.t(aVar.j, "failed to upload image");
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: d.a.j0.y1.g.e$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C1683a implements GetEmotionInfosModel.b {
                public C1683a() {
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onFail(int i2, String str) {
                    a aVar = a.this;
                    e.this.t(aVar.j, "get pid fail");
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onSuccess(List<d.a.i0.b0.c> list) {
                    for (d.a.i0.b0.c cVar : list) {
                        if (cVar != null) {
                            FaceData faceData = new FaceData();
                            faceData.type = 2;
                            faceData.index = a.this.f62782g.get(cVar.f48063g).intValue();
                            faceData.pid = cVar.f48057a;
                            faceData.width = cVar.f48058b;
                            faceData.height = cVar.f48059c;
                            EmotionImageData emotionImageData = new EmotionImageData();
                            emotionImageData.setPicId(cVar.f48057a);
                            emotionImageData.setThumbUrl(cVar.f48061e);
                            emotionImageData.setPicUrl(cVar.f48060d);
                            emotionImageData.setWidth(cVar.f48058b);
                            emotionImageData.setHeight(cVar.f48059c);
                            faceData.emotionImageData = emotionImageData;
                            a.this.f62780e.add(faceData);
                        }
                    }
                    UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                    a aVar = a.this;
                    uploadFaceGroupModel.u(aVar.k, aVar.f62780e, aVar.j, aVar.l);
                }
            }

            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f62781f.size() > 0) {
                    new GetEmotionInfosModel().u(a.this.f62781f, new C1683a());
                    return;
                }
                UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                a aVar = a.this;
                uploadFaceGroupModel.u(aVar.k, aVar.f62780e, aVar.j, aVar.l);
            }
        }

        public a(List list, l lVar, String str, int i2) {
            this.f62784i = list;
            this.j = lVar;
            this.k = str;
            this.l = i2;
        }

        public final void b() {
            new Handler(Looper.getMainLooper()).post(new b());
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData;
            for (int i2 = 0; i2 < this.f62784i.size(); i2++) {
                FaceData faceData = (FaceData) this.f62784i.get(i2);
                faceData.index = i2;
                int i3 = faceData.type;
                if (i3 == 2) {
                    EmotionImageData emotionImageData2 = faceData.emotionImageData;
                    if (emotionImageData2 != null) {
                        if (!TextUtils.isEmpty(emotionImageData2.getPicId())) {
                            faceData.pid = emotionImageData2.getPicId();
                            faceData.width = emotionImageData2.getWidth();
                            faceData.height = emotionImageData2.getHeight();
                            this.f62780e.add(faceData);
                        } else {
                            this.f62781f.add(faceData.emotionImageData.getPicUrl());
                            this.f62782g.put(faceData.emotionImageData.getPicUrl(), Integer.valueOf(faceData.index));
                        }
                    }
                } else if (i3 == 3) {
                    this.f62783h.add(faceData);
                } else if (i3 == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                    faceData.pid = emotionImageData.getPicId();
                    faceData.width = emotionImageData.getWidth();
                    faceData.height = emotionImageData.getHeight();
                    this.f62780e.add(faceData);
                }
            }
            if (this.f62783h.size() > 0) {
                AtomicInteger atomicInteger = new AtomicInteger(this.f62783h.size());
                d.a.j0.y1.g.a aVar = new d.a.j0.y1.g.a(Boolean.TRUE);
                for (int i4 = 0; i4 < Math.min(this.f62783h.size(), 4); i4++) {
                    e.this.f62777b.offer(new d.a.i0.b0.f("face group"));
                }
                for (int i5 = 0; i5 < this.f62783h.size() && aVar.a(); i5++) {
                    FaceData faceData2 = this.f62783h.get(i5);
                    e.this.B(faceData2.imageFileInfo, new C1682a(aVar, faceData2, atomicInteger));
                }
                return;
            }
            b();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageFileInfo f62791e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f62792f;

        public b(ImageFileInfo imageFileInfo, m mVar) {
            this.f62791e = imageFileInfo;
            this.f62792f = mVar;
        }

        public final void a(m mVar, ImageUploadResult imageUploadResult) {
            if (mVar != null) {
                mVar.a(imageUploadResult);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String filePath = this.f62791e.getFilePath();
                if (this.f62791e.isGif()) {
                    d.a.i0.b0.f fVar = (d.a.i0.b0.f) e.this.f62777b.poll(10L, TimeUnit.SECONDS);
                    if (fVar != null) {
                        a(this.f62792f, fVar.k(filePath, true, false));
                        e.this.v(fVar);
                        return;
                    }
                    a(this.f62792f, null);
                    return;
                }
                Bitmap b2 = d.a.j0.y1.g.b.b(this.f62791e);
                if (b2 == null) {
                    this.f62792f.a(null);
                    return;
                }
                String y = e.y("face_" + Math.abs(filePath.hashCode()), b2, 60);
                b2.recycle();
                if (!TextUtils.isEmpty(y)) {
                    d.a.i0.b0.f fVar2 = (d.a.i0.b0.f) e.this.f62777b.poll(10L, TimeUnit.SECONDS);
                    if (fVar2 != null) {
                        ImageUploadResult k = fVar2.k(y, false, false);
                        FileHelper.deleteFile(new File(y));
                        a(this.f62792f, k);
                        e.this.v(fVar2);
                        return;
                    }
                    a(this.f62792f, null);
                    return;
                }
                a(this.f62792f, null);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.y1.g.a f62794a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f62795b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f62796c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.y1.f.a f62797d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62798e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f62799f;

        public c(d.a.j0.y1.g.a aVar, List list, List list2, d.a.j0.y1.f.a aVar2, String str, k kVar) {
            this.f62794a = aVar;
            this.f62795b = list;
            this.f62796c = list2;
            this.f62797d = aVar2;
            this.f62798e = str;
            this.f62799f = kVar;
        }

        @Override // d.a.j0.y1.g.e.j
        public void a(d.a.j0.y1.f.b bVar) {
            if (this.f62794a.a()) {
                this.f62795b.add(bVar);
                if (this.f62795b.size() == this.f62796c.size()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f62795b);
                    Collections.sort(arrayList);
                    this.f62797d.f62753e = arrayList;
                    if (e.this.j(this.f62798e + ((d.a.j0.y1.f.b) arrayList.get(0)).f62757h, this.f62798e)) {
                        e.this.o(this.f62797d, this.f62799f);
                    } else {
                        onFail("face group:fail to create panel");
                    }
                }
            }
        }

        @Override // d.a.j0.y1.g.e.j
        public void onFail(String str) {
            if (this.f62794a.a()) {
                this.f62794a.b(false);
                e.this.s(this.f62799f, false);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f62801e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f62802f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f62803g;

        public d(e eVar, FaceData faceData, String str, j jVar) {
            this.f62801e = faceData;
            this.f62802f = str;
            this.f62803g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap resizeBitmap;
            ImageFileInfo imageFileInfo = this.f62801e.imageFileInfo;
            String filePath = imageFileInfo.getFilePath();
            String substring = filePath.substring(filePath.lastIndexOf("/") + 1);
            if (TextUtils.isEmpty(substring)) {
                substring = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis() + ".jpg";
            }
            String str = "t_" + substring;
            if (FileHelper.copyFile(filePath, this.f62802f + substring)) {
                Bitmap b2 = d.a.j0.y1.g.b.b(imageFileInfo);
                if (b2 == null) {
                    this.f62803g.onFail("face group: fail to get origin bitmap when install album emotion");
                    return;
                }
                if (!imageFileInfo.isGif() && (resizeBitmap = BitmapHelper.resizeBitmap(b2, 240, 240, false)) != null) {
                    d.a.j0.y1.b.e(this.f62802f, substring, resizeBitmap, 100);
                    if (resizeBitmap != b2) {
                        resizeBitmap.recycle();
                    }
                }
                Bitmap resizeBitmap2 = BitmapHelper.resizeBitmap(b2, 150, 150, false);
                if (resizeBitmap2 == null) {
                    this.f62803g.onFail("face group: fail to create small file when install album emotion");
                    return;
                }
                d.a.j0.y1.b.e(this.f62802f, str, resizeBitmap2, 100);
                if (resizeBitmap2 != b2) {
                    resizeBitmap2.recycle();
                }
                b2.recycle();
                d.a.j0.y1.f.b bVar = new d.a.j0.y1.f.b();
                FaceData faceData = this.f62801e;
                bVar.f62754e = faceData.index;
                bVar.f62755f = faceData.pid;
                bVar.f62756g = substring;
                bVar.f62757h = str;
                bVar.j = faceData.width;
                bVar.f62758i = faceData.height;
                this.f62803g.a(bVar);
                return;
            }
            this.f62803g.onFail("face group: fail to copy file when install album emotion");
        }
    }

    /* renamed from: d.a.j0.y1.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1684e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f62804e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f62805f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f62806g;

        public RunnableC1684e(e eVar, FaceData faceData, String str, j jVar) {
            this.f62804e = faceData;
            this.f62805f = str;
            this.f62806g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData = this.f62804e.emotionImageData;
            String str = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis();
            String str2 = "t_" + str;
            String o = u.o(this.f62804e.pid, true);
            String o2 = u.o(this.f62804e.pid, false);
            if (!FileHelper.copyFile(o, this.f62805f + str)) {
                this.f62806g.onFail("face group: fail to copy big file when install collect emotion");
                return;
            }
            if (!FileHelper.copyFile(o2, this.f62805f + str2)) {
                this.f62806g.onFail("face group: fail to copy small file when install collect emotion");
                return;
            }
            d.a.j0.y1.f.b bVar = new d.a.j0.y1.f.b();
            FaceData faceData = this.f62804e;
            bVar.f62754e = faceData.index;
            bVar.f62755f = faceData.pid;
            bVar.f62756g = str;
            bVar.f62757h = str2;
            bVar.j = faceData.width;
            bVar.f62758i = faceData.height;
            this.f62806g.a(bVar);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f62807e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f62808f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f62809g;

        public f(FaceData faceData, j jVar, String str) {
            this.f62807e = faceData;
            this.f62808f = jVar;
            this.f62809g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData = this.f62807e.emotionImageData;
            String substring = emotionImageData.getPicUrl().substring(emotionImageData.getPicUrl().lastIndexOf(IStringUtil.WINDOWS_FOLDER_SEPARATOR) + 1);
            String str = "t_" + substring;
            WebClient webClient = new WebClient();
            byte[] downloadImageBytes = webClient.downloadImageBytes(emotionImageData.getPicUrl(), false);
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                e.this.x(this.f62809g, substring, downloadImageBytes);
                byte[] downloadImageBytes2 = webClient.downloadImageBytes(emotionImageData.getThumbUrl(), false);
                if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                    e.this.x(this.f62809g, str, downloadImageBytes2);
                    d.a.j0.y1.f.b bVar = new d.a.j0.y1.f.b();
                    FaceData faceData = this.f62807e;
                    bVar.f62754e = faceData.index;
                    bVar.f62755f = faceData.pid;
                    bVar.f62756g = substring;
                    bVar.f62757h = str;
                    bVar.j = faceData.width;
                    bVar.f62758i = faceData.height;
                    this.f62808f.a(bVar);
                    return;
                }
                this.f62808f.onFail("face group: fail to download small file when install search emotion");
                return;
            }
            this.f62808f.onFail("face group: fail to download big file when install search emotion");
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f62811e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f62812f;

        public g(e eVar, k kVar, boolean z) {
            this.f62811e = kVar;
            this.f62812f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = this.f62811e;
            if (kVar != null) {
                if (this.f62812f) {
                    kVar.onSuccess();
                } else {
                    kVar.onFail();
                }
            }
            if (this.f62812f) {
                d.a.j0.y1.d.m().w();
                MessageManager.getInstance().runTask(2004603, (Class) null);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("upload_result", new Boolean(true));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, hashMap));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f62813e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f62814f;

        public h(l lVar, String str) {
            this.f62813e = lVar;
            this.f62814f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = this.f62813e;
            if (lVar != null) {
                lVar.onFail(this.f62814f);
            }
            if (this.f62814f != null) {
                BdLog.e("face group:" + this.f62814f);
            }
            e.this.u(false, null);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f62816e;

        public i(e eVar, HashMap hashMap) {
            this.f62816e = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, this.f62816e));
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(d.a.j0.y1.f.b bVar);

        void onFail(String str);
    }

    /* loaded from: classes3.dex */
    public interface k {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes3.dex */
    public interface l {
        void a(String str, List<FaceData> list);

        void onFail(String str);
    }

    /* loaded from: classes3.dex */
    public interface m {
        void a(ImageUploadResult imageUploadResult);
    }

    public static e l() {
        if (f62775e == null) {
            synchronized (e.class) {
                if (f62775e == null) {
                    f62775e = new e();
                }
            }
        }
        return f62775e;
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
            TiebaStatic.file(e2, d.a.c.e.p.k.join("FileHelper", ".", "saveFileToSDOrMemory", " ", file.getAbsolutePath()));
            return null;
        }
    }

    public void A(String str, List<FaceData> list, l lVar, int i2) {
        this.f62778c = true;
        w(str, list, i2);
        if (TextUtils.isEmpty(str)) {
            t(lVar, "name empty");
        } else if (list == null) {
            t(lVar, "list empty");
        } else {
            z(list);
            d.a.j0.y1.a.b().a(new a(list, lVar, str, i2));
        }
    }

    public final void B(ImageFileInfo imageFileInfo, m mVar) {
        d.a.j0.y1.a.b().a(new b(imageFileInfo, mVar));
    }

    public void i() {
        this.f62779d = null;
        d.a.j0.y1.g.c.a();
    }

    public final boolean j(String str, String str2) {
        Bitmap a2 = d.a.j0.y1.g.b.a(str);
        if (a2 == null) {
            BdLog.e("cover bitmap null");
            return false;
        } else if (TextUtils.isEmpty(d.a.j0.y1.b.e(str2, "panel.png", a2, 60))) {
            BdLog.e("fail to save Panel");
            return false;
        } else if (TextUtils.isEmpty(d.a.j0.y1.b.e(str2, "panel_momo.png", a2, 60))) {
            BdLog.e("fail to save PanelMomo");
            return false;
        } else {
            return true;
        }
    }

    public FaceGroupDraft k() {
        if (this.f62779d == null) {
            this.f62779d = d.a.j0.y1.g.c.b();
        }
        return this.f62779d;
    }

    public final void m(FaceData faceData, String str, j jVar) {
        d.a.j0.y1.a.b().a(new d(this, faceData, str, jVar));
    }

    public final void n(FaceData faceData, String str, j jVar) {
        d.a.j0.y1.a.b().a(new RunnableC1684e(this, faceData, str, jVar));
    }

    public final void o(d.a.j0.y1.f.a aVar, k kVar) {
        int f2 = d.a.j0.l0.a.c().f(aVar);
        if (f2 == 0) {
            BdLog.e("no valid emotion");
            s(kVar, false);
            return;
        }
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.setGroupId(aVar.f62749a);
        emotionGroupData.setEmotionsCount(f2);
        emotionGroupData.setHeight(aVar.f62753e.get(0).f62758i);
        emotionGroupData.setWidth(aVar.f62753e.get(0).j);
        emotionGroupData.setDownloadTime(System.currentTimeMillis());
        emotionGroupData.setGroupName(aVar.f62750b);
        emotionGroupData.setStatus(1);
        d.a.j0.l0.g.k().e(emotionGroupData);
        d.a.j0.l0.g.k().f(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
        s(kVar, true);
    }

    public void p(String str, List<FaceData> list, k kVar) {
        String str2 = d.a.j0.y1.c.f62720c + str + "/";
        new File(str2).mkdirs();
        d.a.j0.y1.f.a aVar = new d.a.j0.y1.f.a();
        TbadkCoreApplication.getCurrentAccount();
        TbadkCoreApplication.getCurrentAccountName();
        aVar.f62749a = str;
        String.valueOf(System.currentTimeMillis());
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        d.a.j0.y1.g.a aVar2 = new d.a.j0.y1.g.a(Boolean.TRUE);
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
        d.a.j0.y1.a.b().a(new f(faceData, jVar, str));
    }

    public boolean r() {
        return this.f62778c;
    }

    public final void s(k kVar, boolean z) {
        this.f62776a.post(new g(this, kVar, z));
    }

    public final void t(l lVar, String str) {
        this.f62776a.post(new h(lVar, str));
    }

    public void u(boolean z, String str) {
        if (this.f62778c) {
            this.f62778c = false;
        }
        if (z) {
            i();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("upload_result", new Boolean(false));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("upload_msg", str);
            FaceGroupDraft faceGroupDraft = this.f62779d;
            if (faceGroupDraft != null) {
                faceGroupDraft.setFailMsg(str);
            }
        }
        d.a.j0.y1.g.c.c(this.f62779d);
        this.f62776a.postDelayed(new i(this, hashMap), 1000L);
    }

    public final void v(d.a.i0.b0.f fVar) {
        this.f62777b.offer(fVar);
    }

    public void w(String str, List<FaceData> list, int i2) {
        FaceGroupDraft faceGroupDraft = new FaceGroupDraft();
        this.f62779d = faceGroupDraft;
        faceGroupDraft.setName(str);
        this.f62779d.setList(list);
        this.f62779d.setForumId(i2);
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
