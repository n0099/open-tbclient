package com.kwad.sdk.plugin;

import java.io.Serializable;
/* loaded from: classes6.dex */
public interface DevelopMangerPlugin extends e {

    /* loaded from: classes6.dex */
    public static class DevelopValue implements Serializable {
        public static final long serialVersionUID = 2793333073373146040L;
        public Serializable mValue;

        public DevelopValue(Serializable serializable) {
            this.mValue = serializable;
        }

        public <T> T getValue() {
            T t = (T) this.mValue;
            if (t != null) {
                return t;
            }
            return null;
        }
    }

    DevelopValue a(String str);
}
