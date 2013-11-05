package org.msgpack.util.json;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.b;
import org.msgpack.a;
import org.msgpack.type.r;
import org.msgpack.type.s;
import org.msgpack.unpacker.Converter;
/* loaded from: classes.dex */
public class JSONUnpacker extends Converter {
    protected Reader f;
    private b g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONUnpacker(a aVar, Reader reader) {
        super(aVar, null);
        this.f = reader;
        this.g = new b();
    }

    @Override // org.msgpack.unpacker.Converter
    protected r c() {
        try {
            return a(this.g.b(this.f));
        } catch (IOException e) {
            throw new IOException(e);
        } catch (ParseException e2) {
            throw new IOException(e2);
        }
    }

    private r a(Object obj) {
        if (obj instanceof String) {
            return s.a((String) obj);
        }
        if (obj instanceof Integer) {
            return s.a(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return s.a(((Long) obj).longValue());
        }
        if (obj instanceof Map) {
            return a((Map) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Boolean) {
            return s.a(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Double) {
            return s.a(((Double) obj).doubleValue());
        }
        return s.a();
    }

    private r a(List list) {
        r[] rVarArr = new r[list.size()];
        for (int i = 0; i < rVarArr.length; i++) {
            rVarArr[i] = a(list.get(i));
        }
        return s.a(rVarArr, true);
    }

    private r a(Map map) {
        r[] rVarArr = new r[map.size() * 2];
        Iterator it = map.entrySet().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < rVarArr.length) {
                Map.Entry entry = (Map.Entry) it.next();
                rVarArr[i2] = a(entry.getKey());
                rVarArr[i2 + 1] = a(entry.getValue());
                i = i2 + 2;
            } else {
                return s.b(rVarArr, true);
            }
        }
    }

    @Override // org.msgpack.unpacker.Converter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.close();
        super.close();
    }
}
