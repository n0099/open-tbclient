package d.b.j0.y1.g;

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
import d.b.j0.l0.u;
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
    public static volatile e f64498e;

    /* renamed from: a  reason: collision with root package name */
    public Handler f64499a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<d.b.i0.b0.f> f64500b = new LinkedBlockingQueue(4);

    /* renamed from: c  reason: collision with root package name */
    public boolean f64501c;

    /* renamed from: d  reason: collision with root package name */
    public FaceGroupDraft f64502d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public List<FaceData> f64503e = new CopyOnWriteArrayList();

        /* renamed from: f  reason: collision with root package name */
        public List<String> f64504f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Integer> f64505g = new HashMap();

        /* renamed from: h  reason: collision with root package name */
        public List<FaceData> f64506h = new CopyOnWriteArrayList();
        public final /* synthetic */ List i;
        public final /* synthetic */ l j;
        public final /* synthetic */ String k;
        public final /* synthetic */ int l;

        /* renamed from: d.b.j0.y1.g.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1745a implements m {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.j0.y1.g.a f64507a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FaceData f64508b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f64509c;

            public C1745a(d.b.j0.y1.g.a aVar, FaceData faceData, AtomicInteger atomicInteger) {
                this.f64507a = aVar;
                this.f64508b = faceData;
                this.f64509c = atomicInteger;
            }

            @Override // d.b.j0.y1.g.e.m
            public void a(ImageUploadResult imageUploadResult) {
                if (this.f64507a.a()) {
                    if (imageUploadResult != null && imageUploadResult.error_code == 0) {
                        this.f64508b.pid = String.valueOf(imageUploadResult.picId);
                        FaceData faceData = this.f64508b;
                        ImageUploadResult.PicDetailedInfo picDetailedInfo = imageUploadResult.picInfo.bigPic;
                        faceData.width = picDetailedInfo.width;
                        faceData.height = picDetailedInfo.height;
                        a.this.f64503e.add(faceData);
                        if (this.f64509c.decrementAndGet() == 0) {
                            a.this.b();
                        }
                    } else if (this.f64507a.a()) {
                        this.f64507a.b(false);
                        a aVar = a.this;
                        e.this.t(aVar.j, "failed to upload image");
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: d.b.j0.y1.g.e$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C1746a implements GetEmotionInfosModel.b {
                public C1746a() {
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onFail(int i, String str) {
                    a aVar = a.this;
                    e.this.t(aVar.j, "get pid fail");
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onSuccess(List<d.b.i0.b0.c> list) {
                    for (d.b.i0.b0.c cVar : list) {
                        if (cVar != null) {
                            FaceData faceData = new FaceData();
                            faceData.type = 2;
                            faceData.index = a.this.f64505g.get(cVar.f50509g).intValue();
                            faceData.pid = cVar.f50503a;
                            faceData.width = cVar.f50504b;
                            faceData.height = cVar.f50505c;
                            EmotionImageData emotionImageData = new EmotionImageData();
                            emotionImageData.setPicId(cVar.f50503a);
                            emotionImageData.setThumbUrl(cVar.f50507e);
                            emotionImageData.setPicUrl(cVar.f50506d);
                            emotionImageData.setWidth(cVar.f50504b);
                            emotionImageData.setHeight(cVar.f50505c);
                            faceData.emotionImageData = emotionImageData;
                            a.this.f64503e.add(faceData);
                        }
                    }
                    UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                    a aVar = a.this;
                    uploadFaceGroupModel.u(aVar.k, aVar.f64503e, aVar.j, aVar.l);
                }
            }

            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f64504f.size() > 0) {
                    new GetEmotionInfosModel().u(a.this.f64504f, new C1746a());
                    return;
                }
                UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                a aVar = a.this;
                uploadFaceGroupModel.u(aVar.k, aVar.f64503e, aVar.j, aVar.l);
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
                            this.f64503e.add(faceData);
                        } else {
                            this.f64504f.add(faceData.emotionImageData.getPicUrl());
                            this.f64505g.put(faceData.emotionImageData.getPicUrl(), Integer.valueOf(faceData.index));
                        }
                    }
                } else if (i2 == 3) {
                    this.f64506h.add(faceData);
                } else if (i2 == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                    faceData.pid = emotionImageData.getPicId();
                    faceData.width = emotionImageData.getWidth();
                    faceData.height = emotionImageData.getHeight();
                    this.f64503e.add(faceData);
                }
            }
            if (this.f64506h.size() > 0) {
                AtomicInteger atomicInteger = new AtomicInteger(this.f64506h.size());
                d.b.j0.y1.g.a aVar = new d.b.j0.y1.g.a(Boolean.TRUE);
                for (int i3 = 0; i3 < Math.min(this.f64506h.size(), 4); i3++) {
                    e.this.f64500b.offer(new d.b.i0.b0.f("face group"));
                }
                for (int i4 = 0; i4 < this.f64506h.size() && aVar.a(); i4++) {
                    FaceData faceData2 = this.f64506h.get(i4);
                    e.this.B(faceData2.imageFileInfo, new C1745a(aVar, faceData2, atomicInteger));
                }
                return;
            }
            b();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageFileInfo f64513e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f64514f;

        public b(ImageFileInfo imageFileInfo, m mVar) {
            this.f64513e = imageFileInfo;
            this.f64514f = mVar;
        }

        public final void a(m mVar, ImageUploadResult imageUploadResult) {
            if (mVar != null) {
                mVar.a(imageUploadResult);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String filePath = this.f64513e.getFilePath();
                if (this.f64513e.isGif()) {
                    d.b.i0.b0.f fVar = (d.b.i0.b0.f) e.this.f64500b.poll(10L, TimeUnit.SECONDS);
                    if (fVar != null) {
                        a(this.f64514f, fVar.k(filePath, true, false));
                        e.this.v(fVar);
                        return;
                    }
                    a(this.f64514f, null);
                    return;
                }
                Bitmap b2 = d.b.j0.y1.g.b.b(this.f64513e);
                if (b2 == null) {
                    this.f64514f.a(null);
                    return;
                }
                String y = e.y("face_" + Math.abs(filePath.hashCode()), b2, 60);
                b2.recycle();
                if (!TextUtils.isEmpty(y)) {
                    d.b.i0.b0.f fVar2 = (d.b.i0.b0.f) e.this.f64500b.poll(10L, TimeUnit.SECONDS);
                    if (fVar2 != null) {
                        ImageUploadResult k = fVar2.k(y, false, false);
                        FileHelper.deleteFile(new File(y));
                        a(this.f64514f, k);
                        e.this.v(fVar2);
                        return;
                    }
                    a(this.f64514f, null);
                    return;
                }
                a(this.f64514f, null);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.y1.g.a f64516a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f64517b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f64518c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.y1.f.a f64519d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64520e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f64521f;

        public c(d.b.j0.y1.g.a aVar, List list, List list2, d.b.j0.y1.f.a aVar2, String str, k kVar) {
            this.f64516a = aVar;
            this.f64517b = list;
            this.f64518c = list2;
            this.f64519d = aVar2;
            this.f64520e = str;
            this.f64521f = kVar;
        }

        @Override // d.b.j0.y1.g.e.j
        public void a(d.b.j0.y1.f.b bVar) {
            if (this.f64516a.a()) {
                this.f64517b.add(bVar);
                if (this.f64517b.size() == this.f64518c.size()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f64517b);
                    Collections.sort(arrayList);
                    this.f64519d.f64478e = arrayList;
                    if (e.this.j(this.f64520e + ((d.b.j0.y1.f.b) arrayList.get(0)).f64482h, this.f64520e)) {
                        e.this.o(this.f64519d, this.f64521f);
                    } else {
                        onFail("face group:fail to create panel");
                    }
                }
            }
        }

        @Override // d.b.j0.y1.g.e.j
        public void onFail(String str) {
            if (this.f64516a.a()) {
                this.f64516a.b(false);
                e.this.s(this.f64521f, false);
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
        public final /* synthetic */ FaceData f64523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64524f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f64525g;

        public d(e eVar, FaceData faceData, String str, j jVar) {
            this.f64523e = faceData;
            this.f64524f = str;
            this.f64525g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap resizeBitmap;
            ImageFileInfo imageFileInfo = this.f64523e.imageFileInfo;
            String filePath = imageFileInfo.getFilePath();
            String substring = filePath.substring(filePath.lastIndexOf("/") + 1);
            if (TextUtils.isEmpty(substring)) {
                substring = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis() + ".jpg";
            }
            String str = "t_" + substring;
            if (FileHelper.copyFile(filePath, this.f64524f + substring)) {
                Bitmap b2 = d.b.j0.y1.g.b.b(imageFileInfo);
                if (b2 == null) {
                    this.f64525g.onFail("face group: fail to get origin bitmap when install album emotion");
                    return;
                }
                if (!imageFileInfo.isGif() && (resizeBitmap = BitmapHelper.resizeBitmap(b2, 240, 240, false)) != null) {
                    d.b.j0.y1.b.e(this.f64524f, substring, resizeBitmap, 100);
                    if (resizeBitmap != b2) {
                        resizeBitmap.recycle();
                    }
                }
                Bitmap resizeBitmap2 = BitmapHelper.resizeBitmap(b2, 150, 150, false);
                if (resizeBitmap2 == null) {
                    this.f64525g.onFail("face group: fail to create small file when install album emotion");
                    return;
                }
                d.b.j0.y1.b.e(this.f64524f, str, resizeBitmap2, 100);
                if (resizeBitmap2 != b2) {
                    resizeBitmap2.recycle();
                }
                b2.recycle();
                d.b.j0.y1.f.b bVar = new d.b.j0.y1.f.b();
                FaceData faceData = this.f64523e;
                bVar.f64479e = faceData.index;
                bVar.f64480f = faceData.pid;
                bVar.f64481g = substring;
                bVar.f64482h = str;
                bVar.j = faceData.width;
                bVar.i = faceData.height;
                this.f64525g.a(bVar);
                return;
            }
            this.f64525g.onFail("face group: fail to copy file when install album emotion");
        }
    }

    /* renamed from: d.b.j0.y1.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1747e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f64526e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64527f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f64528g;

        public RunnableC1747e(e eVar, FaceData faceData, String str, j jVar) {
            this.f64526e = faceData;
            this.f64527f = str;
            this.f64528g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData = this.f64526e.emotionImageData;
            String str = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis();
            String str2 = "t_" + str;
            String o = u.o(this.f64526e.pid, true);
            String o2 = u.o(this.f64526e.pid, false);
            if (!FileHelper.copyFile(o, this.f64527f + str)) {
                this.f64528g.onFail("face group: fail to copy big file when install collect emotion");
                return;
            }
            if (!FileHelper.copyFile(o2, this.f64527f + str2)) {
                this.f64528g.onFail("face group: fail to copy small file when install collect emotion");
                return;
            }
            d.b.j0.y1.f.b bVar = new d.b.j0.y1.f.b();
            FaceData faceData = this.f64526e;
            bVar.f64479e = faceData.index;
            bVar.f64480f = faceData.pid;
            bVar.f64481g = str;
            bVar.f64482h = str2;
            bVar.j = faceData.width;
            bVar.i = faceData.height;
            this.f64528g.a(bVar);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f64529e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f64530f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f64531g;

        public f(FaceData faceData, j jVar, String str) {
            this.f64529e = faceData;
            this.f64530f = jVar;
            this.f64531g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData = this.f64529e.emotionImageData;
            String substring = emotionImageData.getPicUrl().substring(emotionImageData.getPicUrl().lastIndexOf(IStringUtil.WINDOWS_FOLDER_SEPARATOR) + 1);
            String str = "t_" + substring;
            WebClient webClient = new WebClient();
            byte[] downloadImageBytes = webClient.downloadImageBytes(emotionImageData.getPicUrl(), false);
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                e.this.x(this.f64531g, substring, downloadImageBytes);
                byte[] downloadImageBytes2 = webClient.downloadImageBytes(emotionImageData.getThumbUrl(), false);
                if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                    e.this.x(this.f64531g, str, downloadImageBytes2);
                    d.b.j0.y1.f.b bVar = new d.b.j0.y1.f.b();
                    FaceData faceData = this.f64529e;
                    bVar.f64479e = faceData.index;
                    bVar.f64480f = faceData.pid;
                    bVar.f64481g = substring;
                    bVar.f64482h = str;
                    bVar.j = faceData.width;
                    bVar.i = faceData.height;
                    this.f64530f.a(bVar);
                    return;
                }
                this.f64530f.onFail("face group: fail to download small file when install search emotion");
                return;
            }
            this.f64530f.onFail("face group: fail to download big file when install search emotion");
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f64533e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f64534f;

        public g(e eVar, k kVar, boolean z) {
            this.f64533e = kVar;
            this.f64534f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = this.f64533e;
            if (kVar != null) {
                if (this.f64534f) {
                    kVar.onSuccess();
                } else {
                    kVar.onFail();
                }
            }
            if (this.f64534f) {
                d.b.j0.y1.d.m().w();
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
        public final /* synthetic */ l f64535e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64536f;

        public h(l lVar, String str) {
            this.f64535e = lVar;
            this.f64536f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = this.f64535e;
            if (lVar != null) {
                lVar.onFail(this.f64536f);
            }
            if (this.f64536f != null) {
                BdLog.e("face group:" + this.f64536f);
            }
            e.this.u(false, null);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f64538e;

        public i(e eVar, HashMap hashMap) {
            this.f64538e = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, this.f64538e));
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(d.b.j0.y1.f.b bVar);

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
        if (f64498e == null) {
            synchronized (e.class) {
                if (f64498e == null) {
                    f64498e = new e();
                }
            }
        }
        return f64498e;
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
            TiebaStatic.file(e2, d.b.c.e.p.k.join("FileHelper", ".", "saveFileToSDOrMemory", " ", file.getAbsolutePath()));
            return null;
        }
    }

    public void A(String str, List<FaceData> list, l lVar, int i2) {
        this.f64501c = true;
        w(str, list, i2);
        if (TextUtils.isEmpty(str)) {
            t(lVar, "name empty");
        } else if (list == null) {
            t(lVar, "list empty");
        } else {
            z(list);
            d.b.j0.y1.a.b().a(new a(list, lVar, str, i2));
        }
    }

    public final void B(ImageFileInfo imageFileInfo, m mVar) {
        d.b.j0.y1.a.b().a(new b(imageFileInfo, mVar));
    }

    public void i() {
        this.f64502d = null;
        d.b.j0.y1.g.c.a();
    }

    public final boolean j(String str, String str2) {
        Bitmap a2 = d.b.j0.y1.g.b.a(str);
        if (a2 == null) {
            BdLog.e("cover bitmap null");
            return false;
        } else if (TextUtils.isEmpty(d.b.j0.y1.b.e(str2, "panel.png", a2, 60))) {
            BdLog.e("fail to save Panel");
            return false;
        } else if (TextUtils.isEmpty(d.b.j0.y1.b.e(str2, "panel_momo.png", a2, 60))) {
            BdLog.e("fail to save PanelMomo");
            return false;
        } else {
            return true;
        }
    }

    public FaceGroupDraft k() {
        if (this.f64502d == null) {
            this.f64502d = d.b.j0.y1.g.c.b();
        }
        return this.f64502d;
    }

    public final void m(FaceData faceData, String str, j jVar) {
        d.b.j0.y1.a.b().a(new d(this, faceData, str, jVar));
    }

    public final void n(FaceData faceData, String str, j jVar) {
        d.b.j0.y1.a.b().a(new RunnableC1747e(this, faceData, str, jVar));
    }

    public final void o(d.b.j0.y1.f.a aVar, k kVar) {
        int f2 = d.b.j0.l0.a.c().f(aVar);
        if (f2 == 0) {
            BdLog.e("no valid emotion");
            s(kVar, false);
            return;
        }
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.setGroupId(aVar.f64474a);
        emotionGroupData.setEmotionsCount(f2);
        emotionGroupData.setHeight(aVar.f64478e.get(0).i);
        emotionGroupData.setWidth(aVar.f64478e.get(0).j);
        emotionGroupData.setDownloadTime(System.currentTimeMillis());
        emotionGroupData.setGroupName(aVar.f64475b);
        emotionGroupData.setStatus(1);
        d.b.j0.l0.g.k().e(emotionGroupData);
        d.b.j0.l0.g.k().f(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
        s(kVar, true);
    }

    public void p(String str, List<FaceData> list, k kVar) {
        String str2 = d.b.j0.y1.c.f64445c + str + "/";
        new File(str2).mkdirs();
        d.b.j0.y1.f.a aVar = new d.b.j0.y1.f.a();
        TbadkCoreApplication.getCurrentAccount();
        TbadkCoreApplication.getCurrentAccountName();
        aVar.f64474a = str;
        String.valueOf(System.currentTimeMillis());
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        d.b.j0.y1.g.a aVar2 = new d.b.j0.y1.g.a(Boolean.TRUE);
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
        d.b.j0.y1.a.b().a(new f(faceData, jVar, str));
    }

    public boolean r() {
        return this.f64501c;
    }

    public final void s(k kVar, boolean z) {
        this.f64499a.post(new g(this, kVar, z));
    }

    public final void t(l lVar, String str) {
        this.f64499a.post(new h(lVar, str));
    }

    public void u(boolean z, String str) {
        if (this.f64501c) {
            this.f64501c = false;
        }
        if (z) {
            i();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("upload_result", new Boolean(false));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("upload_msg", str);
            FaceGroupDraft faceGroupDraft = this.f64502d;
            if (faceGroupDraft != null) {
                faceGroupDraft.setFailMsg(str);
            }
        }
        d.b.j0.y1.g.c.c(this.f64502d);
        this.f64499a.postDelayed(new i(this, hashMap), 1000L);
    }

    public final void v(d.b.i0.b0.f fVar) {
        this.f64500b.offer(fVar);
    }

    public void w(String str, List<FaceData> list, int i2) {
        FaceGroupDraft faceGroupDraft = new FaceGroupDraft();
        this.f64502d = faceGroupDraft;
        faceGroupDraft.setName(str);
        this.f64502d.setList(list);
        this.f64502d.setForumId(i2);
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
