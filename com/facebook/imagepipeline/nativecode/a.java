package com.facebook.imagepipeline.nativecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static final List<String> itP = Collections.unmodifiableList(new ArrayList());

    public static void load() {
        try {
            com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
        } catch (UnsatisfiedLinkError e) {
        }
        com.facebook.common.e.a.loadLibrary("imagepipeline");
    }
}
