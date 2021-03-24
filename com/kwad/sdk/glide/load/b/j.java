package com.kwad.sdk.glide.load.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class j implements h {

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, List<i>> f35314c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Map<String, String> f35315d;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f35316a = b();

        /* renamed from: b  reason: collision with root package name */
        public static final Map<String, List<i>> f35317b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35318c = true;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, List<i>> f35319d = f35317b;

        /* renamed from: e  reason: collision with root package name */
        public boolean f35320e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f35316a)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(f35316a)));
            }
            f35317b = Collections.unmodifiableMap(hashMap);
        }

        @VisibleForTesting
        public static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    charAt = '?';
                }
                sb.append(charAt);
            }
            return sb.toString();
        }

        public j a() {
            this.f35318c = true;
            return new j(this.f35319d);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements i {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final String f35321a;

        public b(@NonNull String str) {
            this.f35321a = str;
        }

        @Override // com.kwad.sdk.glide.load.b.i
        public String a() {
            return this.f35321a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f35321a.equals(((b) obj).f35321a);
            }
            return false;
        }

        public int hashCode() {
            return this.f35321a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f35321a + "'}";
        }
    }

    public j(Map<String, List<i>> map) {
        this.f35314c = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String a(@NonNull List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String a2 = list.get(i).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f35314c.entrySet()) {
            String a2 = a(entry.getValue());
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(entry.getKey(), a2);
            }
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.glide.load.b.h
    public Map<String, String> a() {
        if (this.f35315d == null) {
            synchronized (this) {
                if (this.f35315d == null) {
                    this.f35315d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f35315d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f35314c.equals(((j) obj).f35314c);
        }
        return false;
    }

    public int hashCode() {
        return this.f35314c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f35314c + '}';
    }
}
