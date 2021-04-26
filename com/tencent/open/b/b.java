package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, String> f37211a = new HashMap<>();

    public b(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f37211a.put(str, bundle.getString(str));
            }
        }
    }
}
