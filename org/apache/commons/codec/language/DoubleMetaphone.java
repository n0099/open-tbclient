package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
@Deprecated
/* loaded from: classes7.dex */
public class DoubleMetaphone implements StringEncoder {
    public int maxCodeLen;

    /* loaded from: classes7.dex */
    public class DoubleMetaphoneResult {
        public DoubleMetaphoneResult(int i2) {
            throw new RuntimeException("Stub!");
        }

        public void append(char c2) {
            throw new RuntimeException("Stub!");
        }

        public void appendAlternate(char c2) {
            throw new RuntimeException("Stub!");
        }

        public void appendPrimary(char c2) {
            throw new RuntimeException("Stub!");
        }

        public String getAlternate() {
            throw new RuntimeException("Stub!");
        }

        public String getPrimary() {
            throw new RuntimeException("Stub!");
        }

        public boolean isComplete() {
            throw new RuntimeException("Stub!");
        }

        public void append(char c2, char c3) {
            throw new RuntimeException("Stub!");
        }

        public void appendAlternate(String str) {
            throw new RuntimeException("Stub!");
        }

        public void appendPrimary(String str) {
            throw new RuntimeException("Stub!");
        }

        public void append(String str) {
            throw new RuntimeException("Stub!");
        }

        public void append(String str, String str2) {
            throw new RuntimeException("Stub!");
        }
    }

    public DoubleMetaphone() {
        throw new RuntimeException("Stub!");
    }

    public static boolean contains(String str, int i2, int i3, String[] strArr) {
        throw new RuntimeException("Stub!");
    }

    public char charAt(String str, int i2) {
        throw new RuntimeException("Stub!");
    }

    public String doubleMetaphone(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    public int getMaxCodeLen() {
        throw new RuntimeException("Stub!");
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxCodeLen(int i2) {
        throw new RuntimeException("Stub!");
    }

    public String doubleMetaphone(String str, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        throw new RuntimeException("Stub!");
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z) {
        throw new RuntimeException("Stub!");
    }
}
