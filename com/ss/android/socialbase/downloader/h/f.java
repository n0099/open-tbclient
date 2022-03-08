package com.ss.android.socialbase.downloader.h;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.i;
/* loaded from: classes8.dex */
public interface f {
    com.ss.android.socialbase.downloader.exception.h a(BaseException baseException, long j2);

    com.ss.android.socialbase.downloader.exception.h a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, long j2);

    com.ss.android.socialbase.downloader.model.b a(int i2);

    void a(long j2) throws BaseException;

    void a(BaseException baseException, boolean z);

    void a(b bVar);

    void a(com.ss.android.socialbase.downloader.network.g gVar);

    void a(String str, com.ss.android.socialbase.downloader.network.g gVar, long j2) throws BaseException, i;

    boolean a(BaseException baseException);

    void b(BaseException baseException);

    boolean b(long j2) throws BaseException;

    void c(BaseException baseException);
}
