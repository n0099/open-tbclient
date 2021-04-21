package d.b.j0.s2.a0;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes4.dex */
public class j implements d.b.i0.v.c {
    @Override // d.b.i0.v.c
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        i l = i.l();
        if (i == 3) {
            l.q(downloadData);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
        } else {
            l.u(downloadData);
        }
        i.l().r(downloadData);
    }

    @Override // d.b.i0.v.c
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
            path = d.b.j0.s2.b.h(downloadData.getId());
        }
        d.b.j0.o.d.h.a.f59080a.get().a().onSuccess(downloadData.getId(), path);
        if (downloadData.isNeedInvokeApk()) {
            d.b.j0.o.d.d.c().n(downloadData.getId(), path);
        }
    }

    @Override // d.b.i0.v.c
    public boolean onFileDownloaded(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // d.b.i0.v.c
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

    @Override // d.b.i0.v.c
    public boolean onPreDownload(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }
}
