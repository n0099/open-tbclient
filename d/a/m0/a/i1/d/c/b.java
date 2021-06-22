package d.a.m0.a.i1.d.c;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import d.a.m0.a.v2.s0;
import java.io.File;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements ActivityResultConsumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.i1.d.d.b f46643a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f46644b;

        public a(d.a.m0.a.i1.d.d.b bVar, File file) {
            this.f46643a = bVar;
            this.f46644b = file;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            d.a.m0.a.i1.d.d.b bVar;
            if (i2 != -1 || (bVar = this.f46643a) == null) {
                return true;
            }
            bVar.a(this.f46644b);
            return true;
        }
    }

    /* renamed from: d.a.m0.a.i1.d.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0771b implements ActivityResultConsumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.i1.d.d.b f46645a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f46646b;

        public C0771b(d.a.m0.a.i1.d.d.b bVar, File file) {
            this.f46645a = bVar;
            this.f46646b = file;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            d.a.m0.a.i1.d.d.b bVar;
            if (i2 != -1 || (bVar = this.f46645a) == null) {
                return true;
            }
            bVar.a(this.f46646b);
            return true;
        }
    }

    public static File a(@NonNull String str) {
        String x = d.a.m0.a.k2.b.x(str);
        File file = new File(x + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg");
        d.a.m0.t.d.h(file);
        return file;
    }

    public static File b(@NonNull String str) {
        String x = d.a.m0.a.k2.b.x(str);
        File file = new File(x + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4");
        d.a.m0.t.d.h(file);
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
            if (c.f46647a) {
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
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (1 == cameraInfo.facing) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int, boolean] */
    public static void e(Activity activity, String str, int i2, boolean z, d.a.m0.a.i1.d.d.b bVar) {
        Uri fromFile;
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) activity).getResultDispatcher();
        if (resultDispatcher == null) {
            return;
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        File b2 = b(str);
        if (d.a.m0.a.v2.d.i()) {
            fromFile = s0.a(activity, b2);
            intent.setFlags(3);
        } else {
            fromFile = Uri.fromFile(b2);
        }
        intent.putExtra("output", fromFile);
        intent.putExtra("android.intent.extra.durationLimit", i2);
        ?? r5 = 1;
        intent.putExtra("android.intent.extra.videoQuality", 1);
        r5 = (z && d()) ? 0 : 0;
        if (d.a.m0.a.v2.d.g()) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", (int) r5);
            intent.putExtra("android.intent.extras.LENS_FACING_FRONT", (int) r5);
            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", (boolean) r5);
        } else {
            intent.putExtra("android.intent.extras.CAMERA_FACING", (int) r5);
        }
        resultDispatcher.addConsumer(new C0771b(bVar, b2));
        resultDispatcher.startActivityForResult(intent);
    }

    public static void f(Activity activity, String str, d.a.m0.a.i1.d.d.b bVar) {
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
            if (d.a.m0.a.v2.d.i()) {
                fromFile = s0.a(activity, a2);
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
