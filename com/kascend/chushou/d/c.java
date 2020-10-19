package com.kascend.chushou.d;

import android.app.Application;
import android.os.Environment;
import java.io.File;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes6.dex */
public final class c {
    public static final c oha = new c();

    private c() {
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        Application etB = tv.chushou.basis.d.b.etB();
        q.m(etB, "Router.application()");
        File filesDir = etB.getFilesDir();
        q.m(filesDir, "Router.application().filesDir");
        return sb.append(filesDir.getAbsolutePath()).append("/plugin/").toString();
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        Application etB = tv.chushou.basis.d.b.etB();
        q.m(etB, "Router.application()");
        File filesDir = etB.getFilesDir();
        q.m(filesDir, "Router.application().filesDir");
        return sb.append(filesDir.getAbsolutePath()).append("/svga/").toString();
    }

    public final File c() {
        File externalFilesDir = tv.chushou.basis.d.b.etB().getExternalFilesDir("cstv_imagecache");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application etB = tv.chushou.basis.d.b.etB();
            q.m(etB, "Router.application()");
            File file = new File(etB.getCacheDir(), "cstv_imagecache");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File egg() {
        File externalFilesDir = tv.chushou.basis.d.b.etB().getExternalFilesDir("cstv_download");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application etB = tv.chushou.basis.d.b.etB();
            q.m(etB, "Router.application()");
            File file = new File(etB.getCacheDir(), "cstv_download");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File e() {
        File externalFilesDir = tv.chushou.basis.d.b.etB().getExternalFilesDir("cstv_ninepatch");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdirs())) {
            Application etB = tv.chushou.basis.d.b.etB();
            q.m(etB, "Router.application()");
            File file = new File(etB.getCacheDir(), "cstv_ninepatch");
            file.mkdirs();
            return file;
        }
        return externalFilesDir;
    }

    public final File egh() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        q.m(externalStoragePublicDirectory, "Environment.getExternalS…nment.DIRECTORY_PICTURES)");
        return externalStoragePublicDirectory;
    }
}
