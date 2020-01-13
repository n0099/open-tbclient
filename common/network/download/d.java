package common.network.download;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int mEnd;
    private int mStart;
    private boolean nud;
    private boolean nue;
    private boolean nuf;

    public d(int i) {
        this.mEnd = 0;
        this.nud = false;
        this.nue = false;
        this.nuf = false;
        this.mStart = i;
        this.mEnd = (131072 + i) - 1;
    }

    public d(int i, boolean z) {
        this.mEnd = 0;
        this.nud = false;
        this.nue = false;
        this.nuf = false;
        this.mStart = i;
        this.nud = z;
    }

    public d(int i, int i2) {
        this.mEnd = 0;
        this.nud = false;
        this.nue = false;
        this.nuf = false;
        this.mStart = i;
        this.mEnd = i2;
    }

    public int getStart() {
        return this.mStart;
    }

    public boolean isLast() {
        return this.nud;
    }

    public void kR(boolean z) {
        this.nud = z;
    }

    public boolean aW() {
        return this.nue;
    }

    public void fc(boolean z) {
        this.nue = z;
    }

    public static d dX(JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("start");
        int i2 = jSONObject.getInt("end");
        boolean z = jSONObject.getBoolean("completed");
        if (i2 == 0) {
            d dVar = new d(i, true);
            dVar.fc(z);
            return dVar;
        }
        d dVar2 = new d(i, i2);
        dVar2.fc(z);
        return dVar2;
    }

    public JSONObject dHD() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start", this.mStart);
            jSONObject.put("completed", this.nue);
            jSONObject.put("end", isLast() ? 0 : this.mEnd);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public String dHE() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mStart);
        objArr[1] = this.nud ? "" : Integer.valueOf(this.mEnd);
        return String.format("bytes=%s-%s", objArr);
    }

    public void wB(boolean z) {
        this.nuf = z;
    }

    public boolean isFailed() {
        return this.nuf;
    }
}
