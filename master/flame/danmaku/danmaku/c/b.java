package master.flame.danmaku.danmaku.c;

import android.text.TextUtils;
import master.flame.danmaku.danmaku.model.android.e;
import master.flame.danmaku.danmaku.model.android.f;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public class b {
    public static boolean a(m mVar, d dVar, d dVar2, long j, long j2) {
        int type = dVar.getType();
        if (type == dVar2.getType() && !dVar.dLH()) {
            long dLQ = dVar2.dLQ() - dVar.dLQ();
            if (dLQ <= 0) {
                return true;
            }
            if (Math.abs(dLQ) >= j || dVar.isTimeOut() || dVar2.isTimeOut()) {
                return false;
            }
            if (type == 5 || type == 4) {
                return true;
            }
            return a(mVar, dVar, dVar2, j2) || a(mVar, dVar, dVar2, dVar.dLQ() + dVar.getDuration());
        }
        return false;
    }

    private static boolean a(m mVar, d dVar, d dVar2, long j) {
        float[] a = dVar.a(mVar, j);
        float[] a2 = dVar2.a(mVar, j);
        if (a == null || a2 == null) {
            return false;
        }
        return a(dVar.getType(), dVar2.getType(), a, a2);
    }

    private static boolean a(int i, int i2, float[] fArr, float[] fArr2) {
        if (i != i2) {
            return false;
        }
        if (i == 1) {
            return fArr2[0] < fArr[2];
        } else if (i == 6) {
            return fArr2[2] > fArr[0];
        } else {
            return false;
        }
    }

    public static e a(d dVar, m mVar, e eVar) {
        if (eVar == null) {
            eVar = new e();
        }
        eVar.e((int) Math.ceil(dVar.nFA), (int) Math.ceil(dVar.nFB), mVar.getDensityDpi(), false);
        f fVar = eVar.get();
        if (fVar != null) {
            ((master.flame.danmaku.danmaku.model.b) mVar).a(dVar, fVar.lFv, 0.0f, 0.0f, true);
            if (mVar.isHardwareAccelerated()) {
                fVar.O(mVar.getWidth(), mVar.getHeight(), mVar.dMe(), mVar.dMf());
            }
        }
        return eVar;
    }

    public static int eC(int i, int i2) {
        return i * i2 * 4;
    }

    public static final boolean b(d dVar, d dVar2) {
        if (dVar == dVar2) {
            return false;
        }
        if (dVar.text == dVar2.text) {
            return true;
        }
        return dVar.text != null && dVar.text.equals(dVar2.text);
    }

    public static final int a(d dVar, d dVar2) {
        if (dVar == dVar2) {
            return 0;
        }
        if (dVar != null) {
            if (dVar2 == null) {
                return 1;
            }
            long time = dVar.getTime() - dVar2.getTime();
            if (time > 0) {
                return 1;
            }
            if (time >= 0) {
                int type = dVar.getType() - dVar2.getType();
                if (type > 0) {
                    return 1;
                }
                if (type < 0 || dVar.text == null) {
                    return -1;
                }
                if (dVar2.text == null) {
                    return 1;
                }
                int compareTo = dVar.text.toString().compareTo(dVar2.text.toString());
                if (compareTo != 0) {
                    return compareTo;
                }
                int i = dVar.textColor - dVar2.textColor;
                if (i != 0) {
                    return i >= 0 ? 1 : -1;
                }
                int i2 = dVar.index - dVar2.index;
                if (i2 != 0) {
                    return i2 >= 0 ? 1 : -1;
                }
                return dVar.hashCode() - dVar.hashCode();
            }
            return -1;
        }
        return -1;
    }

    public static void a(d dVar, CharSequence charSequence) {
        dVar.text = charSequence;
        if (!TextUtils.isEmpty(charSequence) && charSequence.toString().contains("/n")) {
            String[] split = String.valueOf(dVar.text).split("/n", -1);
            if (split.length > 1) {
                dVar.nFv = split;
            }
        }
    }
}
