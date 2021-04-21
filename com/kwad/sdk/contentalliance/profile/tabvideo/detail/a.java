package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static List<AdTemplate> f33324a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f33325b;

    public static a a() {
        if (f33325b == null) {
            synchronized (a.class) {
                if (f33325b == null) {
                    f33325b = new a();
                }
            }
        }
        return f33325b;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f33324a == null) {
            f33324a = new ArrayList();
        }
        f33324a.clear();
        f33324a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f33324a;
    }

    public void c() {
        List<AdTemplate> list = f33324a;
        if (list != null) {
            list.clear();
        }
        f33324a = null;
    }
}
