package com.xiaomi.push;

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
/* loaded from: classes8.dex */
public abstract class gd {
    private static long a;
    private static String c;

    /* renamed from: a  reason: collision with other field name */
    private gh f409a;

    /* renamed from: a  reason: collision with other field name */
    private List<ga> f410a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, Object> f411a;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    /* renamed from: a  reason: collision with other field name */
    protected static final String f407a = Locale.getDefault().getLanguage().toLowerCase();
    private static String b = null;

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f408a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    static {
        f408a.setTimeZone(TimeZone.getTimeZone("UTC"));
        c = go.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        a = 0L;
    }

    public gd() {
        this.d = b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f410a = new CopyOnWriteArrayList();
        this.f411a = new HashMap();
        this.f409a = null;
    }

    public gd(Bundle bundle) {
        this.d = b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f410a = new CopyOnWriteArrayList();
        this.f411a = new HashMap();
        this.f409a = null;
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f410a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                ga a2 = ga.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f410a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f409a = new gh(bundle2);
        }
    }

    public static synchronized String i() {
        String sb;
        synchronized (gd.class) {
            StringBuilder append = new StringBuilder().append(c);
            long j = a;
            a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public static String q() {
        return f407a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.d)) {
            bundle.putString("ext_ns", this.d);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_from", this.g);
        }
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_to", this.f);
        }
        if (!TextUtils.isEmpty(this.e)) {
            bundle.putString("ext_pkt_id", this.e);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_chid", this.h);
        }
        if (this.f409a != null) {
            bundle.putBundle("ext_ERROR", this.f409a.a());
        }
        if (this.f410a != null) {
            Bundle[] bundleArr = new Bundle[this.f410a.size()];
            int i = 0;
            Iterator<ga> it = this.f410a.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                Bundle a2 = it.next().a();
                if (a2 != null) {
                    i = i2 + 1;
                    bundleArr[i2] = a2;
                } else {
                    i = i2;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public ga a(String str) {
        return a(str, null);
    }

    public ga a(String str, String str2) {
        for (ga gaVar : this.f410a) {
            if (str2 == null || str2.equals(gaVar.b())) {
                if (str.equals(gaVar.m304a())) {
                    return gaVar;
                }
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public gh m306a() {
        return this.f409a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m307a(String str) {
        return this.f411a == null ? null : this.f411a.get(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m308a();

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<ga> m309a() {
        return this.f410a == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(this.f410a));
    }

    public void a(ga gaVar) {
        this.f410a.add(gaVar);
    }

    public void a(gh ghVar) {
        this.f409a = ghVar;
    }

    public synchronized Collection<String> b() {
        return this.f411a == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(this.f411a.keySet()));
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gd gdVar = (gd) obj;
        if (this.f409a != null) {
            if (!this.f409a.equals(gdVar.f409a)) {
                return false;
            }
        } else if (gdVar.f409a != null) {
            return false;
        }
        if (this.g != null) {
            if (!this.g.equals(gdVar.g)) {
                return false;
            }
        } else if (gdVar.g != null) {
            return false;
        }
        if (this.f410a.equals(gdVar.f410a)) {
            if (this.e != null) {
                if (!this.e.equals(gdVar.e)) {
                    return false;
                }
            } else if (gdVar.e != null) {
                return false;
            }
            if (this.h != null) {
                if (!this.h.equals(gdVar.h)) {
                    return false;
                }
            } else if (gdVar.h != null) {
                return false;
            }
            if (this.f411a != null) {
                if (!this.f411a.equals(gdVar.f411a)) {
                    return false;
                }
            } else if (gdVar.f411a != null) {
                return false;
            }
            if (this.f != null) {
                if (!this.f.equals(gdVar.f)) {
                    return false;
                }
            } else if (gdVar.f != null) {
                return false;
            }
            if (this.d == null ? gdVar.d != null : !this.d.equals(gdVar.d)) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.h != null ? this.h.hashCode() : 0) + (((this.g != null ? this.g.hashCode() : 0) + (((this.f != null ? this.f.hashCode() : 0) + (((this.e != null ? this.e.hashCode() : 0) + ((this.d != null ? this.d.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31) + this.f410a.hashCode()) * 31) + this.f411a.hashCode()) * 31) + (this.f409a != null ? this.f409a.hashCode() : 0);
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.e)) {
            return null;
        }
        if (this.e == null) {
            this.e = i();
        }
        return this.e;
    }

    public String k() {
        return this.h;
    }

    public void k(String str) {
        this.e = str;
    }

    public String l() {
        return this.f;
    }

    public void l(String str) {
        this.h = str;
    }

    public String m() {
        return this.g;
    }

    public void m(String str) {
        this.f = str;
    }

    public String n() {
        return this.i;
    }

    public void n(String str) {
        this.g = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String o() {
        StringBuilder sb;
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        sb = new StringBuilder();
        for (ga gaVar : m309a()) {
            sb.append(gaVar.d());
        }
        if (this.f411a != null && !this.f411a.isEmpty()) {
            sb.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
            for (String str : b()) {
                Object m307a = m307a(str);
                sb.append("<property>");
                sb.append("<name>").append(go.a(str)).append("</name>");
                sb.append("<value type=\"");
                if (m307a instanceof Integer) {
                    sb.append("integer\">").append(m307a).append("</value>");
                } else if (m307a instanceof Long) {
                    sb.append("long\">").append(m307a).append("</value>");
                } else if (m307a instanceof Float) {
                    sb.append("float\">").append(m307a).append("</value>");
                } else if (m307a instanceof Double) {
                    sb.append("double\">").append(m307a).append("</value>");
                } else if (m307a instanceof Boolean) {
                    sb.append("boolean\">").append(m307a).append("</value>");
                } else if (m307a instanceof String) {
                    sb.append("string\">");
                    sb.append(go.a((String) m307a));
                    sb.append("</value>");
                } else {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        } catch (Exception e) {
                            e = e;
                            objectOutputStream2 = null;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream = null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        objectOutputStream2 = null;
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        objectOutputStream = null;
                        byteArrayOutputStream = null;
                    }
                    try {
                        objectOutputStream.writeObject(m307a);
                        sb.append("java-object\">");
                        sb.append(go.a(byteArrayOutputStream.toByteArray())).append("</value>");
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        objectOutputStream2 = objectOutputStream;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            e.printStackTrace();
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception e6) {
                                }
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception e7) {
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
                                } catch (Exception e8) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e9) {
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

    public void o(String str) {
        this.i = str;
    }

    public String p() {
        return this.d;
    }
}
