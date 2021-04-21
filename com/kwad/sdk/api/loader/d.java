package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f32167a;

    /* loaded from: classes6.dex */
    public static class a extends DexClassLoader {
        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        private boolean a(String str) {
            return !TextUtils.isEmpty(str) && str.startsWith("com.kwad.sdk.api");
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z) {
            if (a(str)) {
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
        f32167a = arrayList;
        arrayList.add("com.kwad.sdk");
        f32167a.add("com.ksad");
        f32167a.add("com.kwai");
        f32167a.add("kwad.support");
        f32167a.add("android.support.rastermill");
    }

    @NonNull
    public static ClassLoader a(Context context, String str, String str2, String str3) {
        return new a(str, str2, str3, context.getClassLoader());
    }
}
