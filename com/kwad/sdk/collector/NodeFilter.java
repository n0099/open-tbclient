package com.kwad.sdk.collector;

import java.io.File;
import java.io.Serializable;
/* loaded from: classes5.dex */
public interface NodeFilter extends Serializable {
    void onChildNodeCreate(FNode fNode);

    boolean onFilterChild(File file);
}
