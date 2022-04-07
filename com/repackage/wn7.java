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
/* loaded from: classes7.dex */
public class wn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements e05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ao7 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ bo7 c;

        /* renamed from: com.repackage.wn7$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0542a extends BdAsyncTask<Void, Void, Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadData a;
            public final /* synthetic */ a b;

            public C0542a(a aVar, DownloadData downloadData) {
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
                    if (wn7.g(this.a.getPath(), this.b.c)) {
                        a aVar = this.b;
                        return Boolean.valueOf(wn7.f(aVar.c, aVar.b));
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

        public a(ao7 ao7Var, String str, bo7 bo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ao7Var, str, bo7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ao7Var;
            this.b = str;
            this.c = bo7Var;
        }

        @Override // com.repackage.e05
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) || this.a == null) {
                return;
            }
            String str2 = "faile to download:";
            if (downloadData != null && !TextUtils.isEmpty(downloadData.getUrl())) {
                str2 = "faile to download:" + downloadData.getUrl();
            }
            this.a.onFail(str2);
        }

        @Override // com.repackage.e05
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                new C0542a(this, downloadData).execute(new Void[0]);
            }
        }

        @Override // com.repackage.e05
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.e05
        public void onFileUpdateProgress(DownloadData downloadData) {
            ao7 ao7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || (ao7Var = this.a) == null) {
                return;
            }
            ao7Var.onProgress(downloadData.getProcess());
        }

        @Override // com.repackage.e05
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public static void c(bo7 bo7Var, ao7 ao7Var) {
        List<co7> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bo7Var, ao7Var) == null) {
            if (bo7Var == null || (list = bo7Var.e) == null || list.size() == 0 || TextUtils.isEmpty(bo7Var.d)) {
                if (ao7Var != null) {
                    ao7Var.onFail("group data null");
                    return;
                }
                return;
            }
            a aVar = new a(ao7Var, xn7.c + bo7Var.a + "/", bo7Var);
            new File(xn7.c).mkdirs();
            d(bo7Var, xn7.c, aVar);
        }
    }

    public static void d(bo7 bo7Var, String str, e05 e05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, bo7Var, str, e05Var) == null) {
            if (bo7Var == null || TextUtils.isEmpty(bo7Var.d)) {
                if (e05Var != null) {
                    e05Var.onFileDownloadFailed(null, 0, ADConfigError.REASON_NULL_DATA);
                    return;
                }
                return;
            }
            String str2 = bo7Var.a + ".zip";
            DownloadData downloadData = new DownloadData(bo7Var.a, str2, Uri.encode(bo7Var.d, "-![.:/,%?&=]"), e05Var);
            downloadData.setPath(str + str2);
            f05.k().l(downloadData);
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

    public static boolean f(bo7 bo7Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bo7Var, str)) == null) {
            File file = new File(str + "panel.png");
            File file2 = new File(str + "panel_momo.png");
            if (file.exists() && file2.exists()) {
                return true;
            }
            if (new File(str + bo7Var.c).exists()) {
                Bitmap bitmap = null;
                try {
                    bitmap = BitmapFactory.decodeFile(str + bo7Var.c);
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                }
                if (bitmap == null) {
                    return false;
                }
                if (file.exists() || !TextUtils.isEmpty(e(str, "panel.png", bitmap, 60))) {
                    return file2.exists() || !TextUtils.isEmpty(e(str, "panel_momo.png", bitmap, 60));
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(String str, bo7 bo7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65542, null, str, bo7Var)) != null) {
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
                                String str2 = ".emotions/" + bo7Var.a;
                                FileHelper.saveFileByStream(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str2 + "/" + nextEntry.getName(), zipInputStream2);
                            }
                        } else {
                            zipInputStream2.close();
                            FileHelper.deleteFile(new File(str));
                            pi.e(zipInputStream2);
                            return true;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        pi.e(zipInputStream);
                        return false;
                    } catch (IOException e2) {
                        e = e2;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        pi.e(zipInputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream2;
                        pi.e(zipInputStream);
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
