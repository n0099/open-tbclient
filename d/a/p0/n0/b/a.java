package d.a.p0.n0.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.y.r;
import d.a.o0.v.d;
import d.a.o0.v.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipException;
/* loaded from: classes8.dex */
public class a implements d.a.p0.n0.b.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final String f60459i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public VideoControllerLayout f60460a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.f0.c.a f60461b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.f0.a.a f60462c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f60463d;

    /* renamed from: e  reason: collision with root package name */
    public List<DownloadData> f60464e;

    /* renamed from: f  reason: collision with root package name */
    public b f60465f;

    /* renamed from: g  reason: collision with root package name */
    public QmFilterItem f60466g;

    /* renamed from: h  reason: collision with root package name */
    public d f60467h;

    /* renamed from: d.a.p0.n0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1555a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60468a;

        public C1555a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60468a = aVar;
        }

        @Override // d.a.o0.v.d
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.f60468a.o(downloadData);
                if (this.f60468a.f60465f == null || this.f60468a.f60466g == null || this.f60468a.f60466g.fileUrl == null || !this.f60468a.f60466g.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.f60468a.f60465f.a(str);
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x008a */
        @Override // d.a.o0.v.d
        public void onFileDownloadSucceed(DownloadData downloadData) {
            File file;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath()) || StringUtils.isNull(a.f60459i)) {
                return;
            }
            this.f60468a.o(downloadData);
            if (this.f60468a.f60465f == null || this.f60468a.f60466g == null || this.f60468a.f60466g.fileUrl == null || !this.f60468a.f60466g.fileUrl.equals(downloadData.getUrl()) || !downloadData.getPath().endsWith(".zip")) {
                return;
            }
            String substring = downloadData.getPath().substring(a.f60459i.length() + 1, downloadData.getPath().lastIndexOf("."));
            String str = a.f60459i + "/" + substring;
            try {
                try {
                    try {
                        r.c(new File(downloadData.getPath()), str);
                        this.f60468a.f60463d.put(substring, str);
                        this.f60468a.f60466g.localPath = str;
                        this.f60468a.f60465f.c(this.f60468a.f60466g);
                        String path = downloadData.getPath();
                        file = new File(path);
                        downloadData = path;
                    } catch (ZipException e2) {
                        this.f60468a.f60465f.a("解压失败，请点击重试");
                        FileHelper.deleteFileOrDir(new File(str));
                        BdLog.e(e2);
                        String path2 = downloadData.getPath();
                        file = new File(path2);
                        downloadData = path2;
                    }
                } catch (IOException e3) {
                    this.f60468a.f60465f.a("解压失败，请点击重试");
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

        @Override // d.a.o0.v.d
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // d.a.o0.v.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.f60468a.o(downloadData);
                if (this.f60468a.f60465f == null || this.f60468a.f60466g == null || this.f60468a.f60466g.fileUrl == null || !this.f60468a.f60466g.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.f60468a.f60465f.b();
            }
        }

        @Override // d.a.o0.v.d
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(String str);

        void b();

        void c(QmFilterItem qmFilterItem);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1056427670, "Ld/a/p0/n0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1056427670, "Ld/a/p0/n0/b/a;");
                return;
            }
        }
        f60459i = FileHelper.CreateFileIfNotFound(".filters") != null ? FileHelper.CreateFileIfNotFound(".filters").getAbsolutePath() : "";
    }

    public a(d.a.p0.f0.c.a aVar, d.a.p0.f0.a.a aVar2, VideoControllerLayout videoControllerLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, videoControllerLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60466g = new QmFilterItem();
        this.f60467h = new C1555a(this);
        this.f60461b = aVar;
        this.f60462c = aVar2;
        this.f60460a = videoControllerLayout;
        m();
    }

    @Override // d.a.p0.n0.b.b
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            p(qmFilterItem);
            if (qmFilterItem == null) {
                reset();
                return true;
            } else if (!StringUtils.isNull(qmFilterItem.localPath)) {
                d.a.p0.f0.c.a aVar = this.f60461b;
                if (aVar != null) {
                    aVar.a(qmFilterItem);
                    return true;
                }
                d.a.p0.f0.a.a aVar2 = this.f60462c;
                if (aVar2 != null) {
                    aVar2.a(qmFilterItem);
                }
                return true;
            } else {
                reset();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.p0.n0.b.b
    public QmFilterItem b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60466g : (QmFilterItem) invokeV.objValue;
    }

    @Override // d.a.p0.n0.b.b
    public void c(QmFilterItem qmFilterItem) {
        QmFilterItem qmFilterItem2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmFilterItem) == null) {
            p(qmFilterItem);
            if (qmFilterItem == null) {
                return;
            }
            if (!TextUtils.isEmpty(qmFilterItem.fileUrl) && !StringUtils.isNull(f60459i)) {
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(qmFilterItem.fileUrl);
                if (nameMd5FromUrl == null) {
                    return;
                }
                File file = new File(f60459i);
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(".");
                String str2 = qmFilterItem.fileUrl;
                sb.append(str2.substring(str2.lastIndexOf(".") + 1));
                String sb2 = sb.toString();
                if (this.f60464e == null) {
                    this.f60464e = new ArrayList();
                }
                if (n(qmFilterItem.fileUrl)) {
                    return;
                }
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(qmFilterItem.fileUrl);
                downloadData.setPath(f60459i + "/" + nameMd5FromUrl + sb2);
                downloadData.setCallback(this.f60467h);
                this.f60464e.add(downloadData);
                e.j().k(downloadData);
                return;
            }
            a(null);
            if (this.f60465f == null || (qmFilterItem2 = this.f60466g) == null || (str = qmFilterItem2.fileUrl) == null || !str.equals(qmFilterItem.fileUrl)) {
                return;
            }
            this.f60465f.b();
        }
    }

    @Override // d.a.p0.n0.b.b
    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f60465f = bVar;
        }
    }

    @Override // d.a.p0.n0.b.b
    public void e() {
        VideoControllerLayout videoControllerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (videoControllerLayout = this.f60460a) == null) {
            return;
        }
        videoControllerLayout.setSelectedToRightIndex();
    }

    @Override // d.a.p0.n0.b.b
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            if (this.f60463d == null) {
                this.f60463d = new HashMap<>();
                h();
            }
            return this.f60463d.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.p0.n0.b.b
    public void g() {
        VideoControllerLayout videoControllerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (videoControllerLayout = this.f60460a) == null) {
            return;
        }
        videoControllerLayout.setSelectedToLeftIndex();
    }

    @Override // d.a.p0.n0.b.b
    public void h() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || StringUtils.isNull(f60459i)) {
            return;
        }
        HashMap<String, String> hashMap = this.f60463d;
        if (hashMap == null) {
            this.f60463d = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(f60459i);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    this.f60463d.put(file2.getName(), file2.getAbsolutePath());
                }
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!ListUtils.isEmpty(this.f60464e) && str != null) {
                for (DownloadData downloadData : this.f60464e) {
                    if (downloadData != null && str.equals(downloadData.getUrl())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void o(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, downloadData) == null) || ListUtils.isEmpty(this.f60464e) || downloadData == null) {
            return;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 < this.f60464e.size()) {
                if (this.f60464e.get(i3) != null && this.f60464e.get(i3).getUrl() != null && this.f60464e.get(i3).getUrl().equals(downloadData.getUrl())) {
                    i2 = i3;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        this.f60464e.remove(i2);
    }

    public void p(QmFilterItem qmFilterItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, qmFilterItem) == null) {
            if (qmFilterItem == null) {
                this.f60466g = new QmFilterItem();
            } else {
                this.f60466g = qmFilterItem;
            }
        }
    }

    @Override // d.a.p0.n0.b.b
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.p0.f0.c.a aVar = this.f60461b;
            if (aVar != null) {
                aVar.a(null);
            }
            d.a.p0.f0.a.a aVar2 = this.f60462c;
            if (aVar2 != null) {
                aVar2.a(null);
            }
        }
    }
}
