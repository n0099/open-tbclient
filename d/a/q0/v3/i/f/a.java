package d.a.q0.v3.i.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.w.e;
import d.a.p0.w.f;
import d.a.q0.v3.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f66119c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f66120a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f66121b;

    /* renamed from: d.a.q0.v3.i.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1809a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66122a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f66123b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f66124c;

        public C1809a(a aVar, b bVar, String str) {
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
            this.f66124c = aVar;
            this.f66122a = bVar;
            this.f66123b = str;
        }

        @Override // d.a.p0.w.e
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (this.f66124c.f66121b != null && downloadData.getUrl().equals(this.f66124c.f66121b.getUrl())) {
                    this.f66124c.f66121b = null;
                }
                b bVar = this.f66122a;
                if (bVar != null) {
                    bVar.a(str);
                }
            }
        }

        @Override // d.a.p0.w.e
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (this.f66124c.f66121b != null && downloadData.getUrl().equals(this.f66124c.f66121b.getUrl())) {
                this.f66124c.f66121b = null;
            }
            if (this.f66122a != null) {
                this.f66124c.f66120a.put(downloadData.getPath().substring(c.f66018a.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f66122a.c(this.f66123b, downloadData.getPath());
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
                if (this.f66124c.f66121b != null && downloadData.getUrl().equals(this.f66124c.f66121b.getUrl())) {
                    this.f66124c.f66121b = null;
                }
                b bVar = this.f66122a;
                if (bVar != null) {
                    bVar.b();
                }
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

    /* loaded from: classes8.dex */
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

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f66119c == null) {
                synchronized (a.class) {
                    if (f66119c == null) {
                        f66119c = new a();
                    }
                }
            }
            return f66119c;
        }
        return (a) invokeV.objValue;
    }

    public void d() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HashMap<String, String> hashMap = this.f66120a;
            if (hashMap == null) {
                this.f66120a = new HashMap<>();
            } else {
                hashMap.clear();
            }
            File file = new File(c.f66018a);
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isFile()) {
                        this.f66120a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void e(String str, String str2, b bVar) {
        String nameMd5FromUrl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, bVar) == null) || TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        DownloadData downloadData = this.f66121b;
        if (downloadData != null) {
            if (str2.equals(downloadData.getUrl())) {
                return;
            }
            f.j().g(this.f66121b.getUrl(), true);
        }
        File file = new File(c.f66018a);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData2 = new DownloadData();
        downloadData2.setType(17);
        downloadData2.setId(str);
        downloadData2.setUrl(str2);
        downloadData2.setPath(c.f66018a + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData2.setCallback(new C1809a(this, bVar, str2));
        this.f66121b = downloadData2;
        f.j().k(downloadData2);
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            HashMap<String, String> hashMap = this.f66120a;
            if (hashMap == null) {
                this.f66120a = new HashMap<>();
                d();
                if (this.f66120a.size() > 0) {
                    return this.f66120a.get(nameMd5FromUrl);
                }
                return null;
            }
            return hashMap.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }
}
