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
    public static long f40556a;

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f424a;

    /* renamed from: c  reason: collision with root package name */
    public static String f40558c;

    /* renamed from: a  reason: collision with other field name */
    public gg f425a;

    /* renamed from: a  reason: collision with other field name */
    public List<fz> f426a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, Object> f427a;

    /* renamed from: d  reason: collision with root package name */
    public String f40559d;

    /* renamed from: e  reason: collision with root package name */
    public String f40560e;

    /* renamed from: f  reason: collision with root package name */
    public String f40561f;

    /* renamed from: g  reason: collision with root package name */
    public String f40562g;

    /* renamed from: h  reason: collision with root package name */
    public String f40563h;
    public String i;

    /* renamed from: a  reason: collision with other field name */
    public static final String f423a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: b  reason: collision with root package name */
    public static String f40557b = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f424a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        f40558c = gn.a(5) + "-";
        f40556a = 0L;
    }

    public gc() {
        this.f40559d = f40557b;
        this.f40560e = null;
        this.f40561f = null;
        this.f40562g = null;
        this.f40563h = null;
        this.i = null;
        this.f426a = new CopyOnWriteArrayList();
        this.f427a = new HashMap();
        this.f425a = null;
    }

    public gc(Bundle bundle) {
        this.f40559d = f40557b;
        this.f40560e = null;
        this.f40561f = null;
        this.f40562g = null;
        this.f40563h = null;
        this.i = null;
        this.f426a = new CopyOnWriteArrayList();
        this.f427a = new HashMap();
        this.f425a = null;
        this.f40561f = bundle.getString("ext_to");
        this.f40562g = bundle.getString("ext_from");
        this.f40563h = bundle.getString("ext_chid");
        this.f40560e = bundle.getString("ext_pkt_id");
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
            sb2.append(f40558c);
            long j = f40556a;
            f40556a = 1 + j;
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
        if (!TextUtils.isEmpty(this.f40559d)) {
            bundle.putString("ext_ns", this.f40559d);
        }
        if (!TextUtils.isEmpty(this.f40562g)) {
            bundle.putString("ext_from", this.f40562g);
        }
        if (!TextUtils.isEmpty(this.f40561f)) {
            bundle.putString("ext_to", this.f40561f);
        }
        if (!TextUtils.isEmpty(this.f40560e)) {
            bundle.putString("ext_pkt_id", this.f40560e);
        }
        if (!TextUtils.isEmpty(this.f40563h)) {
            bundle.putString("ext_chid", this.f40563h);
        }
        gg ggVar = this.f425a;
        if (ggVar != null) {
            bundle.putBundle("ext_ERROR", ggVar.a());
        }
        List<fz> list = this.f426a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            for (fz fzVar : this.f426a) {
                Bundle a2 = fzVar.a();
                if (a2 != null) {
                    bundleArr[i] = a2;
                    i++;
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
                if (str.equals(fzVar.m315a())) {
                    return fzVar;
                }
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public gg m324a() {
        return this.f425a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m325a(String str) {
        if (this.f427a == null) {
            return null;
        }
        return this.f427a.get(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m326a();

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<fz> m327a() {
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
            String str = this.f40562g;
            if (str == null ? gcVar.f40562g == null : str.equals(gcVar.f40562g)) {
                if (this.f426a.equals(gcVar.f426a)) {
                    String str2 = this.f40560e;
                    if (str2 == null ? gcVar.f40560e == null : str2.equals(gcVar.f40560e)) {
                        String str3 = this.f40563h;
                        if (str3 == null ? gcVar.f40563h == null : str3.equals(gcVar.f40563h)) {
                            Map<String, Object> map = this.f427a;
                            if (map == null ? gcVar.f427a == null : map.equals(gcVar.f427a)) {
                                String str4 = this.f40561f;
                                if (str4 == null ? gcVar.f40561f == null : str4.equals(gcVar.f40561f)) {
                                    String str5 = this.f40559d;
                                    String str6 = gcVar.f40559d;
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
        String str = this.f40559d;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f40560e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f40561f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f40562g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f40563h;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f426a.hashCode()) * 31) + this.f427a.hashCode()) * 31;
        gg ggVar = this.f425a;
        return hashCode5 + (ggVar != null ? ggVar.hashCode() : 0);
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.f40560e)) {
            return null;
        }
        if (this.f40560e == null) {
            this.f40560e = i();
        }
        return this.f40560e;
    }

    public String k() {
        return this.f40563h;
    }

    public void k(String str) {
        this.f40560e = str;
    }

    public String l() {
        return this.f40561f;
    }

    public void l(String str) {
        this.f40563h = str;
    }

    public String m() {
        return this.f40562g;
    }

    public void m(String str) {
        this.f40561f = str;
    }

    public String n() {
        return this.i;
    }

    public void n(String str) {
        this.f40562g = str;
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
        for (fz fzVar : m327a()) {
            sb.append(fzVar.d());
        }
        if (this.f427a != null && !this.f427a.isEmpty()) {
            sb.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
            for (String str2 : b()) {
                Object m325a = m325a(str2);
                sb.append("<property>");
                sb.append("<name>");
                sb.append(gn.a(str2));
                sb.append("</name>");
                sb.append("<value type=\"");
                if (m325a instanceof Integer) {
                    sb.append("integer\">");
                    sb.append(m325a);
                    str = "</value>";
                } else if (m325a instanceof Long) {
                    sb.append("long\">");
                    sb.append(m325a);
                    str = "</value>";
                } else if (m325a instanceof Float) {
                    sb.append("float\">");
                    sb.append(m325a);
                    str = "</value>";
                } else if (m325a instanceof Double) {
                    sb.append("double\">");
                    sb.append(m325a);
                    str = "</value>";
                } else if (m325a instanceof Boolean) {
                    sb.append("boolean\">");
                    sb.append(m325a);
                    str = "</value>";
                } else if (m325a instanceof String) {
                    sb.append("string\">");
                    sb.append(gn.a((String) m325a));
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
                                    objectOutputStream.writeObject(m325a);
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
        this.i = str;
    }

    public String p() {
        return this.f40559d;
    }
}
