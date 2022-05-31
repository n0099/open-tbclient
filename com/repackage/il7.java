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
public class il7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements nz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ml7 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ nl7 c;

        /* renamed from: com.repackage.il7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0444a extends BdAsyncTask<Void, Void, Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadData a;
            public final /* synthetic */ a b;

            public C0444a(a aVar, DownloadData downloadData) {
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
                    if (il7.g(this.a.getPath(), this.b.c)) {
                        a aVar = this.b;
                        return Boolean.valueOf(il7.f(aVar.c, aVar.b));
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

        public a(ml7 ml7Var, String str, nl7 nl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml7Var, str, nl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ml7Var;
            this.b = str;
            this.c = nl7Var;
        }

        @Override // com.repackage.nz4
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
                hl7.a("【表情下载】 onFileDownloadFailed = " + str);
                if (this.a != null) {
                    String str2 = "faile to download:";
                    if (downloadData != null && !TextUtils.isEmpty(downloadData.getUrl())) {
                        str2 = "faile to download:" + downloadData.getUrl();
                    }
                    this.a.onFail(str2);
                }
            }
        }

        @Override // com.repackage.nz4
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                hl7.a("【表情下载】 onFileDownloadSucceed = " + this.b);
                new C0444a(this, downloadData).execute(new Void[0]);
            }
        }

        @Override // com.repackage.nz4
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.nz4
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
                ml7 ml7Var = this.a;
                if (ml7Var != null) {
                    ml7Var.onProgress(downloadData.getProcess());
                }
                hl7.a("【表情下载】 onFileUpdateProgress = " + downloadData.getProcess());
            }
        }

        @Override // com.repackage.nz4
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public static void c(nl7 nl7Var, ml7 ml7Var) {
        List<ol7> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, nl7Var, ml7Var) == null) {
            if (nl7Var != null && (list = nl7Var.e) != null && list.size() != 0 && !TextUtils.isEmpty(nl7Var.d)) {
                hl7.a("【表情下载】 url = " + nl7Var.d);
                a aVar = new a(ml7Var, jl7.c + nl7Var.a + "/", nl7Var);
                new File(jl7.c).mkdirs();
                d(nl7Var, jl7.c, aVar);
                return;
            }
            if (ml7Var != null) {
                ml7Var.onFail("group data null");
            }
            hl7.a("【表情下载】 fail = 参数异常");
        }
    }

    public static void d(nl7 nl7Var, String str, nz4 nz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, nl7Var, str, nz4Var) == null) {
            if (nl7Var == null || TextUtils.isEmpty(nl7Var.d)) {
                if (nz4Var != null) {
                    nz4Var.onFileDownloadFailed(null, 0, ADConfigError.REASON_NULL_DATA);
                    return;
                }
                return;
            }
            String str2 = nl7Var.a + ".zip";
            DownloadData downloadData = new DownloadData(nl7Var.a, str2, Uri.encode(nl7Var.d, "-![.:/,%?&=]"), nz4Var);
            downloadData.setPath(str + str2);
            oz4.k().l(downloadData);
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

    public static boolean f(nl7 nl7Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, nl7Var, str)) == null) {
            File file = new File(str + "panel.png");
            File file2 = new File(str + "panel_momo.png");
            if (file.exists() && file2.exists()) {
                hl7.a("【表情下载】 savePanelImage");
                return true;
            }
            if (new File(str + nl7Var.c).exists()) {
                Bitmap bitmap = null;
                try {
                    bitmap = BitmapFactory.decodeFile(str + nl7Var.c);
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                }
                if (bitmap == null) {
                    return false;
                }
                if (file.exists() || !TextUtils.isEmpty(e(str, "panel.png", bitmap, 60))) {
                    if (file2.exists() || !TextUtils.isEmpty(e(str, "panel_momo.png", bitmap, 60))) {
                        hl7.a("【表情下载】 savePanelImage = " + nl7Var.c);
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

    public static boolean g(String str, nl7 nl7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65542, null, str, nl7Var)) != null) {
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
                                String str2 = ".emotions/" + nl7Var.a;
                                String str3 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str2 + "/" + nextEntry.getName();
                                FileHelper.saveFileByStream(str3, zipInputStream2);
                                hl7.a("【表情下载】 unZipEmotion = " + str3);
                            }
                        } else {
                            zipInputStream2.close();
                            FileHelper.deleteFile(new File(str));
                            mi.e(zipInputStream2);
                            return true;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        mi.e(zipInputStream);
                        return false;
                    } catch (IOException e2) {
                        e = e2;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        mi.e(zipInputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream2;
                        mi.e(zipInputStream);
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
