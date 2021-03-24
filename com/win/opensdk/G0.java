package com.win.opensdk;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public class G0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39669a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ I0 f39670b;

    public G0(I0 i0, String str) {
        this.f39670b = i0;
        this.f39669a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d1, code lost:
        if (r1 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d5, code lost:
        if (r1 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d9, code lost:
        if (r1 == null) goto L22;
     */
    @Override // android.content.DialogInterface.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(DialogInterface dialogInterface, int i) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (this.f39669a.startsWith(WebGLImageLoader.DATA_URL)) {
            boolean contains = this.f39669a.contains("image/gif");
            String str = EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            if (contains) {
                str = ".gif";
            } else if (this.f39669a.contains("image/jpeg") || this.f39669a.contains("image/pjpeg")) {
                str = ".jpg";
            } else if (!this.f39669a.contains("image/png")) {
                if (this.f39669a.contains("image/tiff")) {
                    str = ".tif";
                } else if (this.f39669a.contains("image/svg+xml")) {
                    str = ".svg";
                }
            }
            boolean contains2 = this.f39669a.contains("base64");
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), System.currentTimeMillis() + str);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    if (file.canWrite()) {
                        fileOutputStream.write(!contains2 ? G.f(this.f39669a.substring(this.f39669a.lastIndexOf(",") + 1, this.f39669a.length())) : Base64.decode(this.f39669a.substring(this.f39669a.lastIndexOf(",") + 1, this.f39669a.length()), 0));
                    }
                } catch (FileNotFoundException unused) {
                } catch (IOException unused2) {
                } catch (IllegalArgumentException unused3) {
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused5) {
                fileOutputStream = null;
            } catch (IOException unused6) {
                fileOutputStream = null;
            } catch (IllegalArgumentException unused7) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                fileOutputStream.close();
            } catch (IOException | IllegalStateException unused8) {
            }
        } else {
            DownloadManager downloadManager = (DownloadManager) this.f39670b.f39678a.getContext().getSystemService("download");
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f39669a));
            if (this.f39670b.f39678a.getContext().getPackageManager().checkPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, this.f39670b.f39678a.getContext().getPackageName()) == 0) {
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, this.f39669a.split("/")[this.f39669a.split("/").length - 1]);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                downloadManager.enqueue(request);
            }
        }
        ((A0) this.f39670b.f39678a.getDispatcher()).a((String) null);
    }
}
