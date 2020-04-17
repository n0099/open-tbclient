package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class gh {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private String f416a;

    /* renamed from: a  reason: collision with other field name */
    private List<ga> f417a;
    private String b;
    private String c;
    private String d;

    /* loaded from: classes8.dex */
    public static class a {
        public static final a a = new a("internal-server-error");
        public static final a b = new a("forbidden");
        public static final a c = new a("bad-request");
        public static final a d = new a("conflict");
        public static final a e = new a("feature-not-implemented");
        public static final a f = new a("gone");
        public static final a g = new a("item-not-found");
        public static final a h = new a("jid-malformed");
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
        private String f418a;

        public a(String str) {
            this.f418a = str;
        }

        public String toString() {
            return this.f418a;
        }
    }

    public gh(int i, String str, String str2, String str3, String str4, List<ga> list) {
        this.f417a = null;
        this.a = i;
        this.f416a = str;
        this.c = str2;
        this.b = str3;
        this.d = str4;
        this.f417a = list;
    }

    public gh(Bundle bundle) {
        this.f417a = null;
        this.a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f416a = bundle.getString("ext_err_type");
        }
        this.b = bundle.getString("ext_err_cond");
        this.c = bundle.getString("ext_err_reason");
        this.d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f417a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                ga a2 = ga.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f417a.add(a2);
                }
            }
        }
    }

    public gh(a aVar) {
        this.f417a = null;
        a(aVar);
        this.d = null;
    }

    private void a(a aVar) {
        this.b = aVar.f418a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (this.f416a != null) {
            bundle.putString("ext_err_type", this.f416a);
        }
        bundle.putInt("ext_err_code", this.a);
        if (this.c != null) {
            bundle.putString("ext_err_reason", this.c);
        }
        if (this.b != null) {
            bundle.putString("ext_err_cond", this.b);
        }
        if (this.d != null) {
            bundle.putString("ext_err_msg", this.d);
        }
        if (this.f417a != null) {
            Bundle[] bundleArr = new Bundle[this.f417a.size()];
            int i = 0;
            Iterator<ga> it = this.f417a.iterator();
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

    /* renamed from: a  reason: collision with other method in class */
    public String m310a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"").append(this.a).append("\"");
        if (this.f416a != null) {
            sb.append(" type=\"");
            sb.append(this.f416a);
            sb.append("\"");
        }
        if (this.c != null) {
            sb.append(" reason=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.b != null) {
            sb.append("<").append(this.b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.d);
            sb.append("</text>");
        }
        for (ga gaVar : m311a()) {
            sb.append(gaVar.d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<ga> m311a() {
        return this.f417a == null ? Collections.emptyList() : Collections.unmodifiableList(this.f417a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.b != null) {
            sb.append(this.b);
        }
        sb.append("(").append(this.a).append(")");
        if (this.d != null) {
            sb.append(" ").append(this.d);
        }
        return sb.toString();
    }
}
