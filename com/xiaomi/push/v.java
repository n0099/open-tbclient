package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f14329a;

    /* renamed from: a  reason: collision with other field name */
    private File f1021a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f1022a;

    private v(Context context, File file) {
        this.f14329a = context;
        this.f1021a = file;
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
                if (this.f1021a == null) {
                    this.f1021a = new File(this.f14329a.getFilesDir(), "default_locker");
                }
                uVar = u.a(this.f14329a, this.f1021a);
                if (this.f1022a != null) {
                    this.f1022a.run();
                }
                a(this.f14329a);
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
