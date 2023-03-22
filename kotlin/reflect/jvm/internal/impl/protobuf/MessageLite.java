package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
/* loaded from: classes9.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* loaded from: classes9.dex */
    public interface Builder extends Cloneable, MessageLiteOrBuilder {
        MessageLite build();

        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
