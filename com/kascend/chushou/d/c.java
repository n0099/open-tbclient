package com.kascend.chushou.d;

import android.app.Application;
import android.os.Environment;
import java.io.File;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes6.dex */
public final class c {
    public static final c nRI = new c();

    private c() {
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        Application epQ = tv.chushou.basis.d.b.epQ();
        q.l((Object) epQ, "Router.application()");
        File filesDir = epQ.getFilesDir();
        q.l((Object) filesDir, "Router.application().filesDir");
        return sb.append(filesDir.getAbsolutePath()).append("/plugin/").toString();
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        Application epQ = tv.chushou.basis.d.b.epQ();
        q.l((Object) epQ, "Router.application()");
        File filesDir = epQ.getFilesDir();
        q.l((Object) filesDir, "Router.application().filesDir");
        return sb.append(filesDir.getAbsolutePath()).append("/svga/").toString();
    }

    public final File c() {
        File externalFilesDir = tv.chushou.basis.d.b.epQ().getExternalFilesDir("cstv_imagecache");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application epQ = tv.chushou.basis.d.b.epQ();
            q.l((Object) epQ, "Router.application()");
            File file = new File(epQ.getCacheDir(), "cstv_imagecache");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File ecv() {
        File externalFilesDir = tv.chushou.basis.d.b.epQ().getExternalFilesDir("cstv_download");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application epQ = tv.chushou.basis.d.b.epQ();
            q.l((Object) epQ, "Router.application()");
            File file = new File(epQ.getCacheDir(), "cstv_download");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File e() {
        File externalFilesDir = tv.chushou.basis.d.b.epQ().getExternalFilesDir("cstv_ninepatch");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application epQ = tv.chushou.basis.d.b.epQ();
            q.l((Object) epQ, "Router.application()");
            File file = new File(epQ.getCacheDir(), "cstv_ninepatch");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File ecw() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        q.l((Object) externalStoragePublicDirectory, "Environment.getExternalS…nment.DIRECTORY_PICTURES)");
        return externalStoragePublicDirectory;
    }
}
