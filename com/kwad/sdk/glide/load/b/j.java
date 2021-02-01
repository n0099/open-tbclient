package com.kwad.sdk.glide.load.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class j implements h {
    private final Map<String, List<i>> c;
    private volatile Map<String, String> d;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final String f10091a = b();

        /* renamed from: b  reason: collision with root package name */
        private static final Map<String, List<i>> f10092b;
        private boolean c = true;
        private Map<String, List<i>> d = f10092b;
        private boolean e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f10091a)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(f10091a)));
            }
            f10092b = Collections.unmodifiableMap(hashMap);
        }

        @VisibleForTesting
        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public j a() {
            this.c = true;
            return new j(this.d);
        }
    }

    /* loaded from: classes3.dex */
    static final class b implements i {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final String f10093a;

        b(@NonNull String str) {
            this.f10093a = str;
        }

        @Override // com.kwad.sdk.glide.load.b.i
        public String a() {
            return this.f10093a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f10093a.equals(((b) obj).f10093a);
            }
            return false;
        }

        public int hashCode() {
            return this.f10093a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f10093a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.c = Collections.unmodifiableMap(map);
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
        for (Map.Entry<String, List<i>> entry : this.c.entrySet()) {
            String a2 = a(entry.getValue());
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(entry.getKey(), a2);
            }
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.glide.load.b.h
    public Map<String, String> a() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.c.equals(((j) obj).c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.c + '}';
    }
}
