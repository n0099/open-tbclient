package d.a.p0.w;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static c f54134b;

    /* renamed from: c  reason: collision with root package name */
    public static DownloadData f54135c;

    /* renamed from: d  reason: collision with root package name */
    public static List<DownloadData> f54136d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f54137a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f54138a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54138a = cVar;
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
                if (k.isEmpty(id) || k.isEmpty(name)) {
                    return downloadData;
                }
                boolean isForceDownload = downloadData.isForceDownload();
                String str = id.replace(".", "_") + ".apk";
                String j = this.f54138a.j(str);
                File GetFile = FileHelper.GetFile(str);
                if (!isForceDownload && GetFile != null) {
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(j);
                    downloadData2.setStatus(3);
                    return downloadData2;
                }
                downloadData.setCallback(new d.a.p0.w.a());
                downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                downloadData.setType(12);
                downloadData.setPath(j);
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
                this.f54138a.f54137a = null;
                if (downloadData != null) {
                    if (downloadData.getStatus() == 3) {
                        this.f54138a.o(downloadData);
                        if (downloadData.isNeedInvokeApk()) {
                            Application app = TbadkCoreApplication.getInst().getApp();
                            UtilHelper.install_apk(app, downloadData.getId().replace(".", "_") + ".apk");
                        }
                    } else {
                        f.j().l(downloadData, 5);
                        int h2 = this.f54138a.h(downloadData.getId(), downloadData.getName());
                        if (downloadData.isNeedNotify() && h2 <= 0) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            Application app2 = TbadkCoreApplication.getInst().getApp();
                            int notifyId = downloadData.getNotifyId();
                            NotificationHelper.showProgressNotification(app2, notifyId, downloadData.getName() + string, 0, string, downloadData.getName(), this.f54138a.g(downloadData.getAction()), false);
                        } else {
                            this.f54138a.p(downloadData);
                        }
                    }
                    DownloadData unused = c.f54135c = null;
                    if (c.f54136d.isEmpty()) {
                        return;
                    }
                    c.f54136d.remove(0);
                    this.f54138a.u();
                }
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(88321114, "Ld/a/p0/w/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(88321114, "Ld/a/p0/w/c;");
                return;
            }
        }
        f54136d = new LinkedList();
    }

    public c() {
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
        this.f54137a = null;
    }

    public static c l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (c.class) {
                if (f54134b == null) {
                    f54134b = new c();
                }
            }
            return f54134b;
        }
        return (c) invokeV.objValue;
    }

    public final PendingIntent g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent(str);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
        }
        return (PendingIntent) invokeL.objValue;
    }

    public int h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            long k = k(str, str2);
            long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
            if (0 == j) {
                return -1;
            }
            if (k > j) {
                return 0;
            }
            return (int) ((k * 100) / j);
        }
        return invokeLL.intValue;
    }

    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
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

    public final String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
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

    public long k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            File GetFile = FileHelper.GetFile(str + "_" + str2 + ".tmp");
            if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
                return GetFile.length();
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public void m(ArrayList<AdvertAppInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            try {
                new C1245c(this, null).execute(arrayList);
            } catch (Exception unused) {
            }
        }
    }

    public void n(List<DownloadData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
        }
    }

    public void o(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public void p(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadData) == null) && downloadData != null && downloadData.isNeedNotify()) {
            int h2 = h(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, h2, h2 + "%", downloadData.getName(), g(downloadData.getAction()), false);
        }
    }

    public void q(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, downloadData) == null) || downloadData == null) {
            return;
        }
        List<DownloadData> i2 = f.j().i();
        if (i2 != null && i2.size() >= 5) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
            o(downloadData);
            UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
            return;
        }
        f54136d.add(downloadData);
        u();
    }

    public void r(String str, String str2, String str3, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            s(str, str2, str3, i2, i3, null, true, false, true);
        }
    }

    public void s(String str, String str2, String str3, int i2, int i3, String[] strArr, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), strArr, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            DownloadData downloadData = new DownloadData(str);
            downloadData.setType(12);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setName(str3);
            downloadData.setTag(strArr);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(i3);
            downloadData.setNeedInvokeApk(z);
            downloadData.setForceDownload(z2);
            downloadData.setNeedNotify(z3);
            q(downloadData);
        }
    }

    public void t(String str, String str2, String str3, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, str, str2, str3, strArr) == null) {
            s(str, str2, str3, -1, (int) d.a.d.e.m.b.f(str, 0L), null, true, false, true);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && f54135c == null) {
            DownloadData downloadData = (DownloadData) ListUtils.getItem(f54136d, 0);
            f54135c = downloadData;
            if (downloadData != null) {
                b bVar = new b(this, null);
                this.f54137a = bVar;
                bVar.setPriority(3);
                this.f54137a.execute(f54135c);
            }
        }
    }

    /* renamed from: d.a.p0.w.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1245c extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<AdvertAppInfo> f54139a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f54140b;

        public C1245c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54140b = cVar;
            this.f54139a = null;
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
                this.f54139a = arrayList;
                Iterator<AdvertAppInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    String downloadId = next.getDownloadId();
                    if (FileHelper.GetFile(this.f54140b.i(next.i4)) != null) {
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
                for (DownloadData downloadData : f.j().i()) {
                    Iterator<AdvertAppInfo> it = this.f54139a.iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals(it.next().getDownloadId(), downloadData.getId())) {
                            list.add(downloadData);
                        }
                    }
                }
                this.f54140b.n(list);
                this.f54139a = null;
            }
        }

        public /* synthetic */ C1245c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
