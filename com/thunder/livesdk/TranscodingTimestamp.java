package com.thunder.livesdk;
/* loaded from: classes4.dex */
public class TranscodingTimestamp {
    public int x = 0;
    public int y = 0;
    public String format = "";
    public String font = "";
    public int size = 0;
    public int color = 0;
    public int backgroundColor = -1;
    public float alpha = 1.0f;

    public String toString() {
        return "[TranscodingTimestamp: " + this.x + ", " + this.y + ", format " + this.format + ", font " + this.font + ", size " + this.size + ", color " + Integer.toHexString(this.color) + ", backgroundColor " + (this.backgroundColor == -1 ? "" : Integer.toHexString(this.backgroundColor)) + ", alpha " + this.alpha + "]";
    }
}
