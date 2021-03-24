package com.kwai.filedownloader.a;

import com.baidu.searchbox.bddownload.core.download.DownloadStrategy;
import com.kwai.filedownloader.f.c;
/* loaded from: classes6.dex */
public class a implements c.a {
    @Override // com.kwai.filedownloader.f.c.a
    public int a(int i, String str, String str2, long j) {
        if (j < 1048576) {
            return 1;
        }
        if (j < 5242880) {
            return 2;
        }
        if (j < 52428800) {
            return 3;
        }
        return j < DownloadStrategy.FOUR_CONNECTION_UPPER_LIMIT ? 4 : 5;
    }
}
