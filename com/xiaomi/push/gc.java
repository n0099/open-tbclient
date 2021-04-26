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
/* loaded from: classes7.dex */
public abstract class gc {

    /* renamed from: a  reason: collision with root package name */
    public static long f38463a;

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f424a;

    /* renamed from: c  reason: collision with root package name */
    public static String f38465c;

    /* renamed from: a  reason: collision with other field name */
    public gg f425a;

    /* renamed from: a  reason: collision with other field name */
    public List<fz> f426a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, Object> f427a;

    /* renamed from: d  reason: collision with root package name */
    public String f38466d;

    /* renamed from: e  reason: collision with root package name */
    public String f38467e;

    /* renamed from: f  reason: collision with root package name */
    public String f38468f;

    /* renamed from: g  reason: collision with root package name */
    public String f38469g;

    /* renamed from: h  reason: collision with root package name */
    public String f38470h;

    /* renamed from: i  reason: collision with root package name */
    public String f38471i;

    /* renamed from: a  reason: collision with other field name */
    public static final String f423a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: b  reason: collision with root package name */
    public static String f38464b = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f424a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        f38465c = gn.a(5) + "-";
        f38463a = 0L;
    }

    public gc() {
        this.f38466d = f38464b;
        this.f38467e = null;
        this.f38468f = null;
        this.f38469g = null;
        this.f38470h = null;
        this.f38471i = null;
        this.f426a = new CopyOnWriteArrayList();
        this.f427a = new HashMap();
        this.f425a = null;
    }

    public gc(Bundle bundle) {
        this.f38466d = f38464b;
        this.f38467e = null;
        this.f38468f = null;
        this.f38469g = null;
        this.f38470h = null;
        this.f38471i = null;
        this.f426a = new CopyOnWriteArrayList();
        this.f427a = new HashMap();
        this.f425a = null;
        this.f38468f = bundle.getString("ext_to");
        this.f38469g = bundle.getString("ext_from");
        this.f38470h = bundle.getString("ext_chid");
        this.f38467e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f426a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fz a2 = fz.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f426a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f425a = new gg(bundle2);
        }
    }

    public static synchronized String i() {
        String sb;
        synchronized (gc.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f38465c);
            long j = f38463a;
            f38463a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public static String q() {
        return f423a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f38466d)) {
            bundle.putString("ext_ns", this.f38466d);
        }
        if (!TextUtils.isEmpty(this.f38469g)) {
            bundle.putString("ext_from", this.f38469g);
        }
        if (!TextUtils.isEmpty(this.f38468f)) {
            bundle.putString("ext_to", this.f38468f);
        }
        if (!TextUtils.isEmpty(this.f38467e)) {
            bundle.putString("ext_pkt_id", this.f38467e);
        }
        if (!TextUtils.isEmpty(this.f38470h)) {
            bundle.putString("ext_chid", this.f38470h);
        }
        gg ggVar = this.f425a;
        if (ggVar != null) {
            bundle.putBundle("ext_ERROR", ggVar.a());
        }
        List<fz> list = this.f426a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            for (fz fzVar : this.f426a) {
                Bundle a2 = fzVar.a();
                if (a2 != null) {
                    bundleArr[i2] = a2;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public fz a(String str) {
        return a(str, null);
    }

    public fz a(String str, String str2) {
        for (fz fzVar : this.f426a) {
            if (str2 == null || str2.equals(fzVar.b())) {
                if (str.equals(fzVar.m322a())) {
                    return fzVar;
                }
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public gg m331a() {
        return this.f425a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m332a(String str) {
        if (this.f427a == null) {
            return null;
        }
        return this.f427a.get(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m333a();

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<fz> m334a() {
        if (this.f426a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f426a));
    }

    public void a(fz fzVar) {
        this.f426a.add(fzVar);
    }

    public void a(gg ggVar) {
        this.f425a = ggVar;
    }

    public synchronized Collection<String> b() {
        if (this.f427a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f427a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gc gcVar = (gc) obj;
        gg ggVar = this.f425a;
        if (ggVar == null ? gcVar.f425a == null : ggVar.equals(gcVar.f425a)) {
            String str = this.f38469g;
            if (str == null ? gcVar.f38469g == null : str.equals(gcVar.f38469g)) {
                if (this.f426a.equals(gcVar.f426a)) {
                    String str2 = this.f38467e;
                    if (str2 == null ? gcVar.f38467e == null : str2.equals(gcVar.f38467e)) {
                        String str3 = this.f38470h;
                        if (str3 == null ? gcVar.f38470h == null : str3.equals(gcVar.f38470h)) {
                            Map<String, Object> map = this.f427a;
                            if (map == null ? gcVar.f427a == null : map.equals(gcVar.f427a)) {
                                String str4 = this.f38468f;
                                if (str4 == null ? gcVar.f38468f == null : str4.equals(gcVar.f38468f)) {
                                    String str5 = this.f38466d;
                                    String str6 = gcVar.f38466d;
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
        String str = this.f38466d;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f38467e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f38468f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f38469g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f38470h;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f426a.hashCode()) * 31) + this.f427a.hashCode()) * 31;
        gg ggVar = this.f425a;
        return hashCode5 + (ggVar != null ? ggVar.hashCode() : 0);
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.f38467e)) {
            return null;
        }
        if (this.f38467e == null) {
            this.f38467e = i();
        }
        return this.f38467e;
    }

    public String k() {
        return this.f38470h;
    }

    public void k(String str) {
        this.f38467e = str;
    }

    public String l() {
        return this.f38468f;
    }

    public void l(String str) {
        this.f38470h = str;
    }

    public String m() {
        return this.f38469g;
    }

    public void m(String str) {
        this.f38468f = str;
    }

    public String n() {
        return this.f38471i;
    }

    public void n(String str) {
        this.f38469g = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String o() {
        StringBuilder sb;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Exception e2;
        String str;
        sb = new StringBuilder();
        for (fz fzVar : m334a()) {
            sb.append(fzVar.d());
        }
        if (this.f427a != null && !this.f427a.isEmpty()) {
            sb.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
            for (String str2 : b()) {
                Object m332a = m332a(str2);
                sb.append("<property>");
                sb.append("<name>");
                sb.append(gn.a(str2));
                sb.append("</name>");
                sb.append("<value type=\"");
                if (m332a instanceof Integer) {
                    sb.append("integer\">");
                    sb.append(m332a);
                    str = "</value>";
                } else if (m332a instanceof Long) {
                    sb.append("long\">");
                    sb.append(m332a);
                    str = "</value>";
                } else if (m332a instanceof Float) {
                    sb.append("float\">");
                    sb.append(m332a);
                    str = "</value>";
                } else if (m332a instanceof Double) {
                    sb.append("double\">");
                    sb.append(m332a);
                    str = "</value>";
                } else if (m332a instanceof Boolean) {
                    sb.append("boolean\">");
                    sb.append(m332a);
                    str = "</value>";
                } else if (m332a instanceof String) {
                    sb.append("string\">");
                    sb.append(gn.a((String) m332a));
                    str = "</value>";
                } else {
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream = null;
                    }
                    try {
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            try {
                                try {
                                    objectOutputStream.writeObject(m332a);
                                    sb.append("java-object\">");
                                    sb.append(gn.a(byteArrayOutputStream.toByteArray()));
                                    sb.append("</value>");
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception unused) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    objectOutputStream2 = objectOutputStream;
                                    if (objectOutputStream2 != null) {
                                        try {
                                            objectOutputStream2.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e4) {
                                e2 = e4;
                                e2.printStackTrace();
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                                if (byteArrayOutputStream == null) {
                                    sb.append("</property>");
                                }
                                byteArrayOutputStream.close();
                            }
                        } catch (Exception e5) {
                            e = e5;
                            objectOutputStream = null;
                            e2 = e;
                            e2.printStackTrace();
                            if (objectOutputStream != null) {
                            }
                            if (byteArrayOutputStream == null) {
                            }
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th = th3;
                        }
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
        this.f38471i = str;
    }

    public String p() {
        return this.f38466d;
    }
}
