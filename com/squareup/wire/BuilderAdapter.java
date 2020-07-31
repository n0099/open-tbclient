package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class BuilderAdapter<B extends Message.Builder> {
    private final List<Field> requiredFields = new ArrayList();
    private static final int SUFFIX_LENGTH = "$Builder".length();
    private static final Comparator<Field> ORDER_BY_FIELD_NAME = new Comparator<Field>() { // from class: com.squareup.wire.BuilderAdapter.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    };

    public BuilderAdapter(Class<B> cls) {
        String name = cls.getName();
        try {
            Field[] declaredFields = Class.forName(name.substring(0, name.length() - SUFFIX_LENGTH)).getDeclaredFields();
            for (Field field : declaredFields) {
                ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
                if (protoField != null && protoField.label() == Message.Label.REQUIRED) {
                    try {
                        this.requiredFields.add(cls.getField(field.getName()));
                    } catch (NoSuchFieldException e) {
                        throw new AssertionError("No builder field found for message field " + field.getName());
                    }
                }
            }
            Collections.sort(this.requiredFields, ORDER_BY_FIELD_NAME);
        } catch (ClassNotFoundException e2) {
            throw new AssertionError("No message class found for builder type " + name);
        }
    }

    public <B extends Message.Builder> void checkRequiredFields(B b) {
        StringBuilder sb = null;
        String str = "";
        try {
            int size = this.requiredFields.size();
            int i = 0;
            while (i < size) {
                Field field = this.requiredFields.get(i);
                if (field.get(b) == null) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    } else {
                        str = "s";
                    }
                    sb.append("\n  ");
                    sb.append(field.getName());
                }
                i++;
                sb = sb;
                str = str;
            }
            if (sb != null) {
                throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError("Unable to access required fields");
        }
    }
}
