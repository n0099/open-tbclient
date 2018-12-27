package com.facebook.d;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
class d {
    private static final Class<?> ihJ = d.class;

    d() {
    }

    public static int zc(int i) {
        switch (i) {
            case 0:
            case 1:
                return 0;
            case 2:
            case 4:
            case 5:
            case 7:
            default:
                com.facebook.common.c.a.e(ihJ, "Unsupported orientation");
                return 0;
            case 3:
                return 180;
            case 6:
                return 90;
            case 8:
                return 270;
        }
    }

    public static int g(InputStream inputStream, int i) throws IOException {
        a aVar = new a();
        int a2 = a(inputStream, i, aVar);
        int i2 = aVar.ive - 8;
        if (a2 == 0 || i2 > a2) {
            return 0;
        }
        inputStream.skip(i2);
        return b(inputStream, a(inputStream, a2 - i2, aVar.ivc, 274), aVar.ivc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        boolean ivc;
        int ivd;
        int ive;

        private a() {
        }
    }

    private static int a(InputStream inputStream, int i, a aVar) throws IOException {
        if (i <= 8) {
            return 0;
        }
        aVar.ivd = c.a(inputStream, 4, false);
        int i2 = i - 4;
        if (aVar.ivd != 1229531648 && aVar.ivd != 1296891946) {
            com.facebook.common.c.a.g(ihJ, "Invalid TIFF header");
            return 0;
        }
        aVar.ivc = aVar.ivd == 1229531648;
        aVar.ive = c.a(inputStream, 4, aVar.ivc);
        int i3 = i2 - 4;
        if (aVar.ive < 8 || aVar.ive - 8 > i3) {
            com.facebook.common.c.a.g(ihJ, "Invalid offset");
            return 0;
        }
        return i3;
    }

    private static int a(InputStream inputStream, int i, boolean z, int i2) throws IOException {
        if (i < 14) {
            return 0;
        }
        int a2 = c.a(inputStream, 2, z);
        int i3 = i - 2;
        while (true) {
            int i4 = a2 - 1;
            if (a2 <= 0 || i3 < 12) {
                return 0;
            }
            int i5 = i3 - 2;
            if (c.a(inputStream, 2, z) == i2) {
                return i5;
            }
            inputStream.skip(10L);
            i3 = i5 - 10;
            a2 = i4;
        }
    }

    private static int b(InputStream inputStream, int i, boolean z) throws IOException {
        if (i >= 10 && c.a(inputStream, 2, z) == 3 && c.a(inputStream, 4, z) == 1) {
            int a2 = c.a(inputStream, 2, z);
            c.a(inputStream, 2, z);
            return a2;
        }
        return 0;
    }
}
