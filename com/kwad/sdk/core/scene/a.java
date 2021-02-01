package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f9438a;

    /* renamed from: b  reason: collision with root package name */
    private static Object f9439b = new Object();
    private URLPackage e;
    private HashMap<String, URLPackage> c = new HashMap<>();
    private HashMap<String, URLPackage> d = new HashMap<>();
    private final URLPackage f = new URLPackage("", 0);
    private final EntryPackage g = new EntryPackage("", 0);

    public static a a() {
        if (f9438a == null) {
            synchronized (f9439b) {
                if (f9438a == null) {
                    f9438a = new a();
                }
            }
        }
        return f9438a;
    }

    private void a(String str, @NonNull URLPackage uRLPackage) {
        if (this.c.containsKey(str)) {
            return;
        }
        this.c.put(str, uRLPackage);
    }

    @Nullable
    public URLPackage a(@NonNull String str) {
        URLPackage uRLPackage;
        return (TextUtils.isEmpty(str) || (uRLPackage = this.c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f : uRLPackage;
    }

    public void a(@NonNull SceneImpl sceneImpl) {
        URLPackage urlPackage = sceneImpl.getUrlPackage();
        if (urlPackage == null) {
            return;
        }
        this.d.put(urlPackage.identity, urlPackage);
        if (this.e == null) {
            a(urlPackage.identity, this.f);
        } else if (!urlPackage.identity.equals(this.e.identity)) {
            a(urlPackage.identity, this.e);
        }
        this.e = urlPackage;
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
            URLPackage uRLPackage = this.c.get(str);
            int size = this.c.size();
            for (int i = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i < size; i++) {
                String str2 = uRLPackage.identity;
                if (TextUtils.isEmpty(str2)) {
                    break;
                }
                uRLPackage = this.c.get(str2);
            }
            if (uRLPackage instanceof EntryPackage) {
                return (EntryPackage) uRLPackage;
            }
        }
        return this.g;
    }

    public void c(@NonNull String str) {
        this.d.remove(str);
        if (this.d.size() == 0 && this.e != null && this.e.identity.equals(str)) {
            this.e = null;
        }
    }
}
