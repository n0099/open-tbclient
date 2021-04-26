package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes6.dex */
public final class BuilderAdapter<B extends Message.Builder> {
    public static final Comparator<Field> ORDER_BY_FIELD_NAME = new Comparator<Field>() { // from class: com.squareup.wire.BuilderAdapter.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    };
    public static final int SUFFIX_LENGTH = 8;
    public final List<Field> requiredFields = new ArrayList();

    public BuilderAdapter(Class<B> cls) {
        Field[] declaredFields;
        String name = cls.getName();
        try {
            for (Field field : Class.forName(name.substring(0, name.length() - SUFFIX_LENGTH)).getDeclaredFields()) {
                ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
                if (protoField != null && protoField.label() == Message.Label.REQUIRED) {
                    try {
                        this.requiredFields.add(cls.getField(field.getName()));
                    } catch (NoSuchFieldException unused) {
                        throw new AssertionError("No builder field found for message field " + field.getName());
                    }
                }
            }
            Collections.sort(this.requiredFields, ORDER_BY_FIELD_NAME);
        } catch (ClassNotFoundException unused2) {
            throw new AssertionError("No message class found for builder type " + name);
        }
    }

    public <B extends Message.Builder> void checkRequiredFields(B b2) {
        try {
            int size = this.requiredFields.size();
            StringBuilder sb = null;
            String str = "";
            for (int i2 = 0; i2 < size; i2++) {
                Field field = this.requiredFields.get(i2);
                if (field.get(b2) == null) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    } else {
                        str = "s";
                    }
                    sb.append("\n  ");
                    sb.append(field.getName());
                }
            }
            if (sb == null) {
                return;
            }
            throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
        } catch (IllegalAccessException unused) {
            throw new AssertionError("Unable to access required fields");
        }
    }
}
