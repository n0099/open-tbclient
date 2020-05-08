package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
/* loaded from: classes8.dex */
public abstract class v implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private File f941a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f942a;

    private v(Context context, File file) {
        this.a = context;
        this.f941a = file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(Context context, File file, w wVar) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        new w(context, file, runnable).run();
    }

    protected abstract void a(Context context);

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // java.lang.Runnable
    public final void run() {
        u uVar = null;
        try {
            try {
                if (this.f941a == null) {
                    this.f941a = new File(this.a.getFilesDir(), "default_locker");
                }
                uVar = u.a(this.a, this.f941a);
                if (this.f942a != null) {
                    this.f942a.run();
                }
                a(this.a);
                if (uVar != null) {
                    uVar.a();
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (uVar != null) {
                    uVar.a();
                }
            }
        } catch (Throwable th) {
            if (uVar != null) {
                uVar.a();
            }
            throw th;
        }
    }
}
