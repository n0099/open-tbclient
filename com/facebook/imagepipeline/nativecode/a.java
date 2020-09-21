package com.facebook.imagepipeline.nativecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes25.dex */
public class a {
    public static final List<String> nHQ = Collections.unmodifiableList(new ArrayList());

    public static void load() {
        com.facebook.common.e.a.loadLibrary("imagepipeline");
    }
}
