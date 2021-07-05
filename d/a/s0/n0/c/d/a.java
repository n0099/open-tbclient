package d.a.s0.n0.c.d;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.v.c;
import d.a.r0.v.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f63719c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f63720a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f63721b;

    /* renamed from: d.a.s0.n0.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1601a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63722a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63723b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f63724c;

        public C1601a(a aVar, b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63724c = aVar;
            this.f63722a = bVar;
            this.f63723b = str;
        }

        @Override // d.a.r0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (this.f63724c.f63721b != null && downloadData.getUrl().equals(this.f63724c.f63721b.getUrl())) {
                    this.f63724c.f63721b = null;
                }
                b bVar = this.f63722a;
                if (bVar != null) {
                    bVar.a(str);
                }
            }
        }

        @Override // d.a.r0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (this.f63724c.f63721b != null && downloadData.getUrl().equals(this.f63724c.f63721b.getUrl())) {
                this.f63724c.f63721b = null;
            }
            if (this.f63722a != null) {
                this.f63724c.f63720a.put(downloadData.getPath().substring(d.a.s0.v3.c.f68588a.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f63722a.c(this.f63723b, downloadData.getPath());
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (this.f63724c.f63721b != null && downloadData.getUrl().equals(this.f63724c.f63721b.getUrl())) {
                    this.f63724c.f63721b = null;
                }
                b bVar = this.f63722a;
                if (bVar != null) {
                    bVar.b();
                }
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

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (f63719c == null) {
                synchronized (a.class) {
                    if (f63719c == null) {
                        f63719c = new a();
                    }
                }
            }
            return f63719c;
        }
        return (a) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63721b == null) {
            return;
        }
        d.j().g(this.f63721b.getUrl(), true);
    }

    public void e() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap<String, String> hashMap = this.f63720a;
            if (hashMap == null) {
                this.f63720a = new HashMap<>();
            } else {
                hashMap.clear();
            }
            File file = new File(d.a.s0.v3.c.f68588a);
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isFile()) {
                        this.f63720a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void f(String str, String str2, b bVar) {
        String nameMd5FromUrl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, bVar) == null) || TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        DownloadData downloadData = this.f63721b;
        if (downloadData != null) {
            if (str2.equals(downloadData.getUrl())) {
                return;
            }
            d.j().g(this.f63721b.getUrl(), true);
        }
        File file = new File(d.a.s0.v3.c.f68588a);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData2 = new DownloadData();
        downloadData2.setType(17);
        downloadData2.setId(str);
        downloadData2.setUrl(str2);
        downloadData2.setPath(d.a.s0.v3.c.f68588a + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData2.setCallback(new C1601a(this, bVar, str2));
        this.f63721b = downloadData2;
        d.j().k(downloadData2);
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            HashMap<String, String> hashMap = this.f63720a;
            if (hashMap == null) {
                this.f63720a = new HashMap<>();
                e();
                if (this.f63720a.size() > 0) {
                    return this.f63720a.get(nameMd5FromUrl);
                }
                return null;
            }
            return hashMap.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }
}
