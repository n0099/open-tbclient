package d.a.l0.a.i1.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.l0.a.c0.b.b {
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public boolean E;
    public b F;
    public boolean G;
    public String n;
    public boolean o;
    public String p;
    public String q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public String w;
    public String x;
    public boolean y;
    public boolean z;

    static {
        boolean z = k.f43199a;
    }

    public c() {
        super("vrvideo", "viewId");
        this.n = "";
        this.o = false;
        this.p = "";
        this.q = "0";
        this.r = false;
        this.s = false;
        this.t = 0;
        this.v = true;
        this.w = "";
        this.x = "";
        this.y = true;
        this.z = true;
        this.A = true;
        this.B = true;
        this.C = -1;
        this.D = true;
        this.E = true;
        this.F = new b();
        this.G = true;
    }

    public static c h(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.e(jSONObject, cVar);
            cVar2.n = jSONObject.optString("videoId", cVar.n);
            cVar2.r = jSONObject.optBoolean("autoplay", cVar.r);
            cVar2.o = jSONObject.optBoolean("muted", cVar.o);
            cVar2.q = jSONObject.optString("initialTime", cVar.q);
            cVar2.p = jSONObject.optString("poster", cVar.p);
            cVar2.t = jSONObject.optInt("position", cVar.t);
            cVar2.u = jSONObject.optBoolean("fullScreen", cVar.u);
            cVar2.s = jSONObject.optBoolean("loop", cVar.s);
            cVar2.v = jSONObject.optBoolean("controls", cVar.v);
            cVar2.w = i(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.w));
            cVar2.E = !d.a.l0.a.k2.b.E(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.w));
            cVar2.y = jSONObject.optBoolean("showPlayBtn", cVar.y);
            cVar2.z = jSONObject.optBoolean("showMuteBtn", cVar.z);
            cVar2.A = jSONObject.optBoolean("showCenterPlayBtn", cVar.A);
            cVar2.B = jSONObject.optBoolean("showProgress", cVar.B);
            cVar2.D = jSONObject.optBoolean("showFullscreenBtn", cVar.D);
            cVar2.x = jSONObject.optString("sanId", cVar.x);
            cVar2.F = cVar2.F.a(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.G = jSONObject.optBoolean("showNoWifiTip", cVar.G);
        }
        return cVar2;
    }

    public static String i(String str) {
        return (!d.a.l0.a.k2.b.E(str) || e.i() == null) ? str : d.a.l0.a.k2.b.H(str, e.i());
    }

    @Override // d.a.l0.a.c0.b.b, d.a.l0.a.l1.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.n);
    }

    @Override // d.a.l0.a.c0.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.n + "', mMute=" + this.o + ", mPoster='" + this.p + "', mInitialTime=" + this.q + ", mAutoPlay=" + this.r + ", mShowNoWifiTip=" + this.G + ", mLoop=" + this.s + ", mPos=" + this.t + ", mFullScreen=" + this.u + ", mShowControlPanel=" + this.v + ", mSrc='" + this.w + "', mSanId='" + this.x + "', mShowPlayBtn=" + this.y + ", mShowMuteBtn=" + this.z + ", mShowCenterPlayBtn=" + this.A + ", mShowProgress=" + this.B + ", mDirection=" + this.C + ", mShowFullscreenBtn=" + this.D + ", mIsRemoteFile=" + this.E + ", mVrVideoMode=" + this.F.toString() + '}';
    }
}
