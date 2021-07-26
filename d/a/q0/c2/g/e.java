package d.a.q0.c2.g;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.p0.u;
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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile e f55259e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f55260a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<d.a.p0.c0.f> f55261b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55262c;

    /* renamed from: d  reason: collision with root package name */
    public FaceGroupDraft f55263d;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<FaceData> f55264e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f55265f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Integer> f55266g;

        /* renamed from: h  reason: collision with root package name */
        public List<FaceData> f55267h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f55268i;
        public final /* synthetic */ l j;
        public final /* synthetic */ String k;
        public final /* synthetic */ int l;
        public final /* synthetic */ e m;

        /* renamed from: d.a.q0.c2.g.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1315a implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.c2.g.a f55269a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FaceData f55270b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f55271c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f55272d;

            public C1315a(a aVar, d.a.q0.c2.g.a aVar2, FaceData faceData, AtomicInteger atomicInteger) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, aVar2, faceData, atomicInteger};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55272d = aVar;
                this.f55269a = aVar2;
                this.f55270b = faceData;
                this.f55271c = atomicInteger;
            }

            @Override // d.a.q0.c2.g.e.m
            public void a(ImageUploadResult imageUploadResult) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, imageUploadResult) == null) && this.f55269a.a()) {
                    if (imageUploadResult != null && imageUploadResult.error_code == 0) {
                        this.f55270b.pid = String.valueOf(imageUploadResult.picId);
                        FaceData faceData = this.f55270b;
                        ImageUploadResult.PicDetailedInfo picDetailedInfo = imageUploadResult.picInfo.bigPic;
                        faceData.width = picDetailedInfo.width;
                        faceData.height = picDetailedInfo.height;
                        this.f55272d.f55264e.add(faceData);
                        if (this.f55271c.decrementAndGet() == 0) {
                            this.f55272d.b();
                        }
                    } else if (this.f55269a.a()) {
                        this.f55269a.b(false);
                        a aVar = this.f55272d;
                        aVar.m.t(aVar.j, "failed to upload image");
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f55273e;

            /* renamed from: d.a.q0.c2.g.e$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C1316a implements GetEmotionInfosModel.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f55274a;

                public C1316a(b bVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f55274a = bVar;
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onFail(int i2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                        a aVar = this.f55274a.f55273e;
                        aVar.m.t(aVar.j, "get pid fail");
                    }
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onSuccess(List<d.a.p0.c0.c> list) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        for (d.a.p0.c0.c cVar : list) {
                            if (cVar != null) {
                                FaceData faceData = new FaceData();
                                faceData.type = 2;
                                faceData.index = this.f55274a.f55273e.f55266g.get(cVar.f52186g).intValue();
                                faceData.pid = cVar.f52180a;
                                faceData.width = cVar.f52181b;
                                faceData.height = cVar.f52182c;
                                EmotionImageData emotionImageData = new EmotionImageData();
                                emotionImageData.setPicId(cVar.f52180a);
                                emotionImageData.setThumbUrl(cVar.f52184e);
                                emotionImageData.setPicUrl(cVar.f52183d);
                                emotionImageData.setWidth(cVar.f52181b);
                                emotionImageData.setHeight(cVar.f52182c);
                                faceData.emotionImageData = emotionImageData;
                                this.f55274a.f55273e.f55264e.add(faceData);
                            }
                        }
                        UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                        a aVar = this.f55274a.f55273e;
                        uploadFaceGroupModel.y(aVar.k, aVar.f55264e, aVar.j, aVar.l);
                    }
                }
            }

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55273e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f55273e.f55265f.size() > 0) {
                        new GetEmotionInfosModel().y(this.f55273e.f55265f, new C1316a(this));
                        return;
                    }
                    UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                    a aVar = this.f55273e;
                    uploadFaceGroupModel.y(aVar.k, aVar.f55264e, aVar.j, aVar.l);
                }
            }
        }

        public a(e eVar, List list, l lVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, list, lVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = eVar;
            this.f55268i = list;
            this.j = lVar;
            this.k = str;
            this.l = i2;
            this.f55264e = new CopyOnWriteArrayList();
            this.f55265f = new ArrayList();
            this.f55266g = new HashMap();
            this.f55267h = new CopyOnWriteArrayList();
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                new Handler(Looper.getMainLooper()).post(new b(this));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (int i2 = 0; i2 < this.f55268i.size(); i2++) {
                    FaceData faceData = (FaceData) this.f55268i.get(i2);
                    faceData.index = i2;
                    int i3 = faceData.type;
                    if (i3 == 2) {
                        EmotionImageData emotionImageData2 = faceData.emotionImageData;
                        if (emotionImageData2 != null) {
                            if (!TextUtils.isEmpty(emotionImageData2.getPicId())) {
                                faceData.pid = emotionImageData2.getPicId();
                                faceData.width = emotionImageData2.getWidth();
                                faceData.height = emotionImageData2.getHeight();
                                this.f55264e.add(faceData);
                            } else {
                                this.f55265f.add(faceData.emotionImageData.getPicUrl());
                                this.f55266g.put(faceData.emotionImageData.getPicUrl(), Integer.valueOf(faceData.index));
                            }
                        }
                    } else if (i3 == 3) {
                        this.f55267h.add(faceData);
                    } else if (i3 == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                        faceData.pid = emotionImageData.getPicId();
                        faceData.width = emotionImageData.getWidth();
                        faceData.height = emotionImageData.getHeight();
                        this.f55264e.add(faceData);
                    }
                }
                if (this.f55267h.size() > 0) {
                    AtomicInteger atomicInteger = new AtomicInteger(this.f55267h.size());
                    d.a.q0.c2.g.a aVar = new d.a.q0.c2.g.a(Boolean.TRUE);
                    for (int i4 = 0; i4 < Math.min(this.f55267h.size(), 4); i4++) {
                        this.m.f55261b.offer(new d.a.p0.c0.f("face group"));
                    }
                    for (int i5 = 0; i5 < this.f55267h.size() && aVar.a(); i5++) {
                        FaceData faceData2 = this.f55267h.get(i5);
                        this.m.B(faceData2.imageFileInfo, new C1315a(this, aVar, faceData2, atomicInteger));
                    }
                    return;
                }
                b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageFileInfo f55275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f55276f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f55277g;

        public b(e eVar, ImageFileInfo imageFileInfo, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, imageFileInfo, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55277g = eVar;
            this.f55275e = imageFileInfo;
            this.f55276f = mVar;
        }

        public final void a(m mVar, ImageUploadResult imageUploadResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, mVar, imageUploadResult) == null) || mVar == null) {
                return;
            }
            mVar.a(imageUploadResult);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    String filePath = this.f55275e.getFilePath();
                    if (this.f55275e.isGif()) {
                        d.a.p0.c0.f fVar = (d.a.p0.c0.f) this.f55277g.f55261b.poll(10L, TimeUnit.SECONDS);
                        if (fVar != null) {
                            a(this.f55276f, fVar.l(filePath, true, false));
                            this.f55277g.v(fVar);
                            return;
                        }
                        a(this.f55276f, null);
                        return;
                    }
                    Bitmap b2 = d.a.q0.c2.g.b.b(this.f55275e);
                    if (b2 == null) {
                        this.f55276f.a(null);
                        return;
                    }
                    String y = e.y("face_" + Math.abs(filePath.hashCode()), b2, 60);
                    b2.recycle();
                    if (!TextUtils.isEmpty(y)) {
                        d.a.p0.c0.f fVar2 = (d.a.p0.c0.f) this.f55277g.f55261b.poll(10L, TimeUnit.SECONDS);
                        if (fVar2 != null) {
                            ImageUploadResult l = fVar2.l(y, false, false);
                            FileHelper.deleteFile(new File(y));
                            a(this.f55276f, l);
                            this.f55277g.v(fVar2);
                            return;
                        }
                        a(this.f55276f, null);
                        return;
                    }
                    a(this.f55276f, null);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.c2.g.a f55278a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f55279b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f55280c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.c2.f.a f55281d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f55283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f55284g;

        public c(e eVar, d.a.q0.c2.g.a aVar, List list, List list2, d.a.q0.c2.f.a aVar2, String str, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar, list, list2, aVar2, str, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55284g = eVar;
            this.f55278a = aVar;
            this.f55279b = list;
            this.f55280c = list2;
            this.f55281d = aVar2;
            this.f55282e = str;
            this.f55283f = kVar;
        }

        @Override // d.a.q0.c2.g.e.j
        public void a(d.a.q0.c2.f.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && this.f55278a.a()) {
                this.f55279b.add(bVar);
                if (this.f55279b.size() == this.f55280c.size()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f55279b);
                    Collections.sort(arrayList);
                    this.f55281d.f55237e = arrayList;
                    if (this.f55284g.j(this.f55282e + ((d.a.q0.c2.f.b) arrayList.get(0)).f55241h, this.f55282e)) {
                        this.f55284g.o(this.f55281d, this.f55283f);
                    } else {
                        onFail("face group:fail to create panel");
                    }
                }
            }
        }

        @Override // d.a.q0.c2.g.e.j
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.f55278a.a()) {
                this.f55278a.b(false);
                this.f55284g.s(this.f55283f, false);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f55285e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55286f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f55287g;

        public d(e eVar, FaceData faceData, String str, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, faceData, str, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55285e = faceData;
            this.f55286f = str;
            this.f55287g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap resizeBitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ImageFileInfo imageFileInfo = this.f55285e.imageFileInfo;
                String filePath = imageFileInfo.getFilePath();
                String substring = filePath.substring(filePath.lastIndexOf("/") + 1);
                if (TextUtils.isEmpty(substring)) {
                    substring = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis() + ".jpg";
                }
                String str = "t_" + substring;
                if (FileHelper.copyFile(filePath, this.f55286f + substring)) {
                    Bitmap b2 = d.a.q0.c2.g.b.b(imageFileInfo);
                    if (b2 == null) {
                        this.f55287g.onFail("face group: fail to get origin bitmap when install album emotion");
                        return;
                    }
                    if (!imageFileInfo.isGif() && (resizeBitmap = BitmapHelper.resizeBitmap(b2, 240, 240, false)) != null) {
                        d.a.q0.c2.b.e(this.f55286f, substring, resizeBitmap, 100);
                        if (resizeBitmap != b2) {
                            resizeBitmap.recycle();
                        }
                    }
                    Bitmap resizeBitmap2 = BitmapHelper.resizeBitmap(b2, 150, 150, false);
                    if (resizeBitmap2 == null) {
                        this.f55287g.onFail("face group: fail to create small file when install album emotion");
                        return;
                    }
                    d.a.q0.c2.b.e(this.f55286f, str, resizeBitmap2, 100);
                    if (resizeBitmap2 != b2) {
                        resizeBitmap2.recycle();
                    }
                    b2.recycle();
                    d.a.q0.c2.f.b bVar = new d.a.q0.c2.f.b();
                    FaceData faceData = this.f55285e;
                    bVar.f55238e = faceData.index;
                    bVar.f55239f = faceData.pid;
                    bVar.f55240g = substring;
                    bVar.f55241h = str;
                    bVar.j = faceData.width;
                    bVar.f55242i = faceData.height;
                    this.f55287g.a(bVar);
                    return;
                }
                this.f55287g.onFail("face group: fail to copy file when install album emotion");
            }
        }
    }

    /* renamed from: d.a.q0.c2.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1317e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f55288e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55289f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f55290g;

        public RunnableC1317e(e eVar, FaceData faceData, String str, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, faceData, str, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55288e = faceData;
            this.f55289f = str;
            this.f55290g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EmotionImageData emotionImageData = this.f55288e.emotionImageData;
                String str = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis();
                String str2 = "t_" + str;
                String o = u.o(this.f55288e.pid, true);
                String o2 = u.o(this.f55288e.pid, false);
                if (!FileHelper.copyFile(o, this.f55289f + str)) {
                    this.f55290g.onFail("face group: fail to copy big file when install collect emotion");
                    return;
                }
                if (!FileHelper.copyFile(o2, this.f55289f + str2)) {
                    this.f55290g.onFail("face group: fail to copy small file when install collect emotion");
                    return;
                }
                d.a.q0.c2.f.b bVar = new d.a.q0.c2.f.b();
                FaceData faceData = this.f55288e;
                bVar.f55238e = faceData.index;
                bVar.f55239f = faceData.pid;
                bVar.f55240g = str;
                bVar.f55241h = str2;
                bVar.j = faceData.width;
                bVar.f55242i = faceData.height;
                this.f55290g.a(bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f55291e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f55292f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f55293g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f55294h;

        public f(e eVar, FaceData faceData, j jVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, faceData, jVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55294h = eVar;
            this.f55291e = faceData;
            this.f55292f = jVar;
            this.f55293g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EmotionImageData emotionImageData = this.f55291e.emotionImageData;
                String substring = emotionImageData.getPicUrl().substring(emotionImageData.getPicUrl().lastIndexOf(IStringUtil.WINDOWS_FOLDER_SEPARATOR) + 1);
                String str = "t_" + substring;
                WebClient webClient = new WebClient();
                byte[] downloadImageBytes = webClient.downloadImageBytes(emotionImageData.getPicUrl(), false);
                if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                    this.f55294h.x(this.f55293g, substring, downloadImageBytes);
                    byte[] downloadImageBytes2 = webClient.downloadImageBytes(emotionImageData.getThumbUrl(), false);
                    if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                        this.f55294h.x(this.f55293g, str, downloadImageBytes2);
                        d.a.q0.c2.f.b bVar = new d.a.q0.c2.f.b();
                        FaceData faceData = this.f55291e;
                        bVar.f55238e = faceData.index;
                        bVar.f55239f = faceData.pid;
                        bVar.f55240g = substring;
                        bVar.f55241h = str;
                        bVar.j = faceData.width;
                        bVar.f55242i = faceData.height;
                        this.f55292f.a(bVar);
                        return;
                    }
                    this.f55292f.onFail("face group: fail to download small file when install search emotion");
                    return;
                }
                this.f55292f.onFail("face group: fail to download big file when install search emotion");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f55295e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f55296f;

        public g(e eVar, k kVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, kVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55295e = kVar;
            this.f55296f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k kVar = this.f55295e;
                if (kVar != null) {
                    if (this.f55296f) {
                        kVar.onSuccess();
                    } else {
                        kVar.onFail();
                    }
                }
                if (this.f55296f) {
                    d.a.q0.c2.d.m().w();
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("upload_result", new Boolean(true));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f55297e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55298f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f55299g;

        public h(e eVar, l lVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, lVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55299g = eVar;
            this.f55297e = lVar;
            this.f55298f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l lVar = this.f55297e;
                if (lVar != null) {
                    lVar.onFail(this.f55298f);
                }
                if (this.f55298f != null) {
                    BdLog.e("face group:" + this.f55298f);
                }
                this.f55299g.u(false, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f55300e;

        public i(e eVar, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55300e = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, this.f55300e));
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface j {
        void a(d.a.q0.c2.f.b bVar);

        void onFail(String str);
    }

    /* loaded from: classes8.dex */
    public interface k {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes8.dex */
    public interface l {
        void a(String str, List<FaceData> list);

        void onFail(String str);
    }

    /* loaded from: classes8.dex */
    public interface m {
        void a(ImageUploadResult imageUploadResult);
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55260a = new Handler(Looper.getMainLooper());
        this.f55261b = new LinkedBlockingQueue(4);
    }

    public static e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f55259e == null) {
                synchronized (e.class) {
                    if (f55259e == null) {
                        f55259e = new e();
                    }
                }
            }
            return f55259e;
        }
        return (e) invokeV.objValue;
    }

    public static String y(String str, Bitmap bitmap, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, str, bitmap, i2)) == null) {
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
                TiebaStatic.file(e2, d.a.d.e.p.k.join("FileHelper", ".", "saveFileToSDOrMemory", " ", file.getAbsolutePath()));
                return null;
            }
        }
        return (String) invokeLLI.objValue;
    }

    public void A(String str, List<FaceData> list, l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048576, this, str, list, lVar, i2) == null) {
            this.f55262c = true;
            w(str, list, i2);
            if (TextUtils.isEmpty(str)) {
                t(lVar, "name empty");
            } else if (list == null) {
                t(lVar, "list empty");
            } else {
                z(list);
                d.a.q0.c2.a.b().a(new a(this, list, lVar, str, i2));
            }
        }
    }

    public final void B(ImageFileInfo imageFileInfo, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, mVar) == null) {
            d.a.q0.c2.a.b().a(new b(this, imageFileInfo, mVar));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f55263d = null;
            d.a.q0.c2.g.c.a();
        }
    }

    public final boolean j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            Bitmap a2 = d.a.q0.c2.g.b.a(str);
            if (a2 == null) {
                BdLog.e("cover bitmap null");
                return false;
            } else if (TextUtils.isEmpty(d.a.q0.c2.b.e(str2, "panel.png", a2, 60))) {
                BdLog.e("fail to save Panel");
                return false;
            } else if (TextUtils.isEmpty(d.a.q0.c2.b.e(str2, "panel_momo.png", a2, 60))) {
                BdLog.e("fail to save PanelMomo");
                return false;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public FaceGroupDraft k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f55263d == null) {
                this.f55263d = d.a.q0.c2.g.c.b();
            }
            return this.f55263d;
        }
        return (FaceGroupDraft) invokeV.objValue;
    }

    public final void m(FaceData faceData, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, faceData, str, jVar) == null) {
            d.a.q0.c2.a.b().a(new d(this, faceData, str, jVar));
        }
    }

    public final void n(FaceData faceData, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, faceData, str, jVar) == null) {
            d.a.q0.c2.a.b().a(new RunnableC1317e(this, faceData, str, jVar));
        }
    }

    public final void o(d.a.q0.c2.f.a aVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, aVar, kVar) == null) {
            int f2 = d.a.q0.p0.a.c().f(aVar);
            if (f2 == 0) {
                BdLog.e("no valid emotion");
                s(kVar, false);
                return;
            }
            EmotionGroupData emotionGroupData = new EmotionGroupData();
            emotionGroupData.setGroupId(aVar.f55233a);
            emotionGroupData.setEmotionsCount(f2);
            emotionGroupData.setHeight(aVar.f55237e.get(0).f55242i);
            emotionGroupData.setWidth(aVar.f55237e.get(0).j);
            emotionGroupData.setDownloadTime(System.currentTimeMillis());
            emotionGroupData.setGroupName(aVar.f55234b);
            emotionGroupData.setStatus(1);
            d.a.q0.p0.g.k().e(emotionGroupData);
            d.a.q0.p0.g.k().f(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
            s(kVar, true);
        }
    }

    public void p(String str, List<FaceData> list, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, list, kVar) == null) {
            String str2 = d.a.q0.c2.c.f55204c + str + "/";
            new File(str2).mkdirs();
            d.a.q0.c2.f.a aVar = new d.a.q0.c2.f.a();
            TbadkCoreApplication.getCurrentAccount();
            TbadkCoreApplication.getCurrentAccountName();
            aVar.f55233a = str;
            String.valueOf(System.currentTimeMillis());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            d.a.q0.c2.g.a aVar2 = new d.a.q0.c2.g.a(Boolean.TRUE);
            c cVar = new c(this, aVar2, copyOnWriteArrayList, list, aVar, str2, kVar);
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
    }

    public final void q(FaceData faceData, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, faceData, str, jVar) == null) {
            d.a.q0.c2.a.b().a(new f(this, faceData, jVar, str));
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f55262c : invokeV.booleanValue;
    }

    public final void s(k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, kVar, z) == null) {
            this.f55260a.post(new g(this, kVar, z));
        }
    }

    public final void t(l lVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, lVar, str) == null) {
            this.f55260a.post(new h(this, lVar, str));
        }
    }

    public void u(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, str) == null) {
            if (this.f55262c) {
                this.f55262c = false;
            }
            if (z) {
                i();
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("upload_result", new Boolean(false));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("upload_msg", str);
                FaceGroupDraft faceGroupDraft = this.f55263d;
                if (faceGroupDraft != null) {
                    faceGroupDraft.setFailMsg(str);
                }
            }
            d.a.q0.c2.g.c.c(this.f55263d);
            this.f55260a.postDelayed(new i(this, hashMap), 1000L);
        }
    }

    public final void v(d.a.p0.c0.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.f55261b.offer(fVar);
        }
    }

    public void w(String str, List<FaceData> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048591, this, str, list, i2) == null) {
            FaceGroupDraft faceGroupDraft = new FaceGroupDraft();
            this.f55263d = faceGroupDraft;
            faceGroupDraft.setName(str);
            this.f55263d.setList(list);
            this.f55263d.setForumId(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String x(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048592, this, str, str2, bArr)) != null) {
            return (String) invokeLLL.objValue;
        }
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, list) == null) || list == null || list.isEmpty()) {
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
