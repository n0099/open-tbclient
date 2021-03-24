package com.facebook.imagepipeline.nativecode;

import com.facebook.common.soloader.SoLoaderProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class ImagePipelineNativeLoader {
    public static final List<String> DEPENDENCIES = Collections.unmodifiableList(new ArrayList());
    public static final String DSO_NAME = "imagepipeline";

    public static void load() {
        SoLoaderProxy.loadLibrary(DSO_NAME);
    }
}
