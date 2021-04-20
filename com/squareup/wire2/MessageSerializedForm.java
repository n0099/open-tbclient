package com.squareup.wire2;

import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
/* loaded from: classes6.dex */
public final class MessageSerializedForm<M extends Message<M, B>, B extends Message.a<M, B>> implements Serializable {
    public static final long serialVersionUID = 0;
    public final byte[] bytes;
    public final Class<M> messageClass;

    public MessageSerializedForm(byte[] bArr, Class<M> cls) {
        this.bytes = bArr;
        this.messageClass = cls;
    }

    public Object readResolve() throws ObjectStreamException {
        try {
            return ProtoAdapter.get(this.messageClass).decode(this.bytes);
        } catch (IOException e2) {
            throw new StreamCorruptedException(e2.getMessage());
        }
    }
}
