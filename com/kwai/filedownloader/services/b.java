package com.kwai.filedownloader.services;

import com.kwai.filedownloader.f.c;
/* loaded from: classes4.dex */
public class b implements c.d {
    @Override // com.kwai.filedownloader.f.c.d
    public int a(int i, String str, String str2, boolean z) {
        return a(str, str2, z);
    }

    @Override // com.kwai.filedownloader.f.c.d
    public int a(String str, String str2, boolean z) {
        return z ? com.kwai.filedownloader.f.f.e(com.kwai.filedownloader.f.f.a("%sp%s@dir", str, str2)).hashCode() : com.kwai.filedownloader.f.f.e(com.kwai.filedownloader.f.f.a("%sp%s", str, str2)).hashCode();
    }
}
