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
/* loaded from: classes9.dex */
public abstract class gj {
    private static long a;
    private static String c;

    /* renamed from: a  reason: collision with other field name */
    private gn f395a;

    /* renamed from: a  reason: collision with other field name */
    private List<gg> f396a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, Object> f397a;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    /* renamed from: a  reason: collision with other field name */
    protected static final String f393a = Locale.getDefault().getLanguage().toLowerCase();
    private static String b = null;

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f394a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    static {
        f394a.setTimeZone(TimeZone.getTimeZone("UTC"));
        c = gu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        a = 0L;
    }

    public gj() {
        this.d = b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f396a = new CopyOnWriteArrayList();
        this.f397a = new HashMap();
        this.f395a = null;
    }

    public gj(Bundle bundle) {
        this.d = b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f396a = new CopyOnWriteArrayList();
        this.f397a = new HashMap();
        this.f395a = null;
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f396a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                gg a2 = gg.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f396a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f395a = new gn(bundle2);
        }
    }

    public static synchronized String i() {
        String sb;
        synchronized (gj.class) {
            StringBuilder append = new StringBuilder().append(c);
            long j = a;
            a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public static String q() {
        return f393a;
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
        if (this.f395a != null) {
            bundle.putBundle("ext_ERROR", this.f395a.a());
        }
        if (this.f396a != null) {
            Bundle[] bundleArr = new Bundle[this.f396a.size()];
            int i = 0;
            Iterator<gg> it = this.f396a.iterator();
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

    public gg a(String str) {
        return a(str, null);
    }

    public gg a(String str, String str2) {
        for (gg ggVar : this.f396a) {
            if (str2 == null || str2.equals(ggVar.b())) {
                if (str.equals(ggVar.m312a())) {
                    return ggVar;
                }
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public gn m314a() {
        return this.f395a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m315a(String str) {
        return this.f397a == null ? null : this.f397a.get(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m316a();

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<gg> m317a() {
        return this.f396a == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(this.f396a));
    }

    public void a(gg ggVar) {
        this.f396a.add(ggVar);
    }

    public void a(gn gnVar) {
        this.f395a = gnVar;
    }

    public synchronized Collection<String> b() {
        return this.f397a == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(this.f397a.keySet()));
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gj gjVar = (gj) obj;
        if (this.f395a != null) {
            if (!this.f395a.equals(gjVar.f395a)) {
                return false;
            }
        } else if (gjVar.f395a != null) {
            return false;
        }
        if (this.g != null) {
            if (!this.g.equals(gjVar.g)) {
                return false;
            }
        } else if (gjVar.g != null) {
            return false;
        }
        if (this.f396a.equals(gjVar.f396a)) {
            if (this.e != null) {
                if (!this.e.equals(gjVar.e)) {
                    return false;
                }
            } else if (gjVar.e != null) {
                return false;
            }
            if (this.h != null) {
                if (!this.h.equals(gjVar.h)) {
                    return false;
                }
            } else if (gjVar.h != null) {
                return false;
            }
            if (this.f397a != null) {
                if (!this.f397a.equals(gjVar.f397a)) {
                    return false;
                }
            } else if (gjVar.f397a != null) {
                return false;
            }
            if (this.f != null) {
                if (!this.f.equals(gjVar.f)) {
                    return false;
                }
            } else if (gjVar.f != null) {
                return false;
            }
            if (this.d == null ? gjVar.d != null : !this.d.equals(gjVar.d)) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.h != null ? this.h.hashCode() : 0) + (((this.g != null ? this.g.hashCode() : 0) + (((this.f != null ? this.f.hashCode() : 0) + (((this.e != null ? this.e.hashCode() : 0) + ((this.d != null ? this.d.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31) + this.f396a.hashCode()) * 31) + this.f397a.hashCode()) * 31) + (this.f395a != null ? this.f395a.hashCode() : 0);
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
        for (gg ggVar : m317a()) {
            sb.append(ggVar.d());
        }
        if (this.f397a != null && !this.f397a.isEmpty()) {
            sb.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
            for (String str : b()) {
                Object m315a = m315a(str);
                sb.append("<property>");
                sb.append("<name>").append(gu.a(str)).append("</name>");
                sb.append("<value type=\"");
                if (m315a instanceof Integer) {
                    sb.append("integer\">").append(m315a).append("</value>");
                } else if (m315a instanceof Long) {
                    sb.append("long\">").append(m315a).append("</value>");
                } else if (m315a instanceof Float) {
                    sb.append("float\">").append(m315a).append("</value>");
                } else if (m315a instanceof Double) {
                    sb.append("double\">").append(m315a).append("</value>");
                } else if (m315a instanceof Boolean) {
                    sb.append("boolean\">").append(m315a).append("</value>");
                } else if (m315a instanceof String) {
                    sb.append("string\">");
                    sb.append(gu.a((String) m315a));
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
                        objectOutputStream.writeObject(m315a);
                        sb.append("java-object\">");
                        sb.append(gu.a(byteArrayOutputStream.toByteArray())).append("</value>");
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
