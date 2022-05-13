package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Collection;
/* loaded from: classes5.dex */
public class cr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadManager a;

    /* loaded from: classes5.dex */
    public class a implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(cr3 cr3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && download.getState() == Download.DownloadState.FINISH && lr3.g(AppRuntime.getAppContext(), download.getKeyByUser()) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public b(cr3 cr3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && TextUtils.equals(download.getKeyByUser(), this.a) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cr3 b;

        public c(cr3 cr3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cr3Var;
            this.a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? (download == null || !TextUtils.equals(download.getKeyByUser(), this.a) || this.b.e(download)) ? false : true : invokeL.booleanValue;
        }
    }

    public cr3(DownloadManager downloadManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = downloadManager;
    }

    public static boolean d(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, download)) == null) {
            if (download == null) {
                return false;
            }
            String realDownloadDir = download.getRealDownloadDir();
            String fileName = download.getFileName();
            if (TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                return false;
            }
            File file = new File(realDownloadDir + File.separator + fileName);
            return file.isFile() && file.exists();
        }
        return invokeL.booleanValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                Collection<Download> downloadListByFilter = this.a.getDownloadListByFilter(new a(this));
                if (downloadListByFilter == null) {
                    return;
                }
                int size = downloadListByFilter.size() - 30;
                if (size <= 0) {
                    return;
                }
                int i = 0;
                for (Download download : downloadListByFilter) {
                    if (i == size) {
                        return;
                    }
                    if (download != null) {
                        this.a.cancel(download.getId().longValue());
                    }
                    i++;
                }
            }
        }
    }

    public void c(String str) {
        Download g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str) || (g = g(str)) == null) {
            return;
        }
        this.a.cancel(g.getId().longValue());
    }

    public final boolean e(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, download)) == null) {
            if (download == null) {
                return false;
            }
            return (f(download) || (download.getState() == Download.DownloadState.FINISH && !d(download))) && !lr3.g(AppRuntime.getAppContext(), download.getKeyByUser());
        }
        return invokeL.booleanValue;
    }

    public final boolean f(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, download)) == null) ? download != null && (System.currentTimeMillis() - new br3(download).k()) / 86400000 >= 30 : invokeL.booleanValue;
    }

    public Download g(String str) {
        InterceptResult invokeL;
        Collection<Download> downloadListByFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Download download = null;
            if (TextUtils.isEmpty(str) || (downloadListByFilter = this.a.getDownloadListByFilter(new b(this, str))) == null) {
                return null;
            }
            for (Download download2 : downloadListByFilter) {
                if (download2 != null) {
                    download = download2;
                }
            }
            return download;
        }
        return (Download) invokeL.objValue;
    }

    public Download h(String str) {
        InterceptResult invokeL;
        Collection<Download> downloadListByFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Download download = null;
            if (TextUtils.isEmpty(str) || (downloadListByFilter = this.a.getDownloadListByFilter(new c(this, str))) == null) {
                return null;
            }
            for (Download download2 : downloadListByFilter) {
                if (download2 != null) {
                    download = download2;
                }
            }
            return download;
        }
        return (Download) invokeL.objValue;
    }
}
