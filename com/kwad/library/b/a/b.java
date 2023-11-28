package com.kwad.library.b.a;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public final class b extends BaseDexClassLoader {
    public final List<String> aip;
    public final List<String> aiq;
    public final ClassLoader air;

    public b(ClassLoader classLoader, String str, @Nullable File file, String str2, List<String> list, List<String> list2) {
        super(str, file, str2, classLoader);
        this.air = classLoader;
        this.aip = list;
        this.aiq = list2;
        while (classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
        Log.i("PluginClassLoader", "mParent is " + classLoader.getClass().getName());
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        String findLibrary = super.findLibrary(str);
        if (TextUtils.isEmpty(findLibrary) && (this.air instanceof BaseDexClassLoader)) {
            StringBuilder sb = new StringBuilder("load so ");
            sb.append(str);
            sb.append(" from parent");
            return ((BaseDexClassLoader) this.air).findLibrary(str);
        }
        return findLibrary;
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) {
        List<String> list = this.aip;
        if (list != null && list.contains(str)) {
            Log.i("PluginClassLoader", "loadClass " + str + " from host by interface");
            return super.loadClass(str, z);
        }
        List<String> list2 = this.aiq;
        if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next() + ".")) {
                    return super.loadClass(str, z);
                }
            }
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException e) {
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException e2) {
                if (Build.VERSION.SDK_INT >= 19) {
                    e2.addSuppressed(e);
                }
                throw e2;
            }
        }
    }
}
