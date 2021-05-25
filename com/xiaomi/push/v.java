package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f38177a;

    /* renamed from: a  reason: collision with other field name */
    public File f987a;

    /* renamed from: a  reason: collision with other field name */
    public Runnable f988a;

    public v(Context context, File file) {
        this.f38177a = context;
        this.f987a = file;
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
                if (this.f987a == null) {
                    this.f987a = new File(this.f38177a.getFilesDir(), "default_locker");
                }
                uVar = u.a(this.f38177a, this.f987a);
                if (this.f988a != null) {
                    this.f988a.run();
                }
                a(this.f38177a);
                if (uVar == null) {
                    return;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
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
