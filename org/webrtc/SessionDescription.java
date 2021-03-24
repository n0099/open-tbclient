package org.webrtc;

import java.util.Locale;
/* loaded from: classes7.dex */
public class SessionDescription {
    public final String description;
    public final Type type;

    /* loaded from: classes7.dex */
    public enum Type {
        OFFER,
        PRANSWER,
        ANSWER;

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
    public String getDescription() {
        return this.description;
    }

    @CalledByNative
    public String getTypeInCanonicalForm() {
        return this.type.canonicalForm();
    }
}
