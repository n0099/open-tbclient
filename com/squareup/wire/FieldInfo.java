package com.squareup.wire;

import com.squareup.protoparser.MessageType;
/* loaded from: classes.dex */
final class FieldInfo {
    final MessageType.Label label;
    final String name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldInfo(String str, MessageType.Label label) {
        this.name = str;
        this.label = label;
    }

    public static boolean isOptional(MessageType.Field field) {
        return field.getLabel() == MessageType.Label.OPTIONAL;
    }

    public static boolean isPacked(MessageType.Field field, boolean z) {
        return field.isPacked() && (z || isPackableScalar(field));
    }

    private static boolean isPackableScalar(MessageType.Field field) {
        String type = field.getType();
        return (!TypeInfo.isScalar(type) || "string".equals(type) || "bytes".equals(type)) ? false : true;
    }

    public static boolean isRepeated(MessageType.Field field) {
        return field.getLabel() == MessageType.Label.REPEATED;
    }

    public static boolean isRequired(MessageType.Field field) {
        return field.getLabel() == MessageType.Label.REQUIRED;
    }

    public boolean isRepeated() {
        return this.label == MessageType.Label.REPEATED;
    }
}
