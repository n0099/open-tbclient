package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class v implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private File f953a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f954a;

    private v(Context context, File file) {
        this.a = context;
        this.f953a = file;
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
                if (this.f953a == null) {
                    this.f953a = new File(this.a.getFilesDir(), "default_locker");
                }
                uVar = u.a(this.a, this.f953a);
                if (this.f954a != null) {
                    this.f954a.run();
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
