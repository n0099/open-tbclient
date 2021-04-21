package com.ksad.lottie.c;

import android.util.JsonReader;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public class h implements aj<com.ksad.lottie.model.b> {

    /* renamed from: a  reason: collision with root package name */
    public static final h f31722a = new h();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.c.aj
    /* renamed from: a */
    public com.ksad.lottie.model.b b(JsonReader jsonReader, float f2) {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = true;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 102) {
                if (hashCode != 106) {
                    if (hashCode != 3261) {
                        if (hashCode != 3452) {
                            if (hashCode != 3463) {
                                if (hashCode != 3543) {
                                    if (hashCode != 3664) {
                                        if (hashCode != 3684) {
                                            if (hashCode != 3710) {
                                                if (hashCode != 115) {
                                                    if (hashCode == 116 && nextName.equals("t")) {
                                                        c2 = 0;
                                                    }
                                                } else if (nextName.equals("s")) {
                                                    c2 = 2;
                                                }
                                            } else if (nextName.equals("tr")) {
                                                c2 = 4;
                                            }
                                        } else if (nextName.equals("sw")) {
                                            c2 = '\t';
                                        }
                                    } else if (nextName.equals(Config.STAT_SDK_CHANNEL)) {
                                        c2 = '\b';
                                    }
                                } else if (nextName.equals("of")) {
                                    c2 = '\n';
                                }
                            } else if (nextName.equals("ls")) {
                                c2 = 6;
                            }
                        } else if (nextName.equals(IAdRequestParam.QUERY_HEIGHT)) {
                            c2 = 5;
                        }
                    } else if (nextName.equals("fc")) {
                        c2 = 7;
                    }
                } else if (nextName.equals("j")) {
                    c2 = 3;
                }
            } else if (nextName.equals("f")) {
                c2 = 1;
            }
            switch (c2) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str2 = jsonReader.nextString();
                    break;
                case 2:
                    d2 = jsonReader.nextDouble();
                    break;
                case 3:
                    i = jsonReader.nextInt();
                    break;
                case 4:
                    i2 = jsonReader.nextInt();
                    break;
                case 5:
                    d3 = jsonReader.nextDouble();
                    break;
                case 6:
                    d4 = jsonReader.nextDouble();
                    break;
                case 7:
                    i3 = p.a(jsonReader);
                    break;
                case '\b':
                    i4 = p.a(jsonReader);
                    break;
                case '\t':
                    d5 = jsonReader.nextDouble();
                    break;
                case '\n':
                    z = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.ksad.lottie.model.b(str, str2, d2, i, i2, d3, d4, i3, i4, d5, z);
    }
}
