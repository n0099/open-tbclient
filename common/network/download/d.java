package common.network.download;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int mEnd;
    private int mStart;
    private boolean nwL;
    private boolean nwM;
    private boolean nwN;

    public d(int i) {
        this.mEnd = 0;
        this.nwL = false;
        this.nwM = false;
        this.nwN = false;
        this.mStart = i;
        this.mEnd = (131072 + i) - 1;
    }

    public d(int i, boolean z) {
        this.mEnd = 0;
        this.nwL = false;
        this.nwM = false;
        this.nwN = false;
        this.mStart = i;
        this.nwL = z;
    }

    public d(int i, int i2) {
        this.mEnd = 0;
        this.nwL = false;
        this.nwM = false;
        this.nwN = false;
        this.mStart = i;
        this.mEnd = i2;
    }

    public int getStart() {
        return this.mStart;
    }

    public boolean isLast() {
        return this.nwL;
    }

    public void la(boolean z) {
        this.nwL = z;
    }

    public boolean aW() {
        return this.nwM;
    }

    public void fk(boolean z) {
        this.nwM = z;
    }

    public static d dX(JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("start");
        int i2 = jSONObject.getInt("end");
        boolean z = jSONObject.getBoolean("completed");
        if (i2 == 0) {
            d dVar = new d(i, true);
            dVar.fk(z);
            return dVar;
        }
        d dVar2 = new d(i, i2);
        dVar2.fk(z);
        return dVar2;
    }

    public JSONObject dJp() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start", this.mStart);
            jSONObject.put("completed", this.nwM);
            jSONObject.put("end", isLast() ? 0 : this.mEnd);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public String dJq() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mStart);
        objArr[1] = this.nwL ? "" : Integer.valueOf(this.mEnd);
        return String.format("bytes=%s-%s", objArr);
    }

    public void wM(boolean z) {
        this.nwN = z;
    }

    public boolean isFailed() {
        return this.nwN;
    }
}
