package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipException;
/* loaded from: classes5.dex */
public class b86 implements a86 {
    public static /* synthetic */ Interceptable $ic;
    public static final String g;
    public transient /* synthetic */ FieldHolder $fh;
    public yz5 a;
    public HashMap<String, String> b;
    public List<DownloadData> c;
    public b d;
    public QmStickerItem e;
    public r05 f;

    /* loaded from: classes5.dex */
    public class a implements r05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b86 a;

        public a(b86 b86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b86Var;
        }

        @Override // com.repackage.r05
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.a.l(downloadData);
                if (this.a.d == null || this.a.e == null || this.a.e.fileUrl == null || !this.a.e.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.a.d.a(str);
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0089 */
        @Override // com.repackage.r05
        public void onFileDownloadSucceed(DownloadData downloadData) {
            File file;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath()) || StringUtils.isNull(b86.g)) {
                return;
            }
            this.a.l(downloadData);
            if (this.a.d == null || this.a.e == null || this.a.e.fileUrl == null || !this.a.e.fileUrl.equals(downloadData.getUrl()) || !downloadData.getPath().endsWith(".zip")) {
                return;
            }
            String substring = downloadData.getPath().substring(b86.g.length() + 1, downloadData.getPath().lastIndexOf("."));
            String str = b86.g + "/" + substring;
            try {
                try {
                    qt4.c(new File(downloadData.getPath()), str);
                    this.a.b.put(substring, str);
                    this.a.e.localPath = str;
                    this.a.d.c(this.a.e);
                    String path = downloadData.getPath();
                    file = new File(path);
                    downloadData = path;
                } catch (ZipException e) {
                    this.a.d.a("解压失败，请点击重试");
                    FileHelper.deleteFileOrDir(new File(str));
                    BdLog.e(e);
                    String path2 = downloadData.getPath();
                    file = new File(path2);
                    downloadData = path2;
                } catch (IOException e2) {
                    this.a.d.a("解压失败，请点击重试");
                    FileHelper.deleteFileOrDir(new File(str));
                    BdLog.e(e2);
                    String path3 = downloadData.getPath();
                    file = new File(path3);
                    downloadData = path3;
                }
                FileHelper.deleteFileOrDir(file);
            } catch (Throwable th) {
                FileHelper.deleteFileOrDir(new File(downloadData.getPath()));
                throw th;
            }
        }

        @Override // com.repackage.r05
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.r05
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.a.l(downloadData);
                if (this.a.d == null || this.a.e == null || this.a.e.fileUrl == null || !this.a.e.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.a.d.b();
            }
        }

        @Override // com.repackage.r05
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str);

        void b();

        void c(QmStickerItem qmStickerItem);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755873071, "Lcom/repackage/b86;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755873071, "Lcom/repackage/b86;");
                return;
            }
        }
        g = FileHelper.CreateFileIfNotFound(".stickers") != null ? FileHelper.CreateFileIfNotFound(".stickers").getAbsolutePath() : "";
    }

    public b86(yz5 yz5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yz5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new QmStickerItem();
        this.f = new a(this);
        this.a = yz5Var;
        j();
    }

    @Override // com.repackage.a86
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            if (this.b == null) {
                this.b = new HashMap<>();
                e();
            }
            return this.b.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.a86
    public boolean b(QmStickerItem qmStickerItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem)) == null) {
            m(qmStickerItem);
            if (qmStickerItem == null) {
                reset();
                return true;
            } else if (!StringUtils.isNull(qmStickerItem.localPath)) {
                yz5 yz5Var = this.a;
                if (yz5Var != null) {
                    return yz5Var.b(qmStickerItem);
                }
                return true;
            } else {
                reset();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.a86
    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.d = bVar;
        }
    }

    @Override // com.repackage.a86
    public void d(QmStickerItem qmStickerItem) {
        QmStickerItem qmStickerItem2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qmStickerItem) == null) {
            m(qmStickerItem);
            if (qmStickerItem == null) {
                return;
            }
            if (!TextUtils.isEmpty(qmStickerItem.fileUrl) && !StringUtils.isNull(g)) {
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(qmStickerItem.fileUrl);
                if (nameMd5FromUrl == null) {
                    return;
                }
                File file = new File(g);
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(".");
                String str2 = qmStickerItem.fileUrl;
                sb.append(str2.substring(str2.lastIndexOf(".") + 1));
                String sb2 = sb.toString();
                if (this.c == null) {
                    this.c = new ArrayList();
                }
                if (k(qmStickerItem.fileUrl)) {
                    return;
                }
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(qmStickerItem.fileUrl);
                downloadData.setPath(g + "/" + nameMd5FromUrl + sb2);
                downloadData.setCallback(this.f);
                this.c.add(downloadData);
                s05.k().l(downloadData);
                return;
            }
            b(null);
            if (this.d == null || (qmStickerItem2 = this.e) == null || (str = qmStickerItem2.fileUrl) == null || !str.equals(qmStickerItem.fileUrl)) {
                return;
            }
            this.d.b();
        }
    }

    @Override // com.repackage.a86
    public void e() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || StringUtils.isNull(g)) {
            return;
        }
        HashMap<String, String> hashMap = this.b;
        if (hashMap == null) {
            this.b = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(g);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    this.b.put(file2.getName(), file2.getAbsolutePath());
                }
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (!ListUtils.isEmpty(this.c) && str != null) {
                for (DownloadData downloadData : this.c) {
                    if (downloadData != null && str.equals(downloadData.getUrl())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void l(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadData) == null) || ListUtils.isEmpty(this.c) || downloadData == null) {
            return;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 < this.c.size()) {
                if (this.c.get(i2) != null && this.c.get(i2).getUrl() != null && this.c.get(i2).getUrl().equals(downloadData.getUrl())) {
                    i = i2;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        this.c.remove(i);
    }

    public void m(QmStickerItem qmStickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmStickerItem) == null) {
            if (qmStickerItem == null) {
                this.e = new QmStickerItem();
            } else {
                this.e = qmStickerItem;
            }
        }
    }

    @Override // com.repackage.a86
    public void reset() {
        yz5 yz5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (yz5Var = this.a) == null) {
            return;
        }
        yz5Var.b(null);
    }
}
