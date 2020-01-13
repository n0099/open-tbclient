package com.kascend.chushou.d;

import android.app.Application;
import android.os.Environment;
import java.io.File;
import kotlin.jvm.internal.q;
/* loaded from: classes4.dex */
public final class c {
    public static final c mOp = new c();

    private c() {
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        Application dOC = tv.chushou.basis.d.b.dOC();
        q.i(dOC, "Router.application()");
        File filesDir = dOC.getFilesDir();
        q.i(filesDir, "Router.application().filesDir");
        return sb.append(filesDir.getAbsolutePath()).append("/plugin/").toString();
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        Application dOC = tv.chushou.basis.d.b.dOC();
        q.i(dOC, "Router.application()");
        File filesDir = dOC.getFilesDir();
        q.i(filesDir, "Router.application().filesDir");
        return sb.append(filesDir.getAbsolutePath()).append("/svga/").toString();
    }

    public final File c() {
        File externalFilesDir = tv.chushou.basis.d.b.dOC().getExternalFilesDir("cstv_imagecache");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application dOC = tv.chushou.basis.d.b.dOC();
            q.i(dOC, "Router.application()");
            File file = new File(dOC.getCacheDir(), "cstv_imagecache");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File dAH() {
        File externalFilesDir = tv.chushou.basis.d.b.dOC().getExternalFilesDir("cstv_download");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application dOC = tv.chushou.basis.d.b.dOC();
            q.i(dOC, "Router.application()");
            File file = new File(dOC.getCacheDir(), "cstv_download");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File e() {
        File externalFilesDir = tv.chushou.basis.d.b.dOC().getExternalFilesDir("cstv_ninepatch");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application dOC = tv.chushou.basis.d.b.dOC();
            q.i(dOC, "Router.application()");
            File file = new File(dOC.getCacheDir(), "cstv_ninepatch");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File dAI() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        q.i(externalStoragePublicDirectory, "Environment.getExternalS…nment.DIRECTORY_PICTURES)");
        return externalStoragePublicDirectory;
    }
}
