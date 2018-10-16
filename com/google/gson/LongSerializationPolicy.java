package com.google.gson;
/* loaded from: classes2.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public i serialize(Long l) {
            return new l(l);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public i serialize(Long l) {
            return new l(String.valueOf(l));
        }
    };

    public abstract i serialize(Long l);
}
