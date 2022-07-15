package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class e {
    public static final List<String> a;

    /* loaded from: classes5.dex */
    public static class a extends DexClassLoader {
        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z) {
            if (!TextUtils.isEmpty(str) && str.startsWith("com.kwad.sdk.api")) {
                return getParent().loadClass(str);
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                findLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            return findLoadedClass != null ? findLoadedClass : super.loadClass(str, z);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add("com.kwad.sdk");
        a.add("com.ksad");
        a.add("com.kwai");
        a.add("kwad.support");
        a.add("android.support.rastermill");
    }

    @NonNull
    public static ClassLoader a(Context context, String str, String str2, String str3) {
        return new a(str, str2, str3, context.getClassLoader());
    }
}
