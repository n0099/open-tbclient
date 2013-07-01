package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.util.BitSet;
/* loaded from: classes.dex */
final class ak extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public BitSet b(com.google.gson.stream.a aVar) {
        boolean z;
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        BitSet bitSet = new BitSet();
        aVar.a();
        JsonToken f = aVar.f();
        int i = 0;
        while (f != JsonToken.END_ARRAY) {
            switch (f) {
                case NUMBER:
                    if (aVar.m() == 0) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case BOOLEAN:
                    z = aVar.i();
                    break;
                case STRING:
                    String h = aVar.h();
                    try {
                        if (Integer.parseInt(h) == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + h);
                    }
                default:
                    throw new JsonSyntaxException("Invalid bitset value type: " + f);
            }
            if (z) {
                bitSet.set(i);
            }
            i++;
            f = aVar.f();
        }
        aVar.b();
        return bitSet;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, BitSet bitSet) {
        if (bitSet == null) {
            dVar.f();
            return;
        }
        dVar.b();
        for (int i = 0; i < bitSet.length(); i++) {
            dVar.a(bitSet.get(i) ? 1 : 0);
        }
        dVar.c();
    }
}
