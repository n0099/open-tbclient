package com.google.android.exoplayer2.extractor.c;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class h {
    public static byte[] a(UUID uuid, byte[] bArr) {
        return a(uuid, null, bArr);
    }

    public static byte[] a(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        boolean z = uuidArr != null;
        int length = bArr != null ? bArr.length : 0;
        int i = length + 32;
        if (z) {
            i += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.putInt(i);
        allocate.putInt(com.google.android.exoplayer2.extractor.c.a.mgZ);
        allocate.putInt(z ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (z) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static UUID ap(byte[] bArr) {
        a aq = aq(bArr);
        if (aq == null) {
            return null;
        }
        return aq.uuid;
    }

    private static a aq(byte[] bArr) {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(bArr);
        if (lVar.dyg() < 32) {
            return null;
        }
        lVar.setPosition(0);
        if (lVar.readInt() == lVar.dyf() + 4 && lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mgZ) {
            int JD = com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt());
            if (JD > 1) {
                Log.w("PsshAtomUtil", "Unsupported pssh version: " + JD);
                return null;
            }
            UUID uuid = new UUID(lVar.readLong(), lVar.readLong());
            if (JD == 1) {
                lVar.skipBytes(lVar.dyq() * 16);
            }
            int dyq = lVar.dyq();
            if (dyq == lVar.dyf()) {
                byte[] bArr2 = new byte[dyq];
                lVar.C(bArr2, 0, dyq);
                return new a(uuid, JD, bArr2);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private final byte[] mjK;
        private final UUID uuid;
        private final int version;

        public a(UUID uuid, int i, byte[] bArr) {
            this.uuid = uuid;
            this.version = i;
            this.mjK = bArr;
        }
    }
}
