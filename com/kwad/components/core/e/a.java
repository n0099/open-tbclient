package com.kwad.components.core.e;

import android.content.Context;
import com.baidu.nps.utils.Constant;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: com.kwad.components.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0650a {
        public static final a Ez = new a((byte) 0);
    }

    public a() {
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j) {
        File[] listFiles = ak(context).listFiles(new FileFilter() { // from class: com.kwad.components.core.e.a.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                String name = file.getName();
                return name.startsWith("dynamic-") && name.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        long j2 = 0;
        for (File file : listFiles) {
            j2 = Math.max(j2, file.lastModified());
        }
        long min = Math.min(j, j2);
        for (File file2 : listFiles) {
            if (file2.exists() && file2.lastModified() < min) {
                file2.delete();
            }
        }
    }

    private void aj(final Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        g.schedule(new Runnable() { // from class: com.kwad.components.core.e.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(context, currentTimeMillis);
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    public static File ak(Context context) {
        return new File(context.getApplicationInfo().dataDir, "ksad_dynamic");
    }

    public static a ng() {
        return C0650a.Ez;
    }

    public final void init(Context context) {
        aj(context);
    }
}
