package d.b.i0.r2.x;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.RecAppDownloadReceiver;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final RemoteViews f59934a = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), R.layout.download_notify_view);

    /* loaded from: classes5.dex */
    public class a extends d.b.b.e.l.c<d.b.b.j.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            if (k.this.f59934a == null || aVar == null || aVar.p() == null) {
                return;
            }
            k.this.f59934a.setImageViewBitmap(R.id.app_icon, aVar.p());
        }
    }

    public k(DownloadData downloadData, int i) {
        c(i);
        this.f59934a.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.f59934a.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
        this.f59934a.setImageViewResource(R.id.download_cancel, R.drawable.notify_cancel_bg);
        this.f59934a.setTextViewText(R.id.downapp_name, downloadData.getUser_name());
        d.b.b.e.l.d.h().m(downloadData.getApp_icon(), 17, new a(), BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.f59934a.setOnClickPendingIntent(R.id.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.f59934a.setOnClickPendingIntent(R.id.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews b() {
        return this.f59934a;
    }

    public void c(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.f59934a.setProgressBar(R.id.download_progress, 100, i, false);
        this.f59934a.setTextViewText(R.id.download_progress_text, str);
    }

    public void d() {
        this.f59934a.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.downloading_app_paused));
        this.f59934a.setImageViewResource(R.id.download_btn, R.drawable.notify_start_bg);
    }

    public void e() {
        this.f59934a.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.f59934a.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
    }
}
