package d.a.r0.b0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.q;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final String f54834h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.r0.b0.b f54835a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f54836b;

    /* renamed from: c  reason: collision with root package name */
    public ImageFileInfo f54837c;

    /* renamed from: d  reason: collision with root package name */
    public d f54838d;

    /* renamed from: e  reason: collision with root package name */
    public d f54839e;

    /* renamed from: f  reason: collision with root package name */
    public d f54840f;

    /* renamed from: g  reason: collision with root package name */
    public d f54841g;

    /* loaded from: classes9.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f54842a;

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
            this.f54842a = eVar;
        }

        @Override // d.a.r0.b0.d
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            String n;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                if (this.f54842a.f54835a == null) {
                    this.f54842a.f54835a = new d.a.r0.b0.b();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                d.a.c.k.d.a c2 = this.f54842a.f54835a.c(imageFileInfo, true);
                if (c2 != null) {
                    n = this.f54842a.n(c2.p(), 5242880L, 100);
                } else {
                    Bitmap l = this.f54842a.l(imageFileInfo);
                    if (l == null) {
                        return null;
                    }
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0) {
                        l = BitmapHelper.rotateBitmapBydegree(l, readPictureDegree);
                    }
                    n = this.f54842a.n(l, 5242880L, 100);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
                return n;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f54843a;

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
            this.f54843a = eVar;
        }

        @Override // d.a.r0.b0.d
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                return this.f54843a.g(imageFileInfo.getFilePath());
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f54844a;

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
            this.f54844a = eVar;
        }

        @Override // d.a.r0.b0.d
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                return this.f54844a.n(this.f54844a.i(imageFileInfo.getFilePath()), 5242880L, 100);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1909195147, "Ld/a/r0/b0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1909195147, "Ld/a/r0/b0/e;");
                return;
            }
        }
        f54834h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/dynamicimgtmp";
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
        this.f54836b = false;
        this.f54838d = new a(this);
        b bVar = new b(this);
        this.f54839e = bVar;
        this.f54840f = bVar;
        this.f54841g = new c(this);
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (BdBaseApplication.getInst() == null) {
                return false;
            }
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
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
                    return n(BitmapHelper.rotateBitmapBydegree(i3, readPictureDegree), Config.FULL_TRACE_LOG_LIMIT, i2);
                }
                return n(i3, Config.FULL_TRACE_LOG_LIMIT, i2);
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
            BitmapFactory.Options m = m(str);
            int i2 = m.outWidth;
            int i3 = m.outHeight;
            if (i2 != 0 && i3 != 0) {
                Bitmap loadBitmap = BitmapHelper.loadBitmap(str);
                if (loadBitmap != null && !loadBitmap.isRecycled()) {
                    return loadBitmap;
                }
                int i4 = 2;
                for (int i5 = 0; i5 < 3; i5++) {
                    m.inSampleSize = i4;
                    Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, m);
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

    public String j(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        d dVar;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            this.f54837c = imageFileInfo;
            String filePath = imageFileInfo.getFilePath();
            boolean checkIsLongImage = FileHelper.checkIsLongImage(filePath);
            boolean checkIsHeifImage = FileHelper.checkIsHeifImage(filePath);
            if (imageFileInfo.isGif() || !(!z || imageFileInfo.hasActionsWithoutResize() || checkIsHeifImage)) {
                if (checkIsLongImage) {
                    dVar = this.f54840f;
                    str = "原始·长图";
                } else {
                    dVar = this.f54839e;
                    str = "原始·图";
                }
            } else if (checkIsLongImage) {
                dVar = this.f54841g;
                str = "正常·长图";
            } else {
                dVar = this.f54838d;
                str = "正常·图";
            }
            if (k()) {
                int[] imageFileWH = FileHelper.getImageFileWH(filePath);
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(filePath);
                sb.append("\n   w =");
                sb.append(imageFileWH[0]);
                sb.append(" h =");
                sb.append(imageFileWH[1]);
                sb.append("  size =");
                str2 = "\n   w =";
                sb.append(((float) FileHelper.getFileSize(filePath)) / 1048576.0f);
                sb.append("MB");
                sb.append("\n   isLongImage =");
                sb.append(checkIsLongImage);
                sb.append("  isHeifImage =");
                sb.append(checkIsHeifImage);
                sb.append(" resize =");
                sb.append(imageFileInfo.hasActionsWithoutResize());
                sb.append(" uploadStrategy =");
                sb.append(str);
                Log.d("UPLOAD_IMG", sb.toString());
            } else {
                str2 = "\n   w =";
            }
            String a2 = dVar.a(imageFileInfo);
            if (k()) {
                int[] imageFileWH2 = FileHelper.getImageFileWH(a2);
                Log.d("UPLOAD_IMG", "temp =" + a2 + str2 + imageFileWH2[0] + " h =" + imageFileWH2[1] + "  size =" + (((float) FileHelper.getFileSize(a2)) / 1048576.0f) + "MB");
            }
            return a2;
        }
        return (String) invokeLZ.objValue;
    }

    public final Bitmap l(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        d.a.c.e.l.e i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.f54835a == null) {
                this.f54835a = new d.a.r0.b0.b();
            }
            if (imageFileInfo.getImageType() == 0) {
                return this.f54835a.f(imageFileInfo, true);
            }
            if (imageFileInfo.getImageType() == 1 && (i2 = d.a.c.e.l.d.h().i(20)) != null) {
                try {
                    Object fromLocal = i2.getFromLocal(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), Boolean.FALSE, null);
                    if (fromLocal instanceof d.a.c.k.d.a) {
                        return ((d.a.c.k.d.a) fromLocal).p();
                    }
                } catch (OutOfMemoryError unused) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final BitmapFactory.Options m(String str) {
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

    public final String n(Bitmap bitmap, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{bitmap, Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            if (this.f54836b) {
                ImageFileInfo imageFileInfo = this.f54837c;
                if (imageFileInfo == null || TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                    return "";
                }
                return FileHelper.compressBitmapToFile(f54834h, q.c(this.f54837c.toCachedKey(false)) + h(this.f54837c.getFilePath()), bitmap, (float) j, i2);
            }
            return FileHelper.compressBitmapToFile("img_upload_temp_file.temp", bitmap, (float) j, i2);
        }
        return (String) invokeCommon.objValue;
    }
}
