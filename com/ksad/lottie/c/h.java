package com.ksad.lottie.c;

import android.util.JsonReader;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapBundleKey;
/* loaded from: classes5.dex */
public class h implements aj<com.ksad.lottie.model.b> {

    /* renamed from: a  reason: collision with root package name */
    public static final h f8272a = new h();

    private h() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.c.aj
    /* renamed from: a */
    public com.ksad.lottie.model.b b(JsonReader jsonReader, float f) {
        String str = null;
        String str2 = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i3 = 0;
        int i4 = 0;
        double d4 = 0.0d;
        boolean z = true;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 102:
                    if (nextName.equals("f")) {
                        c = 1;
                        break;
                    }
                    break;
                case 106:
                    if (nextName.equals("j")) {
                        c = 3;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 2;
                        break;
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3261:
                    if (nextName.equals("fc")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3452:
                    if (nextName.equals(IXAdRequestInfo.QUERY_HEIGHT)) {
                        c = 5;
                        break;
                    }
                    break;
                case 3463:
                    if (nextName.equals("ls")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3543:
                    if (nextName.equals(MapBundleKey.MapObjKey.OBJ_OFFSET)) {
                        c = '\n';
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals(Config.STAT_SDK_CHANNEL)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3710:
                    if (nextName.equals("tr")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str2 = jsonReader.nextString();
                    break;
                case 2:
                    d = jsonReader.nextDouble();
                    break;
                case 3:
                    i = jsonReader.nextInt();
                    break;
                case 4:
                    i2 = jsonReader.nextInt();
                    break;
                case 5:
                    d2 = jsonReader.nextDouble();
                    break;
                case 6:
                    d3 = jsonReader.nextDouble();
                    break;
                case 7:
                    i3 = p.a(jsonReader);
                    break;
                case '\b':
                    i4 = p.a(jsonReader);
                    break;
                case '\t':
                    d4 = jsonReader.nextDouble();
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
        return new com.ksad.lottie.model.b(str, str2, d, i, i2, d2, d3, i3, i4, d4, z);
    }
}
