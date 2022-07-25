package com.kwai.filedownloader.services;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes5.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<DownloadLaunchRunnable> awC;
    public ThreadPoolExecutor awD;
    public final String awE;
    public int awF;
    public int awG;

    public h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.awC = new SparseArray<>();
        this.awE = "Network";
        this.awG = 0;
        this.awD = com.kwai.filedownloader.e.b.l(i, "Network");
        this.awF = i;
    }

    private synchronized void EF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
                int size = this.awC.size();
                for (int i = 0; i < size; i++) {
                    int keyAt = this.awC.keyAt(i);
                    DownloadLaunchRunnable downloadLaunchRunnable = this.awC.get(keyAt);
                    if (downloadLaunchRunnable.isAlive()) {
                        sparseArray.put(keyAt, downloadLaunchRunnable);
                    }
                }
                this.awC = sparseArray;
            }
        }
    }

    public final synchronized int EG() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                EF();
                size = this.awC.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public final synchronized List<Integer> EH() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                EF();
                arrayList = new ArrayList();
                for (int i = 0; i < this.awC.size(); i++) {
                    arrayList.add(Integer.valueOf(this.awC.get(this.awC.keyAt(i)).getId()));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadLaunchRunnable) == null) {
            downloadLaunchRunnable.Dz();
            synchronized (this) {
                this.awC.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
            }
            this.awD.execute(downloadLaunchRunnable);
            int i2 = this.awG;
            if (i2 >= 600) {
                EF();
                i = 0;
            } else {
                i = i2 + 1;
            }
            this.awG = i;
        }
    }

    public final boolean cD(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.awC.get(i);
            return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
        }
        return invokeI.booleanValue;
    }

    public final void cancel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            EF();
            synchronized (this) {
                DownloadLaunchRunnable downloadLaunchRunnable = this.awC.get(i);
                if (downloadLaunchRunnable != null) {
                    downloadLaunchRunnable.pause();
                    boolean remove = this.awD.remove(downloadLaunchRunnable);
                    if (com.kwai.filedownloader.e.d.awL) {
                        com.kwai.filedownloader.e.d.e(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                    }
                }
                this.awC.remove(i);
            }
        }
    }

    public final synchronized boolean cq(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            synchronized (this) {
                if (EG() > 0) {
                    com.kwai.filedownloader.e.d.f(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
                    return false;
                }
                int cE = com.kwai.filedownloader.e.e.cE(i);
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.awF), Integer.valueOf(cE));
                }
                List<Runnable> shutdownNow = this.awD.shutdownNow();
                this.awD = com.kwai.filedownloader.e.b.l(cE, "Network");
                if (shutdownNow.size() > 0) {
                    com.kwai.filedownloader.e.d.f(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
                }
                this.awF = cE;
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public final int p(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i)) == null) {
            if (str == null) {
                return 0;
            }
            int size = this.awC.size();
            for (int i2 = 0; i2 < size; i2++) {
                DownloadLaunchRunnable valueAt = this.awC.valueAt(i2);
                if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i && str.equals(valueAt.DE())) {
                    return valueAt.getId();
                }
            }
            return 0;
        }
        return invokeLI.intValue;
    }
}
