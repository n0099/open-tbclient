package com.google.zxing;

import com.google.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes.dex */
public final class MultiFormatReader implements Reader {
    private Map<DecodeHintType, ?> hints;
    private Reader[] readers;

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) {
        setHints(null);
        return decodeInternal(binaryBitmap);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) {
        setHints(map);
        return decodeInternal(binaryBitmap);
    }

    public Result decodeWithState(BinaryBitmap binaryBitmap) {
        if (this.readers == null) {
            setHints(null);
        }
        return decodeInternal(binaryBitmap);
    }

    public void setHints(Map<DecodeHintType, ?> map) {
        this.hints = map;
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null && collection.contains(BarcodeFormat.QR_CODE)) {
            arrayList.add(new QRCodeReader());
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new QRCodeReader());
        }
        this.readers = (Reader[]) arrayList.toArray(new Reader[arrayList.size()]);
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        if (this.readers != null) {
            for (Reader reader : this.readers) {
                reader.reset();
            }
        }
    }

    private Result decodeInternal(BinaryBitmap binaryBitmap) {
        if (this.readers != null) {
            for (Reader reader : this.readers) {
                try {
                    return reader.decode(binaryBitmap, this.hints);
                } catch (ReaderException e) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
