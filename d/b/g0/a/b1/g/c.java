package d.b.g0.a.b1.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.b.g0.a.a0.b.b {
    public static final boolean N = k.f45051a;
    public boolean A;
    public boolean B;
    public String C;
    public String D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public String n;
    public boolean o;
    public String p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public String u;
    public int v;
    public boolean w;
    public String x;
    public String y;
    public boolean z;

    public c() {
        super("video", "viewId");
        this.n = "";
        this.o = false;
        this.p = "";
        this.q = 0;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.u = "";
        this.v = 0;
        this.x = "";
        this.y = "";
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = "";
        this.D = "";
        this.H = false;
        this.I = true;
        this.J = -1;
        this.K = true;
        this.L = true;
        this.M = true;
    }

    public static c h(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.e(jSONObject, cVar);
            cVar2.n = jSONObject.optString("videoId", cVar.n);
            cVar2.s = jSONObject.optBoolean("autoplay", cVar.s);
            cVar2.o = jSONObject.optBoolean("muted", cVar.o);
            cVar2.u = jSONObject.optString("objectFit", cVar.u);
            cVar2.q = jSONObject.optInt("initialTime", cVar.q);
            cVar2.p = jSONObject.optString("poster", cVar.p);
            cVar2.v = jSONObject.optInt("position", cVar.v);
            cVar2.w = jSONObject.optBoolean("fullScreen", cVar.w);
            cVar2.x = k(jSONObject);
            cVar2.y = jSONObject.optString("danmuList", cVar.y);
            cVar2.z = jSONObject.optBoolean("enableDanmu", cVar.z);
            cVar2.A = jSONObject.optBoolean("danmuBtn", cVar.A);
            cVar2.t = jSONObject.optBoolean("loop", cVar.t);
            cVar2.B = jSONObject.optBoolean("controls", cVar.B);
            cVar2.C = l(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.C));
            cVar2.M = !d.b.g0.a.a2.b.m(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.C));
            cVar2.E = jSONObject.optBoolean("showPlayBtn", cVar.E);
            cVar2.F = jSONObject.optBoolean("showMuteBtn", cVar.F);
            cVar2.G = jSONObject.optBoolean("showCenterPlayBtn", cVar.G);
            cVar2.H = jSONObject.optBoolean("pageGesture", cVar.H);
            cVar2.I = jSONObject.optBoolean("showProgress", cVar.I);
            cVar2.J = jSONObject.optInt("direction", cVar.J);
            cVar2.K = jSONObject.optBoolean("showFullscreenBtn", cVar.K);
            cVar2.L = jSONObject.optBoolean("enableProgressGesture", cVar.L);
            cVar2.D = jSONObject.optString("sanId", cVar.D);
        }
        return cVar2;
    }

    public static String k(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("text", jSONObject.optString("text"));
            jSONObject2.putOpt("color", jSONObject.optString("color"));
            jSONObject2.putOpt("videoId", jSONObject.optString("videoId"));
        } catch (JSONException e2) {
            if (N) {
                e2.printStackTrace();
            }
        }
        return jSONObject2.toString();
    }

    public static String l(String str) {
        return (!d.b.g0.a.a2.b.m(str) || e.y() == null) ? str : d.b.g0.a.a2.b.p(str, e.y());
    }

    public boolean i() {
        return this.s;
    }

    @Override // d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.n);
    }

    public boolean j() {
        return !this.j;
    }

    @Override // d.b.g0.a.a0.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.n + "', mMute=" + this.o + ", mPoster='" + this.p + "', mInitialTime=" + this.q + ", duration=" + this.r + ", mAutoPlay=" + this.s + ", mLoop=" + this.t + ", mObjectFit='" + this.u + "', mPos=" + this.v + ", mFullScreen=" + this.w + ", mDanmu='" + this.x + "', mDanmuList='" + this.y + "', mEnableDanmu=" + this.z + ", mShowDanmuBtn=" + this.A + ", mShowControlPanel=" + this.B + ", mSrc='" + this.C + "', mSanId='" + this.D + "', mShowPlayBtn=" + this.E + ", mShowMuteBtn=" + this.F + ", mShowCenterPlayBtn=" + this.G + ", mPageGesture=" + this.H + ", mShowProgress=" + this.I + ", mDirection=" + this.J + ", mShowFullscreenBtn=" + this.K + ", mEnableProgressGesture=" + this.L + ", mIsRemoteFile=" + this.M + '}';
    }
}
