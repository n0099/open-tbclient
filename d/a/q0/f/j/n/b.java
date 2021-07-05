package d.a.q0.f.j.n;

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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DownloadManager f52817a;

    /* loaded from: classes8.dex */
    public class a implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && download.getState() == Download.DownloadState.FINISH && d.a.q0.f.j.o.a.g(AppRuntime.getAppContext(), download.getKeyByUser()) : invokeL.booleanValue;
        }
    }

    /* renamed from: d.a.q0.f.j.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1110b implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52818a;

        public C1110b(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52818a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && TextUtils.equals(download.getKeyByUser(), this.f52818a) : invokeL.booleanValue;
        }
    }

    public b(DownloadManager downloadManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52817a = downloadManager;
    }

    public static boolean c(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, download)) == null) {
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

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                Collection<Download> downloadListByFilter = this.f52817a.getDownloadListByFilter(new a(this));
                if (downloadListByFilter == null) {
                    return;
                }
                int size = downloadListByFilter.size() - 30;
                if (size <= 0) {
                    return;
                }
                int i2 = 0;
                for (Download download : downloadListByFilter) {
                    if (i2 == size) {
                        return;
                    }
                    if (download != null) {
                        this.f52817a.cancel(download.getId().longValue());
                    }
                    i2++;
                }
            }
        }
    }

    public void b(String str) {
        Download d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str) || (d2 = d(str)) == null) {
            return;
        }
        this.f52817a.cancel(d2.getId().longValue());
    }

    public Download d(String str) {
        InterceptResult invokeL;
        Collection<Download> downloadListByFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (downloadListByFilter = this.f52817a.getDownloadListByFilter(new C1110b(this, str))) == null) {
                return null;
            }
            for (Download download : downloadListByFilter) {
                if (download != null) {
                    return download;
                }
            }
            return null;
        }
        return (Download) invokeL.objValue;
    }
}
