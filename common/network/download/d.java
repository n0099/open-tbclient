package common.network.download;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int mEnd;
    private boolean mRW;
    private boolean mRX;
    private boolean mRY;
    private int mStart;

    public d(int i) {
        this.mEnd = 0;
        this.mRW = false;
        this.mRX = false;
        this.mRY = false;
        this.mStart = i;
        this.mEnd = (131072 + i) - 1;
    }

    public d(int i, boolean z) {
        this.mEnd = 0;
        this.mRW = false;
        this.mRX = false;
        this.mRY = false;
        this.mStart = i;
        this.mRW = z;
    }

    public d(int i, int i2) {
        this.mEnd = 0;
        this.mRW = false;
        this.mRX = false;
        this.mRY = false;
        this.mStart = i;
        this.mEnd = i2;
    }

    public int getStart() {
        return this.mStart;
    }

    public boolean isLast() {
        return this.mRW;
    }

    public void kG(boolean z) {
        this.mRW = z;
    }

    public boolean aW() {
        return this.mRX;
    }

    public void eX(boolean z) {
        this.mRX = z;
    }

    public static d dG(JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("start");
        int i2 = jSONObject.getInt("end");
        boolean z = jSONObject.getBoolean("completed");
        if (i2 == 0) {
            d dVar = new d(i, true);
            dVar.eX(z);
            return dVar;
        }
        d dVar2 = new d(i, i2);
        dVar2.eX(z);
        return dVar2;
    }

    public JSONObject dDx() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start", this.mStart);
            jSONObject.put("completed", this.mRX);
            jSONObject.put("end", isLast() ? 0 : this.mEnd);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public String dDy() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mStart);
        objArr[1] = this.mRW ? "" : Integer.valueOf(this.mEnd);
        return String.format("bytes=%s-%s", objArr);
    }

    public void wc(boolean z) {
        this.mRY = z;
    }

    public boolean isFailed() {
        return this.mRY;
    }
}
