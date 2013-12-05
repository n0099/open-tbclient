package com.google.zxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes.dex */
public final class d implements g {

    /* renamed from: a  reason: collision with root package name */
    private Map<DecodeHintType, ?> f2871a;
    private g[] b;

    @Override // com.google.zxing.g
    public h a(b bVar, Map<DecodeHintType, ?> map) {
        a(map);
        return b(bVar);
    }

    public h a(b bVar) {
        if (this.b == null) {
            a((Map<DecodeHintType, ?>) null);
        }
        return b(bVar);
    }

    public void a(Map<DecodeHintType, ?> map) {
        this.f2871a = map;
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null && collection.contains(BarcodeFormat.QR_CODE)) {
            arrayList.add(new com.google.zxing.qrcode.a());
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new com.google.zxing.qrcode.a());
        }
        this.b = (g[]) arrayList.toArray(new g[arrayList.size()]);
    }

    @Override // com.google.zxing.g
    public void a() {
        if (this.b != null) {
            for (g gVar : this.b) {
                gVar.a();
            }
        }
    }

    private h b(b bVar) {
        if (this.b != null) {
            for (g gVar : this.b) {
                try {
                    return gVar.a(bVar, this.f2871a);
                } catch (ReaderException e) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
