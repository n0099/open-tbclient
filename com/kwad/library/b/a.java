package com.kwad.library.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.library.b.a.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.h;
import com.kwad.sdk.utils.q;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public final class a extends h {
    public b ail;
    public Resources aim;

    public a(String str) {
        super(str);
    }

    private File d(File file) {
        File file2 = new File(file.getParentFile(), this.aiI.xq());
        q.X(file2);
        return file2;
    }

    private b a(File file, File file2) {
        if (Build.VERSION.SDK_INT < 26) {
            if (!file.canRead()) {
                file.setReadable(true);
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            if (!file.canRead() || !file.canWrite()) {
                file = null;
            }
        }
        File file3 = file;
        com.kwad.library.b.a.a aVar = new com.kwad.library.b.a.a((BaseDexClassLoader) a.class.getClassLoader());
        String absolutePath = file2.getAbsolutePath();
        String absolutePath2 = this.ajc.getAbsolutePath();
        com.kwad.library.solder.lib.c.b bVar = this.aji;
        return new b(aVar, absolutePath, file3, absolutePath2, bVar.ajU, bVar.ajT);
    }

    @Override // com.kwad.library.solder.lib.h, com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public final void g(Context context, String str) {
        super.g(context, str);
        File file = new File(str);
        try {
            this.ail = a(d(file), file);
            try {
                this.aim = com.kwad.library.b.b.a.a(context, context.getResources(), str);
                StringBuilder sb = new StringBuilder("Install plugin mClassLoader: ");
                sb.append(this.ail);
                sb.append(", mResources: ");
                sb.append(this.aim);
            } catch (Exception e) {
                Log.getStackTraceString(e);
                throw new PluginError.LoadError(e, 4006);
            }
        } catch (IOException e2) {
            throw new PluginError.LoadError(e2, 4002);
        }
    }

    public final Resources getResources() {
        return this.aim;
    }

    public final b wK() {
        return this.ail;
    }
}
