package d.a.q0.w2.c0;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class l implements d.a.p0.w.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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

    @Override // d.a.p0.w.e
    public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
            k l = k.l();
            if (i2 == 3) {
                l.q(downloadData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
            } else {
                l.u(downloadData);
            }
            k.l().r(downloadData);
        }
    }

    @Override // d.a.p0.w.e
    public void onFileDownloadSucceed(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null) {
            return;
        }
        String[] tag = downloadData.getTag();
        if (tag != null && tag.length == 3) {
            String str = tag[0];
            String str2 = tag[1];
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "dl_game_success", PrefetchEvent.STATE_CLICK, 1, "dev_id", downloadData.getId(), "ref_id", str, "is_detail", tag[2], "ref_type", str2);
        }
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        k.l().r(downloadData);
        String path = downloadData.getPath();
        if (TextUtils.isEmpty(path)) {
            path = d.a.q0.w2.b.h(downloadData.getId());
        }
        d.a.q0.q.d.i.a.f62090a.get().c().onSuccess(downloadData.getId(), path);
        if (downloadData.isNeedInvokeApk()) {
            d.a.q0.q.d.e.c().n(downloadData.getId(), path);
        }
    }

    @Override // d.a.p0.w.e
    public boolean onFileDownloaded(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            downloadData.setStatusMsg(null);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.p0.w.e
    public void onFileUpdateProgress(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || downloadData == null) {
            return;
        }
        SharedPreferences sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
        long j = sharedPreferences.getLong(downloadData.getId(), 0L);
        if (j <= 1 || (downloadData.getSize() > 1 && j != downloadData.getSize())) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(downloadData.getId(), downloadData.getSize());
            edit.commit();
        }
        k.l().v(downloadData);
        k.l().r(downloadData);
    }

    @Override // d.a.p0.w.e
    public boolean onPreDownload(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            downloadData.setStatusMsg(null);
            return true;
        }
        return invokeL.booleanValue;
    }
}
