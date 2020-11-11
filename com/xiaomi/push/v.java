package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
/* loaded from: classes12.dex */
public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f5126a;

    /* renamed from: a  reason: collision with other field name */
    private File f942a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f943a;

    private v(Context context, File file) {
        this.f5126a = context;
        this.f942a = file;
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
                if (this.f942a == null) {
                    this.f942a = new File(this.f5126a.getFilesDir(), "default_locker");
                }
                uVar = u.a(this.f5126a, this.f942a);
                if (this.f943a != null) {
                    this.f943a.run();
                }
                a(this.f5126a);
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
