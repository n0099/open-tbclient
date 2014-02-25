package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.io.TaggedIOException;
/* loaded from: classes.dex */
public class TaggedInputStream extends ProxyInputStream {
    private final Serializable tag;

    public TaggedInputStream(InputStream inputStream) {
        super(inputStream);
        this.tag = UUID.randomUUID();
    }

    public boolean isCauseOf(Throwable th) {
        return TaggedIOException.isTaggedWith(th, this.tag);
    }

    public void throwIfCauseOf(Throwable th) {
        TaggedIOException.throwCauseIfTaggedWith(th, this.tag);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    protected void handleIOException(IOException iOException) {
        throw new TaggedIOException(iOException, this.tag);
    }
}
