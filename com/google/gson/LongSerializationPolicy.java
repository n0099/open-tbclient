package com.google.gson;
/* loaded from: classes.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public r serialize(Long l) {
            return new u(l);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public r serialize(Long l) {
            return new u(String.valueOf(l));
        }
    };

    public abstract r serialize(Long l);
}
