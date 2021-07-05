package d.a.s0.c2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements d.a.r0.v.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.c2.e.b f57909a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f57910b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.c2.f.a f57911c;

        /* renamed from: d.a.s0.c2.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1346a extends BdAsyncTask<Void, Void, Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadData f57912a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f57913b;

            public C1346a(a aVar, DownloadData downloadData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, downloadData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57913b = aVar;
                this.f57912a = downloadData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                    FileHelper.deleteFileOrDir(new File(this.f57913b.f57910b));
                    if (b.g(this.f57912a.getPath(), this.f57913b.f57911c)) {
                        a aVar = this.f57913b;
                        return Boolean.valueOf(b.f(aVar.f57911c, aVar.f57910b));
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
                        a aVar = this.f57913b;
                        aVar.f57909a.onSuccess(aVar.f57910b);
                        return;
                    }
                    this.f57913b.f57909a.onFail("fail to download");
                }
            }
        }

        public a(d.a.s0.c2.e.b bVar, String str, d.a.s0.c2.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57909a = bVar;
            this.f57910b = str;
            this.f57911c = aVar;
        }

        @Override // d.a.r0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) || this.f57909a == null) {
                return;
            }
            String str2 = "faile to download:";
            if (downloadData != null && !TextUtils.isEmpty(downloadData.getUrl())) {
                str2 = "faile to download:" + downloadData.getUrl();
            }
            this.f57909a.onFail(str2);
        }

        @Override // d.a.r0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                new C1346a(this, downloadData).execute(new Void[0]);
            }
        }

        @Override // d.a.r0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // d.a.r0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            d.a.s0.c2.e.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || (bVar = this.f57909a) == null) {
                return;
            }
            bVar.onProgress(downloadData.getProcess());
        }

        @Override // d.a.r0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public static void c(d.a.s0.c2.f.a aVar, d.a.s0.c2.e.b bVar) {
        List<d.a.s0.c2.f.b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, aVar, bVar) == null) {
            if (aVar == null || (list = aVar.f57948e) == null || list.size() == 0 || TextUtils.isEmpty(aVar.f57947d)) {
                if (bVar != null) {
                    bVar.onFail("group data null");
                    return;
                }
                return;
            }
            a aVar2 = new a(bVar, c.f57915c + aVar.f57944a + "/", aVar);
            new File(c.f57915c).mkdirs();
            d(aVar, c.f57915c, aVar2);
        }
    }

    public static void d(d.a.s0.c2.f.a aVar, String str, d.a.r0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, aVar, str, cVar) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.f57947d)) {
                if (cVar != null) {
                    cVar.onFileDownloadFailed(null, 0, "data is null");
                    return;
                }
                return;
            }
            String str2 = aVar.f57944a + ".zip";
            DownloadData downloadData = new DownloadData(aVar.f57944a, str2, Uri.encode(aVar.f57947d, "-![.:/,%?&=]"), cVar);
            downloadData.setPath(str + str2);
            d.a.r0.v.d.j().k(downloadData);
        }
    }

    public static String e(String str, String str2, Bitmap bitmap, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65540, null, str, str2, bitmap, i2)) == null) {
            if (bitmap != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str + str2);
                try {
                    if ((!file.exists() || file.delete()) && file.createNewFile()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
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

    public static boolean f(d.a.s0.c2.f.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, str)) == null) {
            File file = new File(str + "panel.png");
            File file2 = new File(str + "panel_momo.png");
            if (file.exists() && file2.exists()) {
                return true;
            }
            if (new File(str + aVar.f57946c).exists()) {
                Bitmap bitmap = null;
                try {
                    bitmap = BitmapFactory.decodeFile(str + aVar.f57946c);
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
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

    public static boolean g(String str, d.a.s0.c2.f.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, aVar)) != null) {
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
                                String str2 = ".emotions/" + aVar.f57944a;
                                FileHelper.saveFile(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str2 + "/" + nextEntry.getName(), zipInputStream2);
                            }
                        } else {
                            zipInputStream2.close();
                            FileHelper.deleteFile(new File(str));
                            m.e(zipInputStream2);
                            return true;
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        m.e(zipInputStream);
                        return false;
                    } catch (IOException e3) {
                        e = e3;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        m.e(zipInputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream2;
                        m.e(zipInputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
        } catch (IOException e5) {
            e = e5;
        }
    }
}
