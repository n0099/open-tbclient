package com.kwad.sdk.crash.model.message;

import java.io.Serializable;
/* loaded from: classes7.dex */
public final class CaughtExceptionMessage extends JavaExceptionMessage implements Serializable {
    public static final long serialVersionUID = -4220068453451250185L;

    @Override // com.kwad.sdk.crash.model.message.JavaExceptionMessage, com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String getTypePrefix() {
        return "CAUGHT_";
    }
}
