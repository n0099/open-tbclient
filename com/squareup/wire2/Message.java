package com.squareup.wire2;

import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
/* loaded from: classes24.dex */
public abstract class Message<M extends Message<M, B>, B extends a<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    transient int cachedSerializedSize = 0;
    protected transient int hashCode = 0;
    private final transient ByteString unknownFields;

    public abstract a<M, B> newBuilder();

    /* JADX INFO: Access modifiers changed from: protected */
    public Message(ProtoAdapter<M> protoAdapter, ByteString byteString) {
        if (protoAdapter == null) {
            throw new NullPointerException("adapter == null");
        }
        if (byteString == null) {
            throw new NullPointerException("unknownFields == null");
        }
        this.adapter = protoAdapter;
        this.unknownFields = byteString;
    }

    public final ByteString unknownFields() {
        ByteString byteString = this.unknownFields;
        return byteString != null ? byteString : ByteString.EMPTY;
    }

    public final M withoutUnknownFields() {
        return newBuilder().clearUnknownFields().build();
    }

    public String toString() {
        return this.adapter.toString(this);
    }

    protected final Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(BufferedSink bufferedSink) throws IOException {
        this.adapter.encode(bufferedSink, (BufferedSink) this);
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final void encode(OutputStream outputStream) throws IOException {
        this.adapter.encode(outputStream, (OutputStream) this);
    }

    /* loaded from: classes24.dex */
    public static abstract class a<T extends Message<T, B>, B extends a<T, B>> {
        Buffer unknownFieldsBuffer;
        d unknownFieldsWriter;

        public abstract T build();

        public final a<T, B> addUnknownFields(ByteString byteString) {
            if (byteString.size() > 0) {
                if (this.unknownFieldsWriter == null) {
                    this.unknownFieldsBuffer = new Buffer();
                    this.unknownFieldsWriter = new d(this.unknownFieldsBuffer);
                }
                try {
                    this.unknownFieldsWriter.b(byteString);
                } catch (IOException e) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public final a<T, B> addUnknownField(int i, FieldEncoding fieldEncoding, Object obj) {
            if (this.unknownFieldsWriter == null) {
                this.unknownFieldsBuffer = new Buffer();
                this.unknownFieldsWriter = new d(this.unknownFieldsBuffer);
            }
            try {
                fieldEncoding.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, i, obj);
                return this;
            } catch (IOException e) {
                throw new AssertionError();
            }
        }

        public final a<T, B> clearUnknownFields() {
            this.unknownFieldsWriter = null;
            this.unknownFieldsBuffer = null;
            return this;
        }

        public final ByteString buildUnknownFields() {
            return this.unknownFieldsBuffer != null ? this.unknownFieldsBuffer.clone().readByteString() : ByteString.EMPTY;
        }
    }
}
