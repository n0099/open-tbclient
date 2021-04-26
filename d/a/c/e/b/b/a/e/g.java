package d.a.c.e.b.b.a.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import com.squareup.wire.Message;
import d.a.c.e.b.b.a.d.h;
import d.a.c.e.b.b.a.d.i;
import d.a.c.e.b.b.a.d.j;
import d.a.c.e.b.b.a.d.k;
import d.a.c.e.b.b.a.d.l;
import d.a.c.e.b.b.a.d.m;
import d.a.c.e.b.b.a.d.n;
import d.a.c.e.b.b.a.d.o;
import d.a.c.e.b.b.a.d.p;
import d.a.c.e.b.b.a.d.q;
import d.a.c.e.b.b.a.d.r;
import d.a.c.e.b.b.a.d.s;
import d.a.c.e.b.b.a.d.t;
import d.a.c.e.b.b.a.d.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    /* JADX WARN: Removed duplicated region for block: B:140:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final h a(Object obj) {
        ObjectOutputStream objectOutputStream;
        Exception e2;
        ObjectOutputStream objectOutputStream2 = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return new d.a.c.e.b.b.a.d.b(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Bundle) {
            return new d.a.c.e.b.b.a.d.c((Bundle) obj);
        }
        if (obj instanceof Byte) {
            return new d.a.c.e.b.b.a.d.d(((Byte) obj).byteValue());
        }
        if (obj instanceof Character) {
            return new d.a.c.e.b.b.a.d.e(((Character) obj).charValue());
        }
        if (obj instanceof Double) {
            return new d.a.c.e.b.b.a.d.f(((Double) obj).doubleValue());
        }
        if (obj instanceof Float) {
            return new d.a.c.e.b.b.a.d.g(((Float) obj).floatValue());
        }
        if (obj instanceof Integer) {
            return new i(((Integer) obj).intValue());
        }
        if (obj instanceof JSONArray) {
            return new j((JSONArray) obj);
        }
        if (obj instanceof JSONObject) {
            return new k((JSONObject) obj);
        }
        if (obj instanceof Long) {
            return new m(((Long) obj).longValue());
        }
        if (obj instanceof Short) {
            return new s(((Short) obj).shortValue());
        }
        if (obj instanceof String) {
            return new u((String) obj);
        }
        if (obj instanceof SparseArray) {
            return new t((SparseArray) obj);
        }
        if (obj instanceof List) {
            return new l((List) obj);
        }
        if (obj instanceof Queue) {
            return new q((Queue) obj);
        }
        if (obj instanceof Set) {
            return new r((Set) obj);
        }
        if (obj instanceof Map) {
            return new n((Map) obj);
        }
        if (obj instanceof Message) {
            return new p((Message) obj);
        }
        if (obj.getClass().isArray()) {
            return new d.a.c.e.b.b.a.d.a(obj);
        }
        if (obj instanceof CharSequence) {
            return new u(((CharSequence) obj).toString());
        }
        if (obj instanceof Serializable) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    try {
                        objectOutputStream.writeObject(obj);
                        objectOutputStream.flush();
                        d.a.c.e.b.b.a.d.a aVar = new d.a.c.e.b.b.a.d.a(byteArrayOutputStream.toByteArray());
                        try {
                            objectOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        return aVar;
                    } catch (Exception e5) {
                        e2 = e5;
                        e2.printStackTrace();
                        o oVar = new o(obj);
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                        return oVar;
                    }
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e10) {
                objectOutputStream = null;
                e2 = e10;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream2 != null) {
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } else if (obj instanceof IBinder) {
            return new o(obj);
        } else {
            if (obj instanceof Parcelable) {
                return new o(obj);
            }
            return new o(obj);
        }
    }
}
