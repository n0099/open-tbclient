package org.webrtc;

import java.util.Locale;
/* loaded from: classes12.dex */
public class SessionDescription {
    public final String description;
    public final Type type;

    /* loaded from: classes12.dex */
    public enum Type {
        OFFER,
        PRANSWER,
        ANSWER;

        @CalledByNative("Type")
        public static Type fromCanonicalForm(String str) {
            return (Type) valueOf(Type.class, str.toUpperCase(Locale.US));
        }

        public String canonicalForm() {
            return name().toLowerCase(Locale.US);
        }
    }

    @CalledByNative
    public SessionDescription(Type type, String str) {
        this.type = type;
        this.description = str;
    }

    @CalledByNative
    String getDescription() {
        return this.description;
    }

    @CalledByNative
    String getTypeInCanonicalForm() {
        return this.type.canonicalForm();
    }
}
