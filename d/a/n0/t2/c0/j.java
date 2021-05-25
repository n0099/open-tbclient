package d.a.n0.t2.c0;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes5.dex */
public class j implements d.a.m0.v.c {
    @Override // d.a.m0.v.c
    public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
        i l = i.l();
        if (i2 == 3) {
            l.q(downloadData);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
        } else {
            l.u(downloadData);
        }
        i.l().r(downloadData);
    }

    @Override // d.a.m0.v.c
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
        i.l().r(downloadData);
        String path = downloadData.getPath();
        if (TextUtils.isEmpty(path)) {
            path = d.a.n0.t2.b.h(downloadData.getId());
        }
        d.a.n0.q.d.i.a.f58232a.get().c().onSuccess(downloadData.getId(), path);
        if (downloadData.isNeedInvokeApk()) {
            d.a.n0.q.d.e.c().n(downloadData.getId(), path);
        }
    }

    @Override // d.a.m0.v.c
    public boolean onFileDownloaded(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // d.a.m0.v.c
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
        i.l().v(downloadData);
        i.l().r(downloadData);
    }

    @Override // d.a.m0.v.c
    public boolean onPreDownload(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }
}
