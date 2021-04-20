package d.b.i0.s2.a0;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadReceiver;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final RemoteViews f61525a = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), R.layout.download_notify_view);

    /* loaded from: classes4.dex */
    public class a extends d.b.c.e.l.c<d.b.c.j.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            if (g.this.f61525a == null || aVar == null || aVar.p() == null) {
                return;
            }
            g.this.f61525a.setImageViewBitmap(R.id.app_icon, aVar.p());
        }
    }

    public g(DownloadData downloadData, int i) {
        c(i);
        this.f61525a.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.f61525a.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
        this.f61525a.setImageViewResource(R.id.download_cancel, R.drawable.notify_cancel_bg);
        this.f61525a.setTextViewText(R.id.downapp_name, downloadData.getUser_name());
        d.b.c.e.l.d.h().m(downloadData.getApp_icon(), 17, new a(), BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        this.f61525a.setOnClickPendingIntent(R.id.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.f61525a.setOnClickPendingIntent(R.id.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews b() {
        return this.f61525a;
    }

    public void c(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.f61525a.setProgressBar(R.id.download_progress, 100, i, false);
        this.f61525a.setTextViewText(R.id.download_progress_text, str);
    }

    public void d() {
        this.f61525a.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.downloading_app_paused));
        this.f61525a.setImageViewResource(R.id.download_btn, R.drawable.notify_start_bg);
    }

    public void e() {
        this.f61525a.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.f61525a.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
    }
}
