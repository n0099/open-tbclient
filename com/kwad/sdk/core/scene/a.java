package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f34816a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f34817b = new Object();

    /* renamed from: e  reason: collision with root package name */
    public URLPackage f34820e;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, URLPackage> f34818c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, URLPackage> f34819d = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final URLPackage f34821f = new URLPackage("", 0);

    /* renamed from: g  reason: collision with root package name */
    public final EntryPackage f34822g = new EntryPackage("", 0);

    public static a a() {
        if (f34816a == null) {
            synchronized (f34817b) {
                if (f34816a == null) {
                    f34816a = new a();
                }
            }
        }
        return f34816a;
    }

    private void a(String str, @NonNull URLPackage uRLPackage) {
        if (this.f34818c.containsKey(str)) {
            return;
        }
        this.f34818c.put(str, uRLPackage);
    }

    @Nullable
    public URLPackage a(@NonNull String str) {
        URLPackage uRLPackage;
        return (TextUtils.isEmpty(str) || (uRLPackage = this.f34818c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f34821f : uRLPackage;
    }

    public void a(@NonNull SceneImpl sceneImpl) {
        String str;
        URLPackage uRLPackage;
        URLPackage urlPackage = sceneImpl.getUrlPackage();
        if (urlPackage == null) {
            return;
        }
        this.f34819d.put(urlPackage.identity, urlPackage);
        URLPackage uRLPackage2 = this.f34820e;
        if (uRLPackage2 != null) {
            if (!urlPackage.identity.equals(uRLPackage2.identity)) {
                str = urlPackage.identity;
                uRLPackage = this.f34820e;
            }
            this.f34820e = urlPackage;
        }
        str = urlPackage.identity;
        uRLPackage = this.f34821f;
        a(str, uRLPackage);
        this.f34820e = urlPackage;
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
            URLPackage uRLPackage = this.f34818c.get(str);
            int size = this.f34818c.size();
            for (int i2 = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i2 < size; i2++) {
                String str2 = uRLPackage.identity;
                if (TextUtils.isEmpty(str2)) {
                    break;
                }
                uRLPackage = this.f34818c.get(str2);
            }
            if (uRLPackage instanceof EntryPackage) {
                return (EntryPackage) uRLPackage;
            }
        }
        return this.f34822g;
    }

    public void c(@NonNull String str) {
        URLPackage uRLPackage;
        this.f34819d.remove(str);
        if (this.f34819d.size() == 0 && (uRLPackage = this.f34820e) != null && uRLPackage.identity.equals(str)) {
            this.f34820e = null;
        }
    }
}
