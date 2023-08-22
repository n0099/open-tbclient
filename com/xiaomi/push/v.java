package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public abstract class v implements Runnable {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public File f1019a;

    /* renamed from: a  reason: collision with other field name */
    public Runnable f1020a;

    public v(Context context, File file) {
        this.a = context;
        this.f1019a = file;
    }

    public /* synthetic */ v(Context context, File file, w wVar) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        new w(context, file, runnable).run();
    }

    public abstract void a(Context context);

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // java.lang.Runnable
    public final void run() {
        u uVar = null;
        try {
            try {
                if (this.f1019a == null) {
                    this.f1019a = new File(this.a.getFilesDir(), "default_locker");
                }
                uVar = u.a(this.a, this.f1019a);
                if (this.f1020a != null) {
                    this.f1020a.run();
                }
                a(this.a);
                if (uVar == null) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (uVar == null) {
                    return;
                }
            }
            uVar.a();
        } catch (Throwable th) {
            if (uVar != null) {
                uVar.a();
            }
            throw th;
        }
    }
}
