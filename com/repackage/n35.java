package com.repackage;

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
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class n35 {
    public static /* synthetic */ Interceptable $ic;
    public static final String h;
    public transient /* synthetic */ FieldHolder $fh;
    public k35 a;
    public boolean b;
    public ImageFileInfo c;
    public m35 d;
    public m35 e;
    public m35 f;
    public m35 g;

    /* loaded from: classes6.dex */
    public class a implements m35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n35 a;

        public a(n35 n35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n35Var;
        }

        @Override // com.repackage.m35
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            String m;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                if (this.a.a == null) {
                    this.a.a = new k35();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                fo c = this.a.a.c(imageFileInfo, true);
                if (c != null) {
                    m = this.a.m(c.p(), 5242880L, 100);
                } else {
                    Bitmap k = this.a.k(imageFileInfo);
                    if (k == null) {
                        return null;
                    }
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0) {
                        k = BitmapHelper.rotateBitmapBydegree(k, readPictureDegree);
                    }
                    m = this.a.m(k, 5242880L, 100);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
                return m;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements m35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n35 a;

        public b(n35 n35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n35Var;
        }

        @Override // com.repackage.m35
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                return this.a.g(imageFileInfo.getFilePath());
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements m35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n35 a;

        public c(n35 n35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n35Var;
        }

        @Override // com.repackage.m35
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                return this.a.m(this.a.i(imageFileInfo.getFilePath()), 5242880L, 100);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755520415, "Lcom/repackage/n35;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755520415, "Lcom/repackage/n35;");
                return;
            }
        }
        h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/dynamicimgtmp";
    }

    public n35() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.d = new a(this);
        b bVar = new b(this);
        this.e = bVar;
        this.f = bVar;
        this.g = new c(this);
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            long fileSize = FileHelper.getFileSize(str);
            int i = fileSize >= 31457280 ? 80 : fileSize >= DownloadManager.MIN_LEFT_SIZE ? 85 : fileSize >= 15728640 ? 90 : fileSize >= Config.FULL_TRACE_LOG_LIMIT ? 95 : 100;
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree == 0 && i == 100) {
                    return str;
                }
                Bitmap i2 = i(str);
                if (readPictureDegree != 0 && i2 != null) {
                    return m(BitmapHelper.rotateBitmapBydegree(i2, readPictureDegree), Config.FULL_TRACE_LOG_LIMIT, i);
                }
                return m(i2, Config.FULL_TRACE_LOG_LIMIT, i);
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
            int i = l.outWidth;
            int i2 = l.outHeight;
            if (i != 0 && i2 != 0) {
                Bitmap loadBitmap = BitmapHelper.loadBitmap(str);
                if (loadBitmap != null && !loadBitmap.isRecycled()) {
                    return loadBitmap;
                }
                int i3 = 2;
                for (int i4 = 0; i4 < 3; i4++) {
                    l.inSampleSize = i3;
                    Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, l);
                    if (loadBitmap2 != null && !loadBitmap2.isRecycled()) {
                        return loadBitmap2;
                    }
                    i3 *= 2;
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public String j(WriteData writeData, ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLLZ;
        m35 m35Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, writeData, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            this.c = imageFileInfo;
            String filePath = imageFileInfo.getFilePath();
            boolean checkIsLongImage = FileHelper.checkIsLongImage(filePath);
            boolean checkIsHeifImage = FileHelper.checkIsHeifImage(filePath);
            if (imageFileInfo.isGif() || !(!z || imageFileInfo.hasActionsWithoutResize() || checkIsHeifImage)) {
                if (checkIsLongImage) {
                    m35Var = this.f;
                    str = "原始·长图";
                } else {
                    m35Var = this.e;
                    str = "原始·图";
                }
            } else if (checkIsLongImage) {
                m35Var = this.g;
                str = "正常·长图";
            } else {
                m35Var = this.d;
                str = "正常·图";
            }
            xm8.s(writeData, imageFileInfo, filePath, FileHelper.getImageFileWH(filePath), FileHelper.getFileSize(filePath), checkIsLongImage, checkIsHeifImage, imageFileInfo.hasActionsWithoutResize(), str);
            String a2 = m35Var.a(imageFileInfo);
            xm8.j(writeData, imageFileInfo, a2, FileHelper.getImageFileWH(a2), FileHelper.getFileSize(a2));
            return a2;
        }
        return (String) invokeLLZ.objValue;
    }

    public final Bitmap k(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        jg i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.a == null) {
                this.a = new k35();
            }
            if (imageFileInfo.getImageType() == 0) {
                return this.a.f(imageFileInfo, true);
            }
            if (imageFileInfo.getImageType() == 1 && (i = ig.h().i(20)) != null) {
                try {
                    Object fromLocal = i.getFromLocal(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), Boolean.FALSE, null);
                    if (fromLocal instanceof fo) {
                        return ((fo) fromLocal).p();
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

    public final String m(Bitmap bitmap, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{bitmap, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (this.b) {
                ImageFileInfo imageFileInfo = this.c;
                if (imageFileInfo == null || TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                    return "";
                }
                return FileHelper.compressBitmapToFile(h, ui.c(this.c.toCachedKey(false)) + h(this.c.getFilePath()), bitmap, (float) j, i);
            }
            ImageFileInfo imageFileInfo2 = this.c;
            return FileHelper.compressBitmapToFile((imageFileInfo2 == null || TextUtils.isEmpty(imageFileInfo2.getTempUploadFileName())) ? "img_upload_temp_file.temp" : this.c.getTempUploadFileName(), bitmap, (float) j, i);
        }
        return (String) invokeCommon.objValue;
    }
}
