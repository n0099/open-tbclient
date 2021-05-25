package d.a.n0.k2.q;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class e extends d {
    public int L0;
    public int M0;

    public e(Context context, View view) {
        super(context, view);
        p0(false);
        this.L0 = l.k(this.P) / 10;
    }

    public void A0(String str, String str2) {
        this.V = str2;
        O();
        P();
        s0(this.f56923f);
        this.G.setPlayer(this.u);
        this.C.setVisibility(8);
        this.v.setPlaceHolder(3);
        this.v.V(str, 10, false);
        this.I.setShareData(null);
    }

    @Override // d.a.n0.k2.q.d
    public void V(boolean z) {
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
        } else if (context instanceof BaseActivity) {
            ((BaseActivity) context).setSwipeBackEnabled(this.a0);
        }
        super.V(z);
        if (this.a0) {
            this.R.getLayoutParams().height = -1;
            return;
        }
        this.R.getLayoutParams().height = this.M0;
    }

    @Override // d.a.n0.k2.q.d
    public void e0() {
        this.u.setVolume(1.0f, 1.0f);
    }

    @Override // d.a.n0.k2.q.d
    public boolean f0(MotionEvent motionEvent) {
        return this.a0 || motionEvent.getX() > ((float) this.L0);
    }

    @Override // d.a.n0.k2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.u.getCyberPlayer() == null) {
            return;
        }
        CyberPlayer cyberPlayer = this.u.getCyberPlayer();
        this.U = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
        int videoHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.k(this.P));
        this.M0 = videoHeight;
        if (videoHeight > l.i(this.P)) {
            this.M0 = l.i(this.P);
        }
        this.R.getLayoutParams().height = this.M0;
        this.R.requestLayout();
    }

    @Override // d.a.n0.k2.q.d
    public void s0(int i2) {
        super.s0(i2);
        this.K.setVisibility(8);
        this.E.setVisibility(8);
    }
}
