package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes6.dex */
final class c extends TagPayloadReader {
    private long lZB;

    public c(m mVar) {
        super(mVar);
        this.lZB = -9223372036854775807L;
    }

    public long getDurationUs() {
        return this.lZB;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean a(l lVar) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void a(l lVar, long j) throws ParserException {
        if (b(lVar) != 2) {
            throw new ParserException();
        }
        if ("onMetaData".equals(e(lVar)) && b(lVar) == 8) {
            HashMap<String, Object> h = h(lVar);
            if (h.containsKey("duration")) {
                double doubleValue = ((Double) h.get("duration")).doubleValue();
                if (doubleValue > 0.0d) {
                    this.lZB = (long) (doubleValue * 1000000.0d);
                }
            }
        }
    }

    private static int b(l lVar) {
        return lVar.readUnsignedByte();
    }

    private static Boolean c(l lVar) {
        return Boolean.valueOf(lVar.readUnsignedByte() == 1);
    }

    private static Double d(l lVar) {
        return Double.valueOf(Double.longBitsToDouble(lVar.readLong()));
    }

    private static String e(l lVar) {
        int readUnsignedShort = lVar.readUnsignedShort();
        int position = lVar.getPosition();
        lVar.skipBytes(readUnsignedShort);
        return new String(lVar.data, position, readUnsignedShort);
    }

    private static ArrayList<Object> f(l lVar) {
        int dzC = lVar.dzC();
        ArrayList<Object> arrayList = new ArrayList<>(dzC);
        for (int i = 0; i < dzC; i++) {
            arrayList.add(b(lVar, b(lVar)));
        }
        return arrayList;
    }

    private static HashMap<String, Object> g(l lVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String e = e(lVar);
            int b = b(lVar);
            if (b != 9) {
                hashMap.put(e, b(lVar, b));
            } else {
                return hashMap;
            }
        }
    }

    private static HashMap<String, Object> h(l lVar) {
        int dzC = lVar.dzC();
        HashMap<String, Object> hashMap = new HashMap<>(dzC);
        for (int i = 0; i < dzC; i++) {
            hashMap.put(e(lVar), b(lVar, b(lVar)));
        }
        return hashMap;
    }

    private static Date i(l lVar) {
        Date date = new Date((long) d(lVar).doubleValue());
        lVar.skipBytes(2);
        return date;
    }

    private static Object b(l lVar, int i) {
        switch (i) {
            case 0:
                return d(lVar);
            case 1:
                return c(lVar);
            case 2:
                return e(lVar);
            case 3:
                return g(lVar);
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            default:
                return null;
            case 8:
                return h(lVar);
            case 10:
                return f(lVar);
            case 11:
                return i(lVar);
        }
    }
}
