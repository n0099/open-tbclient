package d.a.i0.v;

import android.content.SharedPreferences;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import d.a.j0.s2.b0.e;
/* loaded from: classes3.dex */
public class a implements c {
    @Override // d.a.i0.v.c
    public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
        e n = e.n();
        if (i2 == 3) {
            n.v(downloadData);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
        } else {
            n.B(downloadData);
        }
        e.n().y(downloadData);
    }

    @Override // d.a.i0.v.c
    public void onFileDownloadSucceed(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        String[] tag = downloadData.getTag();
        if (tag != null && tag.length == 3) {
            String str = tag[0];
            String str2 = tag[1];
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "dl_game_success", PrefetchEvent.STATE_CLICK, 1, "dev_id", downloadData.getId(), "ref_id", str, "is_detail", tag[2], "ref_type", str2);
        }
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        e.n().y(downloadData);
        if (downloadData.isNeedInvokeApk()) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
        }
    }

    @Override // d.a.i0.v.c
    public boolean onFileDownloaded(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // d.a.i0.v.c
    public void onFileUpdateProgress(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        SharedPreferences sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
        long j = sharedPreferences.getLong(downloadData.getId(), 0L);
        if (j <= 1 || (downloadData.getSize() > 1 && j != downloadData.getSize())) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(downloadData.getId(), downloadData.getSize());
            edit.commit();
        }
        e.n().C(downloadData);
        e.n().y(downloadData);
    }

    @Override // d.a.i0.v.c
    public boolean onPreDownload(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }
}
