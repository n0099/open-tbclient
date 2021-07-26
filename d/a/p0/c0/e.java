package d.a.p0.c0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.q;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final String f52187h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.p0.c0.b f52188a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52189b;

    /* renamed from: c  reason: collision with root package name */
    public ImageFileInfo f52190c;

    /* renamed from: d  reason: collision with root package name */
    public d f52191d;

    /* renamed from: e  reason: collision with root package name */
    public d f52192e;

    /* renamed from: f  reason: collision with root package name */
    public d f52193f;

    /* renamed from: g  reason: collision with root package name */
    public d f52194g;

    /* loaded from: classes7.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f52195a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52195a = eVar;
        }

        @Override // d.a.p0.c0.d
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            String m;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                if (this.f52195a.f52188a == null) {
                    this.f52195a.f52188a = new d.a.p0.c0.b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                d.a.d.k.d.a c2 = this.f52195a.f52188a.c(imageFileInfo, true);
                if (c2 != null) {
                    m = this.f52195a.m(c2.p(), 5242880L, 100);
                } else {
                    Bitmap k = this.f52195a.k(imageFileInfo);
                    if (k == null) {
                        return null;
                    }
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0) {
                        k = BitmapHelper.rotateBitmapBydegree(k, readPictureDegree);
                    }
                    m = this.f52195a.m(k, 5242880L, 100);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
                return m;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f52196a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52196a = eVar;
        }

        @Override // d.a.p0.c0.d
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                return this.f52196a.g(imageFileInfo.getFilePath());
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f52197a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52197a = eVar;
        }

        @Override // d.a.p0.c0.d
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                return this.f52197a.m(this.f52197a.i(imageFileInfo.getFilePath()), 5242880L, 100);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1575502002, "Ld/a/p0/c0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1575502002, "Ld/a/p0/c0/e;");
                return;
            }
        }
        f52187h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/dynamicimgtmp";
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52189b = false;
        this.f52191d = new a(this);
        b bVar = new b(this);
        this.f52192e = bVar;
        this.f52193f = bVar;
        this.f52194g = new c(this);
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            long fileSize = FileHelper.getFileSize(str);
            int i2 = fileSize >= 31457280 ? 80 : fileSize >= DownloadManager.MIN_LEFT_SIZE ? 85 : fileSize >= 15728640 ? 90 : fileSize >= Config.FULL_TRACE_LOG_LIMIT ? 95 : 100;
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree == 0 && i2 == 100) {
                    return str;
                }
                Bitmap i3 = i(str);
                if (readPictureDegree != 0 && i3 != null) {
                    return m(BitmapHelper.rotateBitmapBydegree(i3, readPictureDegree), Config.FULL_TRACE_LOG_LIMIT, i2);
                }
                return m(i3, Config.FULL_TRACE_LOG_LIMIT, i2);
            } catch (Throwable unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String h(String str) {
        InterceptResult invokeL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return ".jpg";
            }
            try {
                substring = str.substring(str.lastIndexOf("."));
            } catch (Exception unused) {
            }
            return !TextUtils.isEmpty(substring) ? substring : ".jpg";
        }
        return (String) invokeL.objValue;
    }

    public final Bitmap i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            BitmapFactory.Options l = l(str);
            int i2 = l.outWidth;
            int i3 = l.outHeight;
            if (i2 != 0 && i3 != 0) {
                Bitmap loadBitmap = BitmapHelper.loadBitmap(str);
                if (loadBitmap != null && !loadBitmap.isRecycled()) {
                    return loadBitmap;
                }
                int i4 = 2;
                for (int i5 = 0; i5 < 3; i5++) {
                    l.inSampleSize = i4;
                    Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, l);
                    if (loadBitmap2 != null && !loadBitmap2.isRecycled()) {
                        return loadBitmap2;
                    }
                    i4 *= 2;
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public String j(WriteData writeData, ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLLZ;
        d dVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, writeData, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            this.f52190c = imageFileInfo;
            String filePath = imageFileInfo.getFilePath();
            boolean checkIsLongImage = FileHelper.checkIsLongImage(filePath);
            boolean checkIsHeifImage = FileHelper.checkIsHeifImage(filePath);
            if (imageFileInfo.isGif() || !(!z || imageFileInfo.hasActionsWithoutResize() || checkIsHeifImage)) {
                if (checkIsLongImage) {
                    dVar = this.f52193f;
                    str = "原始·长图";
                } else {
                    dVar = this.f52192e;
                    str = "原始·图";
                }
            } else if (checkIsLongImage) {
                dVar = this.f52194g;
                str = "正常·长图";
            } else {
                dVar = this.f52191d;
                str = "正常·图";
            }
            d.a.q0.h3.q0.d.r(writeData, imageFileInfo, filePath, FileHelper.getImageFileWH(filePath), FileHelper.getFileSize(filePath), checkIsLongImage, checkIsHeifImage, imageFileInfo.hasActionsWithoutResize(), str);
            String a2 = dVar.a(imageFileInfo);
            d.a.q0.h3.q0.d.i(writeData, imageFileInfo, a2, FileHelper.getImageFileWH(a2), FileHelper.getFileSize(a2));
            return a2;
        }
        return (String) invokeLLZ.objValue;
    }

    public final Bitmap k(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        d.a.d.e.l.e i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.f52188a == null) {
                this.f52188a = new d.a.p0.c0.b();
            }
            if (imageFileInfo.getImageType() == 0) {
                return this.f52188a.f(imageFileInfo, true);
            }
            if (imageFileInfo.getImageType() == 1 && (i2 = d.a.d.e.l.d.h().i(20)) != null) {
                try {
                    Object fromLocal = i2.getFromLocal(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), Boolean.FALSE, null);
                    if (fromLocal instanceof d.a.d.k.d.a) {
                        return ((d.a.d.k.d.a) fromLocal).p();
                    }
                } catch (OutOfMemoryError unused) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final BitmapFactory.Options l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return options;
        }
        return (BitmapFactory.Options) invokeL.objValue;
    }

    public final String m(Bitmap bitmap, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{bitmap, Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            if (this.f52189b) {
                ImageFileInfo imageFileInfo = this.f52190c;
                if (imageFileInfo == null || TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                    return "";
                }
                return FileHelper.compressBitmapToFile(f52187h, q.c(this.f52190c.toCachedKey(false)) + h(this.f52190c.getFilePath()), bitmap, (float) j, i2);
            }
            return FileHelper.compressBitmapToFile("img_upload_temp_file.temp", bitmap, (float) j, i2);
        }
        return (String) invokeCommon.objValue;
    }
}
