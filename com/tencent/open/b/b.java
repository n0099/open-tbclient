package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, String> f40167a = new HashMap<>();

    public b(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f40167a.put(str, bundle.getString(str));
            }
        }
    }
}
