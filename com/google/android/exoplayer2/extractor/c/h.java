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
        allocate.putInt(com.google.android.exoplayer2.extractor.c.a.mjF);
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
        if (lVar.dzS() < 32) {
            return null;
        }
        lVar.setPosition(0);
        if (lVar.readInt() == lVar.dzR() + 4 && lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mjF) {
            int JO = com.google.android.exoplayer2.extractor.c.a.JO(lVar.readInt());
            if (JO > 1) {
                Log.w("PsshAtomUtil", "Unsupported pssh version: " + JO);
                return null;
            }
            UUID uuid = new UUID(lVar.readLong(), lVar.readLong());
            if (JO == 1) {
                lVar.skipBytes(lVar.dAc() * 16);
            }
            int dAc = lVar.dAc();
            if (dAc == lVar.dzR()) {
                byte[] bArr2 = new byte[dAc];
                lVar.G(bArr2, 0, dAc);
                return new a(uuid, JO, bArr2);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private final byte[] mmo;
        private final UUID uuid;
        private final int version;

        public a(UUID uuid, int i, byte[] bArr) {
            this.uuid = uuid;
            this.version = i;
            this.mmo = bArr;
        }
    }
}
