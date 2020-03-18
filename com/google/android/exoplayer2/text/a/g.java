package com.google.android.exoplayer2.text.a;

import android.util.Log;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
/* loaded from: classes6.dex */
public final class g {
    public static void a(long j, l lVar, m[] mVarArr) {
        while (lVar.dzR() > 1) {
            int T = T(lVar);
            int T2 = T(lVar);
            if (T2 == -1 || T2 > lVar.dzR()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                lVar.setPosition(lVar.dzS());
            } else if (a(T, T2, lVar)) {
                lVar.skipBytes(8);
                int readUnsignedByte = lVar.readUnsignedByte() & 31;
                lVar.skipBytes(1);
                int i = readUnsignedByte * 3;
                int position = lVar.getPosition();
                for (m mVar : mVarArr) {
                    lVar.setPosition(position);
                    mVar.a(lVar, i);
                    mVar.a(j, 1, i, 0, null);
                }
                lVar.skipBytes(T2 - ((readUnsignedByte * 3) + 10));
            } else {
                lVar.skipBytes(T2);
            }
        }
    }

    private static int T(l lVar) {
        int i = 0;
        while (lVar.dzR() != 0) {
            int readUnsignedByte = lVar.readUnsignedByte();
            i += readUnsignedByte;
            if (readUnsignedByte != 255) {
                return i;
            }
        }
        return -1;
    }

    private static boolean a(int i, int i2, l lVar) {
        if (i != 4 || i2 < 8) {
            return false;
        }
        int position = lVar.getPosition();
        int readUnsignedByte = lVar.readUnsignedByte();
        int readUnsignedShort = lVar.readUnsignedShort();
        int readInt = lVar.readInt();
        int readUnsignedByte2 = lVar.readUnsignedByte();
        lVar.setPosition(position);
        return readUnsignedByte == 181 && readUnsignedShort == 49 && readInt == 1195456820 && readUnsignedByte2 == 3;
    }
}
