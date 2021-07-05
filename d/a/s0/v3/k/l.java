package d.a.s0.v3.k;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String f68876f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f68877a;

    /* renamed from: b  reason: collision with root package name */
    public List<DownloadData> f68878b;

    /* renamed from: c  reason: collision with root package name */
    public b f68879c;

    /* renamed from: d  reason: collision with root package name */
    public String f68880d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.v.c f68881e;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.v.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f68882a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68882a = lVar;
        }

        @Override // d.a.r0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.f68882a.i(downloadData);
                if (this.f68882a.f68879c == null || !this.f68882a.f68880d.equals(downloadData.getUrl())) {
                    return;
                }
                this.f68882a.f68879c.a(str);
            }
        }

        @Override // d.a.r0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath()) || StringUtils.isNull(l.f68876f)) {
                return;
            }
            this.f68882a.i(downloadData);
            if (this.f68882a.f68879c == null || !this.f68882a.f68880d.equals(downloadData.getUrl())) {
                return;
            }
            this.f68882a.f68877a.put(downloadData.getPath().substring(l.f68876f.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
            this.f68882a.f68879c.c(this.f68882a.f68880d, downloadData.getPath());
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.f68882a.i(downloadData);
                if (this.f68882a.f68879c == null || !this.f68882a.f68880d.equals(downloadData.getUrl())) {
                    return;
                }
                this.f68882a.f68879c.b();
            }
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

    /* loaded from: classes9.dex */
    public interface b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1245249880, "Ld/a/s0/v3/k/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1245249880, "Ld/a/s0/v3/k/l;");
                return;
            }
        }
        f68876f = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public l() {
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
        this.f68881e = new a(this);
    }

    public void e() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(f68876f)) {
            return;
        }
        HashMap<String, String> hashMap = this.f68877a;
        if (hashMap == null) {
            this.f68877a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(f68876f);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f68877a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !StringUtils.isNull(f68876f)) {
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
                if (nameMd5FromUrl == null) {
                    return;
                }
                File file = new File(f68876f);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
                if (this.f68878b == null) {
                    this.f68878b = new ArrayList();
                }
                if (h(str)) {
                    return;
                }
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(f68876f + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.f68881e);
                this.f68878b.add(downloadData);
                d.a.r0.v.d.j().k(downloadData);
                return;
            }
            b bVar = this.f68879c;
            if (bVar != null) {
                bVar.a("");
            }
        }
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            if (this.f68877a == null) {
                this.f68877a = new HashMap<>();
                e();
            }
            return this.f68877a.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }

    public final boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!ListUtils.isEmpty(this.f68878b) && str != null) {
                for (DownloadData downloadData : this.f68878b) {
                    if (downloadData != null && str.equals(downloadData.getUrl())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void i(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) || ListUtils.isEmpty(this.f68878b) || downloadData == null) {
            return;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 < this.f68878b.size()) {
                if (this.f68878b.get(i3) != null && this.f68878b.get(i3).getUrl() != null && this.f68878b.get(i3).getUrl().equals(downloadData.getUrl())) {
                    i2 = i3;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        this.f68878b.remove(i2);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (str == null) {
                this.f68880d = "";
            } else {
                this.f68880d = str;
            }
        }
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f68879c = bVar;
        }
    }
}
