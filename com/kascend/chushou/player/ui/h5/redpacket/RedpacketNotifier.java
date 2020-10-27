package com.kascend.chushou.player.ui.h5.redpacket;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.d.e;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes6.dex */
public class RedpacketNotifier extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f4178a;
    private TextView b;
    private int d;
    private boolean e;
    private FrescoThumbnailView pku;

    public RedpacketNotifier(@NonNull Context context) {
        this(context, null);
    }

    public RedpacketNotifier(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedpacketNotifier(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.RedpacketNotifier);
        this.d = obtainStyledAttributes.getResourceId(a.k.RedpacketNotifier_closeImg, a.e.pop_h5_close_black);
        obtainStyledAttributes.recycle();
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(a.h.view_videoplayer_redpacket_notifier, (ViewGroup) this, true);
        this.f4178a = (ImageView) findViewById(a.f.red_packet_close_view);
        this.f4178a.setOnClickListener(this);
        this.pku = (FrescoThumbnailView) findViewById(a.f.iv_redpacket);
        this.pku.setAnim(true);
        this.pku.DK(a.e.open_red_packet);
        this.pku.setOnClickListener(this);
        this.b = (TextView) findViewById(a.f.tv_redpacket_count);
    }

    public void a(a aVar, boolean z) {
        if (aVar != null) {
            int size = aVar.a().size();
            if (size == 0) {
                setVisibility(8);
            } else if (!this.e) {
                setVisibility(0);
                String f = aVar.f();
                if (this.pku != null) {
                    this.pku.j(f, a.e.open_red_packet, -1, -1);
                }
                a(size, z);
                this.e = true;
            }
        }
    }

    public void a(int i, boolean z) {
        this.f4178a.setImageResource(a.e.ic_room_ad_close_circle);
        if (i == 0) {
            setVisibility(8);
        } else if (i == 1) {
            setVisibility(0);
            this.b.setVisibility(8);
        } else {
            setVisibility(0);
            this.b.setVisibility(0);
            if (i > 1 && i < 99) {
                this.b.setText(String.valueOf(i));
            } else {
                this.b.setText(a.i.cs_red_dot_number);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.red_packet_close_view) {
            setVisibility(8);
        } else if (id == a.f.iv_redpacket) {
            if (!tv.chushou.zues.utils.a.eDX()) {
                g.RH(a.i.s_no_available_network);
            } else if (e.c(getContext(), null)) {
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(6, null));
            }
        }
    }
}
