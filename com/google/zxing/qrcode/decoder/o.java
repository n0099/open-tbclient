package com.google.zxing.qrcode.decoder;

import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.zeus.bouncycastle.DERTags;
import com.google.zxing.FormatException;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2885a = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private static final o[] b = f();
    private final int c;
    private final int[] d;
    private final q[] e;
    private final int f;

    private o(int i, int[] iArr, q... qVarArr) {
        p[] b2;
        this.c = i;
        this.d = iArr;
        this.e = qVarArr;
        int a2 = qVarArr[0].a();
        int i2 = 0;
        for (p pVar : qVarArr[0].b()) {
            i2 += (pVar.b() + a2) * pVar.a();
        }
        this.f = i2;
    }

    public int a() {
        return this.c;
    }

    public int[] b() {
        return this.d;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return (this.c * 4) + 17;
    }

    public q a(ErrorCorrectionLevel errorCorrectionLevel) {
        return this.e[errorCorrectionLevel.ordinal()];
    }

    public static o a(int i) {
        if (i % 4 != 1) {
            throw FormatException.getFormatInstance();
        }
        try {
            return b((i - 17) >> 2);
        } catch (IllegalArgumentException e) {
            throw FormatException.getFormatInstance();
        }
    }

    public static o b(int i) {
        if (i < 1 || i > 40) {
            throw new IllegalArgumentException();
        }
        return b[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o c(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        for (int i4 = 0; i4 < f2885a.length; i4++) {
            int i5 = f2885a[i4];
            if (i5 == i) {
                return b(i4 + 7);
            }
            int a2 = n.a(i, i5);
            if (a2 < i2) {
                i3 = i4 + 7;
                i2 = a2;
            }
        }
        if (i2 <= 3) {
            return b(i3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.common.a e() {
        int d = d();
        com.google.zxing.common.a aVar = new com.google.zxing.common.a(d);
        aVar.a(0, 0, 9, 9);
        aVar.a(d - 8, 0, 8, 9);
        aVar.a(0, d - 8, 9, 8);
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            int i2 = this.d[i] - 2;
            for (int i3 = 0; i3 < length; i3++) {
                if ((i != 0 || (i3 != 0 && i3 != length - 1)) && (i != length - 1 || i3 != 0)) {
                    aVar.a(this.d[i3] - 2, i2, 5, 5);
                }
            }
        }
        aVar.a(6, 9, 1, d - 17);
        aVar.a(9, 6, d - 17, 1);
        if (this.c > 6) {
            aVar.a(d - 11, 0, 3, 6);
            aVar.a(0, d - 11, 6, 3);
        }
        return aVar;
    }

    public String toString() {
        return String.valueOf(this.c);
    }

    private static o[] f() {
        return new o[]{new o(1, new int[0], new q(7, new p(1, 19)), new q(10, new p(1, 16)), new q(13, new p(1, 13)), new q(17, new p(1, 9))), new o(2, new int[]{6, 18}, new q(10, new p(1, 34)), new q(16, new p(1, 28)), new q(22, new p(1, 22)), new q(28, new p(1, 16))), new o(3, new int[]{6, 22}, new q(15, new p(1, 55)), new q(26, new p(1, 44)), new q(18, new p(2, 17)), new q(22, new p(2, 13))), new o(4, new int[]{6, 26}, new q(20, new p(1, 80)), new q(18, new p(2, 32)), new q(26, new p(2, 24)), new q(16, new p(4, 9))), new o(5, new int[]{6, 30}, new q(26, new p(1, 108)), new q(24, new p(2, 43)), new q(18, new p(2, 15), new p(2, 16)), new q(22, new p(2, 11), new p(2, 12))), new o(6, new int[]{6, 34}, new q(18, new p(2, 68)), new q(16, new p(4, 27)), new q(24, new p(4, 19)), new q(28, new p(4, 15))), new o(7, new int[]{6, 22, 38}, new q(20, new p(2, 78)), new q(18, new p(4, 31)), new q(18, new p(2, 14), new p(4, 15)), new q(26, new p(4, 13), new p(1, 14))), new o(8, new int[]{6, 24, 42}, new q(24, new p(2, 97)), new q(22, new p(2, 38), new p(2, 39)), new q(22, new p(4, 18), new p(2, 19)), new q(26, new p(4, 14), new p(2, 15))), new o(9, new int[]{6, 26, 46}, new q(30, new p(2, SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE)), new q(22, new p(3, 36), new p(2, 37)), new q(20, new p(4, 16), new p(4, 17)), new q(24, new p(4, 12), new p(4, 13))), new o(10, new int[]{6, 28, 50}, new q(18, new p(2, 68), new p(2, 69)), new q(26, new p(4, 43), new p(1, 44)), new q(24, new p(6, 19), new p(2, 20)), new q(28, new p(6, 15), new p(2, 16))), new o(11, new int[]{6, 30, 54}, new q(20, new p(4, 81)), new q(30, new p(1, 50), new p(4, 51)), new q(28, new p(4, 22), new p(4, 23)), new q(24, new p(3, 12), new p(8, 13))), new o(12, new int[]{6, 32, 58}, new q(24, new p(2, 92), new p(2, 93)), new q(22, new p(6, 36), new p(2, 37)), new q(26, new p(4, 20), new p(6, 21)), new q(28, new p(7, 14), new p(4, 15))), new o(13, new int[]{6, 34, 62}, new q(26, new p(4, SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP)), new q(22, new p(8, 37), new p(1, 38)), new q(24, new p(8, 20), new p(4, 21)), new q(22, new p(12, 11), new p(4, 12))), new o(14, new int[]{6, 26, 46, 66}, new q(30, new p(3, SocialAPIErrorCodes.ERROR_INVALID_RESPONSE_TYPE), new p(1, SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE)), new q(24, new p(4, 40), new p(5, 41)), new q(20, new p(11, 16), new p(5, 17)), new q(24, new p(11, 12), new p(5, 13))), new o(15, new int[]{6, 26, 48, 70}, new q(22, new p(5, 87), new p(1, 88)), new q(24, new p(5, 41), new p(5, 42)), new q(30, new p(5, 24), new p(7, 25)), new q(24, new p(11, 12), new p(7, 13))), new o(16, new int[]{6, 26, 50, 74}, new q(24, new p(5, 98), new p(1, 99)), new q(28, new p(7, 45), new p(3, 46)), new q(24, new p(15, 19), new p(2, 20)), new q(30, new p(3, 15), new p(13, 16))), new o(17, new int[]{6, 30, 54, 78}, new q(28, new p(1, SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP), new p(5, 108)), new q(28, new p(10, 46), new p(1, 47)), new q(28, new p(1, 22), new p(15, 23)), new q(28, new p(2, 14), new p(17, 15))), new o(18, new int[]{6, 30, 56, 82}, new q(30, new p(5, SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE), new p(1, SocialAPIErrorCodes.ERROR_INVALID_STATE)), new q(26, new p(9, 43), new p(4, 44)), new q(28, new p(17, 22), new p(1, 23)), new q(28, new p(2, 14), new p(19, 15))), new o(19, new int[]{6, 30, 58, 86}, new q(28, new p(3, 113), new p(4, 114)), new q(26, new p(3, 44), new p(11, 45)), new q(26, new p(17, 21), new p(4, 22)), new q(26, new p(9, 13), new p(16, 14))), new o(20, new int[]{6, 34, 62, 90}, new q(28, new p(3, SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP), new p(5, 108)), new q(26, new p(3, 41), new p(13, 42)), new q(30, new p(15, 24), new p(5, 25)), new q(28, new p(15, 15), new p(10, 16))), new o(21, new int[]{6, 28, 50, 72, 94}, new q(28, new p(4, SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE), new p(4, SocialAPIErrorCodes.ERROR_INVALID_MEDIA_TYPE)), new q(26, new p(17, 42)), new q(28, new p(17, 22), new p(6, 23)), new q(30, new p(19, 16), new p(6, 17))), new o(22, new int[]{6, 26, 50, 74, 98}, new q(28, new p(2, SocialAPIErrorCodes.ERROR_EXPIRED_ACCESS_TOKEN), new p(7, SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY)), new q(28, new p(17, 46)), new q(30, new p(7, 24), new p(16, 25)), new q(24, new p(34, 13))), new o(23, new int[]{6, 30, 54, 78, 102}, new q(30, new p(4, SocialAPIErrorCodes.ERROR_INVALID_STATE), new p(5, SocialAPIErrorCodes.ERROR_SESSION_EXPIRED)), new q(28, new p(4, 47), new p(14, 48)), new q(30, new p(11, 24), new p(14, 25)), new q(30, new p(16, 15), new p(14, 16))), new o(24, new int[]{6, 28, 54, 80, SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE_ALGORITHM}, new q(30, new p(6, SocialAPIErrorCodes.ERROR_INVALID_MEDIA_TYPE), new p(4, SocialAPIErrorCodes.ERROR_INVALID_REDIRECT_URI)), new q(28, new p(6, 45), new p(14, 46)), new q(30, new p(11, 24), new p(16, 25)), new q(30, new p(30, 16), new p(2, 17))), new o(25, new int[]{6, 32, 58, 84, SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN}, new q(26, new p(8, SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE_ALGORITHM), new p(4, SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP)), new q(28, new p(8, 47), new p(13, 48)), new q(30, new p(7, 24), new p(22, 25)), new q(30, new p(22, 15), new p(13, 16))), new o(26, new int[]{6, 30, 58, 86, 114}, new q(28, new p(10, 114), new p(2, SocialAPIErrorCodes.ERROR_INVALID_RESPONSE_TYPE)), new q(28, new p(19, 46), new p(4, 47)), new q(28, new p(28, 22), new p(6, 23)), new q(30, new p(33, 16), new p(4, 17))), new o(27, new int[]{6, 34, 62, 90, SocialAPIErrorCodes.ERROR_INVALID_REDIRECT_URI}, new q(30, new p(8, SocialAPIErrorCodes.ERROR_SESSION_EXPIRED), new p(4, SocialAPIErrorCodes.ERROR_INVALID_BDUSS)), new q(28, new p(22, 45), new p(3, 46)), new q(30, new p(8, 23), new p(26, 24)), new q(30, new p(12, 15), new p(28, 16))), new o(28, new int[]{6, 26, 50, 74, 98, SocialAPIErrorCodes.ERROR_SESSION_EXPIRED}, new q(30, new p(3, SocialAPIErrorCodes.ERROR_INVALID_MEDIA_TYPE), new p(10, SocialAPIErrorCodes.ERROR_INVALID_REDIRECT_URI)), new q(28, new p(3, 45), new p(23, 46)), new q(30, new p(4, 24), new p(31, 25)), new q(30, new p(11, 15), new p(31, 16))), new o(29, new int[]{6, 30, 54, 78, 102, 126}, new q(30, new p(7, SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE), new p(7, SocialAPIErrorCodes.ERROR_INVALID_MEDIA_TYPE)), new q(28, new p(21, 45), new p(7, 46)), new q(30, new p(1, 23), new p(37, 24)), new q(30, new p(19, 15), new p(26, 16))), new o(30, new int[]{6, 26, 52, 78, 104, 130}, new q(30, new p(5, SocialAPIErrorCodes.ERROR_INVALID_RESPONSE_TYPE), new p(10, SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE)), new q(28, new p(19, 47), new p(10, 48)), new q(30, new p(15, 24), new p(25, 25)), new q(30, new p(23, 15), new p(25, 16))), new o(31, new int[]{6, 30, 56, 82, 108, 134}, new q(30, new p(13, SocialAPIErrorCodes.ERROR_INVALID_RESPONSE_TYPE), new p(3, SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE)), new q(28, new p(2, 46), new p(29, 47)), new q(30, new p(42, 24), new p(1, 25)), new q(30, new p(23, 15), new p(28, 16))), new o(32, new int[]{6, 34, 60, 86, SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY, 138}, new q(30, new p(17, SocialAPIErrorCodes.ERROR_INVALID_RESPONSE_TYPE)), new q(28, new p(10, 46), new p(23, 47)), new q(30, new p(10, 24), new p(35, 25)), new q(30, new p(19, 15), new p(35, 16))), new o(33, new int[]{6, 30, 58, 86, 114, 142}, new q(30, new p(17, SocialAPIErrorCodes.ERROR_INVALID_RESPONSE_TYPE), new p(1, SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE)), new q(28, new p(14, 46), new p(21, 47)), new q(30, new p(29, 24), new p(19, 25)), new q(30, new p(11, 15), new p(46, 16))), new o(34, new int[]{6, 34, 62, 90, SocialAPIErrorCodes.ERROR_INVALID_REDIRECT_URI, 146}, new q(30, new p(13, SocialAPIErrorCodes.ERROR_INVALID_RESPONSE_TYPE), new p(6, SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE)), new q(28, new p(14, 46), new p(23, 47)), new q(30, new p(44, 24), new p(7, 25)), new q(30, new p(59, 16), new p(1, 17))), new o(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new q(30, new p(12, SocialAPIErrorCodes.ERROR_INVALID_STATE), new p(7, SocialAPIErrorCodes.ERROR_SESSION_EXPIRED)), new q(28, new p(12, 47), new p(26, 48)), new q(30, new p(39, 24), new p(14, 25)), new q(30, new p(22, 15), new p(41, 16))), new o(36, new int[]{6, 24, 50, 76, 102, DERTags.TAGGED, 154}, new q(30, new p(6, SocialAPIErrorCodes.ERROR_INVALID_STATE), new p(14, SocialAPIErrorCodes.ERROR_SESSION_EXPIRED)), new q(28, new p(6, 47), new p(34, 48)), new q(30, new p(46, 24), new p(10, 25)), new q(30, new p(2, 15), new p(64, 16))), new o(37, new int[]{6, 28, 54, 80, SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE_ALGORITHM, 132, 158}, new q(30, new p(17, SocialAPIErrorCodes.ERROR_SESSION_EXPIRED), new p(4, SocialAPIErrorCodes.ERROR_INVALID_BDUSS)), new q(28, new p(29, 46), new p(14, 47)), new q(30, new p(49, 24), new p(10, 25)), new q(30, new p(24, 15), new p(46, 16))), new o(38, new int[]{6, 32, 58, 84, SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN, 136, 162}, new q(30, new p(4, SocialAPIErrorCodes.ERROR_SESSION_EXPIRED), new p(18, SocialAPIErrorCodes.ERROR_INVALID_BDUSS)), new q(28, new p(13, 46), new p(32, 47)), new q(30, new p(48, 24), new p(14, 25)), new q(30, new p(42, 15), new p(32, 16))), new o(39, new int[]{6, 26, 54, 82, SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN, 138, 166}, new q(30, new p(20, SocialAPIErrorCodes.ERROR_INVALID_MEDIA_TYPE), new p(4, SocialAPIErrorCodes.ERROR_INVALID_REDIRECT_URI)), new q(28, new p(40, 47), new p(7, 48)), new q(30, new p(43, 24), new p(22, 25)), new q(30, new p(10, 15), new p(67, 16))), new o(40, new int[]{6, 30, 58, 86, 114, 142, 170}, new q(30, new p(19, SocialAPIErrorCodes.ERROR_INVALID_REDIRECT_URI), new p(6, SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY)), new q(28, new p(18, 47), new p(31, 48)), new q(30, new p(34, 24), new p(34, 25)), new q(30, new p(20, 15), new p(61, 16)))};
    }
}
