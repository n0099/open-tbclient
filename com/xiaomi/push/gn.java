package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class gn {

    /* renamed from: a  reason: collision with root package name */
    private int f14359a;

    /* renamed from: a  reason: collision with other field name */
    private String f482a;

    /* renamed from: a  reason: collision with other field name */
    private List<gg> f483a;

    /* renamed from: b  reason: collision with root package name */
    private String f14360b;
    private String c;
    private String d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f14361a = new a("internal-server-error");

        /* renamed from: b  reason: collision with root package name */
        public static final a f14362b = new a("forbidden");
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
        private String f484a;

        public a(String str) {
            this.f484a = str;
        }

        public String toString() {
            return this.f484a;
        }
    }

    public gn(int i, String str, String str2, String str3, String str4, List<gg> list) {
        this.f483a = null;
        this.f14359a = i;
        this.f482a = str;
        this.c = str2;
        this.f14360b = str3;
        this.d = str4;
        this.f483a = list;
    }

    public gn(Bundle bundle) {
        this.f483a = null;
        this.f14359a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f482a = bundle.getString("ext_err_type");
        }
        this.f14360b = bundle.getString("ext_err_cond");
        this.c = bundle.getString("ext_err_reason");
        this.d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f483a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                gg a2 = gg.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f483a.add(a2);
                }
            }
        }
    }

    public gn(a aVar) {
        this.f483a = null;
        a(aVar);
        this.d = null;
    }

    private void a(a aVar) {
        this.f14360b = aVar.f484a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (this.f482a != null) {
            bundle.putString("ext_err_type", this.f482a);
        }
        bundle.putInt("ext_err_code", this.f14359a);
        if (this.c != null) {
            bundle.putString("ext_err_reason", this.c);
        }
        if (this.f14360b != null) {
            bundle.putString("ext_err_cond", this.f14360b);
        }
        if (this.d != null) {
            bundle.putString("ext_err_msg", this.d);
        }
        if (this.f483a != null) {
            Bundle[] bundleArr = new Bundle[this.f483a.size()];
            int i = 0;
            Iterator<gg> it = this.f483a.iterator();
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
    public String m348a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"").append(this.f14359a).append("\"");
        if (this.f482a != null) {
            sb.append(" type=\"");
            sb.append(this.f482a);
            sb.append("\"");
        }
        if (this.c != null) {
            sb.append(" reason=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f14360b != null) {
            sb.append("<").append(this.f14360b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.d);
            sb.append("</text>");
        }
        for (gg ggVar : m349a()) {
            sb.append(ggVar.d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<gg> m349a() {
        return this.f483a == null ? Collections.emptyList() : Collections.unmodifiableList(this.f483a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f14360b != null) {
            sb.append(this.f14360b);
        }
        sb.append("(").append(this.f14359a).append(")");
        if (this.d != null) {
            sb.append(" ").append(this.d);
        }
        return sb.toString();
    }
}
