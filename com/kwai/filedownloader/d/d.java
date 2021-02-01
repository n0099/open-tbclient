package com.kwai.filedownloader.d;
/* loaded from: classes3.dex */
public class d {
    public static boolean a(int i) {
        return i < 0;
    }

    public static boolean a(int i, int i2) {
        if ((i == 3 || i == 5 || i != i2) && !a(i)) {
            if (i < 1 || i > 6 || i2 < 10 || i2 > 11) {
                switch (i) {
                    case 1:
                        switch (i2) {
                            case 0:
                                return false;
                            default:
                                return true;
                        }
                    case 2:
                        switch (i2) {
                            case 0:
                            case 1:
                            case 6:
                                return false;
                            default:
                                return true;
                        }
                    case 3:
                        switch (i2) {
                            case 0:
                            case 1:
                            case 2:
                            case 6:
                                return false;
                            case 3:
                            case 4:
                            case 5:
                            default:
                                return true;
                        }
                    case 4:
                    default:
                        return true;
                    case 5:
                        switch (i2) {
                            case 1:
                            case 6:
                                return false;
                            default:
                                return true;
                        }
                    case 6:
                        switch (i2) {
                            case 0:
                            case 1:
                                return false;
                            default:
                                return true;
                        }
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
            if (i2 != -2 && i2 != -1) {
                switch (i) {
                    case 0:
                        switch (i2) {
                            case 10:
                                return true;
                            default:
                                return false;
                        }
                    case 1:
                        switch (i2) {
                            case 6:
                                return true;
                            default:
                                return false;
                        }
                    case 2:
                    case 3:
                        switch (i2) {
                            case -3:
                            case 3:
                            case 5:
                                return true;
                            default:
                                return false;
                        }
                    case 4:
                    case 7:
                    case 8:
                    case 9:
                    default:
                        return false;
                    case 5:
                    case 6:
                        switch (i2) {
                            case 2:
                            case 5:
                                return true;
                            case 3:
                            case 4:
                            default:
                                return false;
                        }
                    case 10:
                        switch (i2) {
                            case 11:
                                return true;
                            default:
                                return false;
                        }
                    case 11:
                        switch (i2) {
                            case -4:
                            case -3:
                            case 1:
                                return true;
                            case -2:
                            case -1:
                            case 0:
                            default:
                                return false;
                        }
                }
            }
            return true;
        }
        return false;
    }
}
