package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f34370a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f34371b = new Object();

    /* renamed from: e  reason: collision with root package name */
    public URLPackage f34374e;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, URLPackage> f34372c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, URLPackage> f34373d = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final URLPackage f34375f = new URLPackage("", 0);

    /* renamed from: g  reason: collision with root package name */
    public final EntryPackage f34376g = new EntryPackage("", 0);

    public static a a() {
        if (f34370a == null) {
            synchronized (f34371b) {
                if (f34370a == null) {
                    f34370a = new a();
                }
            }
        }
        return f34370a;
    }

    private void a(String str, @NonNull URLPackage uRLPackage) {
        if (this.f34372c.containsKey(str)) {
            return;
        }
        this.f34372c.put(str, uRLPackage);
    }

    @Nullable
    public URLPackage a(@NonNull String str) {
        URLPackage uRLPackage;
        return (TextUtils.isEmpty(str) || (uRLPackage = this.f34372c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f34375f : uRLPackage;
    }

    public void a(@NonNull SceneImpl sceneImpl) {
        String str;
        URLPackage uRLPackage;
        URLPackage urlPackage = sceneImpl.getUrlPackage();
        if (urlPackage == null) {
            return;
        }
        this.f34373d.put(urlPackage.identity, urlPackage);
        URLPackage uRLPackage2 = this.f34374e;
        if (uRLPackage2 != null) {
            if (!urlPackage.identity.equals(uRLPackage2.identity)) {
                str = urlPackage.identity;
                uRLPackage = this.f34374e;
            }
            this.f34374e = urlPackage;
        }
        str = urlPackage.identity;
        uRLPackage = this.f34375f;
        a(str, uRLPackage);
        this.f34374e = urlPackage;
    }

    public void a(String str, SceneImpl sceneImpl) {
        a(str, "", sceneImpl);
    }

    public void a(String str, String str2, SceneImpl sceneImpl) {
        if (str == null || sceneImpl == null || sceneImpl.getUrlPackage() == null) {
            return;
        }
        EntryPackage entryPackage = new EntryPackage();
        entryPackage.entryPageSource = str;
        entryPackage.entryId = str2;
        a(sceneImpl.getUrlPackage().identity, entryPackage);
    }

    public EntryPackage b(String str) {
        if (!TextUtils.isEmpty(str)) {
            URLPackage uRLPackage = this.f34372c.get(str);
            int size = this.f34372c.size();
            for (int i = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i < size; i++) {
                String str2 = uRLPackage.identity;
                if (TextUtils.isEmpty(str2)) {
                    break;
                }
                uRLPackage = this.f34372c.get(str2);
            }
            if (uRLPackage instanceof EntryPackage) {
                return (EntryPackage) uRLPackage;
            }
        }
        return this.f34376g;
    }

    public void c(@NonNull String str) {
        URLPackage uRLPackage;
        this.f34373d.remove(str);
        if (this.f34373d.size() == 0 && (uRLPackage = this.f34374e) != null && uRLPackage.identity.equals(str)) {
            this.f34374e = null;
        }
    }
}
