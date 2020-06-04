package com.kascend.chushou.d;

import android.app.Application;
import android.os.Environment;
import java.io.File;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes5.dex */
public final class c {
    public static final c mIR = new c();

    private c() {
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        Application dRy = tv.chushou.basis.d.b.dRy();
        q.l((Object) dRy, "Router.application()");
        File filesDir = dRy.getFilesDir();
        q.l((Object) filesDir, "Router.application().filesDir");
        return sb.append(filesDir.getAbsolutePath()).append("/plugin/").toString();
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        Application dRy = tv.chushou.basis.d.b.dRy();
        q.l((Object) dRy, "Router.application()");
        File filesDir = dRy.getFilesDir();
        q.l((Object) filesDir, "Router.application().filesDir");
        return sb.append(filesDir.getAbsolutePath()).append("/svga/").toString();
    }

    public final File c() {
        File externalFilesDir = tv.chushou.basis.d.b.dRy().getExternalFilesDir("cstv_imagecache");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application dRy = tv.chushou.basis.d.b.dRy();
            q.l((Object) dRy, "Router.application()");
            File file = new File(dRy.getCacheDir(), "cstv_imagecache");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File dEk() {
        File externalFilesDir = tv.chushou.basis.d.b.dRy().getExternalFilesDir("cstv_download");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application dRy = tv.chushou.basis.d.b.dRy();
            q.l((Object) dRy, "Router.application()");
            File file = new File(dRy.getCacheDir(), "cstv_download");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File e() {
        File externalFilesDir = tv.chushou.basis.d.b.dRy().getExternalFilesDir("cstv_ninepatch");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application dRy = tv.chushou.basis.d.b.dRy();
            q.l((Object) dRy, "Router.application()");
            File file = new File(dRy.getCacheDir(), "cstv_ninepatch");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File dEl() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        q.l((Object) externalStoragePublicDirectory, "Environment.getExternalS…nment.DIRECTORY_PICTURES)");
        return externalStoragePublicDirectory;
    }
}
