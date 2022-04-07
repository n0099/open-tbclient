package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class hb8 {
    public static /* synthetic */ Interceptable $ic;
    public static hb8 c;
    public static DownloadData d;
    public static List<DownloadData> e;
    public static HashMap<String, Integer> f;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public HashMap<String, jb8> b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb8 a;

        public b(hb8 hb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hb8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public DownloadData doInBackground(DownloadData... downloadDataArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadDataArr)) == null) {
                DownloadData downloadData = downloadDataArr[0];
                if (downloadData == null) {
                    return downloadData;
                }
                String id = downloadData.getId();
                String name = downloadData.getName();
                if (ni.isEmpty(id) || ni.isEmpty(name)) {
                    return downloadData;
                }
                boolean isForceDownload = downloadData.isForceDownload();
                String f = h98.f(id);
                String h = h98.h(id);
                File e = h98.e(f);
                if (!isForceDownload && e != null) {
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(f);
                    downloadData2.setPath(h);
                    downloadData2.setStatus(3);
                    return downloadData2;
                }
                downloadData.setCallback(new ib8());
                downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                downloadData.setType(12);
                downloadData.setPath(h);
                return downloadData;
            }
            return (DownloadData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                super.onPostExecute(downloadData);
                this.a.a = null;
                if (downloadData != null) {
                    if (downloadData.getStatus() == 3) {
                        String a = hj5.a(TbadkCoreApplication.getInst(), downloadData.getPath());
                        uj5.a.get().c().onSuccess(downloadData.getId(), downloadData.getPath());
                        this.a.p(downloadData);
                        if (downloadData.isNeedInvokeApk() && !hj5.b(TbadkCoreApplication.getInst(), a) && !ga8.b(h98.h(downloadData.getId()))) {
                            h98.c(new File(h98.h(downloadData.getId())));
                        }
                    } else {
                        uj5.a.get().c().c(downloadData.getId());
                        xa8.j().l(downloadData, 5);
                        if (this.a.h(downloadData.getId(), downloadData.getName()) <= 0) {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("0");
                            }
                            if (downloadData.isNeedNotify()) {
                                TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f0500);
                                this.a.b.put(downloadData.getUrl(), new jb8(downloadData, 0));
                            }
                        } else {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("1");
                            }
                            this.a.t(downloadData);
                        }
                    }
                    DownloadData unused = hb8.d = null;
                    if (gd7.e(hb8.e)) {
                        return;
                    }
                    gd7.i(hb8.e, 0);
                    this.a.w();
                }
            }
        }

        public /* synthetic */ b(hb8 hb8Var, a aVar) {
            this(hb8Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755653901, "Lcom/repackage/hb8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755653901, "Lcom/repackage/hb8;");
                return;
            }
        }
        e = new LinkedList();
        f = new HashMap<>();
    }

    public hb8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new HashMap<>();
    }

    public static hb8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (hb8.class) {
                if (c == null) {
                    c = new hb8();
                }
            }
            return c;
        }
        return (hb8) invokeV.objValue;
    }

    public static Integer k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (f.containsKey(str)) {
                return f.get(str);
            }
            Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
            f.put(str, valueOf);
            return valueOf;
        }
        return (Integer) invokeL.objValue;
    }

    public static int l(DownloadData downloadData) {
        InterceptResult invokeL;
        int i;
        String id;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, downloadData)) == null) {
            if (h98.j(downloadData.getId())) {
                i = 3;
            } else if (j().m(downloadData.getId())) {
                i = 5;
            } else if (j().n(downloadData.getId())) {
                i = 1;
            } else {
                i = h98.k(downloadData.getId(), downloadData.getName()) ? 7 : 6;
            }
            DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
            if (downloadStaticsData != null) {
                id = downloadStaticsData.getApk_name();
            } else {
                id = downloadData.getId();
            }
            if (!TextUtils.isEmpty(id) && rg5.h().B() && ga8.r(id)) {
                return 8;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public void f(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, str, str2, z) == null) || StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : xa8.j().i()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        if (z) {
            xa8.j().g(str, true);
        } else {
            xa8.j().f(str);
        }
        if (downloadData != null) {
            int h = h(downloadData.getId(), downloadData.getName());
            uj5.a.get().c().a(str2, h);
            String str3 = h + "%";
            if (downloadData == null || h < 0) {
                return;
            }
            jb8 jb8Var = this.b.get(downloadData.getUrl());
            if (jb8Var == null) {
                jb8Var = new jb8(downloadData, h);
            }
            jb8Var.c();
        }
    }

    public void g(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
            xa8.j().h(downloadData);
            uj5.a.get().c().b(downloadData.getId(), StopStatus.DOWNLOAD_UNSTART);
            p(downloadData);
        }
    }

    public int h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            long i = i(str, str2);
            long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
            if (0 == j) {
                return -1;
            }
            if (i > j) {
                return 0;
            }
            return (int) ((i * 100) / j);
        }
        return invokeLL.intValue;
    }

    public long i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            File e2 = h98.e(h98.i(str, str2));
            if (e2 != null && e2.exists() && e2.isFile()) {
                return e2.length();
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            for (DownloadData downloadData : xa8.j().i()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            for (DownloadData downloadData : xa8.j().i()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, downloadData) == null) || downloadData == null) {
            return;
        }
        q(downloadData);
        uj5.a.get().c().b(downloadData.getId(), StopStatus.DOWNLOAD_FAIL);
        this.b.get(downloadData.getUrl());
    }

    public void p(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public void q(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadData) == null) || downloadData == null) {
            return;
        }
        jb8 jb8Var = this.b.get(downloadData.getUrl());
        int h = h(downloadData.getId(), downloadData.getName());
        if (jb8Var == null) {
            jb8Var = new jb8(downloadData, h);
        }
        jb8Var.c();
    }

    public void r(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, downloadData) == null) || downloadData == null) {
            return;
        }
        jb8 jb8Var = this.b.get(downloadData.getUrl());
        int h = h(downloadData.getId(), downloadData.getName());
        if (jb8Var == null) {
            jb8Var = new jb8(downloadData, h);
        }
        jb8Var.d();
    }

    public void s(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, downloadData) == null) || downloadData == null) {
            return;
        }
        int errorCode = downloadData.getErrorCode();
        if (errorCode == 1) {
            TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04f7);
        } else if (errorCode != 3) {
            TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04f5);
        } else {
            TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04f6);
        }
    }

    public void t(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, downloadData) == null) && downloadData != null && downloadData.isNeedNotify()) {
            int h = h(downloadData.getId(), downloadData.getName());
            uj5.a.get().c().d(downloadData.getId(), h);
            String str = h + "%";
            jb8 jb8Var = this.b.get(downloadData.getUrl());
            if (jb8Var == null) {
                jb8Var = new jb8(downloadData, h);
            }
            int l = l(downloadData);
            if (l == 1) {
                jb8Var.d();
            } else if (l == 4 || l == 2 || l == 7) {
                jb8Var.c();
            } else if (l == 6) {
                return;
            }
            jb8Var.b(h);
        }
    }

    public void u(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, downloadData) == null) || downloadData == null) {
            return;
        }
        List<DownloadData> i = xa8.j().i();
        if (i != null && i.size() >= 5) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f04f4));
            p(downloadData);
            UtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f04f4);
            return;
        }
        gd7.a(e, downloadData);
        w();
    }

    public void v(String str, String str2, String str3, int i, int i2, String[] strArr, boolean z, boolean z2, boolean z3, String str4, DownloadStaticsData downloadStaticsData, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), strArr, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4, downloadStaticsData, str5}) == null) {
            DownloadData downloadData = new DownloadData(str);
            downloadData.setType(12);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setName(str3);
            downloadData.setTag(strArr);
            downloadData.setPosition(i);
            downloadData.setNotifyId(i2);
            downloadData.setNeedInvokeApk(z);
            downloadData.setForceDownload(z2);
            downloadData.setNeedNotify(z3);
            downloadData.setApp_icon(str4);
            downloadData.setDownloadStaticsData(downloadStaticsData);
            downloadData.setUser_name(str5);
            u(downloadData);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && d == null && !gd7.e(e)) {
            DownloadData downloadData = (DownloadData) gd7.d(e, 0);
            d = downloadData;
            if (downloadData != null) {
                b bVar = new b(this, null);
                this.a = bVar;
                bVar.setPriority(3);
                this.a.execute(d);
            }
        }
    }
}
