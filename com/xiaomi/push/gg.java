package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class gg {

    /* renamed from: a  reason: collision with root package name */
    public int f40869a;

    /* renamed from: a  reason: collision with other field name */
    public String f432a;

    /* renamed from: a  reason: collision with other field name */
    public List<fz> f433a;

    /* renamed from: b  reason: collision with root package name */
    public String f40870b;

    /* renamed from: c  reason: collision with root package name */
    public String f40871c;

    /* renamed from: d  reason: collision with root package name */
    public String f40872d;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f40873a = new a("internal-server-error");

        /* renamed from: b  reason: collision with root package name */
        public static final a f40874b = new a("forbidden");

        /* renamed from: c  reason: collision with root package name */
        public static final a f40875c = new a("bad-request");

        /* renamed from: d  reason: collision with root package name */
        public static final a f40876d = new a("conflict");

        /* renamed from: e  reason: collision with root package name */
        public static final a f40877e = new a("feature-not-implemented");

        /* renamed from: f  reason: collision with root package name */
        public static final a f40878f = new a("gone");

        /* renamed from: g  reason: collision with root package name */
        public static final a f40879g = new a("item-not-found");

        /* renamed from: h  reason: collision with root package name */
        public static final a f40880h = new a("jid-malformed");
        public static final a i = new a("not-acceptable");
        public static final a j = new a("not-allowed");
        public static final a k = new a("not-authorized");
        public static final a l = new a("payment-required");
        public static final a m = new a("recipient-unavailable");
        public static final a n = new a("redirect");
        public static final a o = new a("registration-required");
        public static final a p = new a("remote-server-error");
        public static final a q = new a("remote-server-not-found");
        public static final a r = new a("remote-server-timeout");
        public static final a s = new a("resource-constraint");
        public static final a t = new a("service-unavailable");
        public static final a u = new a("subscription-required");
        public static final a v = new a("undefined-condition");
        public static final a w = new a("unexpected-request");
        public static final a x = new a("request-timeout");

        /* renamed from: a  reason: collision with other field name */
        public String f434a;

        public a(String str) {
            this.f434a = str;
        }

        public String toString() {
            return this.f434a;
        }
    }

    public gg(int i, String str, String str2, String str3, String str4, List<fz> list) {
        this.f433a = null;
        this.f40869a = i;
        this.f432a = str;
        this.f40871c = str2;
        this.f40870b = str3;
        this.f40872d = str4;
        this.f433a = list;
    }

    public gg(Bundle bundle) {
        this.f433a = null;
        this.f40869a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f432a = bundle.getString("ext_err_type");
        }
        this.f40870b = bundle.getString("ext_err_cond");
        this.f40871c = bundle.getString("ext_err_reason");
        this.f40872d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f433a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fz a2 = fz.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f433a.add(a2);
                }
            }
        }
    }

    public gg(a aVar) {
        this.f433a = null;
        a(aVar);
        this.f40872d = null;
    }

    private void a(a aVar) {
        this.f40870b = aVar.f434a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f432a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f40869a);
        String str2 = this.f40871c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f40870b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f40872d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<fz> list = this.f433a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            for (fz fzVar : this.f433a) {
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

    /* renamed from: a  reason: collision with other method in class */
    public String m332a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.f40869a);
        sb.append("\"");
        if (this.f432a != null) {
            sb.append(" type=\"");
            sb.append(this.f432a);
            sb.append("\"");
        }
        if (this.f40871c != null) {
            sb.append(" reason=\"");
            sb.append(this.f40871c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f40870b != null) {
            sb.append("<");
            sb.append(this.f40870b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f40872d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.f40872d);
            sb.append("</text>");
        }
        for (fz fzVar : m333a()) {
            sb.append(fzVar.d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<fz> m333a() {
        if (this.f433a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.f433a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f40870b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.f40869a);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        if (this.f40872d != null) {
            sb.append(" ");
            sb.append(this.f40872d);
        }
        return sb.toString();
    }
}
