package com.repackage;

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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class l66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l66 c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> a;
    public DownloadData b;

    /* loaded from: classes6.dex */
    public class a implements nz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ l66 c;

        public a(l66 l66Var, b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l66Var;
            this.a = bVar;
            this.b = str;
        }

        @Override // com.repackage.nz4
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (this.c.b != null && downloadData.getUrl().equals(this.c.b.getUrl())) {
                    this.c.b = null;
                }
                b bVar = this.a;
                if (bVar != null) {
                    bVar.a(str);
                }
            }
        }

        @Override // com.repackage.nz4
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (this.c.b != null && downloadData.getUrl().equals(this.c.b.getUrl())) {
                this.c.b = null;
            }
            if (this.a != null) {
                this.c.a.put(downloadData.getPath().substring(uo8.a.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.a.c(this.b, downloadData.getPath());
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
            if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (this.c.b != null && downloadData.getUrl().equals(this.c.b.getUrl())) {
                    this.c.b = null;
                }
                b bVar = this.a;
                if (bVar != null) {
                    bVar.b();
                }
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

    /* loaded from: classes6.dex */
    public interface b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

    public l66() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static l66 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c == null) {
                synchronized (l66.class) {
                    if (c == null) {
                        c = new l66();
                    }
                }
            }
            return c;
        }
        return (l66) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b == null) {
            return;
        }
        oz4.k().h(this.b.getUrl(), true);
    }

    public void e() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap<String, String> hashMap = this.a;
            if (hashMap == null) {
                this.a = new HashMap<>();
            } else {
                hashMap.clear();
            }
            File file = new File(uo8.a);
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isFile()) {
                        this.a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
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
        DownloadData downloadData = this.b;
        if (downloadData != null) {
            if (str2.equals(downloadData.getUrl())) {
                return;
            }
            oz4.k().h(this.b.getUrl(), true);
        }
        File file = new File(uo8.a);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData2 = new DownloadData();
        downloadData2.setType(17);
        downloadData2.setId(str);
        downloadData2.setUrl(str2);
        downloadData2.setPath(uo8.a + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData2.setCallback(new a(this, bVar, str2));
        this.b = downloadData2;
        oz4.k().l(downloadData2);
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            HashMap<String, String> hashMap = this.a;
            if (hashMap == null) {
                this.a = new HashMap<>();
                e();
                if (this.a.size() > 0) {
                    return this.a.get(nameMd5FromUrl);
                }
                return null;
            }
            return hashMap.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }
}
