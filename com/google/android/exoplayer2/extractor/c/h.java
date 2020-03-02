package com.google.android.exoplayer2.extractor.c;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.UUID;
/* loaded from: classes6.dex */
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
        allocate.putInt(com.google.android.exoplayer2.extractor.c.a.mhM);
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

    public static UUID au(byte[] bArr) {
        a av = av(bArr);
        if (av == null) {
            return null;
        }
        return av.uuid;
    }

    private static a av(byte[] bArr) {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(bArr);
        if (lVar.dzu() < 32) {
            return null;
        }
        lVar.setPosition(0);
        if (lVar.readInt() == lVar.dzt() + 4 && lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mhM) {
            int JI = com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt());
            if (JI > 1) {
                Log.w("PsshAtomUtil", "Unsupported pssh version: " + JI);
                return null;
            }
            UUID uuid = new UUID(lVar.readLong(), lVar.readLong());
            if (JI == 1) {
                lVar.skipBytes(lVar.dzE() * 16);
            }
            int dzE = lVar.dzE();
            if (dzE == lVar.dzt()) {
                byte[] bArr2 = new byte[dzE];
                lVar.G(bArr2, 0, dzE);
                return new a(uuid, JI, bArr2);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private final byte[] mkx;
        private final UUID uuid;
        private final int version;

        public a(UUID uuid, int i, byte[] bArr) {
            this.uuid = uuid;
            this.version = i;
            this.mkx = bArr;
        }
    }
}
