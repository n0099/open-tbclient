package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.io.TaggedIOException;
/* loaded from: classes.dex */
public class TaggedOutputStream extends ProxyOutputStream {
    private final Serializable tag;

    public TaggedOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.tag = UUID.randomUUID();
    }

    public boolean isCauseOf(Exception exc) {
        return TaggedIOException.isTaggedWith(exc, this.tag);
    }

    public void throwIfCauseOf(Exception exc) {
        TaggedIOException.throwCauseIfTaggedWith(exc, this.tag);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream
    protected void handleIOException(IOException iOException) {
        throw new TaggedIOException(iOException, this.tag);
    }
}
