package com.kwad.framework.filedownloader.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.framework.filedownloader.exception.PathConflictException;
import com.kwad.framework.filedownloader.y;
import java.io.File;
/* loaded from: classes10.dex */
public final class c {
    @SuppressLint({"StaticFieldLeak"})
    public static Context ahV;

    /* loaded from: classes10.dex */
    public interface a {
        int K(long j);
    }

    /* loaded from: classes10.dex */
    public interface b {
        com.kwad.framework.filedownloader.a.b aX(String str);
    }

    /* renamed from: com.kwad.framework.filedownloader.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0683c {
        com.kwad.framework.filedownloader.b.a wC();
    }

    /* loaded from: classes10.dex */
    public interface d {
        int f(String str, String str2, boolean z);

        int g(String str, String str2, boolean z);
    }

    /* loaded from: classes10.dex */
    public interface e {
        com.kwad.framework.filedownloader.e.a c(File file);
    }

    public static boolean a(int i, long j, String str, String str2, y yVar) {
        int p;
        if (str2 != null && str != null && (p = yVar.p(str, i)) != 0) {
            com.kwad.framework.filedownloader.message.e.vV().s(com.kwad.framework.filedownloader.message.f.a(i, j, new PathConflictException(p, str, str2)));
            return true;
        }
        return false;
    }

    public static boolean a(int i, com.kwad.framework.filedownloader.d.c cVar, y yVar, boolean z) {
        if (yVar.a(cVar)) {
            com.kwad.framework.filedownloader.message.e.vV().s(com.kwad.framework.filedownloader.message.f.a(i, cVar.wb(), cVar.getTotal(), z));
            return true;
        }
        return false;
    }

    public static boolean a(int i, String str, boolean z, boolean z2) {
        if (!z && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwad.framework.filedownloader.message.e.vV().s(com.kwad.framework.filedownloader.message.f.a(i, file, z2));
                return true;
            }
        }
        return false;
    }

    public static void am(Context context) {
        ahV = context;
    }

    public static Context wB() {
        return ahV;
    }
}
