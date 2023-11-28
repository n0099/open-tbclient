package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.download.d;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.a;
import com.kwad.framework.filedownloader.message.d;
import com.kwad.framework.filedownloader.message.h;
import java.io.File;
/* loaded from: classes10.dex */
public class f {
    public static MessageSnapshot a(byte b, com.kwad.framework.filedownloader.d.c cVar, d.a aVar) {
        MessageSnapshot dVar;
        String str;
        IllegalStateException illegalStateException;
        int id = cVar.getId();
        if (b != -4) {
            if (b != -3) {
                if (b != -1) {
                    if (b != 1) {
                        if (b != 2) {
                            if (b != 3) {
                                if (b != 5) {
                                    if (b != 6) {
                                        String b2 = com.kwad.framework.filedownloader.f.f.b("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                                        com.kwad.framework.filedownloader.f.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                                        if (aVar.getException() != null) {
                                            illegalStateException = new IllegalStateException(b2, aVar.getException());
                                        } else {
                                            illegalStateException = new IllegalStateException(b2);
                                        }
                                        if (cVar.tR()) {
                                            return new d.C0685d(id, cVar.wb(), illegalStateException);
                                        }
                                        return new h.d(id, (int) cVar.wb(), illegalStateException);
                                    }
                                    return new MessageSnapshot.b(id);
                                } else if (cVar.tR()) {
                                    dVar = new d.h(id, cVar.wb(), aVar.getException(), aVar.tP());
                                } else {
                                    dVar = new h.C0686h(id, (int) cVar.wb(), aVar.getException(), aVar.tP());
                                }
                            } else if (cVar.tR()) {
                                return new d.g(id, cVar.wb());
                            } else {
                                return new h.g(id, (int) cVar.wb());
                            }
                        } else {
                            if (cVar.tH()) {
                                str = cVar.getFilename();
                            } else {
                                str = null;
                            }
                            if (cVar.tR()) {
                                return new d.c(id, aVar.vG(), cVar.getTotal(), cVar.wc(), str);
                            }
                            return new h.c(id, aVar.vG(), (int) cVar.getTotal(), cVar.wc(), str);
                        }
                    } else if (cVar.tR()) {
                        return new d.f(id, cVar.wb(), cVar.getTotal());
                    } else {
                        return new h.f(id, (int) cVar.wb(), (int) cVar.getTotal());
                    }
                } else if (cVar.tR()) {
                    dVar = new d.C0685d(id, cVar.wb(), aVar.getException());
                } else {
                    dVar = new h.d(id, (int) cVar.wb(), aVar.getException());
                }
                return dVar;
            } else if (cVar.tR()) {
                return new d.b(id, false, cVar.getTotal());
            } else {
                return new h.b(id, false, (int) cVar.getTotal());
            }
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("please use #catchWarn instead %d", Integer.valueOf(id)));
    }

    public static MessageSnapshot a(int i, long j, long j2, boolean z) {
        if (j2 > 2147483647L) {
            if (z) {
                return new d.i(i, j, j2);
            }
            return new d.j(i, j, j2);
        } else if (z) {
            return new h.i(i, (int) j, (int) j2);
        } else {
            return new h.j(i, (int) j, (int) j2);
        }
    }

    public static MessageSnapshot a(int i, long j, Throwable th) {
        if (j > 2147483647L) {
            return new d.C0685d(i, j, th);
        }
        return new h.d(i, (int) j, th);
    }

    public static MessageSnapshot a(int i, File file, boolean z) {
        long length = file.length();
        if (length > 2147483647L) {
            if (z) {
                return new d.a(i, true, length);
            }
            return new d.b(i, true, length);
        } else if (z) {
            return new h.a(i, true, (int) length);
        } else {
            return new h.b(i, true, (int) length);
        }
    }

    public static MessageSnapshot e(com.kwad.framework.filedownloader.a aVar) {
        if (aVar.tR()) {
            return new d.e(aVar.getId(), aVar.tJ(), aVar.tK());
        }
        return new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.tL() == -3) {
            return new a.C0684a(messageSnapshot);
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.tL())));
    }
}
