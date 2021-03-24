package com.kwai.filedownloader.d;
/* loaded from: classes6.dex */
public class d {
    public static boolean a(int i) {
        return i < 0;
    }

    public static boolean a(int i, int i2) {
        if ((i == 3 || i == 5 || i != i2) && !a(i)) {
            if (i < 1 || i > 6 || i2 < 10 || i2 > 11) {
                if (i == 1) {
                    return i2 != 0;
                } else if (i == 2) {
                    return (i2 == 0 || i2 == 1 || i2 == 6) ? false : true;
                } else if (i == 3) {
                    return (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 6) ? false : true;
                } else if (i == 5) {
                    return (i2 == 1 || i2 == 6) ? false : true;
                } else if (i != 6) {
                    return true;
                } else {
                    return (i2 == 0 || i2 == 1) ? false : true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean a(com.kwai.filedownloader.a aVar) {
        return aVar.v() == 0 || aVar.v() == 3;
    }

    public static boolean b(int i) {
        return i > 0;
    }

    public static boolean b(int i, int i2) {
        if ((i == 3 || i == 5 || i != i2) && !a(i)) {
            if (i2 == -2 || i2 == -1) {
                return true;
            }
            if (i == 0) {
                return i2 == 10;
            } else if (i == 1) {
                return i2 == 6;
            } else if (i == 2 || i == 3) {
                return i2 == -3 || i2 == 3 || i2 == 5;
            } else if (i == 5 || i == 6) {
                return i2 == 2 || i2 == 5;
            } else if (i == 10) {
                return i2 == 11;
            } else if (i != 11) {
                return false;
            } else {
                return i2 == -4 || i2 == -3 || i2 == 1;
            }
        }
        return false;
    }
}
