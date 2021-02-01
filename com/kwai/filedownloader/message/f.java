package com.kwai.filedownloader.message;

import com.kwai.filedownloader.download.d;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.a;
import com.kwai.filedownloader.message.d;
import com.kwai.filedownloader.message.h;
import java.io.File;
/* loaded from: classes3.dex */
public class f {
    public static MessageSnapshot a(byte b2, com.kwai.filedownloader.d.c cVar, d.a aVar) {
        int a2 = cVar.a();
        if (b2 == -4) {
            throw new IllegalStateException(com.kwai.filedownloader.f.f.a("please use #catchWarn instead %d", Integer.valueOf(a2)));
        }
        switch (b2) {
            case -3:
                return cVar.q() ? new d.b(a2, false, cVar.h()) : new h.b(a2, false, (int) cVar.h());
            case -2:
            case 0:
            case 4:
            default:
                String a3 = com.kwai.filedownloader.f.f.a("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b2));
                com.kwai.filedownloader.f.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b2));
                IllegalStateException illegalStateException = aVar.b() != null ? new IllegalStateException(a3, aVar.b()) : new IllegalStateException(a3);
                return cVar.q() ? new d.C1161d(a2, cVar.g(), illegalStateException) : new h.d(a2, (int) cVar.g(), illegalStateException);
            case -1:
                return cVar.q() ? new d.C1161d(a2, cVar.g(), aVar.b()) : new h.d(a2, (int) cVar.g(), aVar.b());
            case 1:
                return cVar.q() ? new d.f(a2, cVar.g(), cVar.h()) : new h.f(a2, (int) cVar.g(), (int) cVar.h());
            case 2:
                String m = cVar.l() ? cVar.m() : null;
                return cVar.q() ? new d.c(a2, aVar.a(), cVar.h(), cVar.j(), m) : new h.c(a2, aVar.a(), (int) cVar.h(), cVar.j(), m);
            case 3:
                return cVar.q() ? new d.g(a2, cVar.g()) : new h.g(a2, (int) cVar.g());
            case 5:
                return cVar.q() ? new d.h(a2, cVar.g(), aVar.b(), aVar.c()) : new h.C1162h(a2, (int) cVar.g(), aVar.b(), aVar.c());
            case 6:
                return new MessageSnapshot.b(a2);
        }
    }

    public static MessageSnapshot a(int i, long j, long j2, boolean z) {
        return j2 > 2147483647L ? z ? new d.i(i, j, j2) : new d.j(i, j, j2) : z ? new h.i(i, (int) j, (int) j2) : new h.j(i, (int) j, (int) j2);
    }

    public static MessageSnapshot a(int i, long j, Throwable th) {
        return j > 2147483647L ? new d.C1161d(i, j, th) : new h.d(i, (int) j, th);
    }

    public static MessageSnapshot a(int i, File file, boolean z) {
        long length = file.length();
        return length > 2147483647L ? z ? new d.a(i, true, length) : new d.b(i, true, length) : z ? new h.a(i, true, (int) length) : new h.b(i, true, (int) length);
    }

    public static MessageSnapshot a(com.kwai.filedownloader.a aVar) {
        return aVar.D() ? new d.e(aVar.h(), aVar.r(), aVar.t()) : new h.e(aVar.h(), aVar.q(), aVar.s());
    }

    public static MessageSnapshot a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.b() != -3) {
            throw new IllegalStateException(com.kwai.filedownloader.f.f.a("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b())));
        }
        return new a.C1160a(messageSnapshot);
    }
}
