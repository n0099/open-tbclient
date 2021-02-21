package com.facebook.imagepipeline.nativecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static final List<String> pLE = Collections.unmodifiableList(new ArrayList());

    public static void load() {
        com.facebook.common.e.a.loadLibrary("imagepipeline");
    }
}
