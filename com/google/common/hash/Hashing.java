package com.google.common.hash;

import d.g.c.d.e;
import d.g.c.d.g;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
/* loaded from: classes6.dex */
public final class Hashing {

    /* renamed from: a  reason: collision with root package name */
    public static final int f31344a = (int) System.currentTimeMillis();

    /* loaded from: classes6.dex */
    public enum ChecksumType implements g<Checksum> {
        CRC_32("Hashing.crc32()") { // from class: com.google.common.hash.Hashing.ChecksumType.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.hash.Hashing.ChecksumType, d.g.c.a.r
            public Checksum get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") { // from class: com.google.common.hash.Hashing.ChecksumType.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.hash.Hashing.ChecksumType, d.g.c.a.r
            public Checksum get() {
                return new Adler32();
            }
        };
        
        public final e hashFunction;

        @Override // d.g.c.a.r
        public abstract /* synthetic */ T get();

        ChecksumType(String str) {
            this.hashFunction = new ChecksumHashFunction(this, 32, str);
        }
    }

    public static e a() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }
}
