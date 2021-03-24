package com.squareup.wire;

import com.baidu.mobstat.Config;
import com.squareup.wire.Message;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class Wire {
    public final Map<Class<? extends Message.Builder>, BuilderAdapter<? extends Message.Builder>> builderAdapters;
    public final Map<Class<? extends ProtoEnum>, EnumAdapter<? extends ProtoEnum>> enumAdapters;
    public final Map<Class<? extends Message>, MessageAdapter<? extends Message>> messageAdapters;
    public final ExtensionRegistry registry;

    public Wire(Class<?>... clsArr) {
        this(Arrays.asList(clsArr));
    }

    public static <T> T get(T t, T t2) {
        return t != null ? t : t2;
    }

    public synchronized <B extends Message.Builder> BuilderAdapter<B> builderAdapter(Class<B> cls) {
        BuilderAdapter<B> builderAdapter;
        builderAdapter = (BuilderAdapter<B>) this.builderAdapters.get(cls);
        if (builderAdapter == null) {
            builderAdapter = new BuilderAdapter<>(cls);
            this.builderAdapters.put(cls, builderAdapter);
        }
        return builderAdapter;
    }

    public synchronized <E extends ProtoEnum> EnumAdapter<E> enumAdapter(Class<E> cls) {
        EnumAdapter<E> enumAdapter;
        enumAdapter = (EnumAdapter<E>) this.enumAdapters.get(cls);
        if (enumAdapter == null) {
            enumAdapter = new EnumAdapter<>(cls);
            this.enumAdapters.put(cls, enumAdapter);
        }
        return enumAdapter;
    }

    public synchronized <M extends Message> MessageAdapter<M> messageAdapter(Class<M> cls) {
        MessageAdapter<M> messageAdapter;
        messageAdapter = (MessageAdapter<M>) this.messageAdapters.get(cls);
        if (messageAdapter == null) {
            messageAdapter = new MessageAdapter<>(this, cls);
            this.messageAdapters.put(cls, messageAdapter);
        }
        return messageAdapter;
    }

    public <M extends Message> M parseFrom(byte[] bArr, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(bArr, "bytes");
        Preconditions.checkNotNull(cls, "messageClass");
        return (M) parseFrom(WireInput.newInstance(bArr), cls);
    }

    public Wire(List<Class<?>> list) {
        Field[] declaredFields;
        this.messageAdapters = new LinkedHashMap();
        this.builderAdapters = new LinkedHashMap();
        this.enumAdapters = new LinkedHashMap();
        this.registry = new ExtensionRegistry();
        for (Class<?> cls : list) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType().equals(Extension.class)) {
                    try {
                        this.registry.add((Extension) field.get(null));
                    } catch (IllegalAccessException e2) {
                        throw new AssertionError(e2);
                    }
                }
            }
        }
    }

    public <M extends Message> M parseFrom(byte[] bArr, int i, int i2, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(bArr, "bytes");
        Preconditions.checkArgument(i >= 0, "offset < 0");
        Preconditions.checkArgument(i2 >= 0, "count < 0");
        Preconditions.checkArgument(i + i2 <= bArr.length, "offset + count > bytes");
        Preconditions.checkNotNull(cls, "messageClass");
        return (M) parseFrom(WireInput.newInstance(bArr, i, i2), cls);
    }

    public <M extends Message> M parseFrom(InputStream inputStream, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(inputStream, Config.INPUT_PART);
        Preconditions.checkNotNull(cls, "messageClass");
        return (M) parseFrom(WireInput.newInstance(inputStream), cls);
    }

    private <M extends Message> M parseFrom(WireInput wireInput, Class<M> cls) throws IOException {
        return messageAdapter(cls).read(wireInput);
    }
}
