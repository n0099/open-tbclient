package com.win.opensdk;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import com.baidu.down.manage.DownloadConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes14.dex */
public class x implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8179a;
    public final /* synthetic */ ad qkB;

    public x(ad adVar, String str) {
        this.qkB = adVar;
        this.f8179a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f9, code lost:
        if (r1 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ff, code lost:
        if (r1 == null) goto L19;
     */
    @Override // android.content.DialogInterface.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(DialogInterface dialogInterface, int i) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (!this.f8179a.startsWith("data:")) {
            DownloadManager downloadManager = (DownloadManager) this.qkB.qkf.getContext().getSystemService("download");
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f8179a));
            if (this.qkB.qkf.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.qkB.qkf.getContext().getPackageName()) == 0) {
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, this.f8179a.split("/")[this.f8179a.split("/").length - 1]);
                try {
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(1);
                    downloadManager.enqueue(request);
                } catch (IllegalStateException e) {
                }
            }
        } else {
            String str = ".png";
            if (this.f8179a.contains(DownloadConstants.MIMETYPE_GIF)) {
                str = ".gif";
            } else if (this.f8179a.contains("image/jpeg") || this.f8179a.contains("image/pjpeg")) {
                str = ".jpg";
            } else if (this.f8179a.contains("image/png")) {
                str = ".png";
            } else if (this.f8179a.contains("image/tiff")) {
                str = ".tif";
            } else if (this.f8179a.contains("image/svg+xml")) {
                str = ".svg";
            }
            boolean contains = this.f8179a.contains("base64");
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), System.currentTimeMillis() + str);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    if (file.canWrite()) {
                        fileOutputStream.write(!contains ? v.abY(this.f8179a.substring(this.f8179a.lastIndexOf(",") + 1, this.f8179a.length())) : Base64.decode(this.f8179a.substring(this.f8179a.lastIndexOf(",") + 1, this.f8179a.length()), 0));
                    }
                } catch (FileNotFoundException e2) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        fileOutputStream = fileOutputStream2;
                        fileOutputStream.close();
                    }
                    ((e) this.qkB.qkf.getDispatcher()).a((String) null);
                } catch (IOException e3) {
                } catch (IllegalArgumentException e4) {
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                fileOutputStream2 = null;
            } catch (IOException e7) {
                fileOutputStream = null;
            } catch (IllegalArgumentException e8) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.close();
            } catch (IOException e9) {
            }
        }
        ((e) this.qkB.qkf.getDispatcher()).a((String) null);
    }
}
