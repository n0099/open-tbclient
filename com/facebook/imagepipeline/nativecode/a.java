package com.facebook.imagepipeline.nativecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    public static final List<String> oZv = Collections.unmodifiableList(new ArrayList());

    public static void load() {
        com.facebook.common.e.a.loadLibrary("imagepipeline");
    }
}
