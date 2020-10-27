package com.kascend.chushou.d;

import android.app.Application;
import android.os.Environment;
import java.io.File;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes6.dex */
public final class c {
    public static final c oYp = new c();

    private c() {
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        Application eDz = tv.chushou.basis.d.b.eDz();
        q.m(eDz, "Router.application()");
        File filesDir = eDz.getFilesDir();
        q.m(filesDir, "Router.application().filesDir");
        return sb.append(filesDir.getAbsolutePath()).append("/plugin/").toString();
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        Application eDz = tv.chushou.basis.d.b.eDz();
        q.m(eDz, "Router.application()");
        File filesDir = eDz.getFilesDir();
        q.m(filesDir, "Router.application().filesDir");
        return sb.append(filesDir.getAbsolutePath()).append("/svga/").toString();
    }

    public final File c() {
        File externalFilesDir = tv.chushou.basis.d.b.eDz().getExternalFilesDir("cstv_imagecache");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application eDz = tv.chushou.basis.d.b.eDz();
            q.m(eDz, "Router.application()");
            File file = new File(eDz.getCacheDir(), "cstv_imagecache");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File eqg() {
        File externalFilesDir = tv.chushou.basis.d.b.eDz().getExternalFilesDir("cstv_download");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application eDz = tv.chushou.basis.d.b.eDz();
            q.m(eDz, "Router.application()");
            File file = new File(eDz.getCacheDir(), "cstv_download");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File e() {
        File externalFilesDir = tv.chushou.basis.d.b.eDz().getExternalFilesDir("cstv_ninepatch");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application eDz = tv.chushou.basis.d.b.eDz();
            q.m(eDz, "Router.application()");
            File file = new File(eDz.getCacheDir(), "cstv_ninepatch");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File eqh() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        q.m(externalStoragePublicDirectory, "Environment.getExternalS…nment.DIRECTORY_PICTURES)");
        return externalStoragePublicDirectory;
    }
}
