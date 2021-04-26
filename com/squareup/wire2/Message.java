package com.squareup.wire2;

import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import d.n.a.d;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
/* loaded from: classes6.dex */
public abstract class Message<M extends Message<M, B>, B extends a<M, B>> implements Serializable {
    public static final long serialVersionUID = 0;
    public final transient ProtoAdapter<M> adapter;
    public transient int cachedSerializedSize = 0;
    public transient int hashCode = 0;
    public final transient ByteString unknownFields;

    /* loaded from: classes6.dex */
    public static abstract class a<T extends Message<T, B>, B extends a<T, B>> {
        public Buffer unknownFieldsBuffer;
        public d unknownFieldsWriter;

        public final a<T, B> addUnknownField(int i2, FieldEncoding fieldEncoding, Object obj) {
            if (this.unknownFieldsWriter == null) {
                Buffer buffer = new Buffer();
                this.unknownFieldsBuffer = buffer;
                this.unknownFieldsWriter = new d(buffer);
            }
            try {
                fieldEncoding.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, i2, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        public final a<T, B> addUnknownFields(ByteString byteString) {
            if (byteString.size() > 0) {
                if (this.unknownFieldsWriter == null) {
                    Buffer buffer = new Buffer();
                    this.unknownFieldsBuffer = buffer;
                    this.unknownFieldsWriter = new d(buffer);
                }
                try {
                    this.unknownFieldsWriter.k(byteString);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public abstract T build();

        public final ByteString buildUnknownFields() {
            Buffer buffer = this.unknownFieldsBuffer;
            return buffer != null ? buffer.clone().readByteString() : ByteString.EMPTY;
        }

        public final a<T, B> clearUnknownFields() {
            this.unknownFieldsWriter = null;
            this.unknownFieldsBuffer = null;
            return this;
        }
    }

    public Message(ProtoAdapter<M> protoAdapter, ByteString byteString) {
        if (protoAdapter == null) {
            throw new NullPointerException("adapter == null");
        }
        if (byteString != null) {
            this.adapter = protoAdapter;
            this.unknownFields = byteString;
            return;
        }
        throw new NullPointerException("unknownFields == null");
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(BufferedSink bufferedSink) throws IOException {
        this.adapter.encode(bufferedSink, (BufferedSink) this);
    }

    public abstract a<M, B> newBuilder();

    public String toString() {
        return this.adapter.toString(this);
    }

    public final ByteString unknownFields() {
        ByteString byteString = this.unknownFields;
        return byteString != null ? byteString : ByteString.EMPTY;
    }

    public final M withoutUnknownFields() {
        return newBuilder().clearUnknownFields().build();
    }

    public final Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final void encode(OutputStream outputStream) throws IOException {
        this.adapter.encode(outputStream, (OutputStream) this);
    }
}
