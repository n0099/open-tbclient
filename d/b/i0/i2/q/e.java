package d.b.i0.i2.q;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class e extends d {
    public int K0;
    public int L0;

    public e(Context context, View view) {
        super(context, view);
        p0(false);
        this.K0 = l.k(this.P) / 10;
    }

    @Override // d.b.i0.i2.q.d
    public void W(boolean z) {
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
        } else if (context instanceof BaseActivity) {
            ((BaseActivity) context).setSwipeBackEnabled(this.a0);
        }
        super.W(z);
        if (this.a0) {
            this.R.getLayoutParams().height = -1;
            return;
        }
        this.R.getLayoutParams().height = this.L0;
    }

    @Override // d.b.i0.i2.q.d
    public void g0() {
        this.u.setVolume(1.0f, 1.0f);
    }

    @Override // d.b.i0.i2.q.d
    public boolean h0(MotionEvent motionEvent) {
        return this.a0 || motionEvent.getX() > ((float) this.K0);
    }

    @Override // d.b.i0.i2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.u.getCyberPlayer() == null) {
            return;
        }
        CyberPlayer cyberPlayer = this.u.getCyberPlayer();
        this.U = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
        int videoHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.k(this.P));
        this.L0 = videoHeight;
        if (videoHeight > l.i(this.P)) {
            this.L0 = l.i(this.P);
        }
        this.R.getLayoutParams().height = this.L0;
        this.R.requestLayout();
    }

    @Override // d.b.i0.i2.q.d
    public void r0(int i) {
        super.r0(i);
        this.K.setVisibility(8);
        this.E.setVisibility(8);
    }

    public void z0(String str, String str2) {
        this.V = str2;
        Q();
        R();
        r0(this.f56187f);
        this.G.setPlayer(this.u);
        this.C.setVisibility(8);
        this.v.setPlaceHolder(3);
        this.v.W(str, 10, false);
        this.I.setShareData(null);
    }
}
