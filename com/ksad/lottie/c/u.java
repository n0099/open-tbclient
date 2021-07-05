package com.ksad.lottie.c;

import android.util.JsonReader;
import android.util.Log;
import com.airbnb.lottie.L;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ksad.lottie.model.content.Mask;
/* loaded from: classes7.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008c, code lost:
        if (r0.equals("a") != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Mask a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jsonReader, dVar)) == null) {
            jsonReader.beginObject();
            Mask.MaskMode maskMode = null;
            com.ksad.lottie.model.a.h hVar = null;
            com.ksad.lottie.model.a.d dVar2 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                char c3 = 0;
                if (hashCode == 111) {
                    if (nextName.equals(Config.OS)) {
                        c2 = 2;
                    }
                    c2 = 65535;
                } else if (hashCode != 3588) {
                    if (hashCode == 3357091 && nextName.equals("mode")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else {
                    if (nextName.equals(Config.PLATFORM_TYPE)) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    String nextString = jsonReader.nextString();
                    int hashCode2 = nextString.hashCode();
                    if (hashCode2 != 97) {
                        if (hashCode2 != 105) {
                            if (hashCode2 == 115 && nextString.equals("s")) {
                                c3 = 1;
                                if (c3 != 0) {
                                    if (c3 == 1) {
                                        maskMode = Mask.MaskMode.MaskModeSubtract;
                                    } else if (c3 != 2) {
                                        Log.w(L.TAG, "Unknown mask mode " + nextName + ". Defaulting to Add.");
                                    } else {
                                        dVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                        maskMode = Mask.MaskMode.MaskModeIntersect;
                                    }
                                }
                                maskMode = Mask.MaskMode.MaskModeAdd;
                            }
                            c3 = 65535;
                            if (c3 != 0) {
                            }
                            maskMode = Mask.MaskMode.MaskModeAdd;
                        } else {
                            if (nextString.equals("i")) {
                                c3 = 2;
                                if (c3 != 0) {
                                }
                                maskMode = Mask.MaskMode.MaskModeAdd;
                            }
                            c3 = 65535;
                            if (c3 != 0) {
                            }
                            maskMode = Mask.MaskMode.MaskModeAdd;
                        }
                    }
                } else if (c2 == 1) {
                    hVar = d.e(jsonReader, dVar);
                } else if (c2 != 2) {
                    jsonReader.skipValue();
                } else {
                    dVar2 = d.b(jsonReader, dVar);
                }
            }
            jsonReader.endObject();
            return new Mask(maskMode, hVar, dVar2);
        }
        return (Mask) invokeLL.objValue;
    }
}
