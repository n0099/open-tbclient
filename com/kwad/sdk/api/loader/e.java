package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class e {
    public static final List<String> Sl;

    /* loaded from: classes8.dex */
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
        Sl = arrayList;
        arrayList.add("com.kwad.sdk");
        Sl.add("com.ksad");
        Sl.add("com.kwai");
        Sl.add("kwad.support");
        Sl.add("android.support.rastermill");
    }

    @NonNull
    public static ClassLoader a(Context context, String str, String str2, String str3) {
        return new a(str, str2, str3, context.getClassLoader());
    }
}
