package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f5460a = new ArrayList();

    /* loaded from: classes3.dex */
    private static class a extends DexClassLoader {
        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        private boolean a(String str) {
            return !TextUtils.isEmpty(str) && str.startsWith("com.kwad.sdk.api");
        }

        @Override // java.lang.ClassLoader
        protected Class<?> loadClass(String str, boolean z) {
            if (a(str)) {
                return getParent().loadClass(str);
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass == null) {
                try {
                    findLoadedClass = findClass(str);
                } catch (ClassNotFoundException e) {
                }
                return findLoadedClass == null ? super.loadClass(str, z) : findLoadedClass;
            }
            return findLoadedClass;
        }
    }

    static {
        f5460a.add("com.kwad.sdk");
        f5460a.add("com.ksad");
        f5460a.add("com.kwai");
        f5460a.add("kwad.support");
        f5460a.add("android.support.rastermill");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static ClassLoader a(Context context, String str, String str2, String str3) {
        return new a(str, str2, str3, context.getClassLoader());
    }
}
