package d.a.s0.p0;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f64483a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f64484b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f64485c;

        public a(o oVar, AtomicInteger atomicInteger, List list, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, atomicInteger, list, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64483a = atomicInteger;
            this.f64484b = list;
            this.f64485c = cVar;
        }

        @Override // d.a.s0.p0.o.d
        public void a(ImageUploadResult imageUploadResult) {
            ImageUploadResult.picInfo picinfo;
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imageUploadResult) == null) {
                this.f64483a.decrementAndGet();
                if (imageUploadResult != null && (picinfo = imageUploadResult.picInfo) != null && (picDetailedInfo = picinfo.bigPic) != null && !TextUtils.isEmpty(picDetailedInfo.picUrl)) {
                    this.f64484b.add(imageUploadResult.picInfo.bigPic.picUrl);
                }
                if (this.f64483a.get() == 0) {
                    if (!ListUtils.isEmpty(this.f64484b)) {
                        this.f64485c.c(this.f64484b);
                    } else {
                        this.f64485c.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageFileInfo f64486e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f64487f;

        public b(o oVar, ImageFileInfo imageFileInfo, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, imageFileInfo, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64486e = imageFileInfo;
            this.f64487f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String filePath = this.f64486e.getFilePath();
                d.a.r0.b0.f fVar = new d.a.r0.b0.f("from_user_collect");
                if (this.f64486e.isGif()) {
                    this.f64487f.a(fVar.k(filePath, true, false));
                    return;
                }
                Bitmap b2 = d.a.s0.c2.g.b.b(this.f64486e);
                if (b2 == null) {
                    this.f64487f.a(null);
                    return;
                }
                String saveFile = FileHelper.saveFile(TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath(), "face_" + Math.abs(filePath.hashCode()), b2, 60);
                b2.recycle();
                if (TextUtils.isEmpty(saveFile)) {
                    this.f64487f.a(null);
                    return;
                }
                ImageUploadResult k = fVar.k(saveFile, false, false);
                FileHelper.deleteFile(new File(saveFile));
                this.f64487f.a(k);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void c(List<String> list);

        void d();
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a(ImageUploadResult imageUploadResult);
    }

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(ArrayList<ImageFileInfo> arrayList, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, arrayList, cVar) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(arrayList.size());
        ArrayList arrayList2 = new ArrayList();
        Iterator<ImageFileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            b(it.next(), new a(this, atomicInteger, arrayList2, cVar));
        }
    }

    public final void b(ImageFileInfo imageFileInfo, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, dVar) == null) {
            d.a.s0.c2.a.b().a(new b(this, imageFileInfo, dVar));
        }
    }
}
