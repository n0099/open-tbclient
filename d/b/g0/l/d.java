package d.b.g0.l;
/* loaded from: classes3.dex */
public final class d {
    public static String a(int i, String str) {
        if (i != 1020) {
            switch (i) {
                case 1001:
                    return "system error";
                case 1002:
                    return "the request is prohibited";
                case 1003:
                    return "invalid common params";
                case 1004:
                    return "invalid query params";
                default:
                    switch (i) {
                        case 1010:
                            return "the current package is the latest";
                        case 1011:
                            return "the app is not exist";
                        case 1012:
                            return "the package is not exist";
                        case 1013:
                            return "please upgrade SDK version";
                        case 1014:
                            return "the framework is not available";
                        case 1015:
                            return "the host app is not support this app";
                        default:
                            return "";
                    }
            }
        }
        return str;
    }
}
