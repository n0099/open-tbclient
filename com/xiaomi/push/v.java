package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
/* loaded from: classes12.dex */
public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f5124a;

    /* renamed from: a  reason: collision with other field name */
    private File f940a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f941a;

    private v(Context context, File file) {
        this.f5124a = context;
        this.f940a = file;
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
                if (this.f940a == null) {
                    this.f940a = new File(this.f5124a.getFilesDir(), "default_locker");
                }
                uVar = u.a(this.f5124a, this.f940a);
                if (this.f941a != null) {
                    this.f941a.run();
                }
                a(this.f5124a);
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
