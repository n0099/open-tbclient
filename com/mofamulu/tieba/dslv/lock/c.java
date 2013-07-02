package com.mofamulu.tieba.dslv.lock;

import android.content.Context;
import java.util.zip.CRC32;
/* loaded from: classes.dex */
public class c implements b {
    @Override // com.mofamulu.tieba.dslv.lock.b
    public String a(Context context, String str) {
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        return String.format("%08x", Long.valueOf(crc32.getValue()));
    }
}
