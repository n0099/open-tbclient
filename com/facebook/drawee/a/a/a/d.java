package com.facebook.drawee.a.a.a;
/* loaded from: classes18.dex */
public class d {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int VO(String str) {
        char c;
        switch (str.hashCode()) {
            case -1914072202:
                if (str.equals("BitmapMemoryCacheGetProducer")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1307634203:
                if (str.equals("EncodedMemoryCacheProducer")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1224383234:
                if (str.equals("NetworkFetchProducer")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 656304759:
                if (str.equals("DiskCacheProducer")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 957714404:
                if (str.equals("BitmapMemoryCacheProducer")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return 3;
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return 0;
            default:
                return -1;
        }
    }
}
