package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class e {
    public static final List<String> alF;

    /* loaded from: classes10.dex */
    public static class a extends DexClassLoader {
        public final ClassLoader alG;

        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
            this.alG = classLoader;
            new StringBuilder("pcl").append(this.alG.getClass().getName());
        }

        public static boolean bS(String str) {
            if (!TextUtils.isEmpty(str) && str.startsWith("com.kwad.sdk.api")) {
                return true;
            }
            return false;
        }

        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z) {
            if (bS(str)) {
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
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            return super.loadClass(str, z);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        alF = arrayList;
        arrayList.add("com.kwad.sdk");
        alF.add("com.ksad");
        alF.add("com.kwai");
        alF.add("kwad.support");
        alF.add("android.support.rastermill");
    }

    @NonNull
    public static ClassLoader a(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (t.b(context, "useContextClassLoader", false)) {
            classLoader = context.getClassLoader();
        }
        return new a(str, str2, str3, classLoader);
    }
}
