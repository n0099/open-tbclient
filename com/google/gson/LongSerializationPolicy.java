package com.google.gson;
/* loaded from: classes2.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public h serialize(Long l) {
            return new k(l);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public h serialize(Long l) {
            return new k(String.valueOf(l));
        }
    };

    public abstract h serialize(Long l);
}
