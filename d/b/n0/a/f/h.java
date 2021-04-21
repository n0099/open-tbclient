package d.b.n0.a.f;

import com.baidu.ubs.analytics.SampleResult;
/* loaded from: classes5.dex */
public final class h {
    public static SampleResult a(String str) {
        if (str != null && !str.equals("")) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 79) {
                switch (hashCode) {
                    case 2126:
                        if (str.equals("C1")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 2127:
                        if (str.equals("C2")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 2128:
                        if (str.equals("C3")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    default:
                        switch (hashCode) {
                            case 2653:
                                if (str.equals("T1")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 2654:
                                if (str.equals("T2")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 2655:
                                if (str.equals("T3")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 2656:
                                if (str.equals("T4")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 2657:
                                if (str.equals("T5")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                        }
                }
            } else if (str.equals("O")) {
                c2 = '\b';
            }
            switch (c2) {
                case 0:
                    return SampleResult.T1;
                case 1:
                    return SampleResult.T2;
                case 2:
                    return SampleResult.T3;
                case 3:
                    return SampleResult.T4;
                case 4:
                    return SampleResult.T5;
                case 5:
                    return SampleResult.C1;
                case 6:
                    return SampleResult.C2;
                case 7:
                    return SampleResult.C3;
                case '\b':
                    return SampleResult.OTHERE;
                default:
                    return SampleResult.OTHERE;
            }
        }
        return SampleResult.OTHERE;
    }
}
