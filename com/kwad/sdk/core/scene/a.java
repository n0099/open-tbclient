package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f34718a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f34719b = new Object();

    /* renamed from: e  reason: collision with root package name */
    public URLPackage f34722e;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, URLPackage> f34720c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, URLPackage> f34721d = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final URLPackage f34723f = new URLPackage("", 0);

    /* renamed from: g  reason: collision with root package name */
    public final EntryPackage f34724g = new EntryPackage("", 0);

    public static a a() {
        if (f34718a == null) {
            synchronized (f34719b) {
                if (f34718a == null) {
                    f34718a = new a();
                }
            }
        }
        return f34718a;
    }

    private void a(String str, @NonNull URLPackage uRLPackage) {
        if (this.f34720c.containsKey(str)) {
            return;
        }
        this.f34720c.put(str, uRLPackage);
    }

    @Nullable
    public URLPackage a(@NonNull String str) {
        URLPackage uRLPackage;
        return (TextUtils.isEmpty(str) || (uRLPackage = this.f34720c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f34723f : uRLPackage;
    }

    public void a(@NonNull SceneImpl sceneImpl) {
        String str;
        URLPackage uRLPackage;
        URLPackage urlPackage = sceneImpl.getUrlPackage();
        if (urlPackage == null) {
            return;
        }
        this.f34721d.put(urlPackage.identity, urlPackage);
        URLPackage uRLPackage2 = this.f34722e;
        if (uRLPackage2 != null) {
            if (!urlPackage.identity.equals(uRLPackage2.identity)) {
                str = urlPackage.identity;
                uRLPackage = this.f34722e;
            }
            this.f34722e = urlPackage;
        }
        str = urlPackage.identity;
        uRLPackage = this.f34723f;
        a(str, uRLPackage);
        this.f34722e = urlPackage;
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
            URLPackage uRLPackage = this.f34720c.get(str);
            int size = this.f34720c.size();
            for (int i2 = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i2 < size; i2++) {
                String str2 = uRLPackage.identity;
                if (TextUtils.isEmpty(str2)) {
                    break;
                }
                uRLPackage = this.f34720c.get(str2);
            }
            if (uRLPackage instanceof EntryPackage) {
                return (EntryPackage) uRLPackage;
            }
        }
        return this.f34724g;
    }

    public void c(@NonNull String str) {
        URLPackage uRLPackage;
        this.f34721d.remove(str);
        if (this.f34721d.size() == 0 && (uRLPackage = this.f34722e) != null && uRLPackage.identity.equals(str)) {
            this.f34722e = null;
        }
    }
}
