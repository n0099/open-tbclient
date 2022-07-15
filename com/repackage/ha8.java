package com.repackage;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class ha8 {
    public static /* synthetic */ Interceptable $ic;
    public static ha8 c;
    public static DownloadData d;
    public static List<DownloadData> e;
    public static HashMap<String, Integer> f;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public HashMap<String, la8> b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha8 a;

        public b(ha8 ha8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha8Var;
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
                if (oi.isEmpty(id) || oi.isEmpty(name)) {
                    return downloadData;
                }
                boolean isForceDownload = downloadData.isForceDownload();
                String str = id.replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
                String l = ha8.l(str);
                File GetFile = FileHelper.GetFile(str);
                if (!isForceDownload && GetFile != null) {
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(l);
                    downloadData2.setStatus(3);
                    return downloadData2;
                }
                downloadData.setCallback(new a15());
                downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                downloadData.setType(12);
                downloadData.setPath(l);
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
                        this.a.y(downloadData);
                        if (downloadData.isNeedInvokeApk()) {
                            Application app = TbadkCoreApplication.getInst().getApp();
                            UtilHelper.install_apk(app, downloadData.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                        }
                    } else {
                        ka8.j().l(downloadData, 5);
                        if (this.a.j(downloadData.getId(), downloadData.getName()) <= 0) {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("0");
                            }
                            if (downloadData.isNeedNotify()) {
                                String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f0509);
                                la8 la8Var = new la8(downloadData, 0);
                                this.a.b.put(downloadData.getUrl(), la8Var);
                                Application app2 = TbadkCoreApplication.getInst().getApp();
                                int notifyId = downloadData.getNotifyId();
                                NotificationHelper.showProgressNotification(app2, notifyId, downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), this.a.h(downloadData.getAction()), false, la8Var.b(), false);
                            }
                        } else {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("1");
                            }
                            this.a.C(downloadData);
                        }
                    }
                    DownloadData unused = ha8.d = null;
                    if (ha8.e.isEmpty()) {
                        return;
                    }
                    ha8.e.remove(0);
                    this.a.F();
                }
            }
        }

        public /* synthetic */ b(ha8 ha8Var, a aVar) {
            this(ha8Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755654862, "Lcom/repackage/ha8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755654862, "Lcom/repackage/ha8;");
                return;
            }
        }
        e = new LinkedList();
        f = new HashMap<>();
    }

    public ha8() {
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

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(FileHelper.getCacheDir());
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static ha8 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (ha8.class) {
                if (c == null) {
                    c = new ha8();
                }
            }
            return c;
        }
        return (ha8) invokeV.objValue;
    }

    public static Integer o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (f.containsKey(str)) {
                return f.get(str);
            }
            Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
            f.put(str, valueOf);
            return valueOf;
        }
        return (Integer) invokeL.objValue;
    }

    public static int p(DownloadData downloadData) {
        InterceptResult invokeL;
        int i;
        String id;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, downloadData)) == null) {
            if (n().t(downloadData.getId())) {
                i = 3;
            } else if (n().r(downloadData.getId())) {
                i = 5;
            } else if (n().u(downloadData.getId())) {
                i = 1;
            } else {
                i = n().q(downloadData.getId(), downloadData.getName()) ? 7 : 6;
            }
            DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
            if (downloadStaticsData != null) {
                id = downloadStaticsData.getApk_name();
            } else {
                id = downloadData.getId();
            }
            if (!TextUtils.isEmpty(id) && di5.a().l() && n().s(id)) {
                return 8;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public void A(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadData) == null) || downloadData == null) {
            return;
        }
        la8 la8Var = this.b.get(downloadData.getUrl());
        int j = j(downloadData.getId(), downloadData.getName());
        if (la8Var == null) {
            la8Var = new la8(downloadData, j);
        }
        la8Var.e();
        NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, j(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), h(downloadData.getAction()), false, la8Var.b(), false);
    }

    public void B(DownloadData downloadData) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null) {
            return;
        }
        int errorCode = downloadData.getErrorCode();
        if (errorCode == 1) {
            string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0500);
        } else if (errorCode != 3) {
            string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04fe);
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ff);
        }
        String str = string;
        if (downloadData.isNeedNotify()) {
            int process = downloadData.getProcess();
            Application app = TbadkCoreApplication.getInst().getApp();
            int notifyId = downloadData.getNotifyId();
            NotificationHelper.showProgressNotification(app, notifyId, downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f04fe), process, process + "%", str, h(downloadData.getAction()), false);
        }
    }

    public void C(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) && downloadData != null && downloadData.isNeedNotify()) {
            int j = j(downloadData.getId(), downloadData.getName());
            String str = j + "%";
            la8 la8Var = this.b.get(downloadData.getUrl());
            if (la8Var == null) {
                la8Var = new la8(downloadData, j);
            }
            int p = p(downloadData);
            if (p == 1) {
                la8Var.e();
            } else if (p == 4 || p == 2 || p == 7) {
                la8Var.d();
            } else if (p == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            la8Var.c(j);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), h(downloadData.getAction()), false, la8Var.b(), false);
        }
    }

    public void D(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || downloadData == null) {
            return;
        }
        List<DownloadData> i = ka8.j().i();
        if (i != null && i.size() >= 5) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f04fd));
            y(downloadData);
            UtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f04fd);
            return;
        }
        e.add(downloadData);
        F();
    }

    public void E(String str, String str2, String str3, int i, int i2, String[] strArr, boolean z, boolean z2, boolean z3, String str4, DownloadStaticsData downloadStaticsData, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), strArr, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4, downloadStaticsData, str5}) == null) {
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
            D(downloadData);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && d == null && !e.isEmpty()) {
            DownloadData downloadData = e.get(0);
            d = downloadData;
            if (downloadData != null) {
                b bVar = new b(this, null);
                this.a = bVar;
                bVar.setPriority(3);
                this.a.execute(d);
            }
        }
    }

    public void g(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048582, this, str, str2, z) == null) || StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : ka8.j().i()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        if (z) {
            ka8.j().g(str, true);
        } else {
            ka8.j().f(str);
        }
        if (downloadData != null) {
            int j = j(downloadData.getId(), downloadData.getName());
            String str3 = j + "%";
            if (downloadData == null || j < 0) {
                return;
            }
            la8 la8Var = this.b.get(downloadData.getUrl());
            if (la8Var == null) {
                la8Var = new la8(downloadData, j);
            }
            la8Var.d();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), h(downloadData.getAction()), false, la8Var.b(), false);
        }
    }

    public final PendingIntent h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent(str);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
        }
        return (PendingIntent) invokeL.objValue;
    }

    public void i(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadData) == null) {
            ka8.j().h(downloadData);
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
            y(downloadData);
        }
    }

    public int j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
            long m = m(str, str2);
            long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
            if (0 == j) {
                return -1;
            }
            if (m > j) {
                return 0;
            }
            return (int) ((m * 100) / j);
        }
        return invokeLL.intValue;
    }

    public String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            if (str.contains("?")) {
                str = str.substring(0, str.indexOf("?"));
            }
            String[] split = str.split("/");
            return split[split.length - 1];
        }
        return (String) invokeL.objValue;
    }

    public long m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            String str3 = str + "_" + str2 + ".tmp";
            File GetFile = FileHelper.GetFile(str3);
            if (GetFile == null) {
                GetFile = FileHelper.GetFileInCache(str3);
            }
            if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
                return GetFile.length();
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public boolean q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            if (TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) == 0) {
                return false;
            }
            File GetFile = FileHelper.GetFile(str + "_" + str2 + ".tmp");
            return GetFile != null && GetFile.exists() && GetFile.isFile();
        }
        return invokeLL.booleanValue;
    }

    public boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            for (DownloadData downloadData : ka8.j().i()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            TbadkApplication inst = TbadkApplication.getInst();
            if (inst != null) {
                try {
                    if (inst.getPackageManager() != null) {
                        inst.getPackageManager().getPackageInfo(str, 64);
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str.replace(".", "_"));
            sb.append(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            return FileHelper.GetFile(sb.toString()) != null;
        }
        return invokeL.booleanValue;
    }

    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            for (DownloadData downloadData : ka8.j().i()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void v(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, downloadData) == null) || downloadData == null) {
            return;
        }
        z(downloadData);
        la8 la8Var = this.b.get(downloadData.getUrl());
        if (la8Var != null) {
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, j(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), h(downloadData.getAction()), false, la8Var.b(), false);
        }
    }

    public void w(ArrayList<AdvertAppInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, arrayList) == null) {
            try {
                new c(this, null).execute(arrayList);
            } catch (Exception unused) {
            }
        }
    }

    public void x(List<DownloadData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
        }
    }

    public void y(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            hg5.c().f(linkedList);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public void z(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, downloadData) == null) || downloadData == null) {
            return;
        }
        la8 la8Var = this.b.get(downloadData.getUrl());
        int j = j(downloadData.getId(), downloadData.getName());
        if (la8Var == null) {
            la8Var = new la8(downloadData, j);
        }
        la8Var.d();
    }

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<AdvertAppInfo> a;
        public final /* synthetic */ ha8 b;

        public c(ha8 ha8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ha8Var;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<DownloadData> doInBackground(ArrayList<AdvertAppInfo>... arrayListArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayListArr)) == null) {
                ArrayList<AdvertAppInfo> arrayList = arrayListArr[0];
                LinkedList linkedList = new LinkedList();
                if (arrayList == null) {
                    return linkedList;
                }
                this.a = arrayList;
                Iterator<AdvertAppInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    String downloadId = next.getDownloadId();
                    if (FileHelper.GetFile(this.b.k(next.o)) != null) {
                        DownloadData downloadData = new DownloadData(downloadId);
                        downloadData.setStatus(3);
                        linkedList.add(downloadData);
                    }
                }
                return linkedList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<DownloadData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                if (list == null) {
                    list = new LinkedList<>();
                }
                for (DownloadData downloadData : ka8.j().i()) {
                    Iterator<AdvertAppInfo> it = this.a.iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals(it.next().getDownloadId(), downloadData.getId())) {
                            list.add(downloadData);
                        }
                    }
                }
                this.b.x(list);
                this.a = null;
            }
        }

        public /* synthetic */ c(ha8 ha8Var, a aVar) {
            this(ha8Var);
        }
    }
}
