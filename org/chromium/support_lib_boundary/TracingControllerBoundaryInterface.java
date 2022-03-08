package org.chromium.support_lib_boundary;

import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public interface TracingControllerBoundaryInterface {
    boolean isTracing();

    void start(int i2, Collection<String> collection, int i3) throws IllegalStateException, IllegalArgumentException;

    boolean stop(OutputStream outputStream, Executor executor);
}
