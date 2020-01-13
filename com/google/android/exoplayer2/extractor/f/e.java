package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class e implements w.c {
    private final int flags;
    private final List<Format> mma;

    public e() {
        this(0);
    }

    public e(int i) {
        this(i, Collections.emptyList());
    }

    public e(int i, List<Format> list) {
        this.flags = i;
        if (!isSet(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.a(null, "application/cea-608", 0, null));
        }
        this.mma = list;
    }

    @Override // com.google.android.exoplayer2.extractor.f.w.c
    public SparseArray<w> duh() {
        return new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.f.w.c
    public w a(int i, w.b bVar) {
        switch (i) {
            case 2:
                return new p(new i());
            case 3:
            case 4:
                return new p(new n(bVar.language));
            case 15:
                if (isSet(2)) {
                    return null;
                }
                return new p(new d(false, bVar.language));
            case 17:
                if (isSet(2)) {
                    return null;
                }
                return new p(new m(bVar.language));
            case 21:
                return new p(new l());
            case 27:
                if (isSet(4)) {
                    return null;
                }
                return new p(new j(a(bVar), isSet(1), isSet(8)));
            case 36:
                return new p(new k(a(bVar)));
            case 89:
                return new p(new g(bVar.moo));
            case 129:
            case 135:
                return new p(new b(bVar.language));
            case 130:
            case 138:
                return new p(new f(bVar.language));
            case 134:
                if (isSet(16)) {
                    return null;
                }
                return new s(new u());
            default:
                return null;
        }
    }

    private t a(w.b bVar) {
        String str;
        int i;
        if (isSet(32)) {
            return new t(this.mma);
        }
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(bVar.mop);
        List<Format> list = this.mma;
        while (lVar.dyf() > 0) {
            int readUnsignedByte = lVar.readUnsignedByte();
            int position = lVar.getPosition() + lVar.readUnsignedByte();
            if (readUnsignedByte == 134) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = lVar.readUnsignedByte() & 31;
                for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                    String LP = lVar.LP(3);
                    int readUnsignedByte3 = lVar.readUnsignedByte();
                    if ((readUnsignedByte3 & 128) != 0) {
                        str = "application/cea-708";
                        i = readUnsignedByte3 & 63;
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    arrayList.add(Format.a((String) null, str, (String) null, -1, 0, LP, i, (DrmInitData) null));
                    lVar.skipBytes(2);
                }
                list = arrayList;
            }
            lVar.setPosition(position);
        }
        return new t(list);
    }

    private boolean isSet(int i) {
        return (this.flags & i) != 0;
    }
}
