package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public abstract class v implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private File f949a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f950a;

    private v(Context context, File file) {
        this.a = context;
        this.f949a = file;
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
                if (this.f949a == null) {
                    this.f949a = new File(this.a.getFilesDir(), "default_locker");
                }
                uVar = u.a(this.a, this.f949a);
                if (this.f950a != null) {
                    this.f950a.run();
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
