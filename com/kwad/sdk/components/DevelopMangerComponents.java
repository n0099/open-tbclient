package com.kwad.sdk.components;

import java.io.Serializable;
/* loaded from: classes7.dex */
public interface DevelopMangerComponents extends a {

    /* loaded from: classes7.dex */
    public class DevelopValue implements Serializable {
        public static final long serialVersionUID = 2793333073373146040L;
        public Serializable mValue;

        public DevelopValue(Serializable serializable) {
            this.mValue = serializable;
        }

        public Object getValue() {
            Serializable serializable = this.mValue;
            if (serializable != null) {
                return serializable;
            }
            return null;
        }
    }
}
