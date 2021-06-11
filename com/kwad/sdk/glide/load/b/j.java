package com.kwad.sdk.glide.load.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class j implements h {

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, List<i>> f35998c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Map<String, String> f35999d;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f36000a = b();

        /* renamed from: b  reason: collision with root package name */
        public static final Map<String, List<i>> f36001b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36002c = true;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, List<i>> f36003d = f36001b;

        /* renamed from: e  reason: collision with root package name */
        public boolean f36004e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f36000a)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(f36000a)));
            }
            f36001b = Collections.unmodifiableMap(hashMap);
        }

        @VisibleForTesting
        public static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    charAt = '?';
                }
                sb.append(charAt);
            }
            return sb.toString();
        }

        public j a() {
            this.f36002c = true;
            return new j(this.f36003d);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements i {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final String f36005a;

        public b(@NonNull String str) {
            this.f36005a = str;
        }

        @Override // com.kwad.sdk.glide.load.b.i
        public String a() {
            return this.f36005a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f36005a.equals(((b) obj).f36005a);
            }
            return false;
        }

        public int hashCode() {
            return this.f36005a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f36005a + "'}";
        }
    }

    public j(Map<String, List<i>> map) {
        this.f35998c = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String a(@NonNull List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String a2 = list.get(i2).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f35998c.entrySet()) {
            String a2 = a(entry.getValue());
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(entry.getKey(), a2);
            }
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.glide.load.b.h
    public Map<String, String> a() {
        if (this.f35999d == null) {
            synchronized (this) {
                if (this.f35999d == null) {
                    this.f35999d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f35999d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f35998c.equals(((j) obj).f35998c);
        }
        return false;
    }

    public int hashCode() {
        return this.f35998c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f35998c + '}';
    }
}
