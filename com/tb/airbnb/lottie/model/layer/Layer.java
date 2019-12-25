package com.tb.airbnb.lottie.model.layer;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tb.airbnb.lottie.model.a.b;
import com.tb.airbnb.lottie.model.a.j;
import com.tb.airbnb.lottie.model.a.k;
import com.tb.airbnb.lottie.model.a.l;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Layer {
    private static final String TAG = Layer.class.getSimpleName();
    private final com.tb.airbnb.lottie.e composition;
    private final List<Mask> gJ;
    private final List<com.tb.airbnb.lottie.a.a<Float>> jB;
    private final String jn;
    private final long jo;
    private final long jq;
    @Nullable
    private final String jr;
    private final int js;
    private final int jt;
    private final int ju;
    private final float jv;
    private final int jw;
    private final int jx;
    private final float kr;
    private final l mOH;
    private final LayerType mOT;
    @Nullable
    private final j mOU;
    @Nullable
    private final k mOV;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b mOW;
    private final MatteType mOX;
    private final List<com.tb.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes2.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    private Layer(List<com.tb.airbnb.lottie.model.content.b> list, com.tb.airbnb.lottie.e eVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.tb.airbnb.lottie.a.a<Float>> list3, MatteType matteType, @Nullable com.tb.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = eVar;
        this.jn = str;
        this.jo = j;
        this.mOT = layerType;
        this.jq = j2;
        this.jr = str2;
        this.gJ = list2;
        this.mOH = lVar;
        this.js = i;
        this.jt = i2;
        this.ju = i3;
        this.jv = f;
        this.kr = f2;
        this.jw = i4;
        this.jx = i5;
        this.mOU = jVar;
        this.mOV = kVar;
        this.jB = list3;
        this.mOX = matteType;
        this.mOW = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tb.airbnb.lottie.e dBd() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float dh() {
        return this.jv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float di() {
        return this.kr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.a.a<Float>> dj() {
        return this.jB;
    }

    public long getId() {
        return this.jo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.jn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.jr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dk() {
        return this.jw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dl() {
        return this.jx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> bW() {
        return this.gJ;
    }

    public LayerType dCn() {
        return this.mOT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType dCo() {
        return this.mOX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public long m32do() {
        return this.jq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.model.content.b> ci() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l dCh() {
        return this.mOH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.ju;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dp() {
        return this.jt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dq() {
        return this.js;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j dCp() {
        return this.mOU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k dCq() {
        return this.mOV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tb.airbnb.lottie.model.a.b dCr() {
        return this.mOW;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer gQ = this.composition.gQ(m32do());
        if (gQ != null) {
            sb.append("\t\tParents: ").append(gQ.getName());
            Layer gQ2 = this.composition.gQ(gQ.m32do());
            while (gQ2 != null) {
                sb.append("->").append(gQ2.getName());
                gQ2 = this.composition.gQ(gQ2.m32do());
            }
            sb.append(str).append("\n");
        }
        if (!bW().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(bW().size()).append("\n");
        }
        if (dq() != 0 && dp() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(dq()), Integer.valueOf(dp()), Integer.valueOf(getSolidColor())));
        }
        if (!this.shapes.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (com.tb.airbnb.lottie.model.content.b bVar : this.shapes) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static Layer j(com.tb.airbnb.lottie.e eVar) {
            Rect be = eVar.be();
            return new Layer(Collections.emptyList(), eVar, "root", -1L, LayerType.PreComp, -1L, null, Collections.emptyList(), l.a.dBJ(), 0, 0, 0, 0.0f, 0.0f, be.width(), be.height(), null, null, Collections.emptyList(), MatteType.None, null);
        }

        public static Layer C(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            LayerType layerType;
            String optString = jSONObject.optString("nm");
            String optString2 = jSONObject.optString("refId");
            if (optString.endsWith(".ai") || jSONObject.optString(Config.CELL_LOCATION, "").equals("ai")) {
                eVar.G("Convert your Illustrator layers to shape layers.");
            }
            long optLong = jSONObject.optLong("ind");
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int optInt = jSONObject.optInt(Config.EXCEPTION_CRASH_CHANNEL, -1);
            if (optInt < LayerType.Unknown.ordinal()) {
                layerType = LayerType.values()[optInt];
            } else {
                layerType = LayerType.Unknown;
            }
            if (layerType == LayerType.Text && !com.tb.airbnb.lottie.c.f.a(eVar, 4, 8, 0)) {
                layerType = LayerType.Unknown;
                eVar.G("Text is only supported on bodymovin >= 4.8.0");
            }
            LayerType layerType2 = layerType;
            long optLong2 = jSONObject.optLong("parent", -1L);
            if (layerType2 == LayerType.Solid) {
                i = (int) (jSONObject.optInt("sw") * eVar.dAZ());
                i2 = (int) (jSONObject.optInt(IXAdRequestInfo.SCREEN_HEIGHT) * eVar.dAZ());
                i3 = Color.parseColor(jSONObject.optString(Config.STAT_SDK_CHANNEL));
            }
            l n = l.a.n(jSONObject.optJSONObject("ks"), eVar);
            MatteType matteType = MatteType.values()[jSONObject.optInt(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP)];
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("masksProperties");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    arrayList.add(Mask.a.r(optJSONArray.optJSONObject(i6), eVar));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("shapes");
            if (optJSONArray2 != null) {
                for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                    com.tb.airbnb.lottie.model.content.b w = com.tb.airbnb.lottie.model.content.j.w(optJSONArray2.optJSONObject(i7), eVar);
                    if (w != null) {
                        arrayList2.add(w);
                    }
                }
            }
            j jVar = null;
            k kVar = null;
            JSONObject optJSONObject = jSONObject.optJSONObject("t");
            if (optJSONObject != null) {
                jVar = j.a.l(optJSONObject.optJSONObject("d"), eVar);
                kVar = k.a.m(optJSONObject.optJSONArray(Config.APP_VERSION_CODE).optJSONObject(0), eVar);
            }
            if (jSONObject.has("ef")) {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ef");
                String[] strArr = new String[optJSONArray3.length()];
                for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                    strArr[i8] = optJSONArray3.optJSONObject(i8).optString("nm");
                }
                eVar.G("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + Arrays.toString(strArr));
            }
            float optDouble = (float) jSONObject.optDouble("sr", 1.0d);
            float optDouble2 = ((float) jSONObject.optDouble("st")) / eVar.bn();
            if (layerType2 == LayerType.PreComp) {
                i4 = (int) (jSONObject.optInt("w") * eVar.dAZ());
                i5 = (int) (jSONObject.optInt("h") * eVar.dAZ());
            }
            float optLong3 = ((float) jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_IP)) / optDouble;
            float optLong4 = ((float) jSONObject.optLong("op")) / optDouble;
            ArrayList arrayList3 = new ArrayList();
            if (optLong3 > 0.0f) {
                arrayList3.add(new com.tb.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
            }
            float dAY = (optLong4 > 0.0f ? optLong4 : (float) eVar.dAY()) + 1.0f;
            arrayList3.add(new com.tb.airbnb.lottie.a.a(eVar, Float.valueOf(1.0f), Float.valueOf(1.0f), null, optLong3, Float.valueOf(dAY)));
            arrayList3.add(new com.tb.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, dAY, Float.valueOf(Float.MAX_VALUE)));
            com.tb.airbnb.lottie.model.a.b bVar = null;
            if (jSONObject.has(IXAdRequestInfo.MAX_TITLE_LENGTH)) {
                bVar = b.a.a(jSONObject.optJSONObject(IXAdRequestInfo.MAX_TITLE_LENGTH), eVar, false);
            }
            return new Layer(arrayList2, eVar, optString, optLong, layerType2, optLong2, optString2, arrayList, n, i, i2, i3, optDouble, optDouble2, i4, i5, jVar, kVar, arrayList3, matteType, bVar);
        }
    }
}
