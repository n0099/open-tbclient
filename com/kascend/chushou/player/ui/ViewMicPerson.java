package com.kascend.chushou.player.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.FanItem;
import com.kascend.chushou.constants.MicStatus;
import java.util.ArrayList;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class ViewMicPerson extends RelativeLayout implements View.OnClickListener, Animation.AnimationListener {
    private boolean a;
    private boolean b;
    private View c;
    private View d;
    private Context f;
    private TextView g;
    private TextView h;
    private boolean i;
    private long j;
    private String k;
    private int l;
    private Fragment oci;

    public ViewMicPerson(Context context) {
        super(context);
        this.a = false;
        this.b = false;
        this.i = false;
    }

    public ViewMicPerson(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.b = false;
        this.i = false;
    }

    public ViewMicPerson(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.b = false;
        this.i = false;
    }

    public void a(ArrayList<FanItem> arrayList, MicStatus micStatus, String str, boolean z, String str2) {
        if (!h.isEmpty(micStatus.micRoomId) && !micStatus.micRoomId.equals("0")) {
            this.k = micStatus.micRoomId;
            this.l = micStatus.micGameActionType;
        }
        this.i = z;
        if (this.b) {
            if (this.g != null) {
                this.g.setText(String.format(this.f.getString(a.i.mic_number2), Integer.valueOf(micStatus.onlineCount), Integer.valueOf(micStatus.capacity)));
            }
            if (this.h != null) {
                this.h.setText(String.format(this.f.getString(a.i.mic_play_together), Integer.valueOf(micStatus.onlineCount)));
            }
            if (this.oci != null && this.oci.isAdded()) {
                ((com.kascend.chushou.view.c.a) this.oci).a(arrayList);
            }
        }
    }

    public void a() {
        this.b = false;
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f, a.C0879a.commonres_activity_exit_right);
        loadAnimation.setAnimationListener(this);
        if (this.d != null) {
            this.d.startAnimation(loadAnimation);
            if (this.c != null) {
                this.c.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (!this.b) {
            setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    public void b() {
        this.f = null;
        this.b = false;
        this.a = false;
        this.oci = null;
        this.d = null;
        this.c = null;
        this.j = 0L;
    }
}
