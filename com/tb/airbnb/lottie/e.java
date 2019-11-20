package com.tb.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.RestrictTo;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.tb.airbnb.lottie.g;
import com.tb.airbnb.lottie.model.f;
import com.tb.airbnb.lottie.model.g;
import com.tb.airbnb.lottie.model.layer.Layer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    private final Map<String, List<Layer>> cR;
    private final Map<String, g> cS;
    private final Map<String, com.tb.airbnb.lottie.model.f> cT;
    private final SparseArrayCompat<com.tb.airbnb.lottie.model.g> cU;
    private final LongSparseArray<Layer> cV;
    private final List<Layer> cW;
    private final HashSet<String> cX;
    private final Rect cZ;
    private final long da;
    private final long dc;
    private final float dd;
    private final float de;
    private final int dg;
    private final int dh;
    private final int di;
    private final i krS;

    private e(Rect rect, long j, long j2, float f, float f2, int i, int i2, int i3) {
        this.cR = new HashMap();
        this.cS = new HashMap();
        this.cT = new HashMap();
        this.cU = new SparseArrayCompat<>();
        this.cV = new LongSparseArray<>();
        this.cW = new ArrayList();
        this.cX = new HashSet<>();
        this.krS = new i();
        this.cZ = rect;
        this.da = j;
        this.dc = j2;
        this.dd = f;
        this.de = f2;
        this.dg = i;
        this.dh = i2;
        this.di = i3;
        if (!com.tb.airbnb.lottie.c.f.a(this, 4, 5, 0)) {
            E("Lottie only supports bodymovin >= 4.5.0");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void E(String str) {
        Log.w("LOTTIE", str);
        this.cX.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.krS.setEnabled(z);
    }

    public i getPerformanceTracker() {
        return this.krS;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer el(long j) {
        return this.cV.get(j);
    }

    public Rect aS() {
        return this.cZ;
    }

    public long getDuration() {
        return (((float) (this.dc - this.da)) / this.dd) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMajorVersion() {
        return this.dg;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMinorVersion() {
        return this.dh;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int aT() {
        return this.di;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long aU() {
        return this.da;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long aV() {
        return this.dc;
    }

    public List<Layer> aW() {
        return this.cW;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> F(String str) {
        return this.cR.get(str);
    }

    public SparseArrayCompat<com.tb.airbnb.lottie.model.g> aX() {
        return this.cU;
    }

    public Map<String, com.tb.airbnb.lottie.model.f> aY() {
        return this.cT;
    }

    public Map<String, g> aZ() {
        return this.cS;
    }

    public float ba() {
        return (((float) getDuration()) * this.dd) / 1000.0f;
    }

    public float bb() {
        return this.de;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.cW) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static com.tb.airbnb.lottie.a a(Context context, String str, h hVar) {
            try {
                return a(context, context.getAssets().open(str), hVar);
            } catch (IOException e) {
                throw new IllegalStateException("Unable to find file " + str, e);
            }
        }

        public static com.tb.airbnb.lottie.a a(Context context, @RawRes int i, h hVar) {
            return a(context, context.getResources().openRawResource(i), hVar);
        }

        public static com.tb.airbnb.lottie.a a(Context context, InputStream inputStream, h hVar) {
            com.tb.airbnb.lottie.model.e eVar = new com.tb.airbnb.lottie.model.e(context.getResources(), hVar);
            eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[]{inputStream});
            return eVar;
        }

        public static com.tb.airbnb.lottie.a a(Resources resources, JSONObject jSONObject, h hVar) {
            com.tb.airbnb.lottie.model.h hVar2 = new com.tb.airbnb.lottie.model.h(resources, hVar);
            hVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[]{jSONObject});
            return hVar2;
        }

        @Nullable
        public static e b(Resources resources, InputStream inputStream) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        return b(resources, new JSONObject(sb.toString()));
                    }
                }
            } catch (IOException e) {
                Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to find file.", e));
                return null;
            } catch (JSONException e2) {
                Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to load JSON.", e2));
                return null;
            } finally {
                com.tb.airbnb.lottie.c.f.closeQuietly(inputStream);
            }
        }

        public static e b(Resources resources, JSONObject jSONObject) {
            float f = resources.getDisplayMetrics().density;
            int optInt = jSONObject.optInt("w", -1);
            int optInt2 = jSONObject.optInt("h", -1);
            Rect rect = (optInt == -1 || optInt2 == -1) ? null : new Rect(0, 0, (int) (optInt * f), (int) (optInt2 * f));
            String[] split = jSONObject.optString("v").split("[.]");
            e eVar = new e(rect, jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_IP, 0L), jSONObject.optLong("op", 0L), (float) jSONObject.optDouble("fr", 0.0d), f, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            JSONArray optJSONArray = jSONObject.optJSONArray("assets");
            b(optJSONArray, eVar);
            a(optJSONArray, eVar);
            b(jSONObject.optJSONObject("fonts"), eVar);
            c(jSONObject.optJSONArray("chars"), eVar);
            a(jSONObject, eVar);
            return eVar;
        }

        private static void a(JSONObject jSONObject, e eVar) {
            int i = 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("layers");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Layer C = Layer.a.C(optJSONArray.optJSONObject(i2), eVar);
                    if (C.cMe() == Layer.LayerType.Image) {
                        i++;
                    }
                    a(eVar.cW, eVar.cV, C);
                }
                if (i > 4) {
                    eVar.E("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                }
            }
        }

        private static void a(@Nullable JSONArray jSONArray, e eVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    JSONArray optJSONArray = optJSONObject.optJSONArray("layers");
                    if (optJSONArray != null) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        LongSparseArray longSparseArray = new LongSparseArray();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            Layer C = Layer.a.C(optJSONArray.optJSONObject(i2), eVar);
                            longSparseArray.put(C.getId(), C);
                            arrayList.add(C);
                        }
                        eVar.cR.put(optJSONObject.optString("id"), arrayList);
                    }
                }
            }
        }

        private static void b(@Nullable JSONArray jSONArray, e eVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject.has("p")) {
                        g cu = g.a.cu(optJSONObject);
                        eVar.cS.put(cu.getId(), cu);
                    }
                }
            }
        }

        private static void b(@Nullable JSONObject jSONObject, e eVar) {
            JSONArray optJSONArray;
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("list")) != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    com.tb.airbnb.lottie.model.f cw = f.a.cw(optJSONArray.optJSONObject(i));
                    eVar.cT.put(cw.getName(), cw);
                }
            }
        }

        private static void c(@Nullable JSONArray jSONArray, e eVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    com.tb.airbnb.lottie.model.g c = g.a.c(jSONArray.optJSONObject(i), eVar);
                    eVar.cU.put(c.hashCode(), c);
                }
            }
        }

        private static void a(List<Layer> list, LongSparseArray<Layer> longSparseArray, Layer layer) {
            list.add(layer);
            longSparseArray.put(layer.getId(), layer);
        }
    }
}
