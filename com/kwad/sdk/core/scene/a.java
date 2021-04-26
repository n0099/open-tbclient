package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f33453a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f33454b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, URLPackage> f33455c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, URLPackage> f33456d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final URLPackage f33457e = new URLPackage("", 0);

    /* renamed from: f  reason: collision with root package name */
    public final EntryPackage f33458f = new EntryPackage("", 0);

    public static a a() {
        if (f33453a == null) {
            synchronized (f33454b) {
                if (f33453a == null) {
                    f33453a = new a();
                }
            }
        }
        return f33453a;
    }

    @Nullable
    public URLPackage a(@NonNull String str) {
        URLPackage uRLPackage;
        return (TextUtils.isEmpty(str) || (uRLPackage = this.f33455c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f33457e : uRLPackage;
    }

    public EntryPackage b(String str) {
        if (!TextUtils.isEmpty(str)) {
            URLPackage uRLPackage = this.f33455c.get(str);
            int size = this.f33455c.size();
            for (int i2 = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i2 < size; i2++) {
                String str2 = uRLPackage.identity;
                if (TextUtils.isEmpty(str2)) {
                    break;
                }
                uRLPackage = this.f33455c.get(str2);
            }
            if (uRLPackage instanceof EntryPackage) {
                return (EntryPackage) uRLPackage;
            }
        }
        return this.f33458f;
    }
}
