package d.a.q0.n0.d;

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
import d.a.p0.s.y.r;
import d.a.p0.w.e;
import d.a.p0.w.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipException;
/* loaded from: classes8.dex */
public class b implements d.a.q0.n0.d.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final String f61105g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.f0.c.a f61106a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f61107b;

    /* renamed from: c  reason: collision with root package name */
    public List<DownloadData> f61108c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC1563b f61109d;

    /* renamed from: e  reason: collision with root package name */
    public QmStickerItem f61110e;

    /* renamed from: f  reason: collision with root package name */
    public e f61111f;

    /* loaded from: classes8.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f61112a;

        public a(b bVar) {
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
            this.f61112a = bVar;
        }

        @Override // d.a.p0.w.e
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.f61112a.l(downloadData);
                if (this.f61112a.f61109d == null || this.f61112a.f61110e == null || this.f61112a.f61110e.fileUrl == null || !this.f61112a.f61110e.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.f61112a.f61109d.a(str);
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x008a */
        @Override // d.a.p0.w.e
        public void onFileDownloadSucceed(DownloadData downloadData) {
            File file;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath()) || StringUtils.isNull(b.f61105g)) {
                return;
            }
            this.f61112a.l(downloadData);
            if (this.f61112a.f61109d == null || this.f61112a.f61110e == null || this.f61112a.f61110e.fileUrl == null || !this.f61112a.f61110e.fileUrl.equals(downloadData.getUrl()) || !downloadData.getPath().endsWith(".zip")) {
                return;
            }
            String substring = downloadData.getPath().substring(b.f61105g.length() + 1, downloadData.getPath().lastIndexOf("."));
            String str = b.f61105g + "/" + substring;
            try {
                try {
                    try {
                        r.c(new File(downloadData.getPath()), str);
                        this.f61112a.f61107b.put(substring, str);
                        this.f61112a.f61110e.localPath = str;
                        this.f61112a.f61109d.c(this.f61112a.f61110e);
                        String path = downloadData.getPath();
                        file = new File(path);
                        downloadData = path;
                    } catch (ZipException e2) {
                        this.f61112a.f61109d.a("解压失败，请点击重试");
                        FileHelper.deleteFileOrDir(new File(str));
                        BdLog.e(e2);
                        String path2 = downloadData.getPath();
                        file = new File(path2);
                        downloadData = path2;
                    }
                } catch (IOException e3) {
                    this.f61112a.f61109d.a("解压失败，请点击重试");
                    FileHelper.deleteFileOrDir(new File(str));
                    BdLog.e(e3);
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

        @Override // d.a.p0.w.e
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // d.a.p0.w.e
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.f61112a.l(downloadData);
                if (this.f61112a.f61109d == null || this.f61112a.f61110e == null || this.f61112a.f61110e.fileUrl == null || !this.f61112a.f61110e.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.f61112a.f61109d.b();
            }
        }

        @Override // d.a.p0.w.e
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: d.a.q0.n0.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1563b {
        void a(String str);

        void b();

        void c(QmStickerItem qmStickerItem);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1252881562, "Ld/a/q0/n0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1252881562, "Ld/a/q0/n0/d/b;");
                return;
            }
        }
        f61105g = FileHelper.CreateFileIfNotFound(".stickers") != null ? FileHelper.CreateFileIfNotFound(".stickers").getAbsolutePath() : "";
    }

    public b(d.a.q0.f0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61110e = new QmStickerItem();
        this.f61111f = new a(this);
        this.f61106a = aVar;
        j();
    }

    @Override // d.a.q0.n0.d.a
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            if (this.f61107b == null) {
                this.f61107b = new HashMap<>();
                e();
            }
            return this.f61107b.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.q0.n0.d.a
    public boolean b(QmStickerItem qmStickerItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem)) == null) {
            m(qmStickerItem);
            if (qmStickerItem == null) {
                reset();
                return true;
            } else if (!StringUtils.isNull(qmStickerItem.localPath)) {
                d.a.q0.f0.c.a aVar = this.f61106a;
                if (aVar != null) {
                    return aVar.b(qmStickerItem);
                }
                return true;
            } else {
                reset();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.n0.d.a
    public void c(InterfaceC1563b interfaceC1563b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1563b) == null) {
            this.f61109d = interfaceC1563b;
        }
    }

    @Override // d.a.q0.n0.d.a
    public void d(QmStickerItem qmStickerItem) {
        QmStickerItem qmStickerItem2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qmStickerItem) == null) {
            m(qmStickerItem);
            if (qmStickerItem == null) {
                return;
            }
            if (!TextUtils.isEmpty(qmStickerItem.fileUrl) && !StringUtils.isNull(f61105g)) {
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(qmStickerItem.fileUrl);
                if (nameMd5FromUrl == null) {
                    return;
                }
                File file = new File(f61105g);
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(".");
                String str2 = qmStickerItem.fileUrl;
                sb.append(str2.substring(str2.lastIndexOf(".") + 1));
                String sb2 = sb.toString();
                if (this.f61108c == null) {
                    this.f61108c = new ArrayList();
                }
                if (k(qmStickerItem.fileUrl)) {
                    return;
                }
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(qmStickerItem.fileUrl);
                downloadData.setPath(f61105g + "/" + nameMd5FromUrl + sb2);
                downloadData.setCallback(this.f61111f);
                this.f61108c.add(downloadData);
                f.j().k(downloadData);
                return;
            }
            b(null);
            if (this.f61109d == null || (qmStickerItem2 = this.f61110e) == null || (str = qmStickerItem2.fileUrl) == null || !str.equals(qmStickerItem.fileUrl)) {
                return;
            }
            this.f61109d.b();
        }
    }

    @Override // d.a.q0.n0.d.a
    public void e() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || StringUtils.isNull(f61105g)) {
            return;
        }
        HashMap<String, String> hashMap = this.f61107b;
        if (hashMap == null) {
            this.f61107b = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(f61105g);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    this.f61107b.put(file2.getName(), file2.getAbsolutePath());
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
            if (!ListUtils.isEmpty(this.f61108c) && str != null) {
                for (DownloadData downloadData : this.f61108c) {
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadData) == null) || ListUtils.isEmpty(this.f61108c) || downloadData == null) {
            return;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 < this.f61108c.size()) {
                if (this.f61108c.get(i3) != null && this.f61108c.get(i3).getUrl() != null && this.f61108c.get(i3).getUrl().equals(downloadData.getUrl())) {
                    i2 = i3;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        this.f61108c.remove(i2);
    }

    public void m(QmStickerItem qmStickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmStickerItem) == null) {
            if (qmStickerItem == null) {
                this.f61110e = new QmStickerItem();
            } else {
                this.f61110e = qmStickerItem;
            }
        }
    }

    @Override // d.a.q0.n0.d.a
    public void reset() {
        d.a.q0.f0.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.f61106a) == null) {
            return;
        }
        aVar.b(null);
    }
}
