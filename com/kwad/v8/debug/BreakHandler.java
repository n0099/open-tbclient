package com.kwad.v8.debug;

import com.kwad.v8.V8Object;
import com.kwad.v8.debug.DebugHandler;
/* loaded from: classes7.dex */
public interface BreakHandler {
    void onBreak(DebugHandler.DebugEvent debugEvent, ExecutionState executionState, EventData eventData, V8Object v8Object);
}
