package d.b.g0.a.b1.d.c;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import java.io.File;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements ActivityResultConsumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.d.d.b f43421a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f43422b;

        public a(d.b.g0.a.b1.d.d.b bVar, File file) {
            this.f43421a = bVar;
            this.f43422b = file;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            d.b.g0.a.b1.d.d.b bVar;
            if (i != -1 || (bVar = this.f43421a) == null) {
                return true;
            }
            bVar.a(this.f43422b);
            return true;
        }
    }

    /* renamed from: d.b.g0.a.b1.d.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0607b implements ActivityResultConsumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.d.d.b f43423a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f43424b;

        public C0607b(d.b.g0.a.b1.d.d.b bVar, File file) {
            this.f43423a = bVar;
            this.f43424b = file;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            d.b.g0.a.b1.d.d.b bVar;
            if (i != -1 || (bVar = this.f43423a) == null) {
                return true;
            }
            bVar.a(this.f43424b);
            return true;
        }
    }

    public static File a(@NonNull String str) {
        String h2 = d.b.g0.a.a2.b.h(str);
        File file = new File(h2 + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg");
        d.b.g0.p.d.e(file);
        return file;
    }

    public static File b(@NonNull String str) {
        String h2 = d.b.g0.a.a2.b.h(str);
        File file = new File(h2 + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4");
        d.b.g0.p.d.e(file);
        return file;
    }

    public static VideoModel c(File file) {
        MediaMetadataRetriever mediaMetadataRetriever;
        String absolutePath = file.getAbsolutePath();
        VideoModel videoModel = new VideoModel(absolutePath);
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            mediaMetadataRetriever.setDataSource(absolutePath);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
            videoModel.o(Integer.parseInt(extractMetadata));
            videoModel.n(Integer.parseInt(extractMetadata2));
            videoModel.m(Long.parseLong(extractMetadata3));
            videoModel.g(file.length());
            mediaMetadataRetriever.release();
        } catch (Exception e3) {
            e = e3;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            if (c.f43425a) {
                e.printStackTrace();
            }
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
            }
            return videoModel;
        } catch (Throwable th2) {
            th = th2;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
            }
            throw th;
        }
        return videoModel;
    }

    public static boolean d() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (1 == cameraInfo.facing) {
                return true;
            }
        }
        return false;
    }

    public static void e(Activity activity, String str, int i, boolean z, d.b.g0.a.b1.d.d.b bVar) {
        Uri fromFile;
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) activity).getResultDispatcher();
        if (resultDispatcher == null) {
            return;
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        File b2 = b(str);
        if (d.b.g0.a.i2.c.i()) {
            fromFile = FileProvider.getUriForFile(activity, activity.getPackageName() + ".swan.fileprovider", b2);
            intent.setFlags(3);
        } else {
            fromFile = Uri.fromFile(b2);
        }
        intent.putExtra("output", fromFile);
        intent.putExtra("android.intent.extra.durationLimit", i);
        intent.putExtra("android.intent.extra.videoQuality", 1);
        if (z && d()) {
            if (d.b.g0.a.i2.c.g()) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            } else {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
            }
        }
        resultDispatcher.addConsumer(new C0607b(bVar, b2));
        resultDispatcher.startActivityForResult(intent);
    }

    public static void f(Activity activity, String str, d.b.g0.a.b1.d.d.b bVar) {
        Uri fromFile;
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) activity).getResultDispatcher();
        if (resultDispatcher == null) {
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            File a2 = a(str);
            if (a2 == null || !a2.exists()) {
                if (bVar != null) {
                    bVar.b("error create file");
                    return;
                }
                return;
            }
            if (d.b.g0.a.i2.c.i()) {
                fromFile = FileProvider.getUriForFile(activity, activity.getPackageName() + ".swan.fileprovider", a2);
                intent.setFlags(3);
            } else {
                fromFile = Uri.fromFile(a2);
            }
            intent.putExtra("output", fromFile);
            resultDispatcher.addConsumer(new a(bVar, a2));
            resultDispatcher.startActivityForResult(intent);
        }
    }
}
