package org.json.simple;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class JSONArray extends ArrayList implements List, a, b {
    private static final long serialVersionUID = 3957988303675231981L;

    public static void writeJSONString(List list, Writer writer) {
        if (list == null) {
            writer.write("null");
            return;
        }
        boolean z = true;
        writer.write(91);
        for (Object obj : list) {
            if (z) {
                z = false;
            } else {
                writer.write(44);
            }
            if (obj == null) {
                writer.write("null");
            } else {
                c.a(obj, writer);
            }
        }
        writer.write(93);
    }

    @Override // org.json.simple.b
    public void writeJSONString(Writer writer) {
        writeJSONString(this, writer);
    }

    public static String toJSONString(List list) {
        if (list == null) {
            return "null";
        }
        boolean z = true;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for (Object obj : list) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            if (obj == null) {
                stringBuffer.append("null");
            } else {
                stringBuffer.append(c.a(obj));
            }
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    @Override // org.json.simple.a
    public String toJSONString() {
        return toJSONString(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return toJSONString();
    }
}
