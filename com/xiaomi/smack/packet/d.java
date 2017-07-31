package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public abstract class d {
    private static String d;
    private static long e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private List<a> l;
    private final Map<String, Object> m;
    private h n;
    protected static final String a = Locale.getDefault().getLanguage().toLowerCase();
    private static String c = null;
    public static final DateFormat b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    static {
        b.setTimeZone(TimeZone.getTimeZone("UTC"));
        d = com.xiaomi.smack.util.d.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        e = 0L;
    }

    public d() {
        this.f = c;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = new CopyOnWriteArrayList();
        this.m = new HashMap();
        this.n = null;
    }

    public d(Bundle bundle) {
        this.f = c;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = new CopyOnWriteArrayList();
        this.m = new HashMap();
        this.n = null;
        this.h = bundle.getString("ext_to");
        this.i = bundle.getString("ext_from");
        this.j = bundle.getString("ext_chid");
        this.g = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.l = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                a a2 = a.a((Bundle) parcelable);
                if (a2 != null) {
                    this.l.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.n = new h(bundle2);
        }
    }

    public static synchronized String j() {
        String sb;
        synchronized (d.class) {
            StringBuilder append = new StringBuilder().append(d);
            long j = e;
            e = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public static String u() {
        return a;
    }

    public void a(a aVar) {
        this.l.add(aVar);
    }

    public void a(h hVar) {
        this.n = hVar;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_ns", this.f);
        }
        if (!TextUtils.isEmpty(this.i)) {
            bundle.putString("ext_from", this.i);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_to", this.h);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_pkt_id", this.g);
        }
        if (!TextUtils.isEmpty(this.j)) {
            bundle.putString("ext_chid", this.j);
        }
        if (this.n != null) {
            bundle.putBundle("ext_ERROR", this.n.a());
        }
        if (this.l != null) {
            Bundle[] bundleArr = new Bundle[this.l.size()];
            int i = 0;
            Iterator<a> it = this.l.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                Bundle e2 = it.next().e();
                if (e2 != null) {
                    i = i2 + 1;
                    bundleArr[i2] = e2;
                } else {
                    i = i2;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public a b(String str, String str2) {
        for (a aVar : this.l) {
            if (str2 == null || str2.equals(aVar.b())) {
                if (str.equals(aVar.a())) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public abstract String c();

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.n != null) {
            if (!this.n.equals(dVar.n)) {
                return false;
            }
        } else if (dVar.n != null) {
            return false;
        }
        if (this.i != null) {
            if (!this.i.equals(dVar.i)) {
                return false;
            }
        } else if (dVar.i != null) {
            return false;
        }
        if (this.l.equals(dVar.l)) {
            if (this.g != null) {
                if (!this.g.equals(dVar.g)) {
                    return false;
                }
            } else if (dVar.g != null) {
                return false;
            }
            if (this.j != null) {
                if (!this.j.equals(dVar.j)) {
                    return false;
                }
            } else if (dVar.j != null) {
                return false;
            }
            if (this.m != null) {
                if (!this.m.equals(dVar.m)) {
                    return false;
                }
            } else if (dVar.m != null) {
                return false;
            }
            if (this.h != null) {
                if (!this.h.equals(dVar.h)) {
                    return false;
                }
            } else if (dVar.h != null) {
                return false;
            }
            if (this.f == null ? dVar.f != null : !this.f.equals(dVar.f)) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.j != null ? this.j.hashCode() : 0) + (((this.i != null ? this.i.hashCode() : 0) + (((this.h != null ? this.h.hashCode() : 0) + (((this.g != null ? this.g.hashCode() : 0) + ((this.f != null ? this.f.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + (this.n != null ? this.n.hashCode() : 0);
    }

    public String k() {
        if ("ID_NOT_AVAILABLE".equals(this.g)) {
            return null;
        }
        if (this.g == null) {
            this.g = j();
        }
        return this.g;
    }

    public void k(String str) {
        this.g = str;
    }

    public String l() {
        return this.j;
    }

    public void l(String str) {
        this.j = str;
    }

    public String m() {
        return this.h;
    }

    public void m(String str) {
        this.h = str;
    }

    public String n() {
        return this.i;
    }

    public void n(String str) {
        this.i = str;
    }

    public String o() {
        return this.k;
    }

    public void o(String str) {
        this.k = str;
    }

    public a p(String str) {
        return b(str, null);
    }

    public h p() {
        return this.n;
    }

    public synchronized Object q(String str) {
        return this.m == null ? null : this.m.get(str);
    }

    public synchronized Collection<a> q() {
        return this.l == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(this.l));
    }

    public synchronized Collection<String> r() {
        return this.m == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(this.m.keySet()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String s() {
        StringBuilder sb;
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        sb = new StringBuilder();
        for (a aVar : q()) {
            sb.append(aVar.d());
        }
        if (this.m != null && !this.m.isEmpty()) {
            sb.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
            for (String str : r()) {
                Object q = q(str);
                sb.append("<property>");
                sb.append("<name>").append(com.xiaomi.smack.util.d.a(str)).append("</name>");
                sb.append("<value type=\"");
                if (q instanceof Integer) {
                    sb.append("integer\">").append(q).append("</value>");
                } else if (q instanceof Long) {
                    sb.append("long\">").append(q).append("</value>");
                } else if (q instanceof Float) {
                    sb.append("float\">").append(q).append("</value>");
                } else if (q instanceof Double) {
                    sb.append("double\">").append(q).append("</value>");
                } else if (q instanceof Boolean) {
                    sb.append("boolean\">").append(q).append("</value>");
                } else if (q instanceof String) {
                    sb.append("string\">");
                    sb.append(com.xiaomi.smack.util.d.a((String) q));
                    sb.append("</value>");
                } else {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            objectOutputStream2 = null;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream = null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        objectOutputStream2 = null;
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        objectOutputStream = null;
                        byteArrayOutputStream = null;
                    }
                    try {
                        objectOutputStream.writeObject(q);
                        sb.append("java-object\">");
                        sb.append(com.xiaomi.smack.util.d.a(byteArrayOutputStream.toByteArray())).append("</value>");
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        objectOutputStream2 = objectOutputStream;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            e.printStackTrace();
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception e7) {
                                }
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception e8) {
                                }
                            }
                            sb.append("</property>");
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e9) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e10) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (objectOutputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                }
                sb.append("</property>");
            }
            sb.append("</properties>");
        }
        return sb.toString();
    }

    public String t() {
        return this.f;
    }
}
