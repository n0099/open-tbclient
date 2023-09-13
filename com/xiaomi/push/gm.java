package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public abstract class gm {
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f442a;
    public static String c;

    /* renamed from: a  reason: collision with other field name */
    public gq f443a;

    /* renamed from: a  reason: collision with other field name */
    public List<gj> f444a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, Object> f445a;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    /* renamed from: a  reason: collision with other field name */
    public static final String f441a = Locale.getDefault().getLanguage().toLowerCase();
    public static String b = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f442a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        c = gx.a(5) + "-";
        a = 0L;
    }

    public gm() {
        this.d = b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f444a = new CopyOnWriteArrayList();
        this.f445a = new HashMap();
        this.f443a = null;
    }

    public gm(Bundle bundle) {
        this.d = b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f444a = new CopyOnWriteArrayList();
        this.f445a = new HashMap();
        this.f443a = null;
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f444a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                gj a2 = gj.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f444a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f443a = new gq(bundle2);
        }
    }

    public static synchronized String i() {
        String sb;
        synchronized (gm.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c);
            long j = a;
            a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public static String q() {
        return f441a;
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
        gq gqVar = this.f443a;
        if (gqVar != null) {
            bundle.putBundle("ext_ERROR", gqVar.a());
        }
        List<gj> list = this.f444a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            for (gj gjVar : this.f444a) {
                Bundle a2 = gjVar.a();
                if (a2 != null) {
                    bundleArr[i] = a2;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public gj a(String str) {
        return a(str, null);
    }

    public gj a(String str, String str2) {
        for (gj gjVar : this.f444a) {
            if (str2 == null || str2.equals(gjVar.b())) {
                if (str.equals(gjVar.m527a())) {
                    return gjVar;
                }
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public gq m531a() {
        return this.f443a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m532a(String str) {
        if (this.f445a == null) {
            return null;
        }
        return this.f445a.get(str);
    }

    /* renamed from: a */
    public abstract String mo530a();

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<gj> m533a() {
        if (this.f444a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f444a));
    }

    public void a(gj gjVar) {
        this.f444a.add(gjVar);
    }

    public void a(gq gqVar) {
        this.f443a = gqVar;
    }

    public synchronized Collection<String> b() {
        if (this.f445a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f445a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gm gmVar = (gm) obj;
        gq gqVar = this.f443a;
        if (gqVar == null ? gmVar.f443a == null : gqVar.equals(gmVar.f443a)) {
            String str = this.g;
            if (str == null ? gmVar.g == null : str.equals(gmVar.g)) {
                if (this.f444a.equals(gmVar.f444a)) {
                    String str2 = this.e;
                    if (str2 == null ? gmVar.e == null : str2.equals(gmVar.e)) {
                        String str3 = this.h;
                        if (str3 == null ? gmVar.h == null : str3.equals(gmVar.h)) {
                            Map<String, Object> map = this.f445a;
                            if (map == null ? gmVar.f445a == null : map.equals(gmVar.f445a)) {
                                String str4 = this.f;
                                if (str4 == null ? gmVar.f == null : str4.equals(gmVar.f)) {
                                    String str5 = this.d;
                                    String str6 = gmVar.d;
                                    if (str5 != null) {
                                        if (str5.equals(str6)) {
                                            return true;
                                        }
                                    } else if (str6 == null) {
                                        return true;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.d;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.h;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f444a.hashCode()) * 31) + this.f445a.hashCode()) * 31;
        gq gqVar = this.f443a;
        return hashCode5 + (gqVar != null ? gqVar.hashCode() : 0);
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String o() {
        StringBuilder sb;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Exception e;
        String str;
        sb = new StringBuilder();
        for (gj gjVar : m533a()) {
            sb.append(gjVar.d());
        }
        if (this.f445a != null && !this.f445a.isEmpty()) {
            sb.append(bl.b("PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="));
            for (String str2 : b()) {
                Object m532a = m532a(str2);
                sb.append("<property>");
                sb.append("<name>");
                sb.append(gx.a(str2));
                sb.append("</name>");
                sb.append("<value type=\"");
                if (m532a instanceof Integer) {
                    sb.append("integer\">");
                    sb.append(m532a);
                    str = "</value>";
                } else if (m532a instanceof Long) {
                    sb.append("long\">");
                    sb.append(m532a);
                    str = "</value>";
                } else if (m532a instanceof Float) {
                    sb.append("float\">");
                    sb.append(m532a);
                    str = "</value>";
                } else if (m532a instanceof Double) {
                    sb.append("double\">");
                    sb.append(m532a);
                    str = "</value>";
                } else if (m532a instanceof Boolean) {
                    sb.append("boolean\">");
                    sb.append(m532a);
                    str = "</value>";
                } else if (m532a instanceof String) {
                    sb.append("string\">");
                    sb.append(gx.a((String) m532a));
                    str = "</value>";
                } else {
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            try {
                                try {
                                    objectOutputStream.writeObject(m532a);
                                    sb.append("java-object\">");
                                    sb.append(gx.a(byteArrayOutputStream.toByteArray()));
                                    sb.append("</value>");
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception unused) {
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    if (objectOutputStream != null) {
                                        try {
                                            objectOutputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    if (byteArrayOutputStream == null) {
                                        sb.append("</property>");
                                    }
                                    byteArrayOutputStream.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream2 = objectOutputStream;
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (Exception unused3) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            objectOutputStream = null;
                            e = e;
                            e.printStackTrace();
                            if (objectOutputStream != null) {
                            }
                            if (byteArrayOutputStream == null) {
                            }
                            byteArrayOutputStream.close();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                sb.append(str);
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
