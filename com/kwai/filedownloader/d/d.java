package com.kwai.filedownloader.d;
/* loaded from: classes7.dex */
public class d {
    public static boolean a(int i2) {
        return i2 < 0;
    }

    public static boolean a(int i2, int i3) {
        if ((i2 == 3 || i2 == 5 || i2 != i3) && !a(i2)) {
            if (i2 < 1 || i2 > 6 || i3 < 10 || i3 > 11) {
                if (i2 == 1) {
                    return i3 != 0;
                } else if (i2 == 2) {
                    return (i3 == 0 || i3 == 1 || i3 == 6) ? false : true;
                } else if (i2 == 3) {
                    return (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 6) ? false : true;
                } else if (i2 == 5) {
                    return (i3 == 1 || i3 == 6) ? false : true;
                } else if (i2 != 6) {
                    return true;
                } else {
                    return (i3 == 0 || i3 == 1) ? false : true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean a(com.kwai.filedownloader.a aVar) {
        return aVar.v() == 0 || aVar.v() == 3;
    }

    public static boolean b(int i2) {
        return i2 > 0;
    }

    public static boolean b(int i2, int i3) {
        if ((i2 == 3 || i2 == 5 || i2 != i3) && !a(i2)) {
            if (i3 == -2 || i3 == -1) {
                return true;
            }
            if (i2 == 0) {
                return i3 == 10;
            } else if (i2 == 1) {
                return i3 == 6;
            } else if (i2 == 2 || i2 == 3) {
                return i3 == -3 || i3 == 3 || i3 == 5;
            } else if (i2 == 5 || i2 == 6) {
                return i3 == 2 || i3 == 5;
            } else if (i2 == 10) {
                return i3 == 11;
            } else if (i2 != 11) {
                return false;
            } else {
                return i3 == -4 || i3 == -3 || i3 == 1;
            }
        }
        return false;
    }
}
