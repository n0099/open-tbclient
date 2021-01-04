package com.kwai.filedownloader.a;

import com.baidu.live.tbadk.img.ImageUploadStrategy;
import com.baidu.mobstat.Config;
import com.kwai.filedownloader.f.c;
/* loaded from: classes5.dex */
public class a implements c.a {
    @Override // com.kwai.filedownloader.f.c.a
    public int a(int i, String str, String str2, long j) {
        if (j < 1048576) {
            return 1;
        }
        if (j < ImageUploadStrategy.FILE_SIZE_5M) {
            return 2;
        }
        if (j < Config.RAVEN_LOG_LIMIT) {
            return 3;
        }
        return j < 104857600 ? 4 : 5;
    }
}
