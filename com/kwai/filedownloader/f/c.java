package com.kwai.filedownloader.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwai.filedownloader.exception.PathConflictException;
import com.kwai.filedownloader.x;
import java.io.File;
/* loaded from: classes6.dex */
public class c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f35117a;

    /* loaded from: classes6.dex */
    public interface a {
        int a(int i2, String str, String str2, long j);
    }

    /* loaded from: classes6.dex */
    public interface b {
        com.kwai.filedownloader.a.b a(String str);
    }

    /* renamed from: com.kwai.filedownloader.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0408c {
        com.kwai.filedownloader.b.a a();
    }

    /* loaded from: classes6.dex */
    public interface d {
        int a(int i2, String str, String str2, boolean z);

        int a(String str, String str2, boolean z);
    }

    /* loaded from: classes6.dex */
    public interface e {
        com.kwai.filedownloader.e.a a(File file);

        boolean a();
    }

    public static Context a() {
        return f35117a;
    }

    public static void a(Context context) {
        f35117a = context;
    }

    public static boolean a(int i2, long j, String str, String str2, x xVar) {
        int a2;
        if (str2 == null || str == null || (a2 = xVar.a(str, i2)) == 0) {
            return false;
        }
        com.kwai.filedownloader.message.e.a().a(com.kwai.filedownloader.message.f.a(i2, j, new PathConflictException(a2, str, str2)));
        return true;
    }

    public static boolean a(int i2, com.kwai.filedownloader.d.c cVar, x xVar, boolean z) {
        if (xVar.a(cVar)) {
            com.kwai.filedownloader.message.e.a().a(com.kwai.filedownloader.message.f.a(i2, cVar.g(), cVar.h(), z));
            return true;
        }
        return false;
    }

    public static boolean a(int i2, String str, boolean z, boolean z2) {
        if (!z && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwai.filedownloader.message.e.a().a(com.kwai.filedownloader.message.f.a(i2, file, z2));
                return true;
            }
        }
        return false;
    }
}
