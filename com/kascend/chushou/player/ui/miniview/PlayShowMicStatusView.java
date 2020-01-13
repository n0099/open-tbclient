package com.kascend.chushou.player.ui.miniview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.MicStatus;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class PlayShowMicStatusView extends RelativeLayout implements View.OnClickListener {
    private TextView a;
    private Context b;
    private boolean c;
    private String d;
    private int e;
    private long f;

    public PlayShowMicStatusView(Context context) {
        this(context, null);
    }

    public PlayShowMicStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayShowMicStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        this.f = 0L;
        a(context);
    }

    private void a(Context context) {
        this.b = context;
        this.a = (TextView) LayoutInflater.from(context).inflate(a.h.view_playshow_mic_status, (ViewGroup) this, true).findViewById(a.f.tv_mic_count);
        this.a.setOnClickListener(this);
    }

    public void a(String str, boolean z, MicStatus micStatus, String str2) {
        if (!h.isEmpty(micStatus.micRoomId) && !micStatus.micRoomId.equals("0")) {
            this.d = micStatus.micRoomId;
            this.e = micStatus.micGameActionType;
        }
        this.c = z;
        if (this.a != null) {
            this.a.setText(String.format(this.b.getString(a.i.mic_play_together), Integer.valueOf(micStatus.onlineCount)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
