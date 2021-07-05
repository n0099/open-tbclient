package d.a.s0.w2.c0;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static f f69026c;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f69027d;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f69028e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f69029a;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public Handler f69030b;

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 900002 || message.arg2 <= 0 || f.f69027d == null) {
                    return;
                }
                f.f69027d.setLength(message.arg1);
                f.f69027d.setSize(message.arg2);
                f.f69027d.setStatus(1);
                if (f.f69027d.getCallback() != null) {
                    f.f69027d.getCallback().onFileUpdateProgress(f.f69027d);
                }
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f69031a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f69032b;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69032b = fVar;
            this.f69031a = new NetWork();
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f69031a;
                if (netWork != null) {
                    netWork.setCancel();
                }
                cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            InterceptResult invokeL;
            FileInputStream fileInputStream;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadDataArr)) != null) {
                return (Integer) invokeL.objValue;
            }
            FileInputStream fileInputStream2 = null;
            if (downloadDataArr[0] == null) {
                return null;
            }
            if (downloadDataArr[0].getCallback() != null && !downloadDataArr[0].getCallback().onPreDownload(downloadDataArr[0])) {
                return 0;
            }
            File file = new File(downloadDataArr[0].getPath());
            if (file.exists()) {
                file.delete();
            }
            if (!file.exists()) {
                this.f69031a.setUrl(downloadDataArr[0].getUrl());
                NetWork netWork = this.f69031a;
                if (Boolean.valueOf(netWork.downloadFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", this.f69032b.f69030b, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
                    File GetFile = FileHelper.GetFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (GetFile != null) {
                        try {
                            try {
                                String parent = GetFile.getParent();
                                String parent2 = file.getParent();
                                if (parent.equals(parent2)) {
                                    GetFile.renameTo(new File(parent2, file.getName()));
                                } else {
                                    d.a.c.e.p.f.f(GetFile, file);
                                    d.a.c.e.p.f.n(GetFile);
                                }
                            } catch (IOException unused) {
                                d.a.c.e.p.f.n(file);
                                return 7;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return 7;
                        }
                    } else {
                        return 1;
                    }
                } else {
                    return 3;
                }
            }
            try {
                if (!d.a.c.e.p.k.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    }
                    try {
                        if (!q.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                            d.a.c.e.p.f.n(new File(downloadDataArr[0].getPath()));
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                BdLog.d(e4.getMessage());
                            }
                            return 4;
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            BdLog.d(e5.getMessage());
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        fileInputStream2 = fileInputStream;
                        BdLog.d(e.getMessage());
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e7) {
                                BdLog.d(e7.getMessage());
                            }
                        }
                        return 6;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e8) {
                                BdLog.d(e8.getMessage());
                            }
                        }
                        throw th;
                    }
                }
                if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onFileDownloaded(downloadDataArr[0])) {
                    return 0;
                }
                return 2;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
                this.f69031a.setCancel();
                f.f69027d.setStatus(4);
                f.f69027d.setStatusMsg(null);
                if (f.f69027d.getCallback() != null) {
                    f.f69027d.getCallback().onFileUpdateProgress(f.f69027d);
                }
                if (!f.f69028e.isEmpty()) {
                    f.f69028e.remove(0);
                }
                DownloadData unused = f.f69027d = null;
                this.f69032b.m();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, num) == null) {
                super.onPostExecute((b) num);
                if (num == null) {
                    return;
                }
                if (num.intValue() == 0) {
                    f.f69027d.setStatus(0);
                    if (f.f69027d.getCallback() != null) {
                        f.f69027d.getCallback().onFileUpdateProgress(f.f69027d);
                    }
                    if (f.f69027d.getCallback() != null) {
                        f.f69027d.getCallback().onFileDownloadSucceed(f.f69027d);
                    }
                } else {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue == 2) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue == 3) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                    } else if (intValue == 4) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue != 6) {
                        string = intValue != 7 ? null : TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    }
                    f.f69027d.setStatusMsg(string);
                    f.f69027d.setErrorCode(num.intValue());
                    f.f69027d.setStatus(2);
                    if (f.f69027d.getCallback() != null) {
                        f.f69027d.getCallback().onFileUpdateProgress(f.f69027d);
                    }
                    if (f.f69027d.getCallback() != null) {
                        f.f69027d.getCallback().onFileDownloadFailed(f.f69027d, num.intValue(), string);
                    }
                }
                DownloadData unused = f.f69027d = null;
                if (f.f69028e.isEmpty()) {
                    return;
                }
                f.f69028e.remove(0);
                this.f69032b.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(795931664, "Ld/a/s0/w2/c0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(795931664, "Ld/a/s0/w2/c0/f;");
                return;
            }
        }
        f69026c = new f();
        f69027d = null;
        f69028e = new LinkedList();
    }

    public f() {
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
        this.f69029a = null;
        this.f69030b = new a(this, Looper.getMainLooper());
    }

    public static f j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f69026c : (f) invokeV.objValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            g(str, false);
        }
    }

    public void g(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            DownloadData downloadData = f69027d;
            if (downloadData != null && downloadData.getUrl().equals(str)) {
                if (z) {
                    this.f69029a.b();
                    return;
                } else {
                    this.f69029a.cancel(true);
                    return;
                }
            }
            LinkedList<DownloadData> linkedList = new LinkedList();
            Iterator<DownloadData> it = f69028e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadData next = it.next();
                if (next.getUrl().equals(str)) {
                    next.setStatus(4);
                    if (next.getCallback() != null) {
                        next.getCallback().onFileUpdateProgress(next);
                    }
                    linkedList.add(next);
                }
            }
            for (DownloadData downloadData2 : linkedList) {
                f69028e.remove(downloadData2);
            }
        }
    }

    public void h(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) || downloadData == null) {
            return;
        }
        g(downloadData.getUrl(), true);
        File GetFile = FileHelper.GetFile(downloadData.getId() + "_" + downloadData.getName() + ".tmp");
        if (GetFile != null) {
            GetFile.delete();
        }
    }

    public List<DownloadData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f69028e : (List) invokeV.objValue;
    }

    public void k(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) || downloadData == null) {
            return;
        }
        if (!FileHelper.checkSD()) {
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
            downloadData.setStatus(2);
        }
        if (downloadData.getStatus() == 2) {
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        for (int i2 = 0; i2 < f69028e.size(); i2++) {
            DownloadData downloadData2 = f69028e.get(i2);
            if (downloadData2 != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        f69028e.add(downloadData);
        m();
    }

    public void l(DownloadData downloadData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, downloadData, i2) == null) {
            int type = downloadData.getType();
            int i3 = 0;
            for (DownloadData downloadData2 : f69028e) {
                if (downloadData2.getType() == type) {
                    i3++;
                }
            }
            if (i3 >= i2) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().onFileUpdateProgress(downloadData);
                    return;
                }
                return;
            }
            k(downloadData);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && f69027d == null && !f69028e.isEmpty()) {
            DownloadData downloadData = f69028e.get(0);
            f69027d = downloadData;
            if (downloadData != null) {
                b bVar = new b(this);
                this.f69029a = bVar;
                bVar.execute(f69027d);
            }
        }
    }
}
