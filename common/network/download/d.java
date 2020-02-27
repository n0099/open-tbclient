package common.network.download;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int mEnd;
    private int mStart;
    private boolean nuL;
    private boolean nuM;
    private boolean nuN;

    public d(int i) {
        this.mEnd = 0;
        this.nuL = false;
        this.nuM = false;
        this.nuN = false;
        this.mStart = i;
        this.mEnd = (131072 + i) - 1;
    }

    public d(int i, boolean z) {
        this.mEnd = 0;
        this.nuL = false;
        this.nuM = false;
        this.nuN = false;
        this.mStart = i;
        this.nuL = z;
    }

    public d(int i, int i2) {
        this.mEnd = 0;
        this.nuL = false;
        this.nuM = false;
        this.nuN = false;
        this.mStart = i;
        this.mEnd = i2;
    }

    public int getStart() {
        return this.mStart;
    }

    public boolean isLast() {
        return this.nuL;
    }

    public void kV(boolean z) {
        this.nuL = z;
    }

    public boolean aW() {
        return this.nuM;
    }

    public void fj(boolean z) {
        this.nuM = z;
    }

    public static d dX(JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("start");
        int i2 = jSONObject.getInt("end");
        boolean z = jSONObject.getBoolean("completed");
        if (i2 == 0) {
            d dVar = new d(i, true);
            dVar.fj(z);
            return dVar;
        }
        d dVar2 = new d(i, i2);
        dVar2.fj(z);
        return dVar2;
    }

    public JSONObject dIM() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start", this.mStart);
            jSONObject.put("completed", this.nuM);
            jSONObject.put("end", isLast() ? 0 : this.mEnd);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public String dIN() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mStart);
        objArr[1] = this.nuL ? "" : Integer.valueOf(this.mEnd);
        return String.format("bytes=%s-%s", objArr);
    }

    public void wE(boolean z) {
        this.nuN = z;
    }

    public boolean isFailed() {
        return this.nuN;
    }
}
