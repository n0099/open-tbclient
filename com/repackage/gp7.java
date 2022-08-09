package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes6.dex */
public class gp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements c25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kp7 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lp7 c;

        /* renamed from: com.repackage.gp7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0483a extends BdAsyncTask<Void, Void, Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadData a;
            public final /* synthetic */ a b;

            public C0483a(a aVar, DownloadData downloadData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, downloadData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = downloadData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                    FileHelper.deleteFileOrDir(new File(this.b.b));
                    if (gp7.g(this.a.getPath(), this.b.c)) {
                        a aVar = this.b;
                        return Boolean.valueOf(gp7.f(aVar.c, aVar.b));
                    }
                    return Boolean.FALSE;
                }
                return (Boolean) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                    if (bool.booleanValue()) {
                        a aVar = this.b;
                        aVar.a.onSuccess(aVar.b);
                        return;
                    }
                    this.b.a.onFail("fail to download");
                }
            }
        }

        public a(kp7 kp7Var, String str, lp7 lp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp7Var, str, lp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kp7Var;
            this.b = str;
            this.c = lp7Var;
        }

        @Override // com.repackage.c25
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
                fp7.a("【表情下载】 onFileDownloadFailed = " + str);
                if (this.a != null) {
                    String str2 = "faile to download:";
                    if (downloadData != null && !TextUtils.isEmpty(downloadData.getUrl())) {
                        str2 = "faile to download:" + downloadData.getUrl();
                    }
                    this.a.onFail(str2);
                }
            }
        }

        @Override // com.repackage.c25
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                fp7.a("【表情下载】 onFileDownloadSucceed = " + this.b);
                new C0483a(this, downloadData).execute(new Void[0]);
            }
        }

        @Override // com.repackage.c25
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.c25
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
                kp7 kp7Var = this.a;
                if (kp7Var != null) {
                    kp7Var.onProgress(downloadData.getProcess());
                }
                fp7.a("【表情下载】 onFileUpdateProgress = " + downloadData.getProcess());
            }
        }

        @Override // com.repackage.c25
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public static void c(lp7 lp7Var, kp7 kp7Var) {
        List<mp7> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, lp7Var, kp7Var) == null) {
            if (lp7Var != null && (list = lp7Var.e) != null && list.size() != 0 && !TextUtils.isEmpty(lp7Var.d)) {
                fp7.a("【表情下载】 url = " + lp7Var.d);
                a aVar = new a(kp7Var, hp7.c + lp7Var.a + "/", lp7Var);
                new File(hp7.c).mkdirs();
                d(lp7Var, hp7.c, aVar);
                return;
            }
            if (kp7Var != null) {
                kp7Var.onFail("group data null");
            }
            fp7.a("【表情下载】 fail = 参数异常");
        }
    }

    public static void d(lp7 lp7Var, String str, c25 c25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, lp7Var, str, c25Var) == null) {
            if (lp7Var == null || TextUtils.isEmpty(lp7Var.d)) {
                if (c25Var != null) {
                    c25Var.onFileDownloadFailed(null, 0, ADConfigError.REASON_NULL_DATA);
                    return;
                }
                return;
            }
            String str2 = lp7Var.a + ".zip";
            DownloadData downloadData = new DownloadData(lp7Var.a, str2, Uri.encode(lp7Var.d, "-![.:/,%?&=]"), c25Var);
            downloadData.setPath(str + str2);
            d25.k().l(downloadData);
        }
    }

    public static String e(String str, String str2, Bitmap bitmap, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, bitmap, i)) == null) {
            if (bitmap != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str + str2);
                try {
                    if ((!file.exists() || file.delete()) && file.createNewFile()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, i, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file.getPath();
                    }
                    return null;
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeLLLI.objValue;
    }

    public static boolean f(lp7 lp7Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, lp7Var, str)) == null) {
            File file = new File(str + "panel.png");
            File file2 = new File(str + "panel_momo.png");
            if (file.exists() && file2.exists()) {
                fp7.a("【表情下载】 savePanelImage");
                return true;
            }
            if (new File(str + lp7Var.c).exists()) {
                Bitmap bitmap = null;
                try {
                    bitmap = BitmapFactory.decodeFile(str + lp7Var.c);
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                }
                if (bitmap == null) {
                    return false;
                }
                if (file.exists() || !TextUtils.isEmpty(e(str, "panel.png", bitmap, 60))) {
                    if (file2.exists() || !TextUtils.isEmpty(e(str, "panel_momo.png", bitmap, 60))) {
                        fp7.a("【表情下载】 savePanelImage = " + lp7Var.c);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(String str, lp7 lp7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65542, null, str, lp7Var)) != null) {
            return invokeLL.booleanValue;
        }
        ZipInputStream zipInputStream = null;
        try {
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry != null) {
                            if (!nextEntry.isDirectory()) {
                                String str2 = ".emotions/" + lp7Var.a;
                                String str3 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str2 + "/" + nextEntry.getName();
                                FileHelper.saveFileByStream(str3, zipInputStream2);
                                fp7.a("【表情下载】 unZipEmotion = " + str3);
                            }
                        } else {
                            zipInputStream2.close();
                            FileHelper.deleteFile(new File(str));
                            ri.e(zipInputStream2);
                            return true;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        ri.e(zipInputStream);
                        return false;
                    } catch (IOException e2) {
                        e = e2;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        ri.e(zipInputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream2;
                        ri.e(zipInputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
    }
}
