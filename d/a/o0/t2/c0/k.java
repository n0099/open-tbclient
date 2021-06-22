package d.a.o0.t2.c0;

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
    public final RemoteViews f64785a = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), R.layout.download_notify_view);

    /* loaded from: classes5.dex */
    public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            if (k.this.f64785a == null || aVar == null || aVar.p() == null) {
                return;
            }
            k.this.f64785a.setImageViewBitmap(R.id.app_icon, aVar.p());
        }
    }

    public k(DownloadData downloadData, int i2) {
        c(i2);
        this.f64785a.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.f64785a.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
        this.f64785a.setImageViewResource(R.id.download_cancel, R.drawable.notify_cancel_bg);
        this.f64785a.setTextViewText(R.id.downapp_name, downloadData.getUser_name());
        d.a.c.e.l.d.h().m(downloadData.getApp_icon(), 17, new a(), BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.f64785a.setOnClickPendingIntent(R.id.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.f64785a.setOnClickPendingIntent(R.id.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews b() {
        return this.f64785a;
    }

    public void c(int i2) {
        String str;
        if (i2 > 0) {
            str = i2 + "%";
        } else {
            str = "0%";
        }
        this.f64785a.setProgressBar(R.id.download_progress, 100, i2, false);
        this.f64785a.setTextViewText(R.id.download_progress_text, str);
    }

    public void d() {
        this.f64785a.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.downloading_app_paused));
        this.f64785a.setImageViewResource(R.id.download_btn, R.drawable.notify_start_bg);
    }

    public void e() {
        this.f64785a.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.f64785a.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
    }
}
